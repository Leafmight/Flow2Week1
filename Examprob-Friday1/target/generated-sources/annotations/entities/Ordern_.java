package entities;

import entities.Customer;
import entities.OrderLine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-20T17:57:28")
@StaticMetamodel(Ordern.class)
public class Ordern_ { 

    public static volatile ListAttribute<Ordern, OrderLine> orderlines;
    public static volatile SingularAttribute<Ordern, Integer> id;
    public static volatile SingularAttribute<Ordern, Customer> customer;

}