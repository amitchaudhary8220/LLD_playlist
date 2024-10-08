package ObserverDesignPattern.Observer;

import ObserverDesignPattern.Observable.StocksObservable;

public class MobileAlertObserver implements NotificationAlertObserver {
    StocksObservable observable;
    String userName;

    public MobileAlertObserver(String userName,StocksObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "Product is in the stock hurry up!");
    }

    public void sendMsgOnMobile(String userName, String msg) {
        System.out.println("msg sent to  :" + userName + " " + msg);
    }

}
