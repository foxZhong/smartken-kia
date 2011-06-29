using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    
    public class User
    {
        private int id = 0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private string pass = "";

        public string Pass
        {
            get { return pass; }
            set { pass = value; }
        }

        private string code = "";

        public string Code
        {
            get { return code; }
            set { code = value; }
        }

        private string realName = "";

        public string RealName
        {
            get { return realName; }
            set { realName = value; }
        }

        private int roleId = 0;

        public int RoleId
        {
            get { return roleId; }
            set { roleId = value; }
        }

        private int active = 0;

        public int Active
        {
            get { return active; }
            set { active = value; }
        }
    }
}
