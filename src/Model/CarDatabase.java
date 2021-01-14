package Model;

import java.util.HashMap;

public class CarDatabase
{
    private HashMap<String, Vehicle> db = new HashMap<>();

    public void newVehicle ()
    {
        String manufacturer = MagicGenerator.getRandomManufacturer();
        Vehicle vehicle = new Vehicle(MagicGenerator.getRandomColor(), MagicGenerator.getRandomName(), MagicGenerator.getRandomManufacturer(), MagicGenerator.getRandomModel(manufacturer), MagicGenerator.getRandomLicencePlate());
        db.put(vehicle.getLicensePlate(),vehicle);
    }

    public void db ()
    {
        for (int i = 0; i < 1000; i++)
        {
                newVehicle();
        }
    }
}
