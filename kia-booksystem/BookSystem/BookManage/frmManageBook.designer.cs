namespace BookSystem
{
    partial class frmManageBook
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
            this.txtDesc = new System.Windows.Forms.TextBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.lbStatue = new System.Windows.Forms.Label();
            this.label22 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lbStock = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.lbPubDate = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.lbPrice = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lbGenre = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.lbAuthor = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.lbCatgroie = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.lbPub = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.lbIsbn = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.lbName = new System.Windows.Forms.Label();
            this.tvBooks = new System.Windows.Forms.TreeView();
            this.pbCover = new System.Windows.Forms.PictureBox();
            this.label12 = new System.Windows.Forms.Label();
            this.BtnDelet = new System.Windows.Forms.Button();
            this.BtnUpdate = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.BtnReturn = new System.Windows.Forms.Button();
            this.btnSearch = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbCover)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.txtDesc);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Controls.Add(this.tvBooks);
            this.groupBox1.Controls.Add(this.pbCover);
            this.groupBox1.Controls.Add(this.label12);
            this.groupBox1.Controls.Add(this.BtnDelet);
            this.groupBox1.Controls.Add(this.BtnUpdate);
            this.groupBox1.Controls.Add(this.label8);
            this.groupBox1.Location = new System.Drawing.Point(6, 5);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(616, 483);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "库存管理";
            // 
            // txtDesc
            // 
            this.txtDesc.Location = new System.Drawing.Point(209, 367);
            this.txtDesc.Multiline = true;
            this.txtDesc.Name = "txtDesc";
            this.txtDesc.ReadOnly = true;
            this.txtDesc.Size = new System.Drawing.Size(394, 109);
            this.txtDesc.TabIndex = 92;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.lbStatue);
            this.groupBox2.Controls.Add(this.label22);
            this.groupBox2.Controls.Add(this.label1);
            this.groupBox2.Controls.Add(this.lbStock);
            this.groupBox2.Controls.Add(this.label7);
            this.groupBox2.Controls.Add(this.lbPubDate);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.lbPrice);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.lbGenre);
            this.groupBox2.Controls.Add(this.label10);
            this.groupBox2.Controls.Add(this.lbAuthor);
            this.groupBox2.Controls.Add(this.label13);
            this.groupBox2.Controls.Add(this.lbCatgroie);
            this.groupBox2.Controls.Add(this.label6);
            this.groupBox2.Controls.Add(this.lbPub);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.lbIsbn);
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Controls.Add(this.lbName);
            this.groupBox2.Location = new System.Drawing.Point(199, 31);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(231, 309);
            this.groupBox2.TabIndex = 91;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "书籍信息";
            // 
            // lbStatue
            // 
            this.lbStatue.AutoSize = true;
            this.lbStatue.Location = new System.Drawing.Point(97, 277);
            this.lbStatue.Name = "lbStatue";
            this.lbStatue.Size = new System.Drawing.Size(47, 12);
            this.lbStatue.TabIndex = 92;
            this.lbStatue.Text = "label23";
            // 
            // label22
            // 
            this.label22.AutoSize = true;
            this.label22.Location = new System.Drawing.Point(40, 277);
            this.label22.Name = "label22";
            this.label22.Size = new System.Drawing.Size(41, 12);
            this.label22.TabIndex = 91;
            this.label22.Text = "打折：";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(40, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 66;
            this.label1.Text = "书名：";
            // 
            // lbStock
            // 
            this.lbStock.AutoSize = true;
            this.lbStock.Location = new System.Drawing.Point(97, 253);
            this.lbStock.Name = "lbStock";
            this.lbStock.Size = new System.Drawing.Size(47, 12);
            this.lbStock.TabIndex = 90;
            this.lbStock.Text = "label21";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(28, 87);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(53, 12);
            this.label7.TabIndex = 58;
            this.label7.Text = "出版社：";
            // 
            // lbPubDate
            // 
            this.lbPubDate.AutoSize = true;
            this.lbPubDate.Location = new System.Drawing.Point(97, 225);
            this.lbPubDate.Name = "lbPubDate";
            this.lbPubDate.Size = new System.Drawing.Size(47, 12);
            this.lbPubDate.TabIndex = 89;
            this.lbPubDate.Text = "label20";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(40, 195);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(41, 12);
            this.label3.TabIndex = 60;
            this.label3.Text = "价格：";
            // 
            // lbPrice
            // 
            this.lbPrice.AutoSize = true;
            this.lbPrice.Location = new System.Drawing.Point(97, 195);
            this.lbPrice.Name = "lbPrice";
            this.lbPrice.Size = new System.Drawing.Size(47, 12);
            this.lbPrice.TabIndex = 88;
            this.lbPrice.Text = "label19";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(16, 171);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(65, 12);
            this.label4.TabIndex = 61;
            this.label4.Text = "作者姓名：";
            // 
            // lbGenre
            // 
            this.lbGenre.AutoSize = true;
            this.lbGenre.Location = new System.Drawing.Point(97, 144);
            this.lbGenre.Name = "lbGenre";
            this.lbGenre.Size = new System.Drawing.Size(47, 12);
            this.lbGenre.TabIndex = 87;
            this.lbGenre.Text = "label18";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(16, 225);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(65, 12);
            this.label10.TabIndex = 63;
            this.label10.Text = "出版日期：";
            // 
            // lbAuthor
            // 
            this.lbAuthor.AutoSize = true;
            this.lbAuthor.Location = new System.Drawing.Point(95, 171);
            this.lbAuthor.Name = "lbAuthor";
            this.lbAuthor.Size = new System.Drawing.Size(47, 12);
            this.lbAuthor.TabIndex = 86;
            this.lbAuthor.Text = "label17";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(28, 253);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(53, 12);
            this.label13.TabIndex = 62;
            this.label13.Text = "库存数：";
            // 
            // lbCatgroie
            // 
            this.lbCatgroie.AutoSize = true;
            this.lbCatgroie.Location = new System.Drawing.Point(97, 115);
            this.lbCatgroie.Name = "lbCatgroie";
            this.lbCatgroie.Size = new System.Drawing.Size(47, 12);
            this.lbCatgroie.TabIndex = 85;
            this.lbCatgroie.Text = "label16";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(16, 144);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(65, 12);
            this.label6.TabIndex = 64;
            this.label6.Text = "二级标题：";
            // 
            // lbPub
            // 
            this.lbPub.AutoSize = true;
            this.lbPub.Location = new System.Drawing.Point(97, 87);
            this.lbPub.Name = "lbPub";
            this.lbPub.Size = new System.Drawing.Size(47, 12);
            this.lbPub.TabIndex = 84;
            this.lbPub.Text = "label15";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(28, 57);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 59;
            this.label2.Text = "ISBN码：";
            // 
            // lbIsbn
            // 
            this.lbIsbn.AutoSize = true;
            this.lbIsbn.Location = new System.Drawing.Point(97, 57);
            this.lbIsbn.Name = "lbIsbn";
            this.lbIsbn.Size = new System.Drawing.Size(47, 12);
            this.lbIsbn.TabIndex = 83;
            this.lbIsbn.Text = "label14";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(16, 115);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(65, 12);
            this.label5.TabIndex = 65;
            this.label5.Text = "一级标题：";
            // 
            // lbName
            // 
            this.lbName.Location = new System.Drawing.Point(95, 17);
            this.lbName.Name = "lbName";
            this.lbName.Size = new System.Drawing.Size(128, 40);
            this.lbName.TabIndex = 82;
            this.lbName.Text = "label11";
            // 
            // tvBooks
            // 
            this.tvBooks.Location = new System.Drawing.Point(6, 18);
            this.tvBooks.Name = "tvBooks";
            this.tvBooks.Size = new System.Drawing.Size(174, 458);
            this.tvBooks.TabIndex = 81;
            this.tvBooks.NodeMouseDoubleClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.tvBooks_NodeMouseDoubleClick);
            this.tvBooks.NodeMouseClick += new System.Windows.Forms.TreeNodeMouseClickEventHandler(this.tvBooks_NodeMouseClick);
            // 
            // pbCover
            // 
            this.pbCover.Location = new System.Drawing.Point(446, 48);
            this.pbCover.Name = "pbCover";
            this.pbCover.Size = new System.Drawing.Size(142, 184);
            this.pbCover.TabIndex = 76;
            this.pbCover.TabStop = false;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(444, 23);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(65, 12);
            this.label12.TabIndex = 75;
            this.label12.Text = "图书封面：";
            // 
            // BtnDelet
            // 
            this.BtnDelet.Location = new System.Drawing.Point(473, 312);
            this.BtnDelet.Name = "BtnDelet";
            this.BtnDelet.Size = new System.Drawing.Size(75, 23);
            this.BtnDelet.TabIndex = 57;
            this.BtnDelet.Text = "删 除";
            this.BtnDelet.UseVisualStyleBackColor = true;
            this.BtnDelet.Click += new System.EventHandler(this.BtnDelet_Click);
            // 
            // BtnUpdate
            // 
            this.BtnUpdate.Location = new System.Drawing.Point(473, 273);
            this.BtnUpdate.Name = "BtnUpdate";
            this.BtnUpdate.Size = new System.Drawing.Size(75, 23);
            this.BtnUpdate.TabIndex = 57;
            this.BtnUpdate.Text = "修 改";
            this.BtnUpdate.UseVisualStyleBackColor = true;
            this.BtnUpdate.Click += new System.EventHandler(this.BtnUpdate_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(207, 352);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(41, 12);
            this.label8.TabIndex = 74;
            this.label8.Text = "简介：";
            // 
            // BtnReturn
            // 
            this.BtnReturn.Location = new System.Drawing.Point(519, 505);
            this.BtnReturn.Name = "BtnReturn";
            this.BtnReturn.Size = new System.Drawing.Size(75, 23);
            this.BtnReturn.TabIndex = 57;
            this.BtnReturn.Text = "返 回";
            this.BtnReturn.UseVisualStyleBackColor = true;
            this.BtnReturn.Click += new System.EventHandler(this.BtnReturn_Click);
            // 
            // btnSearch
            // 
            this.btnSearch.Location = new System.Drawing.Point(397, 505);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(75, 23);
            this.btnSearch.TabIndex = 57;
            this.btnSearch.Text = "高级查询";
            this.btnSearch.UseVisualStyleBackColor = true;
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // frmManageBook
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(629, 530);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.BtnReturn);
            this.Controls.Add(this.btnSearch);
            this.MaximizeBox = false;
            this.Name = "frmManageBook";
            this.Text = "FrmUpdateBook";
            this.Load += new System.EventHandler(this.FrmManageBook_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbCover)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.PictureBox pbCover;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Button BtnUpdate;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Button BtnDelet;
        private System.Windows.Forms.Button BtnReturn;
        private System.Windows.Forms.TreeView tvBooks;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label lbStock;
        private System.Windows.Forms.Label lbPubDate;
        private System.Windows.Forms.Label lbPrice;
        private System.Windows.Forms.Label lbGenre;
        private System.Windows.Forms.Label lbAuthor;
        private System.Windows.Forms.Label lbCatgroie;
        private System.Windows.Forms.Label lbPub;
        private System.Windows.Forms.Label lbIsbn;
        private System.Windows.Forms.Label lbName;
        private System.Windows.Forms.Label lbStatue;
        private System.Windows.Forms.Label label22;
        private System.Windows.Forms.TextBox txtDesc;
        private System.Windows.Forms.Button btnSearch;
    }
}