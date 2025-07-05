import java.io.Serializable;

public class Transport implements Serializable {
    private static int nextId = 1;

    protected int id;
    protected String brand;
    protected String model;
    protected String color;
    protected double engineCapacity;
    protected double price;

    public Transport(String brand, String model, String color, double engineCapacity, double price) {
        this.id = nextId++;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.price = price;
    }

    public static void updateNextId(int maxId) {
        nextId = maxId +1;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void displayInfo() {
        System.out.println("  id = " + id + '\n' +
                "  брэнд: " + brand + '\n' +
                "  модель:" + model + '\n' +
                "  цвет: " + color + '\n' +
                "  обьем двигателья: " + engineCapacity + '\n' +
                "  цена: " + price +
                "тг");
    }
}
