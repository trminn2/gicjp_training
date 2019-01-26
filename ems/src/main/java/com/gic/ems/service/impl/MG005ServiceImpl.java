package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.dao.GroupDao;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M05_Service;
import com.gic.ems.web.model.M05_EmpListModel;

@Service
public class MG005ServiceImpl implements M05_Service {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private GroupDao groupDao;
	
	@Transactional
	@Override
	public List<M05_EmpListModel> findAll() {
		// TODO
		List<Employee> empList = employeeDao.findAll();

		List<M05_EmpListModel> models = new ArrayList<>();

		System.out.println("list " + empList.size());
		for (Employee emp : empList) {
			M05_EmpListModel model = new M05_EmpListModel();
		    model.setEmployeeId(emp.getEmployeeId());
			model.setFirstName(emp.getFirstName());
			model.setLastName(emp.getLastName());
			model.setEmail(emp.getUser().getEmail());
			model.setGender(emp.getGender().name());
			models.add(model);
			
			EmpGroup g = groupDao.findById(Long.valueOf(emp.getEmpGroup().getId())).orElse(null);
		if (null != g) {
				model.setGroupName(g.getName());
			}else {
				model.setGroupName("");
			}
			models.add(model);
		}
		return models;
	}

/*	@Override
	public List<M05_EmpListModel> findAll(M05_EmpListSearch m05_EmpListSearch) {
		// TODO
		// List<Employee> employees = employeeDao.findAll();

		List<M05_EmpListModel> models = new ArrayList<>();

		return models;
	}*/
	
	@Transactional
	@Override
	public void search(M05_EmpListModel model) {
		/*System.out.println("Search Datas " + model.getEmployeeId());
		System.out.println("Search Datas " + model.getFirstName());
		System.out.println("Search Datas " + model.getGroupName());
		System.out.println("Search Datas " + model.getEmail());*/
	}

}
