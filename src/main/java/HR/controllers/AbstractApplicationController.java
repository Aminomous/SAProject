package HR.controllers;

import models.Application;

public abstract class AbstractApplicationController {
    Application application;
    MainController mainCtrl;

    public void setApplication(Application application) {
        this.application = application;
    }
    public void setMainController(MainController controller) {
        this.mainCtrl = controller;
    }
    public abstract void showInfo();
}
