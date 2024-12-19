package Pattern;

public class Patterns {

        public static void NumberTrianglePattern(int n) {
                for (int i = 1; i <= n; i++) {
                        for (int space = 1; space <= n - i; space++) {
                                System.out.print(" ");
                        }

                        for (int j = 0; j < i; j++) {
                                System.out.print((i + j));
                        }

                        for (int j = i - 2; j >= 0; j--) {
                                System.out.print((i + j));
                        }

                        System.out.println();
                }
        }

        public static void RightHalfPyramid(int n) {
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j <= i; j++) {
                                System.out.print("*" + " ");
                        }
                        System.out.println();
                }
        }

        public static void InvertedHalfPyramid(int n) {
                for (int i = 0; i <= n; i++) {
                        for (int j = n - i; j >= 0; j--) {
                                System.out.print("*" + " ");
                        }
                        System.out.println();
                }
        }

        public static void InvertedLeftHalfPyramid(int n) {
                for (int i = 0; i <= n; i++) {
                        // for spaces
                        for (int space = 0; space < i; space++) {
                                System.out.print(" ");
                        }
                        for (int j = 0; j < n - i; j++) {
                                System.out.print("*");
                        }
                        System.out.println();
                }
        }

        public static void FullPyramid(int n) {
                for (int i = 0; i <n; i++) {
                        for (int space = 0; space < n - i-1; space++) {
                                System.out.print(" ");
                        }
                        for(int j=0; j<2*i+1; j++){
                                System.out.print("*");
                        }
                        System.out.println();
                }
        }

        public static void InvertedFullPyramid(int n) {
                for (int i = 1; i <=n; i++) {
                        for (int space=1; space<=i-1; space++) {
                                System.out.print(" ");
                        }
                        for(int j=1; j<=2*(n-i)+1; j++){
                                System.out.print("*");
                        }
                        System.out.println();
                }
        }

        public static void main(String[] args) {
                // NumberTrianglePattern(10);
                // RightHalfPyramid(4);
                // System.out.println();
                // InvertedHalfPyramid(4);
                // System.out.println();
                // InvertedLeftHalfPyramid(5);
                FullPyramid(5);
                System.out.println();
                InvertedFullPyramid(5);
        }
}
