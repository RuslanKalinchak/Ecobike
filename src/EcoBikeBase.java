import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EcoBikeBase {
    String path = "C:\\Users\\kalin\\IdeaProjects\\Ecobike\\.idea\\resource\\ecobike.txt";

    public static void fillingEcoBikeBase (ArrayList <Bike> ecoBikeBase, String path) throws IOException {
       Scanner scanner = new Scanner(new File(path));
       while(scanner.hasNext()){
       String [] parameters = scanner.nextLine().split("; ");
       String [] sub = parameters [0].split(" ");
       StringBuilder stringBuilder = new StringBuilder();
       for (int i = 0; i < sub.length; i++){
           if (sub[i].matches("\\b[A-Z-]{4,}\\b")){
               stringBuilder.append(sub[i]);
               stringBuilder.append(" ");
           }
       }
       String type = String.valueOf(stringBuilder).trim();
       String brand = (parameters[0].substring(type.length(), parameters[0].length())).trim();
       try {
           if (type.equals("FOLDING BIKE")){
               ecoBikeBase.add(new FoldingBike(brand, Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]), Boolean.parseBoolean(parameters[4]), parameters[5].trim(), Integer.parseInt(parameters[6])));
           } else if (type.equals("SPEEDELEC")){
               ecoBikeBase.add(new Speedelec(brand, Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]), Boolean.parseBoolean(parameters[3]), Integer.parseInt(parameters[4]), parameters[5].trim(),Integer.parseInt(parameters[6]) ));
           } else if (type.equals("E-BIKE")){
               ecoBikeBase.add(new EBike(brand, Integer.parseInt(parameters[1]), Integer.parseInt(parameters[2]), Boolean.parseBoolean(parameters[3]), Integer.parseInt(parameters[4]), parameters[5].trim(),Integer.parseInt(parameters[6])));
           }
       } catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Error");
       }


       }
       scanner.close();
}

   public static void printAllEcoBikeBase(List <Bike> ecoBikeBase){
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass()==FoldingBike.class){
                if (ecoBikeBase.get(i).isAvailabilityOfLights()==false){
                System.out.println("FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+" with "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber() + " gear(s) and no head/tail light.");
                System.out.println("Price: "+ecoBikeBase.get(i).getPrice()+ " euros.");}
                else {
                    System.out.println("FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+" with "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber() + " gear(s) and head/tail light.");
                    System.out.println("Price: "+ecoBikeBase.get(i).getPrice()+ " euros.");}
            } else if (ecoBikeBase.get(i).getClass()==Speedelec.class){
                if (ecoBikeBase.get(i).isAvailabilityOfLights()==false){
                    System.out.println("SPEEDELEC "+ecoBikeBase.get(i).getBrand()+ " with "+((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()+" mAh battery and no head/tail light.");
                    System.out.println("Price: "+ecoBikeBase.get(i).getPrice()+ " euros.");
                } else {
                    System.out.println("SPEEDELEC "+ecoBikeBase.get(i).getBrand()+ " with "+((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()+" mAh battery and head/tail light.");
                    System.out.println("Price: "+ecoBikeBase.get(i).getPrice()+ " euros.");
                }
            } else if (ecoBikeBase.get(i).getClass()==EBike.class){
                if (ecoBikeBase.get(i).isAvailabilityOfLights()==false){
                    System.out.println("E-BIKE "+ecoBikeBase.get(i).getBrand()+ " with "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+" mAh battery and no head/tail light.");
                    System.out.println("Price: "+ecoBikeBase.get(i).getPrice()+ " euros.");
                } else {
                    System.out.println("E-BIKE "+ecoBikeBase.get(i).getBrand()+ " with "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+" mAh battery and head/tail light.");
                    System.out.println("Price: "+ecoBikeBase.get(i).getPrice()+ " euros.");
                }
            }

        }
}

public static void addNewFoldingBike (List <Bike> ecoBikeBase) {
    Scanner scanner = new Scanner(System.in);
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        boolean flag7 = true;
        boolean availabilityOfLightsFlag = false;
        String brand=null;
        int wheelsSize = 0;
        int gearsNumber = 0;
        int bikeWeight = 0;
        boolean availabilityOfLights = false;
        String bikeColor = null;
        int price = 0;
    System.out.println("Please write the brand of bike you want to add to the database");

    while(flag1){
        String brand2;
        try{
            brand2 = scanner.nextLine().trim();
            if(brand2.equals("\\n")){
                throw new Exception();
            }
            brand=brand2;
            flag1 = false;
            break;
        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");
        }
    }

    System.out.println("Please write the wheels size of the bike (in inch)");
    while(flag2){
        String argument7;
        try{
            argument7 = scanner.nextLine();
            if ((Integer.parseInt(argument7))>0)
            { wheelsSize = Integer.parseInt(argument7);
                flag2 = false;
                break;}
            else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");}}

    System.out.println("Write the number of bike gears");
    while(flag3){
        String argument8;
        try{
            argument8 = scanner.nextLine();
            if ((Integer.parseInt(argument8))>0)
            { gearsNumber = Integer.parseInt(argument8);
                flag3 = false;
                break;}
            else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");}}

    System.out.println("Please write the bike weight (in grams)");
    while(flag4){
        String argument9;
        try{
            argument9 = scanner.nextLine();
            if ((Integer.parseInt(argument9))>0)
            { bikeWeight = Integer.parseInt(argument9);
                flag4 = false;
                break;}
            else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");}}

    System.out.println("Write the availability of lights at front and back (true/false)");
    while(flag5){
        String argument10;
        try{
            argument10 = scanner.nextLine().trim();
            if (argument10.equalsIgnoreCase("TRUE")||argument10.equalsIgnoreCase("FALSE")){
                availabilityOfLights = Boolean.parseBoolean(argument10);
                availabilityOfLightsFlag = true;
                flag5 = false;
                break;
            } else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");}}

    System.out.println("Write the bike color");
    while(flag6){
        String argument11;
        try{
            argument11 = scanner.nextLine().trim();
            if (argument11.matches("[A-Za-z\\u0020]+")){
                bikeColor = argument11;
                flag6 = false;
                break;
            }
            else {
                throw new Exception();
            }

        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");}}

    System.out.println("Please write the bike price");

    while(flag7){
        String argument12;
        try{
            argument12 = scanner.nextLine();
            if ((Integer.parseInt(argument12))>0)
            { price = Integer.parseInt(argument12);
                flag7 = false;
                break;}
            else {
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("You wrote the wrong information, please try again...");}}

    ecoBikeBase.add(new FoldingBike(brand, wheelsSize, gearsNumber, bikeWeight, availabilityOfLights, bikeColor, price));
    System.out.println("You successfully adding your bike to the database with parameters: ");
    System.out.println("brand " + ecoBikeBase.get(ecoBikeBase.size()-1).getBrand() + ";");
    System.out.println("wheels size " + ((FoldingBike)ecoBikeBase.get(ecoBikeBase.size()-1)).getWheelsSize()+ " inch;");
    System.out.println("number of gears " + ((FoldingBike)ecoBikeBase.get(ecoBikeBase.size()-1)).getGearsNumber() + ";");
    System.out.println("bike weight " + ecoBikeBase.get(ecoBikeBase.size()-1).getWeight() + " grams;");
    System.out.println("availability of lights " + ecoBikeBase.get(ecoBikeBase.size()-1).isAvailabilityOfLights()+ ";");
    System.out.println("color " + ecoBikeBase.get(ecoBikeBase.size()-1).getColor() + ";");
    System.out.println("price " + ecoBikeBase.get(ecoBikeBase.size()-1).getPrice() + " $;");

    }

    public static void addNewSpeedelec (List <Bike> ecoBikeBase){
        Scanner scanner = new Scanner(System.in);
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        boolean flag7 = true;
        boolean availabilityOfLightsFlag = false;
        String brand=null;
        int maxSpeed = 0;
        int bikeWeight = 0;
        boolean availabilityOfLights = false;
        int batteryCapacity = 0;
        String bikeColor = null;
        int price = 0;

        System.out.println("Please write the brand of bike you want to add to the database");

        while(flag1){
            String brand2;
            try{
                brand2 = scanner.nextLine().trim();
                if(brand2.equals("\\n")){
                    throw new Exception();
                }
                brand=brand2;
                flag1 = false;
                break;
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");
            }
        }

        System.out.println("Write the maximum speed of the bike (in km/h)");
        while(flag2){
            String argument;
            try{
                argument = scanner.nextLine().trim();
                if ((Integer.parseInt(argument))>0){
                    maxSpeed = Integer.parseInt(argument);
                    flag2 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");
            }}

        System.out.println("Please write the bike weight (in grams)");
        while(flag3){
            String argument2;
            try{
                argument2 = scanner.nextLine().trim();
                if ((Integer.parseInt(argument2))>0){
                    bikeWeight = Integer.parseInt(argument2);
                    flag3 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");
            }}
        System.out.println("Write the availability of lights at front and back (true/false)");
        while(flag4){
            String argument3;
            try{
                argument3 = scanner.nextLine().trim();
                if (argument3.equalsIgnoreCase("TRUE")||argument3.equalsIgnoreCase("FALSE")){
                    availabilityOfLights = Boolean.parseBoolean(argument3);
                    availabilityOfLightsFlag = true;
                    flag4 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        System.out.println("Write the battery capacity of bike (in mAh)");
        while(flag5){
            String argument4;
            try{
                argument4 = scanner.nextLine();
                if ((Integer.parseInt(argument4))>0){
                    batteryCapacity = Integer.parseInt(argument4);
                    flag5 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        System.out.println("Write the bike color");

        while(flag6){
            String argument5;
            try{
                argument5 = scanner.nextLine().trim();
                if (argument5.matches("[A-Za-z\\u0020]+")){
                    bikeColor = argument5;
                    flag6 = false;
                    break;
                }
                else {
                    throw new Exception();
                }

            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        System.out.println("Please write the bike price");
        while(flag7){
            String argument6;
            try{
                argument6 = scanner.nextLine();
                if ((Integer.parseInt(argument6))>0)
                {price = Integer.parseInt(argument6);
                    flag7 = false;
                    break;}
                else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        ecoBikeBase.add(new Speedelec(brand, maxSpeed, bikeWeight, availabilityOfLights, batteryCapacity, bikeColor, price));
        System.out.println("You successfully adding your bike to the database with parameters: ");
        System.out.println("brand " + ecoBikeBase.get(ecoBikeBase.size()-1).getBrand() + ";");
        System.out.println("maximum speed " + ((EBike)ecoBikeBase.get(ecoBikeBase.size()-1)).getMaximumSpeed()+ " km/h;");
        System.out.println("bike weight " + ecoBikeBase.get(ecoBikeBase.size()-1).getWeight() + " grams;");
        System.out.println("availability of lights " + ecoBikeBase.get(ecoBikeBase.size()-1).isAvailabilityOfLights()+ ";");
        System.out.println("battery capacity " + ((EBike)ecoBikeBase.get(ecoBikeBase.size()-1)).getBatteryCapacity() + " mAh;");
        System.out.println("color " + ecoBikeBase.get(ecoBikeBase.size()-1).getColor() + ";");
        System.out.println("price " + ecoBikeBase.get(ecoBikeBase.size()-1).getPrice() + " $;");
        }

    public static void addNewEBike (List <Bike> ecoBikeBase) {
        Scanner scanner = new Scanner(System.in);
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;
        boolean flag5 = true;
        boolean flag6 = true;
        boolean flag7 = true;
        boolean availabilityOfLightsFlag = false;
        String brand=null;
        int maxSpeed = 0;
        int bikeWeight = 0;
        boolean availabilityOfLights = false;
        int batteryCapacity = 0;
        String bikeColor = null;
        int price = 0;

        System.out.println("Please write the brand of bike you want to add to the database");

        while(flag1){
            String brand2;
            try{
                brand2 = scanner.nextLine().trim();
                if(brand2.equals("\\n")){
                    throw new Exception();
                }
                brand=brand2;
                flag1 = false;
                break;
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");
            }
        }

        System.out.println("Write the maximum speed of the bike (in km/h)");
        while(flag2){
            String argument;
            try{
                argument = scanner.nextLine().trim();
                if ((Integer.parseInt(argument))>0){
                    maxSpeed = Integer.parseInt(argument);
                    flag2 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");
            }}

        System.out.println("Please write the bike weight (in grams)");
        while(flag3){
            String argument2;
            try{
                argument2 = scanner.nextLine().trim();
                if ((Integer.parseInt(argument2))>0){
                    bikeWeight = Integer.parseInt(argument2);
                    flag3 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");
            }}
        System.out.println("Write the availability of lights at front and back (true/false)");
        while(flag4){
            String argument3;
            try{
                argument3 = scanner.nextLine().trim();
                if (argument3.equalsIgnoreCase("TRUE")||argument3.equalsIgnoreCase("FALSE")){
                    availabilityOfLights = Boolean.parseBoolean(argument3);
                    availabilityOfLightsFlag = true;
                    flag4 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        System.out.println("Write the battery capacity of bike (in mAh)");
        while(flag5){
            String argument4;
            try{
                argument4 = scanner.nextLine();
                if ((Integer.parseInt(argument4))>0){
                    batteryCapacity = Integer.parseInt(argument4);
                    flag5 = false;
                    break;
                } else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        System.out.println("Write the bike color");

        while(flag6){
            String argument5;
            try{
                argument5 = scanner.nextLine().trim();
                if (argument5.matches("[A-Za-z\\u0020]+")){
                    bikeColor = argument5;
                    flag6 = false;
                    break;
                }
                else {
                    throw new Exception();
                }

            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}

        System.out.println("Please write the bike price");
        while(flag7){
            String argument6;
            try{
                argument6 = scanner.nextLine();
                if ((Integer.parseInt(argument6))>0)
                {price = Integer.parseInt(argument6);
                    flag7 = false;
                    break;}
                else {
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("You wrote the wrong information, please try again...");}}


        ecoBikeBase.add(new EBike(brand, maxSpeed, bikeWeight, availabilityOfLights, batteryCapacity, bikeColor, price));
        System.out.println("You successfully adding your bike to the database with parameters: ");
        System.out.println("brand " + ecoBikeBase.get(ecoBikeBase.size()-1).getBrand() + ";");
        System.out.println("maximum speed " + ((EBike)ecoBikeBase.get(ecoBikeBase.size()-1)).getMaximumSpeed()+ " km/h;");
        System.out.println("bike weight " + ecoBikeBase.get(ecoBikeBase.size()-1).getWeight() + " grams;");
        System.out.println("availability of lights " + ecoBikeBase.get(ecoBikeBase.size()-1).isAvailabilityOfLights()+ ";");
        System.out.println("battery capacity " + ((EBike)ecoBikeBase.get(ecoBikeBase.size()-1)).getBatteryCapacity() + " mAh;");
        System.out.println("color " + ecoBikeBase.get(ecoBikeBase.size()-1).getColor() + ";");
        System.out.println("price " + ecoBikeBase.get(ecoBikeBase.size()-1).getPrice() + " $;");

        }

    public static void writeBaseToFile (List <Bike> ecoBikeBase, String path){
        try (FileWriter fileWriter = new FileWriter(path, false)){
           for (int i = 0; i<ecoBikeBase.size(); i++){
               if (ecoBikeBase.get(i).getClass()==FoldingBike.class){
                   String result = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                   fileWriter.write(result);
                   fileWriter.append('\n');
                   fileWriter.flush();
               } else if (ecoBikeBase.get(i).getClass()==Speedelec.class){
                    String result = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                    fileWriter.write(result);
                   fileWriter.append('\n');
                    fileWriter.flush();
               } else if (ecoBikeBase.get(i).getClass()==EBike.class){
                   String result = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                   fileWriter.write(result);
                   fileWriter.append('\n');
                   fileWriter.flush();
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void search (List <Bike> ecoBikeBase, String type) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)){
                break;
            }
            if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
                printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            }
            System.out.println(printResult);
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, String brand) {
     Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()));
     int indexBeggin = 0;
     String typeFormatted = null;
     String printResult = null;
     if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
         typeFormatted = "FoldingBike";
         } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
         typeFormatted = "Speedelec";
     } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
         typeFormatted = "EBike";
     }
     for (int i = 0; i<ecoBikeBase.size(); i++){
         if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)){
             indexBeggin = i;
             break;
         }
     }

     for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
         if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)){
             break;
         }
         if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
             printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
         } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
             printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
         } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
             printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
         }
         System.out.println(printResult);
     }
    }

    public static void search (List <Bike> ecoBikeBase, String type, int wheelsSize, String brand) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByWheelsSizeComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()==wheelsSize){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()!=wheelsSize){
                break;
            }
            printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            System.out.println(printResult);
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, int wheelsSize, String brand, int gearsNumber) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByWheelsSizeComparator()).thenComparing(new SortByGearsNumberComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()==wheelsSize&&((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()==gearsNumber){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()!=wheelsSize||((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()!=gearsNumber){
                break;
            }
            printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            System.out.println(printResult);
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, int wheelsSize, String brand, int gearsNumber, int weight) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByWheelsSizeComparator()).thenComparing(new SortByGearsNumberComparator()).thenComparing(new SortByWeightComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()==wheelsSize&&((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()==gearsNumber&&ecoBikeBase.get(i).getWeight()==weight){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()!=wheelsSize||((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()!=gearsNumber||ecoBikeBase.get(i).getWeight()!=weight){
                break;
            }
            printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            System.out.println(printResult);
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, int wheelsSize, String brand, int gearsNumber, int weight, boolean availabilityOfLights) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByWheelsSizeComparator()).thenComparing(new SortByGearsNumberComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()==wheelsSize&&((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()==gearsNumber&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()!=wheelsSize||((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()!=gearsNumber||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights){
                break;
            }
            printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            System.out.println(printResult);
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, int wheelsSize, String brand, int gearsNumber, int weight, boolean availabilityOfLights, String color) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByWheelsSizeComparator()).thenComparing(new SortByGearsNumberComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()).thenComparing(new SortByColorComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()==wheelsSize&&((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()==gearsNumber&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()!=wheelsSize||((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()!=gearsNumber||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||!ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)){
                break;
            }
            printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
            System.out.println(printResult);
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, int wheelsSize, String brand, int gearsNumber, int weight, boolean availabilityOfLights, String color, int price) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByWheelsSizeComparator()).thenComparing(new SortByGearsNumberComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()).thenComparing(new SortByColorComparator()).thenComparing(new SortByPriceComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        for (int i = 0; i<ecoBikeBase.size(); i++){
            if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()==wheelsSize&&((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()==gearsNumber&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)&&ecoBikeBase.get(i).getPrice()==price){
                indexBeggin = i;
                break;
            }
        }

        for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
            if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()!=wheelsSize||((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()!=gearsNumber||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||!ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)||ecoBikeBase.get(i).getPrice()!=price){
                break;
            }

            printResult = "FOLDING BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((FoldingBike)ecoBikeBase.get(i)).getWheelsSize()+"; "+((FoldingBike)ecoBikeBase.get(i)).getGearsNumber()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

            System.out.println(printResult);
        }
    }



    public static void search (List <Bike> ecoBikeBase, String type, String brand, int maximumSpeed) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByMaximumSpeedComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        if (typeFormatted.equals("Speedelec")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed){
                    indexBeggin = i;
                    break;
                }
            }
            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed){
                    break;
                }
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                System.out.println(printResult);
            }

        } else if (typeFormatted.equals("EBike")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((EBike)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed){
                    indexBeggin = i;
                    break;
                }
            }

            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((EBike)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed){
                    break;
                }

                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

                System.out.println(printResult);
            }
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, String brand, int maximumSpeed, int weight) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByMaximumSpeedComparator()).thenComparing(new SortByWeightComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        if (typeFormatted.equals("Speedelec")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight){
                    indexBeggin = i;
                    break;
                }
            }
            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight){
                    break;
                }
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                System.out.println(printResult);
            }

        } else if (typeFormatted.equals("EBike")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((EBike)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight){
                    indexBeggin = i;
                    break;
                }
            }

            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((EBike)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight){
                    break;
                }

                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

                System.out.println(printResult);
            }
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, String brand, int maximumSpeed, int weight, boolean availabilityOfLights) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByMaximumSpeedComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        if (typeFormatted.equals("Speedelec")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights){
                    indexBeggin = i;
                    break;
                }
            }
            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights){
                    break;
                }
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                System.out.println(printResult);
            }

        } else if (typeFormatted.equals("EBike")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((EBike)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights){
                    indexBeggin = i;
                    break;
                }
            }

            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((EBike)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights){
                    break;
                }

                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

                System.out.println(printResult);
            }
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, String brand, int maximumSpeed, int weight, boolean availabilityOfLights, int batteryCapacity) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByMaximumSpeedComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()).thenComparing(new SortByBatteryCapacityComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        if (typeFormatted.equals("Speedelec")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()==batteryCapacity){
                    indexBeggin = i;
                    break;
                }
            }
            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()!=batteryCapacity){
                    break;
                }
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                System.out.println(printResult);
            }

        } else if (typeFormatted.equals("EBike")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((EBike)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&((EBike)ecoBikeBase.get(i)).getBatteryCapacity()==batteryCapacity){
                    indexBeggin = i;
                    break;
                }
            }

            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((EBike)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||((EBike)ecoBikeBase.get(i)).getBatteryCapacity()!=batteryCapacity){
                    break;
                }

                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

                System.out.println(printResult);
            }
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, String brand, int maximumSpeed, int weight, boolean availabilityOfLights, int batteryCapacity, String color) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByMaximumSpeedComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()).thenComparing(new SortByBatteryCapacityComparator()).thenComparing(new SortByColorComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }

        if (typeFormatted.equals("Speedelec")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()==batteryCapacity&&ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)){
                    indexBeggin = i;
                    break;
                }
            }
            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()!=batteryCapacity||!ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)){
                    break;
                }
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                System.out.println(printResult);
            }

        } else if (typeFormatted.equals("EBike")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((EBike)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&((EBike)ecoBikeBase.get(i)).getBatteryCapacity()==batteryCapacity&&ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)){
                    indexBeggin = i;
                    break;
                }
            }

            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((EBike)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||((EBike)ecoBikeBase.get(i)).getBatteryCapacity()!=batteryCapacity||!ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)){
                    break;
                }

                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

                System.out.println(printResult);
            }
        }
    }

    public static void search (List <Bike> ecoBikeBase, String type, String brand, int maximumSpeed, int weight, boolean availabilityOfLights, int batteryCapacity, String color, int price) {
        Collections.sort(ecoBikeBase, (new SortByTypeComparator()).thenComparing(new SortByBrandComparator()).thenComparing(new SortByMaximumSpeedComparator()).thenComparing(new SortByWeightComparator()).thenComparing(new SortByAvailabilityOfLightsComparator()).thenComparing(new SortByBatteryCapacityComparator()).thenComparing(new SortByColorComparator()).thenComparing(new SortByPriceComparator()));
        int indexBeggin = 0;
        String typeFormatted = null;
        String printResult = null;
        if ((type.toUpperCase().trim()).equals("FOLDING BIKE")){
            typeFormatted = "FoldingBike";
        } else if ((type.toUpperCase().trim()).equals("SPEEDELEC")){
            typeFormatted = "Speedelec";
        } else if ((type.toUpperCase().trim()).equals("E-BIKE")){
            typeFormatted = "EBike";
        }
        if (typeFormatted.equals("Speedelec")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()==batteryCapacity&&ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)&&ecoBikeBase.get(i).getPrice()==price){
                    indexBeggin = i;
                    break;
                }
            }
            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||((Speedelec)ecoBikeBase.get(i)).getBatteryCapacity()!=batteryCapacity||!ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)||ecoBikeBase.get(i).getPrice()!=price){
                    break;
                }
                printResult = "SPEEDELEC "+ecoBikeBase.get(i).getBrand()+"; "+((Speedelec)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((Speedelec) ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();
                System.out.println(printResult);
            }

        } else if (typeFormatted.equals("EBike")){
            for (int i = 0; i<ecoBikeBase.size(); i++){
                if (ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)&&ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)&&((EBike)ecoBikeBase.get(i)).getMaximumSpeed()==maximumSpeed&&ecoBikeBase.get(i).getWeight()==weight&&ecoBikeBase.get(i).isAvailabilityOfLights()==availabilityOfLights&&((EBike)ecoBikeBase.get(i)).getBatteryCapacity()==batteryCapacity&&ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)&&ecoBikeBase.get(i).getPrice()==price){
                    indexBeggin = i;
                    break;
                }
            }

            for (int i = indexBeggin; i<ecoBikeBase.size(); i++){
                if (!ecoBikeBase.get(i).getClass().getSimpleName().equals(typeFormatted)||!ecoBikeBase.get(i).getBrand().equalsIgnoreCase(brand)||((EBike)ecoBikeBase.get(i)).getMaximumSpeed()!=maximumSpeed||ecoBikeBase.get(i).getWeight()!=weight||ecoBikeBase.get(i).isAvailabilityOfLights()!=availabilityOfLights||((EBike)ecoBikeBase.get(i)).getBatteryCapacity()!=batteryCapacity||!ecoBikeBase.get(i).getColor().equalsIgnoreCase(color)||ecoBikeBase.get(i).getPrice()!=price){
                    break;
                }

                printResult = "E-BIKE "+ecoBikeBase.get(i).getBrand()+"; "+((EBike)ecoBikeBase.get(i)).getMaximumSpeed()+"; "+ecoBikeBase.get(i).getWeight()+"; "+ecoBikeBase.get(i).isAvailabilityOfLights()+"; "+((EBike)ecoBikeBase.get(i)).getBatteryCapacity()+"; "+ecoBikeBase.get(i).getColor()+"; "+ecoBikeBase.get(i).getPrice();

                System.out.println(printResult);
            }
        }
        }

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.start();
        }}
