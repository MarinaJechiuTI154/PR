
    public void show(int level) {
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
