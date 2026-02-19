/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Edith Ramirez
 */
public class productTest {
    
    @Test
    void crearProducto() {
        Product p = new Product("P1", "Mouse", 100, 5);
        assertEquals(5, p.getStock());
    }
    
    @Test
    void reducirStock() {
        Product p = new Product("P1", "Mouse", 100, 5);
        p.reduceStock(2);
        assertEquals(3, p.getStock());
    }
    
    @Test
    void errorStockInsuficiente() {
        Product p = new Product("P1", "Mouse", 100, 1);
        assertThrows(IllegalStateException.class, () -> p.reduceStock(5));
    }
    
    @Test
    void errorCantidadInvalida() {
        Product p = new Product("P1", "Mouse", 100, 5);
        assertThrows(IllegalArgumentException.class, () -> p.reduceStock(0));
    }
}
