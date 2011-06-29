namespace BookSystem
{
    partial class frmLogin
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmLogin));
            this.btnLogin = new System.Windows.Forms.Button();
            this.gbox = new System.Windows.Forms.GroupBox();
            this.lblName = new System.Windows.Forms.Label();
            this.lblRealName = new System.Windows.Forms.Label();
            this.txtPass = new System.Windows.Forms.TextBox();
            this.txtCode = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.gbox.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnLogin
            // 
            this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnLogin.Location = new System.Drawing.Point(79, 202);
            this.btnLogin.Name = "btnLogin";
            this.btnLogin.Size = new System.Drawing.Size(75, 25);
            this.btnLogin.TabIndex = 7;
            this.btnLogin.Text = "登 陆";
            this.btnLogin.UseVisualStyleBackColor = true;
            this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
            // 
            // gbox
            // 
            this.gbox.BackColor = System.Drawing.Color.Transparent;
            this.gbox.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.gbox.Controls.Add(this.lblName);
            this.gbox.Controls.Add(this.lblRealName);
            this.gbox.Controls.Add(this.txtPass);
            this.gbox.Controls.Add(this.txtCode);
            this.gbox.Controls.Add(this.label2);
            this.gbox.Controls.Add(this.label1);
            this.gbox.Location = new System.Drawing.Point(48, 29);
            this.gbox.Name = "gbox";
            this.gbox.Size = new System.Drawing.Size(278, 150);
            this.gbox.TabIndex = 6;
            this.gbox.TabStop = false;
            this.gbox.Text = "用户登陆";
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Location = new System.Drawing.Point(53, 18);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(55, 13);
            this.lblName.TabIndex = 5;
            this.lblName.Text = "员工名：";
            // 
            // lblRealName
            // 
            this.lblRealName.AutoSize = true;
            this.lblRealName.Location = new System.Drawing.Point(110, 18);
            this.lblRealName.Name = "lblRealName";
            this.lblRealName.Size = new System.Drawing.Size(35, 13);
            this.lblRealName.TabIndex = 4;
            this.lblRealName.Text = "label3";
            // 
            // txtPass
            // 
            this.txtPass.Location = new System.Drawing.Point(112, 102);
            this.txtPass.Name = "txtPass";
            this.txtPass.Size = new System.Drawing.Size(126, 20);
            this.txtPass.TabIndex = 3;
            this.txtPass.Text = "1234";
            this.txtPass.UseSystemPasswordChar = true;
            // 
            // txtCode
            // 
            this.txtCode.Location = new System.Drawing.Point(112, 56);
            this.txtCode.Name = "txtCode";
            this.txtCode.Size = new System.Drawing.Size(126, 20);
            this.txtCode.TabIndex = 2;
            this.txtCode.Text = "AC100293";
            this.txtCode.Leave += new System.EventHandler(this.txtCode_Leave);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(41, 105);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(67, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "员工密码：";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(29, 60);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(79, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "登陆员工号：";
            // 
            // btnExit
            // 
            this.btnExit.FlatStyle = System.Windows.Forms.FlatStyle.Popup;
            this.btnExit.Location = new System.Drawing.Point(211, 202);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 25);
            this.btnExit.TabIndex = 8;
            this.btnExit.Text = "取 消";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // frmLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(384, 271);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnLogin);
            this.Controls.Add(this.gbox);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmLogin";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "frmLogin";
            this.Load += new System.EventHandler(this.frmLogin_Load);
            this.gbox.ResumeLayout(false);
            this.gbox.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnLogin;
        private System.Windows.Forms.GroupBox gbox;
        private System.Windows.Forms.TextBox txtPass;
        private System.Windows.Forms.TextBox txtCode;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Label lblRealName;
        private System.Windows.Forms.Label lblName;
    }
}