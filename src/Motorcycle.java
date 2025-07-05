public class Motorcycle extends Transport{
    private String type;

    public Motorcycle(String brand, String model, String color, double engineCapacity , double price, String type) {
        super(brand, model, color, engineCapacity, price);
    this.type = type;
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Тип мотоцикла: " + type);
    }

}