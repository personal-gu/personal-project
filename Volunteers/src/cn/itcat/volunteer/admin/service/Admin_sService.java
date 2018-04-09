package cn.itcat.volunteer.admin.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcat.volunteer.admin.dao.Admin_sDao;

@Transactional
public class Admin_sService {

	//×¢Èëdao
	private Admin_sDao admin_sDao = new Admin_sDao();

	public Admin_sDao getAdmin_sDao() {
		return admin_sDao;
	}

	public void setAdmin_sDao(Admin_sDao admin_sDao) {
		this.admin_sDao = admin_sDao;
	}
	
	
}
