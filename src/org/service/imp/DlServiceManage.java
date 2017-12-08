package org.service.imp;
import org.dao.DlDao;
import org.model.Dlb;
import org.service.DlService;
public class DlServiceManage implements DlService{
	//对DlDao进行依赖注入
	private DlDao dlDao;
	public void setDlDao(DlDao dlDao) {
		this.dlDao = dlDao;
	}
	public boolean existXh(String xh) {
		return dlDao.existXh(xh);
	}
	public Dlb find(String xh, String kl) {
		return dlDao.find(xh, kl);
	}
	public void save(Dlb user) {
		dlDao.save(user);
	}
}
