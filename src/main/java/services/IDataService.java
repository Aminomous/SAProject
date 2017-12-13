package services;

import java.util.ArrayList;

public interface IDataService<T> {

    ArrayList<T> getAll();

    void update(T data);

    void add(T data);
}
