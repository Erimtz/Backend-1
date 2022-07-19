package dao;

public interface IDao<T> {

    // la T significa un generico que despues puedo cambiar y utilizar como quiera

    public T guardar(T t);

    public T buscar (Long id);


}
