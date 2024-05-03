package connectivity;

public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;

    public WeightedQuickUnion(int N){
        for(int i=0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }


    private int root(int i){

        // path compression to shorten the depth of the nodes optimization on weighted quick find

        while(id[i] != i){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    private boolean connected(int p, int q){
        return root(p) == root(q);
    }

    private void union(int p, int q){
        int i = root(p);
        int j = root(q);

        if(i == j){
            return;
        }

       if(sz[i] < sz[j]){
           id[i] = j;
           sz[j] += sz[i];
       }else{
           id[j] = i;
           sz[i] += sz[j];
       }

    }

}
