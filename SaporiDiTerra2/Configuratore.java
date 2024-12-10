package it.uniud.poo.compiti.saporiditerra2;
/*
    * MISSION: contenere tutte le scelte su come istanziare i vari oggetti dell'azienda agricola
 */
public class Configuratore {
    AziendaAgricola configuraAzienda(){
        AziendaAgricola az = new AziendaAgricola();

        //...
        Filare f1 = new Filare();
        Filare f2 = new Filare();
        //aggiungere i filari agli appezzamenti
        DashboardPassiva dashboardSuTerreno = new DashboardPassiva();
        DashboardPassiva dashboardSuProduzione = new DashboardPassiva();
        azienda.addDashboard(dashboardSuTerreno);
        azienda.addDashboard(dashboardSuProduzione);
        f1.addObserver(dashboardSuTerreno);
        f1.addObserver(dashboardSuProduzione);

        return az;
    }
}
