import java.util.Arrays;

public class Main {

    public static int count(int[] a) {
        Arrays.sort(a);

        int N = a.length;
        int count = 0;

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {

                int left = j + 1;
                int right = N - 1;

                while (left < right) {
                    long sum = (long) a[i] + a[j] + a[left] + a[right];

                    if (sum == 0) {count++;left++;right--;} else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, -1, -2, 0};
        System.out.println("So bo 4 co tong bang 0: " + count(a));
    }
}