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
import javax.persistence.Persistence;

/**
 *
 * @author jacobfolkehildebrandt
 */
public class facadeTester {

    private static EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
    private static Facade facade = new Facade();

    public static void main(String[] args) {
        Customer c1 = new Customer("name1", "email1");
        Customer c2 = new Customer("name2", "email2");

        ItemType it1 = new ItemType(25, "Æg", "Frilands");
        ItemType it2 = new ItemType(50, "Mælk", "Øko");
        ItemType it3 = new ItemType(100, "Gær", "Øko");

        Ordern o1 = new Ordern(c1);
        Ordern o2 = new Ordern(c2);

        OrderLine ol1 = new OrderLine(2, it1);
        OrderLine ol2 = new OrderLine(2, it2);
        OrderLine ol3 = new OrderLine(3, it1);
        OrderLine ol4 = new OrderLine(3, it2);

        facade.createCustomer(c1);

        facade.createCustomer(c2);
        System.out.println("++++++++++++++++" + facade.findCustomer(c1.getId()));
        System.out.println("----------------" + facade.getAllCustomers());
        // facade.createItemType(it1.getPrice(), it1.getName(), it1.getDescription());
        // facade.createItemType(it2.getPrice(), it2.getName(), it2.getDescription());
        facade.createItemType(it3.getPrice(), it3.getName(), it3.getDescription());

        facade.addOrder(c1, o1);
        facade.addOrder(c2, o2);

        facade.addOrderLine(o1, ol1);
        facade.addOrderLine(o1, ol2);
        facade.addOrderLine(o2, ol3);
        facade.addOrderLine(o2, ol4);
        Customer c = facade.findCName(c1.getName());

        List<Ordern> orderlist = facade.getAllOrders(c.getId());
        int total_price = 0;

        for (int i = 0; i < orderlist.size(); i++) {
            System.out.println("_______________________" + orderlist.get(i));

        int price = 0, qty = 0;
            price = orderlist.get(i).getOrderlines().get(i).getItemType().getPrice();
            qty = orderlist.get(i).getOrderlines().get(i).getQuantity();
            total_price += price * qty;
        }
            System.out.println(total_price);
    }

}
