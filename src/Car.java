public class Car extends Transport{
    private String carClass;

    public Car(String brand, String model,String color, double engineCapacity, double price, String carClass) {
        super(brand, model, color, engineCapacity, price);
        this.carClass =  carClass;

    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Класс машины: " + carClass);
    }
}
