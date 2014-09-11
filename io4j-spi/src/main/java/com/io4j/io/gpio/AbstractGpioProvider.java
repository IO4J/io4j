package com.io4j.io.gpio;

import com.io4j.AbstractProvider;
import com.io4j.io.Pin;

import java.util.*;

public abstract class AbstractGpioProvider extends AbstractProvider<GpioProvider> implements GpioProvider {

    protected Map<Integer, Pin> pins_by_number = new HashMap<>();
    protected Map<String, Pin> pins_by_name = new HashMap<>();

    public AbstractGpioProvider(String name){
        super(name);
    }

    public <PIN_TYPE extends DigitalIOPin> void addPin(PIN_TYPE pin){

        // add pin to pin by number lookup map
        if(!pins_by_number.containsKey(pin.number()))
            pins_by_number.remove(pin.number());
        pins_by_number.put(pin.number(), pin);

        // add pin to pin by names lookup map
        if(!pins_by_name.containsKey(pin.name()))
            pins_by_name.remove(pin.name());
        pins_by_name.put(pin.name(), pin);
    }

    @Override
    public Collection<Pin> pins() {
        return pins_by_number.values();
    }

    @Override
    public Collection<Pin> pins(int ... number){
        List<Pin> results = new ArrayList<>();
        for(int key : number){
            if(pins_by_number.containsKey(key)){
                results.add(pins_by_number.get(key));
            }
        }
        return results;
    }

    @Override
    public Collection<Pin> pins(String ... name){
        List<Pin> results = new ArrayList<>();
        for(String key : name){
            if(pins_by_name.containsKey(key)){
                results.add(pins_by_name.get(key));
            }
        }
        return results;
    }

    @Override
    public boolean hasPin(int number){
        return pins_by_number.containsKey(number);
    }

    @Override
    public boolean hasPin(String name){
        return pins_by_name.containsKey(name);
    }

    @Override
    public boolean hasPins(int ... number){
        for(int key : number){
            if(!hasPin(key))
                return false;
        }
        return true;
    }

    @Override
    public boolean hasPins(String ... name){
        for(String key : name){
            if(!hasPin(key))
                return false;
        }
        return true;
    }

    @Override
    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(int number) {
        return (PIN_TYPE) pins_by_number.get(number);
    }

    @Override
    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(int number, Class<PIN_TYPE> type) {
        return type.cast(pin(number));
    }

    @Override
    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(String name) {
        return (PIN_TYPE) pins_by_name.get(name);
    }

    @Override
    public <PIN_TYPE extends DigitalPin> PIN_TYPE pin(String name, Class<PIN_TYPE> type) {
        return type.cast(pin(name));
    }

    @Override
    public String toString(){
        return String.format("[<%s> %s]", this.getClass().getName(), this.name);
    }

}
