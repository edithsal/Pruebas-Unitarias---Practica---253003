/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import domain.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import repository.InMemoryOrderRepository;

/**
 *
 * @author Edith Ramirez
 */
public class InMemoryOrderRepositoryTest {

    @Test
    void guardarOrden() {
        InMemoryOrderRepository repo = new InMemoryOrderRepository();

        Order order = new Order("O1");
        repo.save(order);

        assertEquals(1, repo.count());
    }

    @Test
    void guardarMultiplesOrdenes() {
        InMemoryOrderRepository repo = new InMemoryOrderRepository();

        repo.save(new Order("O1"));
        repo.save(new Order("O2"));
        repo.save(new Order("O3"));

        assertEquals(3, repo.count());
    }

    @Test
    void repositorioVacio() {
        InMemoryOrderRepository repo = new InMemoryOrderRepository();

        assertEquals(0, repo.count());
    }
}