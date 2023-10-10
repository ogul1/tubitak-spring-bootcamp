package com.ogul.bootcamp.repository;

import com.ogul.bootcamp.entity.Book;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);

    List<Book> findByAgeGreaterThanEqualOrderByAgeAsc(Long age);

    Page<Book> findByPublishDateAfter(LocalDateTime publishDate, Pageable pageable);

    List<Book> findByTitleContaining(String phrase);

    List<Book> findByAuthorAndAgeGreaterThan(String author, Long age);

    long countByAuthor(String author);

    boolean existsByAuthor(String author);

    @Query(value = "select * from books where title = ?1", nativeQuery = true)
    Book findByTitleQuery(String title);

    @Query("select b from Book b where b.age >= :age")
    Page<Book> findByAgeGreaterThanEqualOrderByAgeAscQuery(Long age, Pageable pageable);

    @Query("select b from Book b where b.publishDate > :publishDate")
    Page<Book> findByPublishDateAfterQuery(LocalDateTime publishDate, Pageable pageable);

    @Query("select b from Book b where b.title like %:phrase%")
    List<Book> findByTitleContainingQuery(String phrase);

    @Query("select b from Book b where b.author = :author and b.age > :age")
    List<Book> findByAuthorAndAgeGreaterThanQuery(String author, Long age);

    @Query("select count(*) from Book b where b.author = ?1")
    long countByAuthorQuery(String author);

}
