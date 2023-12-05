package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneToOne {
    public static void main(String[] args) throws IOException {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Имя сотрудника: ");
            String name = reader.readLine();
            System.out.print("Фамилия сотрудника: ");
            String surname = reader.readLine();
            System.out.print("Отдел: ");
            String department = reader.readLine();
            System.out.print("Зарплата: ");
            int salary;
            try {
                salary = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Неправильный ввод, попробуйте в этот раз ввести реальное число");
                salary = Integer.parseInt(reader.readLine());
            }
            System.out.print("Город: ");
            String city = reader.readLine();
            System.out.print("номер телефона: ");
            String phoneNumber = reader.readLine();
            System.out.print("Почта: ");
            String mail = reader.readLine();
            session = sessionFactory.getCurrentSession();
            Employee employee = new Employee(name, surname, department, salary);
            Detail detail = new Detail(city, phoneNumber, mail);
            employee.setDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction();
            session.save(employee);


            int id = employee.getId();
            Employee employee1 = session.get(Employee.class, id);
            session.getTransaction().commit();
            System.out.println("Сотрудник был сохранён: " + employee1);
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
