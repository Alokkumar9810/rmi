package employee;

import java.rmi.*;
import java.util.*;

public interface EmployeeManager extends Remote{ //extends Remote (MarkUp)Interface

    int addEmployee(short id,String name,short age,int sal,short departmentId) throws RemoteException;
    List<company.EmpEntity> showEmployees(short departmentId) throws RemoteException;  //checked Exception 
    //empEntitiy is in company package 
}
