import java.time.LocalDate;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Person {
    public enum Sex {
        MALE, FEMALE, OTHER
    }

    String name;
    LocalDate birthday;
    Sex sex;
    String emailAddress;

    public Person() {
    }

    public Person(String name, LocalDate birthday, Sex sex, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getAge() {
        LocalDate nd = LocalDate.now();
        long diff = birthday.until(nd, ChronoUnit.YEARS);
        return diff;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(birthday, person.birthday) && Objects.equals(sex, person.sex) && Objects.equals(emailAddress, person.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, sex, emailAddress);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", sex='" + getSex() + "'" +
            ", emailAddress='" + getEmailAddress() + "'" +
            "}";
    }

	public static List<Person> createRoster() {
        List<Person> roster = new ArrayList<>();
        LocalDate d = LocalDate.of(1998, 10, 10);
        LocalDate d2 = LocalDate.of(1999, 10, 10);
        Random random = new Random(1);

        IntStream years = random.ints(1980, 2004).limit(10);
        IntStream months = random.ints(1, 13).limit(10);
        IntStream days = random.ints(1, 29).limit(10);

        /*
        years.forEach(System.out::println);
        months.forEach(m -> System.out.println(m));
        days.forEach(System.out::println);
        */

        int[] aYears = years.toArray();
        List<Integer> aMonths = months.boxed().collect(Collectors.toList());
        int[] aDays =  days.toArray();

        String[] names = {"Bob", "Alex", "Jo", "Tony", "Bo", "Bruce", "Ken", "Xi", "Sri", "Who"};




        for (int index = 0; index < 10; ++index ) {
            LocalDate d1 = LocalDate.of(aYears[index], aMonths.get(index), aDays[index]);
            Sex sex = index%2 == 0 ? Sex.MALE : Sex.FEMALE;
            Person person = new Person(names[index], d1, sex, names[index]+"@ou.edu");
            roster.add(person);
        }
		return roster;
	}

}