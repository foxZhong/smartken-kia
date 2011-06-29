namespace BookSystem
{
    partial class frmAddBook
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnAddImg = new System.Windows.Forms.Button();
            this.cboRebate = new System.Windows.Forms.CheckBox();
            this.calPubDate = new System.Windows.Forms.DateTimePicker();
            this.nupStock = new System.Windows.Forms.NumericUpDown();
            this.nupPrice = new System.Windows.Forms.NumericUpDown();
            this.pbCover = new System.Windows.Forms.PictureBox();
            this.label12 = new System.Windows.Forms.Label();
            this.btnAdd = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.cobPub = new System.Windows.Forms.ComboBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.cobCategories = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.cobGenres = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtDesc = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.txtAuthor = new System.Windows.Forms.TextBox();
            this.txtISBN = new System.Windows.Forms.TextBox();
            this.label13 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.ofdCover = new System.Windows.Forms.OpenFileDialog();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nupStock)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nupPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbCover)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btnAddImg);
            this.groupBox1.Controls.Add(this.cboRebate);
            this.groupBox1.Controls.Add(this.calPubDate);
            this.groupBox1.Controls.Add(this.nupStock);
            this.groupBox1.Controls.Add(this.nupPrice);
            this.groupBox1.Controls.Add(this.pbCover);
            this.groupBox1.Controls.Add(this.label12);
            this.groupBox1.Controls.Add(this.btnAdd);
            this.groupBox1.Controls.Add(this.label8);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.cobPub);
            this.groupBox1.Controls.Add(this.txtName);
            this.groupBox1.Controls.Add(this.cobCategories);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.cobGenres);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.txtDesc);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.txtAuthor);
            this.groupBox1.Controls.Add(this.txtISBN);
            this.groupBox1.Controls.Add(this.label13);
            this.groupBox1.Controls.Add(this.label10);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Location = new System.Drawing.Point(2, 14);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(538, 490);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "新书入库";
            // 
            // btnAddImg
            // 
            this.btnAddImg.Location = new System.Drawing.Point(356, 202);
            this.btnAddImg.Name = "btnAddImg";
            this.btnAddImg.Size = new System.Drawing.Size(126, 21);
            this.btnAddImg.TabIndex = 57;
            this.btnAddImg.Text = "添加图片";
            this.btnAddImg.UseVisualStyleBackColor = true;
            this.btnAddImg.Click += new System.EventHandler(this.btnAddImg_Click);
            // 
            // cboRebate
            // 
            this.cboRebate.AutoSize = true;
            this.cboRebate.Location = new System.Drawing.Point(253, 246);
            this.cboRebate.Name = "cboRebate";
            this.cboRebate.Size = new System.Drawing.Size(72, 16);
            this.cboRebate.TabIndex = 56;
            this.cboRebate.Text = "是否打折";
            this.cboRebate.UseVisualStyleBackColor = true;
            // 
            // calPubDate
            // 
            this.calPubDate.Location = new System.Drawing.Point(95, 215);
            this.calPubDate.Name = "calPubDate";
            this.calPubDate.Size = new System.Drawing.Size(145, 21);
            this.calPubDate.TabIndex = 55;
            this.calPubDate.Value = new System.DateTime(2009, 6, 24, 0, 0, 0, 0);
            // 
            // nupStock
            // 
            this.nupStock.Location = new System.Drawing.Point(95, 247);
            this.nupStock.Name = "nupStock";
            this.nupStock.Size = new System.Drawing.Size(79, 21);
            this.nupStock.TabIndex = 53;
            // 
            // nupPrice
            // 
            this.nupPrice.Location = new System.Drawing.Point(95, 189);
            this.nupPrice.Name = "nupPrice";
            this.nupPrice.Size = new System.Drawing.Size(79, 21);
            this.nupPrice.TabIndex = 54;
            // 
            // pbCover
            // 
            this.pbCover.Location = new System.Drawing.Point(356, 32);
            this.pbCover.Name = "pbCover";
            this.pbCover.Size = new System.Drawing.Size(126, 150);
            this.pbCover.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbCover.TabIndex = 52;
            this.pbCover.TabStop = false;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(271, 29);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(65, 12);
            this.label12.TabIndex = 51;
            this.label12.Text = "图书封面：";
            // 
            // btnAdd
            // 
            this.btnAdd.Location = new System.Drawing.Point(228, 448);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(75, 23);
            this.btnAdd.TabIndex = 33;
            this.btnAdd.Text = "添 加";
            this.btnAdd.UseVisualStyleBackColor = true;
            this.btnAdd.Click += new System.EventHandler(this.btnAdd_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(26, 277);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(41, 12);
            this.label8.TabIndex = 50;
            this.label8.Text = "简介：";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(38, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 42;
            this.label1.Text = "书名：";
            // 
            // cobPub
            // 
            this.cobPub.FormattingEnabled = true;
            this.cobPub.Location = new System.Drawing.Point(95, 80);
            this.cobPub.Name = "cobPub";
            this.cobPub.Size = new System.Drawing.Size(145, 20);
            this.cobPub.TabIndex = 48;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(95, 20);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(145, 21);
            this.txtName.TabIndex = 45;
            // 
            // cobCategories
            // 
            this.cobCategories.FormattingEnabled = true;
            this.cobCategories.Location = new System.Drawing.Point(95, 111);
            this.cobCategories.Name = "cobCategories";
            this.cobCategories.Size = new System.Drawing.Size(145, 20);
            this.cobCategories.TabIndex = 47;
            this.cobCategories.SelectedIndexChanged += new System.EventHandler(this.cobCategories_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(14, 111);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 12);
            this.label5.TabIndex = 41;
            this.label5.Text = "一级标题：";
            // 
            // cobGenres
            // 
            this.cobGenres.FormattingEnabled = true;
            this.cobGenres.Location = new System.Drawing.Point(95, 137);
            this.cobGenres.Name = "cobGenres";
            this.cobGenres.Size = new System.Drawing.Size(145, 20);
            this.cobGenres.TabIndex = 49;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(26, 53);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 35;
            this.label2.Text = "ISBN码：";
            // 
            // txtDesc
            // 
            this.txtDesc.Location = new System.Drawing.Point(16, 301);
            this.txtDesc.Multiline = true;
            this.txtDesc.Name = "txtDesc";
            this.txtDesc.Size = new System.Drawing.Size(499, 141);
            this.txtDesc.TabIndex = 46;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(14, 143);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(65, 12);
            this.label6.TabIndex = 40;
            this.label6.Text = "二级标题：";
            // 
            // txtAuthor
            // 
            this.txtAuthor.Location = new System.Drawing.Point(95, 164);
            this.txtAuthor.Name = "txtAuthor";
            this.txtAuthor.Size = new System.Drawing.Size(145, 21);
            this.txtAuthor.TabIndex = 43;
            // 
            // txtISBN
            // 
            this.txtISBN.Location = new System.Drawing.Point(95, 50);
            this.txtISBN.Name = "txtISBN";
            this.txtISBN.Size = new System.Drawing.Size(145, 21);
            this.txtISBN.TabIndex = 44;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(26, 247);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(53, 12);
            this.label13.TabIndex = 38;
            this.label13.Text = "库存数：";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(14, 217);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(65, 12);
            this.label10.TabIndex = 39;
            this.label10.Text = "出版日期：";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(14, 167);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 12);
            this.label4.TabIndex = 37;
            this.label4.Text = "作者姓名：";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(38, 191);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 36;
            this.label3.Text = "价格：";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(26, 83);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(53, 12);
            this.label7.TabIndex = 34;
            this.label7.Text = "出版社：";
            // 
            // frmAddBook
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(546, 510);
            this.Controls.Add(this.groupBox1);
            this.MaximizeBox = false;
            this.Name = "frmAddBook";
            this.Text = "InsertBook";
            this.Load += new System.EventHandler(this.frmAddBook_Load);
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmAddBook_FormClosed);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nupStock)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nupPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbCover)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.CheckBox cboRebate;
        private System.Windows.Forms.DateTimePicker calPubDate;
        private System.Windows.Forms.NumericUpDown nupStock;
        private System.Windows.Forms.NumericUpDown nupPrice;
        private System.Windows.Forms.PictureBox pbCover;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cobPub;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.ComboBox cobCategories;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ComboBox cobGenres;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtDesc;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox txtAuthor;
        private System.Windows.Forms.TextBox txtISBN;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button btnAddImg;
        private System.Windows.Forms.OpenFileDialog ofdCover;


    }
}