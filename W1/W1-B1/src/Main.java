public class Main {

    static class QuickFindUF {
        private int[] leader;

        public QuickFindUF(int n) {
            leader = new int[n];
            for (int i = 0; i < n; i++) {
                leader[i] = i;
            }
        }

        public int find(int i) {
            return leader[i];
        }
        public void union(int p, int q) {
            for (int i = 0; i < leader.length; i++) {
                if (leader[i] == leader[p]) {
                    leader[i] = leader[q];
                }
            }
        }

        public void printLeader() {
            System.out.print("leader = [");

            for (int i = 0; i < leader.length; i++) {
                System.out.print(leader[i]);

                if (i < leader.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }
    }


    public static void main(String[] args) {

        int n = 4;

        QuickFindUF uf = new QuickFindUF(n);

        System.out.println("Ban dau:");
        uf.printLeader();

        System.out.println("\nunion(0, 1)");
        uf.union(0, 1);
        uf.printLeader();

        System.out.println("\nunion(1, 2)");
        uf.union(1, 2);
        uf.printLeader();

        System.out.println("\nunion(1, 3)");
        uf.union(1, 3);
        uf.printLeader();

        int i = 0;
        int j = 2;

        System.out.println("\nKiem tra:");
        System.out.println("find(" + i + ") = " + uf.find(i));
        System.out.println("find(" + j + ") = " + uf.find(j));

        if (uf.find(i) == uf.find(j)) {
            System.out.println(i + " va " + j + " cung tap hop");
        } else {
            System.out.println(i + " va " + j
                    + " dang thuoc cung tap hop, NHUNG find() tra ve khac nhau -> BUG!");
        }
    }
}