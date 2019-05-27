import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {



    @Test
    void twoItemsWIthTheSamePriceAndNameShouldBeEqual() {
        assertEquals(new Item("n1", 1.1), new Item("n1", 1.1));
    }

    @Test
    void twoItemsWithDifferentNamesArentEquals() {
        assertNotEquals(new Item("n1", 1.1), new Item("n2", 1.1));
    }

    @Test
    void priceLowerThenZeroIsWrong() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Item("asd", -1)
        );
        assertEquals("Cena nie może być niższa lub równa 0", exception.getMessage());
        //Item it01 = new Item("asd", 1);
        //assertNotEquals(it01.getPrice(), 0);
    }
}