import java.util.*;

public class LeetCode133 {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        queue.addLast(node);
        map.put(node.val, new Node(node.val, new ArrayList<>(node.neighbors.size())));
        while (!queue.isEmpty()) {
            Node old = queue.pollFirst();
            Node news = map.get(old.val);
            for (Node neighbor : old.neighbors) {
                Node newN;
                if (!map.containsKey(neighbor.val)) {
                    queue.addLast(neighbor);
                    newN = new Node(neighbor.val, new ArrayList<>(neighbor.neighbors.size()));
                    map.put(neighbor.val, newN);
                }else{
                    newN = map.get(neighbor.val);
                }
                news.neighbors.add(newN);
            }
        }
        return map.get(node.val);
    }
}
