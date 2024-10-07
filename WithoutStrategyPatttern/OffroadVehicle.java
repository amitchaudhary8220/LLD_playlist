package WithoutStrategyPatttern;

public class OffroadVehicle extends  Vehicle{
    @Override
    public void drive() {
        System.out.println("Sports vehicle drive capabilities");  // this login is getting repeated in more than one class
    }
}

// since same code is getting repeated we need to apply strategy design pattern to eliminate the duplicate code