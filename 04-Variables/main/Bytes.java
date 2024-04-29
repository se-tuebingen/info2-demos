package main;



public class Bytes {
    
    public static void main(String[] args) {
        
        byte a = 0;
        
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        
        System.out.println();
        
        a = -128;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        
        System.out.println();
        
        a = -2;
        //
        // Bei -1 sind alle bits im byte "an", also 
        // 1111 1111. Eine weitere Addition von +1 fuehrt 
        // prinzipiell zu 1 0000 0000. Da wir aber nur 8 bits
        // haben, verfaellt die 1 und wir landen bei 0000 0000.
        //
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        
        System.out.println();

        a = 126;
        //
        // 127 : 0111 1111 ist die groesste darstellbarste
        // Zahl mit byte.
        // Bei +1 springen wir auf 1000 0000, das entspricht
        // der kleinsten Zahl.
        //
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        a++;
        System.out.println(BitTools.inspect(a));
        System.out.println(BitTools.inspect((byte)-128));

        System.out.println();
        
        
        
    }
    
    
}