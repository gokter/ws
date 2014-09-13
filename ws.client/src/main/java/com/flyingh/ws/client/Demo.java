package com.flyingh.ws.client;

import com.flyingh.ws.server.Book;
import com.flyingh.ws.server.Books;
import com.flyingh.ws.server.User;
import com.flyingh.ws.server.impl.HelloWorldService;

public class Demo {
	public static void main(String[] args) {
		final com.flyingh.ws.server.HelloWorldService helloWorldServiceImplPort = new HelloWorldService().getHelloWorldServiceImplPort();
		System.out.println(helloWorldServiceImplPort.say("Flyingh"));
		final User user = new User();
		user.setUsername("b");
		user.setPassword("bpass");
		for (final Book book : helloWorldServiceImplPort.getBooksByUser(user)) {
			System.out.println(book.getId() + "--->" + book.getName() + "--->" + book.getPrice());
		}
		System.out.println("*************************************");
		final Books books = helloWorldServiceImplPort.getAllBooks();
		for (final Book book : books.getBooks()) {
			System.out.println(book.getId() + "--->" + book.getName() + "--->" + book.getPrice());
		}
	}
}
