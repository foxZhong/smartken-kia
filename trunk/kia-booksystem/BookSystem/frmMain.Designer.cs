namespace BookSystem
{
    partial class frmMain
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmMain));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.员工管理ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiAddUser = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmlSelectUser = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiManageUser = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiRoleManage = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiLogOut = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiExit = new System.Windows.Forms.ToolStripMenuItem();
            this.销售管理ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiCreateSale = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiInCome = new System.Windows.Forms.ToolStripMenuItem();
            this.图书管理ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiToAddBook = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiToManageBook = new System.Windows.Forms.ToolStripMenuItem();
            this.会员管理ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiCreateCard = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiManageCard = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiInComeAccount = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiStockAccount = new System.Windows.Forms.ToolStripMenuItem();
            this.tsmiSaleAccount = new System.Windows.Forms.ToolStripMenuItem();
            this.关于ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.帮助ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.staInfo = new System.Windows.Forms.StatusStrip();
            this.tsslUserInfo = new System.Windows.Forms.ToolStripStatusLabel();
            this.tsslRoleInfo = new System.Windows.Forms.ToolStripStatusLabel();
            this.tsslLoginTime = new System.Windows.Forms.ToolStripStatusLabel();
            this.menuStrip1.SuspendLayout();
            this.staInfo.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ToolStripMenuItem,
            this.销售管理ToolStripMenuItem,
            this.图书管理ToolStripMenuItem,
            this.会员管理ToolStripMenuItem,
            this.tsmiInComeAccount,
            this.关于ToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(674, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // ToolStripMenuItem
            // 
            this.ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.员工管理ToolStripMenuItem1,
            this.tsmiLogOut,
            this.tsmiExit});
            this.ToolStripMenuItem.Name = "ToolStripMenuItem";
            this.ToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.ToolStripMenuItem.Text = "系统";
            // 
            // 员工管理ToolStripMenuItem1
            // 
            this.员工管理ToolStripMenuItem1.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiAddUser,
            this.tsmlSelectUser,
            this.tsmiManageUser,
            this.tsmiRoleManage});
            this.员工管理ToolStripMenuItem1.Name = "员工管理ToolStripMenuItem1";
            this.员工管理ToolStripMenuItem1.Size = new System.Drawing.Size(118, 22);
            this.员工管理ToolStripMenuItem1.Text = "员工管理";
            // 
            // tsmiAddUser
            // 
            this.tsmiAddUser.Enabled = false;
            this.tsmiAddUser.Name = "tsmiAddUser";
            this.tsmiAddUser.Size = new System.Drawing.Size(118, 22);
            this.tsmiAddUser.Text = "添加员工";
            this.tsmiAddUser.Click += new System.EventHandler(this.tsmiAddUser_Click);
            // 
            // tsmlSelectUser
            // 
            this.tsmlSelectUser.Enabled = false;
            this.tsmlSelectUser.Name = "tsmlSelectUser";
            this.tsmlSelectUser.Size = new System.Drawing.Size(118, 22);
            this.tsmlSelectUser.Text = "查询员工";
            this.tsmlSelectUser.Click += new System.EventHandler(this.tsmlSelectUser_Click);
            // 
            // tsmiManageUser
            // 
            this.tsmiManageUser.Name = "tsmiManageUser";
            this.tsmiManageUser.Size = new System.Drawing.Size(118, 22);
            this.tsmiManageUser.Text = "修改资料";
            this.tsmiManageUser.Click += new System.EventHandler(this.tsmiManageUser_Click);
            // 
            // tsmiRoleManage
            // 
            this.tsmiRoleManage.Enabled = false;
            this.tsmiRoleManage.Name = "tsmiRoleManage";
            this.tsmiRoleManage.Size = new System.Drawing.Size(118, 22);
            this.tsmiRoleManage.Text = "角色管理";
            this.tsmiRoleManage.Click += new System.EventHandler(this.tsmiRoleManage_Click);
            // 
            // tsmiLogOut
            // 
            this.tsmiLogOut.Name = "tsmiLogOut";
            this.tsmiLogOut.Size = new System.Drawing.Size(118, 22);
            this.tsmiLogOut.Text = "注销";
            this.tsmiLogOut.Click += new System.EventHandler(this.tsmiLogOut_Click);
            // 
            // tsmiExit
            // 
            this.tsmiExit.Name = "tsmiExit";
            this.tsmiExit.Size = new System.Drawing.Size(118, 22);
            this.tsmiExit.Text = "退出";
            this.tsmiExit.Click += new System.EventHandler(this.tsmiExit_Click);
            // 
            // 销售管理ToolStripMenuItem
            // 
            this.销售管理ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiCreateSale,
            this.tsmiInCome});
            this.销售管理ToolStripMenuItem.Name = "销售管理ToolStripMenuItem";
            this.销售管理ToolStripMenuItem.Size = new System.Drawing.Size(65, 20);
            this.销售管理ToolStripMenuItem.Text = "销售管理";
            // 
            // tsmiCreateSale
            // 
            this.tsmiCreateSale.Enabled = false;
            this.tsmiCreateSale.Name = "tsmiCreateSale";
            this.tsmiCreateSale.Size = new System.Drawing.Size(130, 22);
            this.tsmiCreateSale.Text = "创建销售单";
            this.tsmiCreateSale.Click += new System.EventHandler(this.tsmiCreateSale_Click);
            // 
            // tsmiInCome
            // 
            this.tsmiInCome.Enabled = false;
            this.tsmiInCome.Name = "tsmiInCome";
            this.tsmiInCome.Size = new System.Drawing.Size(130, 22);
            this.tsmiInCome.Text = "查看销售单";
            this.tsmiInCome.Click += new System.EventHandler(this.tsmiSaleAccount_Click);
            // 
            // 图书管理ToolStripMenuItem
            // 
            this.图书管理ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiToAddBook,
            this.tsmiToManageBook});
            this.图书管理ToolStripMenuItem.Name = "图书管理ToolStripMenuItem";
            this.图书管理ToolStripMenuItem.Size = new System.Drawing.Size(65, 20);
            this.图书管理ToolStripMenuItem.Text = "图书管理";
            // 
            // tsmiToAddBook
            // 
            this.tsmiToAddBook.Enabled = false;
            this.tsmiToAddBook.Name = "tsmiToAddBook";
            this.tsmiToAddBook.Size = new System.Drawing.Size(118, 22);
            this.tsmiToAddBook.Text = "新书入库";
            this.tsmiToAddBook.Click += new System.EventHandler(this.tsmiToAddBook_Click);
            // 
            // tsmiToManageBook
            // 
            this.tsmiToManageBook.Name = "tsmiToManageBook";
            this.tsmiToManageBook.Size = new System.Drawing.Size(118, 22);
            this.tsmiToManageBook.Text = "查看库存";
            this.tsmiToManageBook.Click += new System.EventHandler(this.tsmiToManageBook_Click);
            // 
            // 会员管理ToolStripMenuItem
            // 
            this.会员管理ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiCreateCard,
            this.tsmiManageCard});
            this.会员管理ToolStripMenuItem.Name = "会员管理ToolStripMenuItem";
            this.会员管理ToolStripMenuItem.Size = new System.Drawing.Size(65, 20);
            this.会员管理ToolStripMenuItem.Text = "会员管理";
            // 
            // tsmiCreateCard
            // 
            this.tsmiCreateCard.Enabled = false;
            this.tsmiCreateCard.Name = "tsmiCreateCard";
            this.tsmiCreateCard.Size = new System.Drawing.Size(130, 22);
            this.tsmiCreateCard.Text = "创建优惠卡";
            this.tsmiCreateCard.Click += new System.EventHandler(this.tsmiCreateCard_Click);
            // 
            // tsmiManageCard
            // 
            this.tsmiManageCard.Enabled = false;
            this.tsmiManageCard.Name = "tsmiManageCard";
            this.tsmiManageCard.Size = new System.Drawing.Size(130, 22);
            this.tsmiManageCard.Text = "修改优惠卡";
            this.tsmiManageCard.Click += new System.EventHandler(this.tsmiManageCard_Click);
            // 
            // tsmiInComeAccount
            // 
            this.tsmiInComeAccount.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsmiStockAccount,
            this.tsmiSaleAccount});
            this.tsmiInComeAccount.Name = "tsmiInComeAccount";
            this.tsmiInComeAccount.Size = new System.Drawing.Size(41, 20);
            this.tsmiInComeAccount.Text = "统计";
            // 
            // tsmiStockAccount
            // 
            this.tsmiStockAccount.Name = "tsmiStockAccount";
            this.tsmiStockAccount.Size = new System.Drawing.Size(118, 22);
            this.tsmiStockAccount.Text = "库存统计";
            this.tsmiStockAccount.Click += new System.EventHandler(this.tsmiStockAccount_Click);
            // 
            // tsmiSaleAccount
            // 
            this.tsmiSaleAccount.Enabled = false;
            this.tsmiSaleAccount.Name = "tsmiSaleAccount";
            this.tsmiSaleAccount.Size = new System.Drawing.Size(118, 22);
            this.tsmiSaleAccount.Text = "销量统计";
            this.tsmiSaleAccount.Click += new System.EventHandler(this.tsmiSaleAccount_Click_1);
            // 
            // 关于ToolStripMenuItem
            // 
            this.关于ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.帮助ToolStripMenuItem});
            this.关于ToolStripMenuItem.Name = "关于ToolStripMenuItem";
            this.关于ToolStripMenuItem.Size = new System.Drawing.Size(41, 20);
            this.关于ToolStripMenuItem.Text = "关于";
            // 
            // 帮助ToolStripMenuItem
            // 
            this.帮助ToolStripMenuItem.Name = "帮助ToolStripMenuItem";
            this.帮助ToolStripMenuItem.Size = new System.Drawing.Size(94, 22);
            this.帮助ToolStripMenuItem.Text = "帮助";
            // 
            // staInfo
            // 
            this.staInfo.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsslUserInfo,
            this.tsslRoleInfo,
            this.tsslLoginTime});
            this.staInfo.Location = new System.Drawing.Point(0, 448);
            this.staInfo.Name = "staInfo";
            this.staInfo.Size = new System.Drawing.Size(674, 22);
            this.staInfo.TabIndex = 1;
            this.staInfo.Text = "statusStrip1";
            // 
            // tsslUserInfo
            // 
            this.tsslUserInfo.Name = "tsslUserInfo";
            this.tsslUserInfo.Size = new System.Drawing.Size(131, 17);
            this.tsslUserInfo.Text = "toolStripStatusLabel1";
            this.tsslUserInfo.Click += new System.EventHandler(this.tsslUserInfo_Click);
            // 
            // tsslRoleInfo
            // 
            this.tsslRoleInfo.Name = "tsslRoleInfo";
            this.tsslRoleInfo.Size = new System.Drawing.Size(131, 17);
            this.tsslRoleInfo.Text = "toolStripStatusLabel1";
            // 
            // tsslLoginTime
            // 
            this.tsslLoginTime.Name = "tsslLoginTime";
            this.tsslLoginTime.Size = new System.Drawing.Size(131, 17);
            this.tsslLoginTime.Text = "toolStripStatusLabel1";
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.ClientSize = new System.Drawing.Size(674, 470);
            this.Controls.Add(this.staInfo);
            this.Controls.Add(this.menuStrip1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "frmMain";
            this.Text = "购书管理系统";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.frmMain_Load);
            this.FormClosed += new System.Windows.Forms.FormClosedEventHandler(this.frmMain_FormClosed);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.staInfo.ResumeLayout(false);
            this.staInfo.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.StatusStrip staInfo;
        private System.Windows.Forms.ToolStripMenuItem ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsmiLogOut;
        private System.Windows.Forms.ToolStripMenuItem tsmiExit;
        private System.Windows.Forms.ToolStripMenuItem 图书管理ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 会员管理ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsmiCreateCard;
        private System.Windows.Forms.ToolStripMenuItem 销售管理ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsmiCreateSale;
        private System.Windows.Forms.ToolStripMenuItem tsmiInCome;
        private System.Windows.Forms.ToolStripMenuItem tsmiToAddBook;
        private System.Windows.Forms.ToolStripMenuItem tsmiToManageBook;
        private System.Windows.Forms.ToolStripMenuItem tsmiManageCard;
        private System.Windows.Forms.ToolStripMenuItem 关于ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 帮助ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 员工管理ToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem tsmiAddUser;
        private System.Windows.Forms.ToolStripMenuItem tsmiManageUser;
        private System.Windows.Forms.ToolStripMenuItem tsmiRoleManage;
        private System.Windows.Forms.ToolStripMenuItem tsmiInComeAccount;
        private System.Windows.Forms.ToolStripMenuItem tsmiStockAccount;
        private System.Windows.Forms.ToolStripMenuItem tsmiSaleAccount;
        private System.Windows.Forms.ToolStripStatusLabel tsslUserInfo;
        private System.Windows.Forms.ToolStripStatusLabel tsslLoginTime;
        private System.Windows.Forms.ToolStripMenuItem tsmlSelectUser;
        private System.Windows.Forms.ToolStripStatusLabel tsslRoleInfo;

    }
}