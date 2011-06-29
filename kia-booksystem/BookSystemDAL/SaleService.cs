using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;

namespace BookSystem
{
    
    public class SaleService
    {
        #region 查找所有订单
        public static List<Sales> getAllSales()
        {
            List<Sales> sales = new List<Sales>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from sales";
                MySqlCommand cmd = new MySqlCommand(str, con);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Sales sale = new Sales();
                        sale.Id = int.Parse(reader["sale_id"].ToString());
                        sale.Code = reader["sale_code"].ToString();
                        sale.UId = int.Parse(reader["sale_uid"].ToString());
                        sale.SaleDate = Convert.ToDateTime(reader["sale_date"]);
                        sale.CardId = int.Parse(reader["sale_cardid"].ToString());
                        sales.Add(sale);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sales;
        }
        #endregion

        #region 根据id查找一张订单
        public static Sales getSaleById(int sale_id)
        {
            Sales sale = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from sales where sale_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@id", sale_id);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        sale = new Sales();
                        sale.Id = int.Parse(reader["sale_id"].ToString());
                        sale.Code = reader["sale_code"].ToString();
                        sale.UId = int.Parse(reader["sale_uid"].ToString());
                        sale.SaleDate = Convert.ToDateTime(reader["sale_date"]);
                        sale.CardId = int.Parse(reader["sale_cardid"].ToString());
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sale;
        }
        #endregion

        #region 添加一张订单
        public static int addSale(Sales s)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "proc_addsale";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@code", s.Code);
                cmd.Parameters.AddWithValue("@uid", s.UId);
                cmd.Parameters.AddWithValue("@cardid", s.CardId);
                conn.Open();
                result = int.Parse(cmd.ExecuteScalar().ToString());
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 删除一张订单
        public static int deleteSale(int sale_id)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "delete from sales where sale_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@id", sale_id);
                conn.Open();
                result = Convert.ToInt32(cmd.ExecuteScalar());
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 查找所有订单明细
        public static List<SaleItems> getAllSaleItems()
        {
            List<SaleItems> sis = new List<SaleItems>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from saleitems";
                MySqlCommand cmd = new MySqlCommand(str, con);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        SaleItems si = new SaleItems();
                        si.Id = int.Parse(reader["item_id"].ToString());
                        si.Price = float.Parse(reader["item_price"].ToString());
                        si.SaleId = int.Parse(reader["item_saleid"].ToString());
                        si.Count = int.Parse(reader["item_count"].ToString());
                        si.BookId = int.Parse(reader["item_bookid"].ToString());
                        sis.Add(si);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sis;
        }
        #endregion

        #region 添加一张订单明细
        public static int addSaleItem(SaleItems s)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                //string str = "insert into saleitems (item_price,item_saleid,item_count,item_bookid) values(@price,@saleid,@count,@bookid)";
                string str = "proc_addsaleitem";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                cmd.Parameters.AddWithValue("@price", s.Price);
                cmd.Parameters.AddWithValue("@saleid", s.SaleId);
                cmd.Parameters.AddWithValue("@counts", s.Count);
                cmd.Parameters.AddWithValue("@bookid", s.BookId);

                conn.Open();
                result = (int)cmd.ExecuteNonQuery();
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 删除一张订单明细
        public static int deleteSaleItem(int item_id)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "delete from saleitems where item_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@id", item_id);
                conn.Open();
                result = Convert.ToInt32(cmd.ExecuteScalar());
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 根据订单ID查找一张订单的所有明细项
        public static List<SaleItems> getSaleItemsBySaleId(int sale_id)
        {
            List<SaleItems> sales = new List<SaleItems>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from saleitems where item_saleid=@id";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@id", sale_id);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        SaleItems sale = new SaleItems();
                        sale.Id = int.Parse(reader["item_id"].ToString());
                        sale.Price = float.Parse(reader["item_price"].ToString());
                        sale.SaleId = int.Parse(reader["item_saleid"].ToString());
                        sale.Count = int.Parse(reader["item_count"].ToString());
                        sale.BookId = int.Parse(reader["item_bookid"].ToString());
                        sales.Add(sale);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sales;
        }
        #endregion

        #region 根据BookID查找一张订单的所有明细项
        public static List<SaleItems> getSaleItemsByBookId(int book_id)
        {
            List<SaleItems> sales = new List<SaleItems>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from saleitems where item_bookid=@bookid";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@bookid", book_id);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        SaleItems sale = new SaleItems();
                        sale.Id = int.Parse(reader["item_id"].ToString());
                        sale.BookId = int.Parse(reader["item_bookid"].ToString());                                                
                        sale.Count = int.Parse(reader["item_count"].ToString());
                        sale.Price = float.Parse(reader["item_price"].ToString());
                        sale.SaleId = int.Parse(reader["item_saleid"].ToString());
                        sales.Add(sale);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sales;
        }
        #endregion

        #region 根据UID查找相应订单
        public static List<Sales> getSalesByUid(int sale_uid)
        {
            List<Sales> sales = new List<Sales>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from sales where sale_uid=@uid";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@uid", sale_uid);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Sales sale = new Sales();
                        sale.Id = int.Parse(reader["sale_id"].ToString());
                        sale.Code = reader["sale_code"].ToString();
                        sale.UId = int.Parse(reader["sale_uid"].ToString());
                        sale.SaleDate = Convert.ToDateTime(reader["sale_date"].ToString());
                        Console.Write(sale.SaleDate);
                        sale.CardId = int.Parse(reader["sale_cardid"].ToString());
                        sales.Add(sale);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sales;
        }
        #endregion

        #region 根据UID和日期查找相应订单
        public static List<Sales> getSalesByUidAndDateTime(int sale_uid, string sale_date)
        {
            List<Sales> sales = new List<Sales>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from sales where sale_uid=@uid and date_format(@date,'%Y-%m-%d')=date_format(sale_date,'%Y-%m-%d')";
                Console.Write(str);
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@uid", sale_uid);
                cmd.Parameters.AddWithValue("@date", sale_date);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Sales sale = new Sales();
                        sale.Id = int.Parse(reader["sale_id"].ToString());
                        sale.Code = reader["sale_code"].ToString();
                        sale.UId = int.Parse(reader["sale_uid"].ToString());
                        //DateTime dt = Convert.ToDateTime(reader["sale_date"].ToString());
                        sale.SaleDate = DateTime.Parse(reader["sale_date"].ToString());
                        sale.CardId = int.Parse(reader["sale_cardid"].ToString());
                        sales.Add(sale);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sales;
        }
        #endregion

        #region 根据Saleid查找总价钱
        public static float getTotalBySaleId(int sale_id)
        {
            float Total;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select sum(item_count*item_price) from saleitems where item_saleid=@saleid";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@saleid", sale_id);
                con.Open();
                Total = Convert.ToSingle(cmd.ExecuteScalar());
                con.Close();
            }
            return Total;
        }
        #endregion

        #region 查找数据库时候是否有相同单号存在
        public static Sales checkIsSaleCodeExist(string salecode)
        {
            Sales sale = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from sales where sale_code=@code";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@code", salecode);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        sale = new Sales();
                        sale.Id = int.Parse(reader["sale_id"].ToString());
                        sale.Code = reader["sale_code"].ToString();
                        sale.UId = int.Parse(reader["sale_uid"].ToString());
                        sale.SaleDate = Convert.ToDateTime(reader["sale_date"]);
                        sale.CardId = int.Parse(reader["sale_cardid"].ToString());
                    }
                }
                con.Close();
                con.Dispose();
            }
            return sale;
        }
        #endregion
    }
}
