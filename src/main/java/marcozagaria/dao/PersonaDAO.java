package marcozagaria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marcozagaria.entities.Persona;

public class PersonaDAO {
    private final EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona newPersona) {
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.persist(newPersona);
        transazione.commit();
        System.out.println("nuova persona " + newPersona.getNome() + " salvata con successo");
    }

    public Persona getById(long id) {
        return entityManager.find(Persona.class, id);
    }

    public void delete(long id) {
        Persona personaId = this.getById(id);
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.remove(personaId);
        transazione.commit();
        System.out.println("la persona " + personaId.getNome() + " è stata cancellata");
    }
}
