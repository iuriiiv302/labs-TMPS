public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Factories.CarFactory carFactory = new Factories.CarFactory();

        Factories.CarFactory.Car honda = carFactory.createCar("Honda");
        carFactory.checkParts();

        for(int i=0;i<10;i++){
            carFactory.createEngine();
            carFactory.createGlass();
            carFactory.createBody();
            carFactory.createWheels();
        }

        carFactory.checkParts();

        honda = carFactory.createCar("Honda");
        System.out.println(honda.name);

        carFactory.checkParts();

        Factories.CarFactory copyOfCarFactory = (Factories.CarFactory) carFactory.clone();
        System.out.print("\nCopy of Car Factory:\n");
        copyOfCarFactory.checkParts();

        Factories.CarFactory.Car copyOfHonda = honda.clone();

        System.out.println(copyOfHonda.name);

        honda.price = 6000.00;
        copyOfHonda.price = 6100.00;

        Factories.BoatFactory boatFactory = new Factories.BoatFactory();

        for(int i=0;i<5;i++){
            boatFactory.createEngine();
            boatFactory.createBody();
            boatFactory.createGlass();
        }

        boatFactory.checkParts();

        Factories.BoatFactory.Boat boat1 = new Factories.BoatFactory.Boat("BoatN1");

        System.out.println(boat1.name);
        boat1.price = 33333.333;
        System.out.println(boat1.price);

        Factories.CarShop carShop = new Factories.CarShop();
        carShop.countMoney();

        carShop.sellCar(honda);
        carShop.countMoney();

        System.out.println();

        Factories.BoatShop boatShop = new Factories.BoatShop();
        boatShop.countMoney();

        boatShop.sellBoat(boat1);
        boatShop.countMoney();

    }
}
