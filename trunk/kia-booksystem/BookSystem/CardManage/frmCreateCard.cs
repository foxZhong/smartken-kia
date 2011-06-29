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
    public partial class frmCreateCard : Form
    {
        public frmCreateCard()
        {
            InitializeComponent();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnCreate_Click(object sender, EventArgs e)
        {
            Card d = new Card();
            d.Name = this.txtCardName.Text;
            d.Discount = float.Parse(this.nudDiscount.Value.ToString());
            if (CardManage.addCard(d) == 0)
            {
                MessageBox.Show("创建失败！");
            }
            else
            {
                MessageBox.Show("创建成功！");
            }
        }
    }
}
