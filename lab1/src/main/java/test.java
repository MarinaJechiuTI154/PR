import varianta2.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class test  extends Thread {
    public static void main(String[] args) throws InterruptedException, IOException {
        ThreadAgregation threadAgregation = new ThreadAgregation();
        ArrayList<Categories> listCategories ;
        ArrayList<Orders> listOrders ;

        try {
            listCategories = threadAgregation.call();
            listOrders = threadAgregation.getOrders();
            out.println(Arrays.toString(listCategories.toArray()));
            out.println(Arrays.toString(listOrders.toArray()));
            manageData(listCategories, listOrders);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void manageData(ArrayList<Categories> listCategories, ArrayList<Orders> listOrders) throws IOException {


        System.out.println("--------------------------------------");
        Tree<String> root = new Tree<>("root");
        //--------------------------------------------------------------
        for(int i=1; i<listCategories.size();i++) {
            if(listCategories.get(i).getCategory_id() == 0) {
                Tree<String> child = new Tree<>(listCategories.get(i).getName());
                child.setidNode(listCategories.get(i).getId());
                double suma = getSuma(listOrders, child.getidNode());
                child.setSuma(suma);
                root.addChild(child);
                root.setSuma(suma);
                listCategories.remove(i);
                i--;
            }
        }
        int i=0;
        Tree<String> tempRoot = root;
        root = treeParseData(tempRoot, listCategories, listOrders);
        tempRoot = root.getChildren().get(1);
        tempRoot = treeParseData(tempRoot, listCategories, listOrders);
        root.getChildren().set(1, tempRoot);
        tempRoot = root.getChildren().get(2);
        tempRoot = treeParseData(tempRoot, listCategories, listOrders);
        root.getChildren().set(2, tempRoot);

        root.print(0);

    }

    public static Tree<String> treeParseData(Tree<String> root, ArrayList<Categories> listCategories, ArrayList<Orders> listOrders) {
        for(int i=1; i<listCategories.size();i++) {
            for(int j=0;j<root.getChildren().size();j++) {
                if(listCategories.get(i).getCategory_id() == root.getChildren().get(j).getidNode() ) {
                    Tree<String> child = new Tree<>(listCategories.get(i).getName());
                    child.setidNode(listCategories.get(i).getId());
                    double suma = getSuma(listOrders, child.getidNode());
                    child.setSuma(suma);
                    root.getChildren().get(j).addChild(child);
                    listCategories.remove(i);
                    i--;
                }
            }
        }
        return root;
    }

    public static double getSuma(ArrayList<Orders> listOrders, int category){
        double suma = 0;
        for (int i = 0; i < listOrders.size(); i++) {
            if(listOrders.get(i).getCategory_id() == category) suma+= listOrders.get(i).getTotal();
        }
        return  suma;
    }


}







