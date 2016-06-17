package com.moticon.russianrailroadsimulator;

import java.util.Observable;

/**
 * Created by moticon on 6/17/2016.
 *
 * This class is the Manager, it will create all objects.  When it's done
 *    it will notify all interested objects that they can request links/references
 *    to the objects they are interested in.
 *
 * The goal of this is to allow all objects which are created to exist first, then
 *    allow them to link themselves to each other.
 *
 * The Manager is observable.  Objects which need to get other other links are observers.
 *
 */
public class Manager extends Observable {
    Integer testInt;

    private static Manager manager = new Manager();

    public static Manager getInstance() {
        return manager;
    }

    private Manager() {
        createAllObjects();
    }

    private void createAllObjects(){
        testInt = 4;

        /*
        Now notify observers that the objects are all created. They will call
        back for what they are interested in.
         */
        allObjectsCreated();
    }

    /**
     * This method is called when all objects are created. It will indicate the state
     * has changed. Then notifyObjervers() is called to let everyone know.
     */
    private void allObjectsCreated(){
        setChanged();
        notifyObservers();
    }

    /**
     * These methods are here simply to enable testing from the JUnit test class.
     * @return
     */
    public Integer getTestInt(){ return testInt;}
    public void notifyMe(){allObjectsCreated();}
}
