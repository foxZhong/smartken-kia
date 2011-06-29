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
    public partial class frmSeachBook : Form
    {
        private const string BASESQL = "select b_id,b_name,b_author,b_isbn,pub_name,b_price,b_stock ,b_pubdate,cat_title,gen_title from v_bookdetail where 1=1 ";
        MySqlDataAdapter adapter;
        DataSet ds;
        StringBuilder sb;

        public frmSeachBook()
        {
            InitializeComponent();
            ds = new DataSet();
          
        }

       

        public void loadBooks(){

                          
            using(MySqlConnection con=DBHelper.getCon())
            {
            
            adapter = new MySqlDataAdapter(sb.ToString(),con);
            ds.Tables["books"].Clear();
            adapter.Fill(ds, "books");
            dgvBooks.DataSource = ds.Tables["books"];
            lbSearchInfo.Text=string.Format("当前搜索到的书籍共有 {0} 本",ds.Tables["books"].Rows.Count.ToString());
            }
        }

      

        private void btnReturn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmSeachBook_Load(object sender, EventArgs e)
        {

            sb = new StringBuilder(BASESQL);
            using (MySqlConnection con = DBHelper.getCon())
            {
               adapter = new MySqlDataAdapter(sb.ToString(), con);
                adapter.Fill(ds, "books");
                dgvBooks.DataSource = ds.Tables["books"];
                lbSearchInfo.Text = string.Format("当前库存的书籍共有 {0} 本", ds.Tables["books"].Rows.Count.ToString());
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

        private void btnSearch_Click(object sender, EventArgs e)
        {
            if (txtName.Text != "")
                sb.Append(string.Format("and b_name regexp '{0}' ",txtName.Text));
            if (txtAuthor.Text != "")
                sb.Append(string.Format("and b_author regexp '{0}' ", txtAuthor.Text));
            if (txtISBN.Text != "")
                sb.Append(string.Format("and b_isbn regexp '{0}' ", txtISBN.Text));
            if (cobPubshers.Text != "")
                sb.Append(string.Format("and pub_name regexp '{0}' ", cobPubshers.Text));
            if (cobCategories.Text != "")
                sb.Append(string.Format("and cat_title regexp '{0}' ", cobCategories.Text));
            if (cobGenres.Text != "")
                sb.Append(string.Format("and gen_title regexp '{0}' ", cobGenres.Text));
            
            if (chbPriceExact.Checked)
                sb.Append(string.Format("and b_price={0} ", nudPrice.Value.ToString()));
            if(chbPriceRang.Checked)
                sb.Append(string.Format("and b_price between {0} and {1} ",nudMinPrice.Value.ToString(),nudMaxPrice.Value.ToString()));
            
            if (chbStockExact.Checked)
                sb.Append(string.Format("and b_stock={0} ", nudStock.Value.ToString()));
            if (chbStockRang.Checked)
                sb.Append(string.Format("and b_stock between {0} and {1} ",nudMinStock.Value.ToString(),nudMaxStock.Value.ToString()));

            if (rabStatue0.Checked)
                sb.Append("and b_statue=0 ");
            if (rabStatue1.Checked)
                sb.Append("and b_statue=1 ");

            if (chbUseDate.Checked)
                sb.Append(string.Format("and b_pubdate between '{0}' and '{1}' ", dtpMinPubDate.Text, dtpMaxPubDate.Text));

            if (chbSotckDateExact.Checked)
                sb.Append(string.Format("and b_stockdate='{0}' ", dtpStockDate.Text));
            if (chbStockDateRang.Checked)
                sb.Append(string.Format("and b_stockdate between '{0}' and '{1}' ", dtpMinStockDate.Text, dtpMaxStockDate.Text));
            loadBooks();
          // MessageBox.Show(sb.ToString());
            sb = new StringBuilder(BASESQL);
        }


        private void chbStockRang_CheckedChanged(object sender, EventArgs e)
        {
            if (chbStockRang.Checked)
            {
                nudMaxStock.Enabled = true;
                nudMinStock.Enabled = true;
                chbStockExact.Checked = false;
                nudStock.Enabled = false;
            }
            else
            {
                nudMaxStock.Enabled = false;
                nudMinStock.Enabled = false;
            }
        }

        private void chbStockExact_CheckedChanged(object sender, EventArgs e)
        {
            if (chbStockExact.Checked)
            {
                nudMaxStock.Enabled = false;
                nudMinStock.Enabled = false;
                chbStockRang.Checked = false;
                nudStock.Enabled = true;
            }
            else
            {
                nudStock.Enabled = false;
            }
        }

        private void cbhPriceRang_CheckedChanged(object sender, EventArgs e)
        {
            if (chbPriceRang.Checked)
            {
                nudMaxPrice.Enabled = true;
                nudMinPrice.Enabled = true;
                chbPriceExact.Checked = false;
                nudPrice.Enabled = false;
            }
            else
            {
                nudMaxPrice.Enabled = false;
                nudMinPrice.Enabled = false;
            }
        }

        private void cbhPriceExact_CheckedChanged(object sender, EventArgs e)
        {
            if (chbPriceExact.Checked)
            {
                nudMaxPrice.Enabled = false;
                nudMinPrice.Enabled = false;
                chbPriceRang.Checked = false;
                nudPrice.Enabled = true;
            }
            else
            {
                nudPrice.Enabled = false;
            }
        }

        private void chbUseDate_CheckedChanged(object sender, EventArgs e)
        {
            dtpMaxPubDate.Enabled = chbUseDate.Checked;
            dtpMinPubDate.Enabled = chbUseDate.Checked;
        }

        private void chbSotckDateExact_CheckedChanged(object sender, EventArgs e)
        {
            if (chbSotckDateExact.Checked)
            {
                chbStockDateRang.Checked = false;
                dtpMaxStockDate.Enabled = false;
                dtpMinStockDate.Enabled = false;
                dtpStockDate.Enabled = true;
            }
            else
                dtpStockDate.Enabled = false;
        }

        private void chbStockDateRang_CheckedChanged(object sender, EventArgs e)
        {
            if (chbStockDateRang.Checked)
            {
                chbSotckDateExact.Checked = false;
                dtpStockDate.Enabled = false;
                dtpMaxStockDate.Enabled = true;
                dtpMinStockDate.Enabled = true;
            }
            else
            {
                dtpMaxStockDate.Enabled = false;
                dtpMinStockDate.Enabled = false;
            }
        }

        private void cobCategories_SelectedIndexChanged(object sender, EventArgs e)
        {
            Categorie cat = cobCategories.SelectedItem as Categorie;
            cobGenres.Items.Clear();
            cobGenres.Items.Add(new Genre());
            foreach (Genre gen in BookManage.getGenresByCatId(cat.Id))
            {
                cobGenres.Items.Add(gen);
            }
            cobGenres.SelectedIndex = 0;
        }
        
   

      
    }
}
