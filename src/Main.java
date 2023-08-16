import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> numberList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        for (int i = 1; i <= 10000; i++) {
            numberList.add(i);
        }


        List<Thread> threadList = new ArrayList<>();
        Object lock = new Object();
        for (int i = 0; i <= 3; i++) {

            int startIndex = 0 + i*2500;
            int size =  10000/4;

            List<Integer> pieceList = new ArrayList<>();
            pieceList.addAll(numberList.subList(startIndex,startIndex+size));

            Thread thread = new Thread(new NumberThreads(pieceList, evenList, oddList, lock));
            threadList.add(thread);
            thread.start();
            thread.join();
        }

        System.out.println("Odd Numbers: " + evenList);
        System.out.println("Odd Numbers: " + evenList.size());
        System.out.println("Even Numbers: " + oddList);
        System.out.println("Even Numbers: " + oddList.size());
    }
}
