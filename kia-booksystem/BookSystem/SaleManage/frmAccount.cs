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
    public partial class frmAccount : Form
    {
        List<Sales> sales;
        List<SaleItems> items;
        private User user;
        float totals;
        public frmAccount(User u)
        {
            InitializeComponent();
            this.user = u;
        }

        public void addSaleListView()
        {
            float total=0;
            sales = SaleManage.getSalesByUid(user.Id);
            lvSales.Items.Clear();
            foreach (Sales sale in sales)
            {
                ListViewItem lvi = new ListViewItem(sale.Code);
                lvi.Tag = sale.Id;
                lvi.SubItems.Add(sale.SaleDate.ToString());
                lvi.SubItems.Add(CardManage.getCardById(sale.CardId).Name);
                lvi.SubItems.Add(SaleManage.getTotalBySaleId(sale.Id).ToString() + "元");
                lvSales.Items.Add(lvi);
                total = total + SaleManage.getTotalBySaleId(sale.Id);
                totals = total;
            }
            this.lblSaleTotal.Text = totals.ToString() + "元";
        }

        public void addItemsListView()
        {
            int salesid = int.Parse(lvSales.SelectedItems[0].Tag.ToString());
            items = SaleManage.getSaleItemsBySaleId(salesid);
            lvItems.Items.Clear();
            foreach (SaleItems saleitem in items)
            {
                ListViewItem lvi = new ListViewItem(BookManage.getBookById(saleitem.BookId).Name);
                lvi.Tag = saleitem.Id;
                lvi.SubItems.Add(saleitem.Count.ToString());
                lvi.SubItems.Add(saleitem.Price.ToString() + "元");
                lvi.SubItems.Add((saleitem.Count * saleitem.Price).ToString() + "元");
                lvItems.Items.Add(lvi);
            }
        }

        public void addSaleListViewByDateTime()
        {
            //MessageBox.Show(this.dateTimePicker.Value.ToShortDateString().ToString());
            sales = SaleManage.getSalesByUidAndDateTime(user.Id, this.dateTimePicker.Value.ToShortDateString().ToString());
            lvSales.Items.Clear();
            foreach (Sales sale in sales)
            {
                ListViewItem lvi = new ListViewItem(sale.Code);
                lvi.Tag = sale.Id;
                lvi.SubItems.Add(sale.SaleDate.ToString());
                lvi.SubItems.Add(CardManage.getCardById(sale.CardId).Name);
                lvi.SubItems.Add(SaleManage.getTotalBySaleId(sale.Id).ToString());
                lvSales.Items.Add(lvi);
            }
            this.lblSaleTotal.Text = totals.ToString() + "元";
        }

        private void frmAccount_Load(object sender, EventArgs e)
        {
            addSaleListView();
            this.lblName.Text = user.RealName;
        }

        private void lvSales_Click(object sender, EventArgs e)
        {
            addItemsListView();
        }

        private void btnSet_Click(object sender, EventArgs e)
        {
            addSaleListView();
        }

        private void dateTimePicker_ValueChanged(object sender, EventArgs e)
        {
            addSaleListViewByDateTime();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
