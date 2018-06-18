package com.crm.service;

import java.util.List;

public interface CrudOperation<T> {

	public T save(T t);

	public T update(T t);

	public void delete(Long id);

	public T edit(Long id);

	public List<T> getAll();
}
