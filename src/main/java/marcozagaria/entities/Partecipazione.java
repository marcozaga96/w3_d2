package marcozagaria.entities;

import jakarta.persistence.*;
import marcozagaria.Enum.StatoPartecipazione;

import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private StatoPartecipazione statoPartecipazione;
    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    public Partecipazione() {
    }

    public Partecipazione(StatoPartecipazione statoPartecipazione, Evento evento, Persona persona) {
        this.statoPartecipazione = statoPartecipazione;
        this.evento = evento;
        this.persona = persona;
    }

    public UUID getId() {
        return id;
    }


    public StatoPartecipazione getStatoPartecipazione() {
        return statoPartecipazione;
    }

    public void setStatoPartecipazione(StatoPartecipazione statoPartecipazione) {
        this.statoPartecipazione = statoPartecipazione;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
