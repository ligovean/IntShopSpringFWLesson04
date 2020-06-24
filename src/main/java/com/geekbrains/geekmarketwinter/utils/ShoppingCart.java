package com.geekbrains.geekmarketwinter.utils;

import com.geekbrains.geekmarketwinter.entites.OrderItem;
import com.geekbrains.geekmarketwinter.entites.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCart {
    private List<OrderItem> items;
    private Double totalCost;
    private int totalQty;

    public ShoppingCart() {
        items = new ArrayList<>();
        totalCost = 0.0;
        totalQty = 0;
    }

    public void add(Product product) {
        OrderItem orderItem = findOrderFromProduct(product);
        if (orderItem == null) {
            orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setItemPrice(product.getPrice());
            orderItem.setQuantity(0L);
            orderItem.setId(0L);
            orderItem.setTotalPrice(0.0);
            items.add(orderItem);
        }
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        recalculate();
    }

    public void setQuantity(Product product, Long quantity) {
        OrderItem orderItem = findOrderFromProduct(product);
        if (orderItem == null) {
            return;
        }
        orderItem.setQuantity(quantity);
        recalculate();
    }

    public int getTotalQty() {
        return totalQty;
    }



    public void remove(Product product) {
        OrderItem orderItem = findOrderFromProduct(product);
        if (orderItem == null) {
            return;
        }
        items.remove(orderItem);
        recalculate();
    }

    private void recalculate() {
        totalCost = 0.0;
        totalQty =0;
        for (OrderItem o : items) {
            o.setTotalPrice(o.getQuantity() * o.getProduct().getPrice());
            totalCost += o.getTotalPrice();
            totalQty += o.getQuantity();
        }
    }

    private OrderItem findOrderFromProduct(Product product) {
        return items.stream().filter(o -> o.getProduct().getId().equals(product.getId())).findFirst().orElse(null);
    }

    public long getQtyByProductId(Long id){
        return items.stream().filter(o -> o.getProduct().getId().equals(id)).findFirst().orElse(null).getQuantity();
    }

    public String getNameByProductId(Long id){
        return items.stream().filter(o -> o.getProduct().getId().equals(id)).findFirst().orElse(null).getProduct().getTitle();
    }

}
