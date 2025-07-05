import java.io.*;
import java.util.ArrayList;

public class FileService {
    public static void saveToFile(ArrayList<Transport> transportList, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(transportList);
            System.out.println("Данные успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла.");
        }
    }

    public static ArrayList<Transport> loadFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<Transport>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл не найден или пуст, создаем новый список.");
            return new ArrayList<>();
        }
    }
}