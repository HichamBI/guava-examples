import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 20/10/14
 * Time: 21:35
 */

public class JoinerAndSplitterTest {

    @Test
    public void test_join_objects() {
        Joiner joinerOnString = Joiner.on(", ");
        String StringJoinerResult = joinerOnString.join(1, 2, 3);
        assertThat(StringJoinerResult).isEqualTo("1, 2, 3");

        Joiner joinerOnChar = Joiner.on(' ');
        String charJoinerResult = joinerOnChar.join("Hello", "cruel", "world");
        assertThat(charJoinerResult).isEqualTo("Hello cruel world");
    }

    @Test
    public void test_join_iterables() {
        Joiner joinerOnString = Joiner.on(", ");

        List<Integer> integersList = new ArrayList<>(Arrays.asList(1, 2, 3));
        String StringJoinerResult = joinerOnString.join(integersList);
        assertThat(StringJoinerResult).isEqualTo("1, 2, 3");

        Set<String> stringsSet = new LinkedHashSet<>(Arrays.asList("A", "B", "C", "A"));
        StringJoinerResult = joinerOnString.join(stringsSet);
        assertThat(StringJoinerResult).isEqualTo("A, B, C");
    }

    @Test
    public void test_join_nulls() {
        Joiner skipNullsJoiner = Joiner.on(", ").skipNulls();
        List<Integer> integersList = new ArrayList<>(Arrays.asList(1, 2, null, 3));
        String Result = skipNullsJoiner.join(integersList);

        assertThat(Result).isEqualTo("1, 2, 3");

        Joiner useNullsJoiner = Joiner.on(", ").useForNull("null");
        Set<String> stringsSet = new LinkedHashSet<>(Arrays.asList("A", "B", null, "A", "C"));
        Result = useNullsJoiner.join(stringsSet);

        assertThat(Result).isEqualTo("A, B, null, C");
    }

    @Test
    public void test_join_maps() {
        Joiner.MapJoiner joiner = Joiner.on(", ").withKeyValueSeparator(" => ");

        Map<Integer, String> map = Maps.newLinkedHashMap();
        map.put(0, "Hei");
        map.put(1, "Luffy");
        map.put(2, "Ichigo");
        map.put(3, "Naruto");

        String result = joiner.join(map);
        assertThat(result).isEqualTo("0 => Hei, 1 => Luffy, 2 => Ichigo, 3 => Naruto");
    }

    @Test
    public void test_split_strings() {
        String str = "A, B, C";

        Splitter splitter = Splitter.on(", ");
        List<String> strings = splitter.splitToList(str);

        assertThat(strings).containsExactly("A", "B", "C");
    }
}
