package com.bank.cards.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bank.cards.document.Card;
import com.bank.cards.repository.CardRepository;
import com.bank.cards.service.CardService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CardServiceImpl implements CardService{
	@Autowired
	private CardRepository cardRepository;

	@Transactional(readOnly = true)
	public Flux<Card> getCards() {
		return cardRepository.findAll();
	}

	@Transactional
	public Mono<Card> getCardById(String id) {
		return cardRepository.findById(id);
	}

	@Transactional
	public Flux<Card> getCardsByCardType(String cardType) {
		return cardRepository.findByCardType(cardType);
	}

	@Transactional
	public Mono<Card> getCardByCardNumber(String cardNumber) {
		return cardRepository.findByCardNumber(cardNumber);
	}

	@Transactional
	public Mono<Card> addCard(Card card) {
		return cardRepository.save(card);
	}

	@Transactional
	public Mono<Card> editCard(Card card) {
		return cardRepository.save(card);
	}

	@Transactional
	public Mono<Void> deletedCardById(Card card) {
		return cardRepository.delete(card);
	}

}
