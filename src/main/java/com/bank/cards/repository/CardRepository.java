package com.bank.cards.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.cards.document.Card;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends ReactiveMongoRepository<Card, String> {

	Mono<Card> findByCardNumber(String cardNumber);
	Flux<Card> findByCardType(String cardType);
}
