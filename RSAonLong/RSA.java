import java.util.*;

public class RSA {
    public  long J; // klucz jawny, publiczny
    private long T; // klucz tajny, prywatny
    public  long M; // duza liczba jawna
    private long F;
    private long p; // liczba pierwsza
    private long q; // liczba pierwsza
    
    RSA() {
        // podaj dwie liczby p i q sprawdz czy p jest l.pierwsza jesli nie popros o ponowne podanie
        // jesli tak przejdz do q.(tak samo z q)
        
        Scanner odczyt = new Scanner(System.in);

        boolean is_prime = false;        
        while(is_prime != true){
            System.out.print("Podaj liczbe p: ");
            p = odczyt.nextLong();            
            if (LIB.is_prime(p))
                is_prime = true;
            else 
                System.out.println("Podana liczba nie jest liczba pierwsza");            
        }
        
        is_prime = false;            
        while(is_prime != true){
            System.out.print("Podaj liczbe q: ");
            q = odczyt.nextLong();
            if (LIB.is_prime(q))
                is_prime = true;
            else 
                System.out.println("Podana liczba nie jest liczba pierwsza");            
        }
        
        M = p * q;
        System.out.println("modul M = " + M);
        
        /* wartosc funkcji Eulera (przypisuje kazdej liczbie naturalnej
           liczbe wzglednie z niz pierwszych nie wiekszych od niej samej)*/
        F = (p - 1) * (q - 1); 
        System.out.println("modul F = " + F);
       
        //Podac niewielka nieparzusta liczbe J 
        // i sprawdzic czy jest wzglednie pierwsza z F
        boolean ok_JFT = false;
        while(ok_JFT != true){
            System.out.print("Podaj klucz publiczny: ");
            J = odczyt.nextLong();
            if (J % 2 == 0){
                System.out.println("Podana liczba musi byc nieparzysta");
            } else {
                long[] dxy = LIB.Ext_Euclid(F, J);
                if (dxy[0] == 1){
                    // oblicz T tak aby (T*J) MOD F = 1  
                    // (czyli istnieje X takie, ze T*J = X*F + 1)
                    // T > 0
                    T = dxy[2];
                    if(T > 0){
                        ok_JFT = true;
                        System.out.println("Klucz prywatny: "+ T);
                    } else
                        System.out.println("Wyliczony klucz prywatny nie jest wiekszy od zera: "+ T);                
                } else
                    System.out.println("nwd(F, J) musi byc 1, a jest  "+dxy[0]);    
            }        
        }
    }   

    long code1(long I, long Jb, long Mb) {
        // X = (I^J) MOD M 
        return LIB.potmod(I, Jb, Mb);
    }   

    long decode1(long X) {
        // I = (X^T) MOD M 
        return LIB.potmod(X, T, M); 
    }

    long[] code(String Msg, long Jb, long Mb) {
        long[] Ints = LIB.string_to_int_tab(Msg);
        long[] CodedInts = new long[Msg.length()];
        for (int i = 0; i < Msg.length();++i){
            long I = code1(Ints[i], Jb, Mb);
            CodedInts[i] = I;
        }        
        return CodedInts;
    }

    String decode(long[] CodedInts) {
        long[] DecodedInts = new long[CodedInts.length];
        for (int i = 0; i < CodedInts.length; ++i){
            long I = decode1(CodedInts[i]);
            DecodedInts[i] = I;
        }
        return LIB.int_tab_to_string(DecodedInts);
    }

}