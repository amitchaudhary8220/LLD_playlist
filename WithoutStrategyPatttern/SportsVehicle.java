package WithoutStrategyPatttern;

public class SportsVehicle extends  Vehicle{
    @Override
    public void drive() {
        System.out.println("Sports vehicle drive capabilities");  // this login is getting repeated in more than one class
    }
}
