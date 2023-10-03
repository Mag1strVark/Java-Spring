package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public void getBook(Book book){
        System.out.println("Мы взяли книгу из UniLibrary: " + book.getName() + "Автор " + book.getAuthor() + "Год " + book.getYearOfPublication());
        System.out.println("-------------------------------");
    }

    public void addBook(String name, String author, int year){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setYearOfPublication(year);

        System.out.println("Мы добавили книгу в UniLibrary" + book.getName() + "Автор " + book.getAuthor() + "Год " + book.getYearOfPublication());
        System.out.println("-------------------------------");
    }

    public void returnBook(Book book){
        System.out.println("Мы вернули книгу в UniLibrary" + book.getName());
        System.out.println("-------------------------------");
    }
}
