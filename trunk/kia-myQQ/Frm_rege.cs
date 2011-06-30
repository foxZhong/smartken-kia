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
    public partial class Frm_rege : Form
    {
        string str = "";
        private Frm_login parent;
        SqlCommand cmd;
        SqlDataReader reader;
        private ImageList ilface;
        public int imageID;
        public int code;
        public DBHelper db;
        private Random random = new Random();
        public Frm_rege(Frm_login f)
        {
            InitializeComponent();
            label12.ForeColor = Color.Red;
            btnPre.Hide();
            this.parent = f;
            this.ilface = f.getImageList();
            picbimage.Image = ilface.Images[0];
            this.db = f.db;
            getnewCode();

            
        }

        private void getnewCode()
        {
            int code = random.Next(999) + 1000;
            txtIdentify.Text = code.ToString();
        }

        public void setImage()
        {
            picbimage.Image = ilface.Images[imageID];
        }

        public ImageList getImageList()
        {
            return this.ilface;
        }
    

        public int findStarId()   //��ѯ����ID
        {
            if (cobStar.Text.Trim() != "")
            {
                str = string.Format("select id from Star where stat='{0}'", cobStar.Text);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                reader.Read();
                int id = int.Parse(reader["id"].ToString());
                db.con.Close();
                return id;
            }
            else
                return 1;
        }

        public int findBloodId()   //��ѯѪ��ID
        {
            if (cobBlood.Text.Trim() != "")
            {
                str = string.Format("select id from Bloodtype where bloodtype='{0}'", cobBlood.Text);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                reader.Read();
                int id = int.Parse(reader["id"].ToString());
                db.con.Close();
                return id;
            }
            else
                return 1;
        }

        public int findQuestionId()   //��ѯ����ID
        {
            if (cobStar.Text.Trim() != "")
            {
                str = string.Format("select id from question where question='{0}'", cboQuestion.Text);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                reader.Read();
                int id = int.Parse(reader["id"].ToString());
                db.con.Close();
                return id;
            }
            else
                return 1;
        }

        private void buttonNext_Click(object sender, EventArgs e)
        {
            groupBox1.Hide();
            groupBox2.Show();

            label12.ForeColor = Color.Black;
            label13.ForeColor = Color.Red;
            btnPre.Show();
            btnNext.Hide();
        }

        private void buttonPre_Click(object sender, EventArgs e)
        {
            groupBox1.Show();
            groupBox2.Hide();
            
            label13.ForeColor = Color.Black;
            label12.ForeColor = Color.Red;
            btnPre.Hide();
            btnNext.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.parent.Show();
            this.Dispose();
        }

        private void Frm_rege_Load(object sender, EventArgs e)
        {
            try
            {  
                //�������
                db.con.Open();
                str = "select Stat from Star";
                cmd = new SqlCommand(str, db.con);
                SqlDataReader reader = cmd.ExecuteReader();
                while (reader.Read())
                    cobStar.Items.Add(reader["stat"]);
                db.con.Close();

                //���Ѫ��
                db.con.Open();
                str = "select BloodType from BloodType";
                cmd = new SqlCommand(str, db.con);
                reader = cmd.ExecuteReader();
                while (reader.Read())
                    cobBlood.Items.Add(reader["BloodType"]);
                db.con.Close();

                //�������
                db.con.Open();
                str = "select question from question";
                cmd = new SqlCommand(str, db.con);
                reader = cmd.ExecuteReader();
                while (reader.Read())cboQuestion.Items.Add(reader["Question"]);
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            {db.con.Close();}
        }

        private bool checkLogin()
        {
            if (txtNickname.Text == "")
                txtNickname.Text = " ";
            if (txtPwd.Text.Length<6)
            { MessageBox.Show("�û����벻��Ϊ�ջ�����6��Ӣ����ĸ������"); txtPwd.Clear(); return false; }
            else if (txtPwd.Text != txtRepwd.Text)
            { MessageBox.Show("�ظ�������ԭ���벻ƥ�䣬����������"); txtRepwd.Clear(); return false; }
            else if (cboQuestion.Text == ""||txtAnswer.Text=="")
            { MessageBox.Show("��ѡ�����Ⲣ������ʾ�𰸣�ͨ���𰸿ɰ����������һ�����"); return false; }
            else if (txtIdentify.Text.Trim() != txtInputIdentify.Text.Trim())
            { MessageBox.Show("��֤�����"); txtInputIdentify.Clear(); txtInputIdentify.Focus();
            getnewCode(); txtPwd.Clear(); txtRepwd.Clear(); return false;
        }
            return true;
        }

        private void adduser()
        {
            str = string.Format("insert into Users (loginpwd,friendshippolicyid,nickname,faceid,sex,age,name,stat,bloodtype,email,questionid,city,mood,answer,userstateid)  values " +
                        "('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}','{14}')",
                    txtPwd.Text,//0  ����
                    1,//1 ��Ӻ���ѡ��
                    txtNickname.Text,//2  �û��ǳ�
                    imageID,//3  ����
                    raoMale.Checked?"��":"Ů",//4  �Ա�
                    (int)nudAge.Value,//5   ����
                    txtName.Text,//6  ��ʵ����
                    findStarId(),//7  ����
                    findBloodId(),//8  Ѫ��
                    txtEmail.Text,//9  Email
                    findQuestionId(),//10 ��ʾ����
                    txtCity.Text,//11 ����
                    "�ոտ�ͨ���Լ���Q�ţ��濪��",  //12����
                    txtAnswer.Text,   //13�����
                    4   //14  �û�״̬
                    );
            cmd = new SqlCommand(str, db.con);
            db.con.Open();
            int i = (int)cmd.ExecuteNonQuery();
            if (i!=1) 
            {
                MessageBox.Show("error");
            }
            else
            {
                MessageBox.Show("��Ϣ�ѳɹ��ύ������");
            }
            db.con.Close();
            //parent.Show();
            //this.Dispose();
        }


        private void button1_Click(object sender, EventArgs e)
        {
            if (checkLogin())
            {
                adduser();
                groupBox1.Hide();
                groupBox2.Hide();
                groupBox4.Show();
                btnCancle.Hide();
                btnNext.Hide();
                btnPre.Hide();
                btnConfirm.Show();
                btnReg.Hide();
                label12.ForeColor = Color.Black;
                label13.ForeColor = Color.Black;
                label15.ForeColor = Color.Red;
                try
                {
                    str = string.Format("select top 1 id,nickname  from users order by id desc");
                    cmd = new SqlCommand(str, db.con);
                    db.con.Open();
                    reader = cmd.ExecuteReader();
                    while (reader.Read())
                    {
                        lblID.Text = reader["id"].ToString();
                        lblNickName.Text = reader["nickname"].ToString();;
                    }
                }
                catch (Exception ex)
                { MessageBox.Show("error"); }
                finally
                { db.con.Close(); }
            }
        }

        private void btnSelectFace_Click(object sender, EventArgs e)
        {
            Frm_selectImage f = new Frm_selectImage(this);
            f.ShowDialog();
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            this.Dispose();
            parent.Show();
        }
    }
}