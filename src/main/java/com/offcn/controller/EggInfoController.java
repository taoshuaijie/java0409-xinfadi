package com.offcn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.CatUrlHtml;
import com.offcn.bean.EggInfo;
import com.offcn.service.EggInfoService;

@Controller
public class EggInfoController {
	@Autowired
	EggInfoService eService;
	
	@RequestMapping("save")
	public void save(EggInfo egg,HttpServletResponse response) {
		String url = "";
		for (int i = 1; i <= 100; i++) {
			url = "http://www.xinfadi.com.cn/marketanalysis/3/list/" + i + ".shtml";
			try {
				String html = CatUrlHtml.catUrlHtml(url);
				List<EggInfo> egglist = CatUrlHtml.parseHtml(html);

				for (EggInfo eggInfo : egglist) {
					eService.save(eggInfo);
					response.getWriter().write(eggInfo.toString());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("getlist")
	@ResponseBody
	public List<EggInfo> getlist(String beginDate, String endDate) {
		List<EggInfo> elist = eService.getlist(beginDate, endDate);
		return elist;
	}
	
	@RequestMapping("quxian")
	public String test(){
		
		return "quxian";
	}
	
	
}
