class NeedForSpeed {
    // TODO: define the constructor for the 'NeedForSpeed' class
    private int speed;
    private int batteryDrain;
    private int distance = 0;
    private int battery = 100;
    
    public NeedForSpeed(int speed, int batteryDrain)  {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }
    
    public boolean batteryDrained() {
        return battery <= 0;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (!batteryDrained()) {
            distance += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;
    
    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (true) {
            car.drive();
            if (car.distanceDriven() >= this.distance) {
                return true;
            } else if (car.batteryDrained()) {
                return false;
            }
        }

    }
}
