package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        Book book = context.getBean("book", Book.class);

        uniLibrary.getBook(book);
        uniLibrary.returnBook(book);
        uniLibrary.addBook("Рамштайн и его подвиги", "Власов И.А.", 1978);

        context.close();
    }
}
