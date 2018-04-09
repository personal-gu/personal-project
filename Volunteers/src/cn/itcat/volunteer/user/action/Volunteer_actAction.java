package cn.itcat.volunteer.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcat.volunteer.user.service.Volunteer_actService;
import cn.itcat.volunteer.user.vo.Volunteer_act;


public class Volunteer_actAction  extends ActionSupport implements ModelDriven<Volunteer_act>{
	//模型驱动用到的类
	private Volunteer_act volunteer_act = new Volunteer_act();
	//service注入
	private Volunteer_actService volunteer_actService; 
	//页面标志位flag
	private Integer flag;
	private Integer status;
	//传给页面的actList
	List<Volunteer_act> actList;
	//编辑或者添加标志位
	private Integer editOrAdd;
	//查询类型
	private String select_type;
	//查询的数据
	private String select_data;
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
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
	public Integer getEditOrAdd() {
		return editOrAdd;
	}
	public void setEditOrAdd(Integer editOrAdd) {
		this.editOrAdd = editOrAdd;
	}
	public List<Volunteer_act> getActList() {
		return actList;
	}
	public void setActList(List<Volunteer_act> actList) {
		this.actList = actList;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Override
	public Volunteer_act getModel() {
		// TODO Auto-generated method stub
		return volunteer_act;
	}
	public Volunteer_act getVolunteer_act() {
		return volunteer_act;
	}
	public void setVolunteer_act(Volunteer_act volunteer_act) {
		this.volunteer_act = volunteer_act;
	}
	public Volunteer_actService getVolunteer_actService() {
		return volunteer_actService;
	}
	public void setVolunteer_actService(Volunteer_actService volunteer_actService) {
		this.volunteer_actService = volunteer_actService;
	}
	
	/**
	 * 前台
	 * 主页信息准备
	 * 查询活动表  日期在前三的信息
	 * 然后作为一个结果集显示在页面上
	 * @return
	 */
	public String init(){
		
		try {
			actList = this.getVolunteer_actService().findThree();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "goIndex";
	}
	/**
	 * 后台:添加活动信息
	 */
	public String doAddAct(){
		System.out.println("表单成功提交");
		/**
		 * 将提交过来的表单保存到数据库
		 */
		try {
			this.getVolunteer_actService().addAct(volunteer_act);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.isErrorEnabled();
		}
		return null;
	}
	
	/**
	 * 刷新查询部分区域
	 */
	public String queryForFlag(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			flag = Integer.valueOf(request.getParameter("flag"));
			actList = this.getVolunteer_actService().queryForParameter("Volunteer_act_status",flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajax";
	}
	
	/**
	 * 后台：修改活动信息
	 * 弹出层页面准备
	 * @return
	 */
	public String editAct(){
		HttpServletRequest request = ServletActionContext.getRequest();
		editOrAdd = 1;
		try {
			Integer volunteer_act_uid = Integer.valueOf(request.getParameter("Volunteer_act_uid"));
			List<Volunteer_act> newList = this.getVolunteer_actService().queryForParameter("Volunteer_act_uid",volunteer_act_uid);
			System.out.println(newList.size());
			if(newList.size()==1)actList=newList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "goEditActWin";
	}

	/**
	 * 后台：批量删除操作
	 * @return
	 */
	public String delAct(){
		System.out.println("在删除操作之下了");
		//Map<String,Object> result = new HashMap<String,Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			String [] uids = request.getParameterValues("uid");
			Integer temp = this.getVolunteer_actService().delForUids(uids);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "delActAjax";
	}
	/**
	 * 后台：根据关键字查询
	 * @return
	 */
	public String queryForData(){
		//查询类型
		 
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String select_type = request.getParameter("Type");*/
		
		try {
			/*String select_data = new String(request.getParameter("selectData").getBytes("iso-8859-1"), "utf-8");
			System.out.println(select_type+select_data);
			actList = null;*/
			status=flag;
			actList = this.getVolunteer_actService().queryAll(select_type,new String(select_data.getBytes("iso-8859-1"),"utf-8"),status);
			
			for (Volunteer_act volunteer_act : actList) {
				System.out.println(volunteer_act.toString());
			}
			return "goAdminAct";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 测试upload的上传
	 * @return
	 */
	public String testUpload(){
		System.out.println("在测试环境中");
		HttpServletRequest request = ServletActionContext.getRequest();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        final MultipartFile imgfile = multipartRequest.getFile("Filedata");
        System.out.println();
		return null;
	}
}
