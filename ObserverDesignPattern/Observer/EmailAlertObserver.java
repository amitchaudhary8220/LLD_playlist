package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class EmailAlertObserver implements NotificationAlertObserver {

    String email;
    StocksObservable observable;

    public EmailAlertObserver(String email, StocksObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(email, "Product is the stock, Hurry up!");
    }

    public void sendEmail(String email, String msg) {
        System.out.println("Msg send to:" + email + " " + msg);
    }
}
