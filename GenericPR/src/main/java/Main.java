import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person=new Person(1,"Erfan");

        GenericClass<Person> genericClass=new GenericClass<>();

        genericClass.save(person);

        List<Person> people = genericClass.getAll();


        System.out.println(people);
    }
}
