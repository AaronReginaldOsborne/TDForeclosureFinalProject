package ca.agoldfish.tdforeclosurefinalproject;

import java.util.Comparator;

public class CustomStateComparator implements Comparator<PropertyPackage> {
    @Override
    public int compare(PropertyPackage o1, PropertyPackage o2) {
        return o1.getState().compareTo(o2.getState());
    }
}