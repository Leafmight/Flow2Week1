package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T11:03:45")
@StaticMetamodel(Customer2.class)
public class Customer2_ { 

    public static volatile SingularAttribute<Customer2, String> firstName;
    public static volatile SingularAttribute<Customer2, String> lastName;
    public static volatile ListAttribute<Customer2, String> hobbies;
    public static volatile SingularAttribute<Customer2, Integer> id;

}