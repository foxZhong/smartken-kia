namespace myQQ
{
    partial class Frm_leaveGroup
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_leaveGroup));
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.lblAlart1 = new System.Windows.Forms.Label();
            this.cboMembers = new System.Windows.Forms.ComboBox();
            this.rbnChangGroupHost = new System.Windows.Forms.RadioButton();
            this.rbnDestoryGroup = new System.Windows.Forms.RadioButton();
            this.label1 = new System.Windows.Forms.Label();
            this.btnConfirm = new System.Windows.Forms.Button();
            this.btnCancle = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.lblAlart2 = new System.Windows.Forms.Label();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.lblAlart1);
            this.groupBox1.Controls.Add(this.cboMembers);
            this.groupBox1.Controls.Add(this.rbnChangGroupHost);
            this.groupBox1.Controls.Add(this.rbnDestoryGroup);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(27, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(214, 168);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "提示";
            // 
            // lblAlart1
            // 
            this.lblAlart1.AutoSize = true;
            this.lblAlart1.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lblAlart1.ForeColor = System.Drawing.Color.Red;
            this.lblAlart1.Location = new System.Drawing.Point(17, 17);
            this.lblAlart1.Name = "lblAlart1";
            this.lblAlart1.Size = new System.Drawing.Size(62, 16);
            this.lblAlart1.TabIndex = 4;
            this.lblAlart1.Text = "label2";
            // 
            // cboMembers
            // 
            this.cboMembers.FormattingEnabled = true;
            this.cboMembers.Location = new System.Drawing.Point(6, 132);
            this.cboMembers.Name = "cboMembers";
            this.cboMembers.Size = new System.Drawing.Size(140, 20);
            this.cboMembers.TabIndex = 3;
            // 
            // rbnChangGroupHost
            // 
            this.rbnChangGroupHost.AutoSize = true;
            this.rbnChangGroupHost.Location = new System.Drawing.Point(8, 109);
            this.rbnChangGroupHost.Name = "rbnChangGroupHost";
            this.rbnChangGroupHost.Size = new System.Drawing.Size(155, 16);
            this.rbnChangGroupHost.TabIndex = 2;
            this.rbnChangGroupHost.TabStop = true;
            this.rbnChangGroupHost.Text = "授权群里其他成员为群主";
            this.rbnChangGroupHost.UseVisualStyleBackColor = true;
            // 
            // rbnDestoryGroup
            // 
            this.rbnDestoryGroup.AutoSize = true;
            this.rbnDestoryGroup.Location = new System.Drawing.Point(8, 87);
            this.rbnDestoryGroup.Name = "rbnDestoryGroup";
            this.rbnDestoryGroup.Size = new System.Drawing.Size(71, 16);
            this.rbnDestoryGroup.TabIndex = 1;
            this.rbnDestoryGroup.TabStop = true;
            this.rbnDestoryGroup.Text = "解散该群";
            this.rbnDestoryGroup.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 48);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(197, 36);
            this.label1.TabIndex = 0;
            this.label1.Text = "    由于你是群主，你的退出将影响\r\n到群里其他成员，所以请在退出前选\r\n择一下操作:\r\n";
            // 
            // btnConfirm
            // 
            this.btnConfirm.Location = new System.Drawing.Point(85, 187);
            this.btnConfirm.Name = "btnConfirm";
            this.btnConfirm.Size = new System.Drawing.Size(75, 23);
            this.btnConfirm.TabIndex = 1;
            this.btnConfirm.Text = "确认";
            this.btnConfirm.UseVisualStyleBackColor = true;
            this.btnConfirm.Click += new System.EventHandler(this.btnConfirm_Click);
            // 
            // btnCancle
            // 
            this.btnCancle.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnCancle.Location = new System.Drawing.Point(166, 187);
            this.btnCancle.Name = "btnCancle";
            this.btnCancle.Size = new System.Drawing.Size(75, 23);
            this.btnCancle.TabIndex = 2;
            this.btnCancle.Text = "取消";
            this.btnCancle.UseVisualStyleBackColor = true;
            this.btnCancle.Click += new System.EventHandler(this.btnCancle_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.BackColor = System.Drawing.Color.Transparent;
            this.groupBox2.Controls.Add(this.lblAlart2);
            this.groupBox2.Location = new System.Drawing.Point(27, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(214, 168);
            this.groupBox2.TabIndex = 3;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "提示";
            // 
            // lblAlart2
            // 
            this.lblAlart2.AutoSize = true;
            this.lblAlart2.Font = new System.Drawing.Font("宋体", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lblAlart2.ForeColor = System.Drawing.Color.Red;
            this.lblAlart2.Location = new System.Drawing.Point(14, 48);
            this.lblAlart2.Name = "lblAlart2";
            this.lblAlart2.Size = new System.Drawing.Size(121, 32);
            this.lblAlart2.TabIndex = 0;
            this.lblAlart2.Text = "    注意!你将\r\n\r\n";
            // 
            // Frm_leaveGroup
            // 
            this.AcceptButton = this.btnConfirm;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.CancelButton = this.btnCancle;
            this.ClientSize = new System.Drawing.Size(252, 222);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.btnCancle);
            this.Controls.Add(this.btnConfirm);
            this.Controls.Add(this.groupBox1);
            this.Name = "Frm_leaveGroup";
            this.Text = "离开群";
            this.Load += new System.EventHandler(this.Frm_leaveGroup_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnConfirm;
        private System.Windows.Forms.Button btnCancle;
        private System.Windows.Forms.ComboBox cboMembers;
        private System.Windows.Forms.RadioButton rbnChangGroupHost;
        private System.Windows.Forms.RadioButton rbnDestoryGroup;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label lblAlart2;
        private System.Windows.Forms.Label lblAlart1;
    }
}