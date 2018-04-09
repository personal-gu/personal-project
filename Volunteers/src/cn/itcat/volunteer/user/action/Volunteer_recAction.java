package cn.itcat.volunteer.user.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcat.volunteer.user.service.Volunteer_recService;
import cn.itcat.volunteer.user.vo.Volunteer_rec;
import cn.itcat.volunteer.user.vo.Volunteer_user;

public class Volunteer_recAction extends ActionSupport implements ModelDriven<Volunteer_rec>{

	//注入实体类
	private Volunteer_rec volunteer_rec = new Volunteer_rec();
	//注入事务层
	private Volunteer_recService volunteer_recService = new Volunteer_recService();
	@Override
	public Volunteer_rec getModel() {
		// TODO Auto-generated method stub
		return volunteer_rec;
	}
	public Volunteer_rec getVolunteer_rec() {
		return volunteer_rec;
	}
	public void setVolunteer_rec(Volunteer_rec volunteer_rec) {
		this.volunteer_rec = volunteer_rec;
	}
	public Volunteer_recService getVolunteer_recService() {
		return volunteer_recService;
	}
	public void setVolunteer_recService(Volunteer_recService volunteer_recService) {
		this.volunteer_recService = volunteer_recService;
	}
	
	public String doRec(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Integer uid = Integer.valueOf(request.getParameter("uid"));
		Volunteer_rec rec = new Volunteer_rec();
		Volunteer_user volunteer_user = (Volunteer_user) ServletActionContext.getRequest().getSession().getAttribute("volUser");
		rec.setVolunteer_rec_aid(uid);
		rec.setVolunteer_rec_vid(volunteer_user.getVolunteer_stuid());
		rec.setVolunteer_rec_date(new Date());
		try {
			this.getVolunteer_recService().insertRec(rec);
			response.getWriter().write("{\"success\":true}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}
