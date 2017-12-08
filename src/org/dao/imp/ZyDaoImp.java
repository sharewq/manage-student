package org.dao.imp;
import java.util.List;
import org.dao.ZyDao;
import org.model.Zyb;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class ZyDaoImp extends HibernateDaoSupport implements ZyDao{
	public List getAll() {
		return this.getHibernateTemplate().find("from Zyb");
	}
	public Zyb getOneZy(int zyId) {
		return (Zyb)getHibernateTemplate().find("from Zyb where id=?",zyId).get(0);
	}
	public void save(Zyb zy) {
		getHibernateTemplate().save(zy);
	}
}
