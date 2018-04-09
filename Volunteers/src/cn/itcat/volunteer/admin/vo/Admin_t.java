package cn.itcat.volunteer.admin.vo;

/**
 * 管理员表
 * @author WZH_GYY
 *
 */
public class Admin_t {

	private Integer admin_uid;
	private String admin_name;
	private String admin_ps;
	private String admin_p;
	private String admin_dept;
	public Integer getAdmin_uid() {
		return admin_uid;
	}
	public void setAdmin_uid(Integer admin_uid) {
		this.admin_uid = admin_uid;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_ps() {
		return admin_ps;
	}
	public void setAdmin_ps(String admin_ps) {
		this.admin_ps = admin_ps;
	}
	public String getAdmin_p() {
		return admin_p;
	}
	public void setAdmin_p(String admin_p) {
		this.admin_p = admin_p;
	}
	public String getAdmin_dept() {
		return admin_dept;
	}
	public void setAdmin_dept(String admin_dept) {
		this.admin_dept = admin_dept;
	}
	@Override
	public String toString() {
		return "admin_t [admin_uid=" + admin_uid + ", admin_name=" + admin_name + ", admin_ps=" + admin_ps
				+ ", admin_p=" + admin_p + ", admin_dept=" + admin_dept + "]";
	}
	
	
}
