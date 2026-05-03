package ru.yandex.practicum.delivery.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {

    @Test
    void givenParcelWithinTTL_whenCheckExpired_thenFalse() {
        PerishableParcel parcel = new PerishableParcel("Еда", 3, "Казань", 1, 5);
        assertFalse(parcel.isExpired(5));
    }

    @Test
    void givenParcelBeyondTTL_whenCheckExpired_thenTrue() {
        PerishableParcel parcel = new PerishableParcel("Еда", 3, "Казань", 1, 5);
        assertTrue(parcel.isExpired(7));
    }

    @Test
    void givenParcelAtBoundary_whenCheckExpired_thenFalse() {
        PerishableParcel parcel = new PerishableParcel("Еда", 3, "Казань", 1, 5);
        assertFalse(parcel.isExpired(6));
    }
}
