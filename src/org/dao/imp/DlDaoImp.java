package org.dao.imp;
import java.util.List;

import org.dao.DlDao;
import org.model.Dlb;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class DlDaoImp extends HibernateDaoSupport implements DlDao{
	public boolean existXh(String xh) {
		List list=getHibernateTemplate().find("from Dlb where xh=?",xh);
		if(list.size()>0)
			return true;
		else 
			return false;
	}
	public Dlb find(String xh, String kl) {
		String str[]={xh,kl};
		List list=getHibernateTemplate().find("from Dlb where xh=? and kl=?",str);
		if(list.size()>0)
			return (Dlb) list.get(0);
		else
			return null;
	}
	public void save(Dlb user) {
		getHibernateTemplate().save(user);
	}
}
