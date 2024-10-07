package WithStrategyDesignPattern;

import WithStrategyDesignPattern.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    public SportsVehicle(){
        super(new SportsDriveStrategy());
    }
}
