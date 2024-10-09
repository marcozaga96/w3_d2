package marcozagaria.entities;

import jakarta.persistence.*;
import marcozagaria.Enum.EventType;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id //per indicare la colonna primaria
    @GeneratedValue(strategy = GenerationType.AUTO) // per generare in automatico gli id
    private long id;
    @Column(name = "titolo", nullable = false)// per creare ogni singola colonna
    private String titolo;
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    @Column(name = "descrizione", nullable = false)
    private String descrizione;
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)// per definire l'enum come stringa altrimenti di defaul sarebbe un numero per il DB
    private EventType eventType;
    @Column(name = "numero_massimo_partecipanti", nullable = false)
    private int numeroMassimoPartecipanti;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni;

    public Evento() { // OBBLIGATORIO nelle entities il costruttore vuoto! Serve a JPA per poterci fornire degli oggetti

    }


    public Evento(String titolo, LocalDate dataEvento, String descrizione, EventType eventType, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.eventType = eventType;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public long getId() {
        return id;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", eventType=" + eventType +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
