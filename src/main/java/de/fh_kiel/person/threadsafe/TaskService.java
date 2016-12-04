package de.fh_kiel.person.threadsafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * Created by amit on 02.12.16.
 */
@Service
public class TaskService {

    //private AtomicInteger setId = new AtomicInteger(0);
    private static Logger logger = LoggerFactory.getLogger(TaskService.class);
    //public Thread t;
    private Long id;
    private Integer finalResult;
    /*public UUID createId() {
        return UUID.randomUUID();
    }*/

    public TaskService() {
    }

    /**
     * Overload Constructor for getting the Uniques thread Id
     * @param id
     */
    public TaskService(Long id) {
         this.id=id;
    }


    public  synchronized Long createTask(Integer i, String createfName){
        switch (createfName){
            case "fibonacci" :
                finalResult=fFibo(i);
                System.out.println("fibo value:" + finalResult);
                for (int j = 0; j <= i; j++)
                    System.out.println(i + ": " + fFibo(j));
                break;
            case "sum" :
                finalResult = fSum(i);
                System.out.println("sumres value:" + finalResult);
                break;
            case "factorial" :
                finalResult = fFact(i);
                System.out.println("fact value:" + finalResult);

                break;
            default:
                System.out.println("No name selected");
        }
        try {
            System.out.println("current Thread Name:" + Thread.currentThread().getName());
            System.out.println("current Thread id:" + Thread.currentThread().getId());
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        return id;
    }

    public  synchronized Integer fFibo(Integer intFibo){
        if (intFibo <= 1)
            return intFibo;
        else
            return fFibo(intFibo-1) + fFibo(intFibo-2);
    }

    public  synchronized Integer fSum(Integer intSum){
        int resSum = 0;
        for (int i = intSum; i>0; i--){
            resSum+=i;
        }
        return resSum;
    }

    public  synchronized Integer fFact(Integer intFact){
        if (intFact > 50) throw new IllegalArgumentException(intFact + " is out of range");
        return IntStream.rangeClosed(2, intFact).reduce(1, (a, b) -> a * b);
    }

    /**
     * If Id does not match then it will return a default value as zero
     * @param getid
     * @return
     */
    public synchronized Integer getTaskResult(Long getid){
        if (getid==id) {
            return finalResult;
        }else {
            System.out.println("No task found");
            return 0;
        }
    }
}
