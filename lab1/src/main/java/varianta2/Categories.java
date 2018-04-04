package varianta2;

import java.util.ArrayList;
import java.util.Arrays;

public class Categories {
    private int id;
    private String name;
    private int category_id;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public Categories(int id, String name, int category_id) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
    }

    public Categories(String string, ArrayList<String> ordine) {
        int lastPosition = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ',') {
                list.add(string.substring(lastPosition, i));
                lastPosition = i + 1;
            }
        }
        if (string.charAt(string.length() - 1) == ',') {
            list.add("0");
        } else {

            list.add(string.substring(lastPosition, string.length()));
        }

        for (int i = 0; i < 3; i++) {
            if (ordine.get(i).equals("id")) {
                this.id = Integer.parseInt(list.get(i));
            }

            if (ordine.get(i).equals("category_id")) {
                this.category_id = Integer.parseInt(list.get(i));

            }

            if (ordine.get(i).equals("name")) {
                this.name = list.get(i);

            }
        }


    }


    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category_id=" + category_id +
                '}' + '\n';
    }
}
