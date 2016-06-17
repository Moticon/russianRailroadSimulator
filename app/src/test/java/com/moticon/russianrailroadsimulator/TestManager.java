package com.moticon.russianrailroadsimulator;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by moticon on 6/17/2016.
 *
 * This is a JUnit class to test the Manager class in the main project.
 */
public class TestManager implements Observer {
    Integer test = 0;

    public TestManager(){}

    @Test
    public void testObservable(){
        Manager manager = Manager.getInstance();

        manager.addObserver(this);
        assertNotEquals("Notified prior to calling 'notify me'", Integer.valueOf(4), test);
        manager.notifyMe(); // we will actually have already been notified
        assertEquals("Not notified", Integer.valueOf(4), test);
    }

    @Override
    public void update(Observable observable, Object data) {

        if (observable instanceof Manager ){
            Manager manager = (Manager) observable;
            test = manager.getTestInt();
        }
    }
}
