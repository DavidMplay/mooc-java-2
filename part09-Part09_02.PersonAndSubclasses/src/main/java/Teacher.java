/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gamer
 */
public class Teacher extends Person{
    private int money;
    public Teacher(String name, String address, int money){
        super(name, address);
        this.money = money;
    }
    public String toString(){
        return super.toString() + "\n  salary " + this.money + " euro/month";
    }
}
