package Lekce06;

public class Main {

    public static void main(String[] args) {
        StateEvidence state = null;
        try {
            state = StateEvidence.importStates("vat-eu.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }/*
        if (null != state) {
            state.printAllStates();
        }
        System.out.println("=======================srovnání=======================");
        state.over();
        System.out.println("=======================státy mimo seznam=======================");
        state.vatBelow();
        state.fileWrite();
        */
    }
}
