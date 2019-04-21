
public class MySingleton {

    public static interface Factory extends Cloneable {

        class Vehicle {
            Double price = 0.00;
            String name;
        }

        void create();

    }

    private MySingleton(){}

    //Here singleton is created by the constructor, and this exemplar of the class will be available at whole project
    public static final MySingleton pointer = new MySingleton();
}