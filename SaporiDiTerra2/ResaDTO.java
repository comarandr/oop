package it.uniud.poo.compiti.saporiditerra2;

/**
 * classe che serve a rappresentare una resa sotto forma di due numeri:
 * - la quantità di ortaggio prodotta in assoluto (kg)
 * - e in relativo (kg/m)
 * NOTA: è immutabile
 */
public class ResaDTO {
    final double quantitaProdottaInAssoluto;
    final double quantitaProdottaInRelativo;

    public ResaDTO(double quantitaProdottaInAssoluto, double quantitaProdottaInRelativo) {
        this.quantitaProdottaInAssoluto = quantitaProdottaInAssoluto;
        this.quantitaProdottaInRelativo = quantitaProdottaInRelativo;
    }
}
