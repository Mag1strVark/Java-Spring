package org.example.app.services;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);

    void deleteByAuthorRegex(String authorPattern);

    void deleteByTitleRegex(String titlePattern);

    void deleteBySizeRegex(String sizePattern);
}
