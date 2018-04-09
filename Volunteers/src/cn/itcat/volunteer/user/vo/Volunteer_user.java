package cn.itcat.volunteer.user.vo;

public class Volunteer_user {
	private Integer volunteer_uid;
	private String volunteer_stuid;
	private String volunteer_name;
	private String volunteer_ps;
	private String volunteer_sex;
	private String volunteer_s;
	private String volunteer_c;
	private String volunteer_p;
	private String volunteer_type;
	private String volunteer_like;//°®ºÃ
	
	
	public String getVolunteer_like() {
		return volunteer_like;
	}
	public void setVolunteer_like(String volunteer_like) {
		this.volunteer_like = volunteer_like;
	}
	public Integer getVolunteer_uid() {
		return volunteer_uid;
	}
	public void setVolunteer_uid(Integer volunteer_uid) {
		this.volunteer_uid = volunteer_uid;
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
	
	public String getVolunteer_stuid() {
		return volunteer_stuid;
	}
	public void setVolunteer_stuid(String volunteer_stuid) {
		this.volunteer_stuid = volunteer_stuid;
	}
	@Override
	public String toString() {
		return "Volunteer_user [volunteer_uid=" + volunteer_uid + ", volunteer_stuid=" + volunteer_stuid
				+ ", volunteer_name=" + volunteer_name + ", volunteer_ps=" + volunteer_ps + ", volunteer_sex="
				+ volunteer_sex + ", volunteer_s=" + volunteer_s + ", volunteer_c=" + volunteer_c + ", volunteer_p="
				+ volunteer_p + ", volunteer_type=" + volunteer_type + "]";
	}
	
	
	
}
