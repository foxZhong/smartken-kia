namespace BookSystem
{
    partial class frmSaleMonthAccount
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
            this.lbSumCount = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.lbSumIncome = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.btnLoadMonths = new System.Windows.Forms.Button();
            this.dgvMonths = new System.Windows.Forms.DataGridView();
            this.ym = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sum_income = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sum_count = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nudYear = new System.Windows.Forms.NumericUpDown();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.dgvSales = new System.Windows.Forms.DataGridView();
            this.sale_code = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sale_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sale_date = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sum_price = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.card_discount = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.card_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sum_itemprice = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.u_realname = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.dgvTopBook = new System.Windows.Forms.DataGridView();
            this.b_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.item_id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.item_saleid = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.item_count = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.item_bookid = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.b_isbn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.count = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.pub_name = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.gen_title = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.btnReturn = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvMonths)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudYear)).BeginInit();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSales)).BeginInit();
            this.groupBox3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvTopBook)).BeginInit();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.lbSumCount);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.lbSumIncome);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.btnLoadMonths);
            this.groupBox1.Controls.Add(this.dgvMonths);
            this.groupBox1.Controls.Add(this.nudYear);
            this.groupBox1.Location = new System.Drawing.Point(12, 22);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(225, 385);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "年度销售统计";
            // 
            // lbSumCount
            // 
            this.lbSumCount.AutoSize = true;
            this.lbSumCount.Location = new System.Drawing.Point(166, 53);
            this.lbSumCount.Name = "lbSumCount";
            this.lbSumCount.Size = new System.Drawing.Size(35, 13);
            this.lbSumCount.TabIndex = 10;
            this.lbSumCount.Text = "label5";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(111, 53);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(58, 13);
            this.label4.TabIndex = 9;
            this.label4.Text = "总交易数:";
            // 
            // lbSumIncome
            // 
            this.lbSumIncome.AutoSize = true;
            this.lbSumIncome.Location = new System.Drawing.Point(49, 53);
            this.lbSumIncome.Name = "lbSumIncome";
            this.lbSumIncome.Size = new System.Drawing.Size(35, 13);
            this.lbSumIncome.TabIndex = 8;
            this.lbSumIncome.Text = "label3";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 53);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(46, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "总收入:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(11, 27);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(31, 13);
            this.label1.TabIndex = 6;
            this.label1.Text = "年份";
            // 
            // btnLoadMonths
            // 
            this.btnLoadMonths.Location = new System.Drawing.Point(139, 22);
            this.btnLoadMonths.Name = "btnLoadMonths";
            this.btnLoadMonths.Size = new System.Drawing.Size(75, 23);
            this.btnLoadMonths.TabIndex = 5;
            this.btnLoadMonths.Text = "Enter";
            this.btnLoadMonths.UseVisualStyleBackColor = true;
            this.btnLoadMonths.Click += new System.EventHandler(this.btnLoadMonths_Click);
            // 
            // dgvMonths
            // 
            this.dgvMonths.AllowUserToAddRows = false;
            this.dgvMonths.AllowUserToDeleteRows = false;
            this.dgvMonths.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvMonths.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ym,
            this.sum_income,
            this.sum_count});
            this.dgvMonths.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.dgvMonths.Location = new System.Drawing.Point(3, 79);
            this.dgvMonths.MultiSelect = false;
            this.dgvMonths.Name = "dgvMonths";
            this.dgvMonths.ReadOnly = true;
            this.dgvMonths.RowHeadersWidth = 5;
            this.dgvMonths.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvMonths.Size = new System.Drawing.Size(219, 303);
            this.dgvMonths.TabIndex = 4;
            this.dgvMonths.CellMouseDoubleClick += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.dgvMonths_CellMouseDoubleClick);
            // 
            // ym
            // 
            this.ym.AutoSizeMode = System.Windows.Forms.DataGridViewAutoSizeColumnMode.DisplayedCells;
            this.ym.DataPropertyName = "ym";
            this.ym.HeaderText = "月份";
            this.ym.Name = "ym";
            this.ym.ReadOnly = true;
            this.ym.Width = 56;
            // 
            // sum_income
            // 
            this.sum_income.DataPropertyName = "sum_income";
            this.sum_income.HeaderText = "收入";
            this.sum_income.Name = "sum_income";
            this.sum_income.ReadOnly = true;
            // 
            // sum_count
            // 
            this.sum_count.DataPropertyName = "sum_count";
            this.sum_count.HeaderText = "交易次数";
            this.sum_count.Name = "sum_count";
            this.sum_count.ReadOnly = true;
            // 
            // nudYear
            // 
            this.nudYear.Location = new System.Drawing.Point(52, 25);
            this.nudYear.Maximum = new decimal(new int[] {
            3000,
            0,
            0,
            0});
            this.nudYear.Minimum = new decimal(new int[] {
            1990,
            0,
            0,
            0});
            this.nudYear.Name = "nudYear";
            this.nudYear.Size = new System.Drawing.Size(70, 20);
            this.nudYear.TabIndex = 3;
            this.nudYear.Value = new decimal(new int[] {
            2006,
            0,
            0,
            0});
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.dgvSales);
            this.groupBox2.Location = new System.Drawing.Point(243, 22);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(553, 221);
            this.groupBox2.TabIndex = 1;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "月度销售统计";
            // 
            // dgvSales
            // 
            this.dgvSales.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvSales.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.sale_code,
            this.sale_id,
            this.sale_date,
            this.sum_price,
            this.card_discount,
            this.card_name,
            this.sum_itemprice,
            this.u_realname});
            this.dgvSales.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvSales.Location = new System.Drawing.Point(3, 16);
            this.dgvSales.Name = "dgvSales";
            this.dgvSales.RowHeadersWidth = 4;
            this.dgvSales.Size = new System.Drawing.Size(547, 202);
            this.dgvSales.TabIndex = 0;
            // 
            // sale_code
            // 
            this.sale_code.DataPropertyName = "sale_code";
            this.sale_code.HeaderText = "买单号";
            this.sale_code.Name = "sale_code";
            // 
            // sale_id
            // 
            this.sale_id.DataPropertyName = "sale_id";
            this.sale_id.HeaderText = "sale_id";
            this.sale_id.Name = "sale_id";
            this.sale_id.Visible = false;
            // 
            // sale_date
            // 
            this.sale_date.DataPropertyName = "sale_date";
            this.sale_date.HeaderText = "下单时间";
            this.sale_date.Name = "sale_date";
            // 
            // sum_price
            // 
            this.sum_price.DataPropertyName = "sum_price";
            this.sum_price.HeaderText = "应收";
            this.sum_price.Name = "sum_price";
            // 
            // card_discount
            // 
            this.card_discount.DataPropertyName = "card_discount";
            this.card_discount.HeaderText = "折扣";
            this.card_discount.Name = "card_discount";
            // 
            // card_name
            // 
            this.card_name.DataPropertyName = "card_name";
            this.card_name.HeaderText = "会员类型";
            this.card_name.Name = "card_name";
            // 
            // sum_itemprice
            // 
            this.sum_itemprice.DataPropertyName = "sum_itemprice";
            this.sum_itemprice.HeaderText = "实收";
            this.sum_itemprice.Name = "sum_itemprice";
            // 
            // u_realname
            // 
            this.u_realname.DataPropertyName = "u_realname";
            this.u_realname.HeaderText = "收款人";
            this.u_realname.Name = "u_realname";
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.dgvTopBook);
            this.groupBox3.Location = new System.Drawing.Point(243, 249);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(553, 161);
            this.groupBox3.TabIndex = 2;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "月度销售龙虎榜";
            // 
            // dgvTopBook
            // 
            this.dgvTopBook.AllowUserToAddRows = false;
            this.dgvTopBook.AllowUserToDeleteRows = false;
            this.dgvTopBook.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvTopBook.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.b_name,
            this.item_id,
            this.item_saleid,
            this.item_count,
            this.item_bookid,
            this.b_isbn,
            this.count,
            this.pub_name,
            this.gen_title});
            this.dgvTopBook.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvTopBook.Location = new System.Drawing.Point(3, 16);
            this.dgvTopBook.MultiSelect = false;
            this.dgvTopBook.Name = "dgvTopBook";
            this.dgvTopBook.ReadOnly = true;
            this.dgvTopBook.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvTopBook.Size = new System.Drawing.Size(547, 142);
            this.dgvTopBook.TabIndex = 1;
            // 
            // b_name
            // 
            this.b_name.DataPropertyName = "b_name";
            this.b_name.HeaderText = "书名";
            this.b_name.Name = "b_name";
            this.b_name.ReadOnly = true;
            // 
            // item_id
            // 
            this.item_id.DataPropertyName = "item_id";
            this.item_id.HeaderText = "item_id";
            this.item_id.Name = "item_id";
            this.item_id.ReadOnly = true;
            this.item_id.Visible = false;
            // 
            // item_saleid
            // 
            this.item_saleid.DataPropertyName = "item_saleid";
            this.item_saleid.HeaderText = "item_saleid";
            this.item_saleid.Name = "item_saleid";
            this.item_saleid.ReadOnly = true;
            this.item_saleid.Visible = false;
            // 
            // item_count
            // 
            this.item_count.DataPropertyName = "item_count";
            this.item_count.HeaderText = "item_count";
            this.item_count.Name = "item_count";
            this.item_count.ReadOnly = true;
            this.item_count.Visible = false;
            // 
            // item_bookid
            // 
            this.item_bookid.DataPropertyName = "item_bookid";
            this.item_bookid.HeaderText = "item_bookid";
            this.item_bookid.Name = "item_bookid";
            this.item_bookid.ReadOnly = true;
            this.item_bookid.Visible = false;
            // 
            // b_isbn
            // 
            this.b_isbn.DataPropertyName = "b_isbn";
            this.b_isbn.HeaderText = "ISBN";
            this.b_isbn.Name = "b_isbn";
            this.b_isbn.ReadOnly = true;
            // 
            // count
            // 
            this.count.DataPropertyName = "sum_count";
            this.count.HeaderText = "销量";
            this.count.Name = "count";
            this.count.ReadOnly = true;
            // 
            // pub_name
            // 
            this.pub_name.DataPropertyName = "pub_name";
            this.pub_name.HeaderText = "出版社";
            this.pub_name.Name = "pub_name";
            this.pub_name.ReadOnly = true;
            // 
            // gen_title
            // 
            this.gen_title.DataPropertyName = "gen_title";
            this.gen_title.HeaderText = "类别";
            this.gen_title.Name = "gen_title";
            this.gen_title.ReadOnly = true;
            // 
            // btnReturn
            // 
            this.btnReturn.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnReturn.Location = new System.Drawing.Point(694, 416);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(99, 23);
            this.btnReturn.TabIndex = 3;
            this.btnReturn.Text = "返回";
            this.btnReturn.UseVisualStyleBackColor = true;
            this.btnReturn.Click += new System.EventHandler(this.btnReturn_Click);
            // 
            // frmSaleMonthAccount
            // 
            this.AcceptButton = this.btnLoadMonths;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnReturn;
            this.ClientSize = new System.Drawing.Size(808, 451);
            this.Controls.Add(this.btnReturn);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "frmSaleMonthAccount";
            this.Text = "frmSaleMonthAccount";
            this.Load += new System.EventHandler(this.frmSaleMonthAccount_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvMonths)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudYear)).EndInit();
            this.groupBox2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvSales)).EndInit();
            this.groupBox3.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvTopBook)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.DataGridView dgvSales;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.DataGridView dgvTopBook;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.DataGridView dgvMonths;
        private System.Windows.Forms.NumericUpDown nudYear;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnLoadMonths;
        private System.Windows.Forms.DataGridViewTextBoxColumn sale_code;
        private System.Windows.Forms.DataGridViewTextBoxColumn sale_id;
        private System.Windows.Forms.DataGridViewTextBoxColumn sale_date;
        private System.Windows.Forms.DataGridViewTextBoxColumn sum_price;
        private System.Windows.Forms.DataGridViewTextBoxColumn card_discount;
        private System.Windows.Forms.DataGridViewTextBoxColumn card_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn sum_itemprice;
        private System.Windows.Forms.DataGridViewTextBoxColumn u_realname;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn item_id;
        private System.Windows.Forms.DataGridViewTextBoxColumn item_saleid;
        private System.Windows.Forms.DataGridViewTextBoxColumn item_count;
        private System.Windows.Forms.DataGridViewTextBoxColumn item_bookid;
        private System.Windows.Forms.DataGridViewTextBoxColumn b_isbn;
        private System.Windows.Forms.DataGridViewTextBoxColumn count;
        private System.Windows.Forms.DataGridViewTextBoxColumn pub_name;
        private System.Windows.Forms.DataGridViewTextBoxColumn gen_title;
        private System.Windows.Forms.Label lbSumCount;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label lbSumIncome;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.DataGridViewTextBoxColumn ym;
        private System.Windows.Forms.DataGridViewTextBoxColumn sum_income;
        private System.Windows.Forms.DataGridViewTextBoxColumn sum_count;
    }
}