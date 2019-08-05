package java8.function;

/**
 * @ClassName:Apple
 * @Description: TODO
 * @Author: shanz
 * @Date: 2019/2/11 9:35
 * @Version:1.0
 **/
public class Apple {

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Apple(int weight) {
        this.weight = weight;
    }


    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
