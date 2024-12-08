# Note varie su alcune classi

## Filare singolo

Rappresentazione astratta di un filare di ortaggi
- un filare ha una lunghezza massima, che non varia
- un filare può contenere 0+ colture, ciascuna dedicata a un ortaggio
- ciascuna Coltura occupa uno spazio contiguo
- 2 colture non possono condividere lo stesso spazio
- è possibile avere spazi vuoti tra gli spazi di due colture
- non è possibile avere una coltura che inizia prima dell'inizio del filare o che
  finisce dopo la fine del filare
- un filare memorizza le colture concluse

## Filare doppio
Rappresentazione astratta:
- un filare doppio è composto da due striscie di terra

Stato concreto:
- due filari
Invariante di rappresentazione:
- i due filari devono avere la stessa tipologia
- i due filari devono avere la stessa lunghezza

### Tipologie di filari

- filare doppio

- filare in pendio
- filare in piano
- filare in ombra
- filare in pieno sole

### Metodi

#### assegnaFilare(Percentuale, Ortaggio) -> Coltura

POST:

- `Percentuale` è un numero compreso tra 0 e 100, altrimenti solleva Eccezione
- lo spazio disponibile è ridotto di percentuale & la coltura è aggiunta al filare & 
  la coltura viene creata con la data corrente e restituita, purché ci sia spazio disponibile contiguo
  altrimenti solleva Eccezione
- NOTA: lo spazio disponibile è calcolato sol osulla base di colture in-corso


#### assegnaFilare(Posizione1, Posizione2, Ortaggio) -> Coltura

POST:
- `Posizione1` e `Posizione2` sono numeri interi compresi tra 0 e lunghezzaFilare
- `Posizione1` è minore di `Posizione2`
- la coltura è aggiunta al filare & la coltura viene creata con data corrente e restituita,  
  purché l'intervallo (Posizione1, Posizione2) sia libero, altrimenti solleva Eccezione
- NOTA: lo spazio disponibile è calcolato sol osulla base di colture in-corso

#### raccogli(Coltura) -> Quantita

POST:
- la quantità di ortaggi raccolti è restituita e la coltura è rimossa dal filare
  e il suo spazio viene reso disponibile; la coltura diventa conclusa, le
  viene assegnata una data di raccolta.
- NOTA: la quantità di ortaggi raccolti è calcolata in base alla produzione
  dell'ortaggio e al periodo di raccolta e lo stato di salute

#### calcolaSpazioDisponibile() -> int

POST:
- restituisce lo spazio disponibile nel filare, >=0, <=lunghezzaFilare
- NOTA: lo spazio disponibile è calcolato sol osulla base di colture in-corso

#### verificaSpazioDisponibile(Percentuale) -> Boolean
#### verificaSpazioDisponibile(Posizione1, Posizione2) -> Boolean

POST:
- restituisce true se c'è spazio disponibile di almeno `Percentuale` % o
  se c'è spazio disponibile nell'intervallo (Posizione1, Posizione2), altrimenti false
- NOTA: lo spazio disponibile è calcolato sol osulla base di colture in-corso

#### calcolaProduzione(Data1, Data2, Ortaggio) -> Quantita

POST:
-  sleeziona le colture che sono state raccolte tra Data1 e Data2 e che sono
    relative all'ortaggio, e calcolo la somma delle quantità raccolte




## Coltura

Rappresentazione astratta:
- può essere conclusa (raccolta con successo ,o fallita) o in-corso
- data di semina
- data di raccolta
- date iniziale e finale previste di raccolta
- sa quale sia l'ortaggio
- la lunghezza nel filare
- quantità di ortaggi raccolti (valido solo per quelle concluse; 0 per quelle in corso)

### Coltura(Ortaggio, DataSemina, Lunghezza)

POST:
- `DataSemina` è una data valida, altrimenti solleva Eccezione
- `Lunghezza` è un numero intero positivo, altrimenti solleva Eccezione
- la data di semina è impostata a `DataSemina`
- lo stato è in-corso
- calcola le date previste di raccolta e le memorizza



### raccogli()

POST:
- cambia lo stato in conclusa e assegna una data di raccolta, purché sia in-corso
  altriemnti solleva Eccezione
- e calcola la produzione e la memorizza

### raccoltoPronto() -> Boolean

POST:
- restituisce true se data corrente inclusa tra data iniziale e finale previste di raccolta,  
  altrimenti false


### aggiungiRitardo(TempoDiRitardo) -> void

POST:
- TempoDiRitardo è un numero intero positivo, altrimenti solleva Eccezione
- la data di raccolta prevista viene posticipata di TempoDiRitardo, 
  modificando le date iniziale e finale previste di raccolta

### monitoraStatoSalute() -> StatoSalute

POST:
- restituisce lo stato di salute della coltura, che può essere Buono, Normale, Cattivo


### calcolaDatePrevisteRaccolta(Ortaggio) -> data1, data2

POST:
- calcola la data iniziale e finale previste di raccolta, calcolate in base all'ortaggio







# Metodo

1. identificare classi, "cosa sa" e "cosa sa fare"
2. identificare metodi e loro parametri
3. identificare pre e post condizioni
4. definire la rappresentazione astratta della classe
   5. tipo di informazioni
   6. vincoli e condizioni di validità
7. verificare che i contratti siano soddisfacibili con le info disponibili nella rappresentazione astratta