import java.util.ArrayDeque;
import java.util.Scanner;

public class OrderLogs {
    private ArrayDeque<String> orderlogs;
    public OrderLogs(){
        orderlogs=new ArrayDeque<>();
    }
    public void addOrderlog(String log){
        orderlogs.push(log);
    }
    private void mostRecentLogEntry(){
        if(!orderlogs.isEmpty()){
            System.out.println("Most recent log: "+orderlogs.peek());
        }else{
            System.out.println("Log is empty!");
        }
    }
    private String getOrderLog(){
        if(orderlogs.isEmpty()){
            return null;
        }else{
            return orderlogs.pop();
        }
    }
    private void removeAllLogEntires(){
        orderlogs.clear();
        System.out.println("All logs removed.");
    }
    private boolean orderLogEmpty(){
        return orderlogs.isEmpty();
    }
    public void handleLogs(){
        Scanner input=new Scanner(System.in);
        String continuechoice;
        do{
            System.out.println("1. Display all logs\n"
            +"2. Display most recent log\n"
            +"3. Remove a log entry\n"
            +"4. Remove all logs\n"
            +"5. Check if the log is empty\n"
            +"Enter choice(1-5): ");
            int choice=input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("All logs: "+orderlogs);
                    break;
                case 2:
                    mostRecentLogEntry();
                    break;
                case 3:
                    if(!orderlogs.isEmpty()){
                        System.out.println("Removed: "+getOrderLog());
                   }else{
                    System.out.println("Log is empty!");
                   }
                   break;
                case 4:
                   removeAllLogEntires();
                   break;
                case 5:
                   System.out.println("Log is empty: "+orderLogEmpty());
                   break;
                default:
                   System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("Continue? (Y/N): ");
            continuechoice=input.nextLine();
        }while(continuechoice.equalsIgnoreCase("Y"));
        input.close();
    }
}
