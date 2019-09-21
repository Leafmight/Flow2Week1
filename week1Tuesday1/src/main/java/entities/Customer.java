package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jacobfolkehildebrandt
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    //OneToOne Unidirectuinal relations:
    //@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    //@JoinColumn(name="Address_ID") 
    //Private Address address;
    
    //OneToMany Unidirectional:
    //@OneToMany(cascade = CascadeType.PERSIST)
    // JoinColumn(name="Customer_ID")
    
    //OneToMany Bidirectional:
    //@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    
    
    // 
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Address> addresses = new ArrayList();

    public void addAddress(Address address) {
        addresses.add(address);
        //  address.setCustomer(this);
    }

//    @OneToOne(cascade = CascadeType.PERSIST)
//    private Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//        this.address.setCustomer(this);
//    }
    public List<Address> getAddresses() {
        return addresses;
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
