using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class UserManage
    {
        public static List<User> getAllUsers()
        {
            return UserService.getAllUsers();
        }

        public static User checkLogin(string code, string pass)
        {
            return UserService.checkLogin(code, pass);
        }

        public static User getUserByCode(string code)
        {
            return UserService.getUserByCode(code);
        }

        public static List<User> getUserByName(string realname)
        {
            return UserService.getUserByName(realname);
        }

        public static List<Rolers> getAllRolers()
        {
            return UserService.getAllRolers();
        }

        public static int addUser(User user)
        {
            return UserService.addUser(user);
        }

        public static Rolers getRolerByID(int id)
        {
            return UserService.getRolerByID(id);
        }

        public static int deleteUserById(int u_id)
        {
            return UserService.deleteUserById(u_id);
        }

        public static int addRolers(Rolers rolers)
        {
            return UserService.addRolers(rolers);
        }

        public static int deleteRolersById(int id)
        {
            return UserService.deleteRolersById(id);
        }

        public static int updateRolers(string name, int id)
        {
            return UserService.updateRolers(name, id);
        }

        public static int updateUser(User user)
        {
            return UserService.updateUser(user);
        }

        public static string getPassByCode(string Code)
        {
            return UserService.getPassByCode(Code);
        }

        public static User getUserByCodeAndName(string code, string name)
        {
            return UserService.getUserByCodeAndName(code, name);
        }

        public static User getUserById(int id)
        {
            return UserService.getUserById(id);
        }

        public static int getLastUserId()
        {
            return UserService.getLastUserId();
        }
    }
}
