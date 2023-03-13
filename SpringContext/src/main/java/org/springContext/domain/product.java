package org.springContext.domain;

public class product {
    private int productId;
    private String productName;
    private int productPrice;

    public product() {
        System.out.println("bean are created using default constructor");
    }

    public product(int productId, String productName, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getGetProductPrice() {
        return productPrice;
    }

    public void setGetProductprice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", getProductprice=" + productPrice +
                '}';
    }
}
