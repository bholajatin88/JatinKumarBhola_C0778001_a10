package com.jatin;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class SalesPerson extends Employee {
    //Default constructor
    public SalesPerson() {
        setId(0);
        setAge(0);
        setName("");
        setSales(0.0);
        setPay(0.0);
        setAdvance(0.0);
    }

    //Parameterized Constructor
    public SalesPerson(int id, String name, int age) {
        setId(id);
        setAge(age);
        setName(name);
        GetSalesAndAdvanceFromUser();
        setPay(0.0);
    }

    //Overridden method
    @Override
    public void displayDetails() {
        StringBuilder message = new StringBuilder();
        message.append("Sales Person details:\n" +
                "Id: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Monthly Sales: " + getSales() + "\n" +
                "Advance Paid: " + getAdvance() + "\n");

        Locale dollar = new Locale("en", "US");
        DecimalFormat decformat = new DecimalFormat("#.##");
        NumberFormat df = NumberFormat.getCurrencyInstance(dollar);
        double decVal = Double.parseDouble(decformat.format(Math.abs(getPay())));
        String num = df.format(decVal);

        if(getPay() < 0) {
            message.append("The calculated gross pay"
                    + " is less than advance paid.\n" + "Employee has to reimburse "
                    + num + " to the company.");
        }
        else {
            message.append("The calculate gross pay"
                    + " is more than the advance paid.\n" + "Company has to pay "
                    + num + " more to the employee.");
        }
        JOptionPane.showMessageDialog(null, message);
    }

    //Method to get Sales person monthly sales and advance from user
    private void GetSalesAndAdvanceFromUser() {
        //Check variable method to get valid values recursively from user
        double sales = checkVariable("Please enter " + getName() + "'s monthly sales", "Monthly Sales");
        double advance = checkVariable("Please enter the amount of advance paid to " + getName(), "Advance amount");
        setSales(sales);
        setAdvance(advance);
    }

    //Validation of inputs
    public static double checkVariable(String selectMessage, String variable) {
        boolean isNum = false;
        double val = 0.0;
        while(!isNum) {
            try {
                //get input from the user
                String input = JOptionPane.showInputDialog(selectMessage);
                if(input==null) {
                    JOptionPane.showMessageDialog(null, "Invalid input. "
                            + "Must provide value for variable " + variable);
                    continue;
                }
                //validate value entered by user
                val = Double.parseDouble(input);
                if(val <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid input. " + variable
                            + " value must be greater than 0");
                    continue;
                }
                isNum = true;
            } catch (NumberFormatException ex) {
                //Display message and continue the loop recursively
                JOptionPane.showMessageDialog(null, "Invalid input. " + variable
                        + " must be number");
            }
        }
        return val;
    }
}
