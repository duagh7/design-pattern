package com.tyr.designpattern.creater.builder;

/**
 * @Auther: TaoYiran
 * @Date: 2018/6/22 17:42
 * @Description: 构建者模式，个人感觉非常给力，真实开发经常使用
 */
public class Order{

    private Order(){
    }

    private Order(Order target){
        this.orderId = target.getOrderId();
        this.consumerId = target.getConsumerId();
        this.shopId = target.getShopId();
        this.totalPrice = target.getTotalPrice();
        this. payableMoney = target.getPayableMoney();
    }

    private String orderId;
    private String shopId;
    private String consumerId;
    private double totalPrice;
    private double payableMoney;

    public static class Builder{
        private Order target;

        public Builder(){
            target = new Order();
        }
        public Builder orderId(String orderId){
            target.orderId = orderId;
            return this;
        }
        public Builder consumerId(String consumerId){
            target.consumerId = consumerId;
            return this;
        }
        public Builder shopId(String shopId){
            target.shopId = shopId;
            return this;
        }
        public Builder totalPrice(double totalPrice){
            target.totalPrice = totalPrice;
            return this;
        }
        public Builder payableMoney(double payableMoney){
            target.payableMoney = payableMoney;
            return this;
        }

        public Order build(){
//            return new Order(target);
            return target;
        }
    }

    public String getOrderId() {
        return orderId;
    }

    public String getShopId() {
        return shopId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getPayableMoney() {
        return payableMoney;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }
}

class PatternTester{
    public static void main(String[] args) {
        Order order = new Order.Builder().orderId("order84931537829483").consumerId("consumer541723321").shopId("shop854731594").totalPrice(88.99).payableMoney(66.66).build();
        System.out.println(order.getConsumerId());
    }
}
