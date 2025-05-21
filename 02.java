class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    String getLicensePlate() {
        return licensePlate;
    }

    String getOwnerName() {
        return ownerName;
    }

    int getHoursParked() {
        return hoursParked;
    }
}

class ParkingLot {
    private int vehicleCount = 0;
    private Vehicle[] varray = new Vehicle[5];

    public void addVehicle(Vehicle V1) {
        if (vehicleCount < varray.length) {
            varray[vehicleCount] = V1;
            vehicleCount++;
        } else {
            System.out.println("Parking is unavailable");
        }
    }

    public void removeVehicle(String licensePlate) {
        for (int i = 0; i < vehicleCount; i++) {
            if (varray[i].getLicensePlate().equals(licensePlate)) {
                for (int j = i; j < vehicleCount - 1; j++) {
                    varray[j] = varray[j + 1];
                }
                varray[vehicleCount - 1] = null;
                vehicleCount--;
                return;
            }
        }
        System.out.println("License Plate " + licensePlate + " can't be found");
    }

    public void display() {
        System.out.println("\nParking Lot Status:");
        System.out.println("License Plate  Owner        Hours Parked");
        for (int i = 0; i < vehicleCount; i++) {
            Vehicle v = varray[i];
            System.out.println(v.getLicensePlate() + "      " + v.getOwnerName() + "      " + v.getHoursParked());
        }
        if (vehicleCount == 0) {
            System.out.println("The Parking Lot is empty");
        }
    }
}

 class Main {
    public static void main(String[] args) {
        ParkingLot pLot = new ParkingLot();

        pLot.addVehicle(new Vehicle("ABC123", "John Doe", 2));
        pLot.addVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        pLot.addVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        pLot.display();

        pLot.removeVehicle("XYZ789");
        pLot.display();
    }
}
