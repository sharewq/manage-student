package org.action;
import java.util.Map;

import org.model.Dlb;
import org.service.DlService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class DlAction extends ActionSupport{
	private DlService dlService;
	private Dlb dl;
	public Dlb getDl() {
		return dl;
	}
	public void setDl(Dlb dl) {
		this.dl = dl;
	}
	public DlService getDlService() {
		return dlService;
	}
	public void setDlService(DlService dlService) {
		this.dlService = dlService;
	}
	public String execute()throws Exception{
		Dlb user=dlService.find(dl.getXh(), dl.getKl());
		if(user!=null){
			Map session=(Map)ActionContext.getContext().getSession();
			session.put("user", user);
			return SUCCESS;
		}else
			return ERROR;
	}
}
