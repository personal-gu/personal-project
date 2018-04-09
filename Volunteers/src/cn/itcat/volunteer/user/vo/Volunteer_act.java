package cn.itcat.volunteer.user.vo;

import java.util.Date;

/**
 * 活动详情表
 * @author Icetea
 *
 */
public class Volunteer_act {

	private Integer Volunteer_act_uid;
	private String Volunteer_act_name;
	private String Volunteer_act_core;
	private String Volunteer_act_spo;
	private Date Volunteer_act_date;
	private String Volunteer_act_site;
	private String Volunteer_act_flow;
	private String Volunteer_act_mans;
	private Integer Volunteer_act_status;
	public Integer getVolunteer_act_uid() {
		return Volunteer_act_uid;
	}
	public void setVolunteer_act_uid(Integer volunteer_act_uid) {
		Volunteer_act_uid = volunteer_act_uid;
	}
	public String getVolunteer_act_name() {
		return Volunteer_act_name;
	}
	public void setVolunteer_act_name(String volunteer_act_name) {
		Volunteer_act_name = volunteer_act_name;
	}
	public String getVolunteer_act_core() {
		return Volunteer_act_core;
	}
	public void setVolunteer_act_core(String volunteer_act_core) {
		Volunteer_act_core = volunteer_act_core;
	}
	public String getVolunteer_act_spo() {
		return Volunteer_act_spo;
	}
	public void setVolunteer_act_spo(String volunteer_act_spo) {
		Volunteer_act_spo = volunteer_act_spo;
	}
	public Date getVolunteer_act_date() {
		return Volunteer_act_date;
	}
	public void setVolunteer_act_date(Date volunteer_act_date) {
		Volunteer_act_date = volunteer_act_date;
	}
	public String getVolunteer_act_site() {
		return Volunteer_act_site;
	}
	public void setVolunteer_act_site(String volunteer_act_site) {
		Volunteer_act_site = volunteer_act_site;
	}
	public String getVolunteer_act_flow() {
		return Volunteer_act_flow;
	}
	public void setVolunteer_act_flow(String volunteer_act_flow) {
		Volunteer_act_flow = volunteer_act_flow;
	}
	public String getVolunteer_act_mans() {
		return Volunteer_act_mans;
	}
	public void setVolunteer_act_mans(String volunteer_act_mans) {
		Volunteer_act_mans = volunteer_act_mans;
	}
	public Integer getVolunteer_act_status() {
		return Volunteer_act_status;
	}
	public void setVolunteer_act_status(Integer volunteer_act_status) {
		Volunteer_act_status = volunteer_act_status;
	}
	@Override
	public String toString() {
		return "Volunteer_act [Volunteer_act_uid=" + Volunteer_act_uid + ", Volunteer_act_name=" + Volunteer_act_name
				+ ", Volunteer_act_core=" + Volunteer_act_core + ", Volunteer_act_spo=" + Volunteer_act_spo
				+ ", Volunteer_act_date=" + Volunteer_act_date + ", Volunteer_act_site=" + Volunteer_act_site
				+ ", Volunteer_act_flow=" + Volunteer_act_flow + ", Volunteer_act_mans=" + Volunteer_act_mans
				+ ", Volunteer_act_status=" + Volunteer_act_status + "]";
	}
	
	
}
