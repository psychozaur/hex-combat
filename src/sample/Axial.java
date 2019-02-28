package sample;

import java.util.Arrays;

public class Axial {

    private int[] axialCoordinates;

    public Axial(int[] axialCoordinates) {
        this.axialCoordinates = axialCoordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Axial axial = (Axial) o;
        return Arrays.equals(axialCoordinates, axial.axialCoordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(axialCoordinates);
    }
}
