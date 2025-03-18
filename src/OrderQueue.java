import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue {
    private Queue<String> orderQueue=new LinkedList<>();
    public void addOrder(String order){
        orderQueue.add(order);
        System.out.println("Order added to queue: "+order);
    }
    public void processNextOrder(){
        if(!orderQueue.isEmpty()){
            String nextOrder=orderQueue.poll();
            System.out.println("Process order: "+nextOrder);
        }else{
            System.out.println("No orders in queue.");
        }
    }
    public void displayQueue(){
        System.out.println("---Current Orders in Queue---");
        for(String order:orderQueue){
            System.out.println(order);
        }
    }
}
