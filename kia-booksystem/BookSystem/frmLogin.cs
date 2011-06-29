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
    public partial class frmLogin : Form
    {
        public frmLogin()
        {
            InitializeComponent();

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            User u = UserManage.checkLogin(txtCode.Text,txtPass.Text);
            if (u != null)
            {
                this.Hide();
                frmMain aa = new frmMain(this,u);
                aa.Show();
            }
            else
            {
                MessageBox.Show("员工号与密码不匹配，或账号被冻结", "登陆失败");
                txtPass.Text = "";
            }   
        }

        private void txtCode_Leave(object sender, EventArgs e)
        {
            
            User user = UserManage.getUserByCode(txtCode.Text);
            if (user != null)
            {
                lblName.Text = "员工名：";
                lblRealName.Text = user.RealName;
            }
            else
                MessageBox.Show("卡号输入错误！");
        }

        private void frmLogin_Load(object sender, EventArgs e)
        {
            lblRealName.Text = "";
            lblName.Text = "";
        }
    }
}
