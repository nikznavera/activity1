package com.fimc.hello.resource;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/people")
public class PeopleResource {
	private ArrayList<PeopleRequest> peopleList = new ArrayList<>();
	PeopleResponse peopleResponse = new PeopleResponse();
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response peopleAdd(PeopleRequest request) {
		if((StringUtils.isEmpty(request.getBirthDate()) || 
					StringUtils.isEmpty(request.getFirstName()) ||
					StringUtils.isEmpty(request.getLastName()) ||
					!peopleResponse.isThisDateValid(request.getBirthDate(), "MM-dd-yyyy"))
				) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
		}
		
		peopleList.add(request);
		return Response.status(HttpServletResponse.SC_CREATED).entity(HttpServletResponse.SC_CREATED).build();
		
				
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response peopleList(PeopleRequest request) {
		
		return Response.ok().entity(peopleList).build();			
	}
}
