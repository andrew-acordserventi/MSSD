package edu.bu.met.cs665.ObserverPattern;

import edu.bu.met.cs665.Objects.DeliveryRequest;

public interface Observer {
    public void display(DeliveryRequest newRequest);
}
