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
        private const string BASE_SQL = "select b_name,b_isbn,b_price,item_price,sale_date,item_count,(item_count*item_price) as sumprice from v_saledetail where 1=1 ";

        private const string GROUPBY_SQL = " group by item_bookid ";

        private const string ORDERBY_SQL = " order by sum(item_count) desc";
        //private const string BASESUMSQL = "select sum(total) from v_saledetail where 1=1";

        private MySqlDataAdapter adapter;
        private DataSet ds;

        private StringBuilder sb;


        public frmSaleAccount()
        {
            InitializeComponent();
            ds = new DataSet();
            sb = new StringBuilder(BASE_SQL);
        }

        private void frmSaleAccount_Load(object sender, EventArgs e)
        {

            using (MySqlConnection con = DBHelper.getCon())
            {
                adapter = new MySqlDataAdapter(sb.ToString(), con);
                adapter.Fill(ds, "saleitems");
                dgSaleClassify.DataSource = ds.Tables["saleitems"];
                float sum = 0;
                int count = 0;
                for (int i = 0; i < ds.Tables["saleitems"].Rows.Count; i++)
                {
                    sum = sum + float.Parse(ds.Tables["saleitems"].Rows[i]["sumprice"].ToString());
                }
                lbInfo.Text = string.Format("目前共有{0}条件记录，销售总额为{1}", ds.Tables["saleitems"].Rows.Count.ToString(), sum.ToString());

            }

                cobCategories.DisplayMember = "Title";
                foreach (Categorie cat in BookManage.getAllCategories())
                {
                    cobCategories.Items.Add(cat);
                }
                cobCategories.Items.Add(new Categorie());

                cobGenres.DisplayMember = "Title";
                cobGenres.Items.Add(new Genre());
                
                cobPubshers.DisplayMember = "Name";
                foreach (Publisher pub in BookManage.getAllPublishers())
                {
                    cobPubshers.Items.Add(pub);
                }
                cobPubshers.Items.Add(new Publisher());
          
            
            
        }

        private void loadSaleClassify()
        {
            using (MySqlConnection con = DBHelper.getCon())
            {
                adapter = new MySqlDataAdapter(sb.ToString(), con);
                ds.Tables["saleitems"].Clear();
                adapter.Fill(ds, "saleitems");
                dgSaleClassify.DataSource = ds.Tables["saleitems"];
                float sum = 0;
                for (int i = 0; i < ds.Tables["saleitems"].Rows.Count; i++)
                {
                    sum=sum+float.Parse(ds.Tables["saleitems"].Rows[i]["total"].ToString());
                }
                  lbInfo.Text = string.Format("搜索结果共有{0}条件记录，销售总额为{1}", ds.Tables["saleitems"].Rows.Count.ToString(), sum.ToString());
                   
            }
        }

        private void cobCategories_SelectedIndexChanged(object sender, EventArgs e)
        {
            Categorie cat=cobCategories.SelectedItem as Categorie;
            cobGenres.Items.Clear();
            cobGenres.Items.Add(new Genre());
            foreach (Genre gen in BookManage.getGenresByCatId(cat.Id))
            {
                cobGenres.Items.Add(gen);
            }
            cobGenres.SelectedIndex = 0;
        }

        private void chbSaleDateExact_CheckedChanged(object sender, EventArgs e)
        {

            if (chbSaleDateExact.Checked)
            {
                dtpSaleDate.Enabled = true;

                chbSaleDateRang.Checked = false;
                dtpMaxSaleDate.Enabled = false;
                dtpMinSaleDate.Enabled = false;
            }
            else
                dtpSaleDate.Enabled = false;

        }

        private void chbSaleDateRang_CheckedChanged(object sender, EventArgs e)
        {
            if (chbSaleDateRang.Checked)
            {
                dtpMaxSaleDate.Enabled = true;
                dtpMinSaleDate.Enabled = true;

                chbSaleDateExact.Checked = false;
                dtpSaleDate.Enabled = false;
            }
            else
            {
                dtpMaxSaleDate.Enabled = false;
                dtpMinSaleDate.Enabled = false;
            }
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            if(cobCategories.Text!="")
            sb.Append(string.Format(" and cat_title like '%{0}%'", cobCategories.Text));
            if(cobGenres.Text!="")
            sb.Append(string.Format(" and gen_title like '%{0}%'", cobGenres.Text));
            if(cobPubshers.Text!="")
            sb.Append(string.Format(" and pub_name like '%{0}%'",cobPubshers.Text));
            if(txtName.Text!="")
            sb.Append(string.Format(" and b_name like '%{0}%'",txtName.Text));
            if(txtIsbn.Text!="")
            sb.Append(string.Format(" and b_isbn like '%{0}%'", txtIsbn.Text));
            if (chbSaleDateExact.Checked)
                sb.Append(string.Format(" and sale_date like '{0}%'", dtpSaleDate.Text));
            else if (chbSaleDateRang.Checked)
                sb.Append(string.Format(" and sale_date between '{0}' and '{1}'", dtpMinSaleDate.Text, dtpMaxSaleDate.Text));
            MessageBox.Show(sb.ToString());
            this.loadSaleClassify();
            sb = new StringBuilder(BASE_SQL);
          
        }

        private void btnTopSale_Click(object sender, EventArgs e)
        {
            sb.Append(GROUPBY_SQL + ORDERBY_SQL);
            MessageBox.Show(sb.ToString());
            this.loadSaleClassify();
            sb = new StringBuilder(BASE_SQL);
        }

        private void cobGenres_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void cobPubshers_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
