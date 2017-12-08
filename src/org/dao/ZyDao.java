package org.dao;
import java.util.List;
import org.model.Zyb;
public interface ZyDao {
	//插入专业信息
	public void save(Zyb zy);
	//根据专业Id查找专业信息
	public Zyb getOneZy(int zyId);
	//查找所有专业信息
	public List getAll();
}
