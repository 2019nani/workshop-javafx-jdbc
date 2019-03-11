package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Vendedor;

public interface SellerDao {
	void insert(Vendedor obj);
	void update(Vendedor obj);
	void deleteById(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor> findAll();
	List<Vendedor> findByDepartment(Departamento department);
}