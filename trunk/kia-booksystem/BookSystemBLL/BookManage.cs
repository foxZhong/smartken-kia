using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace BookSystem
{
    public class BookManage
    {
        public static List<Categorie> getAllCategories()
        {
            return GenreService.getAllCategories();
        }

        public static List<Genre> getGenresByCatId(int catid)
        {
            return GenreService.getGenresByCatId(catid);
        }

        public static int addBook(Book book)
        {
            return BookService.addBook(book);
        }

        public static List<Publisher> getAllPublishers()
        {
            return PublisherService.getAllPublishers();
        }

        public static List<Book> getBooksByGenId(int genid)
        {
            return BookService.getBookByCatId(genid);
        }

        public static Book getBookById(int b_id)
        {
            return BookService.getBookById(b_id);
        }


        public static Categorie getCategorieById(int catid)
        {
            return GenreService.getCategoriesById(catid);
        }

        public static Genre getGenreById(int genid)
        {
            return GenreService.getGenresById(genid);
        }

        public static Publisher getPublisherById(int pubid)
        {
            return PublisherService.getPublisherById(pubid);
        }

        public static Book getBookByISBN(string isbn)
        {
            return BookService.getBookByISBN(isbn);
        }

        public static int deleteBook(int b_id)
        {
            return BookService.deleteBook(b_id);
        }

        public static int updateBook(Book b)
        {
            return BookService.updateBook(b);
        }

        public static List<Book> getFirstBook()
        {
            return BookService.getFirstBook();
        }

    }
    
}
