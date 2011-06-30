namespace myQQ
{
    partial class Frm_addFriend
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_addFriend));
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rbnSearch1 = new System.Windows.Forms.RadioButton();
            this.rbnSearch2 = new System.Windows.Forms.RadioButton();
            this.btnLookup = new System.Windows.Forms.Button();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnAccession = new System.Windows.Forms.Button();
            this.gbSearch1 = new System.Windows.Forms.GroupBox();
            this.cboSearchCity = new System.Windows.Forms.ComboBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.nudSearchMaxAge = new System.Windows.Forms.NumericUpDown();
            this.nudSearchMinAge = new System.Windows.Forms.NumericUpDown();
            this.label2 = new System.Windows.Forms.Label();
            this.cboSerachSex = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.tabControlFriend = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.gbSearch2 = new System.Windows.Forms.GroupBox();
            this.txtSearchID = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.rbnSearchID = new System.Windows.Forms.RadioButton();
            this.rbnSearchNickName = new System.Windows.Forms.RadioButton();
            this.txtSearchNickName = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.tabPageGroup = new System.Windows.Forms.TabPage();
            this.txtGroupName = new System.Windows.Forms.TextBox();
            this.rbnFindGroupName = new System.Windows.Forms.RadioButton();
            this.nupGroupId = new System.Windows.Forms.NumericUpDown();
            this.rbnFindGroupId = new System.Windows.Forms.RadioButton();
            this.label4 = new System.Windows.Forms.Label();
            this.dgvSearch = new System.Windows.Forms.DataGridView();
            this.id = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nickname = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.sex = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.age = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.faceid = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.查看详细信息ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.btnReturn = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.dgvSearchGroup = new System.Windows.Forms.DataGridView();
            this.groupid = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupname = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.host = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.message = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.picFace = new System.Windows.Forms.PictureBox();
            this.labResult = new System.Windows.Forms.Label();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.btnFindAll = new System.Windows.Forms.Button();
            this.btnEnterGroup = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.gbSearch1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSearchMaxAge)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSearchMinAge)).BeginInit();
            this.tabControlFriend.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.gbSearch2.SuspendLayout();
            this.tabPageGroup.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nupGroupId)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSearch)).BeginInit();
            this.contextMenuStrip1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSearchGroup)).BeginInit();
            this.groupBox4.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.picFace)).BeginInit();
            this.groupBox3.SuspendLayout();
            this.SuspendLayout();
            // 
            // pictureBox1
            // 
            this.pictureBox1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("pictureBox1.BackgroundImage")));
            this.pictureBox1.Location = new System.Drawing.Point(6, 20);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(100, 209);
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            // 
            // groupBox1
            // 
            this.groupBox1.BackColor = System.Drawing.Color.Transparent;
            this.groupBox1.Controls.Add(this.pictureBox1);
            this.groupBox1.Location = new System.Drawing.Point(12, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(126, 289);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "查找功能";
            // 
            // rbnSearch1
            // 
            this.rbnSearch1.AutoSize = true;
            this.rbnSearch1.Checked = true;
            this.rbnSearch1.Location = new System.Drawing.Point(91, 43);
            this.rbnSearch1.Name = "rbnSearch1";
            this.rbnSearch1.Size = new System.Drawing.Size(71, 16);
            this.rbnSearch1.TabIndex = 4;
            this.rbnSearch1.TabStop = true;
            this.rbnSearch1.Text = "条件查找";
            this.rbnSearch1.UseVisualStyleBackColor = true;
            this.rbnSearch1.CheckedChanged += new System.EventHandler(this.rbnSearch_CheckedChanged);
            // 
            // rbnSearch2
            // 
            this.rbnSearch2.AutoSize = true;
            this.rbnSearch2.Location = new System.Drawing.Point(168, 43);
            this.rbnSearch2.Name = "rbnSearch2";
            this.rbnSearch2.Size = new System.Drawing.Size(71, 16);
            this.rbnSearch2.TabIndex = 5;
            this.rbnSearch2.Text = "精确查找";
            this.rbnSearch2.UseVisualStyleBackColor = true;
            this.rbnSearch2.CheckedChanged += new System.EventHandler(this.rbnSearch_CheckedChanged);
            // 
            // btnLookup
            // 
            this.btnLookup.Location = new System.Drawing.Point(340, 278);
            this.btnLookup.Name = "btnLookup";
            this.btnLookup.Size = new System.Drawing.Size(75, 23);
            this.btnLookup.TabIndex = 6;
            this.btnLookup.Text = "查找";
            this.btnLookup.UseVisualStyleBackColor = true;
            this.btnLookup.Click += new System.EventHandler(this.btnLookup_Click);
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(421, 278);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(75, 23);
            this.btnClose.TabIndex = 7;
            this.btnClose.Text = "关闭";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnAccession
            // 
            this.btnAccession.Location = new System.Drawing.Point(259, 278);
            this.btnAccession.Name = "btnAccession";
            this.btnAccession.Size = new System.Drawing.Size(75, 23);
            this.btnAccession.TabIndex = 8;
            this.btnAccession.Text = "加为好友";
            this.btnAccession.UseVisualStyleBackColor = true;
            this.btnAccession.Click += new System.EventHandler(this.btnAccession_Click);
            // 
            // gbSearch1
            // 
            this.gbSearch1.Controls.Add(this.cboSearchCity);
            this.gbSearch1.Controls.Add(this.label6);
            this.gbSearch1.Controls.Add(this.label5);
            this.gbSearch1.Controls.Add(this.nudSearchMaxAge);
            this.gbSearch1.Controls.Add(this.nudSearchMinAge);
            this.gbSearch1.Controls.Add(this.label2);
            this.gbSearch1.Controls.Add(this.cboSerachSex);
            this.gbSearch1.Controls.Add(this.label1);
            this.gbSearch1.Location = new System.Drawing.Point(45, 65);
            this.gbSearch1.Name = "gbSearch1";
            this.gbSearch1.Size = new System.Drawing.Size(248, 121);
            this.gbSearch1.TabIndex = 6;
            this.gbSearch1.TabStop = false;
            // 
            // cboSearchCity
            // 
            this.cboSearchCity.FormattingEnabled = true;
            this.cboSearchCity.Location = new System.Drawing.Point(89, 87);
            this.cboSearchCity.Name = "cboSearchCity";
            this.cboSearchCity.Size = new System.Drawing.Size(103, 20);
            this.cboSearchCity.TabIndex = 7;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(32, 90);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(29, 12);
            this.label6.TabIndex = 6;
            this.label6.Text = "城市";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(132, 54);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(17, 12);
            this.label5.TabIndex = 5;
            this.label5.Text = "至";
            // 
            // nudSearchMaxAge
            // 
            this.nudSearchMaxAge.Location = new System.Drawing.Point(155, 52);
            this.nudSearchMaxAge.Name = "nudSearchMaxAge";
            this.nudSearchMaxAge.Size = new System.Drawing.Size(37, 21);
            this.nudSearchMaxAge.TabIndex = 4;
            this.nudSearchMaxAge.Value = new decimal(new int[] {
            30,
            0,
            0,
            0});
            // 
            // nudSearchMinAge
            // 
            this.nudSearchMinAge.Location = new System.Drawing.Point(89, 52);
            this.nudSearchMinAge.Name = "nudSearchMinAge";
            this.nudSearchMinAge.Size = new System.Drawing.Size(37, 21);
            this.nudSearchMinAge.TabIndex = 3;
            this.nudSearchMinAge.Value = new decimal(new int[] {
            10,
            0,
            0,
            0});
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(32, 56);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(29, 12);
            this.label2.TabIndex = 2;
            this.label2.Text = "年龄";
            // 
            // cboSerachSex
            // 
            this.cboSerachSex.FormattingEnabled = true;
            this.cboSerachSex.Items.AddRange(new object[] {
            "男",
            "女"});
            this.cboSerachSex.Location = new System.Drawing.Point(89, 14);
            this.cboSerachSex.Name = "cboSerachSex";
            this.cboSerachSex.Size = new System.Drawing.Size(71, 20);
            this.cboSerachSex.TabIndex = 1;
            this.cboSerachSex.Text = "男女不限";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(29, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "性别";
            // 
            // tabControlFriend
            // 
            this.tabControlFriend.Controls.Add(this.tabPage1);
            this.tabControlFriend.Controls.Add(this.tabPageGroup);
            this.tabControlFriend.Location = new System.Drawing.Point(6, 20);
            this.tabControlFriend.Name = "tabControlFriend";
            this.tabControlFriend.SelectedIndex = 0;
            this.tabControlFriend.Size = new System.Drawing.Size(349, 244);
            this.tabControlFriend.TabIndex = 9;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.gbSearch2);
            this.tabPage1.Controls.Add(this.gbSearch1);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.rbnSearch2);
            this.tabPage1.Controls.Add(this.rbnSearch1);
            this.tabPage1.Location = new System.Drawing.Point(4, 21);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(341, 219);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Tag = "0";
            this.tabPage1.Text = "查找好友";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // gbSearch2
            // 
            this.gbSearch2.BackColor = System.Drawing.Color.Transparent;
            this.gbSearch2.Controls.Add(this.txtSearchID);
            this.gbSearch2.Controls.Add(this.label8);
            this.gbSearch2.Controls.Add(this.rbnSearchID);
            this.gbSearch2.Controls.Add(this.rbnSearchNickName);
            this.gbSearch2.Controls.Add(this.txtSearchNickName);
            this.gbSearch2.Controls.Add(this.label7);
            this.gbSearch2.Location = new System.Drawing.Point(45, 65);
            this.gbSearch2.Name = "gbSearch2";
            this.gbSearch2.Size = new System.Drawing.Size(248, 121);
            this.gbSearch2.TabIndex = 11;
            this.gbSearch2.TabStop = false;
            // 
            // txtSearchID
            // 
            this.txtSearchID.Location = new System.Drawing.Point(115, 73);
            this.txtSearchID.Name = "txtSearchID";
            this.txtSearchID.Size = new System.Drawing.Size(100, 21);
            this.txtSearchID.TabIndex = 5;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(44, 77);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(65, 12);
            this.label8.TabIndex = 4;
            this.label8.Text = "按账号查找";
            // 
            // rbnSearchID
            // 
            this.rbnSearchID.AutoSize = true;
            this.rbnSearchID.Location = new System.Drawing.Point(24, 76);
            this.rbnSearchID.Name = "rbnSearchID";
            this.rbnSearchID.Size = new System.Drawing.Size(14, 13);
            this.rbnSearchID.TabIndex = 3;
            this.rbnSearchID.UseVisualStyleBackColor = true;
            // 
            // rbnSearchNickName
            // 
            this.rbnSearchNickName.AutoSize = true;
            this.rbnSearchNickName.Checked = true;
            this.rbnSearchNickName.Location = new System.Drawing.Point(24, 35);
            this.rbnSearchNickName.Name = "rbnSearchNickName";
            this.rbnSearchNickName.Size = new System.Drawing.Size(14, 13);
            this.rbnSearchNickName.TabIndex = 2;
            this.rbnSearchNickName.TabStop = true;
            this.rbnSearchNickName.UseVisualStyleBackColor = true;
            this.rbnSearchNickName.CheckedChanged += new System.EventHandler(this.rbnSearchNickName_CheckedChanged);
            // 
            // txtSearchNickName
            // 
            this.txtSearchNickName.Location = new System.Drawing.Point(115, 32);
            this.txtSearchNickName.Name = "txtSearchNickName";
            this.txtSearchNickName.Size = new System.Drawing.Size(100, 21);
            this.txtSearchNickName.TabIndex = 1;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(44, 36);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(65, 12);
            this.label7.TabIndex = 0;
            this.label7.Text = "按昵称查找";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(43, 28);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(173, 12);
            this.label3.TabIndex = 7;
            this.label3.Text = "可以设置条件查询条件查询好友";
            // 
            // tabPageGroup
            // 
            this.tabPageGroup.Controls.Add(this.txtGroupName);
            this.tabPageGroup.Controls.Add(this.rbnFindGroupName);
            this.tabPageGroup.Controls.Add(this.nupGroupId);
            this.tabPageGroup.Controls.Add(this.rbnFindGroupId);
            this.tabPageGroup.Controls.Add(this.label4);
            this.tabPageGroup.Location = new System.Drawing.Point(4, 21);
            this.tabPageGroup.Name = "tabPageGroup";
            this.tabPageGroup.Padding = new System.Windows.Forms.Padding(3);
            this.tabPageGroup.Size = new System.Drawing.Size(341, 219);
            this.tabPageGroup.TabIndex = 1;
            this.tabPageGroup.Tag = "1";
            this.tabPageGroup.Text = "查找群";
            this.tabPageGroup.UseVisualStyleBackColor = true;
            // 
            // txtGroupName
            // 
            this.txtGroupName.Location = new System.Drawing.Point(127, 129);
            this.txtGroupName.Name = "txtGroupName";
            this.txtGroupName.Size = new System.Drawing.Size(120, 21);
            this.txtGroupName.TabIndex = 10;
            // 
            // rbnFindGroupName
            // 
            this.rbnFindGroupName.AutoSize = true;
            this.rbnFindGroupName.Location = new System.Drawing.Point(26, 129);
            this.rbnFindGroupName.Name = "rbnFindGroupName";
            this.rbnFindGroupName.Size = new System.Drawing.Size(83, 16);
            this.rbnFindGroupName.TabIndex = 9;
            this.rbnFindGroupName.Text = "按群名查找";
            this.rbnFindGroupName.UseVisualStyleBackColor = true;
            // 
            // nupGroupId
            // 
            this.nupGroupId.Location = new System.Drawing.Point(127, 72);
            this.nupGroupId.Maximum = new decimal(new int[] {
            10000,
            0,
            0,
            0});
            this.nupGroupId.Minimum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nupGroupId.Name = "nupGroupId";
            this.nupGroupId.Size = new System.Drawing.Size(120, 21);
            this.nupGroupId.TabIndex = 8;
            this.nupGroupId.Value = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            // 
            // rbnFindGroupId
            // 
            this.rbnFindGroupId.AutoSize = true;
            this.rbnFindGroupId.Checked = true;
            this.rbnFindGroupId.Location = new System.Drawing.Point(26, 72);
            this.rbnFindGroupId.Name = "rbnFindGroupId";
            this.rbnFindGroupId.Size = new System.Drawing.Size(83, 16);
            this.rbnFindGroupId.TabIndex = 7;
            this.rbnFindGroupId.TabStop = true;
            this.rbnFindGroupId.Text = "按群号查找";
            this.rbnFindGroupId.UseVisualStyleBackColor = true;
            this.rbnFindGroupId.CheckedChanged += new System.EventHandler(this.rbnFindGroupId_CheckedChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(48, 18);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(161, 12);
            this.label4.TabIndex = 6;
            this.label4.Text = "可以设置条件查询条件查询群";
            // 
            // dgvSearch
            // 
            this.dgvSearch.AllowUserToAddRows = false;
            this.dgvSearch.AllowUserToDeleteRows = false;
            this.dgvSearch.BackgroundColor = System.Drawing.SystemColors.ButtonHighlight;
            this.dgvSearch.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvSearch.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.id,
            this.nickname,
            this.sex,
            this.age,
            this.faceid});
            this.dgvSearch.ContextMenuStrip = this.contextMenuStrip1;
            this.dgvSearch.GridColor = System.Drawing.SystemColors.ButtonShadow;
            this.dgvSearch.Location = new System.Drawing.Point(2, 109);
            this.dgvSearch.MultiSelect = false;
            this.dgvSearch.Name = "dgvSearch";
            this.dgvSearch.ReadOnly = true;
            this.dgvSearch.RowHeadersVisible = false;
            this.dgvSearch.RowHeadersWidth = 21;
            this.dgvSearch.RowTemplate.Height = 23;
            this.dgvSearch.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvSearch.Size = new System.Drawing.Size(343, 145);
            this.dgvSearch.TabIndex = 10;
            this.dgvSearch.Click += new System.EventHandler(this.dgvSearch_Click);
            // 
            // id
            // 
            this.id.DataPropertyName = "id";
            this.id.HeaderText = "QQ号";
            this.id.Name = "id";
            this.id.ReadOnly = true;
            // 
            // nickname
            // 
            this.nickname.DataPropertyName = "nickname";
            this.nickname.HeaderText = "昵称";
            this.nickname.Name = "nickname";
            this.nickname.ReadOnly = true;
            // 
            // sex
            // 
            this.sex.DataPropertyName = "sex";
            this.sex.HeaderText = "性别";
            this.sex.Name = "sex";
            this.sex.ReadOnly = true;
            // 
            // age
            // 
            this.age.DataPropertyName = "age";
            this.age.HeaderText = "年龄";
            this.age.Name = "age";
            this.age.ReadOnly = true;
            // 
            // faceid
            // 
            this.faceid.DataPropertyName = "faceid";
            this.faceid.HeaderText = "Column1";
            this.faceid.Name = "faceid";
            this.faceid.ReadOnly = true;
            this.faceid.Visible = false;
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.查看详细信息ToolStripMenuItem});
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(143, 26);
            this.contextMenuStrip1.Click += new System.EventHandler(this.btnLookInfo_Click);
            // 
            // 查看详细信息ToolStripMenuItem
            // 
            this.查看详细信息ToolStripMenuItem.Name = "查看详细信息ToolStripMenuItem";
            this.查看详细信息ToolStripMenuItem.Size = new System.Drawing.Size(142, 22);
            this.查看详细信息ToolStripMenuItem.Text = "查看详细信息";
            // 
            // btnReturn
            // 
            this.btnReturn.Location = new System.Drawing.Point(340, 278);
            this.btnReturn.Name = "btnReturn";
            this.btnReturn.Size = new System.Drawing.Size(75, 23);
            this.btnReturn.TabIndex = 11;
            this.btnReturn.Text = "返回";
            this.btnReturn.UseVisualStyleBackColor = true;
            this.btnReturn.Click += new System.EventHandler(this.btnReturn_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.BackColor = System.Drawing.Color.Transparent;
            this.groupBox2.Controls.Add(this.dgvSearchGroup);
            this.groupBox2.Controls.Add(this.groupBox4);
            this.groupBox2.Controls.Add(this.labResult);
            this.groupBox2.Controls.Add(this.dgvSearch);
            this.groupBox2.Location = new System.Drawing.Point(141, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(351, 260);
            this.groupBox2.TabIndex = 12;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "查找结果";
            // 
            // dgvSearchGroup
            // 
            this.dgvSearchGroup.AllowUserToAddRows = false;
            this.dgvSearchGroup.AllowUserToDeleteRows = false;
            this.dgvSearchGroup.BackgroundColor = System.Drawing.SystemColors.ButtonHighlight;
            this.dgvSearchGroup.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvSearchGroup.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.groupid,
            this.groupname,
            this.host,
            this.message});
            this.dgvSearchGroup.ContextMenuStrip = this.contextMenuStrip1;
            this.dgvSearchGroup.GridColor = System.Drawing.SystemColors.ButtonShadow;
            this.dgvSearchGroup.Location = new System.Drawing.Point(3, 109);
            this.dgvSearchGroup.MultiSelect = false;
            this.dgvSearchGroup.Name = "dgvSearchGroup";
            this.dgvSearchGroup.ReadOnly = true;
            this.dgvSearchGroup.RowHeadersVisible = false;
            this.dgvSearchGroup.RowHeadersWidth = 21;
            this.dgvSearchGroup.RowTemplate.Height = 23;
            this.dgvSearchGroup.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvSearchGroup.Size = new System.Drawing.Size(343, 145);
            this.dgvSearchGroup.TabIndex = 16;
            this.dgvSearchGroup.Click += new System.EventHandler(this.dgvSearchGroup_Click);
            // 
            // groupid
            // 
            this.groupid.DataPropertyName = "id";
            this.groupid.HeaderText = "群号";
            this.groupid.Name = "groupid";
            this.groupid.ReadOnly = true;
            // 
            // groupname
            // 
            this.groupname.DataPropertyName = "groupname";
            this.groupname.HeaderText = "群名";
            this.groupname.Name = "groupname";
            this.groupname.ReadOnly = true;
            // 
            // host
            // 
            this.host.DataPropertyName = "hostid";
            this.host.HeaderText = "群主号";
            this.host.Name = "host";
            this.host.ReadOnly = true;
            this.host.Visible = false;
            // 
            // message
            // 
            this.message.DataPropertyName = "message";
            this.message.HeaderText = "群公告";
            this.message.Name = "message";
            this.message.ReadOnly = true;
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.picFace);
            this.groupBox4.Location = new System.Drawing.Point(239, 6);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(85, 85);
            this.groupBox4.TabIndex = 13;
            this.groupBox4.TabStop = false;
            // 
            // picFace
            // 
            this.picFace.Location = new System.Drawing.Point(8, 11);
            this.picFace.Name = "picFace";
            this.picFace.Size = new System.Drawing.Size(70, 67);
            this.picFace.TabIndex = 12;
            this.picFace.TabStop = false;
            // 
            // labResult
            // 
            this.labResult.AutoSize = true;
            this.labResult.Location = new System.Drawing.Point(20, 56);
            this.labResult.Name = "labResult";
            this.labResult.Size = new System.Drawing.Size(0, 12);
            this.labResult.TabIndex = 11;
            // 
            // groupBox3
            // 
            this.groupBox3.BackColor = System.Drawing.Color.Transparent;
            this.groupBox3.Controls.Add(this.tabControlFriend);
            this.groupBox3.Location = new System.Drawing.Point(141, 12);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(355, 264);
            this.groupBox3.TabIndex = 13;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "查找";
            // 
            // btnFindAll
            // 
            this.btnFindAll.Location = new System.Drawing.Point(259, 278);
            this.btnFindAll.Name = "btnFindAll";
            this.btnFindAll.Size = new System.Drawing.Size(75, 23);
            this.btnFindAll.TabIndex = 15;
            this.btnFindAll.Text = "查找全部";
            this.btnFindAll.UseVisualStyleBackColor = true;
            this.btnFindAll.Click += new System.EventHandler(this.btnFindAll_Click);
            // 
            // btnEnterGroup
            // 
            this.btnEnterGroup.Location = new System.Drawing.Point(259, 278);
            this.btnEnterGroup.Name = "btnEnterGroup";
            this.btnEnterGroup.Size = new System.Drawing.Size(75, 23);
            this.btnEnterGroup.TabIndex = 16;
            this.btnEnterGroup.Text = "加入群";
            this.btnEnterGroup.UseVisualStyleBackColor = true;
            this.btnEnterGroup.Click += new System.EventHandler(this.btnEnterGroup_Click);
            // 
            // Frm_addFriend
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.CancelButton = this.btnClose;
            this.ClientSize = new System.Drawing.Size(505, 311);
            this.Controls.Add(this.btnFindAll);
            this.Controls.Add(this.btnReturn);
            this.Controls.Add(this.btnEnterGroup);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.btnAccession);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnLookup);
            this.Name = "Frm_addFriend";
            this.Text = "查找/添加";
            this.Load += new System.EventHandler(this.Frm_addFriend_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.gbSearch1.ResumeLayout(false);
            this.gbSearch1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSearchMaxAge)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSearchMinAge)).EndInit();
            this.tabControlFriend.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.gbSearch2.ResumeLayout(false);
            this.gbSearch2.PerformLayout();
            this.tabPageGroup.ResumeLayout(false);
            this.tabPageGroup.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nupGroupId)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSearch)).EndInit();
            this.contextMenuStrip1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvSearchGroup)).EndInit();
            this.groupBox4.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.picFace)).EndInit();
            this.groupBox3.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton rbnSearch2;
        private System.Windows.Forms.RadioButton rbnSearch1;
        private System.Windows.Forms.Button btnLookup;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnAccession;
        private System.Windows.Forms.GroupBox gbSearch1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox cboSearchCity;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.NumericUpDown nudSearchMaxAge;
        private System.Windows.Forms.NumericUpDown nudSearchMinAge;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cboSerachSex;
        private System.Windows.Forms.TabControl tabControlFriend;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPageGroup;
        private System.Windows.Forms.DataGridView dgvSearch;
        private System.Windows.Forms.GroupBox gbSearch2;
        private System.Windows.Forms.TextBox txtSearchID;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.RadioButton rbnSearchID;
        private System.Windows.Forms.RadioButton rbnSearchNickName;
        private System.Windows.Forms.TextBox txtSearchNickName;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button btnReturn;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.PictureBox picFace;
        private System.Windows.Forms.Label labResult;
        private System.Windows.Forms.DataGridViewTextBoxColumn id;
        private System.Windows.Forms.DataGridViewTextBoxColumn nickname;
        private System.Windows.Forms.DataGridViewTextBoxColumn sex;
        private System.Windows.Forms.DataGridViewTextBoxColumn age;
        private System.Windows.Forms.DataGridViewTextBoxColumn faceid;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 查看详细信息ToolStripMenuItem;
        private System.Windows.Forms.Button btnFindAll;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.RadioButton rbnFindGroupName;
        private System.Windows.Forms.NumericUpDown nupGroupId;
        private System.Windows.Forms.RadioButton rbnFindGroupId;
        private System.Windows.Forms.TextBox txtGroupName;
        private System.Windows.Forms.DataGridView dgvSearchGroup;
        private System.Windows.Forms.DataGridViewTextBoxColumn groupid;
        private System.Windows.Forms.DataGridViewTextBoxColumn groupname;
        private System.Windows.Forms.DataGridViewTextBoxColumn host;
        private System.Windows.Forms.DataGridViewTextBoxColumn message;
        private System.Windows.Forms.Button btnEnterGroup;
    }
}