/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;


public class Company {
  private HashMap<String, ArrayList<Employee>> departments = new HashMap<>();

  public void addDepartment(String d) {
      if(departments.containsKey(d))
		  throw new DepartmentExistsException("Department already exists");
	  ArrayList<Employee> myList = new ArrayList<Employee>();
	  departments.put(d, myList );
  }

  public void addEmployee(String department, String Name, String id) {
      Employee employee = new Employee(Name, id, department);
	  if(!departments.containsKey(department))
		  throw new NoDepartment("No Department Exists");
	  ArrayList<Employee> newEmployee = departments.get(department);
	  newEmployee.add(employee);
	  departments.put(department, newEmployee);
  }
  
  public void display() {
      HashSet<String> Keys_sorted = new HashSet<String> ();
      Keys_sorted.addAll(departments.keySet());
      String[] KeyAccess = Keys_sorted.toArray(new String[0]);
      Arrays.sort(KeyAccess);
	  
      String s;
      
      for (String run : KeyAccess) {
          s = run;
          p("=== " + s + " ===");
          List<Employee> emps = departments.get(s);
          Collections.sort(emps);
          emps.forEach((e) -> { p(e.Display()); });
      }
  }

  private static void p(String msg) {
    System.out.println(msg);
  }

  private static String[] getNextCommand() {
    Scanner s = new Scanner(System.in);
    p("");
    System.out.print("Next command => ");
    String input = s.nextLine();
    return input.split(" ");
  }

  public static void main(String[] args) {
    
    Company c = new Company();
    boolean done = false;
    do {
      try {
        String[] command = getNextCommand();
        String directive = command[0];
        switch (directive) {
          case "add-dep":
            c.addDepartment(command[1]);
            break;
          case "add-emp":
            c.addEmployee(command[1], command[2], command[3]);
            break;
          case "p":
            c.display();
            break;
          case "q":
            done = true;
            break;
        }
      } 
      catch (Exception e) {
        e.printStackTrace();
        p("Unexpected error during command processing");
      }
    } while (!done);
    p("Goodbye!");
  }
}
