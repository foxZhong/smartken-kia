using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace BookSystem
{
    public partial class frmRoleManage : Form
    {
        List<Rolers> rolers = new List<Rolers>();
        int id = 0;
        string name = "";
        public frmRoleManage()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(this.txtJob.Text))
            {
                MessageBox.Show("请输入职位名！", "输入提示", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return;
            }
            Rolers role = new Rolers();
            role.Name = this.txtJob.Text;
            int result = UserManage.addRolers(role);
            if (result == 1)
            {
                LoadAllRolers();
                MessageBox.Show("添加成功！");
                txtJob.Text = "";
            }
        }

        public void LoadAllRolers()
        {
            this.dataGridView1.AutoGenerateColumns = false;
            rolers = UserManage.getAllRolers();
            this.dataGridView1.DataSource = rolers;
        }

        private void frmRoleManage_Load(object sender, EventArgs e)
        {
            LoadAllRolers();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (id != 0)
            {
                UserManage.deleteRolersById(id);
                LoadAllRolers();
                MessageBox.Show("删除成功！");
            }
            else
                MessageBox.Show("请选择删除对象！");
        }

        private void dataGridView1_CellMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            try
            {
                id = int.Parse(dataGridView1.Rows[e.RowIndex].Cells["Column2"].Value.ToString());
            }
            catch { }
        }

        private void dataGridView1_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            try
            {
                name = dataGridView1.Rows[e.RowIndex].Cells["Column1"].Value.ToString();
            }
            catch { }
            txtJob.Text = name;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (id == 0)
                MessageBox.Show("请选择");
            else
            {
                UserManage.updateRolers(txtJob.Text, id);
                LoadAllRolers();
                MessageBox.Show("修改成功！");
            }
        }
    }
}
