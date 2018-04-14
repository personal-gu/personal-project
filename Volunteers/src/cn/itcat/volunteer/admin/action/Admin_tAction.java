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
 * ����Ա��Action
 * @author IceTea
 *
 */
public class Admin_tAction extends ActionSupport implements ModelDriven<Admin_t>{

	//ע��ʵ����admin_t
	private Admin_t admin_t = new Admin_t();
	
	//ע�������
	private Admin_tService admin_tService = new Admin_tService();
	//ע��act��list  ��ʱ�ô��� ��Ӧ����ôд�� д�ĺû��ҵ�
	private List<Volunteer_act> actList;
	//ע��admin_t���list
	private List<Admin_t> admintList;
	
	//���Ϣ��־λ
	private Integer status;
	//�༭����ӵı�־λ
	private Integer editOrAdd;
	//��ѯ����
	private String select_type;
	//��ѯ������
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
	 * ��Volunteer_userAction������
	 * ��¼��̨����ҳ����
	 * @return
	 */
	public String systemLogin(){
		Admin_t nowAdmin = (Admin_t) ServletActionContext.getRequest().getSession().getAttribute("adminUser");
		System.out.println("��ǰ��¼�û�"+nowAdmin.toString());
		/**
		 * ��ҳ���ݵ�һЩ׼��
		 */
//		ServletActionContext.getRequest().getSession().setAttribute("adminUser", vo);
		return "goAdminIndex";
		
	}
	
	/**
	 * �˳���¼
	 * @return
	 */
	public String quit(){
		//�û�session����
		ServletActionContext.getRequest().getSession().invalidate();
		return "goLogin";
		
	}
	/**
	 * ���Ϣfind
	 */
	public String act(){
		HttpServletRequest request= ServletActionContext.getRequest();
		//�õ�ǰ̨�ı�־λflagѡ����в�ѯ���ҷ��ص�������ʲô
		status = Integer.valueOf(request.getParameter("flag"));
		//׼�������� VOLUNTEER_ACT
		try {
			actList = this.getAdmin_tService().find(status);
			return "goAct";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error("��ѯVOLUNTEER_ACT����");
		}
		return "goAct";
		
	}
	/**
	 * ��ת�����ӻ��Ϣ����
	 * @return
	 */
	public String addAct(){
		editOrAdd = 0;
		return "goAddActWin";
	}
	
	/**
	 * �������еĹ���Ա ���ߴ���find��ص�ֵ
	 * ����ҳ�浽CURD ADmin
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
	 * ������ӹ���Ա��Ϣ����
	 * @return
	 */
	public String addAdmint(){
		
		//��ӵ�
		editOrAdd = 0;
		return "addAdmint";
	}
	/**
	 * �����޸Ĺ���Ա��Ϣ����
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
		//�޸ĵ�
		editOrAdd = 1;
		return "addAdmint";
	}
	
	/**
	 * ��ӻ��߱����admin_t
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
