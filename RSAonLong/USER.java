import java.util.*;
import java.io.*;


// Main program
public class USER {        
    public static void main(String[] args) {
        RSA keyRSA = new RSA();        
        Scanner odczyt = new Scanner(System.in);

        System.out.print("Podaj swoje imie: ");
        String MyName = odczyt.nextLine();
        LIB.write_to_file(MyName + "_public_key", keyRSA.J + ":" + keyRSA.M);

        // Zapytanie dla kogo ma byc wiadomosc
        // PODAJ TO SAMO IMIE... // TODO: FIX THIS
        System.out.print("Podaj imie odbiorcy (PODAJ TO SAMO IMIE...) : ");
        String SomeoneName = odczyt.nextLine();

        // Odczytanie czyjegos pliku z kluczem publicznym 
        long [] Jb_Mb = LIB.read_file(SomeoneName + "_public_key",":"); // ":" separator
        //TODO: dodac sprawdzenie czy jest taki plik

        System.out.print("Podaj wiadomosc do zakodowania: ");
        String Msg = odczyt.nextLine();
        
        // Ta wiadomosc trzeba zakodowac czyims kluczem publicznym nie swoim!
        long[] CodedMsg = keyRSA.code(Msg, Jb_Mb[0], Jb_Mb[1]);                

        System.out.println("Wiadomosc zostala zakodowana i zapisana w pliku.");
        LIB.save_tab_in_file(MyName + "_secret_message", CodedMsg);        

        System.out.println("Zakodowane liczby: ");
        LIB.print_tab(CodedMsg);

        // TODO:
        // Odczytanie czyjegos pliku z zakodowana wiadomoscia.
        // Menu: odczytaj wiadomosc od wczytanego imienia (jesli istnieje)

        System.out.println("Wiadomosc otrzymana od ...:");
        long [] SomeoneMessage = LIB.read_file(SomeoneName + "_secret_message",",");
        LIB.print_tab(SomeoneMessage);

        String DecodedMsg = keyRSA.decode(SomeoneMessage);
        System.out.print("Odkodowana wiadomosc od ...: ");
        System.out.println(DecodedMsg);

        // To wszystko musi byc w petli z odpowiednim menu tak by mozna bylo:
        // powtarzac dane operacje i
        // odczytywac wiadomosci od kogos innego
        
        // zeby mies drugiego usera trzeba tez uruchomic program USER w drugim oknie... na chwile obecna oba userzy musza miec to samo imie, poniewaz pliki z kluczami moga nie istniec.

        

    }
}