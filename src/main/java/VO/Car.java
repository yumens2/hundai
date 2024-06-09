package VO;

public class Car {
    String carName;
    int runCount;

    public Car(String carName){
        this.carName = carName;
        this.runCount = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getRunCount() {
        return runCount;
    }

    public void setRunCount(int runCount) {
        this.runCount = runCount;
    }

    public void addRunCount(int runCount) {
        this.runCount += runCount;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", runCount=" + runCount +
                '}';
    }
}
