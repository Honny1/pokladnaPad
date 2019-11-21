package pokladna;

public interface InterfaceItem {
    void newItems(int count);

    void changePrice(float price);

    float boughtItem(String id);
}
