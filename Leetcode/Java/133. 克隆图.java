/**
 * 方法1“：深度优先搜索
 */
class Solution {
    Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        if(visited.containsKey(node)) return visited.get(node);
        Node CloneNode = new Node(node.val,new ArrayList<>());
        visited.put(node,CloneNode);
        for(Node neighbor:node.neighbors)
            CloneNode.neighbors.add(cloneGraph(neighbor));
        return CloneNode;
    }
}
/**
 * 方法2：广度优先搜索
 */
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Map<Node,Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty())
        {
            Node n = queue.pollFirst();
            for(Node neighbour:n.neighbors)
            {
                if(!visited.containsKey(neighbour))
                {
                    visited.put(neighbour,new Node(neighbour.val,new ArrayList<>()));
                    queue.add(neighbour);
                }
                visited.get(n).neighbors.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }
}