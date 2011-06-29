namespace BookSystem
{
    partial class frmSeachBook
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
            this.cobPubshers = new System.Windows.Forms.ComboBox();
            this.cobGenres = new System.Windows.Forms.ComboBox();
            this.cobCategories = new System.Windows.Forms.ComboBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.groupBox6 = new System.Windows.Forms.GroupBox();
            this.chbStockDateRang = new System.Windows.Forms.CheckBox();
            this.dtpStockDate = new System.Windows.Forms.DateTimePicker();
            this.chbSotckDateExact = new System.Windows.Forms.CheckBox();
            this.label7 = new System.Windows.Forms.Label();
            this.dtpMaxStockDate = new System.Windows.Forms.DateTimePicker();
            this.dtpMinStockDate = new System.Windows.Forms.DateTimePicker();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.chbUseDate = new System.Windows.Forms.CheckBox();
            this.label4 = new System.Windows.Forms.Label();
            this.dtpMaxPubDate = new System.Windows.Forms.DateTimePicker();
            this.dtpMinPubDate = new System.Windows.Forms.DateTimePicker();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.rabStatue0 = new System.Windows.Forms.RadioButton();
            this.rabStatue1 = new System.Windows.Forms.RadioButton();
            this.rabAllStatue = new System.Windows.Forms.RadioButton();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.chbPriceExact = new System.Windows.Forms.CheckBox();
            this.chbPriceRang = new System.Windows.Forms.CheckBox();
            this.nudMaxPrice = new System.Windows.Forms.NumericUpDown();
            this.label1 = new System.Windows.Forms.Label();
            this.nudPrice = new System.Windows.Forms.NumericUpDown();
            this.nudMinPrice = new System.Windows.Forms.NumericUpDown();
            this.dgvBooks = new System.Windows.Forms.DataGridView();
            this.b_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_isbn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_stock = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_author = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pub_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_pubdate = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.cat_title = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.gen_title = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.chbStockRang = new System.Windows.Forms.CheckBox();
            this.nudMaxStock = new System.Windows.Forms.NumericUpDown();
            this.chbStockExact = new System.Windows.Forms.CheckBox();
            this.label9 = new System.Windows.Forms.Label();
            this.nudStock = new System.Windows.Forms.NumericUpDown();
            this.nudMinStock = new System.Windows.Forms.NumericUpDown();
            this.txtAuthor = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtISBN = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.lbSearchInfo = new System.Windows.Forms.Label();
            this.btnSearch = new System.Windows.Forms.Button();
            this.btnReturn = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox6.SuspendLayout();
            this.groupBox5.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMaxPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMinPrice)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvBooks)).BeginInit();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMaxStock)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudStock)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMinStock)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.cobPubshers);
            this.groupBox1.Controls.Add(this.cobGenres);
            this.groupBox1.Controls.Add(this.cobCategories);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label10);
            this.groupBox1.Controls.Add(this.groupBox6);
            this.groupBox1.Controls.Add(this.groupBox5);
            this.groupBox1.Controls.Add(this.groupBox4);
            this.groupBox1.Controls.Add(this.groupBox3);
            this.groupBox1.Controls.Add(this.dgvBooks);
            this.groupBox1.Controls.Add(this.groupBox2);
            this.groupBox1.Controls.Add(this.txtAuthor);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.txtName);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.txtISBN);
            this.groupBox1.Controls.Add(this.label8);
            this.groupBox1.Controls.Add(this.lbSearchInfo);
            this.groupBox1.Location = new System.Drawing.Point(12, 8);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(718, 390);
            this.groupBox1.TabIndex = 43;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "高级搜索窗口";
            // 
            // cobPubshers
            // 
            this.cobPubshers.FormattingEnabled = true;
            this.cobPubshers.Location = new System.Drawing.Point(555, 22);
            this.cobPubshers.Name = "cobPubshers";
            this.cobPubshers.Size = new System.Drawing.Size(145, 20);
            this.cobPubshers.TabIndex = 125;
            // 
            // cobGenres
            // 
            this.cobGenres.FormattingEnabled = true;
            this.cobGenres.Location = new System.Drawing.Point(317, 22);
            this.cobGenres.Name = "cobGenres";
            this.cobGenres.Size = new System.Drawing.Size(143, 20);
            this.cobGenres.TabIndex = 124;
            // 
            // cobCategories
            // 
            this.cobCategories.FormattingEnabled = true;
            this.cobCategories.Location = new System.Drawing.Point(74, 24);
            this.cobCategories.Name = "cobCategories";
            this.cobCategories.Size = new System.Drawing.Size(145, 20);
            this.cobCategories.TabIndex = 123;
            this.cobCategories.SelectedIndexChanged += new System.EventHandler(this.cobCategories_SelectedIndexChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(482, 27);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(47, 12);
            this.label5.TabIndex = 122;
            this.label5.Text = "出版社:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(253, 25);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(59, 12);
            this.label6.TabIndex = 121;
            this.label6.Text = "二级类型:";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(10, 27);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(59, 12);
            this.label10.TabIndex = 120;
            this.label10.Text = "一级类型:";
            // 
            // groupBox6
            // 
            this.groupBox6.Controls.Add(this.chbStockDateRang);
            this.groupBox6.Controls.Add(this.dtpStockDate);
            this.groupBox6.Controls.Add(this.chbSotckDateExact);
            this.groupBox6.Controls.Add(this.label7);
            this.groupBox6.Controls.Add(this.dtpMaxStockDate);
            this.groupBox6.Controls.Add(this.dtpMinStockDate);
            this.groupBox6.Location = new System.Drawing.Point(16, 179);
            this.groupBox6.Name = "groupBox6";
            this.groupBox6.Size = new System.Drawing.Size(684, 36);
            this.groupBox6.TabIndex = 119;
            this.groupBox6.TabStop = false;
            this.groupBox6.Text = "按入库日期查找";
            // 
            // chbStockDateRang
            // 
            this.chbStockDateRang.AutoSize = true;
            this.chbStockDateRang.Location = new System.Drawing.Point(262, 14);
            this.chbStockDateRang.Name = "chbStockDateRang";
            this.chbStockDateRang.Size = new System.Drawing.Size(54, 16);
            this.chbStockDateRang.TabIndex = 115;
            this.chbStockDateRang.Text = "范围:";
            this.chbStockDateRang.UseVisualStyleBackColor = true;
            this.chbStockDateRang.CheckedChanged += new System.EventHandler(this.chbStockDateRang_CheckedChanged);
            // 
            // dtpStockDate
            // 
            this.dtpStockDate.CustomFormat = "yyyy-MM-dd";
            this.dtpStockDate.Enabled = false;
            this.dtpStockDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpStockDate.Location = new System.Drawing.Point(110, 12);
            this.dtpStockDate.Name = "dtpStockDate";
            this.dtpStockDate.Size = new System.Drawing.Size(85, 21);
            this.dtpStockDate.TabIndex = 114;
            this.dtpStockDate.Value = new System.DateTime(2009, 6, 28, 15, 14, 0, 0);
            // 
            // chbSotckDateExact
            // 
            this.chbSotckDateExact.AutoSize = true;
            this.chbSotckDateExact.Location = new System.Drawing.Point(26, 15);
            this.chbSotckDateExact.Name = "chbSotckDateExact";
            this.chbSotckDateExact.Size = new System.Drawing.Size(54, 16);
            this.chbSotckDateExact.TabIndex = 113;
            this.chbSotckDateExact.Text = "精确:";
            this.chbSotckDateExact.UseVisualStyleBackColor = true;
            this.chbSotckDateExact.CheckedChanged += new System.EventHandler(this.chbSotckDateExact_CheckedChanged);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(430, 16);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(11, 12);
            this.label7.TabIndex = 112;
            this.label7.Text = "~";
            // 
            // dtpMaxStockDate
            // 
            this.dtpMaxStockDate.CustomFormat = "yyyy-MM-dd";
            this.dtpMaxStockDate.Enabled = false;
            this.dtpMaxStockDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpMaxStockDate.Location = new System.Drawing.Point(452, 11);
            this.dtpMaxStockDate.Name = "dtpMaxStockDate";
            this.dtpMaxStockDate.Size = new System.Drawing.Size(83, 21);
            this.dtpMaxStockDate.TabIndex = 1;
            this.dtpMaxStockDate.Value = new System.DateTime(2009, 6, 28, 15, 14, 0, 0);
            // 
            // dtpMinStockDate
            // 
            this.dtpMinStockDate.CustomFormat = "yyyy-MM-dd";
            this.dtpMinStockDate.Enabled = false;
            this.dtpMinStockDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpMinStockDate.Location = new System.Drawing.Point(326, 11);
            this.dtpMinStockDate.Name = "dtpMinStockDate";
            this.dtpMinStockDate.Size = new System.Drawing.Size(85, 21);
            this.dtpMinStockDate.TabIndex = 0;
            this.dtpMinStockDate.Value = new System.DateTime(1990, 1, 1, 0, 0, 0, 0);
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.chbUseDate);
            this.groupBox5.Controls.Add(this.label4);
            this.groupBox5.Controls.Add(this.dtpMaxPubDate);
            this.groupBox5.Controls.Add(this.dtpMinPubDate);
            this.groupBox5.Location = new System.Drawing.Point(368, 138);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(332, 36);
            this.groupBox5.TabIndex = 118;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "按出版日期查找";
            // 
            // chbUseDate
            // 
            this.chbUseDate.AutoSize = true;
            this.chbUseDate.Location = new System.Drawing.Point(20, 16);
            this.chbUseDate.Name = "chbUseDate";
            this.chbUseDate.Size = new System.Drawing.Size(48, 16);
            this.chbUseDate.TabIndex = 113;
            this.chbUseDate.Text = "启用";
            this.chbUseDate.UseVisualStyleBackColor = true;
            this.chbUseDate.CheckedChanged += new System.EventHandler(this.chbUseDate_CheckedChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(184, 17);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(11, 12);
            this.label4.TabIndex = 112;
            this.label4.Text = "~";
            // 
            // dtpMaxPubDate
            // 
            this.dtpMaxPubDate.CustomFormat = "yyyy-MM-dd";
            this.dtpMaxPubDate.Enabled = false;
            this.dtpMaxPubDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpMaxPubDate.Location = new System.Drawing.Point(212, 15);
            this.dtpMaxPubDate.Name = "dtpMaxPubDate";
            this.dtpMaxPubDate.Size = new System.Drawing.Size(83, 21);
            this.dtpMaxPubDate.TabIndex = 1;
            this.dtpMaxPubDate.Value = new System.DateTime(2009, 6, 28, 15, 14, 0, 0);
            // 
            // dtpMinPubDate
            // 
            this.dtpMinPubDate.CustomFormat = "yyyy-MM-dd";
            this.dtpMinPubDate.Enabled = false;
            this.dtpMinPubDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpMinPubDate.Location = new System.Drawing.Point(86, 15);
            this.dtpMinPubDate.Name = "dtpMinPubDate";
            this.dtpMinPubDate.Size = new System.Drawing.Size(85, 21);
            this.dtpMinPubDate.TabIndex = 0;
            this.dtpMinPubDate.Value = new System.DateTime(1990, 1, 1, 0, 0, 0, 0);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.rabStatue0);
            this.groupBox4.Controls.Add(this.rabStatue1);
            this.groupBox4.Controls.Add(this.rabAllStatue);
            this.groupBox4.Location = new System.Drawing.Point(16, 137);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(332, 37);
            this.groupBox4.TabIndex = 117;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "折扣状态";
            // 
            // rabStatue0
            // 
            this.rabStatue0.AutoSize = true;
            this.rabStatue0.Location = new System.Drawing.Point(188, 16);
            this.rabStatue0.Name = "rabStatue0";
            this.rabStatue0.Size = new System.Drawing.Size(59, 16);
            this.rabStatue0.TabIndex = 2;
            this.rabStatue0.Text = "非打折";
            this.rabStatue0.UseVisualStyleBackColor = true;
            // 
            // rabStatue1
            // 
            this.rabStatue1.AutoSize = true;
            this.rabStatue1.Location = new System.Drawing.Point(110, 16);
            this.rabStatue1.Name = "rabStatue1";
            this.rabStatue1.Size = new System.Drawing.Size(47, 16);
            this.rabStatue1.TabIndex = 1;
            this.rabStatue1.Text = "打折";
            this.rabStatue1.UseVisualStyleBackColor = true;
            // 
            // rabAllStatue
            // 
            this.rabAllStatue.AutoSize = true;
            this.rabAllStatue.Checked = true;
            this.rabAllStatue.Location = new System.Drawing.Point(37, 16);
            this.rabAllStatue.Name = "rabAllStatue";
            this.rabAllStatue.Size = new System.Drawing.Size(47, 16);
            this.rabAllStatue.TabIndex = 0;
            this.rabAllStatue.TabStop = true;
            this.rabAllStatue.Text = "全部";
            this.rabAllStatue.UseVisualStyleBackColor = true;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.chbPriceExact);
            this.groupBox3.Controls.Add(this.chbPriceRang);
            this.groupBox3.Controls.Add(this.nudMaxPrice);
            this.groupBox3.Controls.Add(this.label1);
            this.groupBox3.Controls.Add(this.nudPrice);
            this.groupBox3.Controls.Add(this.nudMinPrice);
            this.groupBox3.Location = new System.Drawing.Point(368, 86);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(332, 45);
            this.groupBox3.TabIndex = 116;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "价格";
            // 
            // chbPriceExact
            // 
            this.chbPriceExact.AutoSize = true;
            this.chbPriceExact.Location = new System.Drawing.Point(212, 22);
            this.chbPriceExact.Name = "chbPriceExact";
            this.chbPriceExact.Size = new System.Drawing.Size(54, 16);
            this.chbPriceExact.TabIndex = 120;
            this.chbPriceExact.Text = "精确:";
            this.chbPriceExact.UseVisualStyleBackColor = true;
            this.chbPriceExact.CheckedChanged += new System.EventHandler(this.cbhPriceExact_CheckedChanged);
            // 
            // chbPriceRang
            // 
            this.chbPriceRang.AutoSize = true;
            this.chbPriceRang.Location = new System.Drawing.Point(6, 23);
            this.chbPriceRang.Name = "chbPriceRang";
            this.chbPriceRang.Size = new System.Drawing.Size(54, 16);
            this.chbPriceRang.TabIndex = 119;
            this.chbPriceRang.Text = "范围:";
            this.chbPriceRang.UseVisualStyleBackColor = true;
            this.chbPriceRang.CheckedChanged += new System.EventHandler(this.cbhPriceRang_CheckedChanged);
            // 
            // nudMaxPrice
            // 
            this.nudMaxPrice.Enabled = false;
            this.nudMaxPrice.Location = new System.Drawing.Point(130, 21);
            this.nudMaxPrice.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
            this.nudMaxPrice.Minimum = new decimal(new int[] {
            2,
            0,
            0,
            0});
            this.nudMaxPrice.Name = "nudMaxPrice";
            this.nudMaxPrice.Size = new System.Drawing.Size(54, 21);
            this.nudMaxPrice.TabIndex = 112;
            this.nudMaxPrice.Value = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(110, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(11, 12);
            this.label1.TabIndex = 111;
            this.label1.Text = "~";
            // 
            // nudPrice
            // 
            this.nudPrice.Enabled = false;
            this.nudPrice.Location = new System.Drawing.Point(271, 21);
            this.nudPrice.Name = "nudPrice";
            this.nudPrice.Size = new System.Drawing.Size(46, 21);
            this.nudPrice.TabIndex = 113;
            // 
            // nudMinPrice
            // 
            this.nudMinPrice.Enabled = false;
            this.nudMinPrice.Location = new System.Drawing.Point(61, 21);
            this.nudMinPrice.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
            this.nudMinPrice.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudMinPrice.Name = "nudMinPrice";
            this.nudMinPrice.Size = new System.Drawing.Size(43, 21);
            this.nudMinPrice.TabIndex = 81;
            this.nudMinPrice.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // dgvBooks
            // 
            this.dgvBooks.AllowDrop = true;
            this.dgvBooks.AllowUserToAddRows = false;
            this.dgvBooks.AllowUserToDeleteRows = false;
            this.dgvBooks.AllowUserToOrderColumns = true;
            this.dgvBooks.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.b_id,
            this.b_name,
            this.b_isbn,
            this.b_price,
            this.b_stock,
            this.b_author,
            this.pub_name,
            this.b_pubdate,
            this.cat_title,
            this.gen_title});
            this.dgvBooks.Location = new System.Drawing.Point(9, 250);
            this.dgvBooks.MultiSelect = false;
            this.dgvBooks.Name = "dgvBooks";
            this.dgvBooks.ReadOnly = true;
            this.dgvBooks.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvBooks.Size = new System.Drawing.Size(694, 140);
            this.dgvBooks.TabIndex = 115;
            // 
            // b_id
            // 
            this.b_id.DataPropertyName = "b_id";
            this.b_id.HeaderText = "b_id";
            this.b_id.Name = "b_id";
            this.b_id.ReadOnly = true;
            this.b_id.Visible = false;
            // 
            // b_name
            // 
            this.b_name.DataPropertyName = "b_name";
            this.b_name.HeaderText = "书名";
            this.b_name.Name = "b_name";
            this.b_name.ReadOnly = true;
            // 
            // b_isbn
            // 
            this.b_isbn.DataPropertyName = "b_isbn";
            this.b_isbn.HeaderText = "ISBN";
            this.b_isbn.Name = "b_isbn";
            this.b_isbn.ReadOnly = true;
            // 
            // b_price
            // 
            this.b_price.DataPropertyName = "b_price";
            this.b_price.HeaderText = "价格";
            this.b_price.Name = "b_price";
            this.b_price.ReadOnly = true;
            // 
            // b_stock
            // 
            this.b_stock.DataPropertyName = "b_stock";
            this.b_stock.HeaderText = "库存";
            this.b_stock.Name = "b_stock";
            this.b_stock.ReadOnly = true;
            // 
            // b_author
            // 
            this.b_author.DataPropertyName = "b_author";
            this.b_author.HeaderText = "作者";
            this.b_author.Name = "b_author";
            this.b_author.ReadOnly = true;
            // 
            // pub_name
            // 
            this.pub_name.DataPropertyName = "pub_name";
            this.pub_name.HeaderText = "出版社";
            this.pub_name.Name = "pub_name";
            this.pub_name.ReadOnly = true;
            // 
            // b_pubdate
            // 
            this.b_pubdate.DataPropertyName = "b_pubdate";
            this.b_pubdate.HeaderText = "出版日期";
            this.b_pubdate.Name = "b_pubdate";
            this.b_pubdate.ReadOnly = true;
            // 
            // cat_title
            // 
            this.cat_title.DataPropertyName = "cat_title";
            this.cat_title.HeaderText = "一级类型";
            this.cat_title.Name = "cat_title";
            this.cat_title.ReadOnly = true;
            // 
            // gen_title
            // 
            this.gen_title.DataPropertyName = "gen_title";
            this.gen_title.HeaderText = "二级类型";
            this.gen_title.Name = "gen_title";
            this.gen_title.ReadOnly = true;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.chbStockRang);
            this.groupBox2.Controls.Add(this.nudMaxStock);
            this.groupBox2.Controls.Add(this.chbStockExact);
            this.groupBox2.Controls.Add(this.label9);
            this.groupBox2.Controls.Add(this.nudStock);
            this.groupBox2.Controls.Add(this.nudMinStock);
            this.groupBox2.Location = new System.Drawing.Point(16, 86);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(332, 45);
            this.groupBox2.TabIndex = 113;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "库存数";
            // 
            // chbStockRang
            // 
            this.chbStockRang.AutoSize = true;
            this.chbStockRang.Location = new System.Drawing.Point(6, 22);
            this.chbStockRang.Name = "chbStockRang";
            this.chbStockRang.Size = new System.Drawing.Size(54, 16);
            this.chbStockRang.TabIndex = 118;
            this.chbStockRang.Text = "范围:";
            this.chbStockRang.UseVisualStyleBackColor = true;
            this.chbStockRang.CheckedChanged += new System.EventHandler(this.chbStockRang_CheckedChanged);
            // 
            // nudMaxStock
            // 
            this.nudMaxStock.Enabled = false;
            this.nudMaxStock.Location = new System.Drawing.Point(127, 19);
            this.nudMaxStock.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
            this.nudMaxStock.Minimum = new decimal(new int[] {
            2,
            0,
            0,
            0});
            this.nudMaxStock.Name = "nudMaxStock";
            this.nudMaxStock.Size = new System.Drawing.Size(54, 21);
            this.nudMaxStock.TabIndex = 112;
            this.nudMaxStock.Value = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            // 
            // chbStockExact
            // 
            this.chbStockExact.AutoSize = true;
            this.chbStockExact.Location = new System.Drawing.Point(207, 21);
            this.chbStockExact.Name = "chbStockExact";
            this.chbStockExact.Size = new System.Drawing.Size(54, 16);
            this.chbStockExact.TabIndex = 117;
            this.chbStockExact.Text = "精确:";
            this.chbStockExact.UseVisualStyleBackColor = true;
            this.chbStockExact.CheckedChanged += new System.EventHandler(this.chbStockExact_CheckedChanged);
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(107, 24);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(11, 12);
            this.label9.TabIndex = 111;
            this.label9.Text = "~";
            // 
            // nudStock
            // 
            this.nudStock.Enabled = false;
            this.nudStock.Location = new System.Drawing.Point(266, 19);
            this.nudStock.Name = "nudStock";
            this.nudStock.Size = new System.Drawing.Size(46, 21);
            this.nudStock.TabIndex = 113;
            // 
            // nudMinStock
            // 
            this.nudMinStock.Enabled = false;
            this.nudMinStock.Location = new System.Drawing.Point(58, 20);
            this.nudMinStock.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
            this.nudMinStock.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudMinStock.Name = "nudMinStock";
            this.nudMinStock.Size = new System.Drawing.Size(43, 21);
            this.nudMinStock.TabIndex = 81;
            this.nudMinStock.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // txtAuthor
            // 
            this.txtAuthor.Location = new System.Drawing.Point(317, 62);
            this.txtAuthor.Name = "txtAuthor";
            this.txtAuthor.Size = new System.Drawing.Size(143, 21);
            this.txtAuthor.TabIndex = 109;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(17, 67);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 12);
            this.label2.TabIndex = 65;
            this.label2.Text = "书  名：";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(74, 65);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(145, 21);
            this.txtName.TabIndex = 68;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(483, 66);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 12);
            this.label3.TabIndex = 58;
            this.label3.Text = "ISBN码：";
            // 
            // txtISBN
            // 
            this.txtISBN.Location = new System.Drawing.Point(555, 62);
            this.txtISBN.Name = "txtISBN";
            this.txtISBN.Size = new System.Drawing.Size(145, 21);
            this.txtISBN.TabIndex = 67;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(244, 65);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(65, 12);
            this.label8.TabIndex = 60;
            this.label8.Text = "作者姓名：";
            // 
            // lbSearchInfo
            // 
            this.lbSearchInfo.AutoSize = true;
            this.lbSearchInfo.Font = new System.Drawing.Font("宋体", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(134)));
            this.lbSearchInfo.Location = new System.Drawing.Point(6, 230);
            this.lbSearchInfo.Name = "lbSearchInfo";
            this.lbSearchInfo.Size = new System.Drawing.Size(124, 13);
            this.lbSearchInfo.TabIndex = 34;
            this.lbSearchInfo.Text = "当前搜索到的书籍：";
            // 
            // btnSearch
            // 
            this.btnSearch.Location = new System.Drawing.Point(529, 404);
            this.btnSearch.Name = "btnSearch";
            this.btnSearch.Size = new System.Drawing.Size(75, 23);
            this.btnSearch.TabIndex = 42;
            this.btnSearch.Text = "开始查找";
            this.btnSearch.UseVisualStyleBackColor = true;
            this.btnSearch.Click += new System.EventHandler(this.btnSearch_Click);
            // 
            // btnReturn
            // 
            this.btnReturn.Location = new System.Drawing.Point(622, 404);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(75, 23);
            this.btnReturn.TabIndex = 44;
            this.btnReturn.Text = "返 回";
            this.btnReturn.UseVisualStyleBackColor = true;
            this.btnReturn.Click += new System.EventHandler(this.btnReturn_Click);
            // 
            // frmSeachBook
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(741, 438);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnReturn);
            this.Controls.Add(this.btnSearch);
            this.Name = "frmSeachBook";
            this.Text = "frmSelect";
            this.Load += new System.EventHandler(this.frmSeachBook_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox6.ResumeLayout(false);
            this.groupBox6.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMaxPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMinPrice)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvBooks)).EndInit();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMaxStock)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudStock)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMinStock)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtISBN;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button btnSearch;
        private System.Windows.Forms.Label lbSearchInfo;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.NumericUpDown nudMinStock;
        private System.Windows.Forms.TextBox txtAuthor;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.NumericUpDown nudMaxStock;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.DataGridView dgvBooks;
        private System.Windows.Forms.NumericUpDown nudStock;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.NumericUpDown nudMaxPrice;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.NumericUpDown nudPrice;
        private System.Windows.Forms.NumericUpDown nudMinPrice;
        private System.Windows.Forms.CheckBox chbPriceExact;
        private System.Windows.Forms.CheckBox chbPriceRang;
        private System.Windows.Forms.CheckBox chbStockRang;
        private System.Windows.Forms.CheckBox chbStockExact;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.RadioButton rabStatue0;
        private System.Windows.Forms.RadioButton rabStatue1;
        private System.Windows.Forms.RadioButton rabAllStatue;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_id;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_isbn;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_price;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_stock;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_author;
        private System.Windows.Forms.DataGridViewTextBoxColumn pub_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_pubdate;
        private System.Windows.Forms.DataGridViewTextBoxColumn cat_title;
        private System.Windows.Forms.DataGridViewTextBoxColumn gen_title;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.DateTimePicker dtpMaxPubDate;
        private System.Windows.Forms.DateTimePicker dtpMinPubDate;
        private System.Windows.Forms.CheckBox chbUseDate;
        private System.Windows.Forms.GroupBox groupBox6;
        private System.Windows.Forms.CheckBox chbStockDateRang;
        private System.Windows.Forms.DateTimePicker dtpStockDate;
        private System.Windows.Forms.CheckBox chbSotckDateExact;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.DateTimePicker dtpMaxStockDate;
        private System.Windows.Forms.DateTimePicker dtpMinStockDate;
        private System.Windows.Forms.ComboBox cobPubshers;
        private System.Windows.Forms.ComboBox cobGenres;
        private System.Windows.Forms.ComboBox cobCategories;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label10;
    }
}