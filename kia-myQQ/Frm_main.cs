using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using Aptech.UI;
using System.Media;

namespace myQQ
{
    public partial class Frm_main : Form
    {
        Frm_login parent;
        public int userID;
        public string userNickName;
        string str;
        SqlDataReader reader;
        SqlCommand cmd;
        public DBHelper db;
        public ImageList ilFace,ilFacethums;
        SoundPlayer soundFolder,soundMsg,soundSystem;
        SbItem si;
        TreeNode tn;
        //ListViewItem lvi;
        bool isPlay;

        
        public Frm_main(Frm_login f)
        {
            InitializeComponent();
            this.parent = f;
            userID = f.hostID;
            this.ilFace = f.getImageList();
            this.ilFacethums = f.getImageListThums();
            this.sideBar1.ImageList = this.ilFace;
            this.treeView1.ImageList = f.getImageListThums();
            this.treeViewGroup.ImageList = f.getImageListThums();
            //this.lvGroup.LargeImageList = this.ilFace;
            //this.lvGroup.SmallImageList = this.ilFacethums;
            this.db = f.db;
            cboState.Text = f.hostStateID==1?"在线":"隐身";
            sideBar1.AddGroup("我的好友");
            sideBar1.AddGroup("陌生人");
            sideBar1.AddGroup("黑名单");
            //sideBar1.AddGroup("群聊室");

            treeView1.Nodes.Add(new TreeNode("我的好友", 69, 69));
            treeView1.Nodes[0].Tag = -1;
            treeView1.Nodes.Add(new TreeNode("陌生人", 70,70));
            treeView1.Nodes[1].Tag = -1;
            treeView1.Nodes.Add(new TreeNode("黑名单", 71, 71));
            treeView1.Nodes[2].Tag = -1;
            this.soundFolder = new SoundPlayer("folder.wav");
            this.soundMsg = new SoundPlayer("msg.wav");
            this.soundSystem = new SoundPlayer("system.wav");
            this.isPlay = true;
            picBusy.Hide();
           // this.pictureBox1
        }

        private void Frm_main_Load(object sender, EventArgs e)
        {
            getStates();
            getResource();
           
           // SearchMessage();
            tsbNewMessage.Image = ilTools.Images[2];
            tsbNewChatMessage.Image = ilTools.Images[0];
            tsbNewGroupMessage.Image = ilTools.Images[3];
            timerReflash.Enabled = true;
            //soundSystem.Play();
            
           
        }

        public void getStates()
        {
            try
            {
                str = string.Format("select userstate from userstate ",
                               cboState.Text);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    cboState.Items.Add(reader["userstate"].ToString());
                }
            }
            catch (Exception ex)
            { MessageBox.Show("error:getStates"); }
            finally
            { db.con.Close(); }
        }

