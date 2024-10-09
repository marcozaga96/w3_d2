package marcozagaria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marcozagaria.entities.Location;

public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location newLocation) {
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.persist(newLocation);
        transazione.commit();
        System.out.println("nuova location " + newLocation.getNome() + " salvata con successo");
    }

    public Location getById(long id) {
        return entityManager.find(Location.class, id);
    }

    public void delete(long id) {
        Location locationId = this.getById(id);
        EntityTransaction transazione = entityManager.getTransaction();
        transazione.begin();
        entityManager.remove(locationId);
        transazione.commit();
        System.out.println("la location " + locationId.getNome() + " è stata cancellata");
    }
}
