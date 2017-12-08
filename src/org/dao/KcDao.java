package org.dao;
import java.util.List;
import org.model.Kcb;
public interface KcDao {
	//插入课程信息
	public void save(Kcb kc);
	//根据课程号删除课程信息
	public void delete(String kch);
	//修改课程信息
	public void update(Kcb kc);
	//根据课程号查找课程信息
	public Kcb find(String kch);
	//分页显示课程信息
	public List findAll(int pageNow,int pageSize);
	//查询一共多少条课程记录
	public int findKcSize();
}
