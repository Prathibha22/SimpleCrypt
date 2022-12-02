import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Character _cs;
    Character _cf;

    ROT13(Character cs, Character cf) {
        this._cs=cs;
        this._cf=cf;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        char[] input=text.toCharArray();
        int boundaryEnd=(int)this._cf;
        int shiftLength= boundaryEnd - (int) this._cs;
        for(int i=0;i<input.length;i++) {
            if (Character.isAlphabetic(input[i])&& shiftLength != 0){
                if((int)Character.toLowerCase(input[i]) >=boundaryEnd) input[i]=(char)(input[i]-shiftLength);
                else input[i]=(char) ((int)input[i]+shiftLength);
            }
        }
        return String.copyValueOf(input);
    }

    public String encrypt(String text) {
       return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        char[] input=s.toCharArray();
        int boundaryEnd=(int)c;
        int shiftLength= boundaryEnd - (int) input[0];
        for(int i=0;i<input.length;i++) {
            if (input[i] != ' '&& shiftLength != 0){
               if((int)input[i] >=boundaryEnd) input[i]=(char)(input[i]-shiftLength);
               else input[i]=(char) ((int)input[i]+shiftLength);
            }
        }
        return String.copyValueOf(input);
    }

}
