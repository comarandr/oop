package it.uniud.poo.compiti.saporiditerra2;

import java.time.LocalDate;

/**
 * Classe dimostrativa per l'utilizzo del sistema
 */
class Main {
    public static void main(String[] args) {
        try {
            // Creazione dell'azienda
            AziendaAgricola azienda = new AziendaAgricola();

            // Ottiene il primo appezzamento e il primo filare
            Appezzamento app1 = azienda.ottieniAppezzamento(1);
            Filare filare1 = app1.ottieniFilare(1);

            // Alloca alcune colture
            filare1.allocaColtura("Pomodori", 810.0);
            filare1.allocaColtura("Insalata", 50.0);

            // Registra alcune produzioni
            filare1.registraProduzione("Pomodori",
                new Produzione(100.0, 20.0, LocalDate.now()));
            filare1.registraProduzione("Insalata",
                new Produzione(50.0, 20.0, LocalDate.now()));

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