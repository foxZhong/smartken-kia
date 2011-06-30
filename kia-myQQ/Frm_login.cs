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
       
        #region ����

        string str;        //��ѯ���
        public int hostID;   //��½ID
        public int hostStateID;   //��½״̬
        SqlCommand cmd;
        public DBHelper db;      //���ݿ��������
        SqlDataReader reader;

        #endregion

        #region ���캯��

        public Frm_login()
        {
            InitializeComponent();
            //DBHelper.con.Open();
            //MessageBox.Show("OK");
            db = new DBHelper();    //�������ݿ��������
            
        }

        #endregion

        #region �Զ��巽��

        //������
        public bool checkLogin()    
        {
            if (txtNom.Text == "")
            {
                MessageBox.Show("QQ���벻��Ϊ��"); return false;
            }
            else if (txtPwd.Text == "")
            {
                MessageBox.Show("QQ���벻��Ϊ��"); return false;
            }
            try
            {
                str = string.Format("select count(*) from users where id='{0}'and loginPwd='{1}'", int.Parse(txtNom.Text), txtPwd.Text);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();

                if ((int)cmd.ExecuteScalar() > 0)
                { hostID = int.Parse(txtNom.Text); return true; }
                else
                { MessageBox.Show("������󣬻����˺Ų�����"); txtPwd.Clear(); txtPwd.Focus(); return false; }
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
            return false;

        }

        //��ȡͷ���б�
        public ImageList getImageList()   
        {
            return this.ilFace;
        }

        //��ȡ����ͼ�б�
        public ImageList getImageListThums()   
        {
            return this.ilFaceThums;
        }

        //��½
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
                MessageBox.Show("�������������ط���½");
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
        
        #region �ؼ��¼�����

        //���ȡ����ť
        private void btnCancle_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        //����߼�����
        private void lblConfig_Click(object sender, EventArgs e)
        {
            Frm_systemConfig f = new Frm_systemConfig(this);
            f.ShowDialog();
        }

        //�����������
        private void lblPwd_Click(object sender, EventArgs e)
        {
            Frm_findpwd f = new Frm_findpwd(this);
            f.Show();
        }

        //������
        private void lblrege_MouseHover(object sender, EventArgs e)
        {
            ((Label)sender).ForeColor = Color.Red;

        }

        //����뿪
        private void lblrege_MouseLeave(object sender, EventArgs e)
        {
            ((Label)sender).ForeColor = Color.Black;
        }

        //����������
        private void lblrege_MouseClick(object sender, MouseEventArgs e)
        {
            Frm_rege f = new Frm_rege(this);
            this.Hide();
            f.Show();
        }

        //�����½��ť
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