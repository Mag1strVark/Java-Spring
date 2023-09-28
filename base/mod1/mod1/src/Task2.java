public class Task2 {
    public static void main(String[] args) {
        int[][] x = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };

        int minElement = x[0][0];

        for (int[] row : x) {
            for (int element : row) {
                if (element < minElement) {
                    minElement = element;
                }
            }
        }

        System.out.println(minElement);
    }
}
