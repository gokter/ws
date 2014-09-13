package com.flyingh.ws.demo;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;

import com.flyingh.ws.server.impl.HelloWorldServiceImpl;

public class Demo {
	public static void main(String[] args) {
		final EndpointImpl endpointImpl = (EndpointImpl) Endpoint.publish("http://localhost:8899/flyingh", new HelloWorldServiceImpl());
		endpointImpl.getInInterceptors().add(new LoggingInInterceptor());
		endpointImpl.getOutInterceptors().add(new LoggingOutInterceptor());
	}
}
