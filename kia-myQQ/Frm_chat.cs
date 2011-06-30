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
        
        #region ����

        Frm_main parent;    //������
        Frm_groupChat parent_groupchat;
        int hostID, friendID;     //����ID������ID
        string hostNickName, friendNickName;   //�����ǳƣ������ǳ� 
        public ImageList ilFace;   //ͷ���б�
        SqlDataReader reader;
        SqlCommand cmd, cmd2;
        public DBHelper db;
        string str, str2;

        #endregion

        #region ���캯��
        
        //��ȡ�����ڵ���Դ
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

        #region �Զ��巽��

        //������Ϣ
        private void sendMessage()
        {
            try
            {
                str = string.Format("insert into messages (fromuserid,touserid,message,messagetypeid,messagestate,messagetime,groupid) values ('{0}','{1}','{2}','{3}','{4}','{5}','{6}')",
                    hostID, //0 ������ID
                    friendID, //1 ������ID
                    rtbEdit.Text, //2 ��Ϣ����
                    1, //3 ��Ϣ����
                    0, //4 ��Ϣ״̬
                    DateTime.Now.ToString(), //5 ����ʱ��
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

        //��ȡ������Դ
        private void getResource()
        {
            try
            {
                getHostInfo();
                getFreindInfo();
            }
            catch (Exception ex)
            { MessageBox.Show("��Ϣ����ʧ��"); }
        }

        //��ȡ������Ϣ
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
                lblState.Text = "(" + friendID + ")\n" + friendNickName + "\n״̬:";
                lblState.Text += (int)reader["userstateid"] == 3 ? "����" : reader["userstate"].ToString();
                this.Text = "��" + friendNickName + "������";
                if ((int)reader["userstateid"]==1)
                { picFriend.Image = ilFace.Images[(int)reader["faceid"]]; picFriendBusy.Hide(); }
                else if ((int)reader["userstateid"] == 2)
                { picFriend.Image = ilFace.Images[(int)reader["faceid"]]; picFriendBusy.Show(); }
                else
                { picFriend.Image = ilFace.Images[(int)reader["faceid"] + 33]; picFriendBusy.Hide(); }
            }
            db.con.Close();
        }

        //��ȡ������Ϣ
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
                lblHostState.Text = "(" + hostID + ")\n" + hostNickName + "\n״̬:" + reader["userstate"].ToString();
                if ((int)reader["userstateid"] == 1)
                { picHost.Image = ilFace.Images[(int)reader["faceid"]]; picHostBusy.Hide(); }
                else if ((int)reader["userstateid"] == 2)
                { picHost.Image = ilFace.Images[(int)reader["faceid"]]; picHostBusy.Show(); }
                else
                { picHost.Image = ilFace.Images[(int)reader["faceid"] + 33]; picHostBusy.Hide(); }
            }
            db.con.Close();
        }

        //���ҽ�����Ϣ
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

        #region �ؼ��¼�����

        //���촰��
        private void Frm_chat_Load(object sender, EventArgs e)
        {
            getResource();
            timer.Enabled = true;
        }


        //�������
        private void btnSendInfo_Click(object sender, EventArgs e)
        {
            if (rtbEdit.Text.Trim() != "")
            {
                sendMessage();
            }

        }

        //����ر�
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        //�����¼�
        private void timer_Tick(object sender, EventArgs e)
        {
            searchMessage();
        }


        //�����������
        private void picInfo_Click(object sender, EventArgs e)
        {
            Frm_info f = new Frm_info(this, friendID, false);
            f.Show();
        }


        //������
        private void lblMood_MouseHover(object sender, EventArgs e)
        {
            lblMood.ForeColor = Color.CadetBlue;
        }

        //����뿪
        private void lblMood_MouseLeave(object sender, EventArgs e)
        {
            lblMood.ForeColor = Color.White;
        }
        #endregion
    }
}