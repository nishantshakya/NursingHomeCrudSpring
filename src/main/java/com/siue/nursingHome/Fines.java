package com.siue.nursingHome;


public class Fines {

    String number;
    String name;
    String type;
    Integer orating;
    Double fines;
    Double amountFines;

    public Double getFines() {
        return fines;
    }

    public void setFines(Double fines) {
        this.fines = fines;
    }

    public Double getAmountFines() {
        return amountFines;
    }

    public void setAmountFines(Double amountFines) {
        this.amountFines = amountFines;
    }

    @Override
    public String toString() {
        return "Fines{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", orating=" + orating +
                ", srating=" + srating +
                ", total_defiencies=" + total_defiencies +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrating() {
        return orating;
    }

    public void setOrating(Integer orating) {
        this.orating = orating;
    }

    public Integer getSrating() {
        return srating;
    }

    public void setSrating(Integer srating) {
        this.srating = srating;
    }

    Integer srating;


    Integer total_defiencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}