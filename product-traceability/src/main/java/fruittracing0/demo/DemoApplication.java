package fruittracing0.demo;

import fruittracing0.demo.StaffPO.Staff;
import fruittracing0.demo.dao.StaffDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {
    public DemoApplication(StaffDao staffDao) {
        /*Staff staff = staffDao.findById(1).get();
        System.out.println(staff);*/
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
