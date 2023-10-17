import java.io.*;
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private String login;
    private int age;
    private String[] hobbies;

    User(String name, String login, int age, String[] hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Пользователь: ").append(name);
        sb.append(" с логином: ").append(login).append(". ");
        sb.append("Его возраст: ").append(age).append(". ");
        sb.append("Все хобби: ");
        if (hobbies.length > 0) {
            for (int i = 0; i < hobbies.length; i++) {
                sb.append('\n').append(hobbies[i]).append('\n');
            }
        }
        return sb.toString();
    }
}
