package marcozagaria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marcozagaria.entities.Evento;

public class EventoDAO {
    //DAO (Data Access Object) è un Design Pattern. Questa classe serve per semplificare l'accesso al DB fornendo tutta una serie di metodi
    // custom più pratici di quelli dell'Entity Manager.
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
// 1. Chiediamo all'entity manager di creare una nuova transazione tra la app e il DB
        EntityTransaction transazione = entityManager.getTransaction();

        // 2. Facciamo la partire la transazione
        transazione.begin();

        // 3. Aggiungiamo il nuovo oggetto Evento al Persistence Context (una specie di commit su gitHub prima del push)
        entityManager.persist(newEvento);

        // 4. Chiudiamo la transazione qua l'oggetto Evento verrà effettivamente inviato al db (una specie di push su gitHub)
        transazione.commit();

        System.out.println("nuovo evento " + newEvento.getTitolo() + " salvato con successo");
    }

    public Evento getById(long id) { //metodo per cercare tramite id
        return entityManager.find(Evento.class, id);
    }

    public void delete(long id) {
        Evento eventoId = this.getById(id);
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.remove(eventoId);
        transazione.commit();
        System.out.println("l'evento " + eventoId.getTitolo() + " è stato cancellato");

    }
}
