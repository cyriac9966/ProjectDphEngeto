package Projekt1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StateEvidence {
    List<State>states = new ArrayList<>();

    public void addState(State state){
        states.add(state);
    }

    public static StateEvidence importStates(String fileName){
        StateEvidence result = new StateEvidence();
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
        while (scanner.hasNextLine()){
            String textLine = scanner.nextLine();
            String[] value = textLine.split("\t");
            String shorts = value[0];
            String name = value[1];
            Integer fullTax = Integer.parseInt(value[2]);
            Double reduceTax = Double.parseDouble(value[3]);
            Boolean speacialTax = Boolean.parseBoolean(value[4]);
            result.addState(new State(shorts,name,fullTax,reduceTax,speacialTax));
        }
        } catch (FileNotFoundException e) {
            System.err.println("složka nebyla nalezena. Zkontrolujte název a místo uložení složky");
        }
        return result;
    }
    //Název země (zkratka): základní sazba %
    public void printStates(){
        for (State state:states) {
            System.out.println(state);
        }
    }
    public void over20(){
        List<State> result = new ArrayList<>();
        List<State> other = new ArrayList<>();
        int limit = 0;
        String input;
        System.out.println("Zadejte výši sazby, kteou chcete filtrovat.");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        System.out.println(input);
        if (input == "") {
            limit = 20;
        } else limit = Integer.parseInt(input);

        for (State state : states) {
            if (state.getFullTax() >= limit) {
                result.add(state);
            } else other.add(state);
        }
        System.out.println("státy které mají sazbu vyšší než: "+input);
        Collections.sort(result);
        result.forEach(System.out::println);
        System.out.println("===============================\nStáty které mají sazbu nižší než: "+input);

        for (State state : other) {
            System.out.println("(" + state.getShorts() + ") " + state.getFullTax());
        }
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("vat-over-" + limit + ".txt"))) {
            for (State state : result) {
                printWriter.println(
                        state.getName()
                                + ";"
                                + state.getShorts()
                                + ";"
                                + state.getFullTax()
                                + ";"
                                + state.getReduceTax()
                                + ";"
                                + state.getSpecialTax()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
