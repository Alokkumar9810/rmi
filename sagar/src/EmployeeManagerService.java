package employee;

import company.*;
import java.rmi.*;
import java.util.*;
import javax.persistence.*;

//UnicastRemoteObject supports point to point communication with tcp (stream based communication)
public class EmployeeManagerService extends java.rmi.server.UnicastRemoteObject implements EmployeeManager {
    
    public EmployeeManagerService() throws RemoteException {
        super(6000); //export this object in TCP/IP port 6000 
    }

    public int addEmployee(short id,String name,short age,int sal,short departmentId) throws RemoteException{
        var emf = Persistence.createEntityManagerFactory("EmployeePU");
        var em = emf.createEntityManager(); // opens the database connection //does not implement autoclosable
        try{
            var tx = em.getTransaction(); //Starting Transaction
            tx.begin();
            //we are using JPA to store data in database insted of JDBC
            var ord = new EmpEntity();
            int eno = id;
            ord.setId(id);
            ord.setName(name);
            ord.setAge(age);
            ord.setSal(sal);
            ord.setDepartmentId(departmentId);
            em.persist(ord); //ord is created on the heap and we want to save it on database. persist will insert state of the entity into database
            tx.commit(); //save all changes  
            return eno;
        }
        finally{
            em.close();
        }
    }

    public List<EmpEntity> showEmployees(short departmentId) throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("EmployeePU");
        var em = emf.createEntityManager(); // opens the database connection //does not implement autoclosable
        try{
            //in jpql parameters are written as ?1,?2 etc(after ? numbers also given)
            //Parametarized JPQL
            var query = em.createQuery("select e from EmpEntity e WHERE e.departmentId = ?1", EmpEntity.class);
            query.setParameter(1,departmentId);
            return query.getResultList(); // will return list of EmpEntity 
        }
        finally{
            em.close();
        }
    }

    public static void main(String args[]) throws Exception{
        //Hosting service
        var naming = java.rmi.registry.LocateRegistry.createRegistry(6000); //on same port we are creating rmi service
        naming.bind("EmployeeManager",new EmployeeManagerService()); //we can use anything insted of EmployeeManager
    }
}