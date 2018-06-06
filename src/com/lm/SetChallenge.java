package com.lm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetChallenge {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
                /*
        Modify the previous HeavenlyBody example so that the HeavenlyBody
        class also has a "bodyType" field. This field will store the
        type of HeavenlyBody (such as STAR, PLANET, MOON, etc).

        You can include as many types as you want, but must support at
        least PLANET and MOON.

        For each of the types that you support, subclass the HeavenlyBody class
        so that your program can create objects of the appropriate type.

        Although astronomers may shudder at this, our solar systems will
        allow two bodies to have the same name as long as they are not the
        same type of body: so you could have a star called "BetaMinor" and
        an asteroid also called "BetaMinor", for example.

        Hint: This is much easier to implement for the Set than it is for the Map,
        because the Map will need a key that uses both fields.

        There is a restriction that the only satellites that planets can have must
        be moons. Even if you don't implement a STAR type, though, your program
        should not prevent one being added in the future (and a STAR's satellites
        can be almost every kind of HeavenlyBody).

        Test cases:
        1. The planets and moons that we added in the previous video should appear in
        the solarSystem collection and in the sets of moons for the appropriate planets.

        2. a.equals(b) must return the same result as b.equals(a) - equals is symmetric.

        3. Attempting to add a duplicate to a Set must result in no change to the set (so
        the original value is not replaced by the new one).

        4. Attempting to add a duplicate to a Map results in the original being replaced
        by the new object.

        5. Two bodies with the same name but different designations can be added to the same set.

        6. Two bodies with the same name but different designations can be added to the same map,
        and can be retrieved from the map.
*/
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon); // temp is Earth

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon); // temp is now Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(temp.getBodyType() + "." + tempMoon.getName(), tempMoon); // Key value is the name
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getBodyType() + "." + temp.getName(), temp); // Key value is the name
        planets.add(temp);

        System.out.println("Planets");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("PLANET.Mars"); // Used to make sure that same name but different type is allowed
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody moon : body.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }
        // TB solution is creating an inner static class with the key (see in HeavenlyBody)


        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }


        HeavenlyBody pluto2 = new Planet("Pluto", 842);
        planets.add(pluto2);
        System.out.println("Planets again (check Pluto didn't overwrite with duplicate, so old values)");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName() + "-" + planet.getBodyType() + " - " + planet.getOrbitalPeriod());
        }
        solarSystem.put(pluto2.getBodyType() + "." + pluto2.getName(), pluto2);
        System.out.print("Pluto in solar system (check it has NEW values): ");
        System.out.println(solarSystem.get("PLANET.Pluto").getName() + ": " + solarSystem.get("PLANET.Pluto").getBodyType() + "-" +
                solarSystem.get("PLANET.Pluto").getOrbitalPeriod());

        HeavenlyBody pluto3 = new Planet("Pluto", 842);
        // Check equality works:
        System.out.println(pluto2.equals(pluto3));
        System.out.println(pluto3.equals(pluto2));

        HeavenlyBody pluto4 = new Star("Pluto", 842);
        solarSystem.put(pluto4.getBodyType() + "." + pluto4.getName(), pluto4);
        System.out.print("Pluto planet: ");
        System.out.println(solarSystem.get("PLANET.Pluto").getName() + ": " + solarSystem.get("PLANET.Pluto").getBodyType());
        System.out.print("Pluto star: ");
        System.out.println(solarSystem.get("STAR.Pluto").getName() + ": " + solarSystem.get("STAR.Pluto").getBodyType());


    }
}
