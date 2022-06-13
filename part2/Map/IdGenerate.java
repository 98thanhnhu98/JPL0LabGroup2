package java2.LabGroup2.part2.Map;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {  // DONE
    private static long id = 0L;
    private static ReentrantLock lock = new ReentrantLock();

    public static long getNewId(){
        long result;
        lock.lock();

        try {
            result = ++id;
        } finally {
            lock.unlock();
        }
        return result;
    }
    private IdGenerate(){}
}
