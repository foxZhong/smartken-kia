using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class Rolers
    {
        private int id = 0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private string name = "";

        public string Name
        {
            get { return name; }
            set { name = value; }
        }
    }
}
