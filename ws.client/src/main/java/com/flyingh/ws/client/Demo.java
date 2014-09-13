package com.flyingh.ws.client;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.flyingh.ws.server.Book;
import com.flyingh.ws.server.Books;
import com.flyingh.ws.server.User;
import com.flyingh.ws.server.impl.HelloWorldService;

public class Demo {
	public static void main(String[] args) {
		final com.flyingh.ws.server.HelloWorldService helloWorldServiceImplPort = new HelloWorldService().getHelloWorldServiceImplPort();

		final Client client = ClientProxy.getClient(helloWorldServiceImplPort);
		// client.getInInterceptors().add(new LoggingInInterceptor());
		client.getOutInterceptors().add(new AbstractPhaseInterceptor<SoapMessage>(Phase.PREPARE_SEND) {

			@Override
			public void handleMessage(SoapMessage message) throws Fault {
				final List<Header> headers = message.getHeaders();
				final Document document = DOMUtils.createDocument();
				final Element authenticationElement = document.createElement("authentication");
				final Element usernameElement = document.createElement("username");
				final Element passwordElement = document.createElement("password");
				usernameElement.setTextContent("flyingh");
				passwordElement.setTextContent("password");
				authenticationElement.appendChild(usernameElement);
				authenticationElement.appendChild(passwordElement);
				headers.add(0, new Header(new QName("flyingh"), authenticationElement));
			}
		});
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
