package it.uniud.poo.compiti.saporiditerra2;

/**
 * Eccezione custom per errori di dominio specifici dell'applicazione
 */
class SaporiDiTerraException extends Exception {
    public SaporiDiTerraException(String message) {
        super(message);
    }
}
