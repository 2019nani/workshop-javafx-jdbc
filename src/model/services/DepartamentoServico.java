package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoServico {
	
	private DepartamentoDao dao = DaoFactory.createDepartmentDao();

	public List<Departamento> findAll(){
		List<Departamento> list = new ArrayList<>();
		return dao.findAll();
	}
}
