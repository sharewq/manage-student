package org.action;
import java.util.List;
import java.util.Map;
import org.model.Kcb;
import org.service.KcService;
import org.tool.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class KcAction extends ActionSupport {
	private int pageNow=1;
	private int pageSize=8;
	private Kcb kc;
	private KcService kcService;
	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Kcb getKc() {
		return kc;
	}
	public void setKc(Kcb kc) {
		this.kc = kc;
	}
	public String kcInfo()throws Exception{
		List list=kcService.findAll(pageNow, pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		System.out.println("totleSize:"+kcService.findKcSize());
		Pager page=new Pager(pageNow,kcService.findKcSize());
		System.out.println("totlePage:"+page.getTotalPage());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	 public String findKc()throws Exception{
		 String kch=kc.getKch();
		 Kcb kc2=kcService.find(kch);
		 Map request=(Map)ActionContext.getContext().get("request");
		 request.put("kc", kc2);
		 if(kc2!=null){
			 return SUCCESS;
		 }else {
			 return ERROR;
		 }
	 }
	 public String deleteKc() throws Exception{
			String kch=kc.getKch();
			Map request=(Map)ActionContext.getContext().get("request");
			kcService.delete(kch);
			return SUCCESS;
		}
	 public String addKc()throws Exception{
		 Kcb kc1=new Kcb();
		 kc1.setKch(kc.getKch());
		 kc1.setKcm(kc.getKcm());
		 kc1.setXf(kc.getXf());
		 kc1.setKxxq(kc.getKxxq());
		 kc1.setXs(kc.getXs());
		 Map request=(Map)ActionContext.getContext().get("request");
		 kcService.save(kc1);
		 return SUCCESS;
	 }
	 public String updateKcView()throws Exception{
		 String kch=kc.getKch();
		 Kcb kcInfo=kcService.find(kch);
		 Map request=(Map)ActionContext.getContext().get("request");
		 request.put("kcInfo", kcInfo);
		 return SUCCESS;
	 }
	 public String updateKc()throws Exception{
		 Kcb kc3=kcService.find(kc.getKch());
		 kc3.setKcm(kc.getKcm());
		 kc3.setXf(kc.getXf());
		 kc3.setKxxq(kc.getKxxq());
		 kc3.setXs(kc.getXs());
		 Map request=(Map)ActionContext.getContext().get("request");
		 kcService.update(kc3);
		 return SUCCESS;
	 }
	public void setKcService(KcService kcService) {
		this.kcService = kcService;
	}
}
