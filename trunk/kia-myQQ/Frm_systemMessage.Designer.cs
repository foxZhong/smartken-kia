namespace myQQ
{
    partial class Frm_systemMessage
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_systemMessage));
            this.txtMessageGet = new System.Windows.Forms.TextBox();
            this.btnAllow = new System.Windows.Forms.Button();
            this.btnNo = new System.Windows.Forms.Button();
            this.btnAddFriend = new System.Windows.Forms.Button();
            this.llbNickName = new System.Windows.Forms.LinkLabel();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // txtMessageGet
            // 
            this.txtMessageGet.Location = new System.Drawing.Point(6, 34);
            this.txtMessageGet.Multiline = true;
            this.txtMessageGet.Name = "txtMessageGet";
            this.txtMessageGet.Size = new System.Drawing.Size(246, 58);
            this.txtMessageGet.TabIndex = 0;
            // 
            // btnAllow
            // 
            this.btnAllow.Location = new System.Drawing.Point(164, 151);
            this.btnAllow.Name = "btnAllow";
            this.btnAllow.Size = new System.Drawing.Size(51, 23);
            this.btnAllow.TabIndex = 1;
            this.btnAllow.Text = "接受";
            this.btnAllow.UseVisualStyleBackColor = true;
            this.btnAllow.Click += new System.EventHandler(this.btnAllow_Click);
            // 
            // btnNo
            // 
            this.btnNo.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnNo.Location = new System.Drawing.Point(221, 151);
            this.btnNo.Name = "btnNo";
            this.btnNo.Size = new System.Drawing.Size(50, 23);
            this.btnNo.TabIndex = 2;
            this.btnNo.Text = "拒绝";
            this.btnNo.UseVisualStyleBackColor = true;
            this.btnNo.Click += new System.EventHandler(this.btnNo_Click);
            // 
            // btnAddFriend
            // 
            this.btnAddFriend.Location = new System.Drawing.Point(139, 104);
            this.btnAddFriend.Name = "btnAddFriend";
            this.btnAddFriend.Size = new System.Drawing.Size(113, 23);
            this.btnAddFriend.TabIndex = 4;
            this.btnAddFriend.Text = "添加对方为好友";
            this.btnAddFriend.UseVisualStyleBackColor = true;
            this.btnAddFriend.Click += new System.EventHandler(this.btnAddFriend_Click);
            // 
            // llbNickName
            // 
            this.llbNickName.AutoSize = true;
            this.llbNickName.Cursor = System.Windows.Forms.Cursors.Hand;
            this.llbNickName.Font = new System.Drawing.Font("新宋体", 10.5F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.llbNickName.ForeColor = System.Drawing.Color.Olive;
            this.llbNickName.LinkBehavior = System.Windows.Forms.LinkBehavior.NeverUnderline;
            this.llbNickName.LinkColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(64)))), ((int)(((byte)(0)))));
            this.llbNickName.Location = new System.Drawing.Point(6, 17);
            this.llbNickName.Name = "llbNickName";
            this.llbNickName.Size = new System.Drawing.Size(87, 14);
            this.llbNickName.TabIndex = 5;
            this.llbNickName.TabStop = true;
            this.llbNickName.Text = "linkLabel1";
            this.llbNickName.LinkClicked += new System.Windows.Forms.LinkLabelLinkClickedEventHandler(this.llbNickName_LinkClicked);
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.txtMessageGet);
            this.groupBox1.Controls.Add(this.btnAddFriend);
            this.groupBox1.Controls.Add(this.llbNickName);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(261, 133);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "请求信息";
            // 
            // Frm_systemMessage
            // 
            this.AcceptButton = this.btnAllow;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.CancelButton = this.btnNo;
            this.ClientSize = new System.Drawing.Size(282, 185);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnNo);
            this.Controls.Add(this.btnAllow);
            this.Name = "Frm_systemMessage";
            this.Text = "系统信息";
            this.Load += new System.EventHandler(this.Frm_systemMessage_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox txtMessageGet;
        private System.Windows.Forms.Button btnAllow;
        private System.Windows.Forms.Button btnNo;
        private System.Windows.Forms.Button btnAddFriend;
        private System.Windows.Forms.LinkLabel llbNickName;
        private System.Windows.Forms.GroupBox groupBox1;
    }
}