import org.junit.jupiter.api.Test;

import static codewars.PrimesInNumbers.factors;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimesInNumbersTest {


    @Test
    public void testPrimeDecompOne(){
        assertEquals("(2**2)(3**3)(5)(7)(11**2)(17)", factors(7775460));
        assertEquals("(7537)(123863)", factors(933555431));
    }
}
