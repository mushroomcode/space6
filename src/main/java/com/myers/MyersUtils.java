package com.myers;

import com.DiffBean.Node;
import com.DiffBean.NodeParam;
import com.DiffBean.SnakeParam;

public class MyersUtils<T> {

    public Node findAllWays(String strA, String strB, int N, int M) {
//        List<Integer> klines = new ArrayList<Integer>(N + M);
        int size = 2 * (M + N) + 1;
        int middle = size / 2;
        Node[] nodes = new Node[size];
        Node node = new NodeParam(0, -1, null);
        nodes[middle + 1] = node;
        for (int d = 0;d <= N + M;d += 1) {
            for(int k = -d;k <= d;k += 2) {
                int km = k + middle;
                // 若为向下走
                Node prev = null;
                int i;
                if(k == -d || (k != d && nodes[km - 1].getK() < nodes[km + 1].getK())) {
                    i = nodes[km + 1].getK();
                    prev = nodes[km + 1];
                }
                else {
                    i = nodes[km - 1].getK();
                    prev = nodes[km - 1];
                }
                int x = i;
                int y = i - k;
                while (x < N && y < M && strA.charAt(x) == strB.charAt(y)) {
                    x ++;
                    y ++;
                }
                if(x > i) {
                    node = new SnakeParam(x, y, prev);
                }

                nodes[middle] = node;

                if(x >= N && y >= M) {
                    return nodes[middle];
                }

            }

            nodes[middle + d - 1] = null;
        }
        // 找不到合适的路径
        return null;
//        klines.stream().forEach(System.out::println);
    }



}
