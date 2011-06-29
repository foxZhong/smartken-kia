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
    public partial class frmMain : Form
    {
        public static User user = null;

        public static frmMain main;

        public static List<Form> forms=new List<Form>();

        public frmLogin parent;

        public frmMain(frmLogin f, User u)
        {
            InitializeComponent();
            frmMain.main = this;
            this.parent = f;
            user = u;
            tsslUserInfo.Text = "当前用户:" + u.RealName;
            tsslLoginTime.Text = "登陆时间:" + DateTime.Now.ToString();
            Rolers role = UserManage.getRolerByID(u.RoleId);
            tsslRoleInfo.Text = "职位:" + role.Name;
            
        }

      

        private void tsmiToAddBook_Click(object sender, EventArgs e)
        {
            frmAddBook frm = new frmAddBook();
                frm.MdiParent = this;
                forms.Add(frm);
                frm.Show();
            
        }

        private void tsmiToManageBook_Click(object sender, EventArgs e)
        {
            Form frm = new frmManageBook();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiCreateSale_Click(object sender, EventArgs e)
        {
            Form frm = new frmSale();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiSaleAccount_Click(object sender, EventArgs e)
        {
            Form frm = new frmAccount(frmMain.user);
            frm.MdiParent = this;
            frm.Show();
        }

        private void frmMain_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void tsmiCreateCard_Click(object sender, EventArgs e)
        {
            Form frm = new frmCreateCard();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiManageCard_Click(object sender, EventArgs e)
        {
            Form frm = new frmManageCard();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiStockAccount_Click(object sender, EventArgs e)
        {
            Form frm = new frmSeachBook();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiAddUser_Click(object sender, EventArgs e)
        {
            Form frm = new frmAddUser();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmlSelectUser_Click(object sender, EventArgs e)
        {
            Form frm = new frmMessage();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiManageUser_Click(object sender, EventArgs e)
        {
            Form frm = new frmUpDateUser(frmMain.user);
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiRoleManage_Click(object sender, EventArgs e)
        {
            Form frm = new frmRoleManage();
            frm.MdiParent = this;
            frm.Show();
        }

        private void tsmiLogOut_Click(object sender, EventArgs e)
        {
            frmLogin frm = new frmLogin();
            frm.Show();
        }

        private void tsmiExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void tsmiSaleAccount_Click_1(object sender, EventArgs e)
        {
            Form frm = new frmSaleMonthAccount();
            frm.MdiParent = this;
            frm.Show();
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            if (frmMain.user.RoleId == 1)
            {
                tsmiCreateSale.Enabled = true;
                tsmiInCome.Enabled = true;
            }
            else if (frmMain.user.RoleId == 2)
            {
                tsmiAddUser.Enabled = true;
                tsmlSelectUser.Enabled = true;

                tsmiToAddBook.Enabled = true;
                tsmiToManageBook.Enabled = true;

                tsmiCreateCard.Enabled = true;
                tsmiManageCard.Enabled = true;

                tsmiSaleAccount.Enabled = true;

                tsmiToAddBook.Enabled = true;
            }


            else if (frmMain.user.RoleId == 3)
            {
                tsmiRoleManage.Enabled = true;

                tsmiAddUser.Enabled = true;
                tsmlSelectUser.Enabled = true;

                tsmiToAddBook.Enabled = true;
                tsmiToManageBook.Enabled = true;

                tsmiCreateCard.Enabled = true;
                tsmiManageCard.Enabled = true;

                tsmiSaleAccount.Enabled = true;

                tsmiToAddBook.Enabled = true;

            }
        }

        private void tsslUserInfo_Click(object sender, EventArgs e)
        {

        }

     

    }
}
