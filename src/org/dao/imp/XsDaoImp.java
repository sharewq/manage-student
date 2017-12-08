package org.dao.imp;
import java.util.List;
import org.dao.XsDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Xsb;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class XsDaoImp extends HibernateDaoSupport implements XsDao{
	public void delete(String xh) {
		getHibernateTemplate().delete(find(xh));
	}
	public Xsb find(String xh) {
		List list=getHibernateTemplate().find("from Xsb where xh=?",xh);
		if(list.size()>0)
			return (Xsb)list.get(0);
		else
			return null;
	}
	public List findAll(final int pageNow, final int pageSize) {
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback(){
	            int size=pageNow*pageSize-pageSize;
	            public Object doInHibernate(Session session)throws HibernateException{
	            	Query query=session.createQuery("from Xsb order by xh");
	            	query.setFirstResult(size);
	            	query.setMaxResults(pageSize);
	            	List l = query.list();
	            	return l;
		        }
		    });//内部类，返回一个List
		     return list;
	}
	public int findXsSize() {
		return getHibernateTemplate().find("from Xsb").size();
	}
	public void save(Xsb xs) {
		getHibernateTemplate().save(xs);
	}
	public void update(Xsb xs) {
		getHibernateTemplate().update(xs);
	}

}
