namespace BookSystem
{
    partial class frmMessage
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
            this.components = new System.ComponentModel.Container();
            this.btnCancel = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.txtCode = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lvMessage = new System.Windows.Forms.ListView();
            this.columnHeader1 = new System.Windows.Forms.ColumnHeader();
            this.columnHeader2 = new System.Windows.Forms.ColumnHeader();
            this.columnHeader3 = new System.Windows.Forms.ColumnHeader();
            this.columnHeader4 = new System.Windows.Forms.ColumnHeader();
            this.cmsManage = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.tsmiSelectSale = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiUpdate = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiDelete = new System.Windows.Forms.ToolStripMenuItem();
            this.btnSelect = new System.Windows.Forms.Button();
            this.grp = new System.Windows.Forms.GroupBox();
            this.cmsManage.SuspendLayout();
            this.grp.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnCancel
            // 
            this.btnCancel.Location = new System.Drawing.Point(420, 288);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(75, 24);
            this.btnCancel.TabIndex = 10;
            this.btnCancel.Text = "返 回";
            this.btnCancel.UseVisualStyleBackColor = true;
            this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 234);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(53, 12);
            this.label3.TabIndex = 5;
            this.label3.Text = "员工号：";
            // 
            // txtCode
            // 
            this.txtCode.Location = new System.Drawing.Point(65, 231);
            this.txtCode.Name = "txtCode";
            this.txtCode.Size = new System.Drawing.Size(100, 21);
            this.txtCode.TabIndex = 6;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(210, 234);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(41, 12);
            this.label1.TabIndex = 1;
            this.label1.Text = "姓名：";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(257, 231);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(100, 21);
            this.txtName.TabIndex = 2;
            // 
            // lvMessage
            // 
            this.lvMessage.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4});
            this.lvMessage.ContextMenuStrip = this.cmsManage;
            this.lvMessage.FullRowSelect = true;
            this.lvMessage.HideSelection = false;
            this.lvMessage.Location = new System.Drawing.Point(6, 20);
            this.lvMessage.Name = "lvMessage";
            this.lvMessage.Size = new System.Drawing.Size(471, 194);
            this.lvMessage.TabIndex = 14;
            this.lvMessage.UseCompatibleStateImageBehavior = false;
            this.lvMessage.View = System.Windows.Forms.View.Details;
            this.lvMessage.MouseDoubleClick += new System.Windows.Forms.MouseEventHandler(this.lvMessage_MouseDoubleClick);
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "员工号";
            this.columnHeader1.Width = 125;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "姓名";
            this.columnHeader2.Width = 115;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "职位";
            this.columnHeader3.Width = 115;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "状态";
            this.columnHeader4.Width = 112;
            // 
            // cmsManage
            // 
            this.cmsManage.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiSelectSale,
            this.tsmiUpdate,
            this.tsmiDelete});
            this.cmsManage.Name = "cmsManage";
            this.cmsManage.Size = new System.Drawing.Size(153, 92);
            // 
            // tsmiSelectSale
            // 
            this.tsmiSelectSale.Name = "tsmiSelectSale";
            this.tsmiSelectSale.Size = new System.Drawing.Size(152, 22);
            this.tsmiSelectSale.Text = "查看销量";
            this.tsmiSelectSale.Click += new System.EventHandler(this.tsmiSelectSale_Click);
            // 
            // tsmiUpdate
            // 
            this.tsmiUpdate.Name = "tsmiUpdate";
            this.tsmiUpdate.Size = new System.Drawing.Size(152, 22);
            this.tsmiUpdate.Text = "修改";
            this.tsmiUpdate.Click += new System.EventHandler(this.tsmiUpdate_Click);
            // 
            // tsmiDelete
            // 
            this.tsmiDelete.Name = "tsmiDelete";
            this.tsmiDelete.Size = new System.Drawing.Size(152, 22);
            this.tsmiDelete.Text = "删除";
            this.tsmiDelete.Click += new System.EventHandler(this.tsmiDelete_Click);
            // 
            // btnSelect
            // 
            this.btnSelect.Location = new System.Drawing.Point(402, 229);
            this.btnSelect.Name = "btnSelect";
            this.btnSelect.Size = new System.Drawing.Size(75, 23);
            this.btnSelect.TabIndex = 10;
            this.btnSelect.Text = "查 询";
            this.btnSelect.UseVisualStyleBackColor = true;
            this.btnSelect.Click += new System.EventHandler(this.btnSelect_Click);
            // 
            // grp
            // 
            this.grp.Controls.Add(this.btnSelect);
            this.grp.Controls.Add(this.lvMessage);
            this.grp.Controls.Add(this.txtName);
            this.grp.Controls.Add(this.label1);
            this.grp.Controls.Add(this.txtCode);
            this.grp.Controls.Add(this.label3);
            this.grp.Location = new System.Drawing.Point(12, 12);
            this.grp.Name = "grp";
            this.grp.Size = new System.Drawing.Size(483, 270);
            this.grp.TabIndex = 14;
            this.grp.TabStop = false;
            this.grp.Text = "员工信息";
            // 
            // frmMessage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(506, 325);
            this.Controls.Add(this.grp);
            this.Controls.Add(this.btnCancel);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmMessage";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "修改员工信息";
            this.Load += new System.EventHandler(this.frmMessage_Load);
            this.cmsManage.ResumeLayout(false);
            this.grp.ResumeLayout(false);
            this.grp.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox txtCode;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.ListView lvMessage;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.Button btnSelect;
        private System.Windows.Forms.GroupBox grp;
        private System.Windows.Forms.ContextMenuStrip cmsManage;
        private System.Windows.Forms.ToolStripMenuItem tsmiUpdate;
        private System.Windows.Forms.ToolStripMenuItem tsmiDelete;
        private System.Windows.Forms.ToolStripMenuItem tsmiSelectSale;
    }
}