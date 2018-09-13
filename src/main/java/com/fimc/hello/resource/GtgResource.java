package com.fimc.hello.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/__gtg")
public class GtgResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response gtg() {
		final GtgResponse gtgResponse = 
				new GtgResponse ("local", GtgResponse.OK);
		return Response.ok(gtgResponse)
				.status(Response.Status.OK).build();
	}
}
