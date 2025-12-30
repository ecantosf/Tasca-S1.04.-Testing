package assertj.sp1ta4le2ex5Test;

import assertj.sp1ta4le2ex5.MyMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMapTest {

    private MyMap myMap;

    @BeforeEach
    public void setUp() {
        myMap = new MyMap();
    }

    @Test
    @DisplayName("Add Entry And Contains Key")
    public void testAddEntryAndContainsKey() {
        myMap.addEntry("clau1", 100);

        assertTrue(myMap.containsKey("clau1"), "The map should contain 'key1'");
    }

    @Test
    @DisplayName("Contains Key With Non Existent Key")
    public void testContainsKeyWithNonExistentKey() {
        myMap.addEntry("clau1", 100);

        assertFalse(myMap.containsKey("clauInexistent"), "The map should NOT contain 'nonExistentKey'");
    }

    @Test
    @DisplayName("Add Multiple Entries")
    public void testAddMultipleEntries() {
        myMap.addEntry("clau1", 100);
        myMap.addEntry("clau2", 200);
        myMap.addEntry("clau3", 300);

        assertTrue(myMap.containsKey("clau1"));
        assertTrue(myMap.containsKey("clau2"));
        assertTrue(myMap.containsKey("clau3"));

    }
}