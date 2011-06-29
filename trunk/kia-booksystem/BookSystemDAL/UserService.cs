using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;

namespace BookSystem
{
    public class UserService
    {

        #region 检查用户登陆，成功条件为员工号与密码正确，并且用户状态为0，返回一个User对象；失败返回null
        public static User checkLogin(string code, string pass)
        {
            User u = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from users where u_code=@code and u_pass=@pass and u_active=1";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    cmd.Parameters.AddWithValue("@code", code);
                    cmd.Parameters.AddWithValue("@pass", pass);
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        u = new User();
                        u.Id = int.Parse(reader["u_id"].ToString());
                        u.Code = reader["u_code"].ToString();
                        //u.Pass = reader["u_pass"].ToString();
                        u.RealName = reader["u_realname"].ToString();
                        u.RoleId = int.Parse(reader["u_roleid"].ToString());
                        u.Active = int.Parse(reader["u_active"].ToString());
                    }
                    con.Close();
                    con.Dispose();
                }
            }
            return u;
        }
        #endregion

        #region 根据卡号和姓名查询员工
        public static User getUserByCodeAndName(string code, string name)
        {
            User u = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from users where u_code=@code and u_realname=@name";
                using (MySqlCommand cmd = new MySqlCommand(str, con))
                {
                    cmd.Parameters.AddWithValue("@code", code);
                    cmd.Parameters.AddWithValue("@name", name);
                    con.Open();
                    MySqlDataReader reader = cmd.ExecuteReader();
                    if (reader.Read())
                    {
                        u = new User();
                        u.Id = int.Parse(reader["u_id"].ToString());
                        u.Code = reader["u_code"].ToString();
                        //u.Pass = reader["u_pass"].ToString();
                        u.RealName = reader["u_realname"].ToString();
                        u.RoleId = int.Parse(reader["u_roleid"].ToString());
                        u.Active = int.Parse(reader["u_active"].ToString());
                    }
                    con.Close();
                    con.Dispose();
                }
            }
            return u;
        }
        #endregion

        #region 查找所有用户
        public static List<User> getAllUsers()
        {
            List<User> users = new List<User>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from users";
                MySqlCommand cmd = new MySqlCommand(str, con);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        User user = new User();
                        user.Id = int.Parse(reader["u_id"].ToString());
                        user.Code = reader["u_code"].ToString();
                        //user.Pass = reader["u_pass"].ToString();
                        user.RealName = reader["u_realname"].ToString();
                        user.RoleId = int.Parse(reader["u_roleid"].ToString());
                        user.Active = int.Parse(reader["u_active"].ToString());
                        users.Add(user);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return users;
        }
        #endregion

        #region 根据用户ID查找一个用户的所有信息
        public static User getUserById(int id)
        {
            User user = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from users where u_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@id", id);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        user = new User();
                        user.Id = int.Parse(reader["u_id"].ToString());
                        user.Code = reader["u_code"].ToString();
                        //user.Pass = reader["u_pass"].ToString();
                        user.RealName = reader["u_realname"].ToString();
                        user.RoleId = int.Parse(reader["u_roleid"].ToString());
                        user.Active = int.Parse(reader["u_active"].ToString());
                    }
                }
                con.Close();
                con.Dispose();
            }
            return user;
        }
        #endregion

        #region 增加一个用户
        public static int addUser(User user)
        {
            int result = 0;

            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "insert into users (u_code,u_pass,u_realname,u_roleid,u_active) values(@code,@pass,@realnam,@roleid,@active)";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@code", user.Code);
                cmd.Parameters.AddWithValue("@pass", user.Pass);
                cmd.Parameters.AddWithValue("@realnam", user.RealName);
                cmd.Parameters.AddWithValue("@roleid", user.RoleId);
                cmd.Parameters.AddWithValue("@active", user.Active);

                conn.Open();
                result = (int)cmd.ExecuteNonQuery();
                conn.Close();
            }
            return result;
        }
        #endregion

        #region 根据用户卡号查找一个用户的所有信息
        public static User getUserByCode(string code)
        {
            User user = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from users where u_code=@code";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@code", code);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        user = new User();
                        user.Id = int.Parse(reader["u_id"].ToString());
                        user.Code = reader["u_code"].ToString();
                        //user.Pass = reader["u_pass"].ToString();
                        user.RealName = reader["u_realname"].ToString();
                        user.RoleId = int.Parse(reader["u_roleid"].ToString());
                        user.Active = int.Parse(reader["u_active"].ToString());
                    }
                }
                con.Close();
                con.Dispose();
            }
            return user;
        }
        #endregion

        #region 根据用户姓名查找一个用户的所有信息
        public static List<User> getUserByName(string realname)
        {
            List<User> users = new List<User>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from users where u_realname=@realname";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@realname", realname);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        User user = new User();
                        user.Id = int.Parse(reader["u_id"].ToString());
                        user.Code = reader["u_code"].ToString();
                        //user.Pass = reader["u_pass"].ToString();
                        user.RealName = reader["u_realname"].ToString();
                        user.RoleId = int.Parse(reader["u_roleid"].ToString());
                        user.Active = int.Parse(reader["u_active"].ToString());
                        users.Add(user);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return users;
        }
        #endregion

        #region 修改用户资料
        public static int updateUser(User user)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "update users set u_pass=@pass,u_realname=@realname,u_roleid=@roleid,u_active=@active where u_code=@code";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@code", user.Code);
                cmd.Parameters.AddWithValue("@pass", user.Pass);
                cmd.Parameters.AddWithValue("@realname", user.RealName);
                cmd.Parameters.AddWithValue("@roleid", user.RoleId);
                cmd.Parameters.AddWithValue("@active", user.Active);

                conn.Open();
                result = int.Parse(cmd.ExecuteNonQuery().ToString());
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 删除一用户
        public static int deleteUserById(int u_id)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "delete from users where u_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@id", u_id);
                conn.Open();
                result = (int)cmd.ExecuteNonQuery();
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 查找所有职位
        public static List<Rolers> getAllRolers()
        {
            List<Rolers> rolers = new List<Rolers>();
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from rolers";
                MySqlCommand cmd = new MySqlCommand(str, con);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Rolers roler = new Rolers();
                        roler.Id = int.Parse(reader["role_id"].ToString());
                        roler.Name = reader["role_name"].ToString();
                        rolers.Add(roler);
                    }
                }
                con.Close();
                con.Dispose();
            }
            return rolers;
        }
        #endregion

        #region 根据职位ID查找一个职位
        public static Rolers getRolerByID(int id)
        {
            Rolers role = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select * from rolers where role_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@id", id);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        role = new Rolers();
                        role.Id = int.Parse(reader["role_id"].ToString());
                        role.Name = reader["role_name"].ToString();
                    }
                }
                con.Close();
                con.Dispose();
            }
            return role;
        }
        #endregion

        #region 增加一个职位
        public static int addRolers(Rolers rolers)
        {
            int result = 0;

            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "insert into rolers (role_name) values(@name)";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@name", rolers.Name);

                conn.Open();
                result = (int)cmd.ExecuteNonQuery();
                conn.Close();
            }
            return result;
        }
        #endregion

        #region 删除一职位
        public static int deleteRolersById(int id)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "delete from rolers where role_id=@id";
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

        #region 修改职位资料
        public static int updateRolers(string name, int id)
        {
            int result = 0;
            using (MySqlConnection conn = DBHelper.getCon())
            {
                string str = "update rolers set role_name=@name where role_id=@id";
                MySqlCommand cmd = new MySqlCommand(str, conn);
                cmd.Parameters.AddWithValue("@name", name);
                cmd.Parameters.AddWithValue("@id", id);
                conn.Open();
                result = Convert.ToInt32(cmd.ExecuteNonQuery());
                conn.Close();
                conn.Dispose();
            }
            return result;
        }
        #endregion

        #region 根据用户卡号查找一个用户的密码
        public static string getPassByCode(string Code)
        {
            string pass = null;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select u_pass from users where u_code=@code";
                MySqlCommand cmd = new MySqlCommand(str, con);
                cmd.Parameters.AddWithValue("@code", Code);
                con.Open();
                using (MySqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        pass = reader["u_pass"].ToString();

                    }
                }
                con.Close();
                con.Dispose();
            }
            return pass;
        }
        #endregion

        #region 查询最后一次插入的员工ID
        public static int getLastUserId()
        {
            int id=0;
            using (MySqlConnection con = DBHelper.getCon())
            {
                string str = "select u_id from users order by u_id desc";
                MySqlCommand cmd = new MySqlCommand(str, con);
                con.Open();
                id = int.Parse(cmd.ExecuteScalar().ToString());
                con.Close();
            }
            return id;
        }
        #endregion

    }
}