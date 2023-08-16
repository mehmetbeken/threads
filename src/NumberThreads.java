import java.util.List;

public class NumberThreads implements Runnable {

    private List<Integer> oddNumberList;
    private List<Integer> evenNumberList;
    private List<Integer> allNumberList;

    private Object lock;

    public NumberThreads(List<Integer> allNumberList, List<Integer> evenNumberList, List<Integer> oddNumberList, Object lock) {
        this.allNumberList = allNumberList;
        this.oddNumberList = oddNumberList;
        this.evenNumberList = evenNumberList;
        this.lock = lock;
    }

    @Override
    public void run() {


        for (int i = 0; i < allNumberList.size(); i++) {
            if (allNumberList.get(i) % 2 == 1) {
                synchronized (lock) {
                    oddNumberList.add(allNumberList.get(i));
                }
            } else {
                synchronized (lock) {
                    evenNumberList.add(allNumberList.get(i));
                }
            }
        }
    }

    public List<Integer> getOddNumberList() {
        return this.oddNumberList;
    }

    public List<Integer> getEvenNumberList() {
        return this.evenNumberList;
    }
}
