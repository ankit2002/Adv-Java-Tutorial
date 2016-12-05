package de.fh_kiel.person.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ankit on 12/4/2016.
 */
@RestController
@RequestMapping("/oddscontroller")
public class OddsController {

    Logger logger = LoggerFactory.getLogger(OddsController.class);

    private List<Integer> intList = new ArrayList<>();
    private final Lock lock = new ReentrantLock();


    /**
     * This is the first way of solving task 3
     * @param val
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value ="/threeOdds/{val}", method = RequestMethod.GET)
    public synchronized String threeOdds(@PathVariable("val") int val,HttpServletRequest request, HttpServletResponse response) {

        if(val%2 != 0){
            intList.add(val);
        }

        if(intList.size() == 3){
            intList.clear();
            response.setStatus( HttpServletResponse.SC_OK);
            return "yeah";
        }
        return "";
    }

    /**
     * This is the another way of solving the task 3
     * @param val
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value ="/threeOddsver2/{val}", method = RequestMethod.GET)
    public String threeOddsVerSec(@PathVariable("val") int val,HttpServletRequest request, HttpServletResponse response) {
        lock.lock();
        try {
            if (val % 2 != 0) {
                intList.add(val);
            }

            if (intList.size() == 3) {
                intList.clear();
                response.setStatus(HttpServletResponse.SC_OK);
                return "yeah";
            }
        }catch (Exception e){
            System.out.println("Some Exception : " + e.getMessage());
        }
        finally {
            lock.unlock();
        }
        return "";
    }
}



