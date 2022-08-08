package com.pragmatic.assertj;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ObjectsAssertionExample {


    @Test
    public void testSingleObject() {
        Product product1 = new Product("Book", 10.5);
        Product product2 = new Product("T-Shirt", 20.5);
        Product product3 = new Product("Book", 10.5);
        Product product4 = new Product("Book", 9.5);

        assertThat(product1).isEqualTo(product3);
        assertThat(product1).isNotSameAs(product2);
        assertThat(product1).extracting(Product::name).isEqualTo("Book").isSameAs(product4.name());
    }


    @Test
    public void testListOfObjects(){
        Product product1 = new Product("Book", 10.5);
        Product product2 = new Product("T-Shirt", 20.5);
        Product product3 = new Product("Book", 10.5);
        Product product4 = new Product("Book", 9.5);
        List<Product> productList = new ArrayList<>(Arrays.asList(product1, product2, product3, product4));

        assertThat(productList).last().extracting(Product::name).isEqualTo("Book");
        assertThat(productList).size().isEqualTo(4);

        long expensiveProducts = productList.stream().filter(product -> product.price() > 20).count();
        assertThat(expensiveProducts).isEqualTo(1);

        double total = productList.stream().mapToDouble(Product::price).sum();
        assertThat(total).isEqualTo(51.0);

        double maxPrice = productList.stream().mapToDouble(Product::price).max().getAsDouble();
        assertThat(maxPrice).isEqualTo(20.5);
    }

}


record Product(String name, double price) {

}