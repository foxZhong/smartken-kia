using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class Categorie
    {
        private int id=0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private string title = "";

        public string Title
        {
            get { return title; }
            set { title = value; }
        }
    }
}
