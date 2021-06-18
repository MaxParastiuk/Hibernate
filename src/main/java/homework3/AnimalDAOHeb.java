package homework3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class AnimalDAOHeb implements AnimalDAO {

    private Session currentSession;
    private Transaction currentTransaction;

    @Override
    public Animal getAnimal(int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Animal animal = factory.openSession().get(Animal.class, id);
        factory.close();
        return animal;
    }


    @Override
    public void updateAnimal(Animal animal, int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Animal.class, id) != null) {
            Animal animal1 = animal;
            animal1.setId(id);

            Session session = factory.openSession();
            session.beginTransaction();
            session.update(animal1);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }
        factory.close();
    }

    @Override
    public void deleteAnimal(int id) {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        if (factory.openSession().get(Animal.class, id) != null) {
            Animal animal = factory.openSession().get(Animal.class, id);


            Session session = factory.openSession();
            session.beginTransaction();
            session.delete(animal);
            session.flush();
            session.getTransaction().commit();

            session.close();
        }
        factory.close();
    }
}
