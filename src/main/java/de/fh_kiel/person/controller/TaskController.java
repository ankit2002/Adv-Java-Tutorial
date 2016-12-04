
package de.fh_kiel.person.controller;

import de.fh_kiel.person.threadsafe.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * Created by amit on 02.12.16.
 */



@RestController
public class TaskController implements ErrorController {
    Integer res=0;

    @Autowired
    TaskService ts;

     @RequestMapping(value = "/task")
     public Integer taskResults(HttpServletRequest request, HttpServletResponse response){

         /**
          * Completable future for method CreateTask
          */

         CompletableFuture<Long> createFut = CompletableFuture.supplyAsync(() ->
         {  new TaskService(Thread.currentThread().getId());
                try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }
             /**
              * String name can be changed to calculate different requirements
              */
             return ts.createTask(5, "factorial");
         });

         /**
          * Then Applying .theApply funtion to tranform and get the result of using getTaskMethod Async
          */

         CompletableFuture<Integer> getResFut = createFut.thenApply((Long t) -> {
             try {
                 Thread.sleep(1000);

             } catch (InterruptedException e) {
                 System.out.println(Thread.currentThread().getName() + " interrupted.");
             }
             return ts.getTaskResult(t);
         });
         CompletableFuture<String> excp = getResFut.handle((result, throwable) -> {
             if (throwable !=null){
                 return ("Some Exception here :" + throwable);
             }else{
                 return result.toString();
             }

         });
         if(!getResFut.isDone()){
             try {
                 res = getResFut.get();
                 if (res==0){
                     response.setStatus( HttpServletResponse.SC_EXPECTATION_FAILED);
                 } else {
                     response.setStatus( HttpServletResponse.SC_OK);
                 }

             } catch (InterruptedException e) {
                 System.out.println(Thread.currentThread().getName() + " interrupted.");
             }catch (ExecutionException e) {
                 System.out.println(Thread.currentThread().getName() + " interrupted.");
             }
         }

         return res;
     }


    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}

