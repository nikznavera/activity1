package com.fimc.hello.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Path("/calc")
public class CalculatorResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response calc(CalculatorRequest request) {
		CalculatorResponse calculatorResponse = new CalculatorResponse();
		if((StringUtils.isEmpty(request.getOperator()) || 
					StringUtils.isEmpty(request.getNumber1()) ||
					StringUtils.isEmpty(request.getNumber2()) ) || 
						(!request.getOperator().equals("+")&&
						 !request.getOperator().equals("-")&&
						 !request.getOperator().equals("*")&&
						 !request.getOperator().equals("/")) || 
						(request.getOperator().equals("/") && request.getNumber2() == 0)
				) {
			return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(HttpServletResponse.SC_BAD_REQUEST).build();
		}
		
		calculatorResponse = calculatorResponse.calculate(request);
		return Response.ok().entity(calculatorResponse).build();
		
				
	}
}
