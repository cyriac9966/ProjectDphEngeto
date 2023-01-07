package Lekce06;

public class State implements Comparable<State>{
    private String abr;
    private String name;
    private Integer vat;
    private double reduceVat;
    private boolean speacialVat;

    public State(String abr, String name, Integer vat, double reduceVat, boolean speacialVat) {
        this.abr = abr;
        this.name = name;
        this.vat = vat;
        this.reduceVat = reduceVat;
        this.speacialVat = speacialVat;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }

    public double getReduceVat() {
        return reduceVat;
    }

    public void setReduceVat(double reduceVat) {
        this.reduceVat = reduceVat;
    }

    public boolean isSpeacialVat() {
        return speacialVat;
    }

    public void setSpeacialVat(boolean speacialVat) {
        this.speacialVat = speacialVat;
    }

    @Override
    public String toString() {
        return name +" ("+ abr + ") " + vat +"%";
    }


    @Override
    public int compareTo(State o) {
        return o.vat.compareTo(vat);
    }
    public String getInfo(){
        return name +" ("+ abr + ") " + vat +"%";
    }
}

