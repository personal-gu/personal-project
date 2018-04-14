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
 * �û�ҵ���
 * ������
 * 
 * @author icetea
 *
 */
@Transactional
public class Volunteer_userService {
	// ע�� Volunteer_userDao
	private Volunteer_userDao volunteer_userDao;

	public Volunteer_userDao getVolunteer_userDao() {
		return volunteer_userDao;
	}

	public void setVolunteer_userDao(Volunteer_userDao volunteer_userDao) {
		this.volunteer_userDao = volunteer_userDao;
	}

	/**
	 * ����ע��
	 * @param volunteer_user
	 */
	public void save(Volunteer_user volunteer_user) {
		// TODO Auto-generated method stub
		//����ǳ�ʼ״̬ �͸�0״̬ 
		//0 δ���  1�����
		volunteer_user.setVolunteer_type((volunteer_user.getVolunteer_type()!=null)?volunteer_user.getVolunteer_type():"0");
		this.volunteer_userDao.save(volunteer_user);
	}

	
	/**
	 * �����¼
	 * @param volunteer_user
	 * @return
	 * @throws Exception
	 */
	public Volunteer_user getVolunteer_user(Volunteer_user volunteer_user) throws Exception {
		// TODO Auto-generated method stub
		
		return this.volunteer_userDao.selectVo(volunteer_user);
		
	}

	/**
	 * ��ѯ����user
	 * @return
	 * @throws Exception
	 */
	public List<Volunteer_user> queryAll() throws Exception{
		// TODO Auto-generated method stub
		return this.getVolunteer_userDao().queryAll();
	}

	/**
	 * ���ݴ�������ѧԺ��ѧ�Ų�ѯ
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
			//�޸����λ 1Ϊ���ͨ�� 0Ϊδ���
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
	 * ���ݴ��α����������Ӧ��VolunteerVOֵ
	 * @return
	 * @throws Exception 
	 */
	public List<volunteerVO> queryVAAll(Map<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer strs = new StringBuffer();
		strs.append(" ");
		//��������ǿ�ֵ ��ôsqlֻ���ո�
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
	 * �õ� �����ѧ���µ�δ�����Ļ
	 * @param volunteer_stuid
	 * @return
	 * @throws Exception 
	 */
	public List<volunteer_act_> queryByStuid(String volunteer_stuid) throws Exception {
		// TODO Auto-generated method stub
		
		return this.volunteer_userDao.queryByStuid(volunteer_stuid);
	}

	
	

	

}
