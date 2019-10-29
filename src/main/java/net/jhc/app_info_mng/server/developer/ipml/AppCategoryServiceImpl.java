package net.jhc.app_info_mng.server.developer.ipml;

import net.jhc.app_info_mng.dao.AppCategoryMapper;
import net.jhc.app_info_mng.pojo.AppCategory;
import net.jhc.app_info_mng.server.developer.AppCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getAppCategoryListByParentId(parentId);
	}

}
