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
    public partial class frmManageCard : Form
    {
        List<Card> cards;
        Card c;
        int cardid = 0;
        public frmManageCard()
        {
            InitializeComponent();
            //cards = CardManage.getAllCards();
        }

        public void addListView()
        {
            cards = CardManage.getAllCards();
            lvCard.Items.Clear();
            foreach (Card card in cards)
            {
                ListViewItem lvi = new ListViewItem(card.Name);
                lvi.Tag = card.Id;
                lvi.SubItems.Add(card.Discount.ToString());
                lvCard.Items.Add(lvi);
            }
        }
        
        private void frmManageCard_Load(object sender, EventArgs e)
        {
            addListView();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            c = new Card();
            c.Id = cardid;
            c.Name = this.txtCardName.Text;
            c.Discount = float.Parse(this.nubDiscount.Value.ToString());
            if (cardid == 0)
                MessageBox.Show("请选择一个卡！");
            else
            {
                if (CardManage.updateCard(c) == 1)
                {
                    
                    MessageBox.Show("保存成功！");
                    addListView();
                }
                else
                    MessageBox.Show("保存失败！");
            }
        }

        private void btnDel_Click(object sender, EventArgs e)
        {
            if (cardid == 0)
                MessageBox.Show("请选择一个卡！");
            else
            {
                if (CardManage.deleteCard(cardid) == 1)
                {
                    MessageBox.Show("删除成功！");
                    addListView();
                }
                else
                    MessageBox.Show("无法删除！");
            }        
        }

        private void lvCard_Click(object sender, EventArgs e)
        {
            cardid = int.Parse(lvCard.SelectedItems[0].Tag.ToString());
            this.txtCardName.Text = CardManage.getCardById(cardid).Name;
            this.nubDiscount.Value = Convert.ToDecimal(CardManage.getCardById(cardid).Discount);
        }
    }
}
