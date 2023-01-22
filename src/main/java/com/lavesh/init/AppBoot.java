package com.lavesh.init;

import java.util.HashSet;
import java.util.Set;

import com.lavesh.init.newoj.NewOjPerReq;
import com.lavesh.init.singleton.Singletobj;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

//@ApplicationPath("/api")
public class AppBoot extends Application {

	Set<Object> singletons;
	Set<Class<?>> newperreq;

	public AppBoot() {
		singletons = new HashSet<Object>();
		newperreq = new HashSet<Class<?>>();

		// add in single to set to get same obj n no. of times
		singletons.add(new Singletobj());

		// add .class for req per new obj

		newperreq.add(NewOjPerReq.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return newperreq;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
