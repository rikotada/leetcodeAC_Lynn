package testTest;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory1472 {
    List<String> list = new ArrayList<>();
    int index = 0;
    int valid = 0;
    

    public DesignBrowserHistory1472(String homepage) {
        list.add(homepage);
    }

    public void visit(String url) {
        index++;
        if(index == list.size()){
            list.add(url);
            valid++;
        }
        else{
            valid = index;
            list.set(valid,url);
        }

    }
    
    public String back(int steps) {
        if(steps >= index){
           index = 0;
        }
        else{
            index = index - steps;
        }
        return list.get(index);
    }
    
    public String forward(int steps) {
        if(steps + index >= valid){
            index = valid;
        }
        else{
           index = index + steps;
        }
        return list.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
