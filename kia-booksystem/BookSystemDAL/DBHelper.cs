using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Configuration;
using MySql.Data.MySqlClient;

namespace BookSystem
{
    public class DBHelper
    {
        public static MySqlConnection getCon()
        {
            string str = ConfigurationManager.ConnectionStrings["booksystem"].ConnectionString;
            return new MySqlConnection(str);
        }
    }
}
