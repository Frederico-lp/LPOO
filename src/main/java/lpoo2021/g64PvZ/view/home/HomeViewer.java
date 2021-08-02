package lpoo2021.g64PvZ.view.home;

import lpoo2021.g64PvZ.gui.Gui;
import lpoo2021.g64PvZ.model.Home;
import lpoo2021.g64PvZ.view.Viewer;

public class HomeViewer extends Viewer<Home> {

    public HomeViewer(Home home){
        super(home);
    }

    @Override
    protected void drawElements(Gui gui) {
        int i=0;
        gui.drawBackground();
        for(String option :this.getModel().getOptions()){
            gui.drawString(3,3+i,option,getModel().getCurrentOption()==i ? "#FFD700" : "#FFFFFF");
            i++;
        }
    }

}
