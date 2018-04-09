package cn.itcat.volunteer.user.service;


import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;


import cn.itcat.volunteer.user.dao.Volunteer_userDao;
import cn.itcat.volunteer.user.vo.Volunteer_act;
import cn.itcat.volunteer.user.vo.Volunteer_user;
import cn.itcat.volunteer.user.vo.volunteerVO;
import cn.itcat.volunteer.user.vo.volunteer_act_;

/**
 * 用户业务层
 * 事务处理
 * 
 * @author icetea
 *
 */
@Transactional
public class Volunteer_userService {
	// 注入 Volunteer_userDao
	private Volunteer_userDao volunteer_userDao;

	public Volunteer_userDao getVolunteer_userDao() {
		return volunteer_userDao;
	}

	public void setVolunteer_userDao(Volunteer_userDao volunteer_userDao) {
		this.volunteer_userDao = volunteer_userDao;
	}

	/**
	 * 处理注册
	 * @param volunteer_user
	 */
	public void save(Volunteer_user volunteer_user) {
		// TODO Auto-generated method stub
		//如果是初始状态 就给0状态 
		//0 未审核  1以审核
		volunteer_user.setVolunteer_type((volunteer_user.getVolunteer_type()!=null)?volunteer_user.getVolunteer_type():"0");
		this.volunteer_userDao.save(volunteer_user);
	}

	
	/**
	 * 处理登录
	 * @param volunteer_user
	 * @return
	 * @throws Exception
	 */
	public Volunteer_user getVolunteer_user(Volunteer_user volunteer_user) throws Exception {
		// TODO Auto-generated method stub
		
		return this.volunteer_userDao.selectVo(volunteer_user);
		
	}

	/**
	 * 查询所有user
	 * @return
	 * @throws Exception
	 */
	public List<Volunteer_user> queryAll() throws Exception{
		// TODO Auto-generated method stub
		return this.getVolunteer_userDao().queryAll();
	}

	/**
	 * 根据传过来的学院和学号查询
	 * @param volunteer_s
	 * @param volunteer_stuid
	 * @return
	 */
	public List<Volunteer_user> queryForData(String volunteer_s, String volunteer_stuid) throws Exception {
		// TODO Auto-generated method stub
		String hql;
		if(volunteer_stuid==null&&volunteer_s==null){
			hql = "from Volunteer_user";
			return this.getVolunteer_userDao().queryForSql(hql,null);
		}
		else if(volunteer_stuid==null&&volunteer_s!=null){
			hql = "from Volunteer_user where volunteer_s = ?";
			return this.getVolunteer_userDao().queryForSql(hql,new Object[]{volunteer_s});
		}else {
			hql = "from Volunteer_user where volunteer_s = ? and volunteer_stuid = ?";
			return this.getVolunteer_userDao().queryForSql(hql,new Object[]{volunteer_s,volunteer_stuid});
		}
		
	
	}

	
	public Boolean updateUserStatus(Integer volunteer_uid) throws Exception{
		// TODO Auto-generated method stub
		String hql = "from Volunteer_user where volunteer_uid = ?";
		List<Volunteer_user> userList = this.getVolunteer_userDao().queryForSql(hql, new Object[]{volunteer_uid});
		if(userList.size()==1){
			Volunteer_user user = userList.get(0);
			//修改审核位 1为审核通过 0为未审核
			user.setVolunteer_type("1");
			this.getVolunteer_userDao().updateUserStatus(user);
			return true;
		}else{
			return false;
		}
		
	}

	public List<Volunteer_user> queryForUid(Integer volunteer_uid) throws Exception{
		// TODO Auto-generated method stub
		String hql = "from Volunteer_user where volunteer_uid = ?";
		return this.getVolunteer_userDao().queryForSql(hql, new Object[]{volunteer_uid});
		
	}

	public void updateUser(Volunteer_user volunteer_user) throws Exception{
		// TODO Auto-generated method stub
		this.getVolunteer_userDao().updateUserStatus(volunteer_user);
	}

	public Integer delUserForId(String[] uids) throws Exception{
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		
		for (String string : uids) {
			hql.append(" or volunteer_uid="+Integer.valueOf(string));
			//delete table where uids=? or uids =?
		}
		String newhql=hql.toString().substring(3);
		return this.getVolunteer_userDao().delUserForId(newhql);
	}

	/**
	 * 根据传参遍历所有相对应的VolunteerVO值
	 * @return
	 * @throws Exception 
	 */
	public List<volunteerVO> queryVAAll(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer strs = new StringBuffer();
		strs.append(" ");
		//如果传参是空值 那么sql只传空格
		if(map!=null){
			/*strs.append(" where 1=1 ");*/
			Set<String> set = map.keySet();
			for (String string : set) {
//				map.get("string");
				strs.append(" and "+string+" like '%"+map.get(string)+"%'");
			}
		}
		
	
		return this.volunteer_userDao.queryVAAll(strs.toString());
	}

	public Integer delVAForUid(String[] uids) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer();
		hql.append("delete from Volunteer_rec where uid in ( ");
		for (String string : uids) {
			hql.append(Integer.valueOf(string)+",");
			//delete table where uids=? or uids =?
		}
		String str = hql.toString();
		str=str.substring(0,str.lastIndexOf(","))+" )";

		return this.getVolunteer_userDao().delVAForUid(str);
	
	}

	/**
	 * 得到 在这个学号下的未报名的活动
	 * @param volunteer_stuid
	 * @return
	 * @throws Exception 
	 */
	public List<volunteer_act_> queryByStuid(String volunteer_stuid) throws Exception {
		// TODO Auto-generated method stub
		
		return this.volunteer_userDao.queryByStuid(volunteer_stuid);
	}

	
	

	

}
