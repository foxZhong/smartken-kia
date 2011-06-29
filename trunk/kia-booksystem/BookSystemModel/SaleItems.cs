using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class SaleItems
    {
        private int id = 0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private float price = 0;

        public float Price
        {
            get { return price; }
            set { price = value; }
        }

        private int saleId = 0;

        public int SaleId
        {
            get { return saleId; }
            set { saleId = value; }
        }

        private int bookId = 0;

        public int BookId
        {
            get { return bookId; }
            set { bookId = value; }
        }

        private int count = 1;

        public int Count
        {
            get { return count; }
            set { count = value; }
        }
    }
}
