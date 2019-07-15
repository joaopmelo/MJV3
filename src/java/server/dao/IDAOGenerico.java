package server.dao;

import java.util.List;

public interface IDAOGenerico<T> {

    public void add(T u);

    public void upd(T u);

    public void del(T u);

    public T findById(int id);

    public List<T> listaAll();

    public List<T> JpqlLike(String campo, String valor);
}
