import java.util.Random;

public class Model {
    Viewer viewer;
    Tree tree;
    Random r = new Random();

    public Model(Viewer viewer) {
        this.viewer = viewer;
    }

    public void addBranch() {
        //int count = Integer.parseInt(viewer.tf.getText());
        int count = Math.abs(r.nextInt() % 99);
        tree.add(count);
        viewer.branching(tree.ar);
    }

    public void createRoot() {
        tree = new Tree(Integer.parseInt(viewer.tf.getText()));
        viewer.createRoot(Integer.parseInt(viewer.tf.getText()));
    }

    class Tree {
        int[] ar;
        int count = 0;

        public Tree(int depth) {
            ar = new int[(int) Math.pow(2, depth) - 1];
        }

        public void add(int b) {
            ar[count] = b;
            count++;
        }

        public void checking() {
            for (int j = 0; j < ar.length; j++) {
                for (int i = 0; i < ar.length; i++) {
                    siftDown(i);
                }
            }
            viewer.branching(ar);
        }

        public void remove() {
            ar[0] = ar[count - 1];
            ar[count - 1] = 0;
            viewer.branching(ar);
            count--;
        }

        public void remove(int index) {
            ar[index] = ar[count - 1];
            ar[count - 1] = 0;
            count--;
            viewer.branching(ar);
        }

        public void siftDown(int index) {
            int leftIndex = index * 2 + 1;
            int rightIndex = index * 2 + 2;
            if (leftIndex < ar.length && ar[index] < ar[leftIndex] && ar[leftIndex] >= ar[rightIndex]) {
                int b = ar[index];
                ar[index] = ar[leftIndex];
                ar[leftIndex] = b;
            }
            if (rightIndex < ar.length && ar[index] < ar[rightIndex] && ar[leftIndex] < ar[rightIndex]) {
                int b = ar[index];
                ar[index] = ar[rightIndex];
                ar[rightIndex] = b;
            }
        }
    }

}