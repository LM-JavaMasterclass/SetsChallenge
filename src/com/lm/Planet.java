package com.lm;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getBodyType()!=BodyTypes.MOON) {
            System.out.println("Only moons can be planet satellites");
            return false;
        }
        return super.addSatellite(moon);
    }

}
