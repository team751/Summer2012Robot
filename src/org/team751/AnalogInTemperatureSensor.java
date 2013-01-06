package org.team751;

import edu.wpi.first.wpilibj.AnalogChannel;

/**
 * A temperature sensor that gets its temperature from an analog input.
 * This class implements offset and scaling for a sensor that has a linear
 * relationship between temperature and output voltage.
 * 
 * To subclass this:
 * Create a class that extends this one 
 * 
 * @author Sam Crow
 */
public abstract class AnalogInTemperatureSensor implements TemperatureSensor {
    
    /** 
     * A temperature (in degrees Celsius) at which the sensor is known to output a
     * certain voltage specified by {@link #knownVoltage}.
     */
    private double knownTemperature;
    /**
     * The voltage that the sensor outputs at the temperature specified by
     * {@link #knownTemperature}.
     */
    private double knownVoltage;
    /**
     * The slope of the graph with temperature on the Y axis and voltage on the
     * X axis. This is also the number of degrees Celsius that the temperature
     * changes for every volt of output change, or the inverse of the number
     * of volts per degree Celsius.
     */
    private double slope;
    
    /**
     * The analog input that the sensor uses.
     */
    protected AnalogChannel input;
    
    /**
     * Constructor
     * @param knownTemperature see {@link #knownTemperature}
     * @param knownVoltage see {@link #knownVoltage}
     * @param slope see {@link #slope}
     * @param input see {@link #input}
     */
    protected AnalogInTemperatureSensor(double knownTemperature, double knownVoltage, double slope, AnalogChannel input) {
        this.knownTemperature = knownTemperature;
        this.knownVoltage = knownVoltage;
        this.slope = slope;
        this.input = input;
    }

    public double getTemperature() {
        // Point-slope format: Line through (a, b) with slope m:
        // y - b = a (x - a)
        // y = a(x - a) + b
        return slope * (input.getVoltage() - knownVoltage) + knownTemperature;
    }
    
    
    
}
