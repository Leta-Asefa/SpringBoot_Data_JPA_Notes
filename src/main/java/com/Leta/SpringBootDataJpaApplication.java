package com.Leta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.Leta.MainPackage.Main;

@SpringBootApplication
@EntityScan(basePackages = "com.Leta")
public class SpringBootDataJpaApplication  {
	
	
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context= SpringApplication.run(SpringBootDataJpaApplication.class, args);
		Main main=context.getBean(Main.class);
		//main.create();  
		//main.read();
		//main.update();
		//main.delete();
		//main.customSearching_One();
		//main.customSearching_Two();
		//main.oneToMany();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	public void twoWaysOfImplementingCommandLineRunner() {
	
		//if you want to try , delete the method declaration above and uncomment the code below
		//the method is created only for contraction purpose to make the class clear
	
//	@Bean
//	CommandLineRunner lambdaCommandLineRunner(ProductRepo repo) {
//		return args->{
//			Product pro=new Product();
//			pro.setPro_name("OneProductName");
//			pro.setActive(true);
//			pro.setImageUrl("image1.png");
//			pro.setSku("SKU");
//			pro.setPrice(new BigDecimal(50));
//			pro.setDescription("Description");
//			
//			repo.save(pro);
//		};
//		
//	}
//
//
//    @Bean
//    CommandLineRunner anonymousInnerClassCommandLineRunner(ProductRepo repo) {
//	    return new CommandLineRunner() {
//	        @Override
//	        public void run(String... args) throws Exception {
//	        	Product pro=new Product();
//				pro.setPro_name("ThreeProductName");
//				pro.setActive(true);
//				pro.setImageUrl("image3.png");
//				pro.setSku("SKU");
//				pro.setPrice(new BigDecimal(50));
//				pro.setDescription("Description");
//				
//				repo.save(pro);
//	        }
//	    };
//	}
	
	}
	
}
