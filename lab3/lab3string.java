import java.lang.StringBuilder;

public class lab3string
{
 
    public static int dlugosc(String str)
    {
        return str.length();
    }

    public static int ile_razy_literka_wystepuje(String str,char c)
    {
        int suma = 0;
        for(char a : str.toCharArray())
        {
            if(a == c) suma += 1;
        }
        return suma;
    }   

    public static boolean czy_takie_same(String str1, String str2)
    {
        return str1.equals(str2);
    }

    public static String wspak(String str)
    {
        return  new StringBuilder(str).reverse().toString();
    }
    
    
}
