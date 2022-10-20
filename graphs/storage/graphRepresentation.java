public class Main {
    public static void main(String[] args) throws IOException {
        int numVertices = 6;

        //Adjacency Matrix
        //O(V^2) time to implement, where V is number of vertices
        //Takes up O(V^2) space
        //O(1) time to find edge
        int[][] adjMatrix = new int[numVertices][numVertices];
        //Value represent weight of edge between two Nodes
        //If bidirectional, matrix is symmetric
        //Else, select one end to represent direction
        //Add edge to list (Example: 0->1 weight 5)
        adjMatrix[0][1] = 5;

        //Good for dense graphs


        //Adjacency List
        //O(V+E) time to implement, where E is number of edges
        //Takes up O(V+E) space
        //O(k) time to find, where k is number of neighbours as worst case you need traverse through all
        List<List<Integer>> adjLst = new ArrayList<>();
        for(int i = 0; i < numVertices; i++) {
            adjLst.add(new ArrayList<>()); //So you can get edges by .get(initial)
        }
        //Add edge to list (Example: 0<->1 unweighted)
        adjLst.get(0).add(1);
        adjLst.get(1).add(0);
        //To add weights, just use a custom Pair class
        List<List<Pair>> adjLst2 = new ArrayList<>();
        adjLst2.get(0).add(new Pair(1,2));
        adjLst2.get(1).add(new Pair(0,2));
        //Good for sparse graphs

        //Edge Lists
        //O(E) time to implement, where E is the number of edges
        //O(E) space taken
        //O(E) time to find
        List<Pair> edgeLst = new ArrayList<>();
        //Add edge to list (Example: 0<->1 unweighted)
        edgeLst.add(new Pair(0, 1));
        //Weighted
        List<Triple> edgeLst2 = new ArrayList<>();
        edgeLst2.add(new Triple (0, 1, 2));
        //Usually only used for MST

        //Make sure all your representations allow you to
        //add node, delete node, add edge, delete edge, query an edge
    }
}

class Pair {
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Triple {
    int x, y, z;
    Triple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}