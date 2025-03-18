public class Main{
    public static void main(String[] args) throws Exception {
        HandleOrders handleOrders = new HandleOrders();
        handleOrders.takeOrder();
        handleOrders.createOrderSummary();
        handleOrders.getOrderLogs().handleLogs();
        handleOrders.getOrderQueue().displayQueue();
        System.out.println(handleOrders);
    }
}
