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
    public partial class Frm_systemConfig : Form
    {
        
        #region ����
        DBHelper db;    
        Frm_login parent;  //������
        SqlCommand cmd;
        string constr;    //���ݿ��������
        
        #endregion

        #region ���캯��
        public Frm_systemConfig(Frm_login f)
        {
            InitializeComponent();
            this.parent = f;
            this.db = f.db;
            this.txtSever.Text=ConfigHelper.getServerHost();
            this.txtDatabase.Text = ConfigHelper.getDbName();
        }
    #endregion

        #region �Զ��巽��

        //��������
        private void testConnection()
        {
            if (txtSever.Text.Trim() == "" || txtDatabase.Text.Trim() == "")
            {
                MessageBox.Show("�������������ݿ�������Ϊ��");
                return;
            }
            else
                if (rbnWindowLogin.Checked)
                {
                    constr = string.Format("data source={0};initial catalog={1};trusted_connection=true",
                        txtSever.Text.Trim(), txtDatabase.Text.Trim());
                    
                }
                else
                {
                    constr = string.Format("data source={0};initial catalog={1};User ID={2};Pwd={3}",
                        txtSever.Text.Trim(), txtDatabase.Text.Trim(),
                        txtSQLUser.Text.Trim(),txtSQLPwd.Text.Trim());
                }
            this.db.testConnetion(constr);
        }


        //�޸�����
        private void setConnection()
        {
            if (txtSever.Text.Trim() == "" || txtDatabase.Text.Trim() == "")
            {
                MessageBox.Show("�������������ݿ�������Ϊ��");
                return;
            }
            else
            {
                DialogResult resutl = MessageBox.Show("�Ƿ񱣴浱ǰ�޸ģ�", "��ʾ", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
                if (resutl == DialogResult.OK)
                    if (rbnWindowLogin.Checked)
                    {
                        constr = string.Format("data source={0};initial catalog={1};trusted_connection=true",
                            txtSever.Text.Trim(), txtDatabase.Text.Trim());

                    }
                    else
                    {
                        constr = string.Format("data source={0};initial catalog={1};User ID={2};Pwd={3}",
                            txtSever.Text.Trim(), txtDatabase.Text.Trim(),
                            txtSQLUser.Text.Trim(), txtSQLPwd.Text.Trim());
                    }
                this.db.setConnection(constr);
                ConfigHelper.setServerHost(txtSever.Text.Trim());
                ConfigHelper.setDbName(txtDatabase.Text.Trim());
            }
            this.Dispose();
        }
    #endregion

        #region �ؼ��¼�����

        //�������
        private void btnTest_Click(object sender, EventArgs e)
        {
            testConnection();

        }


        //���ȡ��
        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        //���ȷ��
        private void btnConfirm_Click(object sender, EventArgs e)
        {
            setConnection();
        }


        //��½��ݵ�ѡ��ť״̬�ı�
        private void rbnWindowLogin_CheckedChanged(object sender, EventArgs e)
        {
            txtSQLUser.Enabled = rbbSQLLogin.Checked;
            txtSQLPwd.Enabled = rbbSQLLogin.Checked;
        }


        //���촰��
        private void Frm_systemConfig_Load(object sender, EventArgs e)
        {
            rbnWindowLogin_CheckedChanged(sender, e);
        }
        #endregion
    }
}