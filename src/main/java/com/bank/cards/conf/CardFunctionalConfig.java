package com.bank.cards.conf;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bank.cards.document.Card;
import com.bank.cards.service.CardService;

@Configuration
public class CardFunctionalConfig {
	@Autowired
	private CardService cardService;
	
	@Bean
	RouterFunction<ServerResponse> getCards(){
		return route(GET("/api/v1/cards"), 
				req -> ok().body(
						cardService.getCards(), Card.class
						));
	}
	
	@Bean 
	RouterFunction<ServerResponse> getCardById(){
		return route(GET("/api/v1/cards/{id}"),
				req -> ok().body(
						cardService.getCardById("id"), Card.class
						));
	}
	
	@Bean
	RouterFunction<ServerResponse> getCardsByCardType(){
		return route(GET("/api/v1/cards/{cardType}"),
				req -> ok().body(
						cardService.getCardsByCardType(req.pathVariable("cardType")), Card.class
						));
	}
	
	@Bean
	RouterFunction<ServerResponse> getCardByCardNumber(){
		return route(GET("/api/v1/cards/{cardNumber}"),
				req -> ok().body(
						cardService.getCardByCardNumber(req.pathVariable("cardNumber")), Card.class
						));
	}
	
	@Bean
	RouterFunction<ServerResponse> addCard(){
		return route(POST("/api/v1/cards"),
				req -> ok().body(
						fromPublisher(req.bodyToMono(Card.class).flatMap(cardService::addCard), Card.class)
						));
	}
	
	RouterFunction<ServerResponse> editCard(){
		return route(PUT("/api/v1/cards"),
				req -> ok().body(
						fromPublisher(req.bodyToMono(Card.class).flatMap(cardService::editCard), Card.class)
						));
	}
	
	@Bean
	RouterFunction<ServerResponse> deletedCardById(){
		return route(DELETE("/api/v1/cards/{id}"),
				req -> ok().body(
						cardService.getCardById(req.pathVariable("id")).flatMap(card -> cardService.deletedCardById(card)), Void.class
						));
	}
	
}
