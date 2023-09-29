package com.Leta.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Component
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products",schema="Marketing"//,
	//uniqueConstraints =   @UniqueConstraint(name="unique_constraint_for_imageUrl",columnNames="imageUrl")
		)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //auto_increment
	private Long id;
	@Column(name="stock_keeping_unit")
	private String sku;
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	@Column(unique = false ,nullable = false)
	private String imageUrl;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	@Autowired
	@ManyToOne
	private Owner owner; 
	 
	
	
	
}
