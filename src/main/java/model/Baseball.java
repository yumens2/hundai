package model;

import java.util.Arrays;

public class Baseball {

  private String[] answer; // 정답 숫자
  private String[] submit; // 제출한 숫자
  private boolean finish;


  public boolean isFinish() {
    return finish;
  }

  public void setFinish(boolean finish) {
    this.finish = finish;
  }

  public String[] getAnswer() {
    return answer;
  }

  public void setAnswer(String[] answer) {
    this.answer = answer;
  }

  public String[] getSubmit() {
    return submit;
  }

  public void setSubmit(String[] submit) {
    this.submit = submit;
  }

  @Override
  public String toString() {
    return "Baseball{" +
        "answer=" + Arrays.toString(answer) +
        ", finish=" + finish +
        '}';
  }
}
