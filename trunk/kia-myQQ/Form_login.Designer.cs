namespace MyQQ
{
    partial class Form_login
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
            this.panel1 = new System.Windows.Forms.Panel();
            this.comboBox3 = new System.Windows.Forms.ComboBox();
            this.enter = new System.Windows.Forms.CheckBox();
            this.lblQQ5 = new System.Windows.Forms.Label();
            this.lblpwd = new System.Windows.Forms.Label();
            this.lblLogin = new System.Windows.Forms.Label();
            this.comboBox2 = new System.Windows.Forms.ComboBox();
            this.cboAccounts = new System.Windows.Forms.ComboBox();
            this.lblQQ2 = new System.Windows.Forms.Label();
            this.lblQQ1 = new System.Windows.Forms.Label();
            this.btoEnter = new System.Windows.Forms.Button();
            this.btoCancel = new System.Windows.Forms.Button();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.comboBox3);
            this.panel1.Controls.Add(this.enter);
            this.panel1.Controls.Add(this.lblQQ5);
            this.panel1.Controls.Add(this.lblpwd);
            this.panel1.Controls.Add(this.lblLogin);
            this.panel1.Controls.Add(this.comboBox2);
            this.panel1.Controls.Add(this.cboAccounts);
            this.panel1.Controls.Add(this.lblQQ2);
            this.panel1.Controls.Add(this.lblQQ1);
            this.panel1.Location = new System.Drawing.Point(12, 54);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(331, 130);
            this.panel1.TabIndex = 0;
            // 
            // comboBox3
            // 
            this.comboBox3.FormattingEnabled = true;
            this.comboBox3.Items.AddRange(new object[] {
            "在线",
            "Q我吧",
            "忙碌",
            "离开",
            "静音",
            "隐身"});
            this.comboBox3.Location = new System.Drawing.Point(114, 101);
            this.comboBox3.Name = "comboBox3";
            this.comboBox3.Size = new System.Drawing.Size(63, 21);
            this.comboBox3.TabIndex = 8;
            this.comboBox3.Text = "在线";
            // 
            // enter
            // 
            this.enter.AutoSize = true;
            this.enter.Location = new System.Drawing.Point(183, 103);
            this.enter.Name = "enter";
            this.enter.Size = new System.Drawing.Size(74, 17);
            this.enter.TabIndex = 7;
            this.enter.Text = "自动登录";
            this.enter.UseVisualStyleBackColor = true;
            // 
            // lblQQ5
            // 
            this.lblQQ5.AutoSize = true;
            this.lblQQ5.Location = new System.Drawing.Point(67, 104);
            this.lblQQ5.Name = "lblQQ5";
            this.lblQQ5.Size = new System.Drawing.Size(34, 13);
            this.lblQQ5.TabIndex = 6;
            this.lblQQ5.Text = "状态:";
            // 
            // lblpwd
            // 
            this.lblpwd.AutoSize = true;
            this.lblpwd.Location = new System.Drawing.Point(261, 70);
            this.lblpwd.Name = "lblpwd";
            this.lblpwd.Size = new System.Drawing.Size(61, 13);
            this.lblpwd.TabIndex = 5;
            this.lblpwd.Text = "忘了密码?";
            // 
            // lblLogin
            // 
            this.lblLogin.AutoSize = true;
            this.lblLogin.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblLogin.Location = new System.Drawing.Point(261, 26);
            this.lblLogin.Name = "lblLogin";
            this.lblLogin.Size = new System.Drawing.Size(55, 13);
            this.lblLogin.TabIndex = 4;
            this.lblLogin.Text = "申请帐号";
            this.lblLogin.MouseLeave += new System.EventHandler(this.lblLogin_MouseLeave);
            this.lblLogin.MouseMove += new System.Windows.Forms.MouseEventHandler(this.lblLogin_MouseMove);
            this.lblLogin.MouseClick += new System.Windows.Forms.MouseEventHandler(this.lblLogin_MouseClick);
            // 
            // comboBox2
            // 
            this.comboBox2.FormattingEnabled = true;
            this.comboBox2.Location = new System.Drawing.Point(104, 67);
            this.comboBox2.Name = "comboBox2";
            this.comboBox2.Size = new System.Drawing.Size(145, 21);
            this.comboBox2.TabIndex = 3;
            // 
            // cboAccounts
            // 
            this.cboAccounts.FormattingEnabled = true;
            this.cboAccounts.Location = new System.Drawing.Point(104, 23);
            this.cboAccounts.Name = "cboAccounts";
            this.cboAccounts.Size = new System.Drawing.Size(145, 21);
            this.cboAccounts.TabIndex = 2;
            // 
            // lblQQ2
            // 
            this.lblQQ2.AutoSize = true;
            this.lblQQ2.Location = new System.Drawing.Point(18, 70);
            this.lblQQ2.Name = "lblQQ2";
            this.lblQQ2.Size = new System.Drawing.Size(47, 13);
            this.lblQQ2.TabIndex = 1;
            this.lblQQ2.Text = "QQ密码";
            // 
            // lblQQ1
            // 
            this.lblQQ1.AutoSize = true;
            this.lblQQ1.Location = new System.Drawing.Point(18, 26);
            this.lblQQ1.Name = "lblQQ1";
            this.lblQQ1.Size = new System.Drawing.Size(47, 13);
            this.lblQQ1.TabIndex = 0;
            this.lblQQ1.Text = "QQ帐号";
            // 
            // btoEnter
            // 
            this.btoEnter.Location = new System.Drawing.Point(162, 200);
            this.btoEnter.Name = "btoEnter";
            this.btoEnter.Size = new System.Drawing.Size(75, 25);
            this.btoEnter.TabIndex = 7;
            this.btoEnter.Text = "登录";
            this.btoEnter.UseVisualStyleBackColor = true;
            // 
            // btoCancel
            // 
            this.btoCancel.Location = new System.Drawing.Point(257, 200);
            this.btoCancel.Name = "btoCancel";
            this.btoCancel.Size = new System.Drawing.Size(75, 25);
            this.btoCancel.TabIndex = 8;
            this.btoCancel.Text = "取消";
            this.btoCancel.UseVisualStyleBackColor = true;
            // 
            // Form_login
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(355, 238);
            this.Controls.Add(this.btoCancel);
            this.Controls.Add(this.btoEnter);
            this.Controls.Add(this.panel1);
            this.MaximizeBox = false;
            this.Name = "Form_login";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "QQ用户登录";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label lblQQ5;
        private System.Windows.Forms.Label lblpwd;
        private System.Windows.Forms.Label lblLogin;
        private System.Windows.Forms.ComboBox comboBox2;
        private System.Windows.Forms.ComboBox cboAccounts;
        private System.Windows.Forms.Label lblQQ2;
        private System.Windows.Forms.Label lblQQ1;
        private System.Windows.Forms.Button btoEnter;
        private System.Windows.Forms.Button btoCancel;
        private System.Windows.Forms.ComboBox comboBox3;
        private System.Windows.Forms.CheckBox enter;
    }
}

