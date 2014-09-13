package com.flyingh.ws.demo;

import javax.xml.ws.Endpoint;

import com.flyingh.ws.server.impl.HelloWorldServiceImpl;

public class Demo {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8899/flyingh", new HelloWorldServiceImpl());
	}
}
