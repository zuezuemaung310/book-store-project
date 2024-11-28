package bookStoreWithSecurity.bookStoreSecure.repository;



import bookStoreWithSecurity.bookStoreSecure.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
    @Query("SELECT b FROM Book b WHERE LOWER(b.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(b.author) LIKE LOWER(CONCAT('%', :keyword, '%'))")
   List<Book> findAll(String keyword);

    //Page<Book> findAll(String keyword,Pageable pageable);





}
