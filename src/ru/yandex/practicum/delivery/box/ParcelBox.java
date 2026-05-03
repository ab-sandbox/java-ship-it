package ru.yandex.practicum.delivery.box;

import ru.yandex.practicum.delivery.model.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final List<T> parcels = new ArrayList<>();
    private final int maxWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (getCurrentWeight() + parcel.getWeight() > maxWeight) {
            System.out.println("Превышен максимальный вес коробки!");
            return;
        }
        parcels.add(parcel);
    }

    public List<T> getAllParcels() {
        return parcels;
    }

    private int getCurrentWeight() {
        int sum = 0;
        for (T p : parcels) {
            sum += p.getWeight();
        }
        return sum;
    }
}
