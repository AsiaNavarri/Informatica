public class Contatto
{
    //dichiarazione e inizializzazione delle variabili
    String nome;
    String cognome;
    int telefono;
    boolean nascosto; //se = false è visibile, se = true è nascosto
    int nChiamate=0;

    //metodo per la stampa dei dati del contatto
    public String stampa()
    {
        return String.format("Nome: %s\tCognome: %s\nNumero di Telefono: %s\t", nome, cognome, telefono);
    }

}
