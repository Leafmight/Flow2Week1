/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Customer;
import entities.ItemType;
import entities.OrderLine;
import entities.Ordern;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class Facade {

    private static Facade instance;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public static Facade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new Facade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Customer createCustomer(Customer cust) {
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

    public Customer findCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer c = em.find(Customer.class, id);
            return c;
        } finally {
            em.close();
        }
    }
    public Customer findCName(String name){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT c FROM Customer c WHERE c.name=:customername", Customer.class);

            return query.setParameter("customername", name).getSingleResult();
        } finally {
            em.close();

        }
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT c FROM Customer c", Customer.class);

            return query.getResultList();
        } finally {
            em.close();

        }
    }

    public ItemType createItemType(int price, String name, String description) {
        EntityManager em = emf.createEntityManager();
        ItemType it = new ItemType(price, name, description);
        try {
            em.getTransaction().begin();
            em.persist(it);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
        return it;
    }

    public ItemType findItemType(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            ItemType c = em.find(ItemType.class, id);
            return c;
        } finally {
            em.close();
        }
    }

    public void addOrder(Customer cust, Ordern order) {
        EntityManager em = emf.createEntityManager();

        Customer c = em.find(Customer.class, cust.getId());
        c.setOrder(order);
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();

        }

    }

    public void addOrderLine(Ordern o, OrderLine ol) {
        EntityManager em = emf.createEntityManager();
        Ordern foundOrder = em.find(Ordern.class, o.getId());
        foundOrder.setOrderline(ol);
        try {
            em.getTransaction().begin();
            em.persist(foundOrder);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public List<Ordern> getAllOrders(int id) {
        EntityManager em = emf.createEntityManager();

        try {

            return (List<Ordern>) em.createQuery("SELECT o FROM Ordern o WHERE o.customer.id=:customerid")
                    .setParameter("customerid", id).getResultList();

        } finally {
            em.close();

        }
    }

}
