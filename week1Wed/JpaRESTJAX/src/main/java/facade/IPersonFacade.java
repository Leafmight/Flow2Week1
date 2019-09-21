/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Person;
import exception.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author jacobfolkehildebrandt
 */

public interface IPersonFacade {
  public Person addPerson(String fName, String lName, String phone);  
  public Person deletePerson(Long id) throws PersonNotFoundException;  
  public Person getPerson(Long id) throws PersonNotFoundException;  
  public List<Person> getAllPersons();  
  public Person editPerson(Person p) throws PersonNotFoundException;  
  public Long getPersonCount();
}

