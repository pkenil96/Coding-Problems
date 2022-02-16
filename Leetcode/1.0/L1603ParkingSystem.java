class L1603ParkingSystem {
    int bptr, big;
    int mptr, medium;
    int sptr, small;
    
    public L1603ParkingSystem(int big, int medium, int small) {
        bptr=0;
        mptr=0;
        sptr=0;
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(bptr == big){
                return false;
            } else {
                bptr++;
                return true;
            }
        } else if(carType == 2) {
            if(mptr == medium){
                return false;
            } else {
                mptr++;
                return true;
            }
        } else {
            if(sptr == small){
                return false;
            } else {
                sptr++;
                return true;
            }
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */