package cn.itcat.volunteer.index.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳAction
 * @author admin
 *
 */

public class IndexAction extends ActionSupport{

	/**
	 * 
	 * ȥ��ҳ execute��Ĭ�ϲ���
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("ȥ��ҳ�ȵ�¼");
		return "goLogin";
	}
	
	
	
}
