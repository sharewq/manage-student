package org.service.imp;

import java.util.List;

import org.dao.CjDao;
import org.dao.KcDao;
import org.model.Kcb;
import org.service.KcService;

public class KcServiceManage implements KcService {
	private KcDao kcDao;
	private CjDao cjDao;
	public void setKcDao(KcDao kcDao) {
		this.kcDao = kcDao;
	}
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}
	public void delete(String kch) {
		kcDao.delete(kch);
		cjDao.deleteOneKcInfo(kch);
	}
	public Kcb find(String kch) {
		return kcDao.find(kch);
	}
	public List findAll(int pageNow, int pageSize) {
		return kcDao.findAll(pageNow, pageSize);
	}
	public int findKcSize() {
		return kcDao.findKcSize();
	}
	public void save(Kcb kc) {
		kcDao.save(kc);
	}
	public void update(Kcb kc) {
		kcDao.update(kc);
	}
}
