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
 * 用户Action
 * @author WZH_GYY
 *
 */

public class Volunteer_userAction extends ActionSupport implements ModelDriven<Volunteer_user>{
	//模型驱动用到的类
	private Volunteer_user volunteer_user = new Volunteer_user();
	//志愿者的Service注入
	private Volunteer_userService volunteer_userService;
	//管理员的service注入
	private  Admin_tService admin_tService;
	//是否是管理员志愿者
	private String select;
	//user遍历集合
	private List<Volunteer_user> userList;
	//传给页面的用户对象
	private List<volunteerVO> voList;
	//页面过来的查询类型
	private String select_type;
	//页面过来的查询数据
	private String select_data;
	//传给页面的活动信息
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
	 * 到注册页面
	 * @return
	 */
	public String goRegistPage() {
		return "registPage";
		
	}
	/**
	 * 处理前台返回注册的数据
	 * @return
	 */
	public String doRegist(){
		
		this.volunteer_userService.save(volunteer_user);
		//把登录对象传给session
		//ServletActionContext.getRequest().getSession().setAttribute("existUser", volunteer_user);
		return "goLogin";
		
	}

	/**
	 * 处理登录
	 * @return
	 */
	public String doLogin(){
		System.out.println("登录信息++++++++++"+volunteer_user.toString());
		System.out.println(this.getSelect());
		
		/**
		 * 两种情况 第一种为志愿者  0
		 * 第二种是管理员 1
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
					this.addActionError("用户名密码错误或账户未审核通过");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				this.addActionError("用户名密码错误或账户未审核通过");
				e.printStackTrace();
			}

		}else if("1".equals(this.getSelect())){
			try {
				avo = this.getAdmin_tService().getAdmin_t(volunteer_user);
				if(avo!=null&&avo.getAdmin_ps().equals(volunteer_user.getVolunteer_ps())){
					ServletActionContext.getRequest().getSession().setAttribute("adminUser", avo);
					return "goAdmin";
				}else{
					this.addActionError("用户名或密码错误");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				this.addActionError("用户名或密码错误");
				e.printStackTrace();
			}
		}
	
		return "goLogin";
	}
	/**
	 * 审核志愿者信息
	 * 进入审核页面 遍历出所有的志愿者信息 然后跳转到页面
	 * 对志愿者信息的标志位修改 对志愿者信息的修改
	 * 分为 0 1两种状态 0为未审核 不能登录 1为审核通过
	 * @return
	 */
	public String checkUser(){
		try {
			userList = this.getVolunteer_userService().queryAll();
			System.out.println(userList.toString());
			return "goCheckUser";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("查询所有user出错", null);
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 根据前台提交的学号和学院查询学生信息
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
	 * 页面传参是uid
	 * 审核通过按钮
	 * @return
	 */
	public String confirmUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer volunteer_uid = null;
		if(request.getParameter("volunteer_uid")!=null) volunteer_uid = Integer.valueOf(request.getParameter("volunteer_uid"));
		//执行更新状态位
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
	 * 进入编辑页面
	 * 准备好被编辑的数据
	 * 从数据库中遍历出来
	 * @return
	 */
	public String goEditUser(){
		Integer volunteer_uid =null;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println("带过来的值是"+request.getParameter("volunteer_uid"));
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
	 * 更新编辑页面带过来的数据
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
	 * 删除多条记录
	 * @return
	 */
	public String delUser(){
		System.out.println("删除的方法里面");
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
	 * 后台：
	 * 志愿者报名处理
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
			//压入值栈
			ActionContext.getContext().getValueStack().set("voList", voList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adminVA";
	}
	
	/**
	 * 后台
	 * 志愿者报名 ：查询
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
			//压入值栈
			ActionContext.getContext().getValueStack().set("voList", voList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adminVA";
	}
	
	/**
	 * 删除多条的VA
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
	 * 前台：
	 * 跳转到个人信息页面
	 * 首先获得个人的所有信息
	 * 然后在个人信息页面遍历出来
	 * 包含当前登录信息 以及 活动报名情况
	 * @return
	 */
	public String goInfo(){
		
		//在session域里面拿当前登陆对象
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
	 * 活动报名页面
	 * 展示当前未报名的活动
	 * 活动的查找以及报名
	 * @return
	 */
	public String goUserForAct(){
		//在session域里面拿当前登陆对象
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
