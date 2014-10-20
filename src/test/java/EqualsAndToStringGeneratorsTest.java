import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 20/10/14
 * Time: 22:23
 */

public class EqualsAndToStringGeneratorsTest {

    private static class Pojo {
        private final String name;
        private final Integer age;
        private final float weight;

        private Pojo(String name, Integer age, float weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                    .add("Name", name)
                    .add("Age", age)
                    .add("Weight", weight)
                    .toString();
        }
    }

    @Test
    public void test_equal() {
        Pojo pojo = new Pojo("Hei", 28, 66.5F);
        assertTrue(Objects.equal(null, null));
        assertFalse(Objects.equal(pojo, null));
        assertFalse(Objects.equal(null, pojo));
        assertTrue(Objects.equal(pojo, pojo));
        assertFalse(Objects.equal(pojo, new Object()));
    }

    @Test
    public void test_to_string() {
        Pojo pojo = new Pojo("Hei", 28, 66.5F);

        assertThat(pojo.toString()).isEqualTo("Pojo{Name=Hei, Age=28, Weight=66.5}");
    }
}
