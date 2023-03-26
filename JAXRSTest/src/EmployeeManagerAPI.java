package modern.web.app;

import company.*;
import employee.*;
import java.rmi.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/employees")
public class EmployeeManagerAPI {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response readOrders(@PathParam("id") short departmentId1) {
		try{
			var remote = (EmployeeManager)Naming.lookup("rmi://localhost:6000/EmployeeManager");
			var orders = remote.showEmployees(departmentId1);
			if(orders.size() == 0)
				return Response.status(404).build();
			return Response.ok(orders).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(EmpEntity info) {
		try{
			var remote = (EmployeeManager)Naming.lookup("rmi://localhost:6000/EmployeeManager");
			short eNo =(short)remote.addEmployee(info.getId(), info.getName(), info.getAge(),info.getSal(),info.getDepartmentId());
			info.setId(eNo);
			return Response.ok(info).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
}

