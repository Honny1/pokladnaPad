package pokladna;

import java.util.ArrayList;
import java.util.HashMap;

import static org.testng.Assert.*;
import static pokladna.DataLoader.creatCashRegister;
import static pokladna.DataLoader.creatItems;

public class CashRegisterTest {

    @org.testng.annotations.Test
    public void testGetName() {
        CashRegister cashRegister = creatCashRegister();
        assertEquals(cashRegister.getName(),"POKLADNA-1");
    }

    @org.testng.annotations.Test
    public void testGetCurrency() {
        CashRegister cashRegister = creatCashRegister();
        assertEquals(cashRegister.getCurrency(),"Kč");

    }

    @org.testng.annotations.Test
    public void testGetCashNow() {
        CashRegister cashRegister = creatCashRegister();
        assertEquals(cashRegister.getCashNow(),2000,0.001);
    }

    @org.testng.annotations.Test
    public void testBuyItems() {
        CashRegister cashRegister = creatCashRegister();
        HashMap<String, Integer> buy = new HashMap<>();
        buy.put(cashRegister.getItems().get(1).getId(),10);
        assertEquals(cashRegister.buyItems(buy,700), "100.0");
    }

    @org.testng.annotations.Test
    public void testBuyItems1() {
        CashRegister cashRegister = creatCashRegister();
        HashMap<String, Integer> buy = new HashMap<>();
        buy.put(cashRegister.getItems().get(1).getId(),10);
        assertEquals(cashRegister.buyItems(buy,600), "0.0");
    }

    @org.testng.annotations.Test
    public void testBuyItems2() {
        CashRegister cashRegister = creatCashRegister();
        HashMap<String, Integer> buy = new HashMap<>();
        buy.put(cashRegister.getItems().get(1).getId(),10);
        assertEquals(cashRegister.buyItems(buy,500), "Not enough money!");
    }

    @org.testng.annotations.Test
    public void testGetTableRows() {
        CashRegister cashRegister = creatCashRegister();

        HashMap<String, Integer> buy = new HashMap<>();
        buy.put(cashRegister.getItems().get(1).getId(),10);

        ArrayList<TableRow> rows = new ArrayList<>();
        Ticket ticket = (Ticket) cashRegister.getItems().get(1);

        rows.add(new TableRow(ticket.getName() + "-" + ticket.getType(), ticket.getPrice(), ticket.getPrice() * 10, 10));

        assertEquals(cashRegister.getTableRows(buy).get(0).getCount(), rows.get(0).getCount());
        assertEquals(cashRegister.getTableRows(buy).get(0).getSumPrice(), rows.get(0).getSumPrice());
        assertEquals(cashRegister.getTableRows(buy).get(0).getPrice(), rows.get(0).getPrice());
        assertEquals(cashRegister.getTableRows(buy).get(0).getName(), rows.get(0).getName());
    }

    @org.testng.annotations.Test
    public void testGetSumPrice() {
        CashRegister cashRegister = creatCashRegister();
        HashMap<String, Integer> buy = new HashMap<>();
        buy.put(cashRegister.getItems().get(1).getId(),10);
        assertEquals(cashRegister.getSumPrice(buy), 600, 0.001);
    }

    @org.testng.annotations.Test
    public void testGetItems() {
        CashRegister cashRegister = creatCashRegister();
        ArrayList<Item> items = creatItems();
        assertEquals(cashRegister.getItems().size(), items.size());
        for(int i = 0; i < items.size();i++) {
            assertEquals(cashRegister.getItems().get(i).getPrice(), items.get(i).getPrice());
            assertEquals(cashRegister.getItems().get(i).getCount(), items.get(i).getCount());
            assertEquals(cashRegister.getItems().get(i).getName(), items.get(i).getName());
        }
    }
}