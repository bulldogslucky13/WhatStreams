import java.util.function.Predicate;

public class PredicateForA<T> implements Predicate<T> {

    @Override
    public boolean test(T t) {
        if ( t instanceof Person){
            Person person = (Person) t;
            String name = person.getName();
            return name.charAt(0) == 'A';
        }
        return false;
    }




}