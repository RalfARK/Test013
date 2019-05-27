import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    @Test
    void addToBasket() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Basket().addToBasket(new Item("asd", 1), -1)
                //() -> new Basket().addToBasket(new Item("asd", 1), 0)
        );

        assertEquals("Ilość nie może być mniejsza lub równa 0", exception.getMessage());
    }

    @Test
    void removeFromBasket() {

        Basket basketTest1 = new Basket();
        Item it01 = new Item ("asd", 1);
        Item it02 = new Item ("asd2", 2);
        basketTest1.addToBasket(it01);
        assertAll(
                () -> assertThrows(
                        IllegalArgumentException.class, () -> new Basket().removeFromBasket(new Item("asd", 1), -1)
                ),
                () -> assertThrows(
                        IllegalArgumentException.class, () -> new Basket().removeFromBasket(new Item("asd", 1), 0)
                )




        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> basketTest1.removeFromBasket(it01, 10));
        assertEquals("Nie można usunąć z koszyka więcej niż w nim jest", exception.getMessage());

        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> basketTest1.removeFromBasket(it02, 1));
        assertEquals("Nie ma takiego artykułu w koszyku", exception2.getMessage());
    }

    @Test
    void removeFromBasket1() {
        Basket b1 = new Basket();
        Item it1 = new Item("asd", 1);
        Item it2 = new Item("asd2", 1);
        b1.addToBasket(it1);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> b1.removeFromBasket(it2));

        assertEquals("Nie ma takiego artykułu w koszyku", exception.getMessage());
    }

}