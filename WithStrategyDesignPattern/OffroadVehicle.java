package WithStrategyDesignPattern;

import WithStrategyDesignPattern.Strategy.SportsDriveStrategy;

public class OffroadVehicle extends Vehicle {
    public OffroadVehicle() {
        super(new SportsDriveStrategy());
    }
}
