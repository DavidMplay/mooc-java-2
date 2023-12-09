/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory hystory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.hystory = new ChangeHistory();
        this.hystory.add(initialBalance);
    }

    public String history() {
        return hystory.toString();
    }

    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        this.hystory.add(super.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        if (super.getBalance() < amount) {
            this.hystory.add(super.getBalance());
            return super.getBalance();
        }
        super.takeFromWarehouse(amount);
        this.hystory.add(super.getBalance());

        return super.getBalance();
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Largest amount of product: " + this.hystory.maxValue());
        System.out.println("Smallest amount of product: " + this.hystory.minValue());
        System.out.println("Average: " + this.hystory.average());
    }
}
