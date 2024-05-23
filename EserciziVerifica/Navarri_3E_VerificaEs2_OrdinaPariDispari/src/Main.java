//importazione libreria
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //dichiarazione e inizializzazione delle variabili
        int scelta = 0;
        int[] array = new int[10];
        int[] nuovoArray = new int[11];

        Scanner scanner = new Scanner(System.in); //creazione scanner

        // Acquisizione e verifica dei numeri, inserendoli nell'array
        for (int i = 0; i < 11; i++)
        {
            // Richiesta all'utente se vuole inserire anche l'undicesimo numero
            if (i == 10)
            {
                do
                {
                    System.out.println("Inserire 11 numero?\n[1] sì\n[2] no\n");
                    scelta = scanner.nextInt();
                } while ((scelta != 1) && (scelta != 2));

                if (scelta == 1)
                {
                    // Copia dei 10 elementi precedenti nel nuovo array
                    System.arraycopy(array, 0, nuovoArray, 0, array.length);

                    // Acquisizione 11 numero
                    do {
                        System.out.println("Inserire " + (i + 1) + " numero: ");
                        nuovoArray[i] = scanner.nextInt();

                        if (verificaNumero(nuovoArray[i], nuovoArray, i) == -1)
                            System.out.println("Il numero inserito non appartiene all'intervallo di valori corretto \n(deve essere compreso tra 1 e 30) ");

                        else if (verificaNumero(nuovoArray[i], nuovoArray, i) == 1)
                            System.out.println("Il numero inserito è già presente nell'array");

                    } while (verificaNumero(nuovoArray[i], nuovoArray, i) != 0);

                }
            }
            else
            {
                do
                {
                    System.out.println("Inserire " + (i + 1) + " numero: ");
                    array[i] = scanner.nextInt();

                    if (verificaNumero(array[i], array, i) == -1)
                        System.out.println("Il numero inserito non appartiene all'intervallo di valori corretto \n(deve essere compreso tra 1 e 30) ");

                    else if (verificaNumero(array[i], array, i) == 1)
                        System.out.println("Il numero inserito è già presente nell'array");

                } while (verificaNumero(array[i], array, i) != 0);
            }
        }

        if (scelta == 1)
        {
            // Stampa a schermo dell'array non ordinato
            System.out.println("ARRAY DI NUMERI NON ORDINATO: ");
            stampa(nuovoArray);

            // Ordinamento dei numeri all'interno dell'array
            ordina(nuovoArray);

            //verifica se l'array è già ordinato
            if(ordina(nuovoArray) ==1)
                System.out.println("\nL'array è già ordinato");

            // Stampa a schermo dell'array ordinato
            System.out.println("\nARRAY DI NUMERI ORDINATO: ");
            stampa(nuovoArray);
        }

        else
        {
            // Stampa a schermo dell'array non ordinato
            System.out.println("ARRAY DI NUMERI NON ORDINATO: ");
            stampa(array);

            // Ordinamento dei numeri all'interno dell'array
            ordina(array);

            //verifica se l'array è già ordinato
            if(ordina(array) ==1)
                System.out.println("\nL'array è già ordinato");

            // Stampa a schermo dell'array ordinato
            System.out.println("\nARRAY DI NUMERI ORDINATO: ");
            stampa(array);
        }
    }

    /*metodo per la verifica dei numeri inseriti che
    devono essere commpresi tra 1 e 30,
    e non devono ripetersi all'interno dell'array*/
    private static int verificaNumero (int n, int [] array, int index)
    {
        //controlla che sia positivo e sia compreso tra 1 e 30
        if((n<1) || (n>30))
            return -1; //il valore non appartiene all'intervallo di numeri corretto

        //controlla che non si ripeta
        for (int i = 0; i < index; i++)
        {
            if (n == array[i])
            {
                return 1; //il valore è già presente nell'array
            }
        }

        return 0; //il valore rispetta tutti i criteri
    }

    //metodo per la stampa dell'array
    private static void stampa (int[] array)
    {
        for(int i=0; i< array.length; i++)
        {
            System.out.print(array[i]+" ");
        }
    }

    /*metodo per ordinare l'array dei numeri inseriti in modo che
    i numeri pari sono ordinati in modo crescente
    la posizione dei numeri dispari e dell'ultimo elemento dell'array rimane invariata */
    private static int ordina (int []array)
    {
        //dichiarazione e inizialzizazione delle variabili
        int contaPari = 0;
        int index = 0;

        //conta il numero di elementi pari tralasciando l'ultimo elemento
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] % 2 == 0)
            {
                contaPari++;
            }
        }

        //creazione 2 array, uno per i numeri pari da ordinare e l'altra per le posizioni che occupavano
        int[] arrayPari = new int[contaPari];
        int[] posizioni = new int[contaPari];

        //inserimento numeri pari e le relative posizioni all'interno degli appositi array
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] % 2 == 0)
            {
                arrayPari[index] = array[i];
                posizioni[index] = i;
                index++; //incremeno indice degli array
            }
        }

        //ordinamento numeri pari invocando il metodo selection sort
        selectionSort(arrayPari);

        //inserimento numeri pari in ordine crescente nelle posizioni che occupavano in principio
        for (int i = 0; i < arrayPari.length; i++)
        {
            array[posizioni[i]] = arrayPari[i];
        }

        //se non ci sono numeri pari da ordinare, l'array è già ordinato
        if ((contaPari==0) || (selectionSort(arrayPari)==1))
        {
            return 1;
        }

        return 0;
    }
    //metodo di ordinamento selection sort per ordinare i numeri pari
    private static int selectionSort(int[] arrayPari)
    {
        //dichiarazione e inizializzzazione delle variabili
        int scambio=0;
        int temp; //variabile per lo scambio dei valori

        for (int i = 0; i < arrayPari.length - 1; i++)
        {
            int minIndex = i; //assegnazione indice del valore minore

            //trova il valore minore
            for (int j = i + 1; j < arrayPari.length; j++)
            {
                if (arrayPari[j] < arrayPari[minIndex])
                {
                    minIndex = j; //assegnazione indice del valore minore
                    scambio++;
                }
            }
            //scambio del valore minore con quello di indice i
            temp = arrayPari[minIndex];
            arrayPari[minIndex] = arrayPari[i];
            arrayPari[i] = temp;

        }

        //verifica se l'array era già ordinato
        if(scambio==0)
            return 1;

        return 0;
    }
}