package varianta2;

import java.util.ArrayList;
import java.util.List;

public class Tree<T>{
    private T data = null;
    private List<Tree> children = new ArrayList<>();
    private Tree parent = null;
    private int idNode;
    private  double suma = 0;

    public void setSuma(double suma) {
        this.suma += suma;
    }

    public double getSuma() {
        return suma;
    }

    public void setidNode(int idNode) {
    	this.idNode = idNode;
    }
    public int getidNode() {
    	return idNode;
    }
    public Tree(T data) {
        this.data = data;
    }

    public void addChild(Tree<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public List<Tree> getChildren() {
        return children;
    }


    private void setParent(Tree parent) {
        this.parent = parent;
    }

    public Tree getParent() {
        return parent;
    }




    public void print(int level) {
        for (int i = 1; i < level; i++) {
            System.out.print("\t");
            this.getParent().setSuma(this.getSuma());

        }
        if(data != "root") {
            System.out.println(data +"  " + this.getSuma());
        }
        for (Tree child : children) {
            child.print(level + 1);
        }
    }
}