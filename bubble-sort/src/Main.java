public class Main {
    public static void main(String[] args) {
        int[] v = {5, 3, 2, 4, 7, 1, 0, 6};
        BubbleSort bs = new BubbleSort();
        bs.ordenar(v);
        for(int num : v) {
            System.out.print(num + " ");
        }
    }

}
