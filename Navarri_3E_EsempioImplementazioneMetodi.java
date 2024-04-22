/*Codice esempio per l'implementazione dei metodi:
- wrongIndexSearch (ricerca secondo l'indice)
- evenOddSearch (ordinamento di un array)
- biBinarySearch (
 */

import static tools.utility.*;
//importazione librerie
import java.util.Scanner;
import java.util.Random;

public class Navarri_3E_EsempioImplementazioneMetodi //creazione classe
{
    public static void main(String[] args) //metodo principale
    {
        Scanner tastiera = new Scanner(System.in);
        Random random = new Random();

        //dichiarazione e inizializzazione variabili per il menù
        String[] opzioni = {"Opzioni",
                "[1] Ricerca numero nell'array in base all'indice(wrongIndexSearch)",
                "[2] Ordinamento numeri pari in ordine crescente e dispari in ordine decrescente(evenOddSearch)",
                "[3] Ordinamento numeri pari e dispari+ ricerca(biBinarySearch)"};
        boolean fine = true;

        //dichiarazione e inizialzizzazione delle variabili
        int errore = 0, posizione, posizionePrecedente = 0; //per il metodo wrongIndexSearch
        //dichiarazione array di numeri interi
        int[] arrayNumeri = {5, 2, 1, 8, 3, 6, 4, 7, 10, 9};
        int[] arrayOrdinato;

        //ciclo do while per la ripetizione del programma
        do {
                //estrazione numero casuale tra 3 e 5 per l'errore
                if (errore == 0)
                    errore = random.nextInt(2, 5) + 1;

                switch (menu(opzioni, tastiera))
                {
                    case 1: //wrongIndexSearch

                        errore--; //quando viene scelta l'ozione 1, viene eseguita una ricerca e quindi decremenatto il contatore

                        //salvataggio posizione (può essere quella giusta o sbagliata in base al valore dell'errore)
                        posizione = wrongIndexSearch (arrayNumeri, tastiera, random, errore, posizionePrecedente);

                        System.out.println(arrayNumeri[posizione]); //stampa numero in quella posizione

                        posizionePrecedente = posizione; //salva posizione appena cercata

                        break;

                    case 2: //evenOddSearch

                        arrayOrdinato = evenOddSearch(arrayNumeri); //invoca metodo per ordinare l'array

                        for (int i = 0; i < arrayOrdinato.length; i++)
                        {
                            System.out.print(arrayOrdinato[i]+ " "); //stampa a schermo array ordinato
                        }

                        break;

                    case 3: //biBinarySearch

                        arrayOrdinato = evenOddSearch(arrayNumeri); //invoca metodo per ordinare l'array
                        biBinarySearch(); //invoca metodo per carcare

                        break;

                    default:
                        fine = false;
                        break;


                }

                String svuotabuffer = tastiera.nextLine();

        } while (fine);
    }

    /* metodo che ricerca il valore nell'array in base all'indice, però commette degli errori
    (un valore casuale tra le 3 e le 5 ricerche) e restituisce il valore cercato precedentemente*/
    private static int wrongIndexSearch(int[] arrayNumeri, Scanner tastiera, int errore, int posizionePrecedente)
    {
        //dichiarazione variabile per acquisire la posizione da cercare
        int posizione;

        do {
            System.out.println("Inserire la posizione da cercare nell'array: ");
            posizione = tastiera.nextInt() + 1;

            //verifica valore inserito
            if (posizione < 0 || posizione > arrayNumeri.length)
            {
                System.out.println("Valore inserito non valido.");
            }
        } while (posizione < 0 || posizione > arrayNumeri.length);


        if (errore == 0)
        {
            return posizionePrecedente;
        }
        else
        {
            return posizione;
        }
    }

