/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.Order;
import domain.OrderItem;
import domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Edith Ramirez
 */
public class orderTest {
    
    @Test
    void crearOrden() {
        Order order = new Order("O1");
        assertNotNull(order);
    }

    @Test
    void calcularTotal() {
        Product p = new Product("P1", "Teclado", 50, 10);
        OrderItem item = new OrderItem(p, 2); 

        Order order = new Order("O1");
        order.addItem(item);

        assertEquals(100, order.calculateTotal());
    }

    @Test
    void marcarPagada() {
        Order order = new Order("O1");
        order.markAsPaid();
        assertTrue(order.isPaid());
    }
}
