package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode)throws Exception;
}
