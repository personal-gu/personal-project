package cn.itcat.volunteer.user.vo;

import java.util.Date;

public class volunteerVO {

	private Integer Volunteer_act_uid;
	private String Volunteer_act_name;
	private String Volunteer_act_core;
	private String Volunteer_act_spo;
	private Date Volunteer_act_date;
	private String Volunteer_act_site;
	private String Volunteer_act_flow;
	private String Volunteer_act_mans;
	private Integer Volunteer_act_status;
	
	private Integer volunteer_uid;
	private String volunteer_stuid;
	private String volunteer_name;
	private String volunteer_ps;
	private String volunteer_sex;
	private String volunteer_s;
	private String volunteer_c;
	private String volunteer_p;
	private String volunteer_type;
	private String volunteer_like;//爱好
	
	private Integer uid;
	private Integer Volunteer_rec_aid;//活动编号
	private String Volunteer_rec_vid; //学生学号
	private Date Volunteer_rec_date;
	
	
	
	public volunteerVO(Integer volunteer_act_uid, String volunteer_act_name, String volunteer_act_core,
			String volunteer_act_spo, Date volunteer_act_date, String volunteer_act_site, String volunteer_act_flow,
			String volunteer_act_mans, Integer volunteer_act_status, Integer volunteer_uid, String volunteer_stuid,
			String volunteer_name, String volunteer_ps, String volunteer_sex, String volunteer_s, String volunteer_c,
			String volunteer_p, String volunteer_type, String volunteer_like, Integer uid, Integer volunteer_rec_aid,
			String volunteer_rec_vid, Date volunteer_rec_date) {
		super();
		Volunteer_act_uid = volunteer_act_uid;
		Volunteer_act_name = volunteer_act_name;
		Volunteer_act_core = volunteer_act_core;
		Volunteer_act_spo = volunteer_act_spo;
		Volunteer_act_date = volunteer_act_date;
		Volunteer_act_site = volunteer_act_site;
		Volunteer_act_flow = volunteer_act_flow;
		Volunteer_act_mans = volunteer_act_mans;
		Volunteer_act_status = volunteer_act_status;
		this.volunteer_uid = volunteer_uid;
		this.volunteer_stuid = volunteer_stuid;
		this.volunteer_name = volunteer_name;
		this.volunteer_ps = volunteer_ps;
		this.volunteer_sex = volunteer_sex;
		this.volunteer_s = volunteer_s;
		this.volunteer_c = volunteer_c;
		this.volunteer_p = volunteer_p;
		this.volunteer_type = volunteer_type;
		this.volunteer_like = volunteer_like;
		this.uid = uid;
		Volunteer_rec_aid = volunteer_rec_aid;
		Volunteer_rec_vid = volunteer_rec_vid;
		Volunteer_rec_date = volunteer_rec_date;
	}
	public Date getVolunteer_rec_date() {
		return Volunteer_rec_date;
	}
	public void setVolunteer_rec_date(Date volunteer_rec_date) {
		Volunteer_rec_date = volunteer_rec_date;
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
	public Integer getVolunteer_uid() {
		return volunteer_uid;
	}
	public void setVolunteer_uid(Integer volunteer_uid) {
		this.volunteer_uid = volunteer_uid;
	}
	public String getVolunteer_stuid() {
		return volunteer_stuid;
	}
	public void setVolunteer_stuid(String volunteer_stuid) {
		this.volunteer_stuid = volunteer_stuid;
	}
	public String getVolunteer_name() {
		return volunteer_name;
	}
	public void setVolunteer_name(String volunteer_name) {
		this.volunteer_name = volunteer_name;
	}
	public String getVolunteer_ps() {
		return volunteer_ps;
	}
	public void setVolunteer_ps(String volunteer_ps) {
		this.volunteer_ps = volunteer_ps;
	}
	public String getVolunteer_sex() {
		return volunteer_sex;
	}
	public void setVolunteer_sex(String volunteer_sex) {
		this.volunteer_sex = volunteer_sex;
	}
	public String getVolunteer_s() {
		return volunteer_s;
	}
	public void setVolunteer_s(String volunteer_s) {
		this.volunteer_s = volunteer_s;
	}
	public String getVolunteer_c() {
		return volunteer_c;
	}
	public void setVolunteer_c(String volunteer_c) {
		this.volunteer_c = volunteer_c;
	}
	public String getVolunteer_p() {
		return volunteer_p;
	}
	public void setVolunteer_p(String volunteer_p) {
		this.volunteer_p = volunteer_p;
	}
	public String getVolunteer_type() {
		return volunteer_type;
	}
	public void setVolunteer_type(String volunteer_type) {
		this.volunteer_type = volunteer_type;
	}
	public String getVolunteer_like() {
		return volunteer_like;
	}
	public void setVolunteer_like(String volunteer_like) {
		this.volunteer_like = volunteer_like;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
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
		return "volunteerVO [Volunteer_act_uid=" + Volunteer_act_uid + ", Volunteer_act_name=" + Volunteer_act_name
				+ ", Volunteer_act_core=" + Volunteer_act_core + ", Volunteer_act_spo=" + Volunteer_act_spo
				+ ", Volunteer_act_date=" + Volunteer_act_date + ", Volunteer_act_site=" + Volunteer_act_site
				+ ", Volunteer_act_flow=" + Volunteer_act_flow + ", Volunteer_act_mans=" + Volunteer_act_mans
				+ ", Volunteer_act_status=" + Volunteer_act_status + ", volunteer_uid=" + volunteer_uid
				+ ", volunteer_stuid=" + volunteer_stuid + ", volunteer_name=" + volunteer_name + ", volunteer_ps="
				+ volunteer_ps + ", volunteer_sex=" + volunteer_sex + ", volunteer_s=" + volunteer_s + ", volunteer_c="
				+ volunteer_c + ", volunteer_p=" + volunteer_p + ", volunteer_type=" + volunteer_type
				+ ", volunteer_like=" + volunteer_like + ", uid=" + uid + ", Volunteer_rec_aid=" + Volunteer_rec_aid
				+ ", Volunteer_rec_vid=" + Volunteer_rec_vid + ", Volunteer_rec_date=" + Volunteer_rec_date + "]";
	}
	
	
	
}
