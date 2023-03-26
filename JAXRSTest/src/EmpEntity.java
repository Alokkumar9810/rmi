package company;

import java.util.*;

public class EmpEntity implements java.io.Serializable {

	private short id;

	private String name;

	private short age;

	private int sal;

	private short departmentId;

	public short getId() { return id; }
	public void setId(short value) { id = value; }

	public String getName() { return name; }
	public void setName(String value) { name = value; }

	public short getAge() { return age; }
	public void setAge(short value) { age = value; }

	public int getSal() { return sal; }
	public void setSal(int value) { sal = value; }

	public short getDepartmentId() { return departmentId; }
	public void setDepartmentId(short value) { departmentId = value; }

}

