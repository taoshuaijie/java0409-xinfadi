package com.offcn;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.offcn.bean.EggInfo;
import com.offcn.dao.EggInfoDao;
import com.offcn.service.EggInfoService;
import com.offcn.service.EggInfoServiceImpl;

public class CatUrlHtml {

public static void main(String[] args) throws Exception {
		//**********
		CatUrlHtml cuh = new CatUrlHtml();
		cuh.catEgg();
	}

	public void catEgg() throws Exception {
		String url = "";
		for (int i = 1; i <= 100; i++) {
			url = "http://www.xinfadi.com.cn/marketanalysis/3/list/" + i + ".shtml";

			String html = catUrlHtml(url);
			// System.out.println(html);
			List<EggInfo> egglist = parseHtml(html);
			for (EggInfo eggInfo : egglist) {
				System.out.println(eggInfo);
			}
		}
	}



	//1、获取html页面
	public static String catUrlHtml(String url) throws Exception, Exception{
		String html="";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse res = client.execute(get);
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
		
		if(res.getStatusLine().getStatusCode()==200){
			HttpEntity entity = res.getEntity();
			html = EntityUtils.toString(entity,"UTF-8");
			EntityUtils.consume(entity);
			
		}else{
			System.out.println("请求失败，错误码："+res.getStatusLine().getStatusCode());
		}
		client.close();
		
		return html;
	}
	
	//2、解析html
	public static List<EggInfo> parseHtml(String html) throws Exception{
		
		List<EggInfo> list=new ArrayList<EggInfo>();
		Document doc = Jsoup.parse(html);
		Element table = doc.select(".hq_table").first();
		
		//得到class=hq_table的table下所有的tr标签
		Elements trs = table.select("tr");
		int size = trs.size();
		for (int i = 0; i < size; i++) {
			
			Element tr = trs.get(i);
			//System.out.println(tr.text());
			
			Elements tds = tr.select("td");
			String temp="";
			for (Element td : tds) {
				temp+=td.text()+"--";
			}
			//System.out.println(temp);
			//除去第一个tr标签是标题外，其他封装到bean里
			if(i!=0){
				String[] goods = temp.split("--");
				//System.out.println(Arrays.toString(goods)+goods[0]);
				if(goods[0].equals("猪板油")){
					//System.out.println(Arrays.toString(goods));
					EggInfo egg = new EggInfo();
					egg.setName(goods[0]);
					egg.setMinPrice(Double.parseDouble(goods[1]));
					egg.setAvgPrice(Double.parseDouble(goods[2]));
					egg.setMaxPrice(Double.parseDouble(goods[3]));
					egg.setStandard(goods[4]);
					egg.setUnit(goods[5]);
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(goods[6]);
					egg.setPubDate(date);
					
					list.add(egg);
				}
				
			}
			
			
		}
		
		
		return list;
	}
}
