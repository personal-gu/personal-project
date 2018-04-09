package cn.itcat.volunteer.admin.vo;

import java.util.Date;

public class Admin_s {

	private Integer s_uid;
	private Integer s_type;
	private String s_details;
	private Integer s_confirm;
	private Integer s_admin_uid;
	private Date s_admin_date;
	public Integer getS_uid() {
		return s_uid;
	}
	public void setS_uid(Integer s_uid) {
		this.s_uid = s_uid;
	}
	public Integer getS_type() {
		return s_type;
	}
	public void setS_type(Integer s_type) {
		this.s_type = s_type;
	}
	public String getS_details() {
		return s_details;
	}
	public void setS_details(String s_details) {
		this.s_details = s_details;
	}
	public Integer getS_confirm() {
		return s_confirm;
	}
	public void setS_confirm(Integer s_confirm) {
		this.s_confirm = s_confirm;
	}
	public Integer getS_admin_uid() {
		return s_admin_uid;
	}
	public void setS_admin_uid(Integer s_admin_uid) {
		this.s_admin_uid = s_admin_uid;
	}
	public Date getS_admin_date() {
		return s_admin_date;
	}
	public void setS_admin_date(Date s_admin_date) {
		this.s_admin_date = s_admin_date;
	}
	@Override
	public String toString() {
		return "admin_s [s_uid=" + s_uid + ", s_type=" + s_type + ", s_details=" + s_details + ", s_confirm="
				+ s_confirm + ", s_admin_uid=" + s_admin_uid + ", s_admin_date=" + s_admin_date + "]";
	}
	
	
}
