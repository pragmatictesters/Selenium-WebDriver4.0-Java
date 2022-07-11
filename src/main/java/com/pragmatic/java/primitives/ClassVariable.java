package com.pragmatic.java.primitives;

public class ClassVariable {



    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        InventoryManager manager2 = new InventoryManager();

        System.out.println("Before initializing the product count ");
        System.out.println("Manager 1  see product count as " + manager.getProductCount());
        manager.setProductCount(10);
        System.out.println("After setting the product count to 10");
        System.out.println("Manager 1  see product count as " + manager.getProductCount());


        System.out.println("Manager 2  see product count as " +manager2.getProductCount());

        manager2.setProductCount(30);
        System.out.println("After setting the product count to 30");
        System.out.println("Manager 1  see product count as " + manager.getProductCount());
        System.out.println("Manager 2  see product count as " +manager2.getProductCount());

    }



}

class InventoryManager {
    //Instance variable without initialisation
    private  int productCount =0 ;

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}


