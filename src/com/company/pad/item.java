package com.company.pad;

public abstract class item implements interfaceItem{
    private String name;
    private String id;
    private float price;
    private int count;

    public void newItems(int count){
        this.count=count;
    }
    public void changePrice(float price){
        this.price=price;
    }
    public float boughtItem(String id){
        this.count--;
        return this.getPrice();
    }

    public item(String name, float price, int count) {
        this.name = name;
        itemId id_ = new itemId();
        this.id = id_.getRandomUUIDString();
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "item{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}