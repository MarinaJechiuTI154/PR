package varianta2;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ReadCategories implements Callable<ArrayList<Categories>> {
    ArrayList<String> categories;
    ArrayList<Categories> listObjectCategories = new ArrayList<>();

    @Override
    public ArrayList<Categories> call() throws Exception {
        String url1 = "https://evil-legacy-service.herokuapp.com/api/v101/categories/?start=2017-09-01&end=2017-10-03";
        String key = "55193451-1409-4729-9cd4-7c65d63b8e76";
        Request request1 = new Request(url1, key);
        categories = request1.getData();

        ArrayList<String> list = order(categories.get(0));
        for (int i = 1; i < categories.size(); i++) {
            listObjectCategories.add(new Categories(categories.get(i), list));
        }
        return listObjectCategories;

    }

    private ArrayList<String> order(String string) {
        int lastPosition = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ',') {
                list.add(string.substring(lastPosition, i));
                lastPosition = i + 1;
            }
        }
        if (string.charAt(string.length() - 1) == ',') {
            list.add("-1");
        } else {

            list.add(string.substring(lastPosition, string.length()));
        }
        return list;

    }
}
