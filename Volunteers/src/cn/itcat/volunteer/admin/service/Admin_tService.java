package cn.itcat.volunteer.admin.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import cn.itcat.volunteer.admin.dao.Admin_tDao;
import cn.itcat.volunteer.admin.vo.Admin_t;
import cn.itcat.volunteer.user.vo.Volunteer_act;
import cn.itcat.volunteer.user.vo.Volunteer_user;
import cn.itcat.volunteer.user.vo.volunteerVO;

@Transactional
public class Admin_tService {

	//×¢ÈëDao
	private Admin_tDao admin_tDao = new Admin_tDao();

	public Admin_tDao getAdmin_tDao() {
		return admin_tDao;
	}

	public void setAdmin_tDao(Admin_tDao admin_tDao) {
		this.admin_tDao = admin_tDao;
	}

	public Admin_t getAdmin_t(Volunteer_user volunteer_user) throws Exception {
		// TODO Auto-generated method stub
		Admin_t admin_t = new Admin_t();
		admin_t.setAdmin_name(volunteer_user.getVolunteer_name());
		admin_t.setAdmin_ps(volunteer_user.getVolunteer_ps());
		List<Admin_t> listVo= this.getAdmin_tDao().find(admin_t);
		return listVo.get(0);
	}

	public List<Volunteer_act> find(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return this.getAdmin_tDao().findAllAct(status);
	}

	public List<Admin_t> findAdmint(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("select t from Admin_t t where 1=1");
		if(map!=null){
			Set<String> set = map.keySet();
			for (String string : set) {
				hql.append(" and "+string+" like '%"+map.get(string)+"%'");
			}
		}
		return this.admin_tDao.findAdmint(hql.toString());
	}

	public void SOUAdmint(Admin_t admin_t) throws Exception {
		// TODO Auto-generated method stub
		this.admin_tDao.SOUAdmint(admin_t);
	}

	public List<Admin_t> findById(Integer admin_uid) throws Exception {
		// TODO Auto-generated method stub
		return this.admin_tDao.findTById(admin_uid);
	}

	public Integer delTByUids(String[] uids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("delete from Admin_t where admin_uid in ( ");
		for (String string : uids) {
			hql.append(Integer.valueOf(string) +", ");
		}
		String str = hql.toString();
		str=str.substring(0,str.lastIndexOf(","))+" )";
		return this.getAdmin_tDao().delTByUids(str);
	}

	
	
	
}
