namespace myQQ
{
    partial class Frm_chat
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_chat));
            this.btnSendInfo = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.rtbDisplay = new System.Windows.Forms.RichTextBox();
            this.rtbEdit = new System.Windows.Forms.RichTextBox();
            this.picFriend = new System.Windows.Forms.PictureBox();
            this.picHost = new System.Windows.Forms.PictureBox();
            this.timer = new System.Windows.Forms.Timer(this.components);
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.picHostBusy = new System.Windows.Forms.PictureBox();
            this.picFriendBusy = new System.Windows.Forms.PictureBox();
            this.lblHostState = new System.Windows.Forms.Label();
            this.lblState = new System.Windows.Forms.Label();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.lblMood = new System.Windows.Forms.Label();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            ((System.ComponentModel.ISupportInitialize)(this.picFriend)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picHost)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picHostBusy)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.picFriendBusy)).BeginInit();
            this.groupBox3.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnSendInfo
            // 
            this.btnSendInfo.Location = new System.Drawing.Point(147, 323);
            this.btnSendInfo.Name = "btnSendInfo";
            this.btnSendInfo.Size = new System.Drawing.Size(65, 29);
            this.btnSendInfo.TabIndex = 0;
            this.btnSendInfo.Text = "发送";
            this.btnSendInfo.UseVisualStyleBackColor = true;
            this.btnSendInfo.Click += new System.EventHandler(this.btnSendInfo_Click);
            // 
            // btnClose
            // 
            this.btnClose.BackColor = System.Drawing.Color.Transparent;
            this.btnClose.Location = new System.Drawing.Point(218, 323);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(69, 29);
            this.btnClose.TabIndex = 1;
            this.btnClose.Text = "关闭";
            this.btnClose.UseVisualStyleBackColor = false;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // rtbDisplay
            // 
            this.rtbDisplay.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.rtbDisplay.Location = new System.Drawing.Point(8, 38);
            this.rtbDisplay.Name = "rtbDisplay";
            this.rtbDisplay.ReadOnly = true;
            this.rtbDisplay.Size = new System.Drawing.Size(267, 151);
            this.rtbDisplay.TabIndex = 1;
            this.rtbDisplay.Text = "";
            // 
            // rtbEdit
            // 
            this.rtbEdit.Location = new System.Drawing.Point(8, 195);
            this.rtbEdit.Name = "rtbEdit";
            this.rtbEdit.Size = new System.Drawing.Size(267, 54);
            this.rtbEdit.TabIndex = 0;
            this.rtbEdit.Text = "";
            // 
            // picFriend
            // 
            this.picFriend.Location = new System.Drawing.Point(8, 11);
            this.picFriend.Name = "picFriend";
            this.picFriend.Size = new System.Drawing.Size(71, 66);
            this.picFriend.TabIndex = 1;
            this.picFriend.TabStop = false;
            // 
            // picHost
            // 
            this.picHost.Location = new System.Drawing.Point(8, 11);
            this.picHost.Name = "picHost";
            this.picHost.Size = new System.Drawing.Size(71, 66);
            this.picHost.TabIndex = 0;
            this.picHost.TabStop = false;
            // 
            // timer
            // 
            this.timer.Interval = 2000;
            this.timer.Tick += new System.EventHandler(this.timer_Tick);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(12, 7);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(282, 48);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // groupBox1
            // 
            this.groupBox1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.picHostBusy);
            this.groupBox1.Controls.Add(this.picFriendBusy);
            this.groupBox1.Controls.Add(this.lblHostState);
            this.groupBox1.Controls.Add(this.lblState);
            this.groupBox1.Controls.Add(this.groupBox3);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Location = new System.Drawing.Point(299, 7);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(123, 345);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            // 
            // picHostBusy
            // 
            this.picHostBusy.Image = ((System.Drawing.Image)(resources.GetObject("picHostBusy.Image")));
            this.picHostBusy.Location = new System.Drawing.Point(73, 273);
            this.picHostBusy.Name = "picHostBusy";
            this.picHostBusy.Size = new System.Drawing.Size(27, 23);
            this.picHostBusy.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picHostBusy.TabIndex = 9;
            this.picHostBusy.TabStop = false;
            // 
            // picFriendBusy
            // 
            this.picFriendBusy.Image = ((System.Drawing.Image)(resources.GetObject("picFriendBusy.Image")));
            this.picFriendBusy.Location = new System.Drawing.Point(73, 93);
            this.picFriendBusy.Name = "picFriendBusy";
            this.picFriendBusy.Size = new System.Drawing.Size(27, 23);
            this.picFriendBusy.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.picFriendBusy.TabIndex = 8;
            this.picFriendBusy.TabStop = false;
            // 
            // lblHostState
            // 
            this.lblHostState.AutoSize = true;
            this.lblHostState.BackColor = System.Drawing.Color.Transparent;
            this.lblHostState.Font = new System.Drawing.Font("新宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lblHostState.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.lblHostState.Location = new System.Drawing.Point(18, 274);
            this.lblHostState.Name = "lblHostState";
            this.lblHostState.Size = new System.Drawing.Size(49, 14);
            this.lblHostState.TabIndex = 7;
            this.lblHostState.Text = "label1";
            // 
            // lblState
            // 
            this.lblState.AutoSize = true;
            this.lblState.BackColor = System.Drawing.Color.Transparent;
            this.lblState.Font = new System.Drawing.Font("新宋体", 10.5F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lblState.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.lblState.Location = new System.Drawing.Point(18, 93);
            this.lblState.Name = "lblState";
            this.lblState.Size = new System.Drawing.Size(49, 14);
            this.lblState.TabIndex = 6;
            this.lblState.Text = "label1";
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.picHost);
            this.groupBox3.Location = new System.Drawing.Point(21, 187);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(87, 80);
            this.groupBox3.TabIndex = 1;
            this.groupBox3.TabStop = false;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.picFriend);
            this.groupBox2.Location = new System.Drawing.Point(21, 10);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(87, 80);
            this.groupBox2.TabIndex = 0;
            this.groupBox2.TabStop = false;
            // 
            // lblMood
            // 
            this.lblMood.AutoSize = true;
            this.lblMood.BackColor = System.Drawing.Color.Transparent;
            this.lblMood.Cursor = System.Windows.Forms.Cursors.Hand;
            this.lblMood.Font = new System.Drawing.Font("新宋体", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lblMood.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.lblMood.Location = new System.Drawing.Point(6, 21);
            this.lblMood.Name = "lblMood";
            this.lblMood.Size = new System.Drawing.Size(41, 12);
            this.lblMood.TabIndex = 5;
            this.lblMood.Text = "label1";
            this.lblMood.MouseLeave += new System.EventHandler(this.lblMood_MouseLeave);
            this.lblMood.Click += new System.EventHandler(this.picInfo_Click);
            this.lblMood.MouseHover += new System.EventHandler(this.lblMood_MouseHover);
            // 
            // groupBox4
            // 
            this.groupBox4.BackColor = System.Drawing.Color.Transparent;
            this.groupBox4.Controls.Add(this.rtbDisplay);
            this.groupBox4.Controls.Add(this.lblMood);
            this.groupBox4.Controls.Add(this.rtbEdit);
            this.groupBox4.Location = new System.Drawing.Point(12, 57);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(282, 260);
            this.groupBox4.TabIndex = 6;
            this.groupBox4.TabStop = false;
            // 
            // Frm_chat
            // 
            this.AcceptButton = this.btnSendInfo;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(427, 358);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnSendInfo);
            this.Name = "Frm_chat";
            this.Text = "对话窗体";
            this.Load += new System.EventHandler(this.Frm_chat_Load);
            ((System.ComponentModel.ISupportInitialize)(this.picFriend)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picHost)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picHostBusy)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.picFriendBusy)).EndInit();
            this.groupBox3.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnSendInfo;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.PictureBox picFriend;
        private System.Windows.Forms.PictureBox picHost;
        private System.Windows.Forms.RichTextBox rtbEdit;
        private System.Windows.Forms.RichTextBox rtbDisplay;
        private System.Windows.Forms.Timer timer;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label lblMood;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.Label lblState;
        private System.Windows.Forms.Label lblHostState;
        private System.Windows.Forms.PictureBox picHostBusy;
        private System.Windows.Forms.PictureBox picFriendBusy;
    }
}