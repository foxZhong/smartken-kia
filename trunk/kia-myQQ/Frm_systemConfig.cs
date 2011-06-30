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
        
        #region 属性
        DBHelper db;    
        Frm_login parent;  //父窗口
        SqlCommand cmd;
        string constr;    //数据库连接语句
        
        #endregion

        #region 构造函数
        public Frm_systemConfig(Frm_login f)
        {
            InitializeComponent();
            this.parent = f;
            this.db = f.db;
            this.txtSever.Text=ConfigHelper.getServerHost();
            this.txtDatabase.Text = ConfigHelper.getDbName();
        }
    #endregion

        #region 自定义方法

        //测试连接
        private void testConnection()
        {
            if (txtSever.Text.Trim() == "" || txtDatabase.Text.Trim() == "")
            {
                MessageBox.Show("服务器名和数据库名不能为空");
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


        //修改连接
        private void setConnection()
        {
            if (txtSever.Text.Trim() == "" || txtDatabase.Text.Trim() == "")
            {
                MessageBox.Show("服务器名和数据库名不能为空");
                return;
            }
            else
            {
                DialogResult resutl = MessageBox.Show("是否保存当前修改？", "提示", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
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

        #region 控件事件方法

        //点击测试
        private void btnTest_Click(object sender, EventArgs e)
        {
            testConnection();

        }


        //点击取消
        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        //点击确认
        private void btnConfirm_Click(object sender, EventArgs e)
        {
            setConnection();
        }


        //登陆身份单选按钮状态改变
        private void rbnWindowLogin_CheckedChanged(object sender, EventArgs e)
        {
            txtSQLUser.Enabled = rbbSQLLogin.Checked;
            txtSQLPwd.Enabled = rbbSQLLogin.Checked;
        }


        //构造窗口
        private void Frm_systemConfig_Load(object sender, EventArgs e)
        {
            rbnWindowLogin_CheckedChanged(sender, e);
        }
        #endregion
    }
}