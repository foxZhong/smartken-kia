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
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.tabPage2 = new System.Windows.Forms.TabPage();
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
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.tabControl1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgSaleClassify)).BeginInit();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Location = new System.Drawing.Point(12, 12);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(649, 365);
            this.tabControl1.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(641, 339);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "月度销量统计";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.lbInfo);
            this.tabPage2.Controls.Add(this.groupBox1);
            this.tabPage2.Controls.Add(this.dgSaleClassify);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(641, 339);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "分类销售统计";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // lbInfo
            // 
            this.lbInfo.AutoSize = true;
            this.lbInfo.Location = new System.Drawing.Point(22, 155);
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
            this.groupBox1.Location = new System.Drawing.Point(6, 6);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(629, 137);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "查询条件";
            // 
            // cobPubshers
            // 
            this.cobPubshers.FormattingEnabled = true;
            this.cobPubshers.Location = new System.Drawing.Point(401, 23);
            this.cobPubshers.Name = "cobPubshers";
            this.cobPubshers.Size = new System.Drawing.Size(166, 21);
            this.cobPubshers.TabIndex = 10;
            // 
            // txtIsbn
            // 
            this.txtIsbn.Location = new System.Drawing.Point(401, 56);
            this.txtIsbn.Name = "txtIsbn";
            this.txtIsbn.Size = new System.Drawing.Size(166, 20);
            this.txtIsbn.TabIndex = 9;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(80, 56);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(246, 20);
            this.txtName.TabIndex = 8;
            // 
            // cobGenres
            // 
            this.cobGenres.FormattingEnabled = true;
            this.cobGenres.Location = new System.Drawing.Point(238, 23);
            this.cobGenres.Name = "cobGenres";
            this.cobGenres.Size = new System.Drawing.Size(88, 21);
            this.cobGenres.TabIndex = 7;
            // 
            // cobCategories
            // 
            this.cobCategories.FormattingEnabled = true;
            this.cobCategories.Location = new System.Drawing.Point(80, 23);
            this.cobCategories.Name = "cobCategories";
            this.cobCategories.Size = new System.Drawing.Size(74, 21);
            this.cobCategories.TabIndex = 6;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(349, 26);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(46, 13);
            this.label5.TabIndex = 5;
            this.label5.Text = "出版社:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(365, 59);
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
            this.label2.Location = new System.Drawing.Point(174, 26);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(58, 13);
            this.label2.TabIndex = 2;
            this.label2.Text = "二级类型:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(58, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "一级类型:";
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
            this.dtpMaxSaleDate.Location = new System.Drawing.Point(418, 19);
            this.dtpMaxSaleDate.Name = "dtpMaxSaleDate";
            this.dtpMaxSaleDate.Size = new System.Drawing.Size(115, 20);
            this.dtpMaxSaleDate.TabIndex = 4;
            // 
            // dtpMinSaleDate
            // 
            this.dtpMinSaleDate.Location = new System.Drawing.Point(278, 19);
            this.dtpMinSaleDate.Name = "dtpMinSaleDate";
            this.dtpMinSaleDate.Size = new System.Drawing.Size(115, 20);
            this.dtpMinSaleDate.TabIndex = 3;
            // 
            // dtpSaleDate
            // 
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
            // 
            // dgSaleClassify
            // 
            this.dgSaleClassify.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgSaleClassify.Location = new System.Drawing.Point(3, 177);
            this.dgSaleClassify.Name = "dgSaleClassify";
            this.dgSaleClassify.Size = new System.Drawing.Size(635, 159);
            this.dgSaleClassify.TabIndex = 0;
            // 
            // tabPage3
            // 
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Size = new System.Drawing.Size(641, 339);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "销量龙虎榜";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // frmSaleAccount
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(673, 418);
            this.Controls.Add(this.tabControl1);
            this.Name = "frmSaleAccount";
            this.Text = "frmSaleAccount";
            this.Load += new System.EventHandler(this.frmSaleAccount_Load);
            this.tabControl1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgSaleClassify)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TabPage tabPage3;
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

    }
}