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
    public partial class frmSale : Form
    {

        Book book;
        Card card;
        List<SaleItems> items;
        private const string baseAddr = "../../BooksCover/";
        private User user;
        float totals = 0;
        public frmSale()
        {
            InitializeComponent();
            this.user = frmMain.user;
            book = null;
            items = new List<SaleItems>();
        }

        private void SaleForm_Load(object sender, EventArgs e)
        {
            Initial();
           
        }

        private void Initial()
        {
            this.lblRealName.Text = user.RealName;
            this.lblISBN.Text = "";
            this.lblName.Text = "";
            this.lblAuthor.Text = "";
            this.lblPrice.Text = "";
            this.lblDiscountedPirce.Text = "";
            this.lblPublisher.Text = "";
            this.lblStock.Text = "";
            //this.lblPubDate.Text = "";
            this.lblTotal.Text = "";
            this.lblGathering.Text = "";
            this.lblFindMoney.Text = "";
            this.txtPay.Text = "";

            cobCardId.DisplayMember = "Name";
            foreach (Card card in CardManage.getAllCards())
            {
                cobCardId.Items.Add(card);
            }
            cobCardId.SelectedItem = cobCardId.Items[0];
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            book = BookManage.getBookByISBN(txtISBN.Text);
            if (book != null)
            {
                if (this.nudCount.Value > book.Stock)
                    MessageBox.Show("库存不足！");
                else
                {
                    BookInfo();
                    addSaleItem();
                    loadlvSale();
                    this.nudCount.Value = 1;
                    this.txtISBN.Text = "";
                }
            }
            else
                MessageBox.Show("ISBN码错误！");
            
        }

        private void addSaleItem()
        {
            bool hasSame=false;
            foreach (SaleItems i in items)
            {
                if (i.BookId == book.Id)
                {   hasSame = true;
                    i.Count=(int)nudCount.Value;
                    break;
                }
            }
            if (!hasSame)
            {
                SaleItems item = new SaleItems();
                item.BookId = book.Id;
                item.Count = (int)nudCount.Value;
                card = cobCardId.SelectedItem as Card;
                item.Price = book.Statue == 1 ?book.Price:(book.Price * card.Discount);
                items.Add(item);
            }
           
           
        }

        private void updateSaleItem()
        {
            foreach (SaleItems item in items)
            {
                card = cobCardId.SelectedItem as Card;
                Book b = BookManage.getBookById(item.BookId);
                item.Price = b.Statue == 1 ? b.Price : (b.Price * card.Discount);
            }
        }

        private void loadlvSale()
        {
            float total = 0;
            lvSale.Items.Clear();
            foreach(SaleItems item in items )
            {
                Book b = BookManage.getBookById(item.BookId);
                ListViewItem lvi = new ListViewItem(b.Isbn);
                lvi.Tag = b.Id;
                lvi.SubItems.Add(b.Name);
                lvi.SubItems.Add(item.Count.ToString());
                lvi.SubItems.Add(b.Price.ToString() + "元");
                lvi.SubItems.Add(item.Price+"元");
                lvi.SubItems.Add((item.Price*item.Count)+"元");
                lvSale.Items.Add(lvi);
                total = total + (item.Price * item.Count);
                totals = total;
            }
            
            lblTotal.Text = totals.ToString() + "元";
            lblGathering.Text = totals.ToString() + "元";
        }

        public void BookInfo()
        {
            this.lblISBN.Text = book.Isbn;
            this.lblName.Text = book.Name;
            this.lblAuthor.Text = book.Author;
            this.lblPrice.Text = book.Price.ToString();
            card = cobCardId.SelectedItem as Card;
            this.lblDiscountedPirce.Text = book.Statue == 1 ? book.Price.ToString() : (book.Price * card.Discount).ToString();
            this.lblPublisher.Text = BookManage.getPublisherById(book.PubId).Name;
            this.lblStock.Text = book.Stock.ToString();
            //this.lblPubDate.Text = book.PubDate.ToString().Substring(0,8);
            string imgurl=string.Format(baseAddr+"{0}/{1}.jpg",BookManage.getGenreById(book.GenId).CatId,book.Isbn);
            this.pbCover.Image = Image.FromFile(imgurl);
        }

        private void btnLoadBook_Click(object sender, EventArgs e)
        {
            book = BookManage.getBookByISBN(txtISBN.Text);
            if(book!=null)
            BookInfo();
        }

        private void btnConfirm_Click(object sender, EventArgs e)
        {
            if (txtPay.Text != "")
            {
                if (int.Parse(txtPay.Text) > totals)
                {
                    Sales sale = new Sales();
                    sale.UId = frmMain.user.Id;
                    Card card = cobCardId.SelectedItem as Card;
                    sale.CardId = card.Id;
                    string tempcode = SaleManage.getSaleCode();
                    while (SaleManage.checkIsSaleCodeExist(tempcode) != null)
                    {
                        tempcode = SaleManage.getSaleCode();
                    }
                    sale.Code = tempcode;
                    SaleManage.addSale(sale, items, float.Parse(txtPay.Text));
                    Initial();
                    lvSale.Items.Clear();
                    MessageBox.Show("购买成功！");
                }
                else
                    MessageBox.Show("金额不足！");
            }
            else
            {
                MessageBox.Show("请付款！");
            }
        }

        private void lvSale_Click(object sender, EventArgs e)
        {
            this.txtISBN.Text = lvSale.SelectedItems[0].Text;
            //this.nudCount.Value = int.Parse(lvSale.SelectedItems[0].Tag.ToString());
            int id = (int)lvSale.SelectedItems[0].Tag;
            foreach (SaleItems item in items)
            {
                if (id == item.Id)
                {     
                    this.nudCount.Value = item.Count;
                    break;
                }
            }
            book = BookManage.getBookByISBN(txtISBN.Text);
            if (book != null)
                BookInfo();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void cobCardId_SelectedIndexChanged(object sender, EventArgs e)
        {
            this.updateSaleItem();
            this.loadlvSale();
        }

        private void txtPay_TextChanged(object sender, EventArgs e)
        {
            if (this.txtPay.Text == "")
                this.lblFindMoney.Text = "";
            else
            {
                this.lblFindMoney.Text = (float.Parse(this.txtPay.Text) - totals).ToString() + "元";
            }
        }

        private void tsmiDelete_Click(object sender, EventArgs e)
        {
            int id=(int)lvSale.SelectedItems[0].Tag;
            //lvSale.SelectedItems[0].Remove();
            //SaleManage.deleteSaleItem();
            foreach (SaleItems item in items)
            {
                if (item.BookId == id)
                { items.Remove(item);
                MessageBox.Show("删除成功！");
                lvSale.SelectedItems.Clear();
                    break; }
            }
           
            this.loadlvSale();
        }
    }
}
