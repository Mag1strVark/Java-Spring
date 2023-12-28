package org.example.app.services;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class BookRepository<T> implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    @Override
    public List<Book> retreiveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        logger.info("store new book: " + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retreiveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                logger.info("remove book completed: " + book);
                return repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public void deleteByAuthorRegex(String authorPattern) {
        Pattern pattern = Pattern.compile(authorPattern);
        Iterator<Book> iterator = repo.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            Matcher matcher = pattern.matcher(book.getAuthor());
            if (matcher.matches()) {
                logger.info("remove book completed: " + book);
                iterator.remove();
            }
        }
    }

    @Override
    public void deleteByTitleRegex(String titlePattern) {
        Pattern pattern = Pattern.compile(titlePattern);
        Iterator<Book> iterator = repo.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            Matcher matcher = pattern.matcher(book.getTitle());
            if (matcher.matches()) {
                logger.info("remove book completed: " + book);
                iterator.remove();
            }
        }
    }

    @Override
    public void deleteBySizeRegex(String sizePattern) {
        Pattern pattern = Pattern.compile(sizePattern);
        Iterator<Book> iterator = repo.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            Matcher matcher = pattern.matcher(book.getSize());
            if (matcher.matches()) {
                logger.info("remove book completed: " + book);
                iterator.remove();
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInit() {
        logger.info("default INIT in book repo bean");
    }

    private void defaultDestroy() {
        logger.info("default DESTROY in book repo bean");
    }
}

