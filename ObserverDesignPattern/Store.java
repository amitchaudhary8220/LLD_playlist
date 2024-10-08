package ObserverDesignPattern;

import ObserverDesignPattern.Observable.IphoneObservable;
import ObserverDesignPattern.Observable.StocksObservable;
import ObserverDesignPattern.Observer.EmailAlertObserver;
import ObserverDesignPattern.Observer.MobileAlertObserver;
import ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public  static void main(String[] args){

        StocksObservable iphoneObservable = new IphoneObservable();

        NotificationAlertObserver user1 = new EmailAlertObserver("amitchaudhary@gmail.com",iphoneObservable);
        NotificationAlertObserver user2 = new EmailAlertObserver("ankit@gmail.com",iphoneObservable);
        NotificationAlertObserver user3 = new MobileAlertObserver("thisisamit",iphoneObservable);

        iphoneObservable.add(user1);
        iphoneObservable.add(user2);
        iphoneObservable.add(user3);

        iphoneObservable.setStockCount(100);
//        iphoneObservable.setStockCount(0);
//        iphoneObservable.setStockCount(50);

    }
}
