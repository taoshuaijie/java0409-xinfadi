import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.bean.EggInfo;
import com.offcn.controller.EggInfoController;
import com.offcn.service.EggInfoService;

public class TestController {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-service.xml","spring-dao.xml","spring-mvc.xml");
		EggInfoController eService = ac.getBean(EggInfoController.class);
		EggInfo eggInfo = new EggInfo();
		eggInfo.setName("egg");
		eggInfo.setMinPrice(10);
		eggInfo.setAvgPrice(11);
		eggInfo.setMaxPrice(16);
		eggInfo.setStandard("nomal");
		eggInfo.setUnit("kg");
		eggInfo.setPubDate(new Date());
		//eService.save(eggInfo);
		
	}
}
