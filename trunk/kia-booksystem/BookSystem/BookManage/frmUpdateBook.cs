using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace BookSystem
{
    public partial class frmUpdateBook : Form
    {
        private const string baseAddr = "../../BooksCover/";
        private string imgAddr;
        private Book book;
        private frmManageBook parent;
        public frmUpdateBook(frmManageBook f, Book book)
        {
            InitializeComponent();
            this.book = book;
            this.parent = f;
        }

        private void BtnReturn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void frmUpdateBook_Load(object sender, EventArgs e)
        {
            cobPub.DisplayMember = "Name";
            cobGenres.DisplayMember = "Title";
            cobCategories.DisplayMember = "Title";
            loadBook(book);
      
        }

        private void loadPubliser()
        {
            foreach (Publisher pub in BookManage.getAllPublishers())
                cobPub.Items.Add(pub);
            
        }

        private void loadCategories()
        {
            foreach (Categorie cat in BookManage.getAllCategories())
                cobCategories.Items.Add(cat);
            
            //cobCategories.SelectedItem = cobCategories.Items[0];
        }

        private void cobCategories_SelectedIndexChanged(object sender, EventArgs e)
        {
            Categorie selcat = cobCategories.SelectedItem as Categorie;
            cobGenres.Items.Clear();
            foreach (Genre gen in BookManage.getGenresByCatId(selcat.Id))
            {
                cobGenres.Items.Add(gen);
                //cobGenres.DisplayMember = "Title";
            }
    
           cobGenres.SelectedItem = cobGenres.Items[0];
        }

        public void loadBook(Book book)
        {
            txtName.Text = book.Name;
            txtISBN.Text = book.Isbn;
            txtAuthor.Text = book.Author;
            nupPrice.Value = decimal.Parse(book.Price.ToString());
            calPubDate.Value = book.PubDate;
            nupStock.Value = decimal.Parse(book.Stock.ToString());
            cboRebate.Checked = book.Statue == 1 ? false : true;
            txtDesc.Text = book.Desc;
          

           
            cobPub.Items.Add(BookManage.getPublisherById(book.PubId));
            cobPub.SelectedItem = cobPub.Items[0];
            loadPubliser();

            Genre gen = BookManage.getGenreById(book.GenId);
            Categorie cat = BookManage.getCategorieById(gen.CatId);

            imgAddr = string.Format(baseAddr + "{0}/{1}.jpg", cat.Id, book.Isbn);
         //   pbCover.Image = Image.FromFile(imgAddr);
            try
            {
                FileStream fs = File.Open(imgAddr, FileMode.Open, FileAccess.Read);
                pbCover.Image = Image.FromStream(fs);
                fs.Close();
            }
            catch
            {
                FileStream fs = File.Open(baseAddr+"nophoto.jpg", FileMode.Open, FileAccess.Read);
                pbCover.Image = Image.FromStream(fs);
                fs.Close();
            }
            ofdChangeCover.FileName = imgAddr;

          


            
            cobCategories.Items.Add(cat);
            cobCategories.SelectedItem = cobCategories.Items[0];
            loadCategories();

            cobGenres.Items.Add(gen);
            cobGenres.SelectedItem = cobGenres.Items[0];
        }

        private void BtnReset_Click(object sender, EventArgs e)
        {
            book = BookManage.getBookById(book.Id);
            loadBook(book);
        }

        private void btnChangeCover_Click(object sender, EventArgs e)
        {
            ofdChangeCover.Title = "请选择图片";
            if (ofdChangeCover.ShowDialog() == DialogResult.OK)
            {
                FileStream fs = File.Open(ofdChangeCover.FileName, FileMode.Open, FileAccess.Read);
                pbCover.Image = Image.FromStream(fs);
              fs.Close();
             
            }
           
            //ofdChangeCover.Filter = "Image (*.jpg)|*.jpg|";
       
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (ofdChangeCover.FileName != imgAddr)
            {
                this.pbCover.Image = null;
                File.Delete(imgAddr);
                Image.FromFile(ofdChangeCover.FileName).Save(imgAddr);
                //img.Save(imgAddr); 
                //this.parent.getPbCover().Image = null;
             
                //
               // pbCover.Image.Save(imgAddr);
            }   //这里就已经保存了图片
            Book b=new Book();
            b.Name = txtName.Text;
            b.Isbn = txtISBN.Text;
            Publisher pub=cobPub.SelectedItem as Publisher;
            b.PubId =pub.Id;
            Genre gen=cobGenres.SelectedItem as Genre;
            b.GenId=gen.Id;
            b.Author = txtAuthor.Text;
            b.Price = float.Parse(nupPrice.Value.ToString());
            b.PubDate = calPubDate.Value;
            b.Stock = (int)nupStock.Value;
                ;
            b.Desc = txtDesc.Text;
            b.Statue = cboRebate.Checked ? 0:1;
            b.Id = book.Id;

            if (BookManage.updateBook(b) != 0)
            {
                MessageBox.Show("修改成功！");
            }
            else
            {
                MessageBox.Show("修改失败！");
            }
            BtnReset_Click(sender, e);
            this.parent.loadBook(this.book);
        }
    }
}
