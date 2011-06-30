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
    public partial class Frm_addFriendRequest : Form
    {
        Frm_addFriend parent;
        Frm_systemMessage parent2;
        int hostID, friendID;
        string friendNickName;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;
        public DBHelper db; 

        public Frm_addFriendRequest(Frm_addFriend f)
        {
            InitializeComponent();
            this.parent = f;
            this.hostID = f.hostID;
            this.friendID = f.friendID;
            this.friendNickName = f.friendNickName;
            this.db = f.db;
        }

        public Frm_addFriendRequest(Frm_systemMessage f)
        {
            InitializeComponent();
            this.parent2 = f;
            this.hostID = f.hostid;
            this.friendID = f.fromuserid;
            this.friendNickName = f.hostNickeName;
            this.db = f.db;
        }

        public bool checkAddFreindReequest()
        {
            if (hostID == friendID)
            {
                MessageBox.Show("��������Լ�Ϊ����");
                return false;
            }
            try
            {
                str = string.Format("select count(*) from friends where hostid='{0}' and friendid='{1}'", hostID, friendID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                if ((int)cmd.ExecuteScalar() > 0)
                {
                    db.con.Close();
                    MessageBox.Show("�Է��Ѿ�������ѣ������ظ����");
                    return false;
                }
                db.con.Close();

                str = string.Format("select friendshippolicyid from users where id='{0}'", friendID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                reader.Read();               
                    if ((int)reader[0] == 3)
                    {
                        db.con.Close();
                        MessageBox.Show("�Է���������Ϊ����");
                        return false;
                    }
                    else if ((int)reader[0] == 2)
                    {
                        db.con.Close();
                        return true;
                    }
                    else if ((int)reader[0] == 1)
                    {
                        db.con.Close();
                        str = string.Format("insert into friends (hostid,friendid,friendoption) values ('{0}','{1}','{2}')",
                   hostID,  //0 ����
                   friendID, //1����
                   0  //2��ϵ  0Ϊ����
                   );
                        while (db.con.State != ConnectionState.Closed) ;
                        cmd = new SqlCommand(str, db.con);
                        db.con.Open();
                        cmd.ExecuteNonQuery();
                        db.con.Close();
                        MessageBox.Show("��Ӻ��ѳɹ�;");
                        return false;
                    }

                
                
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
            return false;
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            sentAddFriendRequest();
            this.Dispose();
        }

        private void sentAddFriendRequest()
        {
            if (!checkAddFreindReequest())
                return;
            try
            {
                str = string.Format("insert into messages (fromuserid,touserid,message,messagetypeid,messagestate,messagetime,groupid) values ('{0}','{1}','{2}','{3}','{4}','{5}','{6}')",
                    hostID, //0 ������ID
                        friendID, //1 ������ID
                       txtRequestMessage.Text, //2 ��Ϣ����
                        2, //3 ��Ϣ����
                        0, //4 ��Ϣ״̬
                        DateTime.Now.ToString(), //5 ����ʱ��
                        1 //6 Ⱥ��
                        );
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
               
            }
            catch (Exception ex)
            {
                MessageBox.Show("error");
            }
            finally
            { db.con.Close();
            MessageBox.Show("����������Ϣ�ѷ����������ĵȴ��ظ�");
        }
        }

        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void Frm_addFriendRequest_Load(object sender, EventArgs e)
        {
            this.Text = "���" + friendNickName + "Ϊ����";
        }
    }
}