namespace BookSystem
{
    partial class frmUpdateBook
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
            this.cboRebate = new System.Windows.Forms.CheckBox();
            this.calPubDate = new System.Windows.Forms.DateTimePicker();
            this.nupStock = new System.Windows.Forms.NumericUpDown();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.btnChangeCover = new System.Windows.Forms.Button();
            this.nupPrice = new System.Windows.Forms.NumericUpDown();
            this.pbCover = new System.Windows.Forms.PictureBox();
            this.label12 = new System.Windows.Forms.Label();
            this.BtnReset = new System.Windows.Forms.Button();
            this.BtnUpdate = new System.Windows.Forms.Button();
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
            this.BtnReturn = new System.Windows.Forms.Button();
            this.ofdChangeCover = new System.Windows.Forms.OpenFileDialog();
            ((System.ComponentModel.ISupportInitialize)(this.nupStock)).BeginInit();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nupPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbCover)).BeginInit();
            this.SuspendLayout();
            // 
            // cboRebate
            // 
            this.cboRebate.AutoSize = true;
            this.cboRebate.Location = new System.Drawing.Point(196, 251);
            this.cboRebate.Name = "cboRebate";
            this.cboRebate.Size = new System.Drawing.Size(72, 16);
            this.cboRebate.TabIndex = 105;
            this.cboRebate.Text = "是否打折";
            this.cboRebate.UseVisualStyleBackColor = true;
            // 
            // calPubDate
            // 
            this.calPubDate.Location = new System.Drawing.Point(111, 214);
            this.calPubDate.Name = "calPubDate";
            this.calPubDate.Size = new System.Drawing.Size(145, 21);
            this.calPubDate.TabIndex = 104;
            // 
            // nupStock
            // 
            this.nupStock.Location = new System.Drawing.Point(111, 246);
            this.nupStock.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nupStock.Name = "nupStock";
            this.nupStock.Size = new System.Drawing.Size(79, 21);
            this.nupStock.TabIndex = 102;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btnChangeCover);
            this.groupBox1.Controls.Add(this.cboRebate);
            this.groupBox1.Controls.Add(this.calPubDate);
            this.groupBox1.Controls.Add(this.nupStock);
            this.groupBox1.Controls.Add(this.nupPrice);
            this.groupBox1.Controls.Add(this.pbCover);
            this.groupBox1.Controls.Add(this.label12);
            this.groupBox1.Controls.Add(this.BtnReset);
            this.groupBox1.Controls.Add(this.BtnUpdate);
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
            this.groupBox1.Location = new System.Drawing.Point(2, 1);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(462, 482);
            this.groupBox1.TabIndex = 59;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "图书管理";
            // 
            // btnChangeCover
            // 
            this.btnChangeCover.Location = new System.Drawing.Point(299, 247);
            this.btnChangeCover.Name = "btnChangeCover";
            this.btnChangeCover.Size = new System.Drawing.Size(127, 21);
            this.btnChangeCover.TabIndex = 106;
            this.btnChangeCover.Text = "修改封面";
            this.btnChangeCover.UseVisualStyleBackColor = true;
            this.btnChangeCover.Click += new System.EventHandler(this.btnChangeCover_Click);
            // 
            // nupPrice
            // 
            this.nupPrice.Location = new System.Drawing.Point(111, 188);
            this.nupPrice.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nupPrice.Name = "nupPrice";
            this.nupPrice.Size = new System.Drawing.Size(79, 21);
            this.nupPrice.TabIndex = 103;
            // 
            // pbCover
            // 
            this.pbCover.Location = new System.Drawing.Point(298, 47);
            this.pbCover.Name = "pbCover";
            this.pbCover.Size = new System.Drawing.Size(142, 184);
            this.pbCover.TabIndex = 101;
            this.pbCover.TabStop = false;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(296, 22);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(65, 12);
            this.label12.TabIndex = 100;
            this.label12.Text = "图书封面：";
            // 
            // BtnReset
            // 
            this.BtnReset.Location = new System.Drawing.Point(241, 450);
            this.BtnReset.Name = "BtnReset";
            this.BtnReset.Size = new System.Drawing.Size(75, 23);
            this.BtnReset.TabIndex = 81;
            this.BtnReset.Text = "重 置";
            this.BtnReset.UseVisualStyleBackColor = true;
            this.BtnReset.Click += new System.EventHandler(this.BtnReset_Click);
            // 
            // BtnUpdate
            // 
            this.BtnUpdate.Location = new System.Drawing.Point(111, 450);
            this.BtnUpdate.Name = "BtnUpdate";
            this.BtnUpdate.Size = new System.Drawing.Size(75, 23);
            this.BtnUpdate.TabIndex = 82;
            this.BtnUpdate.Text = "修 改";
            this.BtnUpdate.UseVisualStyleBackColor = true;
            this.BtnUpdate.Click += new System.EventHandler(this.BtnUpdate_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(30, 271);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(65, 12);
            this.label8.TabIndex = 99;
            this.label8.Text = "简    介：";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(30, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(65, 12);
            this.label1.TabIndex = 91;
            this.label1.Text = "书    名：";
            // 
            // cobPub
            // 
            this.cobPub.FormattingEnabled = true;
            this.cobPub.Location = new System.Drawing.Point(111, 79);
            this.cobPub.Name = "cobPub";
            this.cobPub.Size = new System.Drawing.Size(145, 20);
            this.cobPub.TabIndex = 97;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(111, 19);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(145, 21);
            this.txtName.TabIndex = 94;
            // 
            // cobCategories
            // 
            this.cobCategories.FormattingEnabled = true;
            this.cobCategories.Location = new System.Drawing.Point(111, 107);
            this.cobCategories.Name = "cobCategories";
            this.cobCategories.Size = new System.Drawing.Size(145, 20);
            this.cobCategories.TabIndex = 96;
            this.cobCategories.SelectedIndexChanged += new System.EventHandler(this.cobCategories_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(30, 110);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 12);
            this.label5.TabIndex = 90;
            this.label5.Text = "一级标题：";
            // 
            // cobGenres
            // 
            this.cobGenres.FormattingEnabled = true;
            this.cobGenres.Location = new System.Drawing.Point(111, 136);
            this.cobGenres.Name = "cobGenres";
            this.cobGenres.Size = new System.Drawing.Size(145, 20);
            this.cobGenres.TabIndex = 98;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(30, 52);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 12);
            this.label2.TabIndex = 84;
            this.label2.Text = "I S B N ：";
            // 
            // txtDesc
            // 
            this.txtDesc.Location = new System.Drawing.Point(21, 295);
            this.txtDesc.Multiline = true;
            this.txtDesc.Name = "txtDesc";
            this.txtDesc.Size = new System.Drawing.Size(419, 141);
            this.txtDesc.TabIndex = 95;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(30, 139);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(65, 12);
            this.label6.TabIndex = 89;
            this.label6.Text = "二级标题：";
            // 
            // txtAuthor
            // 
            this.txtAuthor.Location = new System.Drawing.Point(111, 163);
            this.txtAuthor.Name = "txtAuthor";
            this.txtAuthor.Size = new System.Drawing.Size(145, 21);
            this.txtAuthor.TabIndex = 92;
            // 
            // txtISBN
            // 
            this.txtISBN.Location = new System.Drawing.Point(111, 49);
            this.txtISBN.Name = "txtISBN";
            this.txtISBN.Size = new System.Drawing.Size(145, 21);
            this.txtISBN.TabIndex = 93;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(30, 248);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(65, 12);
            this.label13.TabIndex = 87;
            this.label13.Text = "库 存 数：";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(30, 220);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(65, 12);
            this.label10.TabIndex = 88;
            this.label10.Text = "出版日期：";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(30, 166);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 12);
            this.label4.TabIndex = 86;
            this.label4.Text = "作者姓名：";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(30, 190);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(65, 12);
            this.label3.TabIndex = 85;
            this.label3.Text = "价    格：";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(30, 82);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(65, 12);
            this.label7.TabIndex = 83;
            this.label7.Text = "出 版 社：";
            // 
            // BtnReturn
            // 
            this.BtnReturn.Location = new System.Drawing.Point(389, 489);
            this.BtnReturn.Name = "BtnReturn";
            this.BtnReturn.Size = new System.Drawing.Size(75, 23);
            this.BtnReturn.TabIndex = 60;
            this.BtnReturn.Text = "返 回";
            this.BtnReturn.UseVisualStyleBackColor = true;
            this.BtnReturn.Click += new System.EventHandler(this.BtnReturn_Click);
            // 
            // frmUpdateBook
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(467, 513);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.BtnReturn);
            this.MaximizeBox = false;
            this.Name = "frmUpdateBook";
            this.Text = "frmUpdateBook";
            this.Load += new System.EventHandler(this.frmUpdateBook_Load);
            ((System.ComponentModel.ISupportInitialize)(this.nupStock)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nupPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbCover)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.CheckBox cboRebate;
        private System.Windows.Forms.DateTimePicker calPubDate;
        private System.Windows.Forms.NumericUpDown nupStock;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.NumericUpDown nupPrice;
        private System.Windows.Forms.PictureBox pbCover;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Button BtnReset;
        private System.Windows.Forms.Button BtnUpdate;
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
        private System.Windows.Forms.Button BtnReturn;
        private System.Windows.Forms.Button btnChangeCover;
        private System.Windows.Forms.OpenFileDialog ofdChangeCover;
    }
}