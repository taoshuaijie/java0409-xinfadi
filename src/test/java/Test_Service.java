

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.bean.EggInfo;
import com.offcn.service.EggInfoService;

public class Test_Service {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-service.xml","spring-dao.xml");
		EggInfoService eService = ac.getBean(EggInfoService.class);
		EggInfo eggInfo = new EggInfo();
		eggInfo.setName("egg");
		eggInfo.setMinPrice(10);
		eggInfo.setAvgPrice(11);
		eggInfo.setMaxPrice(12);
		eggInfo.setStandard("nomal");
		eggInfo.setUnit("kg");
		eggInfo.setPubDate(new Date());
		eService.save(eggInfo);
		
		
		
		
		
		
	}
}
