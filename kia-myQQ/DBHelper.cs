using System;
using System.Collections.Generic;
using System.Text;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace myQQ
{
    public class DBHelper
    {
        string serverName, databaseName;
        string str;
        public SqlConnection con;
        //public static string str = "data source=.;initial catalog=MyQQ;trusted_connection=true";
        //public static string str = "data source=SMARTKEN-PC\\KEN;initial catalog=MyQQ;trusted_connection=true";
        //public static string str = "data source=KENPC-946BCC315\\SQLEXPRESS;initial catalog=MyQQ;trusted_connection=true";
        //public static SqlConnection con=new SqlConnection(str);

        public DBHelper()
        {
            serverName = ".\\SQLEXPRESS";
            databaseName = "MyQQ";
            str = string.Format("data source={0};initial catalog={1};trusted_connection=true", serverName, databaseName);
            con = new SqlConnection(str);
        }

        public void setConnection(string constr)
        {
            //serverName = sName;
            //databaseName = dName;
            //str = string.Format("data source={0};initial catalog={1};trusted_connection=true", serverName, databaseName);
            con = new SqlConnection(constr);
        }

        public void testConnetion(string constr)
        {
            try
            {
                con = new SqlConnection(constr);
                con.Open();
                MessageBox.Show("连接数据库成功");
            }
            catch (Exception ex)
            { MessageBox.Show("连接数据失败");
            Console.WriteLine(ex.StackTrace);
        }
            finally
            {con.Close();}
        }
    }

    #region 属性

    #endregion
    #region 构造函数

    #endregion
    #region 自定义方法

    #endregion

    #region 控件事件方法

    #endregion
}
