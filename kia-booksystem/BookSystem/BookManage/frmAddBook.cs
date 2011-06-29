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
    public partial class frmAddBook : Form
    {
        private const string baseAddr="../../BooksCover/";
        private string imgAddr;

        public frmAddBook()
        {
            InitializeComponent();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Book book = new Book();
            book.Isbn = txtISBN.Text;
            book.Name = txtName.Text;
            book.Author = txtAuthor.Text;
            book.Desc = txtDesc.Text;
            book.Price = float.Parse(nupPrice.Value.ToString());
            Publisher pub = cobPub.SelectedItem as Publisher;
            book.PubId = pub.Id;
            Genre gen = cobGenres.SelectedItem as Genre;
            book.GenId = gen.Id;
            book.Statue = cboRebate.Checked ? 1 : 0;
            book.Stock = (int)nupStock.Value;
            book.PubDate = calPubDate.Value;
            int re= BookManage.addBook(book);
            if (re == 1)
            {
                imgAddr = baseAddr + gen.CatId + "/" + book.Isbn + ".jpg";

                //FileStream f = File.Create(imgAddr);
                Image.FromFile(ofdCover.FileName).Save(imgAddr);
                MessageBox.Show(string.Format("图片:{0}保存成功",book.Name));
            }
            else {
                MessageBox.Show(string.Format("图片:{0}保存失败", book.Name));
            }
        }

        private void frmAddBook_Load(object sender, EventArgs e)
        {
            loadCategories();

            loadPublisher();

            pbCover.Image = Image.FromFile(baseAddr+"nophoto.jpg");
            ofdCover.FileName = baseAddr + "nophoto.jpg";
           
        }

        private void loadPublisher()
        {
            foreach (Publisher pub in BookManage.getAllPublishers())
                cobPub.Items.Add(pub);
            cobPub.DisplayMember = "Name";
            cobPub.SelectedItem = cobPub.Items[0];
        }

        private void loadCategories()
        {
            foreach (Categorie cat in BookManage.getAllCategories())
                cobCategories.Items.Add(cat);
            cobCategories.DisplayMember = "Title";
            cobCategories.ValueMember = "Id";
            cobCategories.SelectedItem = cobCategories.Items[0];
        }



        private void cobCategories_SelectedIndexChanged(object sender, EventArgs e)
        {
           
            Categorie selcat = cobCategories.SelectedItem as Categorie;
            cobGenres.Items.Clear();
            foreach (Genre gen in BookManage.getGenresByCatId(selcat.Id))
            //foreach (Genre gen in BookManage.getGenresByCatId(int.Parse(cobCategories.SelectedValue.ToString())))
            {
                cobGenres.Items.Add(gen);
                cobGenres.DisplayMember = "Title";
                cobGenres.ValueMember = "Id";
            }
            cobGenres.SelectedItem = cobGenres.Items[0];
        }

        private void btnAddImg_Click(object sender, EventArgs e)
        {
            if (ofdCover.ShowDialog() == DialogResult.OK)
            {
                pbCover.Image = Image.FromFile(ofdCover.FileName);
            }
           
        }

        private void frmAddBook_FormClosed(object sender, FormClosedEventArgs e)
        {
            pbCover.Image.Dispose();
        }

       

      

    }
}
