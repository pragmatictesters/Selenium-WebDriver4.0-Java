package com.pragmatic.java.string;

public record Address(String addressLine1, String addressLine2, String city, String postCode ) {


    public String getAddress(){
       return String.format("""
                %s,
                %s,
                %s,
                %s.""", addressLine1(), addressLine2(), city(), postCode());
    }
}
