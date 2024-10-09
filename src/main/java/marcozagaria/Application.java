package marcozagaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marcozagaria.Enum.EventType;
import marcozagaria.Enum.Sesso;
import marcozagaria.Enum.StatoPartecipazione;
import marcozagaria.dao.EventoDAO;
import marcozagaria.dao.LocationDAO;
import marcozagaria.dao.PartecipazioneDAO;
import marcozagaria.dao.PersonaDAO;
import marcozagaria.entities.Evento;
import marcozagaria.entities.Location;
import marcozagaria.entities.Partecipazione;
import marcozagaria.entities.Persona;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w3_d2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); // Creeremo un unico Entity Manager per tutta l'applicazione
        EventoDAO event = new EventoDAO(em);
        PersonaDAO person = new PersonaDAO(em);
        LocationDAO location = new LocationDAO(em);
        PartecipazioneDAO partecipazione = new PartecipazioneDAO(em);
//        System.out.println("--------------------esercizio 1------------------------------");
//        Evento newEvent = new Evento("lezione", LocalDate.of(2024, 10, 9), "lezione di riccardo", EventType.PRIVATO, 30);
//        event.save(newEvent);
//        System.out.println("--------------------esercizio 2------------------------------");
//        Evento cercaId = event.getById(1);
//        System.out.println(cercaId);
//        System.out.println("--------------------esercizio 3------------------------------");
//        event.delete(2);
        Evento concerto = new Evento("concerto", LocalDate.of(2024, 10, 20), "concerto di vasco", EventType.PUBBLICO, 10000);
//        event.save(concerto);
        Evento concertoDb = event.getById(2);
        Persona persona1 = new Persona("marco", "zagaria", "marcozagaria@live.com", LocalDate.of(1996, 12, 10), Sesso.M);
//       person.save(persona1);
        Persona persona1Db = person.getById("38da8e0e-9257-4178-a7b1-60344e557484");
        Location location1 = new Location("stadio san nicola", "bari", concertoDb);
//        location.save(location1);
        Partecipazione partecipazione1 = new Partecipazione(StatoPartecipazione.CONFERMATA, concertoDb, persona1Db);
        partecipazione.save(partecipazione1);
    }
}
