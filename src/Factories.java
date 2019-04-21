public class Factories {


    public static class CarFactory implements MySingleton.Factory {

        @Override
        protected Object clone() throws CloneNotSupportedException {
            System.out.print("Clone created!\n");
            return super.clone();
        }

        int wheels = 0, body = 0, engines = 0, glass = 0;

        void CarFactory() {}

        @Override
        public void create() {
            System.out.print("Created a factory named: Car factory");
        }

        public class Car extends Vehicle{


            private Car(String name) {
                this.name = name;
            }

            protected Car clone() {
                return new Car(this.name);
            }

        }

        public void createWheels() {
            wheels++;
        }

        public void createBody() {
            body++;
        }

        public void createEngine() {
            engines++;
        }

        public void createGlass() {
            glass++;
        }

        public void checkParts(){
            System.out.print("Car Factory - Wheels: " + wheels + " Body: " + body + " Engines: " + engines + " Glass: "+ glass + "\n");
        }

        public Car createCar(String name) {
            if (wheels > 0 && body > 0 && engines > 0 && glass > 0) {
                wheels --;
                body --;
                engines --;
                glass --;
                System.out.print("The clone of car named " + name + " has been created");
                return new Car(name);
            } else {
                System.out.print("The car was not created, check your parts!\n");
                return null;
            }
        }


    }

    public static class BoatFactory implements MySingleton.Factory {

        @Override
        protected Object clone() throws CloneNotSupportedException {
            System.out.print("Clone created!\n");
            return super.clone();
        }

        int body = 0, engines = 0, glass = 0;

        void BoatFactory() {}

        @Override
        public void create() {
            System.out.print("Created a factory named: Boat factory");
        }

        public static class Boat extends Vehicle {


            public Boat(String name) {
                this.name = name;
            }

            protected Boat clone() {
                return new Boat(this.name);
            }

        }

        public void createBody() {
            body++;
        }

        public void createEngine() {
            engines++;
        }

        public void createGlass() {
            glass++;
        }

        public void checkParts(){
            System.out.print("Boat Factory - Body: " + body + " Engines: " + engines + " Glass: "+ glass + "\n");
        }

        public Boat createBoat(String name) {
            if ( body > 0 && engines > 0 && glass > 0) {
                body --;
                engines --;
                glass --;
                System.out.print("The clone of Boat named " + name + " has been created");
                return new Boat(name);
            } else {
                System.out.print("The Boat was not created, check your parts!\n");
                return null;
            }
        }


    }


    public static abstract class ShopFactory {

        private double money = 0.00;

        public void addMoney(Double cash) {
            money += cash;
        }

        public void countMoney() {
            System.out.println(this.getClass().getSimpleName() + ": " + money + "€");
        }

    }


    public static class CarShop extends ShopFactory {


        public void sellCar(CarFactory.Car car) {

            addMoney(car.price);
            System.out.println(car.name + " soled for " + car.price);
            car = null;
        }
    }

    public static class BoatShop extends ShopFactory {

        public void sellBoat(BoatFactory.Boat boat) {

            addMoney(boat.price);
            System.out.println(boat.name + " soled for " + boat.price);
            boat = null;
        }
    }

}
