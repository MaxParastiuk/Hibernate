package homework3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        AnimalDAOHeb animalDAOHeb = new AnimalDAOHeb();
        Animal animal = new Animal("Barsik",4, true);

        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(animal);
        session.flush();
        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println("animalDAOHeb.getAnimal" + animalDAOHeb.getAnimal(19));

        animalDAOHeb.updateAnimal(animal,20);

       animalDAOHeb.deleteAnimal(18);

    }
}
