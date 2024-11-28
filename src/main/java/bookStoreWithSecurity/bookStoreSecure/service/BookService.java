package bookStoreWithSecurity.bookStoreSecure.service;

import bookStoreWithSecurity.bookStoreSecure.entity.Book;

import java.util.List;

public interface BookService {
    void save(Book book);

    List<Book> getAllBook();

    Book getBookById(int id);

    void deleteById(int id);

    List<Book> listAll(String keyword);
}
