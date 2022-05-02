package edu.bu.met.cs665.ObserverPattern;

import edu.bu.met.cs665.Objects.DeliveryRequest;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(DeliveryRequest newRequest);
}
