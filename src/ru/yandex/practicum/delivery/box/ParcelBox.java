package ru.yandex.practicum.delivery.box;

import ru.yandex.practicum.delivery.model.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final List<T> parcels = new ArrayList<>();
    private final int maxWeight;

    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        int parcelWeight = parcel.getWeight();

        if (currentWeight + parcelWeight > maxWeight) {
            System.out.println("Превышен максимальный вес коробки!");
            return;
        }

        parcels.add(parcel);
        currentWeight += parcelWeight;
    }

    public List<T> getAllParcels() {
        return new ArrayList<>(parcels);
    }
}
