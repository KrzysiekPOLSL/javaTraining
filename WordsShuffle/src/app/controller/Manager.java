package app.controller;

import app.model.Shuffler;
import app.view.console.Printer;

/**
 *
 * Manager is the controller class from MVC, it stands for managing the two others
 * which are Model (handling data) and View (displaying data)
 */
public class Manager {
    private Shuffler shuffler;
    private Printer printer;
}
