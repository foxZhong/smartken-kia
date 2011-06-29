using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class Sales
    {
        private int id = 0;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private string code = "";

        public string Code
        {
            get { return code; }
            set { code = value; }
        }

        private int uId = 0;

        public int UId
        {
            get { return uId; }
            set { uId = value; }
        }

        private int cardId = 0;

        public int CardId
        {
            get { return cardId; }
            set { cardId = value; }
        }

        private DateTime saleDate = new DateTime();

        public DateTime SaleDate
        {
            get { return saleDate; }
            set { saleDate = value; }
        }
    }
}
