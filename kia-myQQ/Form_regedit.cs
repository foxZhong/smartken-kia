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
            { message = "�ǳƲ���Ϊ��"; return false; }
            else if (txtPwd.Text == "" || txtPwd.Text.Length < 6)
            { message = "���벻��Ϊ���ұ���Ϊ6λ���ֻ�Ӣ����ĸ"; return false; }
            else if (txtRePwd.Text != txtPwd.Text)
            { message = "����ƥ�����������¼��"; return false; }
            else
                return true;

        }

        public void addUser()
        {
            string str = string.Format("insert into Users values ('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}')",
                txtPwd.Text, "����", 3, txtID.Text, 2, rdoMale.Checked ? "��" : "Ů", int.Parse(txtAge.Text),
                txtName.Text, null, null, null);
            SqlCommand cmd = new SqlCommand(str, DBHelp.conn);
            DBHelp.conn.Open();
            int i = cmd.ExecuteNonQuery();
            if (i < 1)
                MessageBox.Show("��½ʧ��");
            else
                MessageBox.Show("��½�ɹ�");
            MessageBox.Show("daffa");
        }
    }
}