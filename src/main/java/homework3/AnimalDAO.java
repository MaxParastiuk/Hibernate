package homework3;

public interface AnimalDAO {
    Animal getAnimal(int id);

    void updateAnimal(Animal animal, int id);

    void deleteAnimal(int id);
}
