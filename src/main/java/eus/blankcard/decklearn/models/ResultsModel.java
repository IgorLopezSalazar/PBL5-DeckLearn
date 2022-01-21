package eus.blankcard.decklearn.models;

import java.sql.Time;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import eus.blankcard.decklearn.models.card.CardResponseModel;

@Entity
@Table( name = "results" )
public class ResultsModel {
    
    @Id
    @Column( name = "results_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="training_session_id")
    private TrainingSessionModel trainingSession;

    @OneToMany(mappedBy = "results", cascade = CascadeType.ALL)
    List<CardResponseModel> cardResponses;

    @Column( name = "avg_response_time" )
    Time avgResTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrainingSessionModel getTrainingSession() {
        return trainingSession;
    }

    public void setTrainingSession(TrainingSessionModel trainingSession) {
        this.trainingSession = trainingSession;
    }

    public List<CardResponseModel> getCardResponses() {
        return cardResponses;
    }

    public void setCardResponses(List<CardResponseModel> cardResponses) {
        this.cardResponses = cardResponses;
    }

    public Time getAvgResTime() {
        return avgResTime;
    }

    public void setAvgResTime(Time avgResTime) {
        this.avgResTime = avgResTime;
    }
}
