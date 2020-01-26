import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    static boolean exitFlag = true;
    static Scanner scanner = new Scanner (System.in) ;
    static ArrayList <Bike> ecoBikeBase = new ArrayList<>();
    static String path = "C:\\Users\\kalin\\IdeaProjects\\Ecobike\\.idea\\resource\\ecobike.txt";
    public void start (){

        try {
            EcoBikeBase.fillingEcoBikeBase(ecoBikeBase, path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (exitFlag){
            boolean commandFlag = true;
            int commandNumber = 0;



            while(commandFlag){
                String number;
                try{
                    System.out.println("Please make your choice:");
                    System.out.println("1 - Show the entire EcoBike catalog");
                    System.out.println("2 – Add a new folding bike");
                    System.out.println("3 – Add a new speedelec");
                    System.out.println("4 – Add a new e-bike");
                    System.out.println("5 – Find the items of a particular brand");
                    System.out.println("6 – Write to file");
                    System.out.println("7 – Stop the program");
                    number = scanner.nextLine().trim();

                    if ((Integer.parseInt(number))>0&&(Integer.parseInt(number))<8){
                        commandNumber = Integer.parseInt(number);

                        break;

                    } else {

                    throw new Exception();}

                }catch(Exception e){
                    System.out.println("You wrote the wrong information, please try again...");
                }finally {
                    commandFlag = false;

                    }
            }
           if (commandNumber == 1){
                EcoBikeBase.printAllEcoBikeBase(ecoBikeBase);
           } else if (commandNumber==2){
                EcoBikeBase.addNewFoldingBike(ecoBikeBase);
            } else if (commandNumber == 3){
                EcoBikeBase.addNewSpeedelec(ecoBikeBase);
           } else if (commandNumber == 4){
                EcoBikeBase.addNewEBike(ecoBikeBase);
           } else if (commandNumber == 5){
               boolean commandSearchFlag = true;
               boolean commandSearchFlag2 = true;
               boolean commandSearchFlag3 = true;
               boolean commandSearchFlag4 = true;
               boolean commandSearchFlag5 = true;
               boolean commandSearchFlag6 = true;
               boolean commandSearchFlag7 = true;
               boolean commandSearchFlag8 = true;
               boolean commandSearchFlag9 = true;
               boolean commandSearchFlag10 = true;
               boolean commandSearchFlag11 = true;
               boolean commandSearchFlag12 = true;
               boolean commandSearchFlag13 = true;
               boolean commandSearchFlag14 = true;
               boolean availabilityOfLightsFlag = false;
               boolean commandSearchMainFlag = true;
               String type = null;
               String brand = null;
               int wheelsSize = 0;
               int gearsNumber = 0;
               int maxSpeed = 0;
               int weight = 0;
               int batteryCapacity = 0;
               boolean availabilityOfLights = false;
               String color = null;
               int price = 0;
               while (commandSearchMainFlag) {
                System.out.println("Please write the type of bike you need to find (choose between Folding Bike, Speedelec or E-Bike)");
                while(commandSearchFlag){

                    String type1;
                   try{
                       type1=(scanner.nextLine()).trim();
                       if (type1.equalsIgnoreCase("FOLDING BIKE")||type1.equalsIgnoreCase("SPEEDELEC")||type1.equalsIgnoreCase("E-BIKE")){
                         type = type1;
                           commandSearchFlag = false;
                           break;
                       } else {
                           throw new Exception();}
                   }
                           catch (Exception e){
                       System.out.println("You wrote the wrong information (choose between Folding Bike, Speedelec or E-Bike), please try again...");
                       }
                }


               System.out.println("Write the bike brand you need to find. If you are not interested in this option, then press enter");

               while(commandSearchFlag2){
                   String brand2;
                   try{
                       brand2 = scanner.nextLine().trim();
                       if(brand2.equals("\\n")){
                           brand=brand2;
                           commandSearchFlag2 = false;
                           break;
                       }
                       brand=brand2;
                       commandSearchFlag2 = false;
                       break;
                   }catch(Exception e){
                       System.out.println("You wrote the wrong information, please try again...");
                       }
               }

               if (brand.equals("")||brand.matches("[\n]*")){
                   EcoBikeBase.search(ecoBikeBase, type);
                   commandSearchMainFlag = false;
                   break;
               }

                   //перша гілка розгалудження
                  if (type.toUpperCase().equals("SPEEDELEC")||type.toUpperCase().equals("E-BIKE")){
                      System.out.println("Please write the maximum speed of the bike you are search for. If you are not interested in this option, then press 0");
                      while(commandSearchFlag3){
                          String argument;
                          try{
                              argument = scanner.nextLine().trim();
                              if ((Integer.parseInt(argument))>=0){
                                  maxSpeed = Integer.parseInt(argument);
                                  commandSearchFlag3 = false;
                                  break;
                              } else {
                                throw new Exception();
                              }
                              }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");
                              }}

                      if (maxSpeed==0){
                          EcoBikeBase.search(ecoBikeBase, type, brand);
                          commandSearchMainFlag = false;
                          break;
                          }

                      System.out.println("Please write the bike weight you are search for. If you are not interested in this option, then press 0");
                      while(commandSearchFlag4){
                         String argument2;
                          try{
                              argument2 = scanner.nextLine().trim();
                              if ((Integer.parseInt(argument2))>=0){
                                  weight = Integer.parseInt(argument2);
                                  commandSearchFlag4 = false;
                                  break;
                              } else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");
                          }}

                      if (weight==0){
                          EcoBikeBase.search(ecoBikeBase, type, brand, maxSpeed);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Write the availability of lights at front and back (true/false).If you are not interested in this option, then press enter");
                      while(commandSearchFlag5){
                          String argument3;
                          try{
                              argument3 = scanner.nextLine().trim();
                              if (argument3.matches("[\n]*")){
                                  commandSearchFlag5 = false;
                                  break;
                              }
                              if (argument3.equalsIgnoreCase("TRUE")||argument3.equalsIgnoreCase("FALSE")){
                                  availabilityOfLights = Boolean.parseBoolean(argument3);
                                  availabilityOfLightsFlag = true;
                                  commandSearchFlag5 = false;
                                  break;
                              } else {
                                  throw new Exception();
                              }
                              }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (availabilityOfLightsFlag==false){
                          EcoBikeBase.search(ecoBikeBase, type, brand, maxSpeed, weight);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Write the battery capacity of bike.If you are not interested in this option, then press 0");
                      while(commandSearchFlag6){
                          String argument4;
                          try{
                              argument4 = scanner.nextLine();
                              if ((Integer.parseInt(argument4))>=0){
                                  batteryCapacity = Integer.parseInt(argument4);
                                  commandSearchFlag6 = false;
                                  break;
                              } else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (batteryCapacity==0){
                          EcoBikeBase.search(ecoBikeBase, type, brand, maxSpeed, weight, availabilityOfLights);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Write the bike color. If you are not interested in this option, then press enter");

                      while(commandSearchFlag7){
                          String argument5;
                          try{
                              argument5 = scanner.nextLine().trim();
                              if (argument5.matches("[\n]*")){
                                  color = argument5;
                                  commandSearchFlag7 = false;
                                  break;
                              } else if (argument5.matches("[A-Za-z\\u0020]+")){
                                  color = argument5;
                                  commandSearchFlag7 = false;
                                  break;
                              }
                              else if ((argument5.matches("[0-9]+")||argument5.matches("[0-9A-Za-z]+")&&!argument5.equals("\\n"))){
                                  throw new Exception();
                              }

                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (color.equals("")||color.matches("[\n]*")){
                          EcoBikeBase.search(ecoBikeBase, type, brand, maxSpeed, weight, availabilityOfLights, batteryCapacity);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Please write the bike price. If you are not interested in this option, then press 0");
                      while(commandSearchFlag8){
                          String argument6;
                          try{
                              argument6 = scanner.nextLine();
                             if ((Integer.parseInt(argument6))>=0)
                             {price = Integer.parseInt(argument6);
                              commandSearchFlag8 = false;
                              break;}
                              else {
                                 throw new Exception();
                             }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (price==0){
                          EcoBikeBase.search(ecoBikeBase, type, brand, maxSpeed, weight, availabilityOfLights, batteryCapacity, color);
                          commandSearchMainFlag = false;
                          break;
                      }
                      EcoBikeBase.search(ecoBikeBase, type, brand, maxSpeed, weight, availabilityOfLights, batteryCapacity, color, price);
                      commandSearchMainFlag = false;
                      break;
                          //блок виконання команд першої гілки

                      //виконання другої гілки пошуку

                         } else if (type.toUpperCase().trim().equals("FOLDING BIKE")){

                      System.out.println("Please write the wheels size of the bike. If you are not interested in this option, then press 0");
                      while(commandSearchFlag9){
                          String argument7;
                          try{
                              argument7 = scanner.nextLine();
                              if ((Integer.parseInt(argument7))>=0)
                              { wheelsSize = Integer.parseInt(argument7);
                                  commandSearchFlag9 = false;
                                  break;}
                              else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                              if (wheelsSize==0){
                              EcoBikeBase.search(ecoBikeBase, type, brand);
                              commandSearchMainFlag = false;
                              break;
                              }

                      System.out.println("Write the number of bike gears. If you are not interested in this option, then press 0");
                      while(commandSearchFlag10){
                          String argument8;
                          try{
                              argument8 = scanner.nextLine();
                              if ((Integer.parseInt(argument8))>=0)
                              { gearsNumber = Integer.parseInt(argument8);
                                  commandSearchFlag10 = false;
                                  break;}
                              else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (gearsNumber==0){
                          EcoBikeBase.search(ecoBikeBase, type, wheelsSize, brand);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Please write the bike weight you are search for. If you are not interested in this option, then press 0");
                      while(commandSearchFlag11){
                          String argument9;
                          try{
                              argument9 = scanner.nextLine();
                              if ((Integer.parseInt(argument9))>=0)
                              { weight = Integer.parseInt(argument9);
                                  commandSearchFlag11 = false;
                                  break;}
                              else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (weight==0){
                          EcoBikeBase.search(ecoBikeBase, type, wheelsSize, brand, gearsNumber);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Write the availability of lights at front and back (true/false).If you are not interested in this option, then press enter");
                      while(commandSearchFlag12){
                          String argument10;
                          try{
                              argument10 = scanner.nextLine().trim();
                              if (argument10.matches("[\n]*")){
                                  commandSearchFlag12 = false;
                                  break;
                              }
                              if (argument10.equalsIgnoreCase("TRUE")||argument10.equalsIgnoreCase("FALSE")){
                                  availabilityOfLights = Boolean.parseBoolean(argument10);
                                  availabilityOfLightsFlag = true;
                                  commandSearchFlag12 = false;
                                  break;
                              } else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (availabilityOfLightsFlag==false){
                          EcoBikeBase.search(ecoBikeBase, type, wheelsSize, brand, gearsNumber, weight);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Write the bike color. If you are not interested in this option, then press enter");
                      while(commandSearchFlag13){
                          String argument11;
                          try{
                              argument11 = scanner.nextLine().trim();
                              if (argument11.matches("[\n]*")){
                                  color = argument11;
                                  commandSearchFlag13 = false;
                                  break;
                              } else if (argument11.matches("[A-Za-z\\u0020]+")){
                                  color = argument11;
                                  commandSearchFlag13 = false;
                                  break;
                              }
                              else if ((argument11.matches("[0-9]+")||argument11.matches("[0-9A-Za-z]+")&&!argument11.equals("\\n"))){
                                  throw new Exception();
                              }

                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (color.equals("")||color.matches("[\n]*")){
                          EcoBikeBase.search(ecoBikeBase, type, wheelsSize, brand, gearsNumber, weight, availabilityOfLights);
                          commandSearchMainFlag = false;
                          break;
                      }

                      System.out.println("Please write the bike price. If you are not interested in this option, then press 0");

                      while(commandSearchFlag14){
                          String argument12;
                          try{
                              argument12 = scanner.nextLine();
                              if ((Integer.parseInt(argument12))>=0)
                              { price = Integer.parseInt(argument12);
                                  commandSearchFlag14 = false;
                                  break;}
                              else {
                                  throw new Exception();
                              }
                          }catch(Exception e){
                              System.out.println("You wrote the wrong information, please try again...");}}

                      if (price==0){
                          EcoBikeBase.search(ecoBikeBase, type, wheelsSize, brand, gearsNumber, weight, availabilityOfLights, color);
                          commandSearchMainFlag = false;
                          break;
                      }
                      EcoBikeBase.search(ecoBikeBase, type, wheelsSize, brand, gearsNumber, weight, availabilityOfLights, color, price);
                      commandSearchMainFlag = false;
                      break;
                    // виконання команд другого блоку
                  }}

           } else if (commandNumber == 6){
                EcoBikeBase.writeBaseToFile(ecoBikeBase, path);
           } else if (commandNumber == 7){
                stop();
           }
        }
    }

    public static void stop (){
        scanner.close();
        exitFlag = false;
    }
}
