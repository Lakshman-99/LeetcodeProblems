package patterns.graphs;

import java.util.*;

public class Clone_Graphs {
    public static Node solve(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) return map.get(node);

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(solve(neighbor, map));
        }

        return newNode;
    }
    public static Node cloneGraph(Node node) {
        if(node == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        return solve(node, map);
    }

    public static void main(String[] args) {

    }
}
