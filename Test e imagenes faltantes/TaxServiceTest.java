/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import service.TaxService;

/**
 *
 * @author Edith Ramirez
 */
public class TaxServiceTest {

    @Test
    void aplicarImpuestoOtroValor() {
        TaxService service = new TaxService();

        double resultado = service.applyTax(250);

        assertEquals(290, resultado); 
    }

    @Test
    void impuestoCero() {
        TaxService service = new TaxService();

        double resultado = service.applyTax(0);

        assertEquals(0, resultado);
    }
}
