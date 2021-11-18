package com.bank.cards.service;

import com.bank.cards.document.Card;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {

	public Flux<Card> getCards();
	public Mono<Card> getCardById(String id);
	public Flux<Card> getCardsByCardType(String cardType);
	public Mono<Card> getCardByCardNumber(String cardNumber);
	public Mono<Card> addCard(Card card);
	public Mono<Card> editCard(Card card);
	public Mono<Void> deletedCardById(Card card);
}
