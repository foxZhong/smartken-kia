using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class Genre
    {
        private int id=0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private int catId = 0;

        public int CatId
        {
            get { return catId; }
            set { catId = value; }
        }

        private string title = "";

        public string Title
        {
            get { return title; }
            set { title = value; }
        }
    }
}
