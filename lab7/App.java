package lab7;

/**
 * Class App
 * @version 1.0
 */
public class App {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Basket basket = new Basket();

        basket.add(new Orange(500,  "Orange1"));
        basket.add(new Apple(200,  "Apple1"));
        basket.add(new Orange(700,  "Orange2"));
        basket.add(new Apple(250, "Apple2"));
        basket.add(new Orange(900, "Orange3"));
        basket.add(new Apple(290,  "Apple3"));

        System.out.println(basket.get(0).getName());
        System.out.println(basket.get(1).getName());
        System.out.println(basket.get(2).getName());
        System.out.println(basket.get(3).getName());

        System.out.println(basket.getFruitWithMaxWeight().getName());
        System.out.println(basket.getTotalWeight());

    }
}
