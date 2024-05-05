package config;


import participant.Participant;
import participant.UserParticipant;
import problem.RandomValueMaker;
import problem.StandardValueChecker;
import problem.ValueChecker;
import problem.ValueMaker;

public class ConfigurationObject {
    public ValueMaker getValueMaker() {
        ValueMaker valueMaker = new RandomValueMaker();
        return valueMaker;
    }



    public ValueChecker getValueChecker(String inputValue) {
        ValueChecker valueChecker = new StandardValueChecker(inputValue);
        return valueChecker;
    }


    public Participant getParticipant() {
        Participant participant = new UserParticipant();
        return participant;
    }
}
