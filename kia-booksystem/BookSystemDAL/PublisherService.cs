using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;

namespace BookSystem
{
    public class PublisherService
    {
        #region 查找所有出版社
        public static List<Publisher> getAllPublishers()
        {
            List<Publisher> pubs = new List<Publisher>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from publishers";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    
                        while (reader.Read())
                        {
                            Publisher pub = new Publisher();
                            pub.Id = int.Parse(reader["pub_id"].ToString());
                            pub.Name = reader["pub_name"].ToString();
                            pubs.Add(pub);
                            
                        }
                    
                }
                con.Close();
             //   con.Dispose();
            }
            return pubs;
        }
        #endregion

        #region 根据ID查找一个出版社
        public static Publisher getPublisherById(int pub_id)
        {
            Publisher pub = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from publishers where pub_id=@id";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    cmd.Parameters.AddWithValue("@id", pub_id);
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    
                        if (reader.Read())
                        {
                            pub = new Publisher();
                            pub.Id = int.Parse(reader["pub_id"].ToString());
                            pub.Name = reader["pub_name"].ToString();
                        }
                    
                }
                con.Close();
                con.Dispose();
            }
            return pub;
        }
        #endregion

    }
}
