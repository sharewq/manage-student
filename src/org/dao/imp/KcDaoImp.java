package org.dao.imp;
import java.util.List;
import org.dao.KcDao;
import org.hibernate.*;
import org.model.Kcb;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class KcDaoImp extends HibernateDaoSupport implements KcDao{

	public void delete(String kch) {
		getHibernateTemplate().delete(find(kch));
	}
	public Kcb find(String kch) {
		List list=getHibernateTemplate().find("from Kcb where kch=?",kch);
		if(list.size()>0)
			return (Kcb)list.get(0);
		else
			return null;
	}
	public List findAll(final int pageNow, final int pageSize) {
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback(){
	            int size=pageNow*pageSize-pageSize;
	            public Object doInHibernate(Session session)throws HibernateException{
	            	Query query=session.createQuery("from Kcb order by kch");
	            	query.setFirstResult(size);
	            	query.setMaxResults(pageSize);
	            	List l = query.list();
	            	return l;
		        }
		    });//内部类，返回一个List
		     return list;
	}
	public int findKcSize() {
		return getHibernateTemplate().find("from Kcb").size();
	}
	public void save(Kcb kc) {
		getHibernateTemplate().save(kc);
	}
	public void update(Kcb kc) {
		getHibernateTemplate().update(kc);
	}
}
