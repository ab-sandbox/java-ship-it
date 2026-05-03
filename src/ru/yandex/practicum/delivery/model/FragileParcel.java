package ru.yandex.practicum.delivery.model;

import ru.yandex.practicum.delivery.tracking.Trackable;

public class FragileParcel extends Parcel implements Trackable {

    private static final int BASE_DELIVERY_COST = 4;

    public FragileParcel(
            String description,
            int weight,
            String deliveryAddress,
            int sendDay
    ) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected String getPackagingExtra() {
        return "Посылка <" + description + "> обернута в защитную пленку";
    }

    @Override
    protected int getBaseCost() {
        return BASE_DELIVERY_COST;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <" + description +
                "> изменила местоположение на " + newLocation);
    }
}
