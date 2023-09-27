package com.Leta.MainPackage;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Leta.Entity.Owner;
import com.Leta.Entity.Product;
import com.Leta.Repository.OwnerRepo;
import com.Leta.Repository.ProductRepo;
@Component
public class Main {
	
	@Autowired
	ProductRepo proRepo;
	@Autowired
	OwnerRepo ownerRepo;
	
	public Main() {
		System.out.println("object initialization ....");
		
	}
	
	public void create () {
		for(int i=1;i<20;i++) { 
			
		
		Product pro=new Product();
		pro.setName("Product_" );
		pro.setDescription("Product_" +"_Descriptoin");
		pro.setActive(true);
		pro.setImageUrl("" );
		pro.setPrice(new BigDecimal(i*500.4));
		pro.setSku("SKU_" );
		
//		System.out.println(pro.getId());
	pro= proRepo.save(pro);
//		System.out.println("---------------------------saved----------------------------------");
//		System.out.println(pro.getId());
		System.out.println(pro.getId()+"    "+pro.getName());
		
	}
	
	}

	public void read() {
		Long id=12L;
		Product product= proRepo.findById(id).get();
		System.out.println("---------retrived-----------");
		System.out.println(product);
		List<Product> list= proRepo.findAll();
		System.out.println("--------------------------------------------------------");
		list.forEach(n-> System.out.println(n.toString()));
		System.out.println("--------------------------------------------------------");
	}

	public void update() {
	//fetch the row to be updated
		Long id=1L;
		Product product= proRepo.findById(id).get();
		System.out.println(product);
		System.out.println("---------retrived-----------");
	//update it
		product.setName("REupdatedName");
	//save it
		proRepo.save(product);
	//check it whether updated or not
		System.out.println("---------After update is performed-----------");
		product= proRepo.findById(id).get();
		System.out.println(product);
		
	}

	public void delete() {
		
		System.out.println(proRepo.existsById(1L));
		proRepo.deleteById(1L);
		System.out.println("-------------Deleted-------------");
		System.out.println(proRepo.existsById(1L));
		
	}

	
	public void customSearching_One() {
		System.out.println("Total = " + proRepo.count());
		
		Product product=proRepo.findByName("product_1");
		System.out.println(product.getName());
		
		System.out.println("--------------------------------------------------------");
		List<Product> productList=proRepo.findByActive(true);
		productList.forEach(n->System.out.println(n.getName()+"  "+n.isActive()));
		System.out.println("--------------------------------------------------------");
		
		product=proRepo.findByDescription("Product_3_Descriptoin");
		System.out.println(product.getName());
		
		String dateTimeString = "2023-09-26 12:41:56.062837";
		// Define a custom date-time formatter to match the pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		// Parse the string into a LocalDateTime object
		LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
		product = proRepo.findByDateCreated(localDateTime).orElse(new Product());
		System.out.println("Search By Date Created : " + product.getName());
		
		productList=proRepo.findByPriceNot(7506);
		productList.forEach(n->System.out.println(n.getName()+"  "+n.getPrice()));
		System.out.println("--------------------------------------------------------");
		
	}

	public void customSearching_Two() {
		//------------------findByNameContaining()------------------------------------
		
//		List<Product> list=proRepo.findByNameContaining("_1");
//	
//		for (Product product : list) {
//			System.out.println(product.getId()+" :"+ product.getName());
//						}
		//-------------------findByNameLike()-----------------------------------------
		
//		List<Product> list=proRepo.findByNameLike("%1%");
//		
//		for (Product product : list) {
//			System.out.println(product.getId()+" :"+ product.getName());
//						}
		//-------------------findByNameNotLike()-----------------------------------------
		
//				List<Product> list=proRepo.findByNameNotLike("%1%");
//				
//				for (Product product : list) {
//					
//					System.out.println(product.getId()+" :"+ product.getName());
//					
//				}
		
		// -------------------findByNameStartingWith()-----------------------------------------

//		List<Product> list = proRepo.findByNameStartingWith("product_1");
//
//		for (Product product : list) {
//
//			System.out.println(product.getId() + " :" + product.getName());
//
//		}
	// -------------------findByNameEndingWith()-----------------------------------------

//			List<Product> list = proRepo.findByNameEndingWith("1");
//
//			for (Product product : list) {
//
//				System.out.println(product.getId() + " :" + product.getName());
//
//			}		
	// -------------------findByNameIsNull()-----------------------------------------
	
//	List<Product> list = proRepo.findByNameIsNotNull();
//
//	for (Product product : list) {
//
//		System.out.println(product.getId() + " :" + product.getName());
//
//	}
	// -------------------findByNameIsNull()-----------------------------------------
//	
//		List<Product> list = proRepo.findByNameIsNotNull();
//
//		for (Product product : list) {
//
//			System.out.println(product.getId() + " :" + product.getName());

		//}
		// -------------------findByPriceGreaterThan()-----------------------------------------
		
//			List<Product> list = proRepo.findByPriceGreaterThan(4000);
//
//			for (Product product : list) {
//
//				System.out.println(product.getId() + " :" + product.getName());
//
//			}
	// -------------------findByPriceBetween()-----------------------------------------
	
//		List<Product> list = proRepo.findByPriceBetween(2000,6000);
//
//		for (Product product : list) {
//
//			System.out.println(product.getPrice() + " :" + product.getName());
//
//		}
		
		
		
		
		
		
	}

	public void oneToMany() {
	
		
		Owner owner=new Owner();
		owner.setName("Tola");
		owner.setPhone("09876555555");
		ownerRepo.save(owner);
		System.out.println("---------------------------------------Owner Saved-----------------");
		
		
		
		Product pro=new Product();
		pro.setName("Product_40" );
		pro.setDescription("Product_40_Descriptoin");
		pro.setActive(true);
		pro.setImageUrl("40.png" );
		pro.setPrice(new BigDecimal(50.2).multiply(new BigDecimal(Math.random()*100)));
		pro.setSku("SKU_40" );
		pro.setOwner(owner);
		proRepo.save(pro);
		System.out.println("---------------------------------------Product Saved-----------------");

		
		
		
		 pro=new Product();
		pro.setName("Product_50" );
		pro.setDescription("Product_50_Descriptoin");
		pro.setActive(true);
		pro.setImageUrl("50.png" );
		pro.setPrice(new BigDecimal(50.2).multiply(new BigDecimal(Math.random()*100)));
		pro.setSku("SKU_50" );
		pro.setOwner(owner);
		proRepo.save(pro);
		System.out.println("---------------------------------------Product Saved-----------------");

		
		
		
		
		
		
		
		
		
	}
















}
