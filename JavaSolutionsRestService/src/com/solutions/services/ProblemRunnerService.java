package com.solutions.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.solutions.problems.BaseProblemSolutions;
import com.solutions.utils.Utilities;


@Path("/runner")
public class ProblemRunnerService {
	
		// Return the list of Available problems to the user in the browser
		  @GET
		  @Path("problemlist")
		  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
		  public List<ProblemsInfo> getAvailableProblemsLIst() {
			  List<ProblemsInfo> pInfo = new ArrayList<ProblemsInfo>();
			  pInfo.addAll(ProblemsInfoDao.instance.getSolutionMap().values());
 			    return pInfo;
		  }
		  
		  

		  // returns the number of Problem solutions
		  // Use http://localhost:8080/JavaSolutionsRestService/solutions/runner/count
		  // to get the total number of records
		  @GET
		  @Path("problemcount")
		  @Produces(MediaType.TEXT_PLAIN)
		  public String getCount() {
				int count = ProblemsInfoDao.instance.getSolutionMap().size();
				return String.valueOf(count);
		  }
}
