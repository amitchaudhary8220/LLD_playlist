package ObserverDesignPattern.Observable;
import ObserverDesignPattern.Observer.EmailAlertObserver;
import ObserverDesignPattern.Observer.MobileAlertObserver;
import ObserverDesignPattern.Observer.NotificationAlertObserver;
import java.util.*;

public class IphoneObservable implements StocksObservable {
   public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public  int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
      //since we are notifying the user when something was out of stock now it is in stock , we will not notify
        // the user, when something is in stock and we just only increasing its quantity

        for(NotificationAlertObserver observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int count) {
        if(stockCount ==0){
            notifySubscribers();
        }
        stockCount+=count;
    }

    @Override
    public int getStockCount() {
        return stockCount; // data is stock count
    }
}
