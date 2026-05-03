package ru.yandex.practicum.delivery.model;

public class StandardParcel extends Parcel {

    private static final int BASE_DELIVERY_COST = 2;

    public StandardParcel(
            String description,
            int weight,
            String deliveryAddress,
            int sendDay
    ) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return BASE_DELIVERY_COST;
    }
}
