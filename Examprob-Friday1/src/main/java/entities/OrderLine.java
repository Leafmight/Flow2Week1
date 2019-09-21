/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jacobfolkehildebrandt
 */
@Entity
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ItemType itemType;
    
    @ManyToOne
    private Ordern order;

    public OrderLine() {
    }

    public OrderLine(int quantity, ItemType itemType) {
        this.quantity = quantity;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return "OrderLine{" + "id=" + id + ", quantity=" + quantity + ", itemType=" + itemType + '}';
    }

 

}
