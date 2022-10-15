class UnionFind {
    int[] p;
    int[] rank;
    int[] size;
    UnionFind(int N) {
        p = new int[N];
        rank = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
            size[i] = 1;
        }
    }
    int findSet(int i) {
        if (p[i] != i) {
            p[i] = findSet(p[i]);
        }
        return p[i];
    }
    boolean isSameSet(int a, int b) {
        return findSet(a) == findSet(b);
    }
    void unionSet(int a, int b) {
        int x = findSet(a), y = findSet(b);
        if (x == y) {
            return;
        }
        if (rank[x] > rank[y]) {
            p[y] = x;
            size[x] += size[y];
        } else if (rank[x] == rank[y]) {
            p[y] = x;
            rank[x] += 1;
            size[x] += size[y];
        } else {
            p[x] = y;
            size[y] += size[x];
        }
    }
    int findSize(int a) {
        int b = findSet(a);
        return size[b];
    }
}