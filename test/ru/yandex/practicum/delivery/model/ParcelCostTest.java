package ru.yandex.practicum.delivery.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelCostTest {

    @Test
    void givenStandardParcel_whenCalculateCost_thenCorrectValue() {
        StandardParcel parcel = new StandardParcel("Книга", 10, "Москва", 1);
        assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    void givenFragileParcel_whenCalculateCost_thenCorrectValue() {
        FragileParcel parcel = new FragileParcel("Ваза", 5, "СПб", 1);
        assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    void givenPerishableParcel_whenCalculateCost_thenCorrectValue() {
        PerishableParcel parcel = new PerishableParcel("Еда", 3, "Казань", 1, 5);
        assertEquals(9, parcel.calculateDeliveryCost());
    }
}
