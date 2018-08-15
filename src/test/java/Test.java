

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.bean.EggInfo;
import com.offcn.dao.EggInfoDao;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		
		EggInfoDao egg = ac.getBean(EggInfoDao.class);
		EggInfo eggInfo = new EggInfo();
		eggInfo.setName("egg");
		eggInfo.setMinPrice(10);
		eggInfo.setAvgPrice(11);
		eggInfo.setMaxPrice(12);
		eggInfo.setStandard("nomal");
		eggInfo.setUnit("kg");
		eggInfo.setPubDate(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-12"));
		egg.save(eggInfo);
	}
	
	

}
