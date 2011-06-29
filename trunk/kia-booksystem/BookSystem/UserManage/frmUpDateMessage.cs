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
    public partial class frmUpDateUser : Form
    {
        
        public frmUpDateUser(User u)
        {
            InitializeComponent();
        }
        public frmMessage form = null;
        User u = frmMain.user;
        public string code = null;
        private void frmUpDateUser_Load(object sender, EventArgs e)
        {
            if (code != null)
            {
                this.txtNumber.Text = UserManage.getUserByCode(code).Code;
                this.txtName.Text = UserManage.getUserByCode(code).RealName;
            }
            else
            {
                this.txtNumber.Text = u.Code;
                this.txtName.Text = u.RealName;
            }
            if (u.RoleId != 1)
            {
                cboJob.Enabled = true;
                rabNormal.Enabled = true;
                rabFreeze.Enabled = true;
            }

            cboJob.DisplayMember = "Name";
            foreach (Rolers roler in UserManage.getAllRolers())
            {
                cboJob.Items.Add(roler);
            }
            cboJob.SelectedItem = cboJob.Items[0];
        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (UserManage.getPassByCode(this.txtNumber.Text) == txtPass.Text)
            {
                u.Code = txtNumber.Text;
                u.Pass = txtNewPass.Text;
                u.RealName = txtName.Text;
                Rolers role = cboJob.SelectedItem as Rolers;
                u.RoleId = role.Id;
                u.Active = rabNormal.Checked ? 1 : 0;
                int resule = UserManage.updateUser(u);
                if (resule == 1)
                {
                    txtPass.Text = "";
                    txtNewPass.Text = "";
                    form.LoadAllUser();
                    MessageBox.Show("修改成功！");
                }
            }
            else
                MessageBox.Show("密码错误！");
        }

    }
}
