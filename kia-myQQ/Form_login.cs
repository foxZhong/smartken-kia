using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace MyQQ
{
    public partial class Form_login: Form
    {
        public Form_login()
        {
            InitializeComponent();
        }

        private void lblLogin_MouseMove(object sender, MouseEventArgs e)
        {
            lblLogin.ForeColor = Color.Red;
            
           
            
        }

        private void lblLogin_MouseClick(object sender, MouseEventArgs e)
        {
            this.Hide();
            new Form_regedit().Show();
        }

        private void lblLogin_MouseLeave(object sender, EventArgs e)
        {
            lblLogin.ForeColor = Color.Black;
            
        }

    }
}