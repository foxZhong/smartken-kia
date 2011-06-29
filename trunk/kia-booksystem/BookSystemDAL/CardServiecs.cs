using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;

namespace BookSystem
{
    public class CardServiecs
    {
        #region 查找所有卡
        public static List<Card> getAllCards()
        {
            List<Card> cards = new List<Card>();
            string str = "select * from cards";
            using (MySqlConnection con = DBHelper.getCon())
            {
                con.Open();
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    MySqlDataReader reader = cmd.ExecuteReader();
                    while(reader.Read())
                    {
                        Card card = new Card();
                        card.Id = int.Parse(reader["card_id"].ToString());
                        card.Name = reader["card_name"].ToString();
                        card.Discount = float.Parse(reader["card_discount"].ToString());
                        cards.Add(card);
                    }
                }
            }
            return cards;
        }
        #endregion

        #region 根据id查找优惠卡
        public static Card getCardById(int card_id)
        {
            Card card = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from cards where card_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@id", card_id);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        card = new Card();
                        card.Id = int.Parse(reader["card_id"].ToString());
                        card.Name = reader["card_name"].ToString();
                        card.Discount = float.Parse(reader["card_discount"].ToString());
                    }
                }
                con.Close();
                con.Dispose();
            }
            return card;
        }
        #endregion

        #region 增加一种卡类型

        public static int addCard(Card d)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "insert into cards (card_name,card_discount) values(@name,@discount)";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@name", d.Name);
                cmd.Parameters.AddWithValue("@discount", d.Discount);

                conn.Open();
                result = Convert.ToInt32(cmd.ExecuteNonQuery());
                conn.Close();
                conn.Dispose();
            }
            return result;
        }

        #endregion

        #region 修改优惠卡
        public static int updateCard(Card card)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "update cards set card_name=@name,card_discount=@discount where card_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@id", card.Id);
                cmd.Parameters.AddWithValue("@name", card.Name);
                cmd.Parameters.AddWithValue("@discount", card.Discount);

                conn.Open();
                result = (int)cmd.ExecuteNonQuery();
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 删除优惠卡
        public static int deleteCard(int id)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "delete from cards where card_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@id", id);
                conn.Open();
                result = (int)cmd.ExecuteNonQuery();
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion
    }
}
