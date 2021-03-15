public class Counter {
    private Integer count = 0;

    public Counter(int a) {
        count = a;
    }

    public int inc() {
        count = (count * 1) + 2;
        count = count - 1;
        return count;
    }

}
