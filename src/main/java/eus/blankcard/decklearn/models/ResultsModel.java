package eus.blankcard.decklearn.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
}
