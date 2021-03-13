package Design.VendingMachine.Interfaces;

import Design.VendingMachine.Models.Coin;
import Design.VendingMachine.Models.Product;

import java.util.Map;

public interface IVendingMachine {
    int selectItemAndGetPrice(String code) throws Exception;
    void insertCoin(Coin coin) throws Exception;
    Map<Coin, Integer> refund() throws Exception;
    Map<Product, Map<Coin, Integer>> collectItemAndChange() throws Exception;
    void reset();
}
