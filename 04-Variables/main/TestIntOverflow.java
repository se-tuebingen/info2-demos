package main;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class TestIntOverflow {
    public static void main(String[] args) {

        int o = 1000000000 * 4;
        int p = (1000000000 * 4) / 10;
        int q = (1000000000 / 10) * 4;

        System.out.println("Result should be the same but");
        System.out.println("o:" + o);
        System.out.println("p:" + p);
        System.out.println("q:" + q);

        // Largest representable number 2^(N-1)
        System.out.println(Math.pow(2,32-1));
        //if (System.out.println(Math.pow(2,32-1)) > o){
        //    System.out.println(Math.pow(2,32-1));
        //}


    }
}