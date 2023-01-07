package Lekce06;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StateEvidence {
    public static final String Delimiter = "  ";

    List<State> stateList = new ArrayList<>();
    List<State> over = new ArrayList<>();
    List<State> under = new ArrayList<>();

    public void addState(State newState) {
        stateList.add(newState);
    }
    int limit = 0;
    String lim;


    public static StateEvidence importStates(String fileName) {
        StateEvidence result = new StateEvidence();
       int lineNumber = 0;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()&&(lineNumber<4)) {
                lineNumber++;
                String nextLine = scanner.nextLine();
                String[] value = nextLine.split("\t");
                String abr = value[0];
                String name = value[1];
                Integer vat = Integer.parseInt(value[2]);
                double redvat = Double.parseDouble(value[3]);
                boolean specialVat = Boolean.parseBoolean(value[4]);
                result.addState(new State(abr, name, vat, redvat, specialVat));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("zde je vypsany stateList "+result.stateList+"zde byl vypsany stateList");
        return result;
    }

    public void printAllStates() {
        stateList.forEach(System.out::println);
    }

    public void over() {
        System.out.println("zadej výši dph k filtraci");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        System.out.println("____________");
        List<State>states=stateList.stream().filter(state -> state.getVat()>=index).collect(Collectors.toList());
        states.forEach(System.out::println);
        System.out.println("____________");

        /*System.out.println("zadej výši dph k filtraci");
        Scanner sc = new Scanner(System.in);
        lim = sc.nextLine();
        System.out.println(lim);
        if (lim.equals("")){
            limit = 20;
        }
        else limit = Integer.parseInt(lim);
        System.out.println(limit);
        for (State state:stateList) {
            if ((state.getVat() > limit) && (!state.isSpeacialVat())) {
                over.add(state);
            } if ((state.getVat() <= limit) || (state.isSpeacialVat())) {
                under.add(state);
            }}
            Collections.sort(over);
            Collections.sort(under);
            for (State state : over) {
                System.out.println(state);*/
        // }

    }

    public void vatBelow(){
        System.out.println("Sazba VAT "+limit+"% nebo nižší nebo používají speciální sazbu: ");
        for (State state:under) {
            System.out.print(state.getAbr()+", ");
        }
    }
    public void fileWrite(){
        String fileName = "vat-over-"+limit+".txt";
        String fileName1 = fileName;
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName1))) {
            for (State state:over) {
                pw.println(
                        state.getName()
                        + Delimiter
                        + state.getAbr()
                        +Delimiter
                        +state.getVat()
                        +Delimiter
                        +state.getReduceVat()
                        +Delimiter
                        +state.isSpeacialVat()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
