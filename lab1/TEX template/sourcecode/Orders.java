
    public Orders(String string, ArrayList<String> ordine) {
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

        for (int i = 0; i < 4; i++) {
            if (ordine.get(i).equals("id")) {
                this.id = list.get(i);
            }

            if (ordine.get(i).equals("category_id")) {
                this.category_id = Integer.parseInt(list.get(i));

            }

            if (ordine.get(i).equals("total")) {
                this.total = Double.parseDouble(list.get(i));
            }

            if (ordine.get(i).equals("created")) {
                this.created = list.get(i);
            }
        }
