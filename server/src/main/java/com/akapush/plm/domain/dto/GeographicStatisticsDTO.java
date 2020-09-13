package com.akapush.plm.domain.bean;

public class GeographicStatistics {

    int numberInToulouse;
    int numberInToulouseMetropole;
    int numberInRegion;

    public GeographicStatistics(int numberInToulouse, int numberInToulouseMetropole, int numberInRegion) {
        this.numberInToulouse = numberInToulouse;
        this.numberInToulouseMetropole = numberInToulouseMetropole;
        this.numberInRegion = numberInRegion;
    }

    public int getNumberInToulouse() {
        return numberInToulouse;
    }

    public void setNumberInToulouse(int numberInToulouse) {
        this.numberInToulouse = numberInToulouse;
    }

    public int getNumberInToulouseMetropole() {
        return numberInToulouseMetropole;
    }

    public void setNumberInToulouseMetropole(int numberInToulouseMetropole) {
        this.numberInToulouseMetropole = numberInToulouseMetropole;
    }

    public int getNumberInRegion() {
        return numberInRegion;
    }

    public void setNumberInRegion(int numberInRegion) {
        this.numberInRegion = numberInRegion;
    }
}
