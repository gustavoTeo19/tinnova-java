public class Calc {
    public int calcular(int n){
        int count = 0;
        for(int i = 1; i < n; i++){
            if(i % 3 == 0 || i % 5 == 0){
               count += i;
            }
        }
        return count;
    }
}
