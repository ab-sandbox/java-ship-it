package ru.yandex.practicum.delivery.model;

public abstract class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        String extra = getPackagingExtra();
        if (!extra.isEmpty()) {
            System.out.println(extra);
        }
        System.out.println("Посылка <" + description + "> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <" + description + "> доставлена по адресу " + deliveryAddress);
    }

    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    protected String getPackagingExtra() {
        return "";
    }

    protected abstract int getBaseCost();
}
