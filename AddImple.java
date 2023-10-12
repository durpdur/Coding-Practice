import java.util.ArrayList;
import java.util.List;

public class AddImple {
    private int sum;
    private int seed;
    private int square;

    public int addSum(int n) {

        while (n > 0) {
            square = n * n;
            sum = sum + square;
            n--;
        }

        return sum;
    }

    public AddImple(int seed) {
        
        this.seed = seed;
        this.sum = addSum(seed);

    }

    public getSum() {
        return sum;
    }


}
