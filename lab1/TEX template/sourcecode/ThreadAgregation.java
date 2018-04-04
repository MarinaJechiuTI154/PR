
public class ThreadAgregation implements Callable<ArrayList<Categories>> {
    private ArrayList<Orders> orders;

    ReadCategories readCategories = new ReadCategories();
    ReadOrders readOrders = new ReadOrders();

    @Override
    public ArrayList<Categories> call() throws Exception {
        ArrayList<Categories> list = readCategories.call();
        this.orders = readOrders.call();
        return list;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }
}
