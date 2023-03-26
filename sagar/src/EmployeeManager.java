//Micro service
package employee;

import java.rmi.*;
import java.util.*;

public interface EmployeeManager extends Remote{ //extends Remote (Marker)Interface

    int addEmployee(short id,String name,short age,int sal,short departmentId) throws RemoteException;
    List<company.EmpEntity> showEmployees(short departmentId) throws RemoteException;  //checked Exception 
    //empEntitiy is in company package 
}

// if in your service interface entity appers as a either parameter type or return type dont use annotations use orm.xml
//if you use annotations then we will have to write anather class EmployeeInfo then take the data from EmpEntity fill it into
