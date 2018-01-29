class FoodDB {
    public Iterator FoodsContainingNames(String cName, String eName){
        TreeMap foodTreeResult = new TreeMap();
        Iterator foodList = getAllRecords();
        while (foodList.hasNext()){
            Food food = (Food) foodList.next();
            if (nameMatchKeyword(food.getCName(), cName) &&
                    nameMatchKeyword(food.getEName(), eName)
                foodTreeResult.put(food.getFoodKey(),food);
        }
        return foodTreeResult.values().iterator();
    }
    private boolean nameMatchKeyword(String name, String keyword) {
        return keyword==null || keyword.equals("") ||
            name.indexOf(keyword)!=-1;
    }
}
