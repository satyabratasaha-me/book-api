package com.codewitme.librairie.repository;

import com.codewitme.librairie.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface BookRepository extends MongoRepository<Book,String> {
}
