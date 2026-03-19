/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import service.DiscountService;

/**
 *
 * @author Edith Ramirez
 */
public class DiscountServiceTest {
    
    
     @Test
    void sinDescuento() {
        DiscountService service = new DiscountService();
        assertEquals(4000, service.applyDiscount(4000));
    }

    @Test
    void descuento10() {
        DiscountService service = new DiscountService();
        assertEquals(5400, service.applyDiscount(6000));
    }

    @Test
    void descuento15() {
        DiscountService service = new DiscountService();
        assertEquals(10200, service.applyDiscount(12000));
    }
}