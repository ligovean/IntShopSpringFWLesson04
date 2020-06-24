package com.geekbrains.geekmarketwinter.entites;

import com.geekbrains.geekmarketwinter.utils.ShoppingCart;

public class Greeting {

    private String content;
    private String qty;
    private String cur;
    private String id;

    public Greeting(String content) {
        this.content = content;
    }


    public Greeting(String content,String qty,String cur,String id) {
        this.content = content;
        this.qty = qty;
        this.id = id;
        this.cur = cur;
    }

    public String getContent() {
        return content;
    }

    public String getQty() {
        return qty;
    }

    public String getId() {
        return id;
    }

    public String getCur() {
        return cur;
    }
}