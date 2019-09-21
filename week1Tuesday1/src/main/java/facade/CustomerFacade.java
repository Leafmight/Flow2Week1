/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


/**
 *
 * @author jacobfolkehildebrandt
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    public CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Customer getCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer c = em.find(Customer.class, id);
            return c;
        } finally {
            em.close();
        }
    }

    public List<Customer> getCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT c FROM Customer c", Customer.class);

            return query.getResultList();
        } finally {
            em.close();

        }
    }

    public Customer addCustomer(Customer cust) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
        return cust;
    }

    public Customer deleteCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        Customer c;
        try {
            c = getCustomer(id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
        return c;
    }

    public Customer editCustomer(Customer cust) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.refresh(cust);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
        return cust;
    }

}
