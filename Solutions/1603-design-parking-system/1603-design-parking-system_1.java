class ParkingSystem {
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        this.spaces = new int[3];
        spaces[0] = big; spaces[1] = medium; spaces[2] = small;
    }
    
    public boolean addCar(int carType) {
        if(spaces[carType-1] > 0){
            spaces[carType-1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */