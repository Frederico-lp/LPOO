package lpoo2021.g64PvZ.model;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private final ArrayList<String> options;
    private int currentOption = 0;

    public Home(){
        this.options = new ArrayList<>();
        options.add("Start");
        options.add("Exit");

    }

    public boolean isStart(){
        return currentOption == 0;
    }

    public int getCurrentOption(){
        return this.currentOption;
    }

    public void nextOption(){
        if(currentOption==0)
            currentOption++;
    }

    public void previousOption(){
        if(currentOption==1)
            currentOption--;
    }

    public List<String> getOptions(){
        return this.options;
    }
}
