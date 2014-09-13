package com.flyingh.ws.demo;

import java.util.List;

import javax.xml.ws.Endpoint;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.common.util.CollectionUtils;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.flyingh.ws.server.impl.HelloWorldServiceImpl;

public class Demo {
	public static void main(String[] args) {
		final EndpointImpl endpointImpl = (EndpointImpl) Endpoint.publish("http://localhost:8899/flyingh", new HelloWorldServiceImpl());
		endpointImpl.getInInterceptors().add(new LoggingInInterceptor());
		endpointImpl.getInInterceptors().add(new AbstractPhaseInterceptor<SoapMessage>(Phase.PRE_INVOKE) {

			@Override
			public void handleMessage(SoapMessage message) throws Fault {
				System.out.println("-----------------------------------------------" + message);
				final List<Header> headers = message.getHeaders();
				if (CollectionUtils.isEmpty(headers)) {
					throw new Fault(new IllegalArgumentException("No headers"));
				}
				for (final Header header : headers) {
					final Element element = (Element) header.getObject();
					final NodeList usernames = element.getElementsByTagName("username");
					final NodeList passwords = element.getElementsByTagName("password");
					if (usernames == null || passwords == null) {
						continue;
					}
					if (usernames.getLength() != 1 || passwords.getLength() != 1) {
						throw new Fault(new IllegalArgumentException("only needs a username and password"));
					}
					final String username = usernames.item(0).getTextContent();
					final String password = passwords.item(0).getTextContent();
					if ("flyingh".equals(username) && "password".equals(password)) {
						return;
					}
					throw new Fault(new IllegalArgumentException("username or password is wrong"));
				}
				throw new Fault(new IllegalArgumentException("no username or password"));
			}
		});
	}
}
