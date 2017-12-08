package org.dao;
import java.util.List;
import org.model.Xsb;
public interface XsDao {
	//插入学生
	public void save(Xsb xs);
	//根据学号删除学生
	public void delete(String xh);
	//修改学生信息
	public void update(Xsb xs);
	//根据学号查询学生信息
	public Xsb find(String xh);
	//分页显示学生信息
	public List findAll(int pageNow,int pageSize);
	//查询一共多少条学生记录
	public int findXsSize();
}
