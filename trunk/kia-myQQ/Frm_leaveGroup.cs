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
    public partial class Frm_leaveGroup : Form
    {
        Frm_main parent;
        int hostid,groupid;
        bool isGroupHost;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;
        DBHelper db;

        public Frm_leaveGroup(Frm_main f,int hostid,int groupid)
        {
            InitializeComponent();
            this.parent = f;
            this.hostid = hostid;
            this.groupid = groupid;
            this.db = f.db;
        }

        private void Frm_leaveGroup_Load(object sender, EventArgs e)
        {
            getResource();
            setEnable(isGroupHost);
        }

        public void getResource()
        {
            try
            {
                int grouphostid=0;
                string groupname="";
                str = string.Format("select * from groups where id='{0}'", groupid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                { groupname = reader["groupname"].ToString();
                grouphostid = (int)reader["hostid"];
                }  
                db.con.Close();
                if (grouphostid == hostid)
                    isGroupHost = true;
                else
                    isGroupHost = false;
                lblAlart1.Text = "Äã½«ÍË³öÈº£º" + groupname;
                lblAlart2.Text = lblAlart1.Text;

                //MessageBox.Show("error"); 

                str = string.Format("select groupmemberid,nickname from groupmembers,users " +
                    "where groupid='{0}' and groupmemberid=users.id", groupid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    if (hostid != (int)reader["groupmemberid"])
                        cboMembers.Items.Add(reader["nickname"].ToString());
                   
                }
                //cboMembers.Text = cboMembers.Items[0].ToString();
            }
            catch (Exception ex)
            { MessageBox.Show("error:getresource"); }
            finally
            { db.con.Close(); }
        }

        public void setEnable(bool enable)
        {
            groupBox1.Visible = enable;
            groupBox2.Visible = !enable;
 
        }

        public int getMemberid()
        {
            try
            {int memberid=0;
                 str = string.Format("select id from users " +
                    "where nickname='{0}'", cboMembers.Text.Trim());
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                    memberid = (int)reader["id"];
                return memberid;
            }
            catch (Exception ex)
            { MessageBox.Show("error:getmemberid"); }
            finally
            { db.con.Close(); }
            return 0;
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            try
            {
                str = string.Format("delete from groupmembers where groupid='{0}' and groupmemberid='{1}'",
                    groupid, hostid);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();

                if (isGroupHost)
                {
                    if (rbnChangGroupHost.Checked)
                    {
                        str = string.Format("update groups set hostid='{0}' where id='{1}'",
                        getMemberid(),groupid);
                       
                    }
                    else if (rbnDestoryGroup.Checked)
                    {
                        str = string.Format("delete from groups where id='{0}'",
                        groupid);
                        while (db.con.State != ConnectionState.Closed) ;
                        cmd = new SqlCommand(str, db.con);
                        db.con.Open();
                        cmd.ExecuteNonQuery();
                        db.con.Close();

                        str=string.Format("delete from groupmembers where groupid='{0}'",
                            groupid);
                    }
                        while (db.con.State != ConnectionState.Closed) ;
                        cmd = new SqlCommand(str, db.con);
                        db.con.Open();
                        cmd.ExecuteNonQuery();
                        db.con.Close();
                    
                }
            }
            catch (Exception ex)
            { MessageBox.Show("error:confirm"); }
            finally
            { db.con.Close(); }
            this.Dispose();
        }

        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
    }
}