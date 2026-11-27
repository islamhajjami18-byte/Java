package a14_08_tax2;

public class Tax {

    public static final float TAX = 21.0f;

    public static float tax(float price) {
        float tax = price * (TAX / 100);
        return tax;
    }

    public static float priceWithTax(float price){
        float newPrice = price + tax(price);
        return newPrice;
    }
    public static float getTaxFromPrice(float price){
        float taxFromPrice = price * TAX / 121;
        return  taxFromPrice;
    }
}
