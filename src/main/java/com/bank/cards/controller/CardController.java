package com.bank.cards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.cards.document.Card;
import com.bank.cards.service.CardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(name = "/api/v1/cards")
public class CardController {
	@Autowired
	private CardService cardService;
	
	@GetMapping(value = "")
	public Flux<Card> getCards(){
		return cardService.getCards();
	}
	
	@GetMapping(value = "/{id}")
	public Mono<Card> getCardById(@PathVariable String id){
		return cardService.getCardById(id);
	}
	
	@GetMapping(value = "/{cardType}")
	@ResponseBody public Flux<Card> getCardsByCardType(@RequestBody String cardType){
		return cardService.getCardsByCardType(cardType);
	}
	
	@GetMapping(value = "/{cardNumber}")
	public Mono<Card> getCardByCardNumber(@PathVariable String cardNumber){
		return cardService.getCardByCardNumber(cardNumber);
	}
	
	@PostMapping(value = "")
	@ResponseBody public Mono<Card> addCard(@RequestBody Card card){
		return cardService.addCard(card);
	}
	
	@PutMapping(value = "")
	@ResponseBody public Mono<Card> editCard(@RequestBody Card card){
		return cardService.addCard(card);
	}
	
	@DeleteMapping(value = "{id}")
	public Mono<ResponseEntity<Card>> deletedCardById(String id){
		return cardService.getCardById(id).flatMap(card -> cardService.deletedCardById(card) )
				.map(c -> ResponseEntity
						.noContent().build());
		}
	
}
