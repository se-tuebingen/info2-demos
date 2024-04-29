package main;

public class BitOps {
    
    public static void main(String[] args) {

        // ~    inverieren aller bits
        // |    bit-weises "Oder"
        // &    bit-weises "Und"
        // ^    bit-weises "exklusiv Oder"
        
        /*
        int a = BitTools.bitStringToInt("");
        System.out.println(BitTools.inspect(a));
        
        int b = ~a;
        System.out.println(BitTools.inspect(b));
        
        System.out.println();
        */
        
    
        int a = BitTools.bitStringToInt("111000");
        System.out.println(BitTools.inspect(a));
     /*   
        int b = BitTools.bitStringToInt("001011");
        System.out.println(BitTools.inspect(b));
        
        int c = a & b;
        
        System.out.println(BitTools.inspect(c));
      */ 
        
        //
        // << Bit shift nach links.
        // >> Bit shift nach rechts (Vorzeichen-erhaltend)
        // >>> Bit shift nach rechts (nicht Vorzeichen-erhaltend).
        //
        a = BitTools.bitStringToInt("1111000001111");
        System.out.println(BitTools.inspect(a));
        System.out.println(BitTools.inspect(a << 1));
        System.out.println(BitTools.inspect(a << 2));
        System.out.println(BitTools.inspect(a << 3));
        
        System.out.println(BitTools.inspect((a << 3) >> 1));
        
        int b = -1234;
        System.out.println(BitTools.inspect(b));
        System.out.println(BitTools.inspect(b >>> 3));
        
        int x = 10;
        int y = 200;
        
        /*
        int temp = x;
        x = y;
        y = temp;
        */
        
        //
        // XOR-swap
        //
        System.out.println(x + ", " + y);
        // x  y    x ^ y  
        //
        // 0  0     0
        // 0  1     1
        // 1  0     1
        // 1  1     0
        //
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        
        System.out.println(x + ", " + y);
        
        
        
        
            
    }
    
}