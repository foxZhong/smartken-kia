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
    public partial class frmSaleMonthAccount : Form
    {

        private const string BASE_SALE_SQL = "select sale_id,sale_code,sum_price,sum_itemprice,card_name,card_discount,u_realname,sale_date from v_sales where 1=1";

    

        private DataSet ds = new DataSet();

        public frmSaleMonthAccount()
        {
            InitializeComponent();
        
        }

        private void frmSaleMonthAccount_Load(object sender, EventArgs e)
        {
            nudYear.Value=DateTime.Now.Year;

            loadDgvMonths();
                
            }

        private void loadDgvMonths()
        {
          
                using (MySqlConnection con = DBHelper.getCon())
                {

                    MySqlDataAdapter adapter = new MySqlDataAdapter(string.Format("CALL proc_month_account({0})", nudYear.Value), con);
                    if(ds.Tables["months"]!=null)
                    ds.Tables["months"].Clear();
                    adapter.Fill(ds, "months");
                    dgvMonths.DataSource = ds.Tables["months"];
                }
                float sumincome = 0;
                int sumcount = 0;
                for (int i = 0; i < ds.Tables["months"].Rows.Count; i++)
                {
                    sumincome = sumincome + float.Parse(ds.Tables["months"].Rows[i][1].ToString());
                    sumcount += int.Parse(ds.Tables["months"].Rows[i][2].ToString());
                }
            lbSumCount.Text=sumcount.ToString();
            lbSumIncome.Text = sumincome.ToString() + "元";
        }

        private void dgvMonths_CellMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {

            string ym = ds.Tables["months"].Rows[e.RowIndex]["ym"].ToString();
            //MessageBox.Show(ym);
            loadDgvSale(ym);
            loadDgvTookbook(ym);
        }

        private void loadDgvSale(string ym)
        {
            string condition = string.Format(" having sale_date between '{0}-1' and '{0}-31'", ym);
            try
            {
                using (MySqlConnection con = DBHelper.getCon())
                {
                    MySqlDataAdapter adapter = new MySqlDataAdapter(BASE_SALE_SQL + condition, con);
                    if (ds.Tables["sales"] != null)
                        ds.Tables["sales"].Clear();
                    adapter.Fill(ds, "sales");
                    dgvSales.DataSource = ds.Tables["sales"];
                }
            }
            catch { }
        }

        private void loadDgvTookbook(string ym)
        {
            string str = string.Format("CALL proc_topsalebook_account('{0}-1');", ym);
            try
            {
                using (MySqlConnection con = DBHelper.getCon())
                {
                    MySqlDataAdapter adapter = new MySqlDataAdapter(str, con);
                    if (ds.Tables["topBooks"] != null)
                        ds.Tables["topBooks"].Clear();
                    adapter.Fill(ds, "topBooks");
                     dgvTopBook.DataSource = ds.Tables["topBooks"];
                }
            }
            catch { }
        }

        private void btnLoadMonths_Click(object sender, EventArgs e)
        {
            this.loadDgvMonths();
        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

       

    
    }
}
    

