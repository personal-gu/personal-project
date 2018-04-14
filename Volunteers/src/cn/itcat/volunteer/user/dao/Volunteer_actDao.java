package cn.itcat.volunteer.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcat.volunteer.user.vo.Volunteer_act;

public class Volunteer_actDao extends HibernateDaoSupport {

	public void addAct(Volunteer_act volunteer_act) throws Exception{
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(volunteer_act);
	}

	/**
	 * 
	 * @param column ������ʵ����ı�������
	 * @param obj ����ѯ��Σ�
	 * @return ����Volunteer_actʵ�����List����
	 * @throws Exception
	 */
	public List<Volunteer_act> queryForParameter(String column,Object obj) throws Exception{
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Volunteer_act where "+column+"=?",obj);
		
	}
	/**
	 * ԭ��sql����ɾ����Volunteer_act�е����ݼ�¼
	 * @param newhql where������������
	 * @return
	 */
	public Integer delForUids(final String newhql) {
		// TODO Auto-generated method stub
		Object temp = this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				//�������ɵ��Hibernate����֧��ԭ��sql ���Լ�д �����
				String sql = "delete from volunteer_act where "+newhql;
				SQLQuery query = session.createSQLQuery(sql);
				query.executeUpdate();
				return null;
			}
		});
		return (Integer) temp;
	}

	/**
	 * ����hql�������е�act
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public List<Volunteer_act> queryAll(String string) throws Exception{
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(string);
	}

	public List<Volunteer_act> findThree() throws Exception{
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Volunteer_act ORDER BY Volunteer_act_date desc limit 3 ");
	}

	
}
