package ru.yandex.practicum.delivery.app;

import ru.yandex.practicum.delivery.box.ParcelBox;
import ru.yandex.practicum.delivery.model.FragileParcel;
import ru.yandex.practicum.delivery.model.Parcel;
import ru.yandex.practicum.delivery.model.PerishableParcel;
import ru.yandex.practicum.delivery.model.StandardParcel;
import ru.yandex.practicum.delivery.tracking.Trackable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackables = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(100);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(100);

    public static void main(String[] args) {
        try {
            runApp();
        } finally {
            scanner.close();
        }
    }

    private static void runApp() {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            running = handleChoice(choice);
        }
    }

    private static boolean handleChoice(int choice) {
        switch (choice) {
            case 1:
                addParcel();
                return true;
            case 2:
                sendParcels();
                return true;
            case 3:
                calculateCosts();
                return true;
            case 4:
                reportStatuses();
                return true;
            case 5:
                showBoxContent();
                return true;
            case 0:
                return false;
            default:
                System.out.println("Неверный выбор.");
                return true;
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус трекинга");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Тип посылки: 1 — стандартная, 2 — хрупкая, 3 — скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Описание:");
        String description = scanner.nextLine();

        System.out.println("Вес:");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Адрес:");
        String address = scanner.nextLine();

        System.out.println("День отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                StandardParcel sp = new StandardParcel(description, weight, address, sendDay);
                allParcels.add(sp);
                standardBox.addParcel(sp);
                break;

            case 2:
                FragileParcel fp = new FragileParcel(description, weight, address, sendDay);
                allParcels.add(fp);
                fragileBox.addParcel(fp);
                trackables.add(fp);
                break;

            case 3:
                System.out.println("Срок хранения (дни):");
                int ttl = Integer.parseInt(scanner.nextLine());

                PerishableParcel pp = new PerishableParcel(description, weight, address, sendDay, ttl);
                allParcels.add(pp);
                perishableBox.addParcel(pp);
                break;

            default:
                System.out.println("Неверный тип.");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int total = 0;
        for (Parcel parcel : allParcels) {
            total += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки: " + total);
    }

    private static void reportStatuses() {
        System.out.println("Введите новое местоположение:");
        String location = scanner.nextLine();

        for (Trackable t : trackables) {
            t.reportStatus(location);
        }
    }

    private static void showBoxContent() {
        System.out.println("Выберите коробку: 1 — стандартная, 2 — хрупкая, 3 — скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());

        List<? extends Parcel> list;

        switch (choice) {
            case 1:
                list = standardBox.getAllParcels();
                break;
            case 2:
                list = fragileBox.getAllParcels();
                break;
            case 3:
                list = perishableBox.getAllParcels();
                break;
            default:
                System.out.println("Неверный выбор");
                return;
        }

        for (Parcel p : list) {
            System.out.println(p.getDescription());
        }
    }
}
