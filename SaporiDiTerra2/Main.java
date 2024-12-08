package it.uniud.poo.compiti.saporiditerra2;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * Classe dimostrativa per l'utilizzo del sistema
 */
class Main {
    public static void main(String[] args) {
        try {
            // Creazione dell'azienda
            AziendaAgricola azienda = new AziendaAgricola();

            int numeroFilare = 1;
            int numeroAppezzamento = 1;
//            azienda.ottieniFilare(numeroFilare, numeroAppezzamento);

            // Ottiene il primo appezzamento e il primo filare
            Appezzamento app1 = azienda.ottieniAppezzamento(1);
            Filare filare1 = app1.ottieniFilare(1);

            // Alloca alcune colture
            // metodo operazione n 1
            Coltura pom = new Coltura("Pomodori");
            filare1.allocaColtura(pom, 10.0);
            // questo solleverebbe un'eccezione
            try {
                filare1.allocaColtura(pom, 50.0);
            } catch (SaporiDiTerraException e) {
                System.out.println("Eccezione sollevata: " + e.getMessage());
            }


//            //
//            filare1.registraProduzione("Pomodori",
//                new Produzione(100.0, 20.0, LocalDate.now()));
//
//            filare1.registraProduzione(pom, registroProduzioni);
//            filare1.registraProduzione(pom, azienda.ottieniRegistroProduzioni());
//            filare1.registraProduzione(pom, azienda);

            // metodo per operazione n. 2 e n. 3
            azienda.registraTerminazioneColtura(pom, filare1, 10.0F);


            Dashboard dashboard = azienda.getDashboard();
            int appezzamento = 1;
            Double x = dashboard.calcolaResaAppezzamenti(appezzamento);
            Double y = dashboard.calcolaResaAppezzamenti();
            Double z = dashboard.calcolaResaAppezzamenti(appezzamento, "pomodori", Periodo.SETTIMANA);

            // TODO pensare se produrre elenco delle rese

            ResaDTO a = dashboard.calcolaResaColture();
            ResaDTO b = dashboard.calcolaResaColture(pom);
            ResaDTO c = dashboard.calcolaResaColture("pomodori");
            ResaDTO d = dashboard.calcolaResaColture("pomodori", Periodo.MESE);

            ResaDTO rr = new ResaDTO(40.0, 10.5);
            double abc = rr.quantitaProdottaInAssoluto;

//
//            filare1.registraProduzione("Insalata",
//                new Produzione(50.0, 20.0, LocalDate.now()));
//
//            app1.aggiungiFilare(3, filare1);
//            Filare gf = new GrandeFilare();
//
//            app1.aggiungiFilare(2, gf);
//            app1.aggiuntiColtura(2, "Patate", 50.0);
//
//            app1.aggiuntiColtura(3, "Pomodori", 10.0);
//            app1.aggiuntiColtura(2, "Insalata", 10.0);
//



            // Ottiene statistiche
            System.out.println("Statistiche colture:");
            azienda.ottieniStatisticheColture()
                  .forEach((coltura, resa) ->
                      System.out.printf("%s: %.2f kg/m%n", coltura, resa));

            // Ottiene produzioni ultima settimana
            System.out.println("\nProduzioni ultima settimana:");
            azienda.ottieniProduzioniUltimoPeriodo(7)
                  .forEach((coltura, kg) ->
                      System.out.printf("%s: %.2f kg%n", coltura, kg));

        } catch (SaporiDiTerraException | ValoreIllegaleException e) {
            System.err.println("Errore di dominio: " + e.getMessage());
//        } catch (IllegalArgumentException | ValoreIllegaleException e) {
//            System.err.println("Errore nei parametri: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("Errore inaspettato: " + e.getMessage());
//            e.printStackTrace();
        }
    }
}