package net.jhc.app_info_mng.server.developer.ipml;

import net.jhc.app_info_mng.dao.DataDictionaryMapper;
import net.jhc.app_info_mng.pojo.DataDictionary;
import net.jhc.app_info_mng.server.developer.DataDictionaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryMapper mapper;
	
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.getDataDictionaryList(typeCode);
	}

}
