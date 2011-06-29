using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;



namespace BookSystem
{
    public partial class frmMessage : Form
    {
        public frmMessage()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }



        static List<User> users = new List<User>();
        
        public void LoadAllUser()
        {
            users = UserManage.getAllUsers();
            lvMessage.Items.Clear();
            foreach (User u in users)
            {
                ListViewItem lvi = new ListViewItem(u.Code);
                lvi.Tag = u.Id;
                lvi.SubItems.AddRange(new string[]{u.RealName,UserManage.getRolerByID(u.RoleId).Name,u.Active==1 ? "正常":"冻结"});
                lvMessage.Items.Add(lvi);
            }
        }

        public void LoadUserByCodeAndName()
        {
            users.Clear();
            if (UserManage.getUserByCodeAndName(this.txtCode.Text, this.txtName.Text) != null)
            {
                users.Add(UserManage.getUserByCodeAndName(this.txtCode.Text, this.txtName.Text));
                lvMessage.Items.Clear();
                foreach (User u in users)
                {
                    ListViewItem lvi = new ListViewItem(u.Code);
                    lvi.Tag = u.Id;
                    lvi.SubItems.AddRange(new string[] { u.RealName, UserManage.getRolerByID(u.RoleId).Name, u.Active == 1 ? "正常" : "冻结" });
                    lvMessage.Items.Add(lvi);
                }
            }
            else
            {
                MessageBox.Show("无此员工！");
            }
        }

        public void LoadUserByCode()
        {
            users.Clear();
            if (UserManage.getUserByCode(this.txtCode.Text) != null)
            {
                users.Add(UserManage.getUserByCode(this.txtCode.Text));
                lvMessage.Items.Clear();
                foreach (User u in users)
                {
                    ListViewItem lvi = new ListViewItem(u.Code);
                    lvi.Tag = u.Id;
                    lvi.SubItems.AddRange(new string[] { u.RealName, UserManage.getRolerByID(u.RoleId).Name, u.Active == 1 ? "正常" : "冻结" });
                    lvMessage.Items.Add(lvi);
                }
            }
            else
            {
                MessageBox.Show("无此卡号！");
            }
            //foreach (ListViewItem item in this.lvMessage.Items)
            //{
            //    if (item.Text == this.txtCode.Text)
            //    {
            //        item.Selected = true;
            //        return;
            //    }
            //}
        }

        public void LoadUserByName()
        {
            users.Clear();
            if (UserManage.getUserByName(this.txtName.Text).Count !=0)
            {
                users = UserManage.getUserByName(this.txtName.Text);
                lvMessage.Items.Clear();
                foreach (User u in users)
                {
                    ListViewItem lvi = new ListViewItem(u.Code);
                    lvi.Tag = u.Id;
                    lvi.SubItems.AddRange(new string[] { u.RealName, UserManage.getRolerByID(u.RoleId).Name, u.Active == 1 ? "正常" : "冻结" });
                    lvMessage.Items.Add(lvi);
                }
            }
            else 
            {
                MessageBox.Show("无此员工！");
            }
        }

        private void frmMessage_Load(object sender, EventArgs e)
        {
            LoadAllUser();
        }

        private void lvMessage_SelectedIndexChanged(object sender, EventArgs e)
        {
            ListViewItem item = lvMessage.SelectedItems[0];
            string id = item.Text;
        }

        private void btnSelect_Click(object sender, EventArgs e)
        {
            if (this.txtCode.Text != "" && this.txtName.Text != "")
            {
                LoadUserByCodeAndName();
                this.txtCode.Text = "";
                this.txtName.Text = "";
                return;
            }
            if (this.txtCode.Text != "")
            {
                LoadUserByCode();
                this.txtCode.Text = "";
                return;
            }
            if (this.txtName.Text != "")
            {
                LoadUserByName();
                this.txtName.Text = "";
                return;
            }
            LoadAllUser();
        }

        private void tsmiUpdate_Click(object sender, EventArgs e)
        {
            string code = lvMessage.SelectedItems[0].Text;
            int id = int.Parse(lvMessage.SelectedItems[0].Tag.ToString());
            frmUpDateUser frm = new frmUpDateUser(UserManage.getUserById(id));
            frm.form = this;
            frm.code = code;
            frm.Show();
        }

        private void tsmiDelete_Click(object sender, EventArgs e)
        {
            int id = (int)lvMessage.SelectedItems[0].Tag;
            int result = UserManage.deleteUserById(id);
            if(result != 0)
            {
                MessageBox.Show("删除成功！");
                LoadAllUser();
            }
            else
                MessageBox.Show("删除失败！");
        }

        private void lvMessage_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            string code = lvMessage.SelectedItems[0].Text;
            int id = int.Parse(lvMessage.SelectedItems[0].Tag.ToString());
            frmUpDateUser frm = new frmUpDateUser(UserManage.getUserById(id));
            frm.code = code;
            frm.Show();
        }

        private void tsmiSelectSale_Click(object sender, EventArgs e)
        {
            int id = (int)lvMessage.SelectedItems[0].Tag;
            User u = UserManage.getUserById(id);
            frmAccount frm = new frmAccount(u);
            frm.Show();
        }
    }
}
