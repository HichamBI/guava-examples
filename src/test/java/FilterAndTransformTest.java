import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 20/10/14
 * Time: 22:57
 */

public class FilterAndTransformTest {

    private static List<Person> people;

    @BeforeClass
    public static void setUp() {
        people = Arrays.asList(
                new Person("Hei", 26),
                new Person("Luffy", 14),
                new Person("Naruto", 18),
                new Person("Ichigo", 17));
    }

    @Test
    public void test_filter() {
        Predicate<Person> majeur = new Predicate<Person>() {
            public boolean apply(Person p) {
                return p.getAge() >= 18;
            }
        };

        Collection<Person> majeurPoeple = Collections2.filter(people, majeur);
        assertThat(majeurPoeple).extracting("name").containsExactly("Hei", "Naruto");
    }

    @Test
    public void test_transform() {
        Function<Person, String> stringTransformer = new Function<Person, String>() {
            public String apply(Person p) {
                return p.getName();
            }
        };

        Collection<String> poepleNames = Collections2.transform(people, stringTransformer);
        assertThat(poepleNames).containsExactly("Hei", "Luffy", "Naruto", "Ichigo");
    }

    private static class Person {
        private final String name;
        private final Integer age;

        private Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

}
