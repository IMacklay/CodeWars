
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class WalkInCityValidTest {

    @Test
    public void ValidTest() {
        assertTrue(WalkInCity.isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}), "Should return true");
        assertFalse(WalkInCity.isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}), "Should return false");
        assertFalse(WalkInCity.isValid(new char[]{'w'}), "Should return false");
        assertFalse(WalkInCity.isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}), "Should return false");
    }

}
