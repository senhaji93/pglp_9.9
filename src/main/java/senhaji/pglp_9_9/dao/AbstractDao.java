package senhaji.pglp_9_9.dao;

import java.util.ArrayList;

public abstract class AbstractDao<T> {
  
    public abstract T create(T object);
  
    public abstract T find(String id);
    
    public abstract ArrayList<T> findAll();
   
    public abstract T update(T object);
   
    public abstract void delete(T object);
}
