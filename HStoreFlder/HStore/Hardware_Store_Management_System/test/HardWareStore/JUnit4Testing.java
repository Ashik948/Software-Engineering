package HardWareStore;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mahmud
 */
public class JUnit4Testing {

    String Count = "SELECT COUNT(*) FROM orders";
    String Sum = "SELECT SUM(PPrice) FROM orders";

    @Test
    public void testQuery1() {

        assertEquals("5", TestingDBConnectivity.StatusQuery(Count, "COUNT(*)"));
    }

    @Test
    public void testQuery2() {

        assertEquals("78500", TestingDBConnectivity.StatusQuery(Sum, "SUM(PPrice)"));
    }
}
