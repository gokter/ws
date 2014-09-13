package com.flyingh.ws.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;

import com.flyingh.ws.server.Book;
import com.flyingh.ws.server.Books;
import com.flyingh.ws.server.User;
import com.flyingh.ws.server.impl.HelloWorldService;

public class Demo {
	public static void main(String[] args) {
		final com.flyingh.ws.server.HelloWorldService helloWorldServiceImplPort = new HelloWorldService().getHelloWorldServiceImplPort();

		final Client client = ClientProxy.getClient(helloWorldServiceImplPort);
		client.getInInterceptors().add(new LoggingInInterceptor());
		client.getOutInterceptors().add(new LoggingOutInterceptor());

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
