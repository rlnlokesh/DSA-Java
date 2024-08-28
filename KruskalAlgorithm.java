import java.util.Arrays;



class UnionFind{
    int parent[];
    UnionFind(int n){
        parent = new int[n];
        for(int i =0;i<n;i++){
            parent[i] = i;
        }
    }
    int find(int a){
        if (parent[a]!=a){
            parent[a]=find(parent[a]);
        }
        return parent[a];
    }
    void union(int a,int b){
        int root_a=find(a);
        int root_b=find(b);
        parent[root_a]=root_b;
    }
}
class KruskalAlgorithm{
    static int kruskals(int [][]G,int n){
        int min_cost = 0;
        int[][] edges = new int[n*(n-1)/2][3];
        int index = 0;

        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (G[i][j]!=0){
                    edges[index++] = new int[]{G[i][j],i,j};

                }
            }
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);

        for (int[] edge:edges){
            int cost = edge[0];
            int a = edge[1];
            int b = edge[2];

            if (uf.find(a)!=uf.find(b)){
                min_cost+=cost;
                uf.union(a,b);
            }
        }
        return min_cost;
    }

    public static void main(String[] args) {
        int nodes = 4;
        int[][] graph = {
                {0, 10, 0, 21},
                {10, 0, 18, 22},
                {0, 18, 0, 13},
                {21, 22, 13, 0}
        };
        int min = kruskals(graph,nodes);
        System.out.println("Minimum Cost is "+min);
    }
}