namespace myQQ
{
    partial class Frm_login
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_login));
            this.txtNom = new System.Windows.Forms.TextBox();
            this.txtPwd = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lblrege = new System.Windows.Forms.Label();
            this.lblPwd = new System.Windows.Forms.Label();
            this.btnLogin = new System.Windows.Forms.Button();
            this.btnCancle = new System.Windows.Forms.Button();
            this.chbHide = new System.Windows.Forms.CheckBox();
            this.ilFace = new System.Windows.Forms.ImageList(this.components);
            this.lblConfig = new System.Windows.Forms.Label();
            this.ilFaceThums = new System.Windows.Forms.ImageList(this.components);
            this.SuspendLayout();
            // 
            // txtNom
            // 
            this.txtNom.Location = new System.Drawing.Point(102, 68);
            this.txtNom.Name = "txtNom";
            this.txtNom.Size = new System.Drawing.Size(100, 21);
            this.txtNom.TabIndex = 0;
            this.txtNom.Text = "10006";
            // 
            // txtPwd
            // 
            this.txtPwd.Location = new System.Drawing.Point(102, 98);
            this.txtPwd.Name = "txtPwd";
            this.txtPwd.PasswordChar = '*';
            this.txtPwd.Size = new System.Drawing.Size(100, 21);
            this.txtPwd.TabIndex = 1;
            this.txtPwd.Text = "123456";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Location = new System.Drawing.Point(40, 71);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 2;
            this.label1.Text = "QQ号码";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Location = new System.Drawing.Point(40, 101);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 3;
            this.label2.Text = "QQ密码";
            // 
            // lblrege
            // 
            this.lblrege.AutoSize = true;
            this.lblrege.BackColor = System.Drawing.Color.Transparent;
            this.lblrege.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblrege.Location = new System.Drawing.Point(217, 71);
            this.lblrege.Name = "lblrege";
            this.lblrege.Size = new System.Drawing.Size(53, 12);
            this.lblrege.TabIndex = 4;
            this.lblrege.Text = "申请号码";
            this.lblrege.MouseLeave += new System.EventHandler(this.lblrege_MouseLeave);
            this.lblrege.MouseClick += new System.Windows.Forms.MouseEventHandler(this.lblrege_MouseClick);
            this.lblrege.MouseHover += new System.EventHandler(this.lblrege_MouseHover);
            // 
            // lblPwd
            // 
            this.lblPwd.AutoSize = true;
            this.lblPwd.BackColor = System.Drawing.Color.Transparent;
            this.lblPwd.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblPwd.Location = new System.Drawing.Point(217, 101);
            this.lblPwd.Name = "lblPwd";
            this.lblPwd.Size = new System.Drawing.Size(53, 12);
            this.lblPwd.TabIndex = 5;
            this.lblPwd.Text = "忘记密码";
            this.lblPwd.MouseLeave += new System.EventHandler(this.lblrege_MouseLeave);
            this.lblPwd.Click += new System.EventHandler(this.lblPwd_Click);
            this.lblPwd.MouseHover += new System.EventHandler(this.lblrege_MouseHover);
            // 
            // btnLogin
            // 
            this.btnLogin.BackColor = System.Drawing.Color.Transparent;
            this.btnLogin.Location = new System.Drawing.Point(138, 156);
            this.btnLogin.Name = "btnLogin";
            this.btnLogin.Size = new System.Drawing.Size(75, 23);
            this.btnLogin.TabIndex = 6;
            this.btnLogin.Text = "登录";
            this.btnLogin.UseVisualStyleBackColor = false;
            this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
            // 
            // btnCancle
            // 
            this.btnCancle.BackColor = System.Drawing.Color.Transparent;
            this.btnCancle.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancle.Location = new System.Drawing.Point(219, 156);
            this.btnCancle.Name = "btnCancle";
            this.btnCancle.Size = new System.Drawing.Size(75, 23);
            this.btnCancle.TabIndex = 7;
            this.btnCancle.Text = "取消";
            this.btnCancle.UseVisualStyleBackColor = false;
            this.btnCancle.Click += new System.EventHandler(this.btnCancle_Click);
            // 
            // chbHide
            // 
            this.chbHide.AutoSize = true;
            this.chbHide.BackColor = System.Drawing.Color.Transparent;
            this.chbHide.Location = new System.Drawing.Point(102, 125);
            this.chbHide.Name = "chbHide";
            this.chbHide.Size = new System.Drawing.Size(72, 16);
            this.chbHide.TabIndex = 8;
            this.chbHide.Text = "隐身登录";
            this.chbHide.UseVisualStyleBackColor = false;
            // 
            // ilFace
            // 
            this.ilFace.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("ilFace.ImageStream")));
            this.ilFace.TransparentColor = System.Drawing.Color.Transparent;
            this.ilFace.Images.SetKeyName(0, "");
            this.ilFace.Images.SetKeyName(1, "");
            this.ilFace.Images.SetKeyName(2, "");
            this.ilFace.Images.SetKeyName(3, "");
            this.ilFace.Images.SetKeyName(4, "");
            this.ilFace.Images.SetKeyName(5, "");
            this.ilFace.Images.SetKeyName(6, "");
            this.ilFace.Images.SetKeyName(7, "");
            this.ilFace.Images.SetKeyName(8, "");
            this.ilFace.Images.SetKeyName(9, "");
            this.ilFace.Images.SetKeyName(10, "");
            this.ilFace.Images.SetKeyName(11, "");
            this.ilFace.Images.SetKeyName(12, "");
            this.ilFace.Images.SetKeyName(13, "");
            this.ilFace.Images.SetKeyName(14, "");
            this.ilFace.Images.SetKeyName(15, "");
            this.ilFace.Images.SetKeyName(16, "");
            this.ilFace.Images.SetKeyName(17, "");
            this.ilFace.Images.SetKeyName(18, "");
            this.ilFace.Images.SetKeyName(19, "");
            this.ilFace.Images.SetKeyName(20, "");
            this.ilFace.Images.SetKeyName(21, "");
            this.ilFace.Images.SetKeyName(22, "");
            this.ilFace.Images.SetKeyName(23, "");
            this.ilFace.Images.SetKeyName(24, "");
            this.ilFace.Images.SetKeyName(25, "");
            this.ilFace.Images.SetKeyName(26, "");
            this.ilFace.Images.SetKeyName(27, "");
            this.ilFace.Images.SetKeyName(28, "");
            this.ilFace.Images.SetKeyName(29, "");
            this.ilFace.Images.SetKeyName(30, "");
            this.ilFace.Images.SetKeyName(31, "");
            this.ilFace.Images.SetKeyName(32, "");
            this.ilFace.Images.SetKeyName(33, "");
            this.ilFace.Images.SetKeyName(34, "");
            this.ilFace.Images.SetKeyName(35, "");
            this.ilFace.Images.SetKeyName(36, "");
            this.ilFace.Images.SetKeyName(37, "");
            this.ilFace.Images.SetKeyName(38, "");
            this.ilFace.Images.SetKeyName(39, "");
            this.ilFace.Images.SetKeyName(40, "");
            this.ilFace.Images.SetKeyName(41, "");
            this.ilFace.Images.SetKeyName(42, "");
            this.ilFace.Images.SetKeyName(43, "");
            this.ilFace.Images.SetKeyName(44, "");
            this.ilFace.Images.SetKeyName(45, "");
            this.ilFace.Images.SetKeyName(46, "");
            this.ilFace.Images.SetKeyName(47, "");
            this.ilFace.Images.SetKeyName(48, "");
            this.ilFace.Images.SetKeyName(49, "");
            this.ilFace.Images.SetKeyName(50, "");
            this.ilFace.Images.SetKeyName(51, "");
            this.ilFace.Images.SetKeyName(52, "");
            this.ilFace.Images.SetKeyName(53, "");
            this.ilFace.Images.SetKeyName(54, "");
            this.ilFace.Images.SetKeyName(55, "");
            this.ilFace.Images.SetKeyName(56, "");
            this.ilFace.Images.SetKeyName(57, "");
            this.ilFace.Images.SetKeyName(58, "");
            this.ilFace.Images.SetKeyName(59, "");
            this.ilFace.Images.SetKeyName(60, "");
            this.ilFace.Images.SetKeyName(61, "");
            this.ilFace.Images.SetKeyName(62, "");
            this.ilFace.Images.SetKeyName(63, "");
            this.ilFace.Images.SetKeyName(64, "");
            this.ilFace.Images.SetKeyName(65, "");
            this.ilFace.Images.SetKeyName(66, "bar_sbuddy.ico");
            this.ilFace.Images.SetKeyName(67, "MessageReading.gif");
            this.ilFace.Images.SetKeyName(68, "bar_QQ.ico");
            this.ilFace.Images.SetKeyName(69, "Button_desktx_010.png");
            this.ilFace.Images.SetKeyName(70, "Button_desktx_007.png");
            this.ilFace.Images.SetKeyName(71, "Button_desktx_003.png");
            this.ilFace.Images.SetKeyName(72, "orbino_icon_pack_008.png");
            // 
            // lblConfig
            // 
            this.lblConfig.AutoSize = true;
            this.lblConfig.BackColor = System.Drawing.Color.Transparent;
            this.lblConfig.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblConfig.Location = new System.Drawing.Point(217, 125);
            this.lblConfig.Name = "lblConfig";
            this.lblConfig.Size = new System.Drawing.Size(53, 12);
            this.lblConfig.TabIndex = 9;
            this.lblConfig.Text = "高级设置";
            this.lblConfig.MouseLeave += new System.EventHandler(this.lblrege_MouseLeave);
            this.lblConfig.Click += new System.EventHandler(this.lblConfig_Click);
            this.lblConfig.MouseHover += new System.EventHandler(this.lblrege_MouseHover);
            // 
            // ilFaceThums
            // 
            this.ilFaceThums.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("ilFaceThums.ImageStream")));
            this.ilFaceThums.TransparentColor = System.Drawing.Color.Transparent;
            this.ilFaceThums.Images.SetKeyName(0, "");
            this.ilFaceThums.Images.SetKeyName(1, "");
            this.ilFaceThums.Images.SetKeyName(2, "");
            this.ilFaceThums.Images.SetKeyName(3, "");
            this.ilFaceThums.Images.SetKeyName(4, "");
            this.ilFaceThums.Images.SetKeyName(5, "");
            this.ilFaceThums.Images.SetKeyName(6, "");
            this.ilFaceThums.Images.SetKeyName(7, "");
            this.ilFaceThums.Images.SetKeyName(8, "");
            this.ilFaceThums.Images.SetKeyName(9, "");
            this.ilFaceThums.Images.SetKeyName(10, "");
            this.ilFaceThums.Images.SetKeyName(11, "");
            this.ilFaceThums.Images.SetKeyName(12, "");
            this.ilFaceThums.Images.SetKeyName(13, "");
            this.ilFaceThums.Images.SetKeyName(14, "");
            this.ilFaceThums.Images.SetKeyName(15, "");
            this.ilFaceThums.Images.SetKeyName(16, "");
            this.ilFaceThums.Images.SetKeyName(17, "");
            this.ilFaceThums.Images.SetKeyName(18, "");
            this.ilFaceThums.Images.SetKeyName(19, "");
            this.ilFaceThums.Images.SetKeyName(20, "");
            this.ilFaceThums.Images.SetKeyName(21, "");
            this.ilFaceThums.Images.SetKeyName(22, "");
            this.ilFaceThums.Images.SetKeyName(23, "");
            this.ilFaceThums.Images.SetKeyName(24, "");
            this.ilFaceThums.Images.SetKeyName(25, "");
            this.ilFaceThums.Images.SetKeyName(26, "");
            this.ilFaceThums.Images.SetKeyName(27, "");
            this.ilFaceThums.Images.SetKeyName(28, "");
            this.ilFaceThums.Images.SetKeyName(29, "");
            this.ilFaceThums.Images.SetKeyName(30, "");
            this.ilFaceThums.Images.SetKeyName(31, "");
            this.ilFaceThums.Images.SetKeyName(32, "");
            this.ilFaceThums.Images.SetKeyName(33, "");
            this.ilFaceThums.Images.SetKeyName(34, "");
            this.ilFaceThums.Images.SetKeyName(35, "");
            this.ilFaceThums.Images.SetKeyName(36, "");
            this.ilFaceThums.Images.SetKeyName(37, "");
            this.ilFaceThums.Images.SetKeyName(38, "");
            this.ilFaceThums.Images.SetKeyName(39, "");
            this.ilFaceThums.Images.SetKeyName(40, "");
            this.ilFaceThums.Images.SetKeyName(41, "");
            this.ilFaceThums.Images.SetKeyName(42, "");
            this.ilFaceThums.Images.SetKeyName(43, "");
            this.ilFaceThums.Images.SetKeyName(44, "");
            this.ilFaceThums.Images.SetKeyName(45, "");
            this.ilFaceThums.Images.SetKeyName(46, "");
            this.ilFaceThums.Images.SetKeyName(47, "");
            this.ilFaceThums.Images.SetKeyName(48, "");
            this.ilFaceThums.Images.SetKeyName(49, "");
            this.ilFaceThums.Images.SetKeyName(50, "");
            this.ilFaceThums.Images.SetKeyName(51, "");
            this.ilFaceThums.Images.SetKeyName(52, "");
            this.ilFaceThums.Images.SetKeyName(53, "");
            this.ilFaceThums.Images.SetKeyName(54, "");
            this.ilFaceThums.Images.SetKeyName(55, "");
            this.ilFaceThums.Images.SetKeyName(56, "");
            this.ilFaceThums.Images.SetKeyName(57, "");
            this.ilFaceThums.Images.SetKeyName(58, "");
            this.ilFaceThums.Images.SetKeyName(59, "");
            this.ilFaceThums.Images.SetKeyName(60, "");
            this.ilFaceThums.Images.SetKeyName(61, "");
            this.ilFaceThums.Images.SetKeyName(62, "");
            this.ilFaceThums.Images.SetKeyName(63, "");
            this.ilFaceThums.Images.SetKeyName(64, "");
            this.ilFaceThums.Images.SetKeyName(65, "");
            this.ilFaceThums.Images.SetKeyName(66, "bar_sbuddy.ico");
            this.ilFaceThums.Images.SetKeyName(67, "MessageReading.gif");
            this.ilFaceThums.Images.SetKeyName(68, "bar_QQ.ico");
            this.ilFaceThums.Images.SetKeyName(69, "Button_desktx_010.png");
            this.ilFaceThums.Images.SetKeyName(70, "Button_desktx_007.png");
            this.ilFaceThums.Images.SetKeyName(71, "Button_desktx_003.png");
            this.ilFaceThums.Images.SetKeyName(72, "TTButton.png");
            // 
            // Frm_login
            // 
            this.AcceptButton = this.btnLogin;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.CancelButton = this.btnCancle;
            this.ClientSize = new System.Drawing.Size(305, 186);
            this.Controls.Add(this.lblConfig);
            this.Controls.Add(this.chbHide);
            this.Controls.Add(this.btnCancle);
            this.Controls.Add(this.btnLogin);
            this.Controls.Add(this.lblPwd);
            this.Controls.Add(this.lblrege);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtPwd);
            this.Controls.Add(this.txtNom);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.MaximizeBox = false;
            this.Name = "Frm_login";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "QQ登录";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtNom;
        private System.Windows.Forms.TextBox txtPwd;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label lblrege;
        private System.Windows.Forms.Label lblPwd;
        private System.Windows.Forms.Button btnLogin;
        private System.Windows.Forms.Button btnCancle;
        private System.Windows.Forms.CheckBox chbHide;
        private System.Windows.Forms.ImageList ilFace;
        private System.Windows.Forms.Label lblConfig;
        private System.Windows.Forms.ImageList ilFaceThums;

    }
}

