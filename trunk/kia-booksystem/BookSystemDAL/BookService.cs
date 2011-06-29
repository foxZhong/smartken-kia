using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;

namespace BookSystem
{
   public class BookService
   {
       #region 根据图书ID查找一本图书
       public static Book getBookById(int b_id)
       {
           Book book = null;
  
           using (MySqlConnection con = DBHelper.getCon())
           {
               string str = "select * from books where b_id=@bid";
               using (MySqlCommand cmd = new MySqlCommand(str, con))
               {
                   cmd.Parameters.AddWithValue("@bid", b_id);
                   con.Open();
                   MySqlDataReader reader = cmd.ExecuteReader();
                   if (reader.Read())
                   {
                       book = new Book();
                       book.Id = int.Parse(reader["b_id"].ToString());
                       book.Isbn = reader["b_isbn"].ToString();
                       book.Name = reader["b_name"].ToString();
                       book.Price = float.Parse(reader["b_price"].ToString());
                       book.PubDate = Convert.ToDateTime(reader["b_pubdate"]);
                       book.PubId = int.Parse(reader["b_pubid"].ToString());
                       book.Statue = int.Parse(reader["b_statue"].ToString());
                       book.Stock = int.Parse(reader["b_stock"].ToString());
                       book.StockDate = Convert.ToDateTime(reader["b_stockdate"]);
                       book.Author = reader["b_author"].ToString();
                       book.Desc = reader["b_desc"].ToString();
                       book.GenId = int.Parse(reader["b_genid"].ToString());
                   }
               }
               con.Close();
               //con.Dispose();
           }
           return book;
          
       }
       #endregion

       #region 根据二级类型ID查找多本图书
       public static List<Book> getBookByCatId(int b_genid)
       {
           List<Book> books = new List<Book>();

           using (MySqlConnection con = DBHelper.getCon())
           {
               string str = "select * from books where b_genid=@b_genid";
               using (MySqlCommand cmd = new MySqlCommand(str, con))
               {
                   cmd.Parameters.AddWithValue("@b_genid", b_genid);
                   con.Open();
                   MySqlDataReader reader = cmd.ExecuteReader();
                   while (reader.Read())
                   {
                       Book book = new Book();
                       book.Id = Convert.ToInt32(reader["b_id"]);
                       book.Isbn = reader["b_isbn"].ToString();
                       book.Name = reader["b_name"].ToString();
                       book.Price = float.Parse(reader["b_price"].ToString());
                       book.PubDate = Convert.ToDateTime(reader["b_pubdate"]);
                       book.PubId = Convert.ToInt32(reader["b_pubid"]);
                       book.Statue = Convert.ToInt32(reader["b_statue"]);
                       book.Stock = Convert.ToInt32(reader["b_stock"]);
                       book.StockDate = Convert.ToDateTime(reader["b_stockdate"]);
                       book.Author = reader["b_author"].ToString();
                       book.Desc = reader["b_desc"].ToString();
                       book.GenId = Convert.ToInt32(reader["b_genid"]);
                       books.Add(book);
                   }
               }
               con.Close();
               //con.Dispose();
           }
           return books;
       }
       #endregion

       #region 添加一本图书

       public static int addBook(Book book)
       {
           int result = 0;

           using (MySqlConnection conn = DBHelper.getCon())
           {
               string str = "insert into books (b_isbn,b_name,b_author,b_desc,b_pubid,b_pubdate,b_price,b_genid,b_stock,b_stockdate,b_statue) values(@isbn,@name,@author,@desc,@pubid,@pubdate,@price,@genid,@stock,@stockdate,@statue)";
               MySqlCommand cmd = new MySqlCommand(str, conn);
               cmd.Parameters.AddWithValue("@isbn", book.Isbn);
               cmd.Parameters.AddWithValue("@name", book.Name);
               cmd.Parameters.AddWithValue("@author", book.Author);
               cmd.Parameters.AddWithValue("@desc", book.Desc);
               cmd.Parameters.AddWithValue("@pubid", book.PubId);
               cmd.Parameters.AddWithValue("@pubdate", book.PubDate);
               cmd.Parameters.AddWithValue("@price", book.Price);
               cmd.Parameters.AddWithValue("@genid", book.GenId);
               cmd.Parameters.AddWithValue("@stock", book.Stock);
               cmd.Parameters.AddWithValue("@stockdate", book.StockDate);
               cmd.Parameters.AddWithValue("@statue", book.Statue);

               conn.Open();
               result = (int)cmd.ExecuteNonQuery();
               conn.Close();
           }
           return result;
       }
       #endregion

