package com.pragmatic.java.primitives;

public class InstanceVariable {



    public static void main(String[] args) {
        Product firstProduct = new Product();
        System.out.println("Product number " + firstProduct.getProductNumber());
        firstProduct.setProductNumber(1234);
        System.out.println("Product number " + firstProduct.getProductNumber());

    }


}

class Product {
    //Instance variable without initialisation
    int productNumber;

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }
}

