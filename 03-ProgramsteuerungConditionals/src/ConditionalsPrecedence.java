package main;
public class ConditionalsPrecedence {
    public static void main(String[] args) {
        //  If I add brackets below, else refers to first condition
        //  If I remove parenthesis, else refers to second condition
        // Tip: Use brackets to avoid confusion
        int money = 26;
        if (money > 25)
            if (money > 27)
                System.out.println("I can buy bike");
        else
            System.out.println("In cannot");
    }
}
