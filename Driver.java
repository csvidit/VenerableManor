import java.util.*;
public class Driver {
    
    public static Location currLocation;
    public static ContainerItem myInventory;

    public static void createWorld()
    {
        Location Kitchen=new Location("Kitchen", "FoodOps Command Center");
        Item oreo = new Item("Oreo", "Cookies", "Classic chocolate sandwich cookies");
        Item ghirardelli = new Item("Ghirardelli", "Chocolate", "Dark chocolate with sea salt caramel");
        Item toaster = new Item("Toaster", "Appliance", "Jumpscare machine");
        Item refrigerator = new Item("Refrigerator", "Appliance", "Storage for temperature sensitive goods");
        Item homepod = new Item("HomePod", "Electronics", "For listening to music");
        Item dishwasher = new Item("Dishwasher", "Appliance", "For washing dishes.");
        Item chandelier = new Item("Chandelier", "Light Fixture", "To add a bit more style");

        Kitchen.addItem(oreo);
        Kitchen.addItem(ghirardelli);
        Kitchen.addItem(toaster);
        Kitchen.addItem(refrigerator);
        Kitchen.addItem(homepod);
        Kitchen.addItem(dishwasher);
        Kitchen.addItem(chandelier);

        Location livingRoom=new Location("LivingRoom", "Entertainment Headquarters");
        Item livingRoomTV= new Item("LivingRoomTV", "Electronics", "8K QLED TV For Netflix binge-watching");
        Item livingRoomSoundbar = new Item("BoseSoundbar", "Electronics", "For listening to Taylor Swift");
        Item livingRoomRecliner = new Item("Recliner", "Furniture", "For reclining");
        Item livingRoomCoffeeTable = new Item("CoffeeTable", "Furniture", "For keeping Game Day snacks");
        Item livingRoomPS5 = new Item("PlayStation5", "Electronics", "For playing FIFA");
        Item livingRoomCouch = new Item("Couch", "Furniture", "For sitting");
        Item livingRoomGame1 = new Item("GrandTheftAuto", "Game", "Role-playging PS5 game");
        Item livingRoomGame2 = new Item("FIFA21", "Game", "PS5 soccer game");

        livingRoom.addItem(livingRoomTV);
        livingRoom.addItem(livingRoomSoundbar);
        livingRoom.addItem(livingRoomRecliner);
        livingRoom.addItem(livingRoomCoffeeTable);
        livingRoom.addItem(livingRoomPS5);
        livingRoom.addItem(livingRoomCouch);
        livingRoom.addItem(livingRoomGame1);
        livingRoom.addItem(livingRoomGame2);

        Location masterBedroom = new Location("Master Bedroom", "Sleeping Zone");
        Item masterBedroomEcho = new Item("EchoShow", "Electronics", "Amazon Surveillance Device");
        Item masterBedroomBed = new Item("KingSizeBed", "Furniture", "For sleeping on");
        Item masterBedroomLamp = new Item("FloorLamp", "Light Fixture", "For late-night binge-reading");
        Item masterBedroomTV = new Item("BedroomTV", "Electronics", "For watching the news");
        Item masterBedroomBook1 = new Item("Angels&Demons", "Book", "Book by Dan Brown");
        Item masterBedroomBook2 = new Item("TheGrandDesign", "Book", "Book by Stephen Hawking");
        Item masterBedroomPhone = new Item("iPhone", "Electronics", "Overpriced mobile phone");
        
        ContainerItem masterBedroomDresser = new ContainerItem("Dresser", "Furniture", "For storing clothes");
        Item dresserItem1 = new Item("Jeans", "Clothes", "Classic dark blue jeans");
        Item dresserItem2 = new Item("TrenchCoat", "Clothes", "To feel like British royalty");
        Item dresserItem3 = new Item("Shirt", "Clothes", "Colour-changing shirt made of programmable matter");

        masterBedroomDresser.addItem(dresserItem1);
        masterBedroomDresser.addItem(dresserItem2);
        masterBedroomDresser.addItem(dresserItem3);


        masterBedroom.addItem(masterBedroomEcho);
        masterBedroom.addItem(masterBedroomBed);
        masterBedroom.addItem(masterBedroomLamp);
        masterBedroom.addItem(masterBedroomTV);
        masterBedroom.addItem(masterBedroomBook1);
        masterBedroom.addItem(masterBedroomBook2);
        masterBedroom.addItem(masterBedroomPhone);
        masterBedroom.addItem(masterBedroomDresser);

        Location homeOffice = new Location("HomeOffice", "Secret CIA Operations Center");
        Item homeOfficeComputer = new Item("MacPro", "Electronics", "For CPU-intensive workloads");
        Item homeOfficeDisplay = new Item("ProDisplayXDR", "Electronics", "Display for computer");
        Item homeOfficeDesk = new Item("TeakwoodDesk", "Furniture", "For keeping classified documents");
        Item homeOfficeChair = new Item("ExecutiveChair", "Furniture", "For midday naps");
        
        ContainerItem officeVault = new ContainerItem("Vault", "Furniture", "High-security storage");
        Item vaultItem1 = new Item("IDCard", "Document", "Area 51 access card");
        Item vaultItem2 = new Item("Passport", "Document", "Issued by the State of Wakanda");
        Item vaultItem3 = new Item("Project Eternity", "Document", "Classified project");

        officeVault.addItem(vaultItem1);
        officeVault.addItem(vaultItem2);
        officeVault.addItem(vaultItem3);

        homeOffice.addItem(homeOfficeComputer);
        homeOffice.addItem(homeOfficeDisplay);
        homeOffice.addItem(homeOfficeDesk);
        homeOffice.addItem(homeOfficeChair);
        homeOffice.addItem(officeVault);
        
        Location frontPorch = new Location("FrontPorch", "Entrance to the Vidit Khandelwal Palace");
        Item frontPorchChair = new Item("PorchChair", "Furniture", "For enjoying the evening breeze");
        Item frontPorchBasketball = new Item("Basketball", "Game", "To get fit");

        frontPorch.addItem(frontPorchChair);
        frontPorch.addItem(frontPorchBasketball);

        livingRoom.connect("south", frontPorch);
        frontPorch.connect("north", livingRoom);

        Kitchen.connect("east", livingRoom);
        livingRoom.connect("west", Kitchen);

        masterBedroom.connect("south", livingRoom);
        livingRoom.connect("north", masterBedroom);

        masterBedroom.connect("west", homeOffice);
        homeOffice.connect("east", masterBedroom);

        currLocation=frontPorch;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        createWorld();
        myInventory= new ContainerItem("Backpack", "Container", "For storing things");


        String command="";
        String commWords[];

        while(true)
        {
            System.out.print("\nEnter command : ");
            command=sc.nextLine();
            command=command.toLowerCase();
            command.trim();
            commWords=command.split(" ");
            command=commWords[0];
            switch(command)
            {
                case "quit":
                break;

                case "look":
                System.out.print("\n"+currLocation.getName()+" - "+currLocation.getDescription()+" has the following items:\n");
                if(currLocation.numItems()==0)
                {
                    System.out.print("\nNo items found.");
                }
                else 
                {
                    for(int i=0;i<currLocation.numItems();i++)
                    {
                        System.out.print("+ "+currLocation.getItem(i).getName()+"\n");
                    }
                }
                break;

                case "examine":
                if(commWords.length>1)
                {
                    if(currLocation.hasItem(commWords[1]))
                    {
                        System.out.print("\n"+currLocation.getItem(commWords[1]).toString());
                    }
                    else
                    {
                        System.out.print("\nCannot find that item");
                    }    
                }
                else 
                {
                    System.out.print("\nNo item name entered.");
                }
                break;
                case "go":
                if(commWords.length>1)
                {
                    if(currLocation.canMove(commWords[1].toLowerCase()))
                    {
                        currLocation=currLocation.getLocation(commWords[1]);
                    }
                    else if(commWords[1].equalsIgnoreCase("east") == false && commWords[1].equalsIgnoreCase("west") == false && commWords[1].equalsIgnoreCase("north") == false && commWords[1].equalsIgnoreCase("south") == false)
                    {
                        System.out.print("\nInvalid Direction. Only North, South, East, and West are supported.");
                    }
                    else
                    {
                        System.out.print("\nCannot go there");
                    }    
                }
                else
                {
                    System.out.print("\nPlease state a direction.");
                }
                break;
                case "inventory":
                System.out.print("\n"+myInventory.toString());
                break;
                case "take":
                if(commWords.length==4)
                {
                    if(currLocation.hasItem(commWords[3]))
                    {
                        ContainerItem thisContainer = (ContainerItem)(currLocation.getItem(commWords[3]));
                        if(thisContainer.hasItem(commWords[1]))
                        {
                            myInventory.addItem(thisContainer.removeItem(commWords[1]));
                        }
                        else 
                        {
                            System.out.print("\nSorry, this item is not in the container.");
                        }
                    }
                    else
                    {
                        System.out.print("\nSorry, that container is not at this location");
                    }
                }
                else if(commWords.length>1)
                {
                    if(currLocation.hasItem(commWords[1]))
                    {
                        myInventory.addItem(currLocation.removeItem(commWords[1]));
                    }
                    else 
                    {
                        System.out.print("\nCannot find that item.");
                    }
                }
                else 
                {
                    System.out.print("\nIncomplete Command. \nPlease mention an item you want to take.\nIf you want to take something from a container, please use this format: take __NAME__ from __CONTAINER__");
                }
                break;
                case "put":
                if(commWords.length==4)
                {
                    if(currLocation.hasItem(commWords[3]))
                    {   
                        ContainerItem thisContainer = (ContainerItem)currLocation.getItem(commWords[3]);
                        if(myInventory.hasItem(commWords[1]))
                        {
                            thisContainer.addItem(myInventory.removeItem(commWords[1]));
                        }
                        else 
                        {
                            System.out.print("\nSorry, this item is not in your inventory.");
                        }
                    }
                    else 
                    {
                        System.out.print("\nSorry, that container is not at this location");
                    }
                }
                else 
                {   
                    System.out.print("\nSorry, this is an incomplete command.\nPlease follow the format: put __NAME__ in __CONTAINER__");
                }
                break;
                case "drop":
                if(commWords.length>1)
                {
                    if(myInventory.hasItem(commWords[1]))
                    {
                        currLocation.addItem(myInventory.removeItem(commWords[1]));
                    }
                    else
                    {
                        System.out.print("\nCannot find that item.");
                    }
                }
                else 
                {
                    System.out.print("\nPlease mention an item you want to drop from inventory.");
                }
                break;
                case "help":
                System.out.print("\n\nLIST OF COMMANDS\n\n"+
                "\nlook :\tFind out your current location and the items currently there."+
                "\n\ngo <direction_name> :\tMove to another location based on your desired direction.\n    Directions supported: North, South, East, West"+
                "\n\nexamine <item_name> :\tGet a description of the particular Item"+
                "\n\nexamine <container_name> : \tGet a list of items in that container"+
                "\n\ninventory :\tFind out the list of items in your backpack."+
                "\n\ntake <item_name> :\tTake an item from your current location and put it into your backpack"+
                "\n\ndrop <item_name> :\tRemove an item from your backpack and drop it in your current location\n\n"+
                "\n\ntake <item_name> from <container_name> : \tTake an item from a container at the current location"+
                "\n\nput <item_name> in <container_name> : \tPut an item from inventory into a container at the current location");
                break;
                default:
                System.out.print("\nSorry, cannot do that yet.");
            }
            if(command.equals("quit"))
            {
                break;
            }
        }
        sc.close();
    }
}
