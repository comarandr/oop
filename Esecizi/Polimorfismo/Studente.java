package Polimorfismo;

public class Studente extends Persona {

    private int matricola;
    private String università;
    public Studente(String codiceFiscale, String nome, String cognome,
                    int matricola, String università) {
        super(codiceFiscale, nome, cognome);
        this.matricola=matricola;
        this.università = università;
    }
    public int getMatricola() {
        return matricola;
    }
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
    public String getUniversità() {
        return università;
    }
    public void setUniversità(String università) {
        this.università = università;
    }

    @Override
    public String toString() {
        return getCodiceFiscale() + "," + getNome() + "," + getCognome() + "," + getMatricola() + "," + getUniversità();
    }



}
