import java.util.*;

public class Location {

    private String name;
    private String description;
    private ArrayList<Item> items;
    private HashMap<String, Location> connections;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<Item>();
        connections = new HashMap<String, Location>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addItem(Item newItem) {
        items.add(newItem);
    }

    public boolean hasItem(String itemName) {
        Iterator<Item> iterItems = items.iterator();
        while (iterItems.hasNext()) {
            if (iterItems.next().getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName)
    {
        Iterator <Item> iterItems=items.iterator();
        Item temp=null;
        while(iterItems.hasNext())
        {
            temp=iterItems.next();
            if(temp.getName().equalsIgnoreCase(itemName))
            {
                return temp;
            }
        }
        return null;
    }

    public Item getItem(int index)
    {
        if(items.size()<index || index<0)
        {
            return null;
        }
        else
        {
            Iterator <Item> iterItems=items.iterator();
            Item temp=null;
            for(int i=0;i<=index;i++)
            {
                temp=iterItems.next();
            }
            return temp;
        }
    }

    public int numItems()
    {
        return items.size();
    }

    public Item removeItem(String itemName)
    {
        Iterator <Item> iterItems=items.iterator();
        Item temp=null;
        while(iterItems.hasNext())
        {
            temp=iterItems.next();
            if(temp.getName().equalsIgnoreCase(itemName))
            {
                items.remove(temp);
                return temp;
            }
        }
        return null;
    }

    public void connect(String directionName, Location anotherLocation)
    {
        this.connections.put(directionName, anotherLocation);
    }

    public boolean canMove(String directionName)
    {
        if(connections.containsKey(directionName))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Location getLocation(String directionName)
    {
        if(connections.isEmpty())
        {
            return null;
        }
        else
        {
            return (Location)connections.get(directionName);
        }
    }

}
