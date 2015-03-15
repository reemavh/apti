package com.ba.apti.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.ba.apti.core.BAResponse;


@Path("/receiver")
public class Receiver {
	
	@POST
	public Response registerTestResponse (@FormParam("jsonTestResponse") String jsonTestResponse) {
		boolean passed = false;
		if(new BAResponse().register(jsonTestResponse))
			passed = true;
		return Response.status(200).entity(Boolean.toString(passed)).build();
	}

}
