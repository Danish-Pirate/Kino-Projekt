package group3.kino.candyAdministration.service;

import group3.kino.movieAdministration.model.Movie;

import java.util.Optional;
import java.util.Set;

public interface CRUD<T, ID> {

    Set<T> findAll();
    T save(T object);
    void delete(Optional<T> object);
    void deleteById(ID Id);
    Optional<T> findById(ID Id);
}
