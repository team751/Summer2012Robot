package org.team751;

/**
 * Interface for anything that can sense temperature.
 * @author Sam Crow
 */
public interface TemperatureSensor {
    
    /**
     * Get the temperature, in degrees Celsius, that this sensor currently senses
     * @return the temperature
     */
    public double getTemperature();
    
}
