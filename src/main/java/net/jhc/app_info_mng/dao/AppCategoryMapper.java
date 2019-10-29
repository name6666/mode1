package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId)throws Exception;
}
