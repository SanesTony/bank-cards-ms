package com.bank.cards.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "card")
public class Card implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@Field(name = "customerId")
	private String customerId;
	
	@Field(name = "productId")
	private String productId;

	@Field(name = "cardType")
	private String cardType;
	
	@Indexed(unique = true)
	private String cardNumber;
	
	@Field(name = "cardName")
	private String cardName;
	
	@Field(name = "cvv")
	private String cvv;
	
	@Field(name = "year")
	private String year;
	
	@Field(name = "month")
	private String month;
	
	@Field(name = "isExpired")
	private boolean isExpired;
	
	@Field(name = "isActived")
	private boolean isActived;
}
