import java.util.*;
public class ContainerItem extends Item{
    
    private ArrayList<Item> items;
    
    public ContainerItem(String name, String type, String description)
    {
        super(name, type, description);
        items = new ArrayList<Item>();

    }

    public void addItem(Item newItem)
    {
        items.add(newItem);
    }

    public boolean hasItem(String itemName)
    {
        Iterator<Item> iterItems = items.iterator();
        Item temp;
        while(iterItems.hasNext())
        {
            temp=iterItems.next();
            if(temp.getName().equalsIgnoreCase(itemName))
            {
                return true;
            }
        }
        return false;
    }

    public Item removeItem(String itemName)
    {
        Iterator<Item> iterItems = items.iterator();
        Item temp;
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

    @Override
    public String toString()
    {
        String toString="";
        toString+=this.getName()+" [ "+this.getType()+" ] : "+this.getDescription();
        Iterator<Item> iterItems = items.iterator();
        Item temp;
        while(iterItems.hasNext())
        {
            temp=iterItems.next();
            toString+="\n + "+temp.getName();
        }
        return toString;
    }
}
