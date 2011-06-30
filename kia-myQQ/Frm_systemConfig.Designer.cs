namespace myQQ
{
    partial class Frm_systemConfig
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_systemConfig));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btnTest = new System.Windows.Forms.Button();
            this.txtDatabase = new System.Windows.Forms.TextBox();
            this.txtSever = new System.Windows.Forms.TextBox();
            this.btnConfirm = new System.Windows.Forms.Button();
            this.btnCancle = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.txtSQLPwd = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.txtSQLUser = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.rbbSQLLogin = new System.Windows.Forms.RadioButton();
            this.rbnWindowLogin = new System.Windows.Forms.RadioButton();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(23, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(65, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "数据服务器";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(47, 63);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "数据库";
            // 
            // btnTest
            // 
            this.btnTest.Location = new System.Drawing.Point(151, 179);
            this.btnTest.Name = "btnTest";
            this.btnTest.Size = new System.Drawing.Size(49, 23);
            this.btnTest.TabIndex = 4;
            this.btnTest.Text = "测试";
            this.btnTest.UseVisualStyleBackColor = true;
            this.btnTest.Click += new System.EventHandler(this.btnTest_Click);
            // 
            // txtDatabase
            // 
            this.txtDatabase.Location = new System.Drawing.Point(94, 60);
            this.txtDatabase.Name = "txtDatabase";
            this.txtDatabase.Size = new System.Drawing.Size(106, 21);
            this.txtDatabase.TabIndex = 3;
            this.txtDatabase.Text = "myQQ";
            // 
            // txtSever
            // 
            this.txtSever.Location = new System.Drawing.Point(94, 24);
            this.txtSever.Name = "txtSever";
            this.txtSever.Size = new System.Drawing.Size(106, 21);
            this.txtSever.TabIndex = 2;
            // 
            // btnConfirm
            // 
            this.btnConfirm.Location = new System.Drawing.Point(106, 235);
            this.btnConfirm.Name = "btnConfirm";
            this.btnConfirm.Size = new System.Drawing.Size(75, 23);
            this.btnConfirm.TabIndex = 4;
            this.btnConfirm.Text = "确认";
            this.btnConfirm.UseVisualStyleBackColor = true;
            this.btnConfirm.Click += new System.EventHandler(this.btnConfirm_Click);
            // 
            // btnCancle
            // 
            this.btnCancle.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancle.Location = new System.Drawing.Point(193, 235);
            this.btnCancle.Name = "btnCancle";
            this.btnCancle.Size = new System.Drawing.Size(75, 23);
            this.btnCancle.TabIndex = 5;
            this.btnCancle.Text = "取消";
            this.btnCancle.UseVisualStyleBackColor = true;
            this.btnCancle.Click += new System.EventHandler(this.btnCancle_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.txtSQLPwd);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.txtSQLUser);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.rbbSQLLogin);
            this.groupBox1.Controls.Add(this.rbnWindowLogin);
            this.groupBox1.Controls.Add(this.btnTest);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.txtDatabase);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.txtSever);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(256, 208);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "设置服务器";
            // 
            // txtSQLPwd
            // 
            this.txtSQLPwd.Location = new System.Drawing.Point(94, 152);
            this.txtSQLPwd.Name = "txtSQLPwd";
            this.txtSQLPwd.Size = new System.Drawing.Size(106, 21);
            this.txtSQLPwd.TabIndex = 10;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(56, 155);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(29, 12);
            this.label4.TabIndex = 9;
            this.label4.Text = "密码";
            // 
            // txtSQLUser
            // 
            this.txtSQLUser.Location = new System.Drawing.Point(94, 121);
            this.txtSQLUser.Name = "txtSQLUser";
            this.txtSQLUser.Size = new System.Drawing.Size(106, 21);
            this.txtSQLUser.TabIndex = 8;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(47, 124);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 7;
            this.label3.Text = "用户名";
            // 
            // rbbSQLLogin
            // 
            this.rbbSQLLogin.AutoSize = true;
            this.rbbSQLLogin.Location = new System.Drawing.Point(147, 96);
            this.rbbSQLLogin.Name = "rbbSQLLogin";
            this.rbbSQLLogin.Size = new System.Drawing.Size(89, 16);
            this.rbbSQLLogin.TabIndex = 6;
            this.rbbSQLLogin.Text = "SQL身份登陆";
            this.rbbSQLLogin.UseVisualStyleBackColor = true;
            this.rbbSQLLogin.CheckedChanged += new System.EventHandler(this.rbnWindowLogin_CheckedChanged);
            // 
            // rbnWindowLogin
            // 
            this.rbnWindowLogin.AutoSize = true;
            this.rbnWindowLogin.Checked = true;
            this.rbnWindowLogin.Location = new System.Drawing.Point(16, 96);
            this.rbnWindowLogin.Name = "rbnWindowLogin";
            this.rbnWindowLogin.Size = new System.Drawing.Size(113, 16);
            this.rbnWindowLogin.TabIndex = 5;
            this.rbnWindowLogin.TabStop = true;
            this.rbnWindowLogin.Text = "windows身份登陆";
            this.rbnWindowLogin.UseVisualStyleBackColor = true;
            this.rbnWindowLogin.CheckedChanged += new System.EventHandler(this.rbnWindowLogin_CheckedChanged);
            // 
            // Frm_systemConfig
            // 
            this.AcceptButton = this.btnConfirm;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.CancelButton = this.btnCancle;
            this.ClientSize = new System.Drawing.Size(289, 265);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnCancle);
            this.Controls.Add(this.btnConfirm);
            this.Name = "Frm_systemConfig";
            this.Text = "系统配置";
            this.Load += new System.EventHandler(this.Frm_systemConfig_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnTest;
        private System.Windows.Forms.TextBox txtDatabase;
        private System.Windows.Forms.TextBox txtSever;
        private System.Windows.Forms.Button btnConfirm;
        private System.Windows.Forms.Button btnCancle;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox txtSQLUser;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.RadioButton rbbSQLLogin;
        private System.Windows.Forms.RadioButton rbnWindowLogin;
        private System.Windows.Forms.TextBox txtSQLPwd;
        private System.Windows.Forms.Label label4;
    }
}