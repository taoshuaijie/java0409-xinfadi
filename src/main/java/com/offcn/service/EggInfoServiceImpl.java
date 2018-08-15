package com.offcn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.bean.EggInfo;
import com.offcn.dao.EggInfoDao;

@Service
public class EggInfoServiceImpl implements EggInfoService {
	
	@Autowired
	EggInfoDao eDao;
	
	
	public void save(EggInfo egg) {
		eDao.save(egg);
	}


	public List<EggInfo> getlist(String beginDate, String endDate) {
		List<EggInfo> elist = eDao.getlist(beginDate, endDate);
		return elist;
	}


}
