/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /* TODO: Write a method named addDrivable that takes a String (the ID)
     *       and a Drivable object. If the ID string does not appear as a key
     *       in drivable_map, then add the pair to drivable_map.
     *       Return true if the Drivable was added to drivable_map.
     */
    public boolean addDrivable (String id, Drivable object) {
        if (! this.drivable_map.containsKey(id)) {
                this.drivable_map.put(id, object);
                return true;
        }
        return false;
    }



    /* TODO: Write a method named hasFasterThan that takes an int (a speed)
     *       and returns true iff there is at least one item in drivable_map
     *       that has a maxSpeed >= the speed given.
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     */
    public boolean hasFasterThan (int speed) {
//        ArrayList set_of_values = new ArrayList(drivable_map.values());
//        // Need: Access value of key, use the getMaxSpeed method.
//        for (int i = 0; i < set_of_values.size(); i++) {
//            int curr_value =  drivable_map.get(set_of_values.get(i)).getMaxSpeed();
//            if ( curr_value >= speed) {
//                return true;
//            }
//        }
//        return false;

        //new idea: create one for loop to get a list of speeds.
        // create a new for loop so it iterates thru the list of speeds and then compares.
        ArrayList speeds_so_far = new ArrayList();
        ArrayList set_of_keys = new ArrayList(drivable_map.keySet());

        for (int i = 0; i < drivable_map.size(); i++) {
            int current_speed = drivable_map.get(set_of_keys.get(i)).getMaxSpeed();
            speeds_so_far.add(current_speed);
        }

        for (int i = 0; i < speeds_so_far.size(); i++) {
            if ((int) speeds_so_far.get(i) >= speed) {
                return true;
            }
        }
        return false;
    }



    /* TODO: Write a method named getTradable that takes no arguments and
     *       returns a List containing all of the Tradable items in
     *       drivable_map.
     */

    public List getTradable() {
        ArrayList list_so_far = new ArrayList();
        ArrayList list_of_keys = new ArrayList(drivable_map.keySet());
        ArrayList list_of_values = new ArrayList(drivable_map.values());

        /* Since it seems like I can't do ((ArrayList) list_of_keys)[i], I will just
        do the if check with a list of values
        I can also can't do list_of_values[i]. Why am I unable to do this?
         */
        for (int i = 0; i < list_of_keys.size(); i++) {
            if (list_of_values.get(i) instanceof Tradable) {
                list_so_far.add(list_of_values.get(i));
            }
        }
        return list_so_far;
    }



    
}