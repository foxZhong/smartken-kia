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
    public partial class Frm_findpwd : Form
    {
        Frm_login parent;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;
        int userid=0;
        DBHelper db;

        public Frm_findpwd(Frm_login f)
        {
            InitializeComponent();
            this.parent = f;
            this.db = f.db;
        }

        private void btnGetQuestion_Click(object sender, EventArgs e)
        {
            try
            {
                str = string.Format("select question from users,question where users.id='{0}' and questionid=question.id",int.Parse(txtUserid.Text));
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    txtQuestion.Text = reader["question"].ToString();
                    userid = int.Parse(txtUserid.Text);
                    db.con.Close();
                }
                else
                { 
                    db.con.Close();
                    MessageBox.Show("用户不存在");
                }
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
        }

        private void btnGetpwd_Click(object sender, EventArgs e)
        {
            try
            {
                string pwd="";
                str = string.Format("select loginpwd from users where answer='{0}' and id='{1}'",
                    txtAnswer.Text, userid);
                //MessageBox.Show(userid.ToString());
                while (db.con.State != ConnectionState.Closed);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                if (reader.Read())
                {
                    pwd = reader["loginpwd"].ToString();
                    db.con.Close();

                }
                else
                { db.con.Close(); }

                if(pwd!="")
                    MessageBox.Show(string.Format("答案正确,你的密码是:{0}\n以后请妥善保管密码.", pwd));
                else
                {
                   
                    MessageBox.Show("答案错误.");
                   
                }
                
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            parent.Show();
            this.Dispose();
            
        }
    }
}