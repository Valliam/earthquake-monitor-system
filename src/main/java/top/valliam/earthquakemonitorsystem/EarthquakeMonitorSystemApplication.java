package top.valliam.earthquakemonitorsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"top.valliam.earthquakemonitorsystem.dao",})
@ServletComponentScan
@EnableTransactionManagement
public class EarthquakeMonitorSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EarthquakeMonitorSystemApplication.class, args);
    }

}
