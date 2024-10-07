package WithStrategyDesignPattern.Strategy;

public interface DriveStrategy {
    public  void  drive();
}


// Strategy pattern is used where when we are extending a base class , and there is some code which is not is
// base class but, it is being shared by many subclass so to remove that code duplicacy , we will use strategy
// design pattern