package cn.itcat.volunteer.index.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 主页Action
 * @author admin
 *
 */

public class IndexAction extends ActionSupport{

	/**
	 * 
	 * 去主页 execute是默认参数
	 */
	@Override
	public String execute() throws Exception{
		System.out.println("去主页先登录");
		return "goLogin";
	}
	
	
	
}
