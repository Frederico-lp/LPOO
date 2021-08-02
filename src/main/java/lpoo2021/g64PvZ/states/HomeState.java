package lpoo2021.g64PvZ.states;

import lpoo2021.g64PvZ.controller.Controller;
import lpoo2021.g64PvZ.controller.HomeController;
import lpoo2021.g64PvZ.model.Home;
import lpoo2021.g64PvZ.view.Viewer;
import lpoo2021.g64PvZ.view.home.HomeViewer;

public class HomeState extends State<Home>{
    public HomeState(Home home){
        super(home);
    }

    @Override
    protected Viewer<Home> getViewer(){
        return new HomeViewer(getModel());
    }

    @Override
    protected Controller<Home> getController() {
        return new HomeController(getModel());
    }
}
