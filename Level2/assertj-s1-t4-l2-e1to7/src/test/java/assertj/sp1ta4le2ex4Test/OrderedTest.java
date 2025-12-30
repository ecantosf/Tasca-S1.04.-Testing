package assertj.sp1ta4le2ex4Test;

import assertj.sp1ta4le2ex4.Ordered;
import assertj.sp1ta4le2ex4.Person;
import assertj.sp1ta4le2ex4.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class OrderedTest {
    private Ordered<Object> orderedList;
    private Person person1;
    private Person person2;
    private Product product1;
    private Product product2;
    private String stringItem;
    private Integer numberItem;
    private Person notAddedPerson;

    @BeforeEach
    void setUp() {
        orderedList = new Ordered<>();

        person1 = new Person("Alice", 30);
        person2 = new Person("Bob", 25);
        product1 = new Product("Laptop", 999.99);
        product2 = new Product("Phone", 499.99);
        stringItem = "Test String";
        numberItem = 42;

        notAddedPerson = new Person("Charlie", 35);

        orderedList.addItem(person1);
        orderedList.addItem(product1);
        orderedList.addItem(stringItem);
        orderedList.addItem(person2);
        orderedList.addItem(product2);
        orderedList.addItem(numberItem);

        orderedList.addItem(person1);
    }

    @Test
    @DisplayName("Order Of Items According To Insertion")
    void testOrderOfItemsAccordingToInsertion() {
        List<Object> expectedOrder = Arrays.asList(
                person1,
                product1,
                stringItem,
                person2,
                product2,
                numberItem,
                person1
        );

        List<Object> actualItems = orderedList.getItems();

        assertEquals(expectedOrder, actualItems,
                "The items should be in the exact order they were inserted");

        assertAll("Verify each position in the list",
                () -> assertEquals(person1, actualItems.get(0),
                        "First item should be person1"),
                () -> assertEquals(product1, actualItems.get(1),
                        "Second item should be product1"),
                () -> assertEquals(stringItem, actualItems.get(2),
                        "Third item should be stringItem"),
                () -> assertEquals(person2, actualItems.get(3),
                        "Fourth item should be person2"),
                () -> assertEquals(product2, actualItems.get(4),
                        "Fifth item should be product2"),
                () -> assertEquals(numberItem, actualItems.get(5),
                        "Sixth item should be numberItem"),
                () -> assertEquals(person1, actualItems.get(6),
                        "Seventh item should be person1 (duplicate)")
        );
    }

    @Test
    @DisplayName("Contains Items In Any Order")
    void testListContainsItemsInAnyOrder() {
        List<Object> expectedItems = Arrays.asList(
                person1,
                product1,
                stringItem,
                person2,
                product2,
                numberItem,
                person1
        );

        List<Object> actualItems = orderedList.getItems();

        assertAll("Verify all items are present (order independent)",
                () -> assertTrue(actualItems.contains(person1),
                        "List should contain person1"),
                () -> assertTrue(actualItems.contains(person2),
                        "List should contain person2"),
                () -> assertTrue(actualItems.contains(product1),
                        "List should contain product1"),
                () -> assertTrue(actualItems.contains(product2),
                        "List should contain product2"),
                () -> assertTrue(actualItems.contains(stringItem),
                        "List should contain stringItem"),
                () -> assertTrue(actualItems.contains(numberItem),
                        "List should contain numberItem")
        );

        assertEquals(expectedItems.size(), actualItems.size(),
                "List should have the correct number of items");

        assertTrue(actualItems.containsAll(expectedItems) &&
                        expectedItems.containsAll(actualItems),
                "Both lists should contain the same elements");
    }

    @Test
    @DisplayName("One Object Added Only Once")
    void testOneObjectAddedOnlyOnce() {
        int countPerson2 = 0;
        for (Object item : orderedList.getItems()) {
            if (item.equals(person2)) {
                countPerson2++;
            }
        }

        assertEquals(1, countPerson2,
                "person2 should appear exactly once in the list");

        assertEquals(1, orderedList.getItemCount(person2),
                "person2 should have a count of 1");

        assertEquals(2, orderedList.getItemCount(person1),
                "person1 should appear twice in the list");

        assertEquals(1, orderedList.getItemCount(product1),
                "product1 should appear once");
        assertEquals(1, orderedList.getItemCount(product2),
                "product2 should appear once");
        assertEquals(1, orderedList.getItemCount(stringItem),
                "stringItem should appear once");
        assertEquals(1, orderedList.getItemCount(numberItem),
                "numberItem should appear once");
    }

    @Test
    @DisplayName("List Does Not Contain Non Added Item(")
    void testListDoesNotContainNonAddedItem() {
        assertFalse(orderedList.containsItem(notAddedPerson),
                "The list should NOT contain notAddedPerson");

        assertEquals(0, orderedList.getItemCount(notAddedPerson),
                "notAddedPerson should have a count of 0");

        Person anotherPerson = new Person("David", 40);
        assertFalse(orderedList.containsItem(anotherPerson),
                "The list should NOT contain anotherPerson");
    }
}