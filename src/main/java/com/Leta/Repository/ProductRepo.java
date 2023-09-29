package com.Leta.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Leta.Entity.Product;
import com.Leta.Entity.ProductNameAndDescription;

public interface ProductRepo extends JpaRepository<Product,Long> {

	public Product findByName(String name);
	public Product findBySku(String sku);
	public Product findByDescription(String description);
	public List<Product> findByActive(boolean active);
	public Optional<Product> findByDateCreated(LocalDateTime dateTime);
	public List<Product> findByPriceNot(int price);
	public List<Product> findByNameContaining(String name);
	public List<Product> findByNameLike(String name);
	public List<Product> findByNameNotLike(String name);
	public List<Product> findByNameStartingWith(String name);
	public List<Product> findByNameEndingWith(String name);
	public List<Product> findByNameIsNotNull();
	public List<Product> findByPriceGreaterThan(int value);
	public List<Product> findByPriceBetween(int start,int end);
	public List<Product> findTop3ByPriceGreaterThan(int value);
	
	public List<Product> findByOwnerName(String name); // uses inner join
	
	@Query(value="select * from products",nativeQuery = true) // it means joining 
	public List<Product> getAllProductsWithOwner();
	
	@Query(value="select * from products inner join owner on products.id=owner.id",nativeQuery = true)
	public List<Product> findBy();
	
	@Query(value="SELECT  p.name as name,p.description as description,p.price as price from Product p")
	public List<ProductNameAndDescription> findProductNamesAndDescriptions();
	
	@Query(value="Select p from Product p where p.name=:name and p.id=:id and p.active=:active")
	public List<Product> findProductsByNameAndIdAndActive(
			@Param("name") String name,@Param("id") String id,@Param("active") Boolean active);
	 
	
	
	
//	Equals: findByField(value)			 													Checked
//	Not Equals: findByFieldNot(value)   													Checked
//	Like: findByFieldContaining(substring) or findByFieldLike(substring)					Checked
//	Not Like: findByFieldNotContaining(substring) or findByFieldNotLike(substring)			Checked
//	Starting With: findByFieldStartingWith(prefix)											Checked
//	Ending With: findByFieldEndingWith(suffix)												Checked
//	Is Null: findByFieldIsNull()  															Checked
//	Is Not Null: findByFieldIsNotNull()  													Checked
//	Greater Than: findByFieldGreaterThan(value)
//	Less Than: findByFieldLessThan(value)
//	Between: findByFieldBetween(start, end)
//	In: findByFieldIn(values)
//	Not In: findByFieldNotIn(values)
//	Ignoring Case: findByFieldIgnoreCase(value)
//	Ordering Ascending: findByFieldOrderByFieldAsc()
//	Ordering Descending: findByFieldOrderByFieldDesc()
//	Distinct: findDistinctByField(value)
//	Count By: countByField(value)
//	Exists By: existsByField(value)
//	First By: findFirstByField(value)
//	Top By: findTopByField(value)
//	And: findByField1AndField2(value1, value2)
//	Or: findByField1OrField2(value1, value2)
//	Not: findByField1Not(value1)
//	True: findByFieldIsTrue()
//	False: findByFieldIsFalse()
	
	
}
