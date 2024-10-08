package marcozagaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marcozagaria.dao.EventoDAO;
import marcozagaria.entities.EventType;
import marcozagaria.entities.Evento;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w3_d2");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); // Creeremo un unico Entity Manager per tutta l'applicazione
        EventoDAO event = new EventoDAO(em);

        Evento newEvent = new Evento("concerto", LocalDate.of(2024, 12, 8), "concerto di vasco", EventType.PUBBLICO, 10000);
        event.save(newEvent);

        Evento cercaId = event.getById(1);
        System.out.println(cercaId);
    }
}
