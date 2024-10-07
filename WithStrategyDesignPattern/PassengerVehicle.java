package WithStrategyDesignPattern;

import WithStrategyDesignPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends  Vehicle{
    public  PassengerVehicle(){
        super(new NormalDriveStrategy());
    }
}
