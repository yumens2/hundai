package model;

public interface BaseballService {

  void baseballInit();

  void play();

  void replay();

  void check();

  void submitAnswer();

  boolean isValid(String submit);
}
