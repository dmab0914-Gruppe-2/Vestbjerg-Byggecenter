package CtrLayer;

import ModelLayer.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas on 22-04-2015.
 */
public class SalesControllerTest {

    SalesController salesController;
    ProductController productController;
    @Before
    public void setUp() throws Exception {
        productController = new ProductController();
        salesController = new SalesController();
        productController.createTestProducts();
    }

    @Test
    public void testAddItem() throws Exception {
        salesController.makeNewSale(1);
        salesController.addItem("1234");
        Product p = productController.findProduct("1234");
        assertEquals("Really nice pink shows for the lady", p.getDescription());
        assertEquals(30, p.getSalesPrice(), 0);

        salesController.addItem("1235");
        Product pp = productController.findProduct("1235");
        assertEquals(300+30, p.getSalesPrice()+pp.getSalesPrice(), 0);

        salesController.closeSale();


    }

    @Test
    public void testGetTotal() throws Exception{
        salesController.makeNewSale(1);
        salesController.addItem("1234");
        salesController.addItem("1234");
        salesController.addItem("1235");
        assertEquals(360.0, salesController.getTotal(), 0);
        salesController.closeSale();
    }

    @Test
    public void testOrder() throws Exception{
        salesController.makeNewSale(1);
        salesController.addItem("1234");
        assertTrue(salesController.makePaymentPhone("88888888"));
        salesController.closeSale();
    }

    @Test
    public void testQuantitySale() throws Exception{
        salesController.makeNewSale(1);
        Product p = productController.findProduct("1234");
        assertEquals(1, p.getQuantity());
        salesController.addItem("1234");
        salesController.makePaymentPhone("88888888");
        assertEquals(0, p.getQuantity());

    }
}