package cn.itcat.volunteer.admin.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcat.volunteer.admin.service.Admin_sService;
import cn.itcat.volunteer.admin.vo.Admin_s;

/**
 * ??????????Action
 * @author WZH_GYY
 *
 */

public class Admin_sAction extends ActionSupport implements ModelDriven<Admin_s>{

	//????????admin_t
	private Admin_s admin_s = new Admin_s();
	
	//????????
	private Admin_sService admin_sService = new Admin_sService();
	
	@Override
	public Admin_s getModel() {
		// TODO Auto-generated method stub
		return admin_s;
	}

	public Admin_s getAdmin_s() {
		return admin_s;
	}

	public void setAdmin_s(Admin_s admin_s) {
		this.admin_s = admin_s;
	}

	public Admin_sService getAdmin_sService() {
		return admin_sService;
	}

	public void setAdmin_sService(Admin_sService admin_sService) {
		this.admin_sService = admin_sService;
	}

	
	

}
