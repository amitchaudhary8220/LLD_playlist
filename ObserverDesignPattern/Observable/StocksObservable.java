package ObserverDesignPattern.Observable;

import ObserverDesignPattern.Observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public  void setStockCount(int data);

    public  int getStockCount();

}
