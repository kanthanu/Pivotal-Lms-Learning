package com;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import org.springframework.core.env.Environment;
//import org.springframework.cloud.config.server.EnableConfigServer;



@Configuration
@ComponentScan
@PropertySource("/config/properties/db.properties")
//@PropertySource("file:D:/cloudfoundry/property/db.properties")
//@SpringBootApplication
public class DbconnectionTest {
	
	@Bean
	static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	
	@Value("${db.host.url}")
	void setUrl(String url){
		System.out.println("setting url "+url);
	}
		
		@Value("${db.port.number}")
		void setNumber(String number){
			System.out.println("setting port no "+number);
		}
			@Value("${db.service.name}")
			void setName(String name){
				System.out.println("setting name "+name);
			}
				@Value("${db.user}")
				void setUser(String user){
					System.out.println("setting user "+user);
				}
				
				@Value("${db.password}")
				void setPassword(String password){
					System.out.println("setting password "+password);
				}
	
	

	@Autowired
	void setEnvironment(Environment env){
		System.out.println("setting environment: " + 
                       env.getProperty("db.host.url")+","+
		               env.getProperty("db.port.number")+","+
		               env.getProperty("db.service.name")+","+
		               env.getProperty("db.user")+","+
		               env.getProperty("db.password"));
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		new AnnotationConfigApplicationContext(DbconnectionTest.class);
		

	}

}
