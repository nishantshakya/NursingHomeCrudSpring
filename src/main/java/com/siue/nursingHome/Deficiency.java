package com.siue.nursingHome;


public class Deficiency{

    String name;
    Integer inspection_cycle;

    @Override
    public String toString() {
        return "Deficiency{" +
                "name='" + name + '\'' +
                ", inspection_cycle=" + inspection_cycle +
                ", total_defiencies=" + total_defiencies +
                '}';
    }

    Integer total_defiencies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInspection_cycle() {
        return inspection_cycle;
    }

    public void setInspection_cycle(Integer inspection_cycle) {
        this.inspection_cycle = inspection_cycle;
    }

    public Integer getTotal_defiencies() {
        return total_defiencies;
    }

    public void setTotal_defiencies(Integer total_defiencies) {
        this.total_defiencies = total_defiencies;
    }
}