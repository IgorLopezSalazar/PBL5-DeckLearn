package eus.blankcard.decklearn.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class CardModel {

    @Id
    private Integer card_id;

    @ManyToOne
    @JoinColumn(name="deck_id")
    private DeckModel deck;

    private String question;

    private String answer;

    private String img_path;

    
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<CardResponseModel> cardResponses;

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public DeckModel getDeck() {
        return deck;
    }

    public void setDeck(DeckModel deck) {
        this.deck = deck;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public List<CardResponseModel> getCardResponses() {
        return cardResponses;
    }

    public void setCardResponses(List<CardResponseModel> cardResponses) {
        this.cardResponses = cardResponses;
    }
}