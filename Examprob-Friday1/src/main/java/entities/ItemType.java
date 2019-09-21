/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jacobfolkehildebrandt
 */
@Entity
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    private String name, description;
    @OneToMany(mappedBy = "itemType", fetch = FetchType.EAGER )
    private List<OrderLine> orderLines;

    public ItemType() {
    }

    public ItemType(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    
    public ItemType(int price, String name, String description, List<OrderLine> orderLines) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.orderLines = orderLines;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ItemType{" + "id=" + id + ", price=" + price + ", name=" + name + ", description=" + description +  '}';
    }

    
  
    
}
