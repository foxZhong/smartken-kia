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
    public partial class Frm_groupManage : Form
    {
        Frm_groupChat parent_groupchat;
        Frm_main parent_main;
        public ImageList ilFace,ilFaceThums;
        public int groupid, hostid, grouphostid;
        public DBHelper db;
        bool isenable;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;
        TreeNode tn;
        ListViewItem lvi;

        public Frm_groupManage(Frm_groupChat f,int groupid,bool isenable)
        {
            InitializeComponent();
            this.parent_groupchat = f;
            this.ilFace = f.ilFace;
            this.ilFaceThums = f.ilFacethums;
            this.groupid = groupid;
            this.hostid = f.hostId;
            this.db = f.db;
           
            setEnable(isenable);
        }

        public Frm_groupManage(Frm_main f,int groupid,bool isenable)
        {
            InitializeComponent();
            this.parent_main = f;
            this.ilFace = f.ilFace;
            this.ilFaceThums = f.ilFacethums;
            this.groupid = groupid;
            this.hostid = f.userID;
            this.db = f.db;
            //txtGroupId.Text = this.groupid.ToString();
            //txtGroupId.Enabled = false;
            //txtGroupHostNickName.ReadOnly = true;
            setEnable(isenable);
        }



        public void setEnable(bool isenable)
        {
            txtGroupName.Enabled = isenable;
            //txtGroupHostNickName.Enabled = isenable;
            rtbGroupMessage.Enabled = isenable;
            btnAddMember.Enabled = isenable;
            btnRemoveMember.Enabled = isenable;
            btnConfirm.Enabled = isenable;
        }


        public void getFriends()
        {
            try
            {

                for (int i = treeViewFriend.Nodes.Count - 1; i >= 0; i--)
                {

                    treeViewFriend.Nodes[i].Nodes.Clear();

                }
                //lvGroup.Items.Clear();
                //treeViewGroup.Nodes.Clear();

                str = string.Format("select friendoption,friendid,nickname,faceid,userstateid from friends,users where hostid='{0}' and friendid=users.id order by friendoption,userstateid", hostid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);

                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    int group = (int)reader["friendoption"];
                    if ((int)reader["userstateid"] == 1)
                    {
                        //si = new SbItem((string)reader["nickname"], (int)reader["faceid"]);
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"], (int)reader["faceid"]);
                    }
                    else
                    {
                        //si = new SbItem((string)reader["nickname"], (int)reader["faceid"] + 33);
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"] + 33, (int)reader["faceid"] + 33);

                    }
                    //si.Tag = (int)reader["friendid"];
                    tn.Tag = (int)reader["friendid"];
                    //sideBar1.Groups[group].Items.Add(si);
                    treeViewFriend.Nodes[group].Nodes.Add(tn);
                }
                db.con.Close();
            }
            catch (Exception ex)
            { MessageBox.Show("error:getfriend"); }
            finally
            {db.con.Close();}
        }

        public void getMembers()
        {
            try
            {
            treeViewMembers.Nodes.Clear();
             str = string.Format("select groupmemberid,nickname,faceid,userstateid from groupmembers,users "+
                 "where groupid='{0}' and groupmemberid=users.id order by userstateid", groupid);
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
               tn.Tag=(int)reader["groupmemberid"];
               treeViewMembers.Nodes.Add(tn);
            }
              }
            catch (Exception ex)
            { MessageBox.Show("error:getmember"); }
            finally
            {db.con.Close();}
 
        }

        public void addMember(int memberid)
        {
            try
            {
                str = string.Format("insert into groupmembers values ('{0}','{1}','{2}')",
                    groupid, //0
                    memberid,  //1
                    1   //2
                    ); 
                    while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();
                getFriends();
                getMembers();
            }
            catch (Exception ex)
            { MessageBox.Show("error:add"); }
            finally
            { db.con.Close(); }
        }

        public void removeMember(int memberid)
        {
            try
            {
                str = string.Format("delete from groupmembers where groupmemberid='{0}'",memberid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();
                getFriends();
                getMembers();
            }
            catch (Exception ex)
            { MessageBox.Show("error:remove"); }
            finally
            { db.con.Close(); }
 
        }

        private void Frm_groupManage_Load(object sender, EventArgs e)
        {
            treeViewFriend.ImageList = ilFaceThums;
            treeViewMembers.ImageList = ilFaceThums;
            treeViewFriend.Nodes.Add(new TreeNode("我的好友", 69, 69));
            treeViewFriend.Nodes[0].Tag = -1;
            treeViewFriend.Nodes.Add(new TreeNode("陌生人", 70, 70));
            treeViewFriend.Nodes[1].Tag = -1;
            treeViewFriend.Nodes.Add(new TreeNode("黑名单", 71, 71));
            treeViewFriend.Nodes[2].Tag = -1;

            txtGroupId.Text = this.groupid.ToString();
            txtGroupId.Enabled = false;
            txtGroupHostNickName.ReadOnly = true;
            getResource();
            getFriends();
            getMembers();
        }

        private void getResource()
        {
            try
            {
                str = string.Format("select hostid,groupname,nickname,message,faceid from Groups,users " +
                    "where groups.id='{0}' and hostid=users.id", groupid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    grouphostid = (int)reader["hostid"];
                    txtGroupName.Text = reader["groupname"].ToString();
                    txtGroupHostNickName.Text = reader["nickname"].ToString();
                    rtbGroupMessage.Text = reader["message"].ToString();
                    picGroupHostFace.Image = ilFace.Images[(int)reader["faceid"]];
                }

            }
            catch (Exception ex)
            { MessageBox.Show("error:load"); }
            finally
            {
                db.con.Close();
            }
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("是否保存修改？", "提示", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
            if (result == DialogResult.OK)
            {
                try
                {
                    str = string.Format("update groups set groupname='{0}',message='{1}' where id='{2}'",
                        txtGroupName.Text, rtbGroupMessage.Text,groupid);
                    while (db.con.State != ConnectionState.Closed) ;
                    cmd = new SqlCommand(str, db.con);
                    db.con.Open();
                    cmd.ExecuteNonQuery();
                }
                catch (Exception ex)
                { MessageBox.Show("error:confirm"); }
                finally
                { db.con.Close(); }
                this.Dispose();
            }
            else
                this.Dispose();
            
        }

        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnAddMember_Click(object sender, EventArgs e)
        {
            if (treeViewFriend.SelectedNode != null)
            {
                //MessageBox.Show("" + (int)treeViewFriend.SelectedNode.Tag);
                int id=(int)treeViewFriend.SelectedNode.Tag;
                if (id!=-1)
                    addMember(id);
               
            }
            
        }

        private void btnRemoveMember_Click(object sender, EventArgs e)
        {
            if (treeViewMembers.SelectedNode != null)
                
                removeMember((int)treeViewMembers.SelectedNode.Tag);
            else
                return;
        }

        private void btnGroupHostInfo_Click(object sender, EventArgs e)
        {
            Frm_info f = new Frm_info(this,grouphostid, false);
            f.Show();
        }
    }
}