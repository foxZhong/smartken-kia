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
    public partial class Frm_login : Form
    {
       
        #region 属性

        string str;        //查询语句
        public int hostID;   //登陆ID
        public int hostStateID;   //登陆状态
        SqlCommand cmd;
        public DBHelper db;      //数据库操作对象
        SqlDataReader reader;

        #endregion

        #region 构造函数

        public Frm_login()
        {
            InitializeComponent();
            //DBHelper.con.Open();
            //MessageBox.Show("OK");
            db = new DBHelper();    //创建数据库操作对象
            
        }

        #endregion

        #region 自定义方法

        //输入检测
        public bool checkLogin()    
        {
            if (txtNom.Text == "")
            {
                MessageBox.Show("QQ号码不能为空"); return false;
            }
            else if (txtPwd.Text == "")
            {
                MessageBox.Show("QQ密码不能为空"); return false;
            }
            try
            {
                str = string.Format("select count(*) from users where id='{0}'and loginPwd='{1}'", int.Parse(txtNom.Text), txtPwd.Text);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();

                if ((int)cmd.ExecuteScalar() > 0)
                { hostID = int.Parse(txtNom.Text); return true; }
                else
                { MessageBox.Show("密码错误，或者账号不存在"); txtPwd.Clear(); txtPwd.Focus(); return false; }
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
            return false;

        }

        //获取头像列表
        public ImageList getImageList()   
        {
            return this.ilFace;
        }

        //获取缩略图列表
        public ImageList getImageListThums()   
        {
            return this.ilFaceThums;
        }

        //登陆
        private bool login()
        {
            try
            {
                str = string.Format("select count(*) from users where id='{0}' and userstateid=4 ", hostID);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                //reader = cmd.ExecuteReader();
                int i = (int)cmd.ExecuteScalar();
                if (i>0)
                {
                    db.con.Close();
                    hostStateID = chbHide.Checked ? 3 : 1;
                    str = string.Format("update users set userstateid='{0}'  where id='{1}'",
                       hostStateID, hostID);
                    cmd = new SqlCommand(str, db.con);
                    db.con.Open();
                    cmd.ExecuteNonQuery();
                    return true;
                }
                else
                { db.con.Close();
                MessageBox.Show("该用已在其他地方登陆");
                return false;
            }
            }
            catch (Exception ex)
            {
                MessageBox.Show("error:login");
            }
            finally
            {
                db.con.Close();
            }
            return false;
        }

        #endregion
        
        #region 控件事件方法

        //点击取消按钮
        private void btnCancle_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        //点击高级设置
        private void lblConfig_Click(object sender, EventArgs e)
        {
            Frm_systemConfig f = new Frm_systemConfig(this);
            f.ShowDialog();
        }

        //点击忘记密码
        private void lblPwd_Click(object sender, EventArgs e)
        {
            Frm_findpwd f = new Frm_findpwd(this);
            f.Show();
        }

        //鼠标进入
        private void lblrege_MouseHover(object sender, EventArgs e)
        {
            ((Label)sender).ForeColor = Color.Red;

        }

        //鼠标离开
        private void lblrege_MouseLeave(object sender, EventArgs e)
        {
            ((Label)sender).ForeColor = Color.Black;
        }

        //点击申请号码
        private void lblrege_MouseClick(object sender, MouseEventArgs e)
        {
            Frm_rege f = new Frm_rege(this);
            this.Hide();
            f.Show();
        }

        //点击登陆按钮
        private void btnLogin_Click(object sender, EventArgs e)
        {
            if (checkLogin())
            {
                if (login())
                {
                    Frm_main f = new Frm_main(this);
                    this.Hide();
                    f.Show();
                }
            }
        }

        #endregion

    }
}