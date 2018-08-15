

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.bean.EggInfo;
import com.offcn.service.EggInfoService;

public class Test_Service02 {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-service.xml","spring-dao.xml");

		EggInfoService egg = ac.getBean(EggInfoService.class);
		List<EggInfo> elist = egg.getlist("2018-02-02", "2018-09-09");
		for (EggInfo eggInfo : elist) {
			System.out.println(eggInfo);
		}

	}

}
