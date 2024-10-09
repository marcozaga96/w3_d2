package marcozagaria;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("w3_d2");

    public static void main(String[] args) {
//        EntityManager em = emf.createEntityManager(); // Creeremo un unico Entity Manager per tutta l'applicazione
//        EventoDAO event = new EventoDAO(em);
//        System.out.println("--------------------esercizio 1------------------------------");
//        Evento newEvent = new Evento("lezione", LocalDate.of(2024, 10, 9), "lezione di riccardo", EventType.PRIVATO, 30);
//        event.save(newEvent);
//        System.out.println("--------------------esercizio 2------------------------------");
//        Evento cercaId = event.getById(1);
//        System.out.println(cercaId);
//        System.out.println("--------------------esercizio 3------------------------------");
//        event.delete(2);
    }
}
