import java.util.ArrayList;
import java.util.Scanner;

public class HandleOrders {

    private static final double PIZZA_BASE_PRICE = 10.0;

    private String[] pizzasOrdered = new String[10];
    private String[] pizzaSizesOrdered = new String[10];
    private String[] sideDishesOrdered = new String[20];
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    private int numberOfPizzasOrdered = 0;
    StringBuilder pizzaOrderSummary = new StringBuilder();
    private ArrayList<CustomPizza> customPizzas=new ArrayList<>();
    private OrderLogs orderLogs=new OrderLogs();
    private OrderQueue orderQueue=new OrderQueue();
    public OrderLogs  getOrderLogs(){
        return orderLogs;
    }
    public OrderQueue getOrderQueue(){
        return orderQueue;
    }

    Scanner input = new Scanner(System.in);

    public void takeOrder(){
        String orderAnother = "Y";
        int j= 0;
        int m = 0;
        int n = 0;
        int p = 0;

        do{
            int i = 1;
            System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here's what we serve: \n");
            for(PizzaSelection pizza : PizzaSelection.values()){
                System.out.println(i + ". " + pizza);
                i++;
            }
            System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose: \n");

            System.out.println("Please enter your choice (1-6): \n");
            int choice = input.nextInt();
            input.nextLine();
            

            if(choice>0 && choice<6){
                switch(choice){
                    case 1:
                        System.out.println("You have selected " + PizzaSelection.PEPPERONI);
                        pizzasOrdered[j] = PizzaSelection.PEPPERONI.toString();
                        totalOrderPrice += PizzaSelection.PEPPERONI.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        String log1="Ordered: "+PizzaSelection.PEPPERONI.getPizzaName();
                        orderLogs.addOrderLog(log1);
                        break;
                    case 2:
                        System.out.println("You have selected " + PizzaSelection.HAWAIIAN);
                        pizzasOrdered[j] = PizzaSelection.HAWAIIAN.toString();
                        totalOrderPrice += PizzaSelection.HAWAIIAN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        String log2="Ordered: "+PizzaSelection.HAWAIIAN.getPizzaName();
                        orderLogs.addOrderLog(log2);
                        break;
                    case 3:
                        System.out.println("You have selected " + PizzaSelection.VEGGIE);
                        pizzasOrdered[j] = PizzaSelection.VEGGIE.toString();
                        totalOrderPrice += PizzaSelection.VEGGIE.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        String log3="Ordered: "+PizzaSelection.VEGGIE.getPizzaName();
                        orderLogs.addOrderLog(log3);
                        break;
                    case 4:
                        System.out.println("You have selected " + PizzaSelection.BBQ_CHICKEN);
                        pizzasOrdered[j] = PizzaSelection.BBQ_CHICKEN.toString();
                        totalOrderPrice += PizzaSelection.BBQ_CHICKEN.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        String log4="Ordered: "+PizzaSelection.BBQ_CHICKEN.getPizzaName();
                        orderLogs.addOrderLog(log4);
                        break;
                    case 5:
                        System.out.println("You have selected " + PizzaSelection.EXTRAVAGANZA);
                        pizzasOrdered[j] = PizzaSelection.EXTRAVAGANZA.toString();
                        totalOrderPrice += PizzaSelection.EXTRAVAGANZA.getPrice();
                        numberOfPizzasOrdered++;
                        j++;
                        String log5="Ordered: "+PizzaSelection.EXTRAVAGANZA.getPizzaName();
                        orderLogs.addOrderLog(log5);
                        break;
                    default:
                        System.out.println("Incorrect choice. Please try again.");
                        break;
                }
            } else if (choice == 6){
                double customPizzaPrice = 0;
                StringBuilder customPizzaTopping =new StringBuilder();
                System.out.println("For your custom pizza, here are the toppings:");
                int k = 1;
                for(PizzaToppings topping : PizzaToppings.values()){
                    System.out.println(k + ". " + topping);
                    k++;
                }
                System.out.println("Please enter a maximum of 10 topping choices.\n");

                StringBuilder customPizza = new StringBuilder(" Custom Pizza with ");
                
                int l = 1;
                do{
                    System.out.println("Enter topping #" + l + ". To stop, type 0: ");
                    int toppingChoice = input.nextInt();
                    input.nextLine();
                    if(toppingChoice == 0){
                        break;
                    }
                    String toppingName=PizzaToppings.values()[toppingChoice-1].getTopping();
                    customPizzaTopping.append(toppingName).append(", ");
                    customPizzaPrice += PizzaToppings.values()[toppingChoice-1].getToppingPrice();
                    l++;
                }while(l!=10 || l!=0);
                String topping=customPizzaTopping.toString();
                CustomPizza customPizzaDetail=new CustomPizza(topping, customPizzaPrice);
                customPizzas.add(customPizzaDetail);
                
                customPizzaPrice += PIZZA_BASE_PRICE;
                
                customPizza.append(": €" + customPizzaPrice);

                pizzasOrdered[j] ="Custom Pizza with "+topping+customPizza.toString();
                totalOrderPrice += customPizzaPrice;
                numberOfPizzasOrdered++;
                j++;
                String customlog="Custom Pizza with toppings: "+topping;
                orderLogs.addOrderLog(customlog);
            }

            i = 1;
            System.out.println("Here are the pizza sizes options: \n");
            for(PizzaSize pizza : PizzaSize.values()){
                System.out.println(i + ". " + pizza);
                i++;
            }

            System.out.println("Pick one size (1 - 3): \n");
            int sizeChoice = input.nextInt();
            input.nextLine();

            pizzaSizesOrdered[m] = PizzaSize.values()[sizeChoice-1].getPizzaSize() + ": €" + PizzaSize.values()[sizeChoice-1].getAddToPizzaPrice();
            totalOrderPrice += PizzaSize.values()[sizeChoice-1].getAddToPizzaPrice();
            m++;

            System.out.println("Here are the side dishes options: \n");
            i = 1;
            for(SideDish sideDish : SideDish.values()){
                System.out.println(i + ". " + sideDish);
                i++;
            }

            System.out.println("Pick one side dish (1 - 4): \n");
            int sideDishChoice = input.nextInt();
            input.nextLine();

            sideDishesOrdered[n] = SideDish.values()[sideDishChoice-1].getSideDishName() + ": €" + SideDish.values()[sideDishChoice-1].getAddToPizzaPrice();
            totalOrderPrice += SideDish.values()[sideDishChoice-1].getAddToPizzaPrice();
            n++;

            System.out.println("Here are the drinks options: \n");
            i = 1;
            for(Drinks drink : Drinks.values()){
                System.out.println(i + ". " + drink);
                i++;
            }

            System.out.println("Pick one drink (1 - 3): \n");
            int drinkChoice = input.nextInt();
            input.nextLine();

            drinksOrdered[p] = Drinks.values()[drinkChoice-1].getDrinkName() + ": €" + Drinks.values()[drinkChoice-1].getAddToPizzaPrice();
            totalOrderPrice += Drinks.values()[drinkChoice-1].getAddToPizzaPrice();
            p++;

            System.out.println("Would you like to order another pizza? (Y/N): \n");
            orderAnother = input.nextLine();
            
            String queueEntry="Pizza: "+pizzasOrdered[j-1]+"\n"+
                              "Size: "+pizzaSizesOrdered[m-1]+"\n"+
                              "Side: "+sideDishesOrdered[n-1]+"\n"+
                              "Drink: "+drinksOrdered[p-1];
            orderQueue.addOrder(queueEntry);
        }while(orderAnother.equalsIgnoreCase("Y"));


    }
    public void displayCustomPizzas(){
        System.out.println("\n---Custom Pizzas Ordered---");
        for(CustomPizza pizza:customPizzas){
            System.out.println(pizza);
        }
    }

    public void createOrderSummary(){
        
        pizzaOrderSummary.append("\nThank you for dining with Slice-o-Heaven. Your order details are as follows: \n");

        for(int i=0; i<numberOfPizzasOrdered; i++){
            pizzaOrderSummary.append((i+1) + pizzasOrdered[i] + "\n");
            pizzaOrderSummary.append(pizzaSizesOrdered[i] + "\n");
            pizzaOrderSummary.append(sideDishesOrdered[i] + "\n");
            pizzaOrderSummary.append(drinksOrdered[i] + "\n \n");
            
        }

        pizzaOrderSummary.append("ORDER TOTAL: €" + totalOrderPrice + "\n");
        orderQueue.addOrder("Complete Order:\n"+pizzaOrderSummary.toString());
    }

    @Override
    public String toString(){
        
        return pizzaOrderSummary.toString();
    }
    
}
