using BookSystem;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;

namespace Test
{
    
    
    /// <summary>
    ///这是 SaleServiceTest 的测试类，旨在
    ///包含所有 SaleServiceTest 单元测试
    ///</summary>
    [TestClass()]
    public class SaleServiceTest
    {


        private TestContext testContextInstance;

        /// <summary>
        ///获取或设置测试上下文，上下文提供
        ///有关当前测试运行及其功能的信息。
        ///</summary>
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }

        #region 附加测试属性
        // 
        //编写测试时，还可使用以下属性:
        //
        //使用 ClassInitialize 在运行类中的第一个测试前先运行代码
        //[ClassInitialize()]
        //public static void MyClassInitialize(TestContext testContext)
        //{
        //}
        //
        //使用 ClassCleanup 在运行完类中的所有测试后再运行代码
        //[ClassCleanup()]
        //public static void MyClassCleanup()
        //{
        //}
        //
        //使用 TestInitialize 在运行每个测试前先运行代码
        //[TestInitialize()]
        //public void MyTestInitialize()
        //{
        //}
        //
        //使用 TestCleanup 在运行完每个测试后运行代码
        //[TestCleanup()]
        //public void MyTestCleanup()
        //{
        //}
        //
        #endregion


        /// <summary>
        ///addSale 的测试
        ///</summary>
        [TestMethod()]
        public void addSaleTest()
        {
            Sales s = new Sales(); // TODO: 初始化为适当的值
            s.CardId = 1;
            s.Code = "adfad";
            s.UId = 2;
            int expected = 5; // TODO: 初始化为适当的值
            int actual;
            actual = SaleService.addSale(s);
            Assert.AreEqual(expected, actual);
          //  Assert.Inconclusive("验证此测试方法的正确性。");
        }

        /// <summary>
        ///addSaleItem 的测试
        ///</summary>
        [TestMethod()]
        public void addSaleItemTest()
        {
            SaleItems s = new SaleItems(); // TODO: 初始化为适当的值
            s.Price = 10;
            s.SaleId = 1;
            s.BookId = 1;
            s.Count = 3;
            int expected = 1; // TODO: 初始化为适当的值
            int actual;
            actual = SaleService.addSaleItem(s);
            Assert.AreEqual(expected, actual);
          //  Assert.Inconclusive("验证此测试方法的正确性。");
        }

        /// <summary>
        ///getSaleItemsByBookId 的测试
        ///</summary>
        [TestMethod()]
        public void getSaleItemsByBookIdTest()
        {
            int book_id = 1; // TODO: 初始化为适当的值
            List<SaleItems> expected = null; // TODO: 初始化为适当的值
            List<SaleItems> actual;
            actual = SaleService.getSaleItemsByBookId(book_id);
            Assert.AreNotEqual(expected, actual);
           //Assert.Inconclusive("验证此测试方法的正确性。");
        }

        /// <summary>
        ///getSaleItemsByBookId 的测试
        ///</summary>
        [TestMethod()]
        public void getSaleItemsByBookIdTest1()
        {
            int book_id = 0; // TODO: 初始化为适当的值
            List<SaleItems> expected = null; // TODO: 初始化为适当的值
            List<SaleItems> actual;
            actual = SaleService.getSaleItemsByBookId(book_id);
            Assert.AreEqual(expected, actual);
            Assert.Inconclusive("验证此测试方法的正确性。");
        }
    }
}
