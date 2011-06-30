namespace myQQ
{
    partial class Frm_Record
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_Record));
            this.rtbMessages = new System.Windows.Forms.RichTextBox();
            this.btnReturn = new System.Windows.Forms.Button();
            this.treeView1 = new System.Windows.Forms.TreeView();
            this.btnReflash = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.ilFaceThums = new System.Windows.Forms.ImageList(this.components);
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // rtbMessages
            // 
            this.rtbMessages.BackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.rtbMessages.Location = new System.Drawing.Point(6, 20);
            this.rtbMessages.Name = "rtbMessages";
            this.rtbMessages.ReadOnly = true;
            this.rtbMessages.Size = new System.Drawing.Size(273, 225);
            this.rtbMessages.TabIndex = 1;
            this.rtbMessages.Text = "";
            // 
            // btnReturn
            // 
            this.btnReturn.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnReturn.Location = new System.Drawing.Point(387, 269);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(75, 23);
            this.btnReturn.TabIndex = 2;
            this.btnReturn.Text = "返回";
            this.btnReturn.UseVisualStyleBackColor = true;
            this.btnReturn.Click += new System.EventHandler(this.btnReturn_Click);
            // 
            // treeView1
            // 
            this.treeView1.BackColor = System.Drawing.Color.SteelBlue;
            this.treeView1.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.treeView1.Location = new System.Drawing.Point(6, 20);
            this.treeView1.Name = "treeView1";
            this.treeView1.Size = new System.Drawing.Size(144, 225);
            this.treeView1.TabIndex = 3;
            this.treeView1.NodeMouseClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.treeView1_NodeMouseClick);
            // 
            // btnReflash
            // 
            this.btnReflash.Location = new System.Drawing.Point(306, 269);
            this.btnReflash.Name = "btnReflash";
            this.btnReflash.Size = new System.Drawing.Size(75, 23);
            this.btnReflash.TabIndex = 4;
            this.btnReflash.Text = "刷新";
            this.btnReflash.UseVisualStyleBackColor = true;
            this.btnReflash.Click += new System.EventHandler(this.btnReflash_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.rtbMessages);
            this.groupBox1.Location = new System.Drawing.Point(175, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(287, 251);
            this.groupBox1.TabIndex = 5;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "消息列表";
            // 
            // groupBox2
            // 
            this.groupBox2.BackColor = System.Drawing.Color.Transparent;
            this.groupBox2.Controls.Add(this.treeView1);
            this.groupBox2.Location = new System.Drawing.Point(12, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(157, 251);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "好友列表";
            // 
            // ilFaceThums
            // 
            this.ilFaceThums.ImageStream = ((System.Windows.Forms.ImageListStreamer)(resources.GetObject("ilFaceThums.ImageStream")));
            this.ilFaceThums.TransparentColor = System.Drawing.Color.Transparent;
            this.ilFaceThums.Images.SetKeyName(0, "04580128.jpg");
            this.ilFaceThums.Images.SetKeyName(1, "0458010.jpg");
            this.ilFaceThums.Images.SetKeyName(2, "0458011.jpg");
            this.ilFaceThums.Images.SetKeyName(3, "0458012.jpg");
            this.ilFaceThums.Images.SetKeyName(4, "0458013.jpg");
            this.ilFaceThums.Images.SetKeyName(5, "0458017.jpg");
            this.ilFaceThums.Images.SetKeyName(6, "0458018.jpg");
            this.ilFaceThums.Images.SetKeyName(7, "04580111.jpg");
            this.ilFaceThums.Images.SetKeyName(8, "04580112.jpg");
            this.ilFaceThums.Images.SetKeyName(9, "04580115.jpg");
            this.ilFaceThums.Images.SetKeyName(10, "04580117.jpg");
            this.ilFaceThums.Images.SetKeyName(11, "04580118.jpg");
            this.ilFaceThums.Images.SetKeyName(12, "04580122.jpg");
            this.ilFaceThums.Images.SetKeyName(13, "04580127.jpg");
            this.ilFaceThums.Images.SetKeyName(14, "20080728080655566.jpg");
            this.ilFaceThums.Images.SetKeyName(15, "121KDR610954292.jpg");
            this.ilFaceThums.Images.SetKeyName(16, "121KDS0510b5T1.jpg");
            this.ilFaceThums.Images.SetKeyName(17, "1214T03AP0501920a_1.jpg");
            this.ilFaceThums.Images.SetKeyName(18, "12095c22251012211C.jpg");
            this.ilFaceThums.Images.SetKeyName(19, "0125210_1.jpg");
            this.ilFaceThums.Images.SetKeyName(20, "0436329.jpg");
            this.ilFaceThums.Images.SetKeyName(21, "1004271.jpg");
            this.ilFaceThums.Images.SetKeyName(22, "1004277.jpg");
            this.ilFaceThums.Images.SetKeyName(23, "1046350.jpg");
            this.ilFaceThums.Images.SetKeyName(24, "1210623UW5N023O1.jpg");
            this.ilFaceThums.Images.SetKeyName(25, "1210623V339350132453_1.jpg");
            this.ilFaceThums.Images.SetKeyName(26, "1210623W01E202Y5V_1.jpg");
            this.ilFaceThums.Images.SetKeyName(27, "1210623W061550293333_1.jpg");
            this.ilFaceThums.Images.SetKeyName(28, "10042711.jpg");
            this.ilFaceThums.Images.SetKeyName(29, "10055438.jpg");
            this.ilFaceThums.Images.SetKeyName(30, "10463520.jpg");
            this.ilFaceThums.Images.SetKeyName(31, "16391010_1.jpg");
            this.ilFaceThums.Images.SetKeyName(32, "SBuddyButton.ico");
            this.ilFaceThums.Images.SetKeyName(33, "MessageReading.gif");
            this.ilFaceThums.Images.SetKeyName(34, "bar_QQ.ico");
            this.ilFaceThums.Images.SetKeyName(35, "bar_content.ico");
            this.ilFaceThums.Images.SetKeyName(36, "MyQQ.ico");
            this.ilFaceThums.Images.SetKeyName(37, "TTButton.png");
            // 
            // Frm_Record
            // 
            this.AcceptButton = this.btnReflash;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.CancelButton = this.btnReturn;
            this.ClientSize = new System.Drawing.Size(469, 299);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnReflash);
            this.Controls.Add(this.btnReturn);
            this.Name = "Frm_Record";
            this.Text = "聊天记录";
            this.Load += new System.EventHandler(this.Frm_Record_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.RichTextBox rtbMessages;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.TreeView treeView1;
        private System.Windows.Forms.Button btnReflash;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.ImageList ilFaceThums;
    }
}