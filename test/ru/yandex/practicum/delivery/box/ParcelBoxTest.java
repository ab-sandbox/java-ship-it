package ru.yandex.practicum.delivery.box;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.model.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    @Test
    void givenBoxWithEnoughCapacity_whenAddParcel_thenParcelAdded() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(20);

        StandardParcel parcel = new StandardParcel("Книга", 10, "Москва", 1);
        box.addParcel(parcel);

        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void givenBoxExceedingCapacity_whenAddParcel_thenParcelNotAdded() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        StandardParcel p1 = new StandardParcel("Книга", 8, "Москва", 1);
        StandardParcel p2 = new StandardParcel("Ноутбук", 5, "СПб", 1);

        box.addParcel(p1);
        box.addParcel(p2);

        assertEquals(1, box.getAllParcels().size());
    }

    @Test
    void givenBoxExactCapacity_whenAddParcel_thenParcelAdded() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        StandardParcel parcel = new StandardParcel("Книга", 10, "Москва", 1);
        box.addParcel(parcel);

        assertEquals(1, box.getAllParcels().size());
    }
}
