import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Transport> transportList;
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "transport_data.txt";

    public static void main(String[] args) {
        transportList = FileService.loadFromFile(FILE_NAME);
        updateMaxId();

        boolean running = true;

        while (running) {
            showMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1 -> showAllTransport();
                case 2 -> addTransport();
                case 3 -> removeTransport();
                case 4 -> searchTransport();
                case 5 -> FileService.saveToFile(transportList, FILE_NAME);
                case 0 -> {
                    FileService.saveToFile(transportList, FILE_NAME);
                    running = false;
                    System.out.println("Выход из программы. Пока, шеф!");
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private static void updateMaxId() {
        int maxId = 0;
        for (Transport t : transportList) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        Transport.updateNextId(maxId);
    }

    private static void showMenu() {

        System.out.println("\n--- Автосалон ---");
        System.out.println("1. Показать все транспортные средства");
        System.out.println("2. Добавить транспорт");
        System.out.println("3. Удалить транспорт");
        System.out.println("4. Найти транспорт по бренду");
        System.out.println("5. Сохранить данные вручную");
        System.out.println("0. Выйти и сохранить");
    }

    private static void showAllTransport() {

        if (transportList.isEmpty()) {
            System.out.println("В списке пока нет транспорта.");

        } else {
            for (Transport t : transportList) {
                t.displayInfo();
                System.out.println("-----------------");

            }
        }


    }

    private static void addTransport() {
        int type = getIntInput("Выберите тип (1 - Машина, 2 - Мотоцикл): ");
        scanner.nextLine();

        System.out.print("Введите бренд: ");
        String brand = scanner.nextLine();

        System.out.print("Введите модель: ");
        String model = scanner.nextLine();

        System.out.print("Введите цвет: ");
        String color = scanner.nextLine();

        double engineVolume = getDoubleInput("Введите объем двигателя: ");
        double price = getDoubleInput("Введите цену: ");
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Введите класс машины (люкс, спорт и т.д.): ");
            String carClass = scanner.nextLine();
            transportList.add(new Car(brand, model, color, engineVolume, price, carClass));
            System.out.println("Транспорт успешно добавлен.");
        } else if (type == 2) {
            System.out.print("Введите тип мотоцикла (спорт, круизер и т.д.): ");
            String motorcycleType = scanner.nextLine();
            transportList.add(new Motorcycle(brand, model, color, engineVolume, price, motorcycleType));
            System.out.println("Транспорт успешно добавлен.");
        } else {
            System.out.println("Неверный тип транспорта.");
        }
    }


    private static void removeTransport() {
        showAllTransport();
        if (!transportList.isEmpty()) {
            int id = getIntInput("Введите ID транспорта для удаления: ");
            Iterator<Transport> iterator = transportList.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                Transport t = iterator.next();
                if (t.getId() == id) {
                    iterator.remove();
                    System.out.println("Транспорт успешно удалён.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Транспорт с таким ID не найден.");
            }
        }
    }

    private static void searchTransport() {
        scanner.nextLine();
        System.out.print("Введите бренд для поиска: ");
        String searchBrand = scanner.nextLine();

        boolean found = false;
        for (Transport t : transportList) {
            if (t.getBrand().toLowerCase().contains(searchBrand.toLowerCase())) {
                t.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Транспорт с таким брендом не найден.");
        }
    }
    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Введите целое число.");
                scanner.nextLine();
            }
        }
    }
    private static double getDoubleInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка вода. Введите число.");
                scanner.nextLine();
            }
        }
    }
}