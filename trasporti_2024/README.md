# NOTE SULLA SOLUZIONE

Si tratta d un progetto realizzato solo in parte, a fronte del tema
d'esame proposto per l'anno 2023/2024.

Non è completo e non è stato testato. È da considerarsi una
traccia di come risolvere un tema d'esame e vuole esemplificare alcuni
aspetti che sono importanti.

## VALUTAZIONE  

### Distribuzione delle responsabilità

Si vede un gran numero di classi, quasi tutte con dei metodi non banali
che implementano una parte di logica.
Questo suggerisce una discreta distribuzione delle responsabilità, e applicazione
del principio di singola responsabilità.

Ad es. ci sono classi per la gestione della flotta, dell'elenco delle 
prenotazioni, delle query.

### Incapsulamento

In molti casi lo stato concreto di un tipo è stato incapsulato e non
traspare all'esterno. Anche se si può fare di meglio.
In alcuni casi ci sono oggetti immutabili.

### API

Esiste una classe principale che implementa completamente i 3 metodi 
richiesti. Questo è un buon segno, perchè significa che l'API è stata
pensata in modo da essere usata in modo semplice.

E come richiesto esiste anche il Main che mostra come si può usare
tale API.

### Contratti

In molti casi e comunque per i metodi principali, sono stati definiti
i contratti, con pre e post condizioni più o meno esplicite.

### Tipi di dati astratti

Per varie classi è stata definita la mission, e in maniera più o meno esplicita
lo stato astratto, lo stato concreto e gli evntuali invarianti di rappresentazione. 

### Clean code

Si vede un uso estensivo degli stream e delle lambda, che rendono il codice
molto conciso e snello. 
Inoltre i metodi hanno relativamente pochi parametri, hanno nomi evocativi,
e sono brevi.

### Pattern

È stato usato lo schema 'Factory', 'Observer', 'Composite'. Soprattutto
quest'ultimo è stato usato in maniera molto efficace per costruire i diversi tipi 
di operatori AND, OR, NOT.
