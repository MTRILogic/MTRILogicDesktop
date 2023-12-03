package com.mtrilogic.abstracts;

import com.mtrilogic.interfaces.PanelListener;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("unused")
public abstract class BaseFrame extends JFrame implements PanelListener {

    /*==================================================================================================================
    PROTECTED ABSTRACT METHODS
    ==================================================================================================================*/

    protected abstract void onInitComponents(Container container);
    protected abstract void onStart();

    /*==================================================================================================================
    PUBLIC CONSTRUCTORS
    ==================================================================================================================*/

    public BaseFrame(Dimension dimension) {
        this("Default Frame", dimension);
    }

    public BaseFrame(String title, Dimension dimension) {
        super(title);
        if (onFrameConfiguration(dimension)) {
            onInitComponents(getContentPane());
            start();
        }
    }

    /*==================================================================================================================
    OVERRIDE PUBLIC METHODS
    ==================================================================================================================*/

    @Override
    public BaseFrame getBaseFrame() {
        return this;
    }

    /*==================================================================================================================
    PUBLIC FINAL METHODS
    ==================================================================================================================*/

    public final void start() {
        setVisible(true);
        onStart();
    }

    /*==================================================================================================================
    PROTECTED METHODS
    ==================================================================================================================*/

    @SuppressWarnings("SameReturnValue")
    protected boolean onFrameConfiguration(Dimension dimension) {
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(dimension);
        setLocationRelativeTo(null);
        setResizable(false);
        return true;
    }
}
