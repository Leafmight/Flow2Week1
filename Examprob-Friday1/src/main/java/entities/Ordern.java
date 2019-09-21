/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author jacobfolkehildebrandt
 */
@Entity
public class Ordern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Customer customer;
    
    
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER )
    @JoinColumn(name = "Order_ID")
    private List<OrderLine> orderlines = new ArrayList();

    public Ordern() {
    }

    public Ordern(Customer customer) {
        this.customer = customer;
    }

    public Ordern(Customer customer, List<OrderLine> orderlines) {
        this.customer = customer;
        this.orderlines = orderlines;
    }

    public void setC(Customer customer) {
        this.customer = customer;
    }

    public void setOrderline(OrderLine orderline) {
        this.orderlines.add(orderline);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Customer getC() {
        return customer;
    }

    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    @Override
    public String toString() {
        return "Ordern{" + "id=" + id + ", customer=" + customer + ", orderlines=" + orderlines + '}';
    }

   

   

}
