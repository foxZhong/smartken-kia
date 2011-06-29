using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class Book
    {
        private int id=0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private string isbn="";

       public string Isbn
      {
       get { return isbn; }
       set { isbn = value; }
        }

        private string name = "";

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        private string author = "";

        public string Author
        {
            get { return author; }
            set { author = value; }
        }

        private string desc = "";

        public string Desc
        {
            get { return desc; }
            set { desc = value; }
        }

        private int pubId = 0;

        public int PubId
        {
            get { return pubId; }
            set { pubId = value; }
        }

      
        private DateTime pubDate ;

        public DateTime PubDate
        {
            get { return pubDate; }
            set { pubDate = value; }
        }

        private float price = 0;

        public float Price
        {
            get { return price; }
            set { price = value; }
        }

        private int stock = 0;

        public int Stock
        {
            get { return stock; }
            set { stock = value; }
        }

        private int genId = 0;

        public int GenId
        {
            get { return genId; }
            set { genId = value; }
        }

        private DateTime stockDate=new DateTime();

        public DateTime StockDate
        {
            get { return stockDate; }
            set { stockDate = value; }
        }

        private int statue = 0;

        public int Statue
        {
            get { return statue; }
            set { statue = value; }
        }
    }
}
