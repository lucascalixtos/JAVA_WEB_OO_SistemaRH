package database;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rh.model.Base;

public class DAO<T extends Base> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static EntityManager manager = ConnectionFactory.getEntityManager();
	
	public T buscarPorId(Class<T> clazz, int id){
		return manager.find(clazz, id);
	}
	
	public void salvar(T t){
		try{
			manager.getTransaction().begin();
			
			if(t.getId() == 0){
				manager.persist(t);
			}else{
				manager.merge(t);
			}
			
			manager.getTransaction().commit();
		} catch (Exception e){
			manager.getTransaction().rollback();
		}
	}
	
	public void remover(Class<T>clazz, int id){
		T t = buscarPorId(clazz, id);
		try{
			manager.getTransaction().begin();
			manager.remove(t);	
			manager.getTransaction().commit();
		} catch (Exception e){
			manager.getTransaction().rollback();
		}
	}
	
	public List<T> buscarTodos(String jpql){
		Query query = manager.createQuery(jpql);
		return query.getResultList();
	}
}
