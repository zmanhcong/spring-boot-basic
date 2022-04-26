package edu.poly.hello.service;

import edu.poly.hello.model.CartItem;

import java.util.Collection;

public interface ShoppingCartService {
    void add(CartItem item);

    void remove(int productId);

    Collection<CartItem> getCartItems();

    void clear();

    void update(int productId, int quantity);

    double getAmount();

    int getCount();

}
