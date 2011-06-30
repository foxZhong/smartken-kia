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
       
        #region ����

        Frm_main parent;    //������
        int hostID;         //����ID
        public ImageList ilFace;
        SqlCommand cmd;
        SqlDataReader reader;
        DBHelper db;
        string str;
        TreeNode tn;

        #endregion

        #region ���캯��
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

        #region �Զ��巽��

        //��ȡȫ����Ϣ
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

        //��ȡ������Դ
        private void getResource()
        {
            try
            {
                //���º����б�
                
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

        #region �ؼ��¼�����

        //���촰�ڷ���
        private void Frm_Record_Load(object sender, EventArgs e)
        {
            treeView1.Nodes.Add(new TreeNode("ȫ����Ϣ", 66, 66));
            treeView1.Nodes[0].Tag = 0;
            treeView1.Nodes.Add(new TreeNode("ϵͳ��Ϣ", 67, 67));
            treeView1.Nodes[1].Tag = 1;
            treeView1.Nodes.Add(new TreeNode("������Ϣ", 68, 68));
            treeView1.Nodes[2].Tag = -1;
            //treeView1.Nodes.Add(new TreeNode("Ⱥ��Ϣ",72, 72));
            //treeView1.Nodes[2].Tag = -1;
            treeView1.Nodes[2].Nodes.Add(new TreeNode("�ҵĺ���", 69, 69));
            treeView1.Nodes[2].Nodes[0].Tag = -1;
            treeView1.Nodes[2].Nodes.Add(new TreeNode("İ����", 70, 70));
            treeView1.Nodes[2].Nodes[1].Tag = -1;
            treeView1.Nodes[2].Nodes.Add(new TreeNode("������", 71, 71));
            treeView1.Nodes[2].Nodes[2].Tag = -1;
            //treeView1.ImageList = ilFace;
            getResource();
            getMessage();
        }


        //�������ڵ㷽��
        private void treeView1_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            int tag = int.Parse(e.Node.Tag.ToString());
            if (tag == -1)
                return;
            else if (tag == 0)  //ȫ����Ϣ
                str = string.Format("select nickname,fromuserid,message,messagetime from messages,users" +
                    " where (fromuserid='{0}' or touserid={0}) and fromuserid=users.id ", hostID);
            else if (tag == 1)    //ϵͳ��Ϣ
                str = string.Format("select nickname,fromuserid,message,messagetime from messages,users" +
                   " where (fromuserid='{0}' or touserid={0}) and fromuserid=users.id and messagetypeid=2", hostID);
            else   //������Ϣ
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

        //����ˢ��
        private void btnReflash_Click(object sender, EventArgs e)
        {
            for (int i = treeView1.Nodes[2].Nodes.Count - 1; i >= 0; i--)
                treeView1.Nodes[2].Nodes[i].Nodes.Clear();
            getResource();
        }


        //��������
        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
        #endregion
    }
}