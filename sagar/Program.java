import employee.*;
import java.rmi.*;

class Program{
    public static void main(String args[]) throws Exception{
        //Naming.lookup is in java.rmi package is going to connect that rmi registry pass this name and get the end point and make the stub and give it to you 

        //stub is the proxy of an exported remote object
        var stub = (EmployeeManager)Naming.lookup("rmi://localhost:6000/EmployeeManager");
        short departmentId1 = Short.parseShort(args[0]);
        if(args.length > 2) {
            short id1 = Short.parseShort(args[1]);
            String name1 = args[2];
            short age1 = Short.parseShort(args[3]);
            int sal1 = Integer.parseInt(args[4]);
            // short departmentId1 = Short.parseShort(args[4]);
            try{
                //calling method on stub. stud will transfer the call to corrosponding method of the remote object 
                int empp = stub.addEmployee(id1,name1,age1,sal1,departmentId1);
                System.out.printf("New Employee Added : %d%n", empp);
            }
            catch(Exception e){
                //System.out.println("Failed to add Employee!" + e);
                System.out.println("Failed to add Employee!");
            }
        }
        else{
            var allemp= stub.showEmployees(departmentId1);
            for(var entry : allemp)
                System.out.printf("%-10d\t\t%-10s\t\t%-10d\t\t%-10d\t\t%-10d%n",entry.getId(),entry.getName(),entry.getAge(),entry.getSal(),entry.getDepartmentId());
        }


    }
}