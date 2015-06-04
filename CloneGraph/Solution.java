public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> nodes = new HashMap<Integer, UndirectedGraphNode>();

        return cloneGraph(node, nodes);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodes) {
        if (node == null)
            return null;
        UndirectedGraphNode n;
        if (!nodes.containsKey(node.label)) {
            nodes.put(node.label, new UndirectedGraphNode(node.label));
        } else {
            return nodes.get(node.label);
        }
        n = nodes.get(node.label);
        List<UndirectedGraphNode> neighbors = n.neighbors;
        for (UndirectedGraphNode neighbor: node.neighbors) {
            neighbors.add(cloneGraph(neighbor, nodes));
        }

        return n;
    }

}
