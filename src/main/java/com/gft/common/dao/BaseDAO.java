package com.gft.common.dao;

import java.util.List;

public interface BaseDAO<T> {
	
	public void insert(T t);
	
	public void update(T t);
	
	public List<T> select();
	
	public List<T> select(T t);
	
	public T selectById(String id);
	
	public void delete(String id);
	
}