    /*metodo che ordina i numeri pari in ordine crescente e i numeri dispari in ordine decrescente,
    restituendo un array con prima tutti i numeri pari ordinati e poi quelli dispari*/
    private static int[] evenOddSearch(int[] arrayNumeri)
    {
        int[] arrayOrdinato = new int[arrayNumeri.length]; // Inizializziamo arrayOrdinato con la stessa dimesione di arrayNumeri
        int j=0, k = 0;

        int [] pariCrescenti={};
        int [] dispariDecrescenti={};

        int temp; //variabile temporanea per l'ordinamento

        for(int i = 0; i < arrayNumeri.length; i++) //scorre l’array di numeri
        {
            if((arrayNumeri[i] %2) == 0) //verifica se sono pari
            {
                pariCrescenti[j]=arrayNumeri[i]; //copia numero dull'array dei numeri pari
                j++;
            }
            else //nel caso siano dispari
            {
                dispariDecrescenti[k]=arrayNumeri[i]; //copia numero sull'array dei numeri dispari
                k++;
            }
        }

        //ordinamento numeri pari in ordine crescente
        for (int index = 0; index < j - 1; index++)
        {
            for (int index2 = 0; index2 < j - index - 1; index2++)
            {
                if (pariCrescenti[index2] > pariCrescenti[index2 + 1])
                {
                    temp = pariCrescenti[index2];
                    pariCrescenti[index2] = pariCrescenti[index2 + 1];
                    pariCrescenti[index2 + 1] = temp;
                }
            }
        }

        //ordinamento numeri dispari in ordine decrescente
        for (int index = 0; index < k - 1; index++)
        {
            for (int index2 = 0; index2 < k - index - 1; index2++)
            {
                if (dispariDecrescenti[index2] < dispariDecrescenti[index2 + 1])
                {
                    temp = dispariDecrescenti[index2];
                    dispariDecrescenti[index2] = dispariDecrescenti[index2 + 1];
                    dispariDecrescenti[index2 + 1] = temp;
                }
            }
        }

        //unione dei due array ordinati
        for (int indexOrdinato = 0; indexOrdinato < arrayNumeri.length; indexOrdinato++)
        {
            if(indexOrdinato<=j)
                arrayOrdinato[indexOrdinato] = pariCrescenti[indexOrdinato];
            else
                arrayOrdinato[indexOrdinato] = dispariDecrescenti[indexOrdinato];
        }

        return arrayOrdinato;
    }

    /*metodo per la ricerca binaria sull'array ordinato*/
    private static int biBinarySearch(int[] arrayNumeri, Scanner tastiera )
    {
        //dichiarazione variabili
        int key = 0, numero = 0, nMax = arrayNumeri.length-1, nMin = 0;

        //acquisizione numero da cercare
        System.out.println("Inserire il numero da cercare nell'array: ");
        numero = tastiera.nextInt() ;

        //ricerca binaria
        for (int i = 1; i < arrayNumeri.length; i++) //scorre l'array
        {
            if (arrayNumeri[i-1] % 2 == 0 && arrayNumeri[i] % 2 == 1)
            {
                if ((numero % 2 == 0 && numero >= arrayNumeri[i-1]) || (numero %2 == 1 && numero >= arrayNumeri[i]))
                {
                    return -1;
                }
                else if (numero % 2 == 0)
                {
                    nMax = i - 1;
                }
                else
                {
                    nMin = i;
                }

                break;
            }
        }

        if (numero % 2 == 0)
        {
            while (nMin <= nMax)
            {
                key = (nMin + nMax) / 2;
                if (numero == arrayNumeri[key])
                {
                    return key;
                }
                else if (numero < arrayNumeri[key])
                {
                    nMax = key - 1;
                }
                else
                {
                    nMin = key + 1;
                }
            }
        }

        else
        {
            while (nMin <= nMax)
            {
                key = (nMin + nMax) / 2;

                if (numero == arrayNumeri[key])
                {
                    return key;
                }

                else if (numero > arrayNumeri[key])
                {
                    nMax = key - 1;
                }

                else
                {
                    nMin = key + 1;
                }
            }
        }

        return -1;
    }

}