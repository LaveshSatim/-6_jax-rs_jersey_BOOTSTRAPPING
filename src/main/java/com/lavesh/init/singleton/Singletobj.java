package com.lavesh.init.singleton;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("{name}/verify")
public class Singletobj {

	@GET
	@Produces(MediaType.TEXT_PLAIN)

	public String get(@PathParam("name") String name) {

		System.out.println(" singleton : " + this.hashCode());

		return "" + UUID.randomUUID().toString();
	}
}
