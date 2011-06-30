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
    public partial class Frm_groupChat : Form
    {
      
        #region 属性
        
        Frm_main parent_main;
        public int GroupId,hostId,grouphostId;
        string hostnickname;
        public ImageList ilFace,ilFacethums;
        public DBHelper db;
        SqlCommand cmd;
        SqlDataReader reader;
        TreeNode tn;
        List<int> memberIds;

        string str;

        #endregion


        #region 构造函数

        public Frm_groupChat(Frm_main f,int groupid)
        {
            InitializeComponent();
            this.parent_main = f;
            this.ilFace = f.ilFace;
            this.ilFacethums = f.ilFacethums;
            //lvGroupMembers.SmallImageList = ilFacethums;
            treeViewMembers.ImageList = ilFacethums;
            this.GroupId = groupid;
            this.hostnickname = f.userNickName;
            this.hostId = f.userID;
            this.db = f.db;
            this.memberIds=new List<int>();
        }
    #endregion
        
       #region 自定义方法
        public void getResource()
        {
            try
            {
                str = string.Format("select * from Groups where id='{0}'", GroupId);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str,db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    this.Text = hostnickname+"在房间 " +reader["groupname"].ToString().Trim()+" 中";
                    grouphostId = (int)reader["hostid"];
                    rtbGroupMessage.Text = "  "+reader["message"].ToString();

                }

                //str = string.Format("select users.id,username,faceid,");
            }
            catch (Exception ex)
            { MessageBox.Show("error:getresource"); }
            finally
            { db.con.Close(); }
        }

        public void getMember()
        {
            treeViewMembers.Nodes.Clear();
            memberIds.Clear();
            try
            {
                
                str = string.Format("select nickname,faceid,groupmemberid,userstateid from users,Groupmembers "+
                    "where groupid='{0}' and groupmemberid=users.id order by userstateid", GroupId);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {

                    if ((int)reader["userstateid"] == 1)
                    { tn = new TreeNode(reader["nickname"].ToString(), (int)reader["faceid"], (int)reader["faceid"]); }
                    else
                    {
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"] + 33, (int)reader["faceid"] + 33);
                    }
                    tn.Tag = (int)reader["groupmemberid"];
                    treeViewMembers.Nodes.Add(tn);
                    memberIds.Add((int)reader["groupmemberid"]);
                }
            }
            catch (Exception ex)
            { MessageBox.Show("error:getmember"); }
            finally
            { db.con.Close(); }
        }

        private void searchMessage()
        {
            try
            {
        
                str = string.Format("select message,messagetime,fromuserid,nickname from messages,users "+
                    "where touserid='{0}' and groupid='{1}' and messagestate=0 and messagetypeid=3 and fromuserid=users.id", hostId, GroupId);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    
                    rtbDisplay.Text = rtbDisplay.Text + reader["nickname"] + "  " + reader["messagetime"].ToString() + "\n  " + reader["message"].ToString() + "\n\n";

                }

                db.con.Close();
                str = string.Format("update messages set messagestate=1 "+
                    "where touserid='{0}' and groupid='{1}' and messagestate=0 and messagetypeid=3 ", hostId,GroupId);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();

            }
            catch (Exception ex)
            { MessageBox.Show("error:searchmessage"); }
            finally
            { db.con.Close(); }
        }

        //发送信息
        private void sendMessage(int memberid)
        {
            try
            {
                //MessageBox.Show("" + memberid);
                str = string.Format("insert into messages (fromuserid,touserid,message,messagetypeid,messagestate,messagetime,groupid) values ('{0}','{1}','{2}','{3}','{4}','{5}','{6}')",
                    hostId, //0 发送人ID
                    memberid, //1 收信人ID
                    rtbEdit.Text, //2 信息内容
                    3, //3 消息类型
                    0, //4 消息状态
                    DateTime.Now.ToString(), //5 发送时间
                    GroupId  //6 所属群
                    );
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
               
            }
            catch (Exception ex)
            { MessageBox.Show("error:sendMessage"); }
            finally
            { db.con.Close(); }
        }

        
    #endregion

        #region 控件事件方法

        private void Frm_groupChat_Load(object sender, EventArgs e)
        {
            getResource();
            getMember();
            timerSearchMessage.Enabled = true;
            timerReflash.Enabled = true;
           
        }

        private void btnSend_Click(object sender, EventArgs e)
        {
            int[] ids=memberIds.ToArray();
            for (int i = ids.Length - 1; i >= 0; i--)
            {if(hostId!=ids[i])
                sendMessage(ids[i]);
            }
          
            rtbDisplay.Text = rtbDisplay.Text + hostnickname + "  " + DateTime.Now.ToString() + "\n  " + rtbEdit.Text + "\n\n";
            rtbEdit.Clear();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
        #endregion

        private void timerReflash_Tick(object sender, EventArgs e)
        {
            getMember();
            getResource();
        }

        private void timerSearchMessage_Tick(object sender, EventArgs e)
        {
            searchMessage();
        }

        private void treeViewMembers_NodeMouseDoubleClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            int id = (int)e.Node.Tag;
            if (id == hostId)
                return;
           Frm_chat f = new Frm_chat(this, hostId, id);
                f.Show();
            
        }

        private void tsmiGroupSetup_Click(object sender, EventArgs e)
        {
            if (hostId == grouphostId)
            {
                Frm_groupManage f = new Frm_groupManage(this, GroupId, true);
                f.Show();
            }
            else
            {
                Frm_groupManage f = new Frm_groupManage(this, GroupId, false);
                f.Show();
            }
        }

        
    }
}