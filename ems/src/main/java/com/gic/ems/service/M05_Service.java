package com.gic.ems.service;

import java.util.List;
import com.gic.ems.web.model.M05_EmpListModel;

public interface M05_Service {

	public List<M05_EmpListModel> findAll();

	public void search(M05_EmpListModel m05_Search);
}
