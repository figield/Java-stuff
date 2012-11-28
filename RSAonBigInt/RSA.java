/* ********************************************************************* *
 * Generowanie N-bitowego publicznego i prywatnego klucza RSA
 * i uzycie do szyfrowania i deszyfrowania losowej wiadomsci.
 *
 **********************************************************************/

//import biblioteki math z funkcja BigInteger
import java.math.BigInteger; 
//zaprojektowana dla zabezpieczen kryptograficznych
import java.security.SecureRandom; 

public class RSA {
    private final static BigInteger jeden = new BigInteger("1");
    private final static SecureRandom random = new SecureRandom();    
    private BigInteger kluczPubliczny;
    private BigInteger kluczPrywatny;
    private BigInteger modul;

    RSA(int A) {
        // wbierz dwie duze liczby pierwsze p i q 
        BigInteger p = BigInteger.probablePrime(A, random);
        BigInteger q = BigInteger.probablePrime(A, random);
        // (p - 1) * (q - 1)
        BigInteger M = (p.subtract(jeden)).multiply(q.subtract(jeden));

        // oblicz M = p * q        
        modul = p.multiply(q);
    
        kluczPubliczny  = new BigInteger("65537");
        kluczPrywatny = kluczPubliczny.modInverse(M);
    }
    
    BigInteger szyfrowanie(BigInteger wiadomosc) {
        return wiadomosc.modPow(kluczPubliczny, modul);
    }
    
    BigInteger deszyfrowanie(BigInteger encrypted) {
        return encrypted.modPow(kluczPrywatny, modul);
    }

    public String toString() {
        String s = "";
        s += "publiczny  = " + kluczPubliczny  + "\n";
        s += "prywatny   = " + kluczPrywatny + "\n";
        s += "modul      = " + modul;
        return s;
    }

    public static void main(String[] args) {
        RSA keyRSA = new RSA(50);
        System.out.println(keyRSA);
        
        /* Tworzymy wiadomosc poprzez przeksztalcenie znakow 
           na licze calkowita */        
        BigInteger wiadomosc = new BigInteger("123456789"); 
              
        BigInteger szyfrowanie = keyRSA.szyfrowanie(wiadomosc);
        BigInteger deszyfrowanie = keyRSA.deszyfrowanie(szyfrowanie);
        System.out.println("Wiadomosc     = " + wiadomosc);
        System.out.println("Szyfrowanie   = " + szyfrowanie);
        System.out.println("Deszyfrowanie = " + deszyfrowanie);
    }
}