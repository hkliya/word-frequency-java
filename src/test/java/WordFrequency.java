import java.util.*;

public class WordFrequency {

    public static String handle(String text) {
        if (text.equals("")) {
            return "";
        } else {

            String[] words = text.split(" ");
            Map<String, Integer> countResult = group(words);
            List<Map.Entry<String, Integer>> countResultList =new LinkedList(countResult.entrySet());
            Collections.sort(countResultList, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });
            return join(countResultList);
        }
    }

    private static String join(List<Map.Entry<String, Integer>> entries) {
        String result = "";
        for (Map.Entry<String, Integer> entry : entries) {
            result += entry.getKey() + " " + entry.getValue() + "\r\n";
        }
        return result.trim();
    }

    private static Map<String, Integer> group(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}
