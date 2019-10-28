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

    public static boolean czy_plaindrom(String str)
    {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean czy_abecadlowe(String str)
    {
        char before = str.charAt(0);
        for(int i=1; i < str.length(); i ++)
        {
            if(str.charAt(i) < before ) return false;
            before = str.charAt(i);
        }
        return true;
    }
    public static String rot13(String str)
    {
        StringBuilder new_string = new StringBuilder(); 
        for(char a : str.toCharArray())
        {
            char new_char = a ;
            int new_num = new_char;
            if (new_char >= 'a'&& new_num <= 'z')
            {
                new_num += 13;
                if(new_num > (int)'z') new_num -= 26;
            }
            else if (new_num >= 'A' && new_num <= 'Z')
            {
                new_num += 13;
                if(new_num > (int)'Z') new_num -= 26;
            }

            new_char = (char)new_num;
            new_string.append(new_char);
        }
        return new_string.toString();
    }
}
