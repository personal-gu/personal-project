package cn.itcat.volunteer.user.vo;

import java.util.Date;

/**
 * 活动报名表
 * @author WZH_GYY
 *
 */
public class Volunteer_rec {

	private Integer uid;
	private Integer Volunteer_rec_aid;//活动编号
	private String Volunteer_rec_vid; //学生学号
	private Date Volunteer_rec_date;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getVolunteer_rec_aid() {
		return Volunteer_rec_aid;
	}
	public void setVolunteer_rec_aid(Integer volunteer_rec_aid) {
		Volunteer_rec_aid = volunteer_rec_aid;
	}
	
	public String getVolunteer_rec_vid() {
		return Volunteer_rec_vid;
	}
	public void setVolunteer_rec_vid(String volunteer_rec_vid) {
		Volunteer_rec_vid = volunteer_rec_vid;
	}
	public Date getVolunteer_rec_date() {
		return Volunteer_rec_date;
	}
	public void setVolunteer_rec_date(Date volunteer_rec_date) {
		Volunteer_rec_date = volunteer_rec_date;
	}
	@Override
	public String toString() {
		return "Volunteer_rec [Volunteer_rec_aid=" + Volunteer_rec_aid + ", Volunteer_rec_vid=" + Volunteer_rec_vid
				+ ", Volunteer_rec_date=" + Volunteer_rec_date + "]";
	} 
	
	
}
