using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Globalization;
using System.IO;

namespace BookSystem
{
    public class SaleManage
    {
        public static List<Sales> getAllSales()
        {
            return null;
        }

        public static int addSale(Sales sale, List<SaleItems> items,float got)
        {
            int saleid = SaleService.addSale(sale);

            if (saleid != 0)
            {
                foreach (SaleItems item in items)
                {
                    item.SaleId = saleid;
                    SaleService.addSaleItem(item);
                }
            }
            SaleManage.Print(saleid, got);
            return 0;
        }

        public static List<SaleItems> getSaleItemsBySaleId(int sale_id)
        {
            return SaleService.getSaleItemsBySaleId(sale_id);
        }

        public static List<Sales> getSalesByUid(int sale_uid)
        {
            return SaleService.getSalesByUid(sale_uid);
        }

        public static float getTotalBySaleId(int sale_id)
        {
            return SaleService.getTotalBySaleId(sale_id);
        }

        public static List<Sales> getSalesByUidAndDateTime(int sale_uid, string sale_date)
        {
            return SaleService.getSalesByUidAndDateTime(sale_uid, sale_date);
        }

        public static string getSaleCode()
        {
            Random r = new Random();
            string d = DateTime.Now.ToString("yyyyMMddHH", DateTimeFormatInfo.InvariantInfo);
            string rancode = r.Next(1000).ToString();
            while(rancode.Length<4)
            {
                rancode="0"+rancode;
            }
            return d + rancode;
        }

        public static Sales checkIsSaleCodeExist(string code)
        {
            return SaleService.checkIsSaleCodeExist(code);
         }

        public static void Print(int saleid, float got)
        {
            float total = 0;
            int Count = 0;
            Sales sale = SaleService.getSaleById(saleid);
            string name = sale.SaleDate + " " + sale.Code + ".txt";
            string fileName = name.Replace(":", "-");
            FileStream fs = new FileStream(fileName, FileMode.Create);
            StreamWriter sw = new StreamWriter(fs);
            sw.WriteLine("***************************");
            sw.WriteLine("欢迎光临购书中心");
            sw.WriteLine("---------------------------");
            sw.WriteLine("书名\t数量*单价\t总价");
            foreach (SaleItems sitem in SaleService.getSaleItemsBySaleId(sale.Id))
            {
                sw.WriteLine("{0}\t{1}*{2}\t{3}元", BookService.getBookById(sitem.BookId).Name, sitem.Count, sitem.Price, sitem.Count * sitem.Price);
                total = total + (sitem.Count * sitem.Price);
                Count = Count + sitem.Count;
            }
            sw.WriteLine("总数量共：{0}本\t合  计：{1}元", Count, total);
            sw.WriteLine("实收金额：{0}元", got);
            sw.WriteLine("应找金额：{0}元", got - total);
            sw.WriteLine("---------------------------");
            sw.WriteLine("感谢惠顾，欢迎下次光临！");
            sw.WriteLine("***************************");
            sw.Close();
            fs.Close();
        }
    }
}
