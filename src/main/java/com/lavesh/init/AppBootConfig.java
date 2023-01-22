package com.lavesh.init;

import org.glassfish.jersey.server.ResourceConfig;

import com.lavesh.init.newoj.NewOjPerReq;
import com.lavesh.init.singleton.Singletobj;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class AppBootConfig extends ResourceConfig {

	public AppBootConfig() {
		super.register(NewOjPerReq.class);
		register(new Singletobj());
	}
}
