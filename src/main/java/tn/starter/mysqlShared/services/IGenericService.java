package tn.starter.mysqlShared.services;

import java.util.List;

public interface IGenericService<T> {
	T add(T dto);
	T update(T dto);
	T retrieveById(Long id);
	List<T> retrieveAll();
	void delete(Long id);
}