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
    public partial class frmAddUser : Form
    {
        User user;
        public frmAddUser()
        {
            InitializeComponent();
        }

        

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if(txtPass.Text=="")
            {
                MessageBox.Show("请输入密码！", "提示", MessageBoxButtons.OK); return;
            }
            else if (txtPass.Text != txtRePass.Text)
            {
                MessageBox.Show("两次输入的密码不一致！", "提示", MessageBoxButtons.OK); return;
            }
            else if (txtUName.Text == "")
            {
                MessageBox.Show("真实姓名不能为空！", "提示", MessageBoxButtons.OK); return;
            }
            else if (cboJob.Text == "")
            {
                MessageBox.Show("请选择职位！", "提示", MessageBoxButtons.OK); return;
            }
            user = new User();
            user.Code = UserManage.getLastUserId() == 0 ?"AC100000":"AC" + (100000 + (UserManage.getLastUserId())).ToString();
            user.Pass = txtPass.Text;
            user.RealName = txtUName.Text;
            Rolers roler = cboJob.SelectedItem as Rolers;
            user.RoleId = roler.Id;
            user.Active = 1;
            int result = UserManage.addUser(user);
            if (result == 1)
            {
                MessageBox.Show("添加成功！员工号：" + user.Code);
                txtPass.Text = "";
                txtRePass.Text = "";
                txtUName.Text = "";
                cboJob.SelectedItem = cboJob.Items[0];
            }
            else
                MessageBox.Show("添加失败！");
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmAddUser_Load(object sender, EventArgs e)
        {
            cboJob.DisplayMember = "Name";
            foreach (Rolers roler in UserManage.getAllRolers())
            {
                cboJob.Items.Add(roler);
            }
            cboJob.SelectedItem = cboJob.Items[0];
            txtPass.Text = "888888";
            txtRePass.Text = "888888";
        }

        private void btnSelect_Click(object sender, EventArgs e)
        {
            frmMessage frm = new frmMessage();
            frm.Show();
            this.Close();
        }


    }
}
