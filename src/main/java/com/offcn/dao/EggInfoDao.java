package com.offcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.offcn.bean.EggInfo;


public interface EggInfoDao {
	
	public void save(EggInfo egg);
	
	public List<EggInfo> getlist(@Param("beginDate") String beginDate,@Param("endDate") String endDate);
	
}
