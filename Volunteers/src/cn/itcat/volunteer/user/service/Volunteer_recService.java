package cn.itcat.volunteer.user.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itcat.volunteer.user.dao.Volunteer_recDao;
import cn.itcat.volunteer.user.vo.Volunteer_rec;

@Transactional
public class Volunteer_recService {

	//×¢ÈëDao
	private Volunteer_recDao volunteer_recDao = new Volunteer_recDao();

	public Volunteer_recDao getVolunteer_recDao() {
		return volunteer_recDao;
	}

	public void setVolunteer_recDao(Volunteer_recDao volunteer_recDao) {
		this.volunteer_recDao = volunteer_recDao;
	}

	public void insertRec(Volunteer_rec rec) throws Exception {
		// TODO Auto-generated method stub
		this.getVolunteer_recDao().insertRec(rec);
	}
	
	
}
