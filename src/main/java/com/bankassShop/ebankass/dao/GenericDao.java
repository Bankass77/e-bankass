package com.bankassShop.ebankass.dao;

import java.util.List;

public interface GenericDao<T> {

	T get(int id);

	List<T> getAll();

	Long save(T t);

	void update(T t);

	void delete(T t);

}
