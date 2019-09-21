/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Person;
import exception.PersonNotFoundException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    public PersonFacade() {
    }

    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person addPerson(String fName, String lName, String phone) {
        EntityManager em = emf.createEntityManager();
        Person pers = new Person(fName, lName, phone);
        pers.setCreated(new Date());
        try {
            em.getTransaction().begin();
            em.persist(pers);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
        return pers;
    }

    @Override
    public Person deletePerson(Long id) throws PersonNotFoundException {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        if(p == null){
            throw new PersonNotFoundException("No person with provided id found");
        }
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();

        }
        return p;
    }

    @Override
    public Person getPerson(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Person p = em.find(Person.class, id);
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query
                    = em.createQuery("SELECT p FROM Person p", Person.class);

            return query.getResultList();
        } finally {
            em.close();

        }
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        p.setCreated(em.find(Person.class, p.getId()).getCreated());
        p.setLastEdited(new Date());
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }

    @Override
    public Long getPersonCount() {

        EntityManager em = emf.createEntityManager();
        try {
            long personCount = (long) em.createQuery("SELECT COUNT(n) FROM Person n").getSingleResult();
            return personCount;
        } finally {
            em.close();
        }

    }

}
