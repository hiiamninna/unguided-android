package com.ninnanovila.materialdesign;

//data get from http://www.recipepuppy.com/api/?i=onions,garlic&q=omelet&p=3
public class Receipt {

    private String title;
    private String ingredients;
    private String imageUrl;

    public Receipt() {
    }

    public Receipt(String title, String ingredients, String imageUrl) {
        this.title = title;
        this.ingredients = ingredients;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Receipt[] getAllReceipt(){
        Receipt[] receipts = {
                new Receipt("Vegetable-Pasta Oven Omelet", "tomato, onions, red pepper, garlic, olive oil, zucchini, cream cheese, vermicelli, eggs, parmesan cheese, milk, italian seasoning, salt, black pepper", "https://www.aspicyperspective.com/wp-content/uploads/2011/03/Prosciutto-and-Edamame-Pasta-with-Lemon-Glaze-6.jpg"),
                new Receipt("Roasted Pepper and Bacon Omelet", "eggs, salt, black pepper, butter, black pepper, bacon, onions, garlic, roasted red peppers, oregano, black pepper", ""),
                new Receipt("Broccoli Oven Omelet Recipe", "eggs, broccoli, onions, parmesan cheese, lowfat milk, salt, basil, garlic, tomato, parmesan cheese", ""),
                new Receipt("Eggplant Omelet with Coriander and Caraway", "caraway seed, coriander, eggplant, eggs, garlic, lemon, olive oil, onions, black pepper, salt", ""),
                new Receipt("Eggplant Omelet with Coriander And Caraway", "eggplant, olive oil, onions, garlic, egg, caraway seed, coriander, salt, black pepper, lemon", ""),
                new Receipt("Broccoli and Cheese Omelet", "onions, garlic, chicken broth, cottage cheese, oregano, black pepper, egg substitute, bread, mozzarella cheese, butter", ""),
                new Receipt("Chard And Onion Omelet", "olive oil, onions, leaves, garlic, eggs, parsley, basil, thyme, gruyere cheese, parmesan cheese", ""),
                new Receipt("Picnic Omelet Squares Recipe", "eggs, garlic, parmesan cheese, olive oil, onions, peas, potato, red pepper, salt, tomato, zucchini", ""),
                new Receipt("Spanish Omelet", "vegetable oil, green pepper, onions, water, milk, eggs, black pepper, mushroom, garlic, salt, chili powder", ""),
                new Receipt("Onion and Fresh Herb Omelet with Mixed Greens", "egg substitute, milk, parsley, thyme, salt, black pepper, eggs, flour, nonstick cooking spray, onions, garlic, salad greens, salad greens, red wine vinegar, olive oil, goat cheese, almonds", "")
        };
        return receipts;
    }
}
