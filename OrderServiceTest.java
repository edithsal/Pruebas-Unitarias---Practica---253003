/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.Order;
import domain.OrderItem;
import domain.Product;
import external.IInventoryService;
import external.IPaymentGateway;
import org.junit.jupiter.api.Test;
import repository.IOrderRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import service.DiscountService;
import service.OrderService;
import service.TaxService;

/**
 *
 * @author Edith Ramirez
 */
class OrderServiceTest {

    @Test
    void ordenVacia() {

        Order order = new Order("O1");

        OrderService service = new OrderService(
                mock(IOrderRepository.class),
                mock(IPaymentGateway.class),
                mock(IInventoryService.class),
                mock(DiscountService.class),
                mock(TaxService.class)
        );

        assertThrows(IllegalStateException.class,
                () -> service.checkout(order));
    }

    @Test
    void pagoFalla() {

        Order order = new Order("O1");
        Product p = new Product("P1", "Mouse", 100, 5);
        order.addItem(new OrderItem(p, 1));

        IPaymentGateway pago = mock(IPaymentGateway.class);
        when(pago.processPayment(anyDouble())).thenReturn(false);

        OrderService service = new OrderService(
                mock(IOrderRepository.class),
                pago,
                mock(IInventoryService.class),
                mock(DiscountService.class),
                mock(TaxService.class)
        );

        assertFalse(service.checkout(order));
    }

    @Test
    void pagoExitoso() {

        Order order = new Order("O1");
        Product p = new Product("P1", "Teclado", 200, 5);
        order.addItem(new OrderItem(p, 1));

        IPaymentGateway pago = mock(IPaymentGateway.class);
        when(pago.processPayment(anyDouble())).thenReturn(true);

        OrderService service = new OrderService(
                mock(IOrderRepository.class),
                pago,
                mock(IInventoryService.class),
                mock(DiscountService.class),
                mock(TaxService.class)
        );

        assertTrue(service.checkout(order));
    }

}