       #region 修改一本图书
       public static int updateBook(Book book)
       {
           int result = 0;
           using (MySqlConnection conn = DBHelper.getCon())
           {
               string str = "update books set b_isbn=@isbn,b_name=@name,b_author=@author,b_desc=@desc,b_pubid=@pubid,b_pubdate=@pubdate,b_price=@price,b_genid=@genid,b_stock=@stock,b_stockdate=@stockdate,b_statue=@statue where b_id=@id";
               MySqlCommand cmd = new MySqlCommand(str, conn);
               cmd.Parameters.AddWithValue("@isbn", book.Isbn);
               cmd.Parameters.AddWithValue("@name", book.Name);
               cmd.Parameters.AddWithValue("@author", book.Author);
               cmd.Parameters.AddWithValue("@desc", book.Desc);
               cmd.Parameters.AddWithValue("@pubid", book.PubId);
               cmd.Parameters.AddWithValue("@pubdate", book.PubDate);
               cmd.Parameters.AddWithValue("@price", book.Price);
               cmd.Parameters.AddWithValue("@genid", book.GenId);
               cmd.Parameters.AddWithValue("@stock", book.Stock);
               cmd.Parameters.AddWithValue("@stockdate", book.StockDate);
               cmd.Parameters.AddWithValue("@statue", book.Statue);
               cmd.Parameters.AddWithValue("@id", book.Id);

               conn.Open();
               result =(int)cmd.ExecuteNonQuery();
               conn.Close();
               conn.Dispose();
           }
           return result;
       }
       #endregion

       #region 删除一本书
       public static int deleteBook(int b_id)
       {
           int result = 0;
           using (MySqlConnection conn = DBHelper.getCon())
           {
               string str = "delete from books where b_id=@id";
               MySqlCommand cmd = new MySqlCommand(str, conn);
               cmd.Parameters.AddWithValue("@id", b_id);
               conn.Open();
               result = (int)cmd.ExecuteNonQuery();
               conn.Close();
               conn.Dispose();
           }
           return result;
       }
       #endregion


       #region 根据ISBN查询一本书

       public static Book getBookByISBN(string isbn)
       {
           Book book = null;

           using (MySqlConnection con = DBHelper.getCon())
           {
               string str = "select * from books where b_isbn=@isbn";
               using (MySqlCommand cmd = new MySqlCommand(str, con))
               {
                   cmd.Parameters.AddWithValue("@isbn", isbn);
                   con.Open();
                   MySqlDataReader reader = cmd.ExecuteReader();
                   if (reader.Read())
                   {
                       book = new Book();
                       book.Id = Convert.ToInt32(reader["b_id"]);
                       book.Isbn = reader["b_isbn"].ToString();
                       book.Name = reader["b_name"].ToString();
                       book.Price = float.Parse(reader["b_price"].ToString());
                       book.PubDate = Convert.ToDateTime(reader["b_pubdate"]);
                       book.PubId = Convert.ToInt32(reader["b_pubid"]);
                       book.Statue = Convert.ToInt32(reader["b_statue"]);
                       book.Stock = Convert.ToInt32(reader["b_stock"]);
                       book.StockDate = Convert.ToDateTime(reader["b_stockdate"]);
                       book.Author = reader["b_author"].ToString();
                       book.Desc = reader["b_desc"].ToString();
                       book.GenId = Convert.ToInt32(reader["b_genid"]);
                   }
               }
               con.Close();
               //con.Dispose();
           }
           return book;
       }

       #endregion

       #region 高级搜索图书
       public static List<Book> searchBooks(Book book)
       {
           List<Book> books = new List<Book>();
           return books;
       }
       #endregion


       #region 获取头一本图书
       public static List<Book> getFirstBook()
       {
           List<Book> books = new List<Book>();

           using (MySqlConnection con = DBHelper.getCon())
           {
               string str = "select * from books limit 0,1";
               using (MySqlCommand cmd = new MySqlCommand(str, con))
               {
                   con.Open();
                   MySqlDataReader reader = cmd.ExecuteReader();
                   while (reader.Read())
                   {
                       Book book = new Book();
                       book.Id = int.Parse(reader["b_id"].ToString());
                       book.Isbn = reader["b_isbn"].ToString();
                       book.Name = reader["b_name"].ToString();
                       book.Price = float.Parse(reader["b_price"].ToString());
                       book.PubDate = Convert.ToDateTime(reader["b_pubdate"]);
                       book.PubId = int.Parse(reader["b_pubid"].ToString());
                       book.Statue = int.Parse(reader["b_statue"].ToString());
                       book.Stock = int.Parse(reader["b_stock"].ToString());
                       book.StockDate = Convert.ToDateTime(reader["b_stockdate"]);
                       book.Author = reader["b_author"].ToString();
                       book.Desc = reader["b_desc"].ToString();
                       book.GenId = int.Parse(reader["b_genid"].ToString());
                       books.Add(book);
                   }
               }
               con.Close();
           }
           return books;

       }
       #endregion


   }
}
