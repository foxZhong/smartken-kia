using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace myQQ
{
    public partial class Frm_Record : Form
    {
       
        #region 属性

        Frm_main parent;    //父窗口
        int hostID;         //主人ID
        public ImageList ilFace;
        SqlCommand cmd;
        SqlDataReader reader;
        DBHelper db;
        string str;
        TreeNode tn;

        #endregion

        #region 构造函数
        public Frm_Record(Frm_main f)
        {
            InitializeComponent();
            this.parent = f;   
            ilFace = f.ilFacethums;
            this.hostID = f.userID;  
            this.db = f.db;
            treeView1.ImageList = ilFace;
        }

    #endregion

        #region 自定义方法

        //获取全部消息
        private void getMessage()
        {
            try
            {
                str = string.Format("select nickname,fromuserid,message,messagetime from messages,users" +
                " where (fromuserid='{0}' or touserid={0}) and fromuserid=users.id ", hostID);

                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    rtbMessages.Text = rtbMessages.Text + reader["nickname"].ToString() + "  " + reader["messagetime"].ToString() + "\n  " + reader["message"].ToString() + "\n\n";
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("error:recordload");
            }
            finally
            { db.con.Close(); }
        }

        //获取窗口资源
        private void getResource()
        {
            try
            {
                //更新好友列表
                
                for (int i = treeView1.Nodes[2].Nodes.Count - 1; i >= 0; i--)
                {
                    treeView1.Nodes[2].Nodes[i].Nodes.Clear();
                }
                //for (int i = treeView1.Nodes[3].Nodes.Count - 1; i >= 0; i--)
                //{
                //    treeView1.Nodes[3].Nodes[i].Nodes.Clear();
                //}
                str = string.Format("select friendoption,friendid,nickname,faceid,userstateid from friends,users where hostid='{0}' and friendid=users.id order by friendoption,userstateid", hostID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);

                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    int group = (int)reader["friendoption"];
                    if ((int)reader["userstateid"] == 1)
                    {
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"], (int)reader["faceid"]);
                    }
                    else
                    {
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"] + 33, (int)reader["faceid"] + 33);

                    }
                    tn.Tag = (int)reader["friendid"];
                    treeView1.Nodes[2].Nodes[group].Nodes.Add(tn);
                }
                db.con.Close();

                //str = string.Format("select groupname,groupid from groups,groupmembers "+
                //    "where groupmemberid='{0}' and groupid=groups.id", hostID);
                //while (db.con.State != ConnectionState.Closed) ;
                //cmd = new SqlCommand(str, db.con);
                
                //db.con.Open();
                //reader = cmd.ExecuteReader();
                //while (reader.Read())
                //{
                //    tn = new TreeNode(reader["groupname"].ToString(), 72, 72);
                //    tn.Tag = (int)reader["groupid"];
                //    treeView1.Nodes[3].Nodes.Add(tn);
                //}
            }
            catch (Exception ex)
            {
                MessageBox.Show("error");
            }
            finally
            { db.con.Close(); }
        }
    #endregion

        #region 控件事件方法

        //构造窗口方法
        private void Frm_Record_Load(object sender, EventArgs e)
        {
            treeView1.Nodes.Add(new TreeNode("全部信息", 66, 66));
            treeView1.Nodes[0].Tag = 0;
            treeView1.Nodes.Add(new TreeNode("系统信息", 67, 67));
            treeView1.Nodes[1].Tag = 1;
            treeView1.Nodes.Add(new TreeNode("聊天信息", 68, 68));
            treeView1.Nodes[2].Tag = -1;
            //treeView1.Nodes.Add(new TreeNode("群信息",72, 72));
            //treeView1.Nodes[2].Tag = -1;
            treeView1.Nodes[2].Nodes.Add(new TreeNode("我的好友", 69, 69));
            treeView1.Nodes[2].Nodes[0].Tag = -1;
            treeView1.Nodes[2].Nodes.Add(new TreeNode("陌生人", 70, 70));
            treeView1.Nodes[2].Nodes[1].Tag = -1;
            treeView1.Nodes[2].Nodes.Add(new TreeNode("黑名单", 71, 71));
            treeView1.Nodes[2].Nodes[2].Tag = -1;
            //treeView1.ImageList = ilFace;
            getResource();
            getMessage();
        }


        //单击树节点方法
        private void treeView1_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            int tag = int.Parse(e.Node.Tag.ToString());
            if (tag == -1)
                return;
            else if (tag == 0)  //全部信息
                str = string.Format("select nickname,fromuserid,message,messagetime from messages,users" +
                    " where (fromuserid='{0}' or touserid={0}) and fromuserid=users.id ", hostID);
            else if (tag == 1)    //系统信息
                str = string.Format("select nickname,fromuserid,message,messagetime from messages,users" +
                   " where (fromuserid='{0}' or touserid={0}) and fromuserid=users.id and messagetypeid=2", hostID);
            else   //聊天信息
                str = string.Format("select nickname,fromuserid,message,messagetime from messages,users" +
                   " where ((fromuserid='{0}' or touserid={0})and (fromuserid='{1}' or touserid={1})) " +
                   "and fromuserid=users.id and messagetypeid=1", hostID, tag);
            //else
            //    str = string.Format("select nickname,fromuserid,message,messagetime from users,messages,groupmembers" +
            //        "where touserid='{0}' and fromuserid=users.id and messagetypeid=3",
            //        hostID, tag
            //        );
            rtbMessages.Clear();
            try
            {
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    rtbMessages.Text = rtbMessages.Text + reader["nickname"].ToString() + "  " + reader["messagetime"].ToString() + "\n  " + reader["message"].ToString() + "\n\n";
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("error");
            }
            finally
            { db.con.Close(); }
        }

        //单击刷新
        private void btnReflash_Click(object sender, EventArgs e)
        {
            for (int i = treeView1.Nodes[2].Nodes.Count - 1; i >= 0; i--)
                treeView1.Nodes[2].Nodes[i].Nodes.Clear();
            getResource();
        }


        //单击返回
        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
        #endregion
    }
}