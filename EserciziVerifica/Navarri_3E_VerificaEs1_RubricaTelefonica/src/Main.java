import static tools.Utility.*;

//importazione libreria
import java.util.Scanner;

public class Main //creazione classe main
{
    public static void main(String[] args) //metodo principale
    {
        //stringa costante con opzioni del menù
        String[] operazioni = { "RUBRICA TELEFONICA",
                "[1] Inserisci contatto",
                "[2] Visualizza contatti",
                "[3] Modifica contatto",
                "[4] Elimina contatto",
                "[5] Effettua telefonata",
                "[6] Visualizza registro chiamate",
                "[7] Modifica Password",
                "[8] Fine" };

        //menù dei contatti da visualizzare
        String[] visualizzaNascosti = {"Visualizzare anche contatti nascosti?", "[1] sì", "[2] no"};
        //dichiarazione e inizializzazione delle variabili
        int maxContatti=10; //numero massimo di contatti che è possinile inserire
        int nContatto=0, scelta=0, chiamate=0;
        int index;
        String passwordInserita="", passwordGiusta="0000";
        String svuotaBuffer;
        boolean fine =true;

        Scanner scanner=new Scanner(System.in); //creazione scanner
        Contatto [] rubrica = new Contatto[maxContatti]; //array di contatti

        do
        {
            ClrScr(); //cancella schermo

            switch (menu(operazioni, scanner))
            {
                case 1: //inserimento contatto in rubrica
                    ClrScr(); //cancella schermo

                    //controllo disponibilità di inserimento
                    if (nContatto < maxContatti)
                    {
                        //inserimento e controllo di un nuovo contatto
                        do{
                            rubrica[nContatto]=inserisci(scanner);
                            nContatto++;

                            if(ripetiContatto(rubrica, nContatto)==1)
                            {
                                System.out.println("Contatto già esistente. Reinserire");
                            }
                        }while(ripetiContatto(rubrica,  nContatto)==1);
                    }
                    else
                        System.out.println("Raggiunto il numero massimo di contatti");
                    svuotaBuffer=scanner.nextLine();

                    break;

                case 2: //visualizza contatti in rubrica
                    ClrScr(); //cancella schermo

                    System.out.println("\nCONTATTI IN RUBRICA: \n");
                    //stampa solo contatti visibili
                    visualizza(rubrica,nContatto, scelta, chiamate);

                    //richiesta di visualizzazione contatti nascosti
                    scelta=menu(visualizzaNascosti,scanner);

                    //verifica scelta
                    if(scelta==1)
                    {
                        do
                        {
                            //inserimento e verifica password per visualizzare contatti nascosti
                            System.out.println("Inserire password: ");
                            passwordInserita=scanner.nextLine();

                            if(passwordInserita.equals(passwordGiusta))
                            {
                                //stampa contatti con anche quelli nascosti
                                visualizza (rubrica, nContatto, scelta, chiamate);
                            }
                            else
                                System.out.println("Password errata");
                        }while(!passwordInserita.equals(passwordGiusta));
                    }
                    scelta=0; //reinizializzare la variabile

                    break;

                case 3: //modifica contatto
                    ClrScr(); //cancella schermo

                    //stampa menù contati da modificare
                    System.out.println("\nCONTATTI MODIFICABILI:\n");
                    menuRubrica(rubrica, nContatto, scanner, scelta);

                    //richiesta di visualizzazione contatti nascosti
                    scelta=menu(visualizzaNascosti,scanner);

                    //verifica scelta
                    if(scelta==1)
                    {
                        do
                        {
                            //inserimento e verifica password per visualizzare conatti nascosti
                            System.out.println("Inserire password: ");
                            passwordInserita=scanner.nextLine();

                            if(passwordInserita.equals(passwordGiusta))
                            {
                                //acquisizione indice del contatto da modificare
                                index=menuRubrica(rubrica, nContatto, scanner, scelta);
                                scanner.nextLine();
                                //acquisizione nuovi dati
                                rubrica[index]=inserisci(scanner);
                                System.out.println("Modifica effettuata");
                                scanner.nextLine();
                            }
                            else
                                System.out.println("Password errata");
                        }while(!passwordInserita.equals(passwordGiusta));
                    }
                    else
                    {
                        //acquisizione indice del contatto da modificare
                        index=menuRubrica(rubrica, nContatto, scanner, scelta);
                        scanner.nextLine();
                        //acquisizione nuovi dati
                        rubrica[index]=inserisci(scanner);
                        System.out.println("Modifica effettuata");
                        scanner.nextLine();
                    }

                    scelta=0; //reinizializzare la variabile

                    break;

                case 4: //elimina contatto
                    ClrScr(); //cancella schermo

                    //stampa menù contati da modificare
                    System.out.println("\nCONTATTI ELIMINABILI:\n");
                    menuRubrica(rubrica, nContatto, scanner, scelta);

                    //richiesta di visualizzazione contatti nascosti
                    scelta=menu(visualizzaNascosti,scanner);

                    //verifica scelta
                    if(scelta==1)
                    {
                        do
                        {
                            //inserimento e verifica password per visualizzare conatti nascosti
                            System.out.println("Inserire password: ");
                            passwordInserita=scanner.nextLine();

                            if(passwordInserita.equals(passwordGiusta))
                            {
                                //acquisizione indice del contatto da eliminare
                                index=menuRubrica(rubrica, nContatto, scanner, scelta);
                                scanner.nextLine();
                                //eliminazione contatto
                                elimina(rubrica, index,nContatto);
                                nContatto--;
                                System.out.println("Eliminazione effettuata");
                                scanner.nextLine();
                            }
                            else
                                System.out.println("Password errata");
                        }while(!passwordInserita.equals(passwordGiusta));
                    }
                    else
                    {
                        //acquisizione indice del contatto da eliminare
                        index=menuRubrica(rubrica, nContatto, scanner, scelta);
                        scanner.nextLine();
                        //eliminazione contatto
                        elimina(rubrica, index,nContatto);
                        nContatto--;
                        System.out.println("Eliminazione effettuata");
                        scanner.nextLine();
                    }

                    scelta=0; //reinizializzare la variabile

                    break;


                case 5: //effettuare telefonate

                    ClrScr(); //cancella schermo

                    //stampa menù contati da chiamare
                    System.out.println("\nCONTATTI A CUI E' POSSIBILE EFFETTUARE UNA TELEFONATA:\n");
                    menuRubrica(rubrica, nContatto, scanner, scelta);

                    //richiesta di visualizzazione contatti nascosti
                    scelta=menu(visualizzaNascosti,scanner);

                    //verifica scelta
                    if(scelta==1)
                    {
                        do
                        {
                            //inserimento e verifica password per visualizzare conatti nascosti
                            System.out.println("Inserire password: ");
                            passwordInserita=scanner.nextLine();

                            if(passwordInserita.equals(passwordGiusta))
                            {
                                //acquisizione indice del contatto da chiamare
                                index=menuRubrica(rubrica, nContatto, scanner, scelta);
                                scanner.nextLine();
                                //effettuazione telefonata
                                rubrica[index].nChiamate++;
                                System.out.println("Chiamata effettuata");
                                scanner.nextLine();
                            }

                            else
                                System.out.println("Password errata");
                        }while(!passwordInserita.equals(passwordGiusta));
                    }
                    else
                    {
                        //acquisizione indice del contatto da chiamare
                        index=menuRubrica(rubrica, nContatto, scanner, scelta);
                        scanner.nextLine();
                        //effettuazione telefonata
                        rubrica[index].nChiamate++;
                        System.out.println("Chiamata effettuata");
                        scanner.nextLine();
                    }

                    scelta=0; //reinizializzare la variabile

                    break;

                case 6: //visualizza elenco chiamate
                    ClrScr(); //cancella schermo
                    chiamate=1;


                    System.out.println("REGISTRO DELLE TELEFONATE: ");
                    //stampa solo contatti visibili
                    visualizza(rubrica,nContatto, scelta, chiamate);
                    //richiesta di visualizzazione contatti nascosti
                    scelta=menu(visualizzaNascosti,scanner);
                    //verifica scelta
                    if(scelta==1)
                    {
                        do
                        {
                            //inserimento e verifica password per visualizzare conatti nascosti
                            System.out.println("Inserire password: ");
                            passwordInserita=scanner.nextLine();

                            if(passwordInserita.equals(passwordGiusta))
                            {
                                //stampa contatti con anche quelli nascosti
                                visualizza(rubrica, nContatto, scelta, chiamate);
                            }
                            else
                                System.out.println("Password errata");
                        }while(!passwordInserita.equals(passwordGiusta));
                    }
                    else
                    {
                        //stampa contatti visibili
                        visualizza(rubrica, nContatto, scelta, chiamate);
                    }

                    scelta=0; //reinizializzare la variabile

                    break;

                case 7: //modifica password
                    ClrScr(); //cancella lo schermo

                    //acquisizione e verifica vecchia password
                    do {
                        System.out.println("Inserire la vecchia password: ");
                        passwordInserita=scanner.nextLine();

                        if(!(passwordInserita.equals(passwordGiusta)))
                        {
                            System.out.println("Password errata");
                        }
                    }while (!(passwordInserita.equals(passwordGiusta)));

                    //acquisizione e verifica nuova password
                    do {
                        System.out.println("Inserire la nuova password: ");
                        passwordGiusta=scanner.nextLine();

                        if(passwordGiusta.equals(""))
                        {
                            System.out.println("Password non valida");
                        }
                    }while (passwordGiusta.equals(""));

                    break;

                default:
                    System.out.println("Fine programma");
                    fine=false;
                    break;
            }
        }while(fine);
    }

    //metodo per la creazione di un nuovo contatto
    private static Contatto inserisci (Scanner scanner)
    {
        String svuotaBuffer;
        String []stato={"Inserire stato del contatto:", "[1] Visibile", "[2] Nascosto"};

        //Istanziato un oggetto di tipo contatto
        Contatto persona = new Contatto();

        //acquisizione e verifica dati contatto
        do {
            System.out.println("\nInserire nome: ");
            persona.nome = scanner.nextLine();
            if(persona.nome.equals(""))
            {
                System.out.println("Nome inserito non valido");
            }
        }while(persona.nome.equals(""));
        do {
            System.out.println("\nInserire cognome: ");
            persona.cognome = scanner.nextLine();
            if(persona.cognome.equals(""))
            {
                System.out.println("Cognome inserito non valido");
            }
        }while(persona.cognome.equals(""));

        System.out.println("\nInserire il numero di telefono: ");
        persona.telefono = scanner.nextInt();

        svuotaBuffer=scanner.nextLine();
        //stampa menù stato e acquisizione scelta
        switch (menu(stato, scanner))
        {
            case 2:
                persona.nascosto=true;
                break;
            default:
                persona.nascosto=false;
                break;
        }
        return persona;
    }

    //metodo per verificare che i contatti non si ripetano
    private static int ripetiContatto (Contatto []rubrica, int nContatto)
    {
        nContatto--;
        for (int i=0; i<nContatto; i++)
        {
            if(rubrica[nContatto].nome.equals(rubrica[i].nome) && rubrica[nContatto].cognome.equals(rubrica[i].cognome) && (rubrica[nContatto].telefono)==(rubrica[i].telefono))
                return 1;
        }
        return 0;
    }

    /* metodo per stampare i contatti,
      se si vogliono vedere anche quelli nascosti
      bisogna inserire una password */
    private static void visualizza(Contatto[] rubrica, int nContatto, int scelta, int chiamate) {
        // Controlla se ci sono contatti in rubrica
        if (nContatto == 0) {
            System.out.println("Nessun contatto inserito");
        } else {
            // Verifica se vanno stampati anche i contatti nascosti
            if (scelta == 1) {
                for (int i = 0; i < nContatto; i++) {
                    if (chiamate == 1) {
                        System.out.println(rubrica[i].stampa()+ "Chiamate effettuate: " + rubrica[i].nChiamate+ "\n");

                    } else {
                        System.out.println(rubrica[i].stampa()+"\n");
                    }
                }
            } else
            {
                for (int i = 0; i < nContatto; i++)
                {
                    // Controlla se è visibile
                    if (!rubrica[i].nascosto) {
                        if (chiamate == 1) {
                            System.out.println(rubrica[i].stampa() + "Chiamate effettuate: " +rubrica[i].nChiamate+"\n");
                        } else {
                            System.out.println(rubrica[i].stampa()+"\n");
                        }
                    }
                }
            }
        }
    }

    /*metodo per stampare i contatti come menù,
    se si vogliono vedere anche quelli nascosti
    bisogna inserire una password
    + acquisizione e verifica indice */
    private static int menuRubrica(Contatto []rubrica, int nContatto, Scanner scanner, int scelta) {
        //dichiarazione variabile
        int index=-1;


        //controlla se ci sono contatti in rubrica
        if (nContatto == 0)
        {
            System.out.println("Nessun contatto inserito");
        }
        else
        {
            //verifica se vanno stampati anche i contatti nascosti
            if(scelta==1)
            {
                //stampa del menù con i vari contatti tra cui scegliere
                for (int i = 0; i < nContatto; i++)
                {
                    System.out.println("[" + (i+1) + "] " + rubrica[i].stampa());
                }
            }
            //stampa solo contatti visibili
            else
            {
                for (int i = 0; i < nContatto; i++)
                {
                    //controlla se è visibile
                    if (!rubrica[i].nascosto)
                    {
                        System.out.println("[" + (i+1) + "] " + rubrica[i].stampa());
                    }
                }
            }

            //acqusizione e verifica scelta
            if(scelta==2)
            {
                do
                {
                    System.out.println("\nInserire numero del contatto: ");
                    index=scanner.nextInt()-1;
                    if(index<0 || index>nContatto || rubrica[index].nascosto)
                    {
                        System.out.println("Valore inserito non valido");
                    }
                }while(index<0 || index>nContatto || rubrica[index].nascosto);
            }
            else if(scelta== 1)//nascosti
            {
                do
                {
                    System.out.println("\nInserire numero del contatto: ");
                    index=scanner.nextInt()-1;
                    if(index<0 || index>nContatto)
                    {
                        System.out.println("Valore inserito non valido");
                    }
                }while(index<0 || index>nContatto);
            }

            return index;
        }
        return index;
    }

    /*metodo per eliminare un contatto dalla rubrica e ordinare i rimanenti*/
    private static void elimina(Contatto[]rubrica, int index, int nContatto)
    {
        //controlla se ci sono contatti in rubrica
        if (nContatto == 0)
        {
            System.out.println("Nessun contatto inserito");
        }
        else
        {
            //cancellazione dei dati
            rubrica[index].nome = null;
            rubrica[index].cognome = null;
            rubrica[index].telefono = 0;

            //ordina i contatti rimanenti
            for (int i = 0; i < nContatto-1; i++)
            {
                if (rubrica[i].nome == null && rubrica[i].cognome == null && rubrica[i].telefono == 0)
                {
                    for (int j = i; j < nContatto; j++)
                    {
                        rubrica[j] = rubrica[j + 1];
                    }
                }
            }
        }
    }


}