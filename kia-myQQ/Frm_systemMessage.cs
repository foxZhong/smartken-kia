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
    public partial class Frm_systemMessage : Form
    {
        Frm_main parent;
        public int messageid,fromuserid,hostid;
        public string hostNickeName;
        public ImageList ilFace;
        public DBHelper db;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;
 
        public Frm_systemMessage(Frm_main f,int id,string message,int fromuserid)
        {
            InitializeComponent();
            this.parent = f;
            this.db = f.db;
            this.messageid = id;
            txtMessageGet.Text= message;
            this.fromuserid = fromuserid;
            this.hostid = f.userID;
            this.hostNickeName = f.userNickName;
            this.ilFace = f.ilFace;
        }

        public void getResource()
        {
            try
            {
                str = string.Format("select nickname from users where id='{0}'", fromuserid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                    llbNickName.Text = string.Format("{0}请求添加你为好友", reader["nickname"]);
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
        }

        private void Frm_systemMessage_Load(object sender, EventArgs e)
        {
            getResource();
        }

        private void llbNickName_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            Frm_info f = new Frm_info(this, fromuserid, false);
            f.Show();
        }

        public bool allowRequest()
        {
            str = string.Format("select count(*) from friends where hostid='{0}' and friendid='{1}' and friendoption=1", hostid,fromuserid);
            while (db.con.State != ConnectionState.Closed) ;
            cmd = new SqlCommand(str, db.con);
            db.con.Open();
            if ((int)cmd.ExecuteScalar() > 0)
            {
                db.con.Close();
                MessageBox.Show("对方已经是你好友，不能重复添加");
                return false;
            }
            db.con.Close();
            return true;
        }

        private void btnAllow_Click(object sender, EventArgs e)
        {
            if (!allowRequest())
                return;
            try
            {
                str = string.Format("insert into friends (hostid,friendid,friendoption) values ('{0}','{1}','{2}')", 
                    parent.userID,  //0 主人
                    fromuserid, //1朋友
                    0  //2关系  0为好友
                    );
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close();
            MessageBox.Show("添加好友成功");
            this.Dispose();
            }
        }

        private void btnNo_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnAddFriend_Click(object sender, EventArgs e)
        {
            Frm_addFriendRequest f = new Frm_addFriendRequest(this);
            f.Show();
        }
    }
}