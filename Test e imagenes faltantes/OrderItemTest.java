/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.OrderItem;
import domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Edith Ramirez
 */
public class OrderItemTest {
    
    
    @Test
    void crearOrderItemValido() {
        Product p = new Product("P1", "Mouse", 100, 5);
        OrderItem item = new OrderItem(p, 2);

        assertNotNull(item);
        assertEquals(2, item.getQuantity());
        assertEquals(p, item.getProduct());
    }

    
    @Test
    void productoNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(null, 2);
        });
    }

    
    @Test
    void cantidadCero() {
        Product p = new Product("P1", "Teclado", 200, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(p, 0);
        });
    }

    
    @Test
    void cantidadNegativa() {
        Product p = new Product("P1", "Monitor", 300, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            new OrderItem(p, -1);
        });
    }

    
    @Test
    void calcularSubtotal() {
        Product p = new Product("P1", "Laptop", 1000, 10);
        OrderItem item = new OrderItem(p, 3);

        assertEquals(3000, item.getSubtotal());
    }
}