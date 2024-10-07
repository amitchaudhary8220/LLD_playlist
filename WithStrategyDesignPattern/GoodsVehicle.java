package WithStrategyDesignPattern;
import WithStrategyDesignPattern.Strategy.SportsDriveStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle(){
        super(new SportsDriveStrategy()); // pass the object of sports drive strategy
    }
}
