package com.flyingh.ws.server;

import java.util.List;

import javax.jws.WebService;

import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

@WebService
public interface HelloWorldService {
	String say(String name);

	List<Book> getBooksByUser(User user);
}
