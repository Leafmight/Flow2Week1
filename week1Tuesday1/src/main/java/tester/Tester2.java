/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entities.Customer2;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class Tester2 {
    public static void main(String[] args) {
        Customer2 c2 = new Customer2("Jacob", "Hildebrandt");
        c2.addHobby("Golf");
        c2.addHobby("Drinking");
        c2.addHobby("Gaming");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(c2);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        
        em = emf.createEntityManager();
        Customer2 found = em.find(Customer2.class, c2.getId());
        System.out.println("Hobbies --> " + found.getHobbies());
    }
}
