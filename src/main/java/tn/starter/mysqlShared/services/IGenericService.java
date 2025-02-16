package tn.starter.mysqlShared.services;

import java.util.List;

public interface IGenericService<T> {
	T add(T dto);
	T update(T dto);
	T retrieveById(long id);
	List<T> retrieveAll();
	void delete(long id);
}