package bookStoreWithSecurity.bookStoreSecure.service;

import bookStoreWithSecurity.bookStoreSecure.entity.Book;
import bookStoreWithSecurity.bookStoreSecure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void save(Book book) {

        bookRepository.save(book);
    }
    @Override
    public List<Book> getAllBook() {

        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {

        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {

        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> listAll(String keyword) {
        if(keyword != null){
            return bookRepository.findAll(keyword);
        }
        return bookRepository.findAll();
    }
}
