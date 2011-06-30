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
    public partial class Frm_addGroup : Form
    {
        Frm_main parent;
        int hostid;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;
        DBHelper db;

        public Frm_addGroup(Frm_main f,int hostid)
        {
            InitializeComponent();
            this.parent = f;
            this.hostid = f.userID;
            this.db = f.db;
        }

        private void btnGreate_Click(object sender, EventArgs e)
        {
            if (txtGroupName.Text == "")
            {
                MessageBox.Show("群名不能为空");
                return;
            }
            try
            {
                str = string.Format("select count(*) from groups where hostid='{0}'", hostid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                int num = (int)cmd.ExecuteScalar();
                if (num >= 3)
                {
                    db.con.Close();
                    MessageBox.Show("系统规定每个用户只能创建最多三个群！");
                    return;
                }
                
                db.con.Close();

                str = string.Format("insert into groups (groupname,hostid,messager) values ('{0}','{1}','{2}')",
                    txtGroupName.Text, hostid, "群主很懒，什么都没有留下");
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();


                int groupid = 0;
                string groupname = "";
                str = string.Format("select top 1 * from groups where hostid='{0}' order by id desc", hostid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                { groupid = (int)reader["id"];
                groupname = reader["groupname"].ToString();
               }
               db.con.Close();

               str = string.Format("insert into groupmembers (groupid,hostid,groupstat) values ('{0}','{1}','{2}')",
                  groupid, hostid, 0);
               while (db.con.State != ConnectionState.Closed) ;
               cmd = new SqlCommand(str, db.con);
               db.con.Open();
               cmd.ExecuteNonQuery();
               db.con.Close();
               
                MessageBox.Show("群已创建成功,请确认信息!\n\n  群号:" + groupid + "\n\n  群名:" +groupname);
         
            }
            catch (Exception ex)
            {
                MessageBox.Show("error:create");
            }
            finally
            {
                db.con.Close();
            }
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
    }
}