package com.BooksApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BooksApi.model.BookModel;
import com.BooksApi.repo.BookRepository;
import com.BooksApi.service.BookService;

@Service(value="bookService")
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void addBookService(BookModel bookModel) {
		
//		bookModel=new BookModel();
//		bookModel.setName(bookModel.getName());
//		bookModel.setAuthor(bookModel.getAuthor());
//		bookModel.setDescription(bookModel.getDescription());
//		bookModel.setPrice(bookModel.getPrice());
//		bookModel.setCategory(bookModel.getCategory());
//		bookModel.setRating(bookModel.getRating());
		bookRepository.save(bookModel);
		
	}

	@Override
	public List<BookModel> getBooksList() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

//	@Override
//	public BookModel getBooksById(int id) {
//		// TODO Auto-generated method stub
//		return bookRepository.findById(id).get();
//	}

	@Override
	public List<String> getCategoryList() {
		
		return bookRepository.categoryList();
	}

//	@Override
//	public BookModel getBooksById(long id) {
//		// TODO Auto-generated method stub
//		return bookRepository.findById(id).get();
//	}

	@Override
	public List<BookModel> listAll(String keyword) {
	
		if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
	}

	@Override
	public BookModel getBooksById(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).get();
	}

	@Override
	public BookModel findByBookName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
