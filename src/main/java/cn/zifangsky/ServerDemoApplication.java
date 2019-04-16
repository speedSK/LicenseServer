package cn.zifangsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ServletComponentScan
@PropertySource({"license-config.properties"}) //加载额外的配置
public class ServerDemoApplication {
//访问（127.0.0.1:7000/license/generateLicense）生成证书
	public static void main(String[] args) {
		SpringApplication.run(ServerDemoApplication.class, args);
	}
}