        public void getResource()
        { 
            string userstate = "";
            try
            {
               
                str = string.Format("select faceid,nickname,userstateid,mood,userstate from users,userstate "+
                    "where users.id='{0}' and userstateid=userstate.id", 
                    userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    userNickName = reader["nickname"].ToString();
                    llbHostName.Text = string.Format("{0}\n({1})", reader["nickname"].ToString(), userID);
                    txtMood.Text = reader["mood"].ToString();
                    userstate = reader["userstate"].ToString();
                    if ((int)reader["userstateid"] == 1)
                    { pboFace.BackgroundImage = ilFace.Images[(int)reader["faceid"]]; picBusy.Hide(); }
                    else if ((int)reader["userstateid"] == 2)
                    { pboFace.BackgroundImage = ilFace.Images[(int)reader["faceid"]]; picBusy.Show(); }
                    else
                    { pboFace.BackgroundImage = ilFace.Images[(int)reader["faceid"] + 33]; picBusy.Hide(); }
                    //cboState.Text = reader["userstate"].ToString();
                }
                db.con.Close();
              
                //更新好友列表
                for (int i = sideBar1.Groups.Count -1; i >= 0; i--)
                {
                    sideBar1.Groups[i].Items.Clear();
                    treeView1.Nodes[i].Nodes.Clear();
                    
                }
                //lvGroup.Items.Clear();
                treeViewGroup.Nodes.Clear();

                str = string.Format("select friendoption,friendid,nickname,faceid,userstateid from friends,users "+
                    "where hostid='{0}' and friendid=users.id order by friendoption,userstateid", userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    int group = (int)reader["friendoption"];
                    if ((int)reader["userstateid"] == 1)
                    {
                        si = new SbItem((string)reader["nickname"], (int)reader["faceid"]);
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"], (int)reader["faceid"]);
                    }
                    else
                    {
                        si = new SbItem((string)reader["nickname"], (int)reader["faceid"] + 33);
                        tn = new TreeNode((string)reader["nickname"], (int)reader["faceid"]+33, (int)reader["faceid"]+33);

                    } 
                    si.Tag = (int)reader["friendid"];
                    tn.Tag = (int)reader["friendid"];
                    sideBar1.Groups[group].Items.Add(si);
                    treeView1.Nodes[group].Nodes.Add(tn);
                }
                db.con.Close();

                //str = string.Format("select groupname,groups.id from groups,groupmembers " +
                //    "where groupmemberid='{0}' and groupid=groups.id order by groupid", userID);
                //  while (db.con.State != ConnectionState.Closed) ;
                //cmd = new SqlCommand(str, db.con);
                
                //db.con.Open();
                //reader = cmd.ExecuteReader();
                //while (reader.Read())
                //{
                //    tn = new TreeNode(reader["groupname"].ToString(), 72, 72);
                //    tn.Tag = (int)reader["id"];
                //    treeViewGroup.Nodes.Add(tn);
                //}

                //db.con.Close();

                //for(int i=treeViewGroup.Nodes.Count-1;i>=0;i--)
                int groupid=0,groupcount=-1;
                str = string.Format("select groupid,groupname,groupmemberid,faceid,nickname,userstateid from groups,groupmembers,users  " +
                       "where groupmemberid=users.id and groupid=groups.id order by groupid,userstateid");
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    //groupid = (int)reader["groupid"];
                    if ((int)reader["groupid"] != groupid)
                    {
                       
                           tn = new TreeNode(reader["groupname"].ToString(), 72, 72);
                           tn.Tag = (int)reader["groupid"];
                           treeViewGroup.Nodes.Add(tn);
                           groupcount++;
                    }
                    if ((int)reader["userstateid"] == 1)
                    tn = new TreeNode(reader["nickname"].ToString(), (int)reader["faceid"], (int)reader["faceid"]);
                    else
                    tn = new TreeNode(reader["nickname"].ToString(), (int)reader["faceid"]+33, (int)reader["faceid"]+33);
                    tn.Tag = (int)reader["groupmemberid"];
                    treeViewGroup.Nodes[groupcount].Nodes.Add(tn);
                    groupid = (int)reader["groupid"];
                }
                db.con.Close();
                for(int i=treeViewGroup.Nodes.Count-1;i>=0;i--)
                {
                    bool found=false;
                    for (int j = treeViewGroup.Nodes[i].Nodes.Count - 1; j >= 0; j--)
                    {
                        if ((int)treeViewGroup.Nodes[i].Nodes[j].Tag == userID)
                            found = true;
                    }
                    if (!found)
                        treeViewGroup.Nodes.RemoveAt(i);
                }    
  
            }
            catch (Exception ex)
            {
                MessageBox.Show("errorr:getResource");
            }
            finally
            {
                db.con.Close();
                cboState.Text = userstate;
            }
            
        }

        private void tsmiAddfriend_Click(object sender, EventArgs e)
        {
            Frm_addFriend f = new Frm_addFriend(this);
            f.Show();
        }

        private void tsmiLargeview_Click(object sender, EventArgs e)
        {
            sideBar1.View = SbView.LargeIcon;
        }

        private void tsmiSmallview_Click(object sender, EventArgs e)
        {
            sideBar1.View = SbView.SmallIcon;
        }

        private void sideBar1_DoubleClick(object sender, EventArgs e)
        {
            
        }

        private void sideBar1_ItemDoubleClick(SbItemEventArgs e)
        {
           
            int freindID = (int)e.Item.Tag;
            Frm_chat f = new Frm_chat(this, this.userID, freindID);
            f.Show();
        }

        private void tsmiFriendInfo_Click(object sender, EventArgs e)
        {
            try
            {
                Frm_info f = new Frm_info(this, (int)sideBar1.SeletedItem.Tag, false);
                    f.Show();
               
            }
            catch (Exception ex)
            {}
        }

        private void tsmiTreeinfo_Click(object sender, EventArgs e)
        {
            try
            {
                if ((int)treeView1.SelectedNode.Tag > 10000)
                {
                    Frm_info f = new Frm_info(this, (int)treeView1.SelectedNode.Tag, false);
                    f.Show();
                }
            }
            catch (Exception ex)
            { }
        }
       
        private void llbHostName_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            Frm_info f = new Frm_info(this, userID, true);
            f.Show();
        }

        private void Frm_main_FormClosed(object sender, FormClosedEventArgs e)
        {
            try
            {
                while (db.con.State != ConnectionState.Closed) ;
                str = string.Format("update users set userstateid='{0}' where id='{1}'",
                          4, userID);
                cmd = new SqlCommand(str, db.con);
                while (db.con.State != ConnectionState.Closed) ;
                db.con.Open();
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
            Application.Exit();
        }

        private int getUserStateID()
        {
            int stateid = 0;

            try
            {
                //MessageBox.Show(cboState.Text);
                str = string.Format("select id from userstate where userstate='{0}'",
                            cboState.Text.Trim());
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    stateid = (int)reader["id"];
                }
               
            }
            catch (Exception ex)
            { MessageBox.Show("error:getuserstateid"); }
            finally
            { db.con.Close(); }
            return stateid;
        }

        private void setUserState()
        {
            try
            {
                int stateid = getUserStateID();
                str = string.Format("update users set userstateid='{0}' where id='{1}'",
                           stateid, userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();

                //str = string.Format("select userstate from userstate where id='{0}'",stateid);
                //str = string.Format("select userstate from userstate where id='{0}'", stateid);
                //while (db.con.State != ConnectionState.Closed) ;
                //cmd = new SqlCommand(str, db.con);
                //db.con.Open();
                //reader = cmd.ExecuteReader();
                //while (reader.Read())
                //{
                //    cboState.Text = reader["userstate"].ToString();
                //}
            }
            catch (Exception ex)
            { MessageBox.Show("error:setuserstate"); }
            finally
            { db.con.Close(); }
        }

       

        private void cboState_SelectedIndexChanged(object sender, EventArgs e)
        {
            setUserState();
        }


        private void SearchMessage()
        {
            try
            {
                str = string.Format("select count(*) from messages where touserid='{0}' and messagestate=0 and messagetypeid=2", userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                if (((int)cmd.ExecuteScalar()) > 0)
                {
                    timerLighting.Enabled = true;
                    if (isPlay)
                        soundSystem.Play();
                }
                else
                {
                    timerLighting.Enabled = false;
                    tsbNewMessage.Image = ilTools.Images[2];
                }
                db.con.Close();

                str = string.Format("select count(*) from messages where touserid='{0}' and messagestate=0 and messagetypeid=1", userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                if (((int)cmd.ExecuteScalar()) > 0)
                {
                    timerFaceLighting.Enabled = true;
                    if (isPlay)
                        soundMsg.Play();
                }
                else
                { timerFaceLighting.Enabled = false; 
                    tsbNewChatMessage.Image = ilTools.Images[1]; }

                    db.con.Close();

                    str = string.Format("select count(*) from messages where touserid='{0}' and messagestate=0 and messagetypeid=3", userID);
                    while (db.con.State != ConnectionState.Closed) ;
                    cmd = new SqlCommand(str, db.con);
                    db.con.Open();
                    if (((int)cmd.ExecuteScalar()) > 0)
                    {
                        timerGroupLighting.Enabled=true;
                        if (isPlay)
                            soundMsg.Play();
                    }
                    else
                    {
                        timerGroupLighting.Enabled = false;
                        tsbNewGroupMessage.Image = ilTools.Images[3];
                    }
            }
            catch (Exception ex)
            { MessageBox.Show("errorw"); }
            finally
            { db.con.Close(); }
        }

        private void timerReflash_Tick(object sender, EventArgs e)
        {
            getResource();
            SearchMessage();
        }

        private void timerLighting_Tick(object sender, EventArgs e)
        {
            if (tsbNewMessage.Image == null)
                tsbNewMessage.Image = ilTools.Images[2];
            else
                tsbNewMessage.Image = null;
        }

        private void tsbNewMessage_Click(object sender, EventArgs e)
        {

            try
            {
                //MessageBox.Show("" + messagetypeid);
                int id = 0, fromuserid = 0, groupid = 0;
                string message = "";
                str = string.Format("select top 1 id,message,fromuserid,groupid from messages where touserid='{0}' and messagestate=0 and messagetypeid=2 order by id", userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    id = (int)reader["id"];
                    fromuserid = (int)reader["fromuserid"];
                    groupid = (int)reader["groupid"];
                    message = reader["message"].ToString();
                    //MessageBox.Show(id.ToString());
                    db.con.Close();

                }
                else
                { db.con.Close(); return; }
                
                    new Frm_systemMessage(this, id, message, fromuserid).Show();
                str = string.Format("update messages set messagestate=1 where id='{0}'", id);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();



            }
            catch (Exception ex)
            { MessageBox.Show("error:getmessage"); }
            finally
            {
                db.con.Close();
            }
            
        }

        private void getMessage(int messagetypeid)
        {
            try
            {
                //MessageBox.Show("" + messagetypeid);
                int id = 0,fromuserid=0,groupid=0;
                string message = "";
                str = string.Format("select top 1 id,message,fromuserid,groupid from messages where touserid='{0}' and messagestate=0 and messagetypeid='{1}' order by id", userID,messagetypeid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    id = (int)reader["id"];
                    fromuserid = (int)reader["fromuserid"];
                    groupid = (int)reader["groupid"];
                    message = reader["message"].ToString();
                    //MessageBox.Show(id.ToString());
                    db.con.Close();
                    
                }
                else
                { db.con.Close(); return; }
                if (messagetypeid == 1)
                    new Frm_chat(this, userID, fromuserid).Show();
                else if (messagetypeid == 2)
                    new Frm_systemMessage(this, id, message, fromuserid).Show();
                else if (messagetypeid == 3)
                    new Frm_groupChat(this, groupid).Show();
                //str = string.Format("update messages set messagestate=1 where id='{0}'", id);
                //while (db.con.State != ConnectionState.Closed) ;
                //cmd = new SqlCommand(str, db.con);
                //db.con.Open();
                //cmd.ExecuteNonQuery();
                //db.con.Close();
                


            }
            catch (Exception ex)
            { MessageBox.Show("error:getmessage"); }
            finally
            { db.con.Close();
            }
        }

        private void timerFaceLighting_Tick(object sender, EventArgs e)
        {
            try
            {
                
                int fromuserid;
                str = string.Format("select fromuserid from messages where touserid='{0}' and messagestate=0 and messagetypeid=1", userID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    //MessageBox.Show(reader["fromuserid"].ToString());
                    fromuserid=(int)reader["fromuserid"];
                    for (int i = sideBar1.Groups.Count-2; i >= 0; i--)
                        for (int j = sideBar1.Groups[i].Items.Count-1; j >= 0; j--)
                        if((int)sideBar1.Groups[i].Items[j].Tag==fromuserid)
                        {
                            if (sideBar1.Groups[i].Items[j].ImageIndex <33)
                            {sideBar1.Groups[i].Items[j].ImageIndex += 33;
                             treeView1.Nodes[i].Nodes[j].ImageIndex+=33;}
                            else
                            {   sideBar1.Groups[i].Items[j].ImageIndex -= 33;
                            treeView1.Nodes[i].Nodes[j].ImageIndex -= 33;}
                            break;
                        }


                }
                if (tsbNewChatMessage.Image == null)
                    tsbNewChatMessage.Image = ilTools.Images[1];
                else
                    tsbNewChatMessage.Image = null;

            }
            catch (Exception ex)
            { MessageBox.Show("error5");
        }
            finally
            { db.con.Close();
            sideBar1.Validate();
        }
        }

        private void picMenu_Click(object sender, EventArgs e)
        {
            Frm_info f = new Frm_info(this, userID, true);
            f.Show();
        }

       

        private void tsmiMoto_Click(object sender, EventArgs e)
        {
            try
            {
                //MessageBox.Show(sideBar1.SeletedItem.Tag.ToString());
                int friendoption=int.Parse(((ToolStripMenuItem)sender).Tag.ToString());
                int friendid=int.Parse(sideBar1.SeletedItem.Tag.ToString());
             
               // MessageBox.Show(" "+friendoption+" "+friendid);
                str = string.Format("update friends set friendoption='{0}' where hostid='{1}' and friendid='{2}'",
                   friendoption, //0
                   userID,//1
                friendid ); //2
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                
            }
            catch (Exception ex)
            { MessageBox.Show("error6"); }
            finally
            { db.con.Close(); }
        }

        private void tsmiTreeMoto_Click(object sender, EventArgs e)
        {
            try
            {
                //MessageBox.Show(sideBar1.SeletedItem.Tag.ToString());
                int friendoption = int.Parse(((ToolStripMenuItem)sender).Tag.ToString());
                int friendid = int.Parse(treeView1.SelectedNode.Tag.ToString());
                // MessageBox.Show(" "+friendoption+" "+friendid);
                str = string.Format("update friends set friendoption='{0}' where hostid='{1}' and friendid='{2}'",
                   friendoption, //0
                   userID,//1
                friendid); //2
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();

            }
            catch (Exception ex)
            {
                //MessageBox.Show("error:tsmiTreeMoto"); 
            }
            finally
            { db.con.Close(); }
        }

        private void tsmiRemove_Click(object sender, EventArgs e)
        {
            try
            {
                int friendid = int.Parse(sideBar1.SeletedItem.Tag.ToString());
                str = string.Format("delete from friends where hostid='{0}' and friendid='{1}'",
                  userID,//0
               friendid); //1
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            { MessageBox.Show("error7"); }
            finally
            { db.con.Close(); }
        }

        private void tsmiTreeRemove_Click(object sender, EventArgs e)
        {
            try
            {
                int friendid = int.Parse(treeView1.SelectedNode.Tag.ToString());
                str = string.Format("delete from friends where hostid='{0}' and friendid='{1}'",
                  userID,//0
               friendid); //1
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
            }
            catch (Exception ex)
            { MessageBox.Show("error7"); }
            finally
            { db.con.Close(); }
        }



        private void tsmiSetReflash_Click(object sender, EventArgs e)
        {
            timerReflash.Interval = int.Parse(((ToolStripMenuItem)sender).Tag.ToString());
        }

        private void tsbNewChatMessage_Click(object sender, EventArgs e)
        {
            getMessage(1);
        }

        public SideBar getSideBar()
        {
            return this.sideBar1;
        }

        //private void getNewChatMessage()
        //{
        //    try
        //    {
        //        int id = 0, fromuserid = 0;
        //        string message = "";
        //        str = string.Format("select top 1 id,message,fromuserid from messages where touserid='{0}' and messagestate=0 and messagetypeid=1 order by id", userID);
        //        while (db.con.State != ConnectionState.Closed) ;
        //        cmd = new SqlCommand(str, db.con);
        //        db.con.Open();
        //        reader = cmd.ExecuteReader();
        //        if (reader.Read())
        //        {
        //            id = (int)reader["id"];
        //            fromuserid = (int)reader["fromuserid"];
        //            message = reader["message"].ToString();
        //            //MessageBox.Show(id.ToString());
        //            db.con.Close();
        //        }
        //        else
        //        { db.con.Close(); return; }
        //        str = string.Format("update messages set messagestate=1 where id='{0}'", id);
        //        while (db.con.State != ConnectionState.Closed) ;
        //        cmd = new SqlCommand(str, db.con);
        //        db.con.Open();
        //        cmd.ExecuteNonQuery();
        //        db.con.Close();
        //        new Frm_chat(this, userID, fromuserid).Show();


        //    }
        //    catch (Exception ex)
        //    { MessageBox.Show("error3"); }
        //    finally
        //    {
        //        db.con.Close();
        //    }
        //}

        private void tsbRecord_Click(object sender, EventArgs e)
        {
            Frm_Record f = new Frm_Record(this);
            f.Show();
        }

        private void treeView1_NodeMouseDoubleClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            int freindID = (int)e.Node.Tag;
            if (freindID < 10000)
                return;
            Frm_chat f = new Frm_chat(this, this.userID, freindID);
            f.Show();
        }

        private void tsmiPlaySound_Click(object sender, EventArgs e)
        {
            isPlay = true;
        }

        private void tsmiStopSound_Click(object sender, EventArgs e)
        {
            isPlay = false;
        }

        private void treeViewGroup_NodeMouseDoubleClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            int id = (int)e.Node.Tag;
            if (id < 10000)
            {
                Frm_groupChat f = new Frm_groupChat(this, id);
                f.Show();
            }
            else if (id < 100000&&id!=userID)
            {
                Frm_chat f = new Frm_chat(this, userID, id);
                f.Show();
            }
        }

        private void tsbNewGroupMessage_Click(object sender, EventArgs e)
        {
            getMessage(3);
        }

        private void timerGroupLighting_Tick(object sender, EventArgs e)
        {
            if (tsbNewGroupMessage.Image == null)
                tsbNewGroupMessage.Image = ilTools.Images[3];
            else
                tsbNewGroupMessage.Image = null;
        }

        private void tsmiCreateNewGroup_Click(object sender, EventArgs e)
        {
            Frm_addGroup f = new Frm_addGroup(this, userID);
            f.Show();
        }

        private void tsmiLeaveGroup_Click(object sender, EventArgs e)
        {
            try
            {
                int groupid = (int)treeViewGroup.SelectedNode.Tag;
                if (groupid < 10000)
                {
                    Frm_leaveGroup f = new Frm_leaveGroup(this, userID, groupid);
                    f.Show();
                }
            }
            catch (Exception ex)
            { }
            
        }

        private void tsmiGroupInfo_Click(object sender, EventArgs e)
        {
            try{
            int id=(int)treeViewGroup.SelectedNode.Tag;
            if (id < 10000)
            {
                Frm_groupManage f = new Frm_groupManage(this, id, false);
                f.Show();
            }
            else
            {
                Frm_info f=new Frm_info(this,id,false);
                f.Show();
            }
            }catch(Exception ex)
            {}
        }


       
       
    }
}