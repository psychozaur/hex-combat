package sample;

public class Cube {

    private int[] cubeCoordinates;

    public Cube(Directions directions) {
        this.cubeCoordinates = new int[3];

        cubeCoordinates = directionsToCoordinates(directions);
    }

    public int[] getCubeCoordinates() {
        return cubeCoordinates;
    }

    public int[] directionsToCoordinates(Directions directions){
        switch(directions){
            case NORTHWEST:
                return new int[]{0,1,-1};
            case WEST:
                return new int[]{-1,1,0};
            case SOUTHWEST:
                return new int[]{-1,0,1};
            case SOUTHEAST:
                return new int[]{0,-1,1};
            case EAST:
                return new int[]{1,-1,0};
            case NORTHEAST:
                return new int[]{1,0,-1};
                default:
                    return new int[]{0,0,0};
        }
    }
}
