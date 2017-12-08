package com.siue.nursingHome;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class NursingHome{
    String provider_number;
    String name;
    Long phone_number;
    String provider_type;
    String ownership_type;
    Integer overall_rating;

    public String getProvider_number() {
        return provider_number;
    }

    public void setProvider_number(String provider_number) {
        this.provider_number = provider_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getProvider_type() {
        return provider_type;
    }

    public void setProvider_type(String provider_type) {
        this.provider_type = provider_type;
    }

    public String getOwnership_type() {
        return ownership_type;
    }

    public void setOwnership_type(String ownership_type) {
        this.ownership_type = ownership_type;
    }

    public Integer getOverall_rating() {
        return overall_rating;
    }

    public void setOverall_rating(Integer overall_rating) {
        this.overall_rating = overall_rating;
    }

    @Override
    public String toString() {
        return "NursingHome{" +
                "provider_number='" + provider_number + '\'' +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", provider_type='" + provider_type + '\'' +
                ", ownership_type='" + ownership_type + '\'' +
                ", overall_rating='" + overall_rating + '\'' +
                '}';
    }


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/nursing_home_information";
        String username = "root";
        String password = "root";

        System.out.println("Connecting database...");

        try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

}