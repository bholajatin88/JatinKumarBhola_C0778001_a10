package com.jatin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Sales person employee object creation
        Employee salesPerson = new SalesPerson(1, "Jatin", 25);
        //Sales Commission Calculator class object with Sales Person details
        SalesCommissionCalc calc = new SalesCommissionCalc(salesPerson);
        //sales commission and pay calculator
        calc.calcPay();
        //Set calculated pay of the sales person
        salesPerson.setPay(calc.getPay());
        //display employee details along with amount to be paid
        salesPerson.displayDetails();
    }
}