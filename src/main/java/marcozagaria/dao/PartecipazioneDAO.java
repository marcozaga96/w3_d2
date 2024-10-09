package marcozagaria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marcozagaria.entities.Partecipazione;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.persist(newPartecipazione);
        transazione.commit();
        System.out.println("nuova partecipazione salvata con successo");
    }

    public Partecipazione getById(long id) {
        return entityManager.find(Partecipazione.class, id);
    }

    public void delete(long id) {
        Partecipazione partecipazioneId = this.getById(id);
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.remove(partecipazioneId);
        transazione.commit();
        System.out.println("la partecipazione è stata cancellata");
    }
}
