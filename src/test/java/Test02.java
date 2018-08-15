

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.bean.EggInfo;
import com.offcn.dao.EggInfoDao;

public class Test02 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		EggInfoDao egg = ac.getBean(EggInfoDao.class);
		List<EggInfo> elist = egg.getlist("2018-02-02", "2018-09-09");
		for (EggInfo eggInfo : elist) {
			System.out.println(eggInfo);
		}
	}
}
