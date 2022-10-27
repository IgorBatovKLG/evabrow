package ru.mse.service.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

@Service
public class CountVisitsService {

    public static HashMap<String, Integer> visits = new HashMap<>();

    public static void newVisits(String ip){
        if(visits.containsKey(ip)){
            visits.put(ip, (visits.get(ip)+1));
        } else {
            visits.put(ip, 1);
        }
    }

    public int getUniqueVisits(){
        return visits.keySet().size();
    }

    public int getVisits(){
        int i = 0;
        Set<String> strings = visits.keySet();
        for (String s:strings){
            i = i + visits.get(s);
        }
        return i;
    }

    public void newMap(){
        visits = new HashMap<>();
    }

}
