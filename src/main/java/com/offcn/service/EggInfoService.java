package com.offcn.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.bean.EggInfo;

public interface EggInfoService {
	
	public void save(EggInfo egg);
	
	public List<EggInfo> getlist(@Param("beginDate") String beginDate,@Param("endDate") String endDate);
	
	
}
