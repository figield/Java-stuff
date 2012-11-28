import java.util.*;
import java.io.*;

public class LIB {

    public static void write_to_file(String FileName, String Msg){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FileName + ".txt"));
            out.write(Msg);
            out.newLine();
            out.close();
        }
        catch (IOException e){
                System.out.println("Wystapil blad zapisu do pliku.");	
        }
    } 

    //http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
    public static long[] read_file(String FileName, String Separator){
        String Lines = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(FileName + ".txt"));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
                Lines = Lines + sCurrentLine;            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
                
        String[] parts = Lines.split(Separator);
        long[] content = new long[parts.length];
        
        for (int i = 0; i < parts.length; ++i)
            content[i] = Long.parseLong(parts[i]);        

        return content;
    }

    public static boolean is_prime(long p){
        long p1 = (long) Math.sqrt(p);
        long a = 2;
        while((p % a) != 0 && a <= p1) 
            a++;
        if (a > p1) return true;
        else        return false;
    }

    public static long potmod(long a, long b, long m) { 
        long y = 1; // y = a^b MOD m 
        while (b > 0) 
            { 
                if (b%2 != 0){
                    y = (y*a) % m;
                }
                b = b / 2; 
                a = (a*a) % m; 
            } 
        return y;  
    } 

    public static long get_prime_number(long n){
        boolean[] numbersTable = new boolean[(int) (n+1)];
        long LastPrimeNumber = 2;
        //sieve of Eratosthenes
        // TODO: replace for with while
        for(int i = 2; i*i <= n; i++){
                if (numbersTable[i] == true)
                    continue;
                for (int j = 2 * i ; j <= n; j += i)
                    numbersTable[j] = true;                
            }
        // TODO: replace for with while
        for (int i = (int) n; i >= 2; i--)
            if (numbersTable[i] == false){
                // System.out.println(i);
                LastPrimeNumber = i;
                break;
            }
        return LastPrimeNumber;
    }

    public static long[] Ext_Euclid(long a, long b){ 
        // returns d, x, y; d = nwd(a, b) = ax + by 
        if (b == 0){ 
            long[] dxy = {a, 1, 0}; 
            return dxy;
        } 
        long[] dxy = Ext_Euclid(b, a % b); 
        long x = dxy[1]; 
        dxy[1] = dxy[2]; 
        dxy[2] = x - (a/b)*dxy[2]; 
        return dxy; 
    } 

    public static long[] string_to_int_tab(String Chars){         
        long[] Ints = new long[Chars.length()]; 
        for (int i = 0; i < Chars.length();++i){
            char c = Chars.charAt(i);
            long j = (long) c;
            Ints[i] = j;
            //System.out.println(j);
        }
        return Ints;
    }

    public static String int_tab_to_string(long[] Ints){         
        char[] result = new char[Ints.length];      
        for (int i = 0; i < Ints.length; i++ ){
                result[i] = (char)Ints[i];
            }      
        return new String(result);
    }

    public static void print_tab(long[] Ints){
        System.out.print("[");
        for (int i = 0; i < Ints.length; i++ ){
                System.out.print(Ints[i]);
                if (i < (Ints.length -1)){
                    System.out.print(", ");
                }
            }            
        System.out.println("]");
    }

    public static void save_tab_in_file(String FileName, long[] Ints){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(FileName + ".txt"));
            for (int i = 0; i < Ints.length; i++ ){
                out.write(Long.toString(Ints[i]));
                if (i < (Ints.length -1))
                    out.write(",");
            }
            out.close();
        }
        catch (IOException e)
            {
                System.out.println("Wystapil blad zapisu do pliku.");	
            }	        
    }
    
}