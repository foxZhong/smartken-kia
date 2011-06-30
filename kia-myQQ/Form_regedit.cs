using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace MyQQ
{
    public partial class Form_regedit : Form
    {
        public Form_regedit()
        {
            InitializeComponent();
        }

        private void bntFinish_Click(object sender, EventArgs e)
        {
            string message = "";
            if (!hanldInput(ref message))
                MessageBox.Show(message);
            addUser();

        }

        public bool hanldInput(ref string message)
        {
            if (txtNickname.Text == "")
            { message = "昵称不能为空"; return false; }
            else if (txtPwd.Text == "" || txtPwd.Text.Length < 6)
            { message = "密码不能为空且必需为6位数字或英文字母"; return false; }
            else if (txtRePwd.Text != txtPwd.Text)
            { message = "密码匹配有误，请重新检查"; return false; }
            else
                return true;

        }

        public void addUser()
        {
            string str = string.Format("insert into Users values ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}')",
                txtPwd.Text, "上线", 3, txtID.Text, 2, rdoMale.Checked ? "男" : "女", int.Parse(txtAge.Text),
                txtName.Text, null, null, null);
            SqlCommand cmd = new SqlCommand(str, DBHelp.conn);
            DBHelp.conn.Open();
            int i = cmd.ExecuteNonQuery();
            if (i < 1)
                MessageBox.Show("登陆失败");
            else
                MessageBox.Show("登陆成功");
            MessageBox.Show("daffa");
        }
    }
}