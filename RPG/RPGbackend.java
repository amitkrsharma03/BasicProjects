package RPG;

import java.util.Random;

public class RPGbackend {
    public static final String Lower_Char= "abcdefghijklmnopqrstuvwxyz";
    public static final String Upper_Char= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String Num_Char= "0123456789";
    public static final String Sym_Char= "!@#$%^&*()_+-=[]{}|;':,.<>/?";

    private final Random random;
    public RPGbackend(){random=new Random();}

    public String generatePass(int length, boolean includeUpper, boolean includeLower, boolean includeNum, boolean includeSym){
        StringBuilder password = new StringBuilder();
        String validChars = "";
        if(includeUpper){
            validChars += Upper_Char;
        }
        if(includeLower){
            validChars += Lower_Char;
        }
        if(includeNum){
            validChars += Num_Char;
        }
        if(includeSym){
            validChars += Sym_Char;
        }
        for(int i=0; i<length; i++){
            int randomIndex = random.nextInt(validChars.length());
            char randomChar = validChars.charAt(randomIndex);
            password.append(randomChar);
        }
        return password.toString();
    }
}
