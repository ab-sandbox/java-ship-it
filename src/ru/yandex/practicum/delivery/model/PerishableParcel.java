package ru.yandex.practicum.delivery.model;

public class PerishableParcel extends Parcel {

    private static final int BASE_DELIVERY_COST = 3;

    private final int timeToLive;

    public PerishableParcel(
            String description,
            int weight,
            String deliveryAddress,
            int sendDay,
            int timeToLive
    ) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    protected int getBaseCost() {
        return BASE_DELIVERY_COST;
    }

    @Override
    public String toString() {
        return super.toString() + ", срок хранения=" + timeToLive;
    }
}
