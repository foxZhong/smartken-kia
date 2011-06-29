using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;


namespace BookSystem
{
    public class GenreService
    {

        #region 根据一级类型ID查找所有二级类型

        public static List<Genre> getGenresByCatId(int catid)
        {
            List<Genre> gens = new List<Genre>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from genres where gen_catId=@catid";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    cmd.Parameters.AddWithValue("@catid", catid);
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    while (reader.Read())
                    {
                        Genre gen = new Genre();
                        gen.Id = (int)reader["gen_id"];
                        gen.Title = reader["gen_title"].ToString();
                        gen.CatId = (int)reader["gen_catid"];
                        gens.Add(gen);
                    }
                }
            }
            return gens;
        }
        #endregion

        #region 根据二级类型的ID查找一个二级类型

        public static Genre getGenresById(int genid)
        {
            Genre gens = new Genre();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from genres where gen_id=@genid";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    cmd.Parameters.AddWithValue("@genid", genid);
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        gens.Id = (int)reader["gen_id"];
                        gens.CatId = (int)reader["gen_catid"];
                        gens.Title = reader["gen_title"].ToString();
                    }
                }
                con.Close();
           //     con.Dispose();
            }
            return gens;
        }
        #endregion

        #region 查找所有一级类型

        public static List<Categorie> getAllCategories()
        {
            List<Categorie> cats = new List<Categorie>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from categories";
                MySqlCommand cmd = new MySqlCommand(str, con);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Categorie cat = new Categorie();
                        cat.Id = int.Parse(reader["cat_id"].ToString());
                        cat.Title = reader["cat_title"].ToString();
                        cats.Add(cat);
                    }
                }
                con.Close();
              //  con.Dispose();
            }
            return cats;
        }
        #endregion

      

        #region 根据Id查找一级类型

        public static Categorie getCategoriesById(int id)
        {
            Categorie cat = new Categorie();

            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from categories where cat_id=@catid";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    cmd.Parameters.AddWithValue("@catid", id);
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        cat.Id = int.Parse(reader["cat_id"].ToString());
                        cat.Title = reader["cat_title"].ToString();
                    }
                }
                con.Close();
             //   con.Dispose();
            }
            return cat;
        }
        #endregion
    }
}
