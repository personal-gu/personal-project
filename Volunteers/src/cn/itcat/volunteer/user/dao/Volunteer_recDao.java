package cn.itcat.volunteer.user.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcat.volunteer.user.vo.Volunteer_rec;

public class Volunteer_recDao extends HibernateDaoSupport{

	public void insertRec(Volunteer_rec rec) throws Exception{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(rec);
	}

}
