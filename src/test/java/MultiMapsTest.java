/**
 * Created by IntelliJ IDEA.
 * Author: Hicham B.I.
 * Date: 09/10/14
 * Time: 23:58
 */

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MultiMapsTest {

    @Test
    public void test_arrayList_multiMap() {
        Multimap<Integer, String> multiValuesMap = ArrayListMultimap.create();
        multiValuesMap.put(1, "Darker Than Black");
        multiValuesMap.put(1, "One Piece");
        multiValuesMap.put(2, "HunterXHunter");
        multiValuesMap.put(1, "Naruto");
        multiValuesMap.put(1, "Naruto");

        List<String> actual = new ArrayList<>(multiValuesMap.get(1));
        List<String> expected = Arrays.asList("Darker Than Black", "One Piece", "Naruto", "Naruto");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void test_linkedHash_multiMap() {
        Multimap<Integer, String> multiValuesMap = LinkedHashMultimap.create();
        multiValuesMap.put(1, "Darker Than Black");
        multiValuesMap.put(1, "One Piece");
        multiValuesMap.put(2, "HunterXHunter");
        multiValuesMap.put(1, "Naruto");
        multiValuesMap.put(1, "Naruto");

        List<String> actual = new ArrayList<>(multiValuesMap.get(1));
        List<String> expected = Arrays.asList("Darker Than Black", "One Piece", "Naruto");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void test_hash_multiMap() {
        Multimap<Integer, String> multiValuesMap = HashMultimap.create();
        multiValuesMap.put(1, "Darker Than Black");
        multiValuesMap.put(1, "One Piece");
        multiValuesMap.put(2, "HunterXHunter");
        multiValuesMap.put(1, "Naruto");
        multiValuesMap.put(1, "Naruto");

        List<String> actual = new ArrayList<>(multiValuesMap.get(1));
        List<String> expected = Arrays.asList("Naruto", "One Piece", "Darker Than Black");

        assertThat(actual).isEqualTo(expected);
    }
}
