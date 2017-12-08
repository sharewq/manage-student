package org.service.imp;

import java.util.List;

import org.dao.ZyDao;
import org.model.Zyb;

public class ZyServiceManage implements org.service.ZyService {
	//对ZyDao进行依赖注入
	private ZyDao zyDao;
	public void setZyDao(ZyDao zyDao) {
		this.zyDao = zyDao;
	}
	public List getAll() {
		return zyDao.getAll();
	}

	public Zyb getOneZy(int zyId) {
		return zyDao.getOneZy(zyId);
	}

	public void save(Zyb zy) {
		zyDao.save(zy);
	}
}
