package com.project.orderservice.entity;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
	
	private Long orderId;
	private BigInteger orderPrice;
	private List<Product> products;
	private 

}
