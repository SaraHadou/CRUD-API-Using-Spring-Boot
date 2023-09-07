package com.saraHadou.models;


import jakarta.persistence.*;

@Table(name = "ORDERS")
@Entity
public class OrderEntity {
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "order_id_sequence", sequenceName = "order_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_sequence")
    private Long id;

    @Column(name = "ORDER_NUMBER")
    private String orderNo;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "QTY")
    private int quantity;

    public OrderEntity(Long id, String orderNo, String productName, float price, int quantity) {
        this.id = id;
        this.orderNo = orderNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderEntity() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
