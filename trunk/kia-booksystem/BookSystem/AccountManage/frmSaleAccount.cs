using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace BookSystem
{
    public partial class frmSaleAccount : Form
    {
        private const string BASESQL = "select b_name,b_isbn,sale_date,item_price,item_count,total from v_saledetail";

        private const string BASESUMSQL = "select sum(total) from v_saledetail";

        private MySqlDataAdapter adapter;
        private DataSet ds=new DataSet();



        public frmSaleAccount()
        {
            InitializeComponent();
        }

        private void frmSaleAccount_Load(object sender, EventArgs e)
        {
            using (MySqlConnection con = DBHelper.getCon())
            {
                adapter = new MySqlDataAdapter(BASESQL,con);
                adapter.Fill(ds,"saleitems");
                dgSaleClassify.DataSource = ds.Tables["saleitems"];
                using(MySqlCommand cmd=new MySqlCommand(BASESUMSQL,con))
                {
                    con.Open();
                   float sum=(float)cmd.ExecuteScalar();
                   lbInfo.Text = string.Format("当前查询到{0}条件记录，销售总额为{1}", ds.Tables["saleitems"].Rows.Count.ToString(),sum.ToString());
                }
            }
            
        }
    }
}
