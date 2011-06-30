using System;
using System.Collections.Generic;
using System.Text;
using System.Data.SqlClient;

namespace MyQQ
{
    class DBHelp
    {
        public static string constr="data source=SMARTKEN-PC\\KEN;initial catalog=MyQQ;trusted_connection=true";
        public static SqlConnection conn=new SqlConnection(constr);
    }
}
