package com.pragmatic.java.interfaceexample;

public class ApplicationTest {


    public static void main(String[] args) {
        Contract contract = new Implementation();
        printContract(contract);

    }

    private static void printContract(Contract contract) {
        contract.term1();
        contract.term2();
        contract.extendedTerm();
    }
}
