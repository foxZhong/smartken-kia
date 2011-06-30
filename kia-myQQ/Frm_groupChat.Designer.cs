namespace myQQ
{
    partial class Frm_groupChat
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_groupChat));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rtbGroupMessage = new System.Windows.Forms.RichTextBox();
            this.cmsGroup = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.tsmiGroupSetup = new System.Windows.Forms.ToolStripMenuItem();
            this.rtbDisplay = new System.Windows.Forms.RichTextBox();
            this.rtbEdit = new System.Windows.Forms.RichTextBox();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.treeViewMembers = new System.Windows.Forms.TreeView();
            this.btnSend = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.timerSearchMessage = new System.Windows.Forms.Timer(this.components);
            this.timerReflash = new System.Windows.Forms.Timer(this.components);
            this.groupBox1.SuspendLayout();
            this.cmsGroup.SuspendLayout();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.rtbGroupMessage);
            this.groupBox1.Location = new System.Drawing.Point(300, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(145, 121);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "群公告：";
            // 
            // rtbGroupMessage
            // 
            this.rtbGroupMessage.BackColor = System.Drawing.SystemColors.Info;
            this.rtbGroupMessage.ContextMenuStrip = this.cmsGroup;
            this.rtbGroupMessage.Location = new System.Drawing.Point(6, 19);
            this.rtbGroupMessage.Name = "rtbGroupMessage";
            this.rtbGroupMessage.Size = new System.Drawing.Size(133, 96);
            this.rtbGroupMessage.TabIndex = 0;
            this.rtbGroupMessage.Text = "";
            // 
            // cmsGroup
            // 
            this.cmsGroup.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiGroupSetup});
            this.cmsGroup.Name = "cmsGroup";
            this.cmsGroup.Size = new System.Drawing.Size(131, 26);
            // 
            // tsmiGroupSetup
            // 
            this.tsmiGroupSetup.Name = "tsmiGroupSetup";
            this.tsmiGroupSetup.Size = new System.Drawing.Size(130, 22);
            this.tsmiGroupSetup.Text = "查看群设置";
            this.tsmiGroupSetup.Click += new System.EventHandler(this.tsmiGroupSetup_Click);
            // 
            // rtbDisplay
            // 
            this.rtbDisplay.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.rtbDisplay.Location = new System.Drawing.Point(6, 12);
            this.rtbDisplay.Name = "rtbDisplay";
            this.rtbDisplay.ReadOnly = true;
            this.rtbDisplay.Size = new System.Drawing.Size(270, 164);
            this.rtbDisplay.TabIndex = 2;
            this.rtbDisplay.Text = "";
            // 
            // rtbEdit
            // 
            this.rtbEdit.Location = new System.Drawing.Point(6, 182);
            this.rtbEdit.Name = "rtbEdit";
            this.rtbEdit.Size = new System.Drawing.Size(270, 55);
            this.rtbEdit.TabIndex = 3;
            this.rtbEdit.Text = "";
            // 
            // groupBox3
            // 
            this.groupBox3.BackColor = System.Drawing.Color.Transparent;
            this.groupBox3.Controls.Add(this.treeViewMembers);
            this.groupBox3.Location = new System.Drawing.Point(300, 139);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(145, 199);
            this.groupBox3.TabIndex = 1;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "成员列表";
            // 
            // treeViewMembers
            // 
            this.treeViewMembers.BackColor = System.Drawing.Color.SteelBlue;
            this.treeViewMembers.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.treeViewMembers.Location = new System.Drawing.Point(6, 20);
            this.treeViewMembers.Name = "treeViewMembers";
            this.treeViewMembers.Size = new System.Drawing.Size(133, 173);
            this.treeViewMembers.TabIndex = 0;
            this.treeViewMembers.NodeMouseDoubleClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.treeViewMembers_NodeMouseDoubleClick);
            // 
            // btnSend
            // 
            this.btnSend.Location = new System.Drawing.Point(132, 315);
            this.btnSend.Name = "btnSend";
            this.btnSend.Size = new System.Drawing.Size(75, 23);
            this.btnSend.TabIndex = 4;
            this.btnSend.Text = "发送";
            this.btnSend.UseVisualStyleBackColor = true;
            this.btnSend.Click += new System.EventHandler(this.btnSend_Click);
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(213, 315);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(75, 23);
            this.btnClose.TabIndex = 5;
            this.btnClose.Text = "关闭";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(12, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(282, 48);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 6;
            this.pictureBox1.TabStop = false;
            // 
            // groupBox2
            // 
            this.groupBox2.BackColor = System.Drawing.Color.Transparent;
            this.groupBox2.Controls.Add(this.rtbDisplay);
            this.groupBox2.Controls.Add(this.rtbEdit);
            this.groupBox2.Location = new System.Drawing.Point(12, 66);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(282, 243);
            this.groupBox2.TabIndex = 7;
            this.groupBox2.TabStop = false;
            // 
            // timerSearchMessage
            // 
            this.timerSearchMessage.Interval = 1500;
            this.timerSearchMessage.Tick += new System.EventHandler(this.timerSearchMessage_Tick);
            // 
            // timerReflash
            // 
            this.timerReflash.Interval = 8000;
            this.timerReflash.Tick += new System.EventHandler(this.timerReflash_Tick);
            // 
            // Frm_groupChat
            // 
            this.AcceptButton = this.btnSend;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(452, 351);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnSend);
            this.Name = "Frm_groupChat";
            this.Text = "Frm_groupChat";
            this.Load += new System.EventHandler(this.Frm_groupChat_Load);
            this.groupBox1.ResumeLayout(false);
            this.cmsGroup.ResumeLayout(false);
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RichTextBox rtbGroupMessage;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.RichTextBox rtbDisplay;
        private System.Windows.Forms.RichTextBox rtbEdit;
        private System.Windows.Forms.Button btnSend;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Timer timerSearchMessage;
        private System.Windows.Forms.TreeView treeViewMembers;
        private System.Windows.Forms.Timer timerReflash;
        private System.Windows.Forms.ContextMenuStrip cmsGroup;
        private System.Windows.Forms.ToolStripMenuItem tsmiGroupSetup;
    }
}