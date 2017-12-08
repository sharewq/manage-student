package org.dao.imp;
import java.util.List;
import org.dao.CjDao;
import org.hibernate.*;
import org.model.Cjb;
import org.model.CjbId;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class CjDaoImp extends HibernateDaoSupport implements CjDao{
	public void deleteCj(String xh, String kch) {
		getHibernateTemplate().delete(getXsCj(xh, kch));
	}
	public void deleteOneKcInfo(String kch) {
		getHibernateTemplate().deleteAll(this.getKcCjList(kch));
	}

	public void deleteOneXsCj(String xh) {
		getHibernateTemplate().deleteAll(getXsCjList(xh));
	}
	public List findAllCj(int pageNow, int pageSize) {
		Session session=getHibernateTemplate().getSessionFactory().openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("select c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch from Xsb a,Kcb b,Cjb c where a.xh=c.id.xh and b.kch=c.id.kch");
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}
	public int findCjSize() {
		return getHibernateTemplate().find("from Cjb").size();
	}
	public List getKcCjList(String kch) {
		return getHibernateTemplate().find("from Cjb where kch=?",kch);
	}
	public List getXsCjList(String xh) {
		return getHibernateTemplate().find("select c.id.xh,a.xm,b.kcm,c.cj,c.xf from Xsb a,Kcb b,Cjb c where c.id.xh=? and a.xh=c.id.xh and b.kch=c.id.kch",xh);
	}
	public Cjb getXsCj(String xh, String kch) {
		CjbId cjbId=new CjbId();
		cjbId.setXh(xh);
		cjbId.setKch(kch);
		return (Cjb)getHibernateTemplate().get(Cjb.class, cjbId);
	}
	public void saveorupdateCj(Cjb cj) {
		getHibernateTemplate().saveOrUpdate(cj);
	}

}
