/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author Josh
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private String ID;
    private String department;

    public Employee(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public Employee(String name, String ID, String Department) {
        this.name = name;
        this.ID = ID;
        this.department = Department;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String Display(){
        return "Employee Name: " + name + ", ID: " + ID;
    }
    @Override
    public int compareTo(Employee p) {
        String combined1 = getID() + getName();
        String combined2 = p.department + p.getName();
        return combined1.compareTo(combined2);
    }

    
}
 
