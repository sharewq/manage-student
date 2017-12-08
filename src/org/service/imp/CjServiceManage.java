package org.service.imp;
import java.util.List;
import org.dao.CjDao;
import org.model.Cjb;
import org.service.CjService;
public class CjServiceManage implements CjService {
	//对CjDao进行依赖注入
	private CjDao cjDao;
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}
	public void deleteCj(String xh, String kch) {
		cjDao.deleteCj(xh, kch);
	}
	public void deleteOneKcInfo(String kch) {
		cjDao.deleteOneKcInfo(kch);
	}
	public void deleteOneXsCj(String xh) {
		cjDao.deleteOneXsCj(xh);
	}
	public List findAllCj(int pageNow, int pageSize) {
		return cjDao.findAllCj(pageNow, pageSize);
	}
	public int findCjSize() {
		return cjDao.findCjSize();
	}
	public List getKcCjList(String kch) {
		return cjDao.getKcCjList(kch);
	}
	public Cjb getXsCj(String xh, String kch) {
		return cjDao.getXsCj(xh, kch);
	}
	public List getXsCjList(String xh) {
		return cjDao.getXsCjList(xh);
	}
	public void saveorupdateCj(Cjb cj) {
		cjDao.saveorupdateCj(cj);
	}
}
