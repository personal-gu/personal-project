package cn.itcat.volunteer.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcat.volunteer.user.dao.Volunteer_actDao;
import cn.itcat.volunteer.user.vo.Volunteer_act;

/**
 * 活动表事务
 * 事务处理
 * @author WZH_GYY
 *
 */
@Transactional
public class Volunteer_actService {

	// 注入 Volunteer_userDao
	private Volunteer_actDao volunteer_actDao;

	public Volunteer_actDao getVolunteer_actDao() {
		return volunteer_actDao;
	}

	public void setVolunteer_actDao(Volunteer_actDao volunteer_actDao) {
		this.volunteer_actDao = volunteer_actDao;
	}
	
	public void addAct(Volunteer_act volunteer_act) throws Exception{
		// TODO Auto-generated method stub
		this.getVolunteer_actDao().addAct(volunteer_act);
	}

	/**
	 * 
	 * @param column 列名（实体类的变量名）
	 * @param obj （查询入参）
	 * @return 返回Volunteer_act实体类的List集合
	 * @throws Exception
	 */
	public List<Volunteer_act> queryForParameter(String column,Object parameter) throws Exception{
		// TODO Auto-generated method stub
		return this.getVolunteer_actDao().queryForParameter(column,parameter);
	}

	/**
	 * 根据uids集合来执行批量删除操作
	 * @param uids
	 * @return
	 */
	public Integer delForUids(String[] uids) throws Exception{
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		
		for (String string : uids) {
			hql.append(" or Volunteer_act_uid="+string);
			//delete table where uids=? or uids =?
		}
		String newhql=hql.toString().substring(3);
		
		return this.getVolunteer_actDao().delForUids(newhql);
	}

	public List<Volunteer_act> queryAll(String select_type, String select_data, Integer status) throws Exception{
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("from Volunteer_act where ");
		//分为两种情况
		if(!"null".equals(select_type)){
			hql.append(select_type+" = '"+select_data+"' and");
		}
		hql.append(" Volunteer_act_status="+status);
		System.out.println(hql.toString());
		return this.getVolunteer_actDao().queryAll(hql.toString());
	}

	public List<Volunteer_act> findThree() throws Exception {
		// TODO Auto-generated method stub
		return this.volunteer_actDao.findThree();
	}

	
}
