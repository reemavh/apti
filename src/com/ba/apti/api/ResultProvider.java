package com.ba.apti.api;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.ba.apti.comm.MySQLClient;

@Path("/results")
public class ResultProvider {
		static final String token = "_BanjaraApt1tud3";
		@POST
		public Response returnRows (@FormParam("token")String requestToken) {
			if(!requestToken.equals(token))
				return Response.status(200).entity("auth failed").build();
			return Response.status(200).entity(MySQLClient.getConnector().getLatestEntries(50)).build();
		}
		

}
