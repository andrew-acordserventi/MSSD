package edu.bu.met.cs665.Objects;

/**
 * Delivery request object. Has an ID, delivery address, pickup address, time, and item description.
 * Contains getters, setters, and return a description of the request.
 **/
public class DeliveryRequest {
    private int orderID;
    private String deliveryAddress;
    private String pickupAddress;
    private Item deliveryItem;
    private int timeDue;

    public DeliveryRequest(int orderID, String pickupAddress, String deliveryAddress, Item deliveryItem, int timeDue) {
        this.setOrderID(orderID);
        this.setPickupAddress(pickupAddress);
        this.setDeliveryAddress(deliveryAddress);
        this.setDeliveryItem(deliveryItem);
        this.setTimeDue(timeDue);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryItem() {
        return deliveryItem.description();
    }

    public void setDeliveryItem(Item deliveryItem) {
        this.deliveryItem = deliveryItem;
    }

    public int getTimeDue() {
        return timeDue;
    }

    public void setTimeDue(int timeDue) {
        this.timeDue = timeDue;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Returns information on the order in a String format
     */
    public String displayOrder() {
        return "OrderID: " + this.getOrderID() +
                ", Pickup Address: " + this.getPickupAddress() +
                ", Delivery Address: " + this.getDeliveryAddress() +
                ", Item to be Delivered: " + this.getDeliveryItem() +
                ", Time due by: " + getTimeDue();
    }
}
