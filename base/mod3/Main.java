import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите имя: ");
            String name = reader.readLine();

            System.out.print("Введите логин: ");
            String login = reader.readLine();

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(reader.readLine());

            System.out.print("Введите хобби через запятую: ");
            String hobbiesInput = reader.readLine();
            String[] hobbies = hobbiesInput.split(",");

            User user = new User(name, login, age, hobbies);

            FileOutputStream fileOut = new FileOutputStream("user.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();

            FileInputStream fileIn = new FileInputStream("user.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            User deserializedUser = (User) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("\nUser details:");
            System.out.println(deserializedUser.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
