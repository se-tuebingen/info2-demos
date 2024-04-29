package main;

public class BuyBike {
    public static void main(String[] args) {
        // A program which tells me if I can buy a 100 Euro bike
        // and a helmet
        final int bike_price = 100;
        int money = 150;
        int borrowed_money = 50;
        int helmet_price = 20;
        if (money >= bike_price) {
            System.out.println("I buy the bike because I have " + money + " Euros");
            if ((money - bike_price) >= helmet_price)
                System.out.println("I can buy also a Helmet because I have " + (money-bike_price) + " Euros left");
        } else if ((money + borrowed_money) >= bike_price){
            System.out.println("I buy the bike because I have " + money + "+ I borrowed " + borrowed_money + " Euros");
        }else{
            System.out.println("I need to borrow more money");
        }
    }
    }

