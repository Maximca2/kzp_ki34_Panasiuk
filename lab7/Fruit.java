package lab7;
/**
 * Class Fruit
 * @version 1.0
 */
public abstract class Fruit {
    protected int weight;
    protected String name;
    /**
     * Constructor
     * @param weight Fruit weight
     * @param name Fruit name
     */
    public Fruit(int weight, String name)
    {
        this.name = name;
        this.weight = weight;
    }
    /**
     * Methods returns Fruit weight
     */
    public int getWeight() {
        return weight;
    }
    /**
     * Methods returns Fruit name
     */
    public String getName() { return name; }
    public void printData()
    {
        System.out.println("Name:" + name);
        System.out.println("Weight:" + weight);
    }
}
