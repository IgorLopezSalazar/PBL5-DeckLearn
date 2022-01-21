package eus.blankcard.decklearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.blankcard.decklearn.models.CardModel;

public interface CardRepository extends JpaRepository<CardModel, Integer> {
    
}
