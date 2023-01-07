package Projekt1;

import java.util.Objects;

public class State implements Comparable<State>{
    private String shorts;
    private String name;
    private  Integer fullTax;
    private Double reduceTax;
    private Boolean specialTax;

    public State(String shorts, String name, Integer fullTax, Double reduceTax, Boolean specialTax) {
        this.shorts = shorts;
        this.name = name;
        this.fullTax = fullTax;
        this.reduceTax = reduceTax;
        this.specialTax = specialTax;
    }

    public String getShorts() {
        return shorts;
    }

    public void setShorts(String shorts) {
        this.shorts = shorts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFullTax() {
        return fullTax;
    }

    public void setFullTax(Integer fullTax) {
        this.fullTax = fullTax;
    }

    public Double getReduceTax() {
        return reduceTax;
    }

    public void setReduceTax(Double reduceTax) {
        this.reduceTax = reduceTax;
    }

    public Boolean getSpecialTax() {
        return specialTax;
    }

    public void setSpecialTax(Boolean specialTax) {
        this.specialTax = specialTax;
    }

    @Override
    public String toString() {
        //Název země (zkratka): základní sazba %
        return  name +"("+shorts+"): " + fullTax;
    }


    @Override
    public int compareTo(State o) {
        return o.fullTax.compareTo(fullTax);
    }
}
