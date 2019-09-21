/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entities.Address;
import entities.Customer;
import facade.CustomerFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sun.font.CFont;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class Tester {
    public static CustomerFacade cf = new CustomerFacade();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        Customer c = new Customer("Jacob", "Hildebrandt");
        Address address1 = new Address("vej3","Byvej");
        Address address2 = new Address("vej2","Byvej");
        Customer c2 = new Customer("Vincent", "Tran");
        c2.addAddress(address1);
        c.addAddress(address1);
        c.addAddress(address2);
   //     c.setAddress(address);
        Customer c3 = new Customer("Renz","Slack");
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.persist(c2);
            
          //  em.persist(address);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
      //  Address found = em.find(Address.class, address.getId());
    //    System.out.println("Address --> " + found.getCustomer().getAddress().getCity());
    
    }
}
