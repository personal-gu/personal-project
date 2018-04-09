package cn.itcat.volunteer.admin.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcat.volunteer.admin.vo.Admin_t;
import cn.itcat.volunteer.user.vo.Volunteer_act;

public class Admin_tDao extends HibernateDaoSupport{

	public List<Admin_t> find(Admin_t admin_t) throws Exception{
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Admin_t where admin_name=?",admin_t.getAdmin_name());

	}

	public List<Volunteer_act> findAllAct(Integer status) throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Volunteer_act where Volunteer_act_status=?",status);
	}

	public List<Admin_t> findAdmint(String string) throws Exception{
		// TODO Auto-generated method stub
		
		return this.getSession().createQuery(string).list();
	}

	public void SOUAdmint(Admin_t admin_t) throws Exception{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(admin_t);
	}

	public List<Admin_t> findTById(Integer admin_uid) throws Exception{
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Admin_t where admin_uid = ?",admin_uid);
	}

	public Integer delTByUids(String str) throws Exception{
		// TODO Auto-generated method stub
		return this.getSession().createSQLQuery(str).executeUpdate();
	}

	

	

}
