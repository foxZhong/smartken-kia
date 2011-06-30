namespace myQQ
{
    partial class Frm_selectImage
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_selectImage));
            this.lvFace = new System.Windows.Forms.ListView();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.tsmiLargeView = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiSmallView = new System.Windows.Forms.ToolStripMenuItem();
            this.ilFaceThums = new System.Windows.Forms.ImageList(this.components);
            this.btnConfirm = new System.Windows.Forms.Button();
            this.btnCancle = new System.Windows.Forms.Button();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.lvFace2 = new System.Windows.Forms.ListView();
            this.contextMenuStrip1.SuspendLayout();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.SuspendLayout();
            // 
            // lvFace
            // 
            this.lvFace.ContextMenuStrip = this.contextMenuStrip1;
            this.lvFace.Location = new System.Drawing.Point(0, 0);
            this.lvFace.MultiSelect = false;
            this.lvFace.Name = "lvFace";
            this.lvFace.Size = new System.Drawing.Size(280, 169);
            this.lvFace.SmallImageList = this.ilFaceThums;
            this.lvFace.TabIndex = 0;
            this.lvFace.UseCompatibleStateImageBehavior = false;
            this.lvFace.SelectedIndexChanged += new System.EventHandler(this.lvFace_SelectedIndexChanged);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiLargeView,
            this.tsmiSmallView});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(131, 48);
            // 
            // tsmiLargeView
            // 
            this.tsmiLargeView.Name = "tsmiLargeView";
            this.tsmiLargeView.Size = new System.Drawing.Size(130, 22);
            this.tsmiLargeView.Text = "显示大头像";
            this.tsmiLargeView.Click += new System.EventHandler(this.tsmiLargeView_Click);
            // 
            // tsmiSmallView
            // 
            this.tsmiSmallView.Name = "tsmiSmallView";
            this.tsmiSmallView.Size = new System.Drawing.Size(130, 22);
            this.tsmiSmallView.Text = "显示小图像";
            this.tsmiSmallView.Click += new System.EventHandler(this.tsmiSmallView_Click);
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
            // 
            // btnConfirm
            // 
            this.btnConfirm.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnConfirm.Location = new System.Drawing.Point(122, 201);
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
            this.btnCancle.Location = new System.Drawing.Point(203, 201);
            this.btnCancle.Name = "btnCancle";
            this.btnCancle.Size = new System.Drawing.Size(75, 23);
            this.btnCancle.TabIndex = 2;
            this.btnCancle.Text = "取消";
            this.btnCancle.UseVisualStyleBackColor = true;
            this.btnCancle.Click += new System.EventHandler(this.btnCancle_Click);
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Location = new System.Drawing.Point(4, 1);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(285, 198);
            this.tabControl1.TabIndex = 3;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.lvFace);
            this.tabPage1.Location = new System.Drawing.Point(4, 21);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(277, 173);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Q版拳王头像";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.lvFace2);
            this.tabPage2.Location = new System.Drawing.Point(4, 21);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(277, 173);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "非主流头像";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // lvFace2
            // 
            this.lvFace2.ContextMenuStrip = this.contextMenuStrip1;
            this.lvFace2.Location = new System.Drawing.Point(6, 1);
            this.lvFace2.MultiSelect = false;
            this.lvFace2.Name = "lvFace2";
            this.lvFace2.Size = new System.Drawing.Size(274, 169);
            this.lvFace2.SmallImageList = this.ilFaceThums;
            this.lvFace2.TabIndex = 1;
            this.lvFace2.UseCompatibleStateImageBehavior = false;
            this.lvFace2.SelectedIndexChanged += new System.EventHandler(this.lvFace2_SelectedIndexChanged);
            // 
            // Frm_selectImage
            // 
            this.AcceptButton = this.btnConfirm;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.CancelButton = this.btnCancle;
            this.ClientSize = new System.Drawing.Size(289, 225);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.btnCancle);
            this.Controls.Add(this.btnConfirm);
            this.Name = "Frm_selectImage";
            this.Text = "选择头像";
            this.Load += new System.EventHandler(this.Frm_selectImage_Load);
            this.contextMenuStrip1.ResumeLayout(false);
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView lvFace;
        private System.Windows.Forms.Button btnConfirm;
        private System.Windows.Forms.Button btnCancle;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.ListView lvFace2;
        private System.Windows.Forms.ImageList ilFaceThums;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem tsmiLargeView;
        private System.Windows.Forms.ToolStripMenuItem tsmiSmallView;
    }
}