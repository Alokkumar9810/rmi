package company;

import javax.persistence.*;

// @Entity
// @Table(name="department")
public class DeptEntity implements java.io.Serializable {

    private short id;
    private String name;
    private String location;

    // @Id
    // @Column(name="id") //optional  we can apply this annotations on fields also
    public short getId(){   return id; }
    public void setId(short value){    id = value;    }

    // @Column(name="name") //optional
    public String getName() { return name; }
    public void setName(String value){ name = value; }

    public String getLocation(){ return location; }
    public void setLocation(String value){ location = value; }


}
