package main;

/**
 * Some tools for quickly analyzing
 * binary affairs of primitive data types.
 * 
 * @author Sebastian Otte
 */
public class BitTools {
    
    /**
     * Generates bit string of a byte value. 
     */
    public static String asBitString(final byte value) {
        
        String result = "";
        
        for (int i = 0; i < 8; i++) {
            final int bit = (value >>> (7 - i)) & 0x1;
            
            if (bit > 0) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result;
    }

    /**
     * Generates bit string of a float value. 
     */
    public static String asBitString(final float value) {
        int bits = Float.floatToIntBits(value);
        
        String result = "";
        
        for (int i = 0; i < 32; i++) {
            if ((i == 1) || (i == 9)) {
                result += " ";
            }
            
            final int bit = (bits >>> (31 - i)) & 0x1;
            
            if (bit > 0) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result;
    }
    
    /**
     * Generates bit string of an int value. 
     */
    public static String asBitString(final int value) {
        
        String result = "";
        
        for (int i = 0; i < 32; i++) {
            if ((i > 0) && ((i & 3) == 0)) {
                result += " ";
            }
            
            final int bit = (value >>> (31 - i)) & 0x1;
            
            if (bit > 0) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result;
    }

    /**
     * Generates bit string + value of a byte. 
     */
    public static String inspect(final byte value) {
        return asBitString(value) + " : " + String.valueOf(value);
    }

    /**
     * Generates bit string + value of a byte. 
     */
    public static String inspect(final int value) {
        return asBitString(value) + " : " + String.valueOf(value);
    }

    /**
     * Generates bit string + value of a float.  
     */
    public static String inspect(final float value) {
        return asBitString(value) + " : " + String.valueOf(value);
    }
    
    /**
     * Extracts the sign bit of a float value.
     */
    public static int sign(final float value) {
        final int bits = Float.floatToIntBits(value);
        return (bits >>> 31) & 0x1;
    }
    
    /**
     * Extracts the exponent bits of a float value.
     */
    public static int exponent(final float value) {
        final int bits = Float.floatToIntBits(value);
        return (bits >>> 23) & 0xFF;
    }

    /**
     * Extracts the mantissa bits of a float value. 
     */
    public static int mantissa(final float value) {
        final int bits = Float.floatToIntBits(value);
        return (bits >>> 23) & 0x7FFFFF;
    }

    /**
     * Converts a bit string into an int value. 
     */
    public static int bitStringToInt(final String bits) {
        final int len = Math.min(32, bits.length());
        
        int sum = 0;
        
        for (int i = 0; i < len; i++) {
            if (bits.charAt(i) == '1') {
                sum += 0x1 << ((len - 1) - i);
            }
        }
        
        return sum;
    }

    /**
     * Converts a bit string in reverse order into an int value. 
     */
    public static int bitStringRevToInt(final String bits) {
        return bitStringToInt(
            new StringBuffer(bits).reverse().toString()
        );
    }
    
    /**
     * Converts a bit string into a float value. 
     */
    public static float bitStringToFloat(final String bits) {
        return Float.intBitsToFloat(bitStringToInt(bits));
    }
    
    /**
     * Generates a hex string from an int value. 
     */
    public static String asHexString(final int bits) {
        String result = "";
        
        result += String.format("%02X", (bits >>> 24) & 0xFF) + " ";
        result += String.format("%02X", (bits >>> 16) & 0xFF) + " ";
        result += String.format("%02X", (bits >>> 8) & 0xFF) + " ";
        result += String.format("%02X", (bits) & 0xFF);
        
        return result;
    }
    
}