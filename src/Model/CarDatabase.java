package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarDatabase
{
    private HashMap<String, Vehicle> db = new HashMap<>();

    public void newVehicle()
    {
        String manufacturer = MagicGenerator.getRandomManufacturer();
        Vehicle vehicle = new Vehicle(MagicGenerator.getRandomColor(), MagicGenerator.getRandomName(), manufacturer, MagicGenerator.getRandomModel(manufacturer),MagicGenerator.getRandomLicencePlate());
        db.put(vehicle.getLicensePlate(), vehicle);
        System.out.println(vehicle.getLicensePlate());
    }
    public void db()
    {
        for (int i = 0; i < 1000; i++)
        {
            newVehicle();
        }
    }
    public ArrayList<Vehicle> QuickSearch (String s)
    {
        ArrayList<Vehicle> qslist = new ArrayList<>();

        for (Map.Entry entry:db.entrySet())
        {
            if (entry.getKey().toString().contains(s))
            {
                qslist.add(db.get(entry.getKey()));
            }
        }
        return qslist;
    }
    public Vehicle Search (String s)
    {
        if (db.get(s) != null)
        {
            System.out.println("moin");
            return db.get(s);
        }
        else{
            return null;
        }
    }
}
