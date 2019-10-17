package com.springboot_vue.js.Model;

public class Employee {

    private int id;
    private String name;
    private String power;
    private String position;
    private String password;

    public Employee(String name, String power, String position){
        this.name = name;
        this.power = power;
        this.position = position;
//        this.password = p
    }


    public Employee(int id, String name, String power, String position, String password) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.position = position;
        this.password = password;
    }

    public Employee(String insert_name, String insert_power, String insert_position, String insert_password){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
