package cn.itcat.volunteer.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcat.volunteer.admin.service.Admin_tService;
import cn.itcat.volunteer.admin.vo.Admin_t;
import cn.itcat.volunteer.user.vo.Volunteer_act;


/**
 * 管理员表Action
 * @author IceTea
 *
 */
public class Admin_tAction extends ActionSupport implements ModelDriven<Admin_t>{

	//注入实体类admin_t
	private Admin_t admin_t = new Admin_t();
	
	//注入事务层
	private Admin_tService admin_tService = new Admin_tService();
	//注入act的list  当时好蠢啊 不应该这么写的 写的好混乱的
	private List<Volunteer_act> actList;
	//注入admin_t表的list
	private List<Admin_t> admintList;
	
	//活动信息标志位
	private Integer status;
	//编辑和添加的标志位
	private Integer editOrAdd;
	//查询类型
	private String select_type;
	//查询的数据
	private String select_data;

	
	public String getSelect_type() {
		return select_type;
	}

	public void setSelect_type(String select_type) {
		this.select_type = select_type;
	}

	public String getSelect_data() {
		return select_data;
	}

	public void setSelect_data(String select_data) {
		this.select_data = select_data;
	}

	public List<Admin_t> getAdmintList() {
		return admintList;
	}

	public void setAdmintList(List<Admin_t> admintList) {
		this.admintList = admintList;
	}

	public void setActList(List<Volunteer_act> actList) {
		this.actList = actList;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEditOrAdd() {
		return editOrAdd;
	}

	public void setEditOrAdd(Integer editOrAdd) {
		this.editOrAdd = editOrAdd;
	}

	public Integer getStatus() {
		return status;
	}

	public List<Volunteer_act> getActList() {
		return actList;
	}

	@Override
	public Admin_t getModel() {
		// TODO Auto-generated method stub
		return admin_t;
	}

	public Admin_t getAdmin_t() {
		return admin_t;
	}

	public void setAdmin_t(Admin_t admin_t) {
		this.admin_t = admin_t;
	}

	public Admin_tService getAdmin_tService() {
		return admin_tService;
	}

	public void setAdmin_tService(Admin_tService admin_tService) {
		this.admin_tService = admin_tService;
	}
	/**
	 * 从Volunteer_userAction传过来
	 * 登录后台的主页操作
	 * @return
	 */
	public String systemLogin(){
		Admin_t nowAdmin = (Admin_t) ServletActionContext.getRequest().getSession().getAttribute("adminUser");
		System.out.println("当前登录用户"+nowAdmin.toString());
		/**
		 * 主页数据的一些准备
		 */
//		ServletActionContext.getRequest().getSession().setAttribute("adminUser", vo);
		return "goAdminIndex";
		
	}
	
	/**
	 * 退出登录
	 * @return
	 */
	public String quit(){
		//用户session销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "goLogin";
		
	}
	/**
	 * 活动信息find
	 */
	public String act(){
		HttpServletRequest request= ServletActionContext.getRequest();
		//得到前台的标志位flag选择进行查询并且返回的数据是什么
		status = Integer.valueOf(request.getParameter("flag"));
		//准备下数据 VOLUNTEER_ACT
		try {
			actList = this.getAdmin_tService().find(status);
			return "goAct";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error("查询VOLUNTEER_ACT出错");
		}
		return "goAct";
		
	}
	/**
	 * 跳转到增加活动信息窗口
	 * @return
	 */
	public String addAct(){
		editOrAdd = 0;
		return "goAddActWin";
	}
	
	/**
	 * 遍历所有的管理员 或者传参find相关的值
	 * 返回页面到CURD ADmin
	 * @return
	 */
	public String curdAdmint(){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
		if(select_type!=null&&!"null".equals(select_type)&&select_data!=null){
			map.put(select_type, new String(select_data.getBytes("iso-8859-1"), "utf-8"));
		}else{
			map=null;
		}
			admintList = this.getAdmin_tService().findAdmint(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "admin_t";
	}

	/**
	 * 进入添加管理员信息弹窗
	 * @return
	 */
	public String addAdmint(){
		
		//添加的
		editOrAdd = 0;
		return "addAdmint";
	}
	/**
	 * 进入修改管理员信息弹窗
	 * @return
	 */
	public String editAdmint(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer admin_uid = Integer.valueOf(request.getParameter("admin_uid"));
		try {
			admintList = this.admin_tService.findById(admin_uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//修改的
		editOrAdd = 1;
		return "addAdmint";
	}
	
	/**
	 * 添加或者保存表单admin_t
	 * @return
	 */
	public String SOUAdmint(){
		
		try {
			this.getAdmin_tService().SOUAdmint(admin_t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String delAdmint(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String [] uids = request.getParameterValues("uid");
		try {
			if(this.getAdmin_tService().delTByUids(uids).equals(uids.length)){
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
}
