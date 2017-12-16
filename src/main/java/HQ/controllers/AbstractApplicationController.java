package HQ.controllers;

import models.Application;

public abstract class AbstractApplicationController {
    Application application;

    public void setApplication(Application application) {
        this.application = application;
    }
    public abstract void showInfo();
}
