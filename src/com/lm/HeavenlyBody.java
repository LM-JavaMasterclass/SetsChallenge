package com.lm;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody { // abstract, so it cannot be instantiated and need to go through subclasses
    // For TB solution for uniqueness etc, use of Key:
//    private final Key key;
    // Plus removes name and bodyType (as contained in Key), and changes constructor as such, and do changes in Main
    // Many changes, can check video

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType; // originally planned to use String, changed to enum after learning from TB solution

    public enum BodyTypes {
        STAR,
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.bodyType = bodyType;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    @Override
    public final boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass()!= this.getClass())) {
            return false;
        }

        if(!this.bodyType.equals(((HeavenlyBody)obj).bodyType)){ // already know they must be same class
            return false;
        }

        // TB uses instanceof:
//        if (obj instanceof HeavenlyBody){
//            HeavenlyBody theObject = (HeavenlyBody) obj;
//            if (this.name.equals(theObject.getName())) {
//                return this.bodyType == theObject.getBodyType();
//            }
//        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public final int hashCode() { // uses hashCOde for both String and enum
        return this.name.hashCode() + 57 + this.bodyType.hashCode();
    }

    // TB suggests overriding toString to make it easier checking on screen:
    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }

    // TB's solution to uniqueness and naming
    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        // Needed for use in Map
        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){ // If same name, check same bodyType
                return (this.bodyType == key.getBodyType());
            }
            return false;
        }
    }


}
