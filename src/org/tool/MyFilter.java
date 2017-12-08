package org.tool;

import java.util.Map;

import org.model.Dlb;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyFilter extends AbstractInterceptor{
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		Map session=arg0.getInvocationContext().getSession();
		Dlb user=(Dlb) session.get("user");	
		if(user==null){
			return Action.LOGIN;
		}
		return arg0.invoke();
	}
}
