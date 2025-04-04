package amazon;

import java.util.*;

public class Evaluate_Division {
    public static double compute(String str, String end, HashSet<String> visited, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(str)) return -1.0;

        if(graph.get(str).containsKey(end))
            return graph.get(str).get(end);

        visited.add(str);
        for(Map.Entry<String, Double> entry : graph.get(str).entrySet()) {
            if(visited.contains(entry.getKey()))
                continue;

            double prod = compute(entry.getKey(), end, visited, graph);
            if(prod != -1.0)
                return entry.getValue() * prod;
        }

        return -1.0;
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i=0;i<equations.size();i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(u, k->new HashMap<>()).put(v, value);
            graph.computeIfAbsent(v, k->new HashMap<>()).put(u, 1 / value);
        }

        double[] res = new double[queries.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = compute(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }

        return res;
    }
    public static void main(String[] args) {
        List<List<String>> eq = Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c"));
        double[] values = {2.0,3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","a"), Arrays.asList("a","e"), Arrays.asList("a","a"), Arrays.asList("x","x"));

        System.out.println(Arrays.toString(calcEquation(eq, values, queries)));

    }
}
