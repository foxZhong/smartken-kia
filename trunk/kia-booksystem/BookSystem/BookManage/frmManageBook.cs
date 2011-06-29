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
    public partial class frmManageBook : Form
    {
        private const string baseAddr = "../../BooksCover/";

        private Book book;

        public frmManageBook()
        {
            InitializeComponent();
            book = BookManage.getFirstBook()[0];
            loadBook(book);
        }

        private void BtnReturn_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void FrmManageBook_Load(object sender, EventArgs e)
        {
            List<Categorie> cats=BookManage.getAllCategories();
            foreach (Categorie cat in cats)
            {
                TreeNode ctn = new TreeNode();
                ctn.Text = cat.Title;
                ctn.Tag = cat.Id;
                foreach (Genre gen in BookManage.getGenresByCatId(cat.Id))
                {
                    TreeNode gtn = new TreeNode();
                    gtn.Text = gen.Title;
                    gtn.Tag = gen.Id;
                    ctn.Nodes.Add(gtn);
                }
                tvBooks.Nodes.Add(ctn);
            }
        }

        private void tvBooks_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            TreeNode tn = e.Node;
            if (tn.Level == 1 && tn.Nodes.Count==0)
            {
                foreach (Book book in BookManage.getBooksByGenId(int.Parse(tn.Tag.ToString())))
                {
                    TreeNode btn=new TreeNode(book.Name);
                    btn.Tag=book.Id;
                    tn.Nodes.Add(btn);
                }
            }
        }

        private void tvBooks_NodeMouseDoubleClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            TreeNode tn = e.Node;
            if (tn.Level == 2)
            {
               this.book=BookManage.getBookById(int.Parse(tn.Tag.ToString()));
               loadBook(book);
            }
        }

        public void loadBook(Book book)
        {
            lbAuthor.Text = book.Author;
            Genre gen = BookManage.getGenreById(book.GenId);
            Categorie cat = BookManage.getCategorieById(gen.CatId);
            lbCatgroie.Text = cat.Title;
            lbGenre.Text = gen.Title;
            txtDesc.Text = book.Desc;
            lbIsbn.Text = book.Isbn;
            lbName.Text = book.Name;
            lbPrice.Text = book.Price.ToString();
            lbPub.Text = BookManage.getPublisherById(book.PubId).Name;
            lbPubDate.Text = book.PubDate.ToString();
            lbStatue.Text = book.Statue == 1 ? "否" : "是";
            lbStock.Text = book.Stock.ToString();
            
            string imgAddr=string.Format(baseAddr+"{0}/{1}.jpg",cat.Id,book.Isbn);
            try
            {
                FileStream fs = File.Open(imgAddr, FileMode.Open, FileAccess.Read);
                pbCover.Image = Image.FromStream(fs);
                fs.Close();
            }
            catch {
                FileStream fs = File.Open(baseAddr+"nophoto.jpg", FileMode.Open, FileAccess.Read);
                pbCover.Image = Image.FromStream(fs);
                fs.Close();
            }
           
           // = img;
          
        }

        public PictureBox getPbCover()
        {
            return this.pbCover;
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            frmUpdateBook frm = new frmUpdateBook(this,book);
            frm.Show();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            frmSeachBook frm = new frmSeachBook();
            frm.Show();
        }

        public PictureBox getCover()
        {
            return this.pbCover;
        }

        private void BtnDelet_Click(object sender, EventArgs e)
        {
            if (BookManage.deleteBook(book.Id) != 0)
            {
                MessageBox.Show("删除成功！");
                File.Delete(string.Format(baseAddr+"{0}/{1}.jpg",BookManage.getGenreById(book.GenId).Id,book.Isbn));
                book = BookManage.getFirstBook()[0];
                loadBook(book);
            }
            else
            {
                MessageBox.Show("删除失败！");
            }
        }
    }
}
