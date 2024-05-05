package src.main.java.config;

import src.main.java.participant.Participant;
import src.main.java.participant.UserParticipant;
import src.main.java.problem.RandomValueMaker;
import src.main.java.problem.StandardValueChecker;
import src.main.java.problem.ValueChecker;
import src.main.java.problem.ValueMaker;

public class ConfigurationObject {
    public ValueMaker getValueMaker() {
        ValueMaker valueMaker = new RandomValueMaker();
        return valueMaker;
    }
}
