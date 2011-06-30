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
    public partial class Frm_info : Form
    {
        Frm_main parent_main;
        Frm_systemMessage parent_systemMessage;
        Frm_addFriend parent_addFriend;
        Frm_chat parent_chat;
        Frm_groupManage parent_groupmemage;
        public int id,faceID;
        bool isEnable;
        public ImageList ilFace,ilFacethums;
        DBHelper db;
        SqlCommand cmd;
        SqlDataReader reader;
        string str;

        public Frm_info(Frm_main f,int id,bool isEnable)
        {
            InitializeComponent();
            this.parent_main = f;
            this.isEnable = isEnable;
            this.ilFace = f.ilFace;
            this.id = id;
            this.db = f.db;
        }

        public Frm_info(Frm_systemMessage f, int id, bool isEnable)
        {
            InitializeComponent();
            this.parent_systemMessage = f;
            this.isEnable = isEnable;
            this.ilFace = f.ilFace;
            this.id = id;
            this.db = f.db;
        }

        public Frm_info(Frm_addFriend f, int id, bool isEnable)
        {
            InitializeComponent();
            this.parent_addFriend = f;
            this.isEnable = isEnable;
            this.ilFace = f.ilFace;
            this.id = id;
            this.db = f.db;
        }

        public Frm_info(Frm_chat f, int id, bool isEnable)
        {
            InitializeComponent();
            this.parent_chat = f;
            this.isEnable = isEnable;
            this.ilFace =f.ilFace;
            this.id = id;
            this.db = f.db;
        }

        public Frm_info(Frm_groupManage f, int id, bool isEnable)
        {
            InitializeComponent();
            this.parent_groupmemage = f;
            this.isEnable= isEnable;
            this.ilFace = f.ilFace;
            this.id = id;
            this.db = f.db;
 
        }

        public void setFace()
        {
            picFace.Image = ilFace.Images[faceID];
        }

        public int findStarId()   //查询星座ID
        {
            if (cboStar.Text.Trim() != "")
            {
                str = string.Format("select id from Star where stat='{0}'", cboStar.Text);
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

        public int findBloodId()   //查询血型ID
        {
            if (cboBlood.Text.Trim() != "")
            {
                str = string.Format("select id from Bloodtype where bloodtype='{0}'", cboBlood.Text);
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

        private void Frm_info_Load(object sender, EventArgs e)
        {
            groupBox2.Hide();
            //添加星座
            db.con.Open();
            str = "select Stat from Star";
            cmd = new SqlCommand(str, db.con);
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
                cboStar.Items.Add(reader["stat"]);
            db.con.Close();

            //添加血型
            db.con.Open();
            str = "select BloodType from BloodType";
            cmd = new SqlCommand(str, db.con);
            reader = cmd.ExecuteReader();
            while (reader.Read())
                cboBlood.Items.Add(reader["BloodType"]);
            db.con.Close();


            reader = getResource(reader);
            setEnable();
        }

        private void setEnable()
        {
            txtName.Enabled = isEnable;
            txtUserID.Enabled = false;
            txtNickName.Enabled = isEnable;
            cboBlood.Enabled = isEnable;
            cboSex.Enabled = isEnable;
            cboStar.Enabled = isEnable;
            btnSelectFace.Visible = isEnable;
            nudAge.Enabled = isEnable;
            txtCity.Enabled = isEnable;
            txtEmail.Enabled = isEnable;
            txtMood.Enabled = isEnable;
            lblSafe.Enabled = isEnable;
        }

        private bool checkNotifyPwd()
        {
            if(txtOldPwd.Text==""&&txtNewPwd.Text==""&&txtReNewPwd.Text=="")
                return true;
            try
            {
                str=string.Format("select count(*) from users where id='{0}' and loginpwd='{1}'",id,txtOldPwd.Text);
                while(db.con.State!=ConnectionState.Closed);
                cmd=new SqlCommand(str,db.con);
                db.con.Open();
                if(((int)cmd.ExecuteScalar())<1)
                {
                    db.con.Close();
                    MessageBox.Show("原密码错误");
                    return false;
                }
                db.con.Close();
                if (txtNewPwd.Text.Length < 6 || txtReNewPwd.Text != txtReNewPwd.Text)
                {
                    MessageBox.Show("修改密码失败");
                    txtOldPwd.Clear();
                    txtNewPwd.Clear();
                    txtReNewPwd.Clear();
                    return false;
                }
                else
                {
                    db.con.Close();
                    str = string.Format("update users set loginpwd='{0}' where id='{1}'", txtNewPwd.Text,id);
                     while(db.con.State!=ConnectionState.Closed);
                     
                   cmd=new SqlCommand(str,db.con);
                   db.con.Open();
                   cmd.ExecuteNonQuery();
                   db.con.Close();
                    MessageBox.Show("修改密码成功");
                    return true;
                }
  
            }catch(Exception ex)
            {MessageBox.Show("error");}
            finally
            {db.con.Close();
            }
            return false;
          
        }

        private SqlDataReader getResource(SqlDataReader reader)
        {
            try
            {
                str = string.Format("select users.id,nickname,faceid,sex,age,name,bloodTypeid,stat,city,email,mood,friendshippolicyid" +
                    " from users,bloodtype,star" +
                    " where users.id='{0}' and starid=star.id and bloodTypeid=bloodtype.id", id);
                cmd = new SqlCommand(str, db.con);
                db.con.Open();
                reader = cmd.ExecuteReader();
                while (reader.Read())
                {
                    faceID = (int)reader["faceid"];
                    txtName.Text = reader["name"].ToString();
                    txtUserID.Text = reader["id"].ToString();
                    txtNickName.Text = reader["nickname"].ToString();
                    cboBlood.Text = reader["bloodtype"].ToString();
                    cboSex.Text = reader["sex"].ToString();
                    cboStar.Text = reader["stat"].ToString();
                    txtCity.Text = reader["city"].ToString();
                    txtEmail.Text = reader["email"].ToString();
                    txtMood.Text = reader["mood"].ToString();
                    nudAge.Value = (int)reader["age"];
                    picFace.Image = ilFace.Images[(int)reader["faceid"]];
                    //(int)reader["friendshippolicyid"] == 1 ? rbnFriendship1.Checked=true : (int)reader["friendshippolicyid"] == 2 ? rbnFriendship2.Checked=true : rbnFriendship3.Checked=true;

                }
            }
            catch (Exception ex)
            { MessageBox.Show("error"); }
            finally
            { db.con.Close(); }
            return reader;
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            if (!isEnable)
            { this.Dispose();
            return;
            }
            
            if (!checkNotifyPwd()) 
                return;
            else
                try
                {
                    DialogResult resutl = MessageBox.Show("是否保存当前修改？", "提示", MessageBoxButtons.OKCancel, MessageBoxIcon.Question);
                    if (resutl ==DialogResult.Cancel)
                        return;
                    
                    if(rbnFriendship1.Checked==false&&rbnFriendship2.Checked==false&&rbnFriendship3.Checked==false)
                        str = string.Format("update users set name='{0}',nickname='{1}',bloodtypeid='{2}'," +
                     "sex='{3}',starid='{4}',faceid='{5}',age='{6}',city='{7}',email='{8}',mood='{9}' where id='{10}'",
                     txtName.Text,//0
                     txtNickName.Text,//1
                     findBloodId(),//2
                     cboSex.Text,//3
                     findStarId(),//4
                     faceID,//5
                     (int)nudAge.Value,//6 
                     txtCity.Text,//7
                     txtEmail.Text,//8
                     txtMood.Text,//9
                     id//10
                     );
                        else
                        str = string.Format("update users set name='{0}',nickname='{1}',bloodtypeid='{2}'," +
                        "sex='{3}',starid='{4}',faceid='{5}',age='{6}',city='{7}',email='{8}',mood='{9}',friendshippolicyid='{10}' where id='{11}'",
                        txtName.Text,//0
                        txtNickName.Text,//1
                        findBloodId(),//2
                        cboSex.Text,//3
                        findStarId(),//4
                        faceID,//5
                        (int)nudAge.Value,//6 
                        txtCity.Text,//7
                        txtEmail.Text,//8
                        txtMood.Text,//9
                        rbnFriendship1.Checked?1:rbnFriendship2.Checked?2:3,
                        id//11
                        );
                    while (db.con.State != ConnectionState.Closed) ;
                    cmd = new SqlCommand(str, db.con);
                    db.con.Open();
                    if (cmd.ExecuteNonQuery() > 0)
                    {
                        db.con.Close();
                        MessageBox.Show("个人信息修改成功");
                    }
                }
                catch (Exception ex)
                { MessageBox.Show("error1"); }
                finally
                {
                    db.con.Close();
                    //parent.getResource();
                    this.Dispose();

                }
        
        }

        private void btnCancle_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnSelectFace_Click(object sender, EventArgs e)
        {
            Frm_selectImage f = new Frm_selectImage(this);
            f.ShowDialog();
        }

        private void lblinfo1_Click(object sender, EventArgs e)
        {
            groupBox1.Show();
            groupBox2.Hide();
            groupBoxSafe.Hide();
        }

        private void lblinfo2_Click(object sender, EventArgs e)
        {
            groupBox2.Show();
            groupBox1.Hide();
            groupBoxSafe.Hide();
        }

        private void lbl_mouseHoverColor(object sender, EventArgs e)
        {
            ((Label)sender).ForeColor = Color.Red;
        }

        private void lbl_mouseReleaseColor(object sender, EventArgs e)
        {
            ((Label)sender).ForeColor = Color.Black;
        }

        private void lblSafe_Click(object sender, EventArgs e)
        {
            groupBox1.Hide();
            groupBox2.Hide();
            groupBoxSafe.Show();
        }
      
        
    }
}