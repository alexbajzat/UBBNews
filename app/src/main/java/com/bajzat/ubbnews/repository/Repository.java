package com.bajzat.ubbnews.repository;

/**
 * Created by bjz on 3/23/2017.
 */
public interface Repository<ID, T> {
    void create(T obj) throws Exception;

    void delete(ID id);

    void update(ID id, T obj);

    Iterable<T> read();
}
