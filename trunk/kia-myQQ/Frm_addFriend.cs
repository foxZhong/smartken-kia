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
    public partial class Frm_addFriend : Form
    {
        Frm_main parent;
        public int hostID,friendID,groupID=0;
        public string friendNickName,groupName="";
        public ImageList ilFace;
        SqlDataAdapter adapter;
        DataSet dataset=new DataSet();
        SqlCommand cmd;
        string str;
        public DBHelper db;
        int tabpage = 0;
        public Frm_addFriend(Frm_main f)
        {
            InitializeComponent();
            this.parent = f;
            this.hostID = f.userID;
            this.ilFace = f.ilFace;
            this.db = f.db;
        }

        private void Frm_addFriend_Load(object sender, EventArgs e)
        {
            rbnSearch_CheckedChanged(sender, e);
            rbnSearchNickName_CheckedChanged(sender, e);
            tabControlFriend.Show();
            groupBox2.Hide();
            btnReturn.Hide();
            btnAccession.Hide();
            adapter = new SqlDataAdapter("select id,nickname,sex,age from users where 1=2", db.con);
            adapter.Fill(dataset, "friend");
            adapter = new SqlDataAdapter("select * from groups where 1=2", db.con);
            adapter.Fill(dataset, "group");
            txtGroupName.Enabled = false;
        }

        private void btnLookup_Click(object sender, EventArgs e)
        {
            groupBox2.Show();
            groupBox3.Hide();
            btnReturn.Show();
            btnLookup.Hide();
            btnAccession.Show();
            btnFindAll.Hide();
            try
            {
                //
                if (tabControlFriend.SelectedIndex == 0)
                {
                    dataset.Tables["friend"].Clear();
                    setSelcetString(ref str);
                    adapter = new SqlDataAdapter(str, db.con);
                    adapter.Fill(dataset, "friend");
                    dgvSearch.DataSource = dataset.Tables["friend"];
                    labResult.Text = "查找到符合条件的用户共" + dataset.Tables["friend"].Rows.Count + "个";
                }
                else if (tabControlFriend.SelectedIndex == 1)
                {
                    dataset.Tables["group"].Clear();
                    setSelcetString(ref str);
                    adapter = new SqlDataAdapter(str, db.con);
                    adapter.Fill(dataset, "group");
                    dgvSearchGroup.DataSource = dataset.Tables["group"];
                    labResult.Text = "查找到符合条件的群共" + dataset.Tables["group"].Rows.Count + "个";
                }
                }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            
        }

        private void setSelcetString(ref string str)
        {
            if (tabControlFriend.SelectedIndex == 0)
            {
                if (rbnSearch1.Checked)
                {
                    if (cboSerachSex.Text == "男女不限" && cboSearchCity.Text == "")
                        str = string.Format("select id,nickname,sex,age,faceid from users where age<='{0}' and age>='{1}'",
                            (int)nudSearchMaxAge.Value, (int)nudSearchMinAge.Value);
                    else if (cboSearchCity.Text == "")
                        str = string.Format("select id,nickname,sex,age,faceid from users where age<='{0}' and age>='{1}' and sex='{2}'",
                            (int)nudSearchMaxAge.Value, (int)nudSearchMinAge.Value, cboSerachSex.Text);
                    else if (cboSerachSex.Text == "男女不限")
                        str = string.Format("select id,nickname,sex,age,faceid from users where age<='{0}' and age>='{1}' and city='{2}'",
                            (int)nudSearchMaxAge.Value, (int)nudSearchMinAge.Value, cboSearchCity.Text);
                    else
                        str = string.Format("select id,nickname,sex,age,faceid from users where age<='{0}' and age>='{1}' and sex='{2}' and city='{3}'",
                           (int)nudSearchMaxAge.Value, (int)nudSearchMinAge.Value, cboSerachSex.Text, cboSearchCity.Text);
                }
                else if (rbnSearch2.Checked)
                {
                    if (rbnSearchNickName.Checked)
                        str = string.Format("select id,nickname,sex,age,faceid from users where nickname like '%{0}%'", txtSearchNickName.Text);
                    else if (rbnSearchID.Checked)
                        str = string.Format("select id,nickname,sex,age,faceid from users where id='{0}'", int.Parse(txtSearchID.Text));
                }
            }
            else if (tabControlFriend.SelectedIndex == 1)
            {
                if (rbnFindGroupId.Checked)
                    str = string.Format("select * from groups where id='{0}'", (int)nupGroupId.Value);
                else if (rbnFindGroupName.Checked)
                    str = string.Format("select * from groups where groupname like '%{0}%'", txtGroupName.Text.Trim());
            }
        }

        private void rbnSearch_CheckedChanged(object sender, EventArgs e)
        {
            if (rbnSearch1.Checked)
            {
                gbSearch1.Show();
                gbSearch2.Hide();
            }
            else
            {
                gbSearch1.Hide();
                gbSearch2.Show();
            }
        }

        private void rbnSearchNickName_CheckedChanged(object sender, EventArgs e)
        {
            if (rbnSearchNickName.Checked)
            {
                txtSearchNickName.ReadOnly = false;
                txtSearchID.ReadOnly = true;
            }
            else
            {
                txtSearchNickName.ReadOnly = true;
                txtSearchID.ReadOnly = false;
            }
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            groupBox2.Hide();
            groupBox3.Show();
            btnReturn.Hide();
            btnLookup.Show();
            btnAccession.Hide();
            btnFindAll.Show();
        }

        private void dgvSearch_Click(object sender, EventArgs e)
        {
            int faceid=(int)dgvSearch.SelectedRows[0].Cells["faceid"].Value;
            friendID = (int)dgvSearch.SelectedRows[0].Cells["id"].Value;
            friendNickName = dgvSearch.SelectedRows[0].Cells["nickname"].Value.ToString();
            picFace.Image = ilFace.Images[faceid];
        }

        private void dgvSearchGroup_Click(object sender, EventArgs e)
        {
            groupID = (int)dgvSearchGroup.SelectedRows[0].Cells["groupid"].Value;
            groupName = dgvSearchGroup.SelectedRows[0].Cells["groupname"].Value.ToString();
        }

        private void btnAccession_Click(object sender, EventArgs e)
        {
            Frm_addFriendRequest f = new Frm_addFriendRequest(this);
            f.ShowDialog();
        }

        private void btnLookInfo_Click(object sender, EventArgs e)
        {
            Frm_info f = new Frm_info(this, friendID, false);
            f.Show();
        }



        private void btnFindAll_Click(object sender, EventArgs e)
        {
            groupBox2.Show();
            groupBox3.Hide();
            btnReturn.Show();
            btnLookup.Hide();
            if(tabControlFriend.SelectedIndex==0)
            btnAccession.Show();
            btnFindAll.Hide();
            try
            {
                //
                dataset.Tables["friend"].Clear();
                if (tabControlFriend.SelectedIndex == 0)
                {
                    btnEnterGroup.Hide();
                    btnAccession.Show();
                    dgvSearch.Show();
                    dgvSearchGroup.Hide();
                    adapter = new SqlDataAdapter("select id,nickname,sex,age,faceid from users", db.con);
                    adapter.Fill(dataset, "friend");
                    dgvSearch.DataSource = dataset.Tables["friend"];
                    labResult.Text = "查找到符合条件的用户共" + dataset.Tables["friend"].Rows.Count + "个";
                }
                else if (tabControlFriend.SelectedIndex == 1)
                {
                    btnEnterGroup.Show();
                    btnAccession.Hide();
                    dgvSearchGroup.Show();
                    dgvSearch.Hide();
                    adapter = new SqlDataAdapter("select * from groups", db.con);
                    adapter.Fill(dataset, "group");
                    dgvSearchGroup.DataSource = dataset.Tables["group"];
                    labResult.Text = "查找到符合条件的群共" + dataset.Tables["group"].Rows.Count + "个";
                }
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
        }

        private void rbnFindGroupId_CheckedChanged(object sender, EventArgs e)
        {
            if (rbnFindGroupId.Checked)
            {
                nupGroupId.Enabled = true;
                txtGroupName.Enabled = false;
            }
            else
            {
                nupGroupId.Enabled = false;
                txtGroupName.Enabled = true;
            }
        }

     

        private void tabControlFriend_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.tabpage = tabControlFriend.SelectedIndex;
            //tabpage = (int)(tabControlFriend.TabPages[tabControlFriend.SelectedIndex].Tag);
        }

        private void btnEnterGroup_Click(object sender, EventArgs e)
        {
            try
            {
                if (groupID == 0)
                    return;
                str = string.Format("select count(*) from groupmembers where groupmemberid='{0}' and groupid='{1}'",
                    hostID, groupID);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                int i = (int)cmd.ExecuteScalar();
                if (i > 0)
                { 
                    db.con.Close();
                    MessageBox.Show("你已经是 " + groupName.Trim() + " 里的成员，不能再进入.");
                    return;
                }
                db.con.Close();

                str = string.Format("insert into groupmembers values ('{0}','{1}','{2}')",
                    groupID, hostID, 1);
                while (db.con.State != ConnectionState.Closed) ;
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                cmd.ExecuteNonQuery();
                db.con.Close();
                MessageBox.Show("恭喜!你已成为 " +groupName.Trim()+ " 的成员.");

            }
            catch (Exception ex)
            {
                MessageBox.Show("error:enter");
            }
            finally
            { db.con.Close(); }
        }

        
      

      




        }
    }
