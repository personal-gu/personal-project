package cn.itcat.volunteer.user.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcat.volunteer.user.vo.Volunteer_act;
import cn.itcat.volunteer.user.vo.Volunteer_user;
import cn.itcat.volunteer.user.vo.volunteerVO;
import cn.itcat.volunteer.user.vo.volunteer_act_;



public class Volunteer_userDao extends HibernateDaoSupport{

	/**
	 * 保存注册信息
	 * @param volunteer_user
	 */
	public void save(Volunteer_user volunteer_user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(volunteer_user);
	}

	/**
	 * 登录信息验证
	 * @param volunteer_user
	 * @return
	 */
	public Volunteer_user selectVo(Volunteer_user volunteer_user) throws Exception{
		// TODO Auto-generated method stub
		
		List<Volunteer_user> listVo = 
				this.getHibernateTemplate().find("from Volunteer_user where volunteer_name=?",volunteer_user.getVolunteer_name());
		
		
		return listVo.get(0);
	}

	public List<Volunteer_user> queryAll() throws Exception{
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Volunteer_user");
	}

	public List<Volunteer_user> queryForSql(String hql, Object[] objects) throws Exception{
		// TODO Auto-generated method stub
		
		return this.getHibernateTemplate().find(hql, objects);
	}

	public void updateUserStatus(Volunteer_user user) throws Exception{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);
	}

	
	public Integer delUserForId(final String newhql) {
		// TODO Auto-generated method stub
		Object temp = this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				//傻逼Hibernate不支持原生sql 我自己写 他妈的
				String sql = "delete from volunteer where "+newhql;
				SQLQuery query = session.createSQLQuery(sql);
				query.executeUpdate();
				return null;
			}
		});
        return (Integer)temp;
	}

	/**
	 * SELECT
			v.*, a.*, r.volunteer_rec_date
		FROM
			(volunteer v ,volunteer_act a ,volunteer_rec r)
		WHERE
			v.volunteer_stuid = r.volunteer_rec_vid
			AND a.volunteer_act_uid = r.volunteer_rec_aid;
	 * @return
	 * @throws Exception
	 */
	public List<volunteerVO> queryVAAll(String sql) throws Exception{
		// new cn.itcat.volunteer.user.vo.volunteerVO(v.*, a.*, r.volunteer_rec_date,r.uid)
		String newsql = "select new cn.itcat.volunteer.user.vo.volunteerVO( a.Volunteer_act_uid, a.Volunteer_act_name, a.Volunteer_act_core,"
				+ "a.Volunteer_act_spo, a.Volunteer_act_date, a.Volunteer_act_site, a.Volunteer_act_flow,"
			+ "a.Volunteer_act_mans, a.Volunteer_act_status, v.volunteer_uid, v.volunteer_stuid,"
			+ "v.volunteer_name, v.volunteer_ps, v.volunteer_sex, v.volunteer_s, v.volunteer_c,"
			+ "v.volunteer_p, v.volunteer_type, v.volunteer_like, r.uid, r.Volunteer_rec_aid,"
			+ "r.Volunteer_rec_vid, r.Volunteer_rec_date"
				+ ") from Volunteer_user v,Volunteer_act a ,Volunteer_rec r "
				+ "where v.volunteer_stuid = r.Volunteer_rec_vid AND "
				+ "a.Volunteer_act_uid = r.Volunteer_rec_aid "+sql;
		/* List list = this.getHibernateTemplate().find(newsql);*/
		
		 List<volunteerVO> list = this.getSession().createQuery(newsql).list();
		 for (volunteerVO volunteerVO : list) {
			System.out.println(volunteerVO.toString());
		}
		
		 return list;
		
	}

	/**
	 * 执行删除值
	 * @param str
	 * @return
	 */
	public Integer delVAForUid(String str) throws Exception{
		// TODO Auto-generated method stub
		Integer flag = this.getSession().createSQLQuery(str).executeUpdate();
		
		return flag;
	}

	public List<volunteer_act_> queryByStuid(String volunteer_stuid) throws Exception{
		// TODO Auto-generated method stub
		String hql = "select new cn.itcat.volunteer.user.vo.volunteer_act_( a.Volunteer_act_uid, a.Volunteer_act_name, a.Volunteer_act_core,"
				+ "a.Volunteer_act_spo, a.Volunteer_act_date, a.Volunteer_act_site, a.Volunteer_act_flow,"
			+ "a.Volunteer_act_mans, a.Volunteer_act_status)"
				+ " from Volunteer_act a "
				+ "where a.Volunteer_act_uid NOT IN ( "
		+"SELECT "
			+"r.Volunteer_rec_aid "
		+"FROM "
			+"Volunteer_rec r "
		+"WHERE "
			+"r.Volunteer_rec_vid = '"+volunteer_stuid+"' "
	+" )";
		
		 List<volunteer_act_> list = this.getSession().createQuery(hql).list();
		 for (volunteer_act_ volunteer_act : list) {
			System.out.println(volunteer_act.toString());
		}
		 return list;
	}

	

}
