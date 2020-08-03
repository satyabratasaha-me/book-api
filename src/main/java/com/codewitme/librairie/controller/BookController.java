package com.codewitme.librairie.controller;


import com.codewitme.librairie.model.Book;
import com.codewitme.librairie.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController {


    @Autowired()
    BookRepository bookRepository;

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        System.out.print("Hello");
        return  ResponseEntity.ok().body(books);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") String id){
        Book book = bookRepository.findById(id).get();
        return ResponseEntity.ok().body(book);
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBookById(@PathVariable(value = "id") String id){
        bookRepository.deleteById(id);
        Map<String,String> message = new HashMap<>();
        message.put("Message",String.format("The book with id %s is deleted successfully",id));
        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/books")
    public ResponseEntity<Object> addbook(@RequestBody Book book){

        bookRepository.save(book);
        Map<String,String> message = new HashMap<>();
        message.put("Message",String.format("The book with id %s is saved successfully",book.getId()));
        return ResponseEntity.ok().body(message);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateBookById(@PathVariable(value = "id") String id, @RequestBody Book details){

        Book book = bookRepository.findById(id).get();
        book.setName(details.getName());
        book.setAuthor(details.getAuthor());
        bookRepository.save(book);
        Map<String,String> message = new HashMap<>();
        message.put("Message",String.format("The book with id %s is updated successfully",book.getId()));
        return ResponseEntity.ok().body(message);
    }
}
