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
    public partial class Frm_chat : Form
    {
        
        #region 属性

        Frm_main parent;    //父窗口
        Frm_groupChat parent_groupchat;
        int hostID, friendID;     //主人ID，朋友ID
        string hostNickName, friendNickName;   //主人昵称，朋友昵称 
        public ImageList ilFace;   //头像列表
        SqlDataReader reader;
        SqlCommand cmd, cmd2;
        public DBHelper db;
        string str, str2;

        #endregion

        #region 构造函数
        
        //获取父窗口的资源
        public Frm_chat(Frm_main f, int hostID, int friendID)
        {
            InitializeComponent();
            this.parent = f;    
            this.hostID = hostID;
            this.friendID = friendID;
            this.ilFace = f.ilFace;
            this.db = f.db;
        }

        public Frm_chat(Frm_groupChat f,int hostID,int friendID)
        {
            InitializeComponent();
            this.parent_groupchat = f;    
            this.hostID = hostID;
            this.friendID = friendID;
            this.ilFace = f.ilFace;
            this.db = f.db;
        
        }

        #endregion

        #region 自定义方法

        //发送信息
        private void sendMessage()
        {
            try
            {
                str = string.Format("insert into messages (fromuserid,touserid,message,messagetypeid,messagestate,messagetime,groupid) values ('{0}','{1}','{2}','{3}','{4}','{5}','{6}')",
                    hostID, //0 发送人ID
                    friendID, //1 收信人ID
                    rtbEdit.Text, //2 信息内容
                    1, //3 消息类型
                    0, //4 消息状态
                    DateTime.Now.ToString(), //5 发送时间
                    0);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);

                db.con.Open();
                if (cmd.ExecuteNonQuery() > 0)
                {
                    rtbDisplay.Text = rtbDisplay.Text + hostNickName + "  " + DateTime.Now.ToString() + "\n  " + rtbEdit.Text + "\n\n";
                    rtbEdit.Clear();
                }
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
        }

        //获取窗口资源
        private void getResource()
        {
            try
            {
                getHostInfo();
                getFreindInfo();
            }
            catch (Exception ex)
            { MessageBox.Show("信息加载失败"); }
        }

        //获取友人信息
        private void getFreindInfo()
        {
            str = string.Format("select faceid,nickname,mood,userstate,userstateid from users,userstate"+
                " where users.id='{0}' and userstateid=userstate.id", friendID);
            cmd = new SqlCommand(str, db.con);
            db.con.Open();
            reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                friendNickName = reader["nickname"].ToString();
                picFriend.Image = ilFace.Images[(int)reader["faceid"]];
                lblMood.Text = friendNickName + ":" + reader["mood"].ToString();
                lblState.Text = "(" + friendID + ")\n" + friendNickName + "\n状态:";
                lblState.Text += (int)reader["userstateid"] == 3 ? "离线" : reader["userstate"].ToString();
                this.Text = "与" + friendNickName + "聊天中";
                if ((int)reader["userstateid"]==1)
                { picFriend.Image = ilFace.Images[(int)reader["faceid"]]; picFriendBusy.Hide(); }
                else if ((int)reader["userstateid"] == 2)
                { picFriend.Image = ilFace.Images[(int)reader["faceid"]]; picFriendBusy.Show(); }
                else
                { picFriend.Image = ilFace.Images[(int)reader["faceid"] + 33]; picFriendBusy.Hide(); }
            }
            db.con.Close();
        }

        //获取主人信息
        private void getHostInfo()
        {
            str = string.Format("select faceid,nickname,userstate,userstateid from users,userstate " +
                "where users.id='{0}' and userstateid=userstate.id", hostID);
            cmd = new SqlCommand(str, db.con);
            db.con.Open();
            reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                hostNickName = reader["nickname"].ToString();
                //picHost.Image = ilFace.Images[(int)reader["faceid"]];
                lblHostState.Text = "(" + hostID + ")\n" + hostNickName + "\n状态:" + reader["userstate"].ToString();
                if ((int)reader["userstateid"] == 1)
                { picHost.Image = ilFace.Images[(int)reader["faceid"]]; picHostBusy.Hide(); }
                else if ((int)reader["userstateid"] == 2)
                { picHost.Image = ilFace.Images[(int)reader["faceid"]]; picHostBusy.Show(); }
                else
                { picHost.Image = ilFace.Images[(int)reader["faceid"] + 33]; picHostBusy.Hide(); }
            }
            db.con.Close();
        }

        //查找接收信息
        private void searchMessage()
        {
            try
            {

                str = string.Format("select message,messagetime from messages where touserid='{0}' and fromuserid='{1}'and messagestate=0 and messagetypeid=1", hostID, friendID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd2 = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd2.ExecuteReader();
                while (reader.Read())
                {

                    rtbDisplay.Text = rtbDisplay.Text + friendNickName + "  " + reader["messagetime"].ToString() + "\n  " + reader["message"].ToString() + "\n\n";

                }

                db.con.Close();
                str = string.Format("update messages set messagestate=1 where touserid='{0}' and fromuserid='{1}' and messagestate=0 and messagetypeid=1", hostID, friendID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd2 = new SqlCommand(str, db.con);
                db.con.Open();
                cmd2.ExecuteNonQuery();

            }
            catch (Exception ex)
            { MessageBox.Show("error1"); }
            finally
            { db.con.Close(); }
        }
    #endregion

        #region 控件事件方法

        //构造窗口
        private void Frm_chat_Load(object sender, EventArgs e)
        {
            getResource();
            timer.Enabled = true;
        }


        //点击发送
        private void btnSendInfo_Click(object sender, EventArgs e)
        {
            if (rtbEdit.Text.Trim() != "")
            {
                sendMessage();
            }

        }

        //点击关闭
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        //周期事件
        private void timer_Tick(object sender, EventArgs e)
        {
            searchMessage();
        }


        //点击友人心情
        private void picInfo_Click(object sender, EventArgs e)
        {
            Frm_info f = new Frm_info(this, friendID, false);
            f.Show();
        }


        //鼠标进入
        private void lblMood_MouseHover(object sender, EventArgs e)
        {
            lblMood.ForeColor = Color.CadetBlue;
        }

        //鼠标离开
        private void lblMood_MouseLeave(object sender, EventArgs e)
        {
            lblMood.ForeColor = Color.White;
        }
        #endregion
    }
}