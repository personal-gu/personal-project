package cn.itcat.volunteer.user.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wakeboy.general.controller.BusinessBaseControler;

import cn.itcat.volunteer.admin.service.Admin_tService;
import cn.itcat.volunteer.admin.vo.Admin_t;
import cn.itcat.volunteer.user.service.Volunteer_userService;
import cn.itcat.volunteer.user.vo.Volunteer_act;
import cn.itcat.volunteer.user.vo.Volunteer_user;
import cn.itcat.volunteer.user.vo.volunteerVO;
import cn.itcat.volunteer.user.vo.volunteer_act_;
/**
 * �û�Action
 * @author WZH_GYY
 *
 */

public class Volunteer_userAction extends ActionSupport implements ModelDriven<Volunteer_user>{
	//ģ�������õ�����
	private Volunteer_user volunteer_user = new Volunteer_user();
	//־Ը�ߵ�Serviceע��
	private Volunteer_userService volunteer_userService;
	//����Ա��serviceע��
	private  Admin_tService admin_tService;
	//�Ƿ��ǹ���Ա־Ը��
	private String select;
	//user��������
	private List<Volunteer_user> userList;
	//����ҳ����û�����
	private List<volunteerVO> voList;
	//ҳ������Ĳ�ѯ����
	private String select_type;
	//ҳ������Ĳ�ѯ����
	private String select_data;
	//����ҳ��Ļ��Ϣ
	private List<volunteer_act_> act_List;
	
	
	
	public List<volunteer_act_> getAct_List() {
		return act_List;
	}
	public void setAct_List(List<volunteer_act_> act_List) {
		this.act_List = act_List;
	}
	public String getSelect_data() {
		return select_data;
	}
	public void setSelect_data(String select_data) {
		this.select_data = select_data;
	}
	public String getSelect_type() {
		return select_type;
	}
	public void setSelect_type(String select_type) {
		this.select_type = select_type;
	}
	public List<volunteerVO> getVoList() {
		return voList;
	}
	public void setVoList(List<volunteerVO> voList) {
		this.voList = voList;
	}
	public List<Volunteer_user> getUserList() {
		return userList;
	}
	public void setUserList(List<Volunteer_user> userList) {
		this.userList = userList;
	}
	public Admin_tService getAdmin_tService() {
		return admin_tService;
	}
	public void setAdmin_tService(Admin_tService admin_tService) {
		this.admin_tService = admin_tService;
	}
	public String getSelect() {
		return select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public Volunteer_user getVolunteer_user() {
		return volunteer_user;
	}
	public void setVolunteer_user(Volunteer_user volunteer_user) {
		this.volunteer_user = volunteer_user;
	}
	public Volunteer_userService getVolunteer_userService() {
		return volunteer_userService;
	}
	public void setVolunteer_userService(Volunteer_userService volunteer_userService) {
		this.volunteer_userService = volunteer_userService;
	}
	
	@Override
	public Volunteer_user getModel() {

		return volunteer_user;
	}
	
	/**
	 * ��ע��ҳ��
	 * @return
	 */
	public String goRegistPage() {
		return "registPage";
		
	}
	/**
	 * ����ǰ̨����ע�������
	 * @return
	 */
	public String doRegist(){
		
		this.volunteer_userService.save(volunteer_user);
		//�ѵ�¼���󴫸�session
		//ServletActionContext.getRequest().getSession().setAttribute("existUser", volunteer_user);
		return "goLogin";
		
	}

	/**
	 * �����¼
	 * @return
	 */
	public String doLogin(){
		System.out.println("��¼��Ϣ++++++++++"+volunteer_user.toString());
		System.out.println(this.getSelect());
		
		/**
		 * ������� ��һ��Ϊ־Ը��  0
		 * �ڶ����ǹ���Ա 1
		 */
		Volunteer_user vo;
		Admin_t avo;
		if("0".equals(this.getSelect())){
			try {
				vo = this.volunteer_userService.getVolunteer_user(volunteer_user);
				if(null!=vo&&vo.getVolunteer_ps().equals(volunteer_user.getVolunteer_ps())){
					ServletActionContext.getRequest().getSession().setAttribute("volUser", vo);
					return "goIndex";
				}else{
					this.addActionError("�û������������˻�δ���ͨ��");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				this.addActionError("�û������������˻�δ���ͨ��");
				e.printStackTrace();
			}

		}else if("1".equals(this.getSelect())){
			try {
				avo = this.getAdmin_tService().getAdmin_t(volunteer_user);
				if(avo!=null&&avo.getAdmin_ps().equals(volunteer_user.getVolunteer_ps())){
					ServletActionContext.getRequest().getSession().setAttribute("adminUser", avo);
					return "goAdmin";
				}else{
					this.addActionError("�û������������");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				this.addActionError("�û������������");
				e.printStackTrace();
			}
		}
	
		return "goLogin";
	}
	/**
	 * ���־Ը����Ϣ
	 * �������ҳ�� ���������е�־Ը����Ϣ Ȼ����ת��ҳ��
	 * ��־Ը����Ϣ�ı�־λ�޸� ��־Ը����Ϣ���޸�
	 * ��Ϊ 0 1����״̬ 0Ϊδ��� ���ܵ�¼ 1Ϊ���ͨ��
	 * @return
	 */
	public String checkUser(){
		try {
			userList = this.getVolunteer_userService().queryAll();
			System.out.println(userList.toString());
			return "goCheckUser";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("��ѯ����user����", null);
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ����ǰ̨�ύ��ѧ�ź�ѧԺ��ѯѧ����Ϣ
	 * @return
	 */
	public String queryForData(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String volunteer_s = null;
		String volunteer_stuid = null;
		try {
			if(StringUtils.isNotEmpty(request.getParameter("volunteer_s")))volunteer_s = new String(request.getParameter("volunteer_s").getBytes("iso-8859-1"), "utf-8");
			if(StringUtils.isNotEmpty(request.getParameter("volunteer_stuid")))volunteer_stuid = new String(request.getParameter("volunteer_stuid").getBytes("iso-8859-1"), "utf-8");
			
			userList = this.getVolunteer_userService().queryForData(volunteer_s,volunteer_stuid);
			return "goCheckUserPage";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * ҳ�洫����uid
	 * ���ͨ����ť
	 * @return
	 */
	public String confirmUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer volunteer_uid = null;
		if(request.getParameter("volunteer_uid")!=null) volunteer_uid = Integer.valueOf(request.getParameter("volunteer_uid"));
		//ִ�и���״̬λ
		try {
			this.getVolunteer_userService().updateUserStatus(volunteer_uid);
			return "goQueryUser";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ����༭ҳ��
	 * ׼���ñ��༭������
	 * �����ݿ��б�������
	 * @return
	 */
	public String goEditUser(){
		Integer volunteer_uid =null;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("��������ֵ��"+request.getParameter("volunteer_uid"));
		try {
			if(request.getParameter("volunteer_uid")!=null)volunteer_uid = Integer.valueOf(request.getParameter("volunteer_uid"));
			userList = this.getVolunteer_userService().queryForUid(volunteer_uid);
			return "editUser";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ���±༭ҳ�������������
	 * @return
	 */
	public String doUpdateUser(){
		try {
			this.getVolunteer_userService().updateUser(volunteer_user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ɾ��������¼
	 * @return
	 */
	public String delUser(){
		System.out.println("ɾ���ķ�������");
		HttpServletRequest request = ServletActionContext.getRequest();
		String [] uids = request.getParameterValues("uid");
		try {
			this.getVolunteer_userService().delUserForId(uids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��̨��
	 * ־Ը�߱�������
	 * 	SELECT
			v.*, a.*, r.volunteer_rec_date
		FROM
			(volunteer v ,volunteer_act a ,volunteer_rec r)
		WHERE
			v.volunteer_stuid = r.volunteer_rec_vid
			AND a.volunteer_act_uid = r.volunteer_rec_aid;
	 * @return
	 */
	public String userForAct(){
		
		try {
			voList = this.volunteer_userService.queryVAAll(null);
			
			for (volunteerVO volunteer_user : voList) {
				System.out.println(volunteer_user.toString());
			}
			//ѹ��ֵջ
			ActionContext.getContext().getValueStack().set("voList", voList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adminVA";
	}
	
	/**
	 * ��̨
	 * ־Ը�߱��� ����ѯ
	 * @return
	 */
	public String queryByVa(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		try {
			if(!select_type.equals("null")){
				map.put(select_type, new String(select_data.getBytes("iso-8859-1"), "utf-8"));
				voList = this.volunteer_userService.queryVAAll(map);
			}else{
				voList = this.volunteer_userService.queryVAAll(null);
			}
			//ѹ��ֵջ
			ActionContext.getContext().getValueStack().set("voList", voList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adminVA";
	}
	
	/**
	 * ɾ��������VA
	 * @return
	 */
	public String delVA(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String [] uids = request.getParameterValues("uid");
		try {
			if(this.getVolunteer_userService().delVAForUid(uids).equals(uids.length)){
				response.getWriter().write("{\"success\":true}");
			}else{
				response.getWriter().write("{\"success\":false}");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	/**
	 * ǰ̨��
	 * ��ת��������Ϣҳ��
	 * ���Ȼ�ø��˵�������Ϣ
	 * Ȼ���ڸ�����Ϣҳ���������
	 * ������ǰ��¼��Ϣ �Լ� ��������
	 * @return
	 */
	public String goInfo(){
		
		//��session�������õ�ǰ��½����
		volunteer_user = (Volunteer_user) ServletActionContext.getRequest().getSession().getAttribute("volUser");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("v.volunteer_stuid", volunteer_user.getVolunteer_stuid());
		try {
			voList = this.getVolunteer_userService().queryVAAll(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Info";
	}
	
	/**
	 * �����ҳ��
	 * չʾ��ǰδ�����Ļ
	 * ��Ĳ����Լ�����
	 * @return
	 */
	public String goUserForAct(){
		//��session�������õ�ǰ��½����
		volunteer_user = (Volunteer_user) ServletActionContext.getRequest().getSession().getAttribute("volUser");
		try {
			act_List = this.getVolunteer_userService().queryByStuid(volunteer_user.getVolunteer_stuid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "userForAct";
	}
	
	public String goIndex(){
		return "goIndex";
	}
}
