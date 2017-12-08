package org.action;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.model.Xsb;
import org.service.XsService;
import org.service.ZyService;
import org.tool.Pager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class XsAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=8;
	private File zpfile;
	//存放专业集合
	private List list;
	public void setList(List list) {
		this.list = list;
	}
	 public List getList(){
		 return zyService.getAll();//返回专业集合
	 }
	public File getZpfile() {
		return zpfile;
	}
	public void setZpfile(File zpfile) {
		this.zpfile = zpfile;
	}
	private Xsb xs;
	private XsService xsService;
	private ZyService zyService;
	public void setZyService(ZyService zyService) {
		this.zyService = zyService;
	}
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
	public String execute() throws Exception {
		System.out.println(this.getPageNow());
		List list=xsService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	public String addXs() throws Exception{
		if(xs.getXh()==null||"".equals(xs.getXh())){
			return ERROR;
		}
		Xsb stu=new Xsb();
		String xh1=xs.getXh();
		if(xsService.find(xh1)!=null){
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		System.out.println(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		stu.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		if(this.getZpfile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpfile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		
		xsService.save(stu);
		return SUCCESS;
	}
	public String deleteXs() throws Exception{
		String xh=xs.getXh();
		xsService.delete(xh);
		return SUCCESS;
	}
	 public String updateXsView()throws Exception{
		 String xh=xs.getXh();
		 Xsb xsInfo=xsService.find(xh);
		 List zys=zyService.getAll();
		 Map request=(Map)ActionContext.getContext().get("request");
		 request.put("xsInfo", xsInfo);
		 request.put("zys", zys);
		 return SUCCESS;
	 }
	 public String updateXs()throws Exception{
		 Xsb xs1=xsService.find(xs.getXh());
		 xs1.setXm(xs.getXm());
		 xs1.setXb(xs.getXb());
		 xs1.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		 xs1.setCssj(xs.getCssj());
		 xs1.setZxf(xs.getZxf());
		 xs1.setBz(xs.getBz());
		 if(this.getZpfile()!=null){
				FileInputStream fis=new FileInputStream(this.getZpfile());
				byte[] buffer=new byte[fis.available()];
				fis.read(buffer);
				xs1.setZp(buffer);
		}
		 Map request=(Map)ActionContext.getContext().get("request");
		 xsService.update(xs1);
		 return SUCCESS;
	 }
	 public String getImage() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		String xh=xs.getXh();
		Xsb xs3=xsService.find(xh);
		byte[] img = xs3.getZp();
		response.setContentType("image/jpeg");
		ServletOutputStream os = response.getOutputStream();
		if ( img != null && img.length != 0 )
		{
			for (int i = 0; i < img.length; i++)
			{
				os.write(img[i]);
			}
			os.flush();
		}
		 return NONE;
	 }
	 public String findXs()throws Exception{
		 String xh=xs.getXh();
		 Xsb stu2=xsService.find(xh);
		 Map request=(Map)ActionContext.getContext().get("request");
		 request.put("xs", stu2);
		 return SUCCESS;
	 }
	 public String addXsView()throws Exception{
		 return	SUCCESS;
	 }
	public Xsb getXs() {
		return xs;
	}
	public void setXs(Xsb xs) {
		this.xs = xs;
	}
	public XsService getXsService() {
		return xsService;
	}
	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}
}
