namespace BookSystem
{
    partial class frmSaleAccount
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
            this.lbInfo = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.cobPubshers = new System.Windows.Forms.ComboBox();
            this.txtIsbn = new System.Windows.Forms.TextBox();
            this.txtName = new System.Windows.Forms.TextBox();
            this.cobGenres = new System.Windows.Forms.ComboBox();
            this.cobCategories = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label6 = new System.Windows.Forms.Label();
            this.dtpMaxSaleDate = new System.Windows.Forms.DateTimePicker();
            this.dtpMinSaleDate = new System.Windows.Forms.DateTimePicker();
            this.dtpSaleDate = new System.Windows.Forms.DateTimePicker();
            this.chbSaleDateRang = new System.Windows.Forms.CheckBox();
            this.chbSaleDateExact = new System.Windows.Forms.CheckBox();
            this.dgSaleClassify = new System.Windows.Forms.DataGridView();
            this.b_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_isbn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.item_price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sum_count = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sumprice = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sale_date = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnSearch = new System.Windows.Forms.Button();
            this.btnReturn = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgSaleClassify)).BeginInit();
            this.SuspendLayout();
            // 
            // lbInfo
            // 
            this.lbInfo.AutoSize = true;
            this.lbInfo.Location = new System.Drawing.Point(19, 184);
            this.lbInfo.Name = "lbInfo";
            this.lbInfo.Size = new System.Drawing.Size(35, 13);
            this.lbInfo.TabIndex = 2;
            this.lbInfo.Text = "label7";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.cobPubshers);
            this.groupBox1.Controls.Add(this.txtIsbn);
            this.groupBox1.Controls.Add(this.txtName);
            this.groupBox1.Controls.Add(this.cobGenres);
            this.groupBox1.Controls.Add(this.cobCategories);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Location = new System.Drawing.Point(22, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(708, 137);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "查询条件";
            // 
            // cobPubshers
            // 
            this.cobPubshers.FormattingEnabled = true;
            this.cobPubshers.Location = new System.Drawing.Point(451, 23);
            this.cobPubshers.Name = "cobPubshers";
            this.cobPubshers.Size = new System.Drawing.Size(166, 21);
            this.cobPubshers.TabIndex = 10;
            this.cobPubshers.SelectedIndexChanged += new System.EventHandler(this.cobPubshers_SelectedIndexChanged);
            // 
            // txtIsbn
            // 
            this.txtIsbn.Location = new System.Drawing.Point(451, 56);
            this.txtIsbn.Name = "txtIsbn";
            this.txtIsbn.Size = new System.Drawing.Size(166, 20);
            this.txtIsbn.TabIndex = 9;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(80, 55);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(279, 20);
            this.txtName.TabIndex = 8;
            // 
            // cobGenres
            // 
            this.cobGenres.FormattingEnabled = true;
            this.cobGenres.Location = new System.Drawing.Point(264, 23);
            this.cobGenres.Name = "cobGenres";
            this.cobGenres.Size = new System.Drawing.Size(95, 21);
            this.cobGenres.TabIndex = 7;
            this.cobGenres.SelectedIndexChanged += new System.EventHandler(this.cobGenres_SelectedIndexChanged);
            // 
            // cobCategories
            // 
            this.cobCategories.FormattingEnabled = true;
            this.cobCategories.Location = new System.Drawing.Point(80, 23);
            this.cobCategories.Name = "cobCategories";
            this.cobCategories.Size = new System.Drawing.Size(98, 21);
            this.cobCategories.TabIndex = 6;
            this.cobCategories.SelectedIndexChanged += new System.EventHandler(this.cobCategories_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(399, 26);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(46, 13);
            this.label5.TabIndex = 5;
            this.label5.Text = "出版社:";
            this.label5.Click += new System.EventHandler(this.label5_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(415, 59);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(30, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Isbn:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(40, 59);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(34, 13);
            this.label3.TabIndex = 3;
            this.label3.Text = "书名:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(200, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(58, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "二级类型:";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(58, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "一级类型:";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label6);
            this.groupBox2.Controls.Add(this.dtpMaxSaleDate);
            this.groupBox2.Controls.Add(this.dtpMinSaleDate);
            this.groupBox2.Controls.Add(this.dtpSaleDate);
            this.groupBox2.Controls.Add(this.chbSaleDateRang);
            this.groupBox2.Controls.Add(this.chbSaleDateExact);
            this.groupBox2.Location = new System.Drawing.Point(19, 81);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(548, 50);
            this.groupBox2.TabIndex = 0;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "按日期查找";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(399, 25);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(14, 13);
            this.label6.TabIndex = 5;
            this.label6.Text = "~";
            // 
            // dtpMaxSaleDate
            // 
            this.dtpMaxSaleDate.CustomFormat = "yyyy-MM-dd";
            this.dtpMaxSaleDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpMaxSaleDate.Location = new System.Drawing.Point(418, 19);
            this.dtpMaxSaleDate.Name = "dtpMaxSaleDate";
            this.dtpMaxSaleDate.Size = new System.Drawing.Size(115, 20);
            this.dtpMaxSaleDate.TabIndex = 4;
            // 
            // dtpMinSaleDate
            // 
            this.dtpMinSaleDate.CustomFormat = "yyyy-MM-dd";
            this.dtpMinSaleDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpMinSaleDate.Location = new System.Drawing.Point(278, 19);
            this.dtpMinSaleDate.Name = "dtpMinSaleDate";
            this.dtpMinSaleDate.Size = new System.Drawing.Size(115, 20);
            this.dtpMinSaleDate.TabIndex = 3;
            // 
            // dtpSaleDate
            // 
            this.dtpSaleDate.CustomFormat = "yyyy-MM-dd";
            this.dtpSaleDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpSaleDate.Location = new System.Drawing.Point(71, 16);
            this.dtpSaleDate.Name = "dtpSaleDate";
            this.dtpSaleDate.Size = new System.Drawing.Size(115, 20);
            this.dtpSaleDate.TabIndex = 2;
            // 
            // chbSaleDateRang
            // 
            this.chbSaleDateRang.AutoSize = true;
            this.chbSaleDateRang.Location = new System.Drawing.Point(219, 19);
            this.chbSaleDateRang.Name = "chbSaleDateRang";
            this.chbSaleDateRang.Size = new System.Drawing.Size(53, 17);
            this.chbSaleDateRang.TabIndex = 1;
            this.chbSaleDateRang.Text = "范围:";
            this.chbSaleDateRang.UseVisualStyleBackColor = true;
            this.chbSaleDateRang.CheckedChanged += new System.EventHandler(this.chbSaleDateRang_CheckedChanged);
            // 
            // chbSaleDateExact
            // 
            this.chbSaleDateExact.AutoSize = true;
            this.chbSaleDateExact.Location = new System.Drawing.Point(12, 19);
            this.chbSaleDateExact.Name = "chbSaleDateExact";
            this.chbSaleDateExact.Size = new System.Drawing.Size(53, 17);
            this.chbSaleDateExact.TabIndex = 0;
            this.chbSaleDateExact.Text = "精确:";
            this.chbSaleDateExact.UseVisualStyleBackColor = true;
            this.chbSaleDateExact.CheckedChanged += new System.EventHandler(this.chbSaleDateExact_CheckedChanged);
            // 
            // dgSaleClassify
            // 
            this.dgSaleClassify.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgSaleClassify.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.b_name,
            this.b_isbn,
            this.b_price,
            this.item_price,
            this.sum_count,
            this.sumprice,
            this.sale_date});
            this.dgSaleClassify.Location = new System.Drawing.Point(12, 200);
            this.dgSaleClassify.Name = "dgSaleClassify";
            this.dgSaleClassify.Size = new System.Drawing.Size(714, 159);
            this.dgSaleClassify.TabIndex = 0;
            // 
            // b_name
            // 
            this.b_name.DataPropertyName = "b_name";
            this.b_name.HeaderText = "书名";
            this.b_name.Name = "b_name";
            // 
            // b_isbn
            // 
            this.b_isbn.DataPropertyName = "b_isbn";
            this.b_isbn.HeaderText = "ISBN";
            this.b_isbn.Name = "b_isbn";
            // 
            // b_price
            // 
            this.b_price.DataPropertyName = "b_price";
            this.b_price.HeaderText = "原价";
            this.b_price.Name = "b_price";
            // 
            // item_price
            // 
            this.item_price.DataPropertyName = "item_price";
            this.item_price.HeaderText = "销售价格";
            this.item_price.Name = "item_price";
            // 
            // sum_count
            // 
            this.sum_count.DataPropertyName = "item_count";
            this.sum_count.HeaderText = "出货数量";
            this.sum_count.Name = "sum_count";
            // 
            // sumprice
            // 
            this.sumprice.DataPropertyName = "sumprice";
            this.sumprice.HeaderText = "总计";
            this.sumprice.Name = "sumprice";
            // 
            // sale_date
            // 
            this.sale_date.DataPropertyName = "sale_date";
            this.sale_date.HeaderText = "销售时间";
            this.sale_date.Name = "sale_date";
            // 
            // btnSearch
            // 
            this.btnSearch.Location = new System.Drawing.Point(554, 375);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(75, 23);
            this.btnSearch.TabIndex = 1;
            this.btnSearch.Text = "搜索";
            this.btnSearch.UseVisualStyleBackColor = true;
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // btnReturn
            // 
            this.btnReturn.Location = new System.Drawing.Point(651, 375);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(75, 23);
            this.btnReturn.TabIndex = 2;
            this.btnReturn.Text = "返回";
            this.btnReturn.UseVisualStyleBackColor = true;
            // 
            // frmSaleAccount
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(742, 424);
            this.Controls.Add(this.lbInfo);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnReturn);
            this.Controls.Add(this.dgSaleClassify);
            this.Controls.Add(this.btnSearch);
            this.Name = "frmSaleAccount";
            this.Text = "frmSaleAccount";
            this.Load += new System.EventHandler(this.frmSaleAccount_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgSaleClassify)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView dgSaleClassify;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cobPubshers;
        private System.Windows.Forms.TextBox txtIsbn;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.ComboBox cobGenres;
        private System.Windows.Forms.ComboBox cobCategories;
        private System.Windows.Forms.CheckBox chbSaleDateRang;
        private System.Windows.Forms.CheckBox chbSaleDateExact;
        private System.Windows.Forms.DateTimePicker dtpMaxSaleDate;
        private System.Windows.Forms.DateTimePicker dtpMinSaleDate;
        private System.Windows.Forms.DateTimePicker dtpSaleDate;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label lbInfo;
        private System.Windows.Forms.Button btnSearch;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_isbn;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_price;
        private System.Windows.Forms.DataGridViewTextBoxColumn item_price;
        private System.Windows.Forms.DataGridViewTextBoxColumn sum_count;
        private System.Windows.Forms.DataGridViewTextBoxColumn sumprice;
        private System.Windows.Forms.DataGridViewTextBoxColumn sale_date;

    }
}