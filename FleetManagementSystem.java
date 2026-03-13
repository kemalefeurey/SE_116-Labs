class Vehicle {
    String licensePlate;
    double dailyRate;

    public Vehicle(String licensePlate, double dailyRate) {
        this.dailyRate = dailyRate;
        this.licensePlate = licensePlate;
    }
    public void safetyCheck() {
        System.out.println("The brakes and lights are safe to go!");
    }
    public double calculateRental(int days) {
        return days * dailyRate;
    }
    public boolean checkRisk(){
        return false;
    }
}

class Truck extends Vehicle {
    public Truck(String licensePlate, double dailyRate, double cargoCapacity) {
        super(licensePlate, dailyRate);
        this.cargoCapacity = cargoCapacity;
    }

    double cargoCapacity;
    @Override
    public boolean checkRisk(){
        if(cargoCapacity<20){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void safetyCheck() {
        super.safetyCheck();
        if (cargoCapacity < 40) {
            System.out.println("The Truck is ready to go.");
        } else {
            System.out.println("The Truck is not ready to go!");
        }
    }

}

class HeavyDutyTruck extends Truck {
    int axleCount;

    public HeavyDutyTruck(String licensePlate, double dailyRate, double cargoCapacity, int axleCount) {
        super(licensePlate, dailyRate, cargoCapacity);
        this.axleCount = axleCount;
    }
    @Override
    public boolean checkRisk(){
        if(axleCount<=4){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public double calculateRental(int days) {
        return (super.calculateRental(days) + axleCount);
    }
}

public class FleetManagementSystem {
    static void main(String[] args) {
        Vehicle[] vArr = new Vehicle[3];
        Vehicle v = new Vehicle("12AB45", 45);
        Truck t = new Truck("17UP250", 25, 33);
        HeavyDutyTruck h = new HeavyDutyTruck("34CCC34", 60, 39, 4);
        vArr[0] = v;
        vArr[1] = t;
        vArr[2] = h;
        vArr[0].calculateRental(12);
        vArr[0].safetyCheck();
        vArr[1].calculateRental(13);
        vArr[1].safetyCheck();
        vArr[2].calculateRental(14);
        vArr[2].safetyCheck();
    }
}