package org.dao;
import java.util.List;
import org.model.Dlb;
public interface DlDao {
	//插入用户
	public void save(Dlb user);
	//根据学号和口令查找
	public Dlb find(String xh,String kl);
	//是否存在该学号的用户
	public boolean existXh(String xh);
}
