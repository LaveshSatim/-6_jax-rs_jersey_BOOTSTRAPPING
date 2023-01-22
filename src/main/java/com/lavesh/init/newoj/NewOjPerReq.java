package com.lavesh.init.newoj;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/abc")
public class NewOjPerReq {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}")
	public String get(@PathParam("name") String name) {

		System.out.println("new obj per req : " + this.hashCode());
		return UUID.randomUUID().toString();
	}
}
