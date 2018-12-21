
public class DecoratorPattern {
    public static void main(String[] args) {
        final SportCarDecorator sportCarDecorator = new SportCarDecorator(new BasicCar());
        sportCarDecorator.assemble();
        final LuxuryCarDecorator luxuryCarDecorator = new LuxuryCarDecorator(new SportCarDecorator(new BasicCar()));
        luxuryCarDecorator.assemble();
    }
}

interface Car{
    void assemble();
}

class BasicCar implements  Car{
    @Override
    public void assemble() {
        System.out.println("basic car assemble");
    }
}


class CarDecorator implements Car {

    private Car car;
    public CarDecorator(Car c) {
        this.car = c;
        System.out.println("car decorator constructor");
    }

    @Override
    public void assemble() {
        this.car.assemble();
        System.out.println("assembling in car decorator");
    }
}
class SportCarDecorator extends CarDecorator {

    public SportCarDecorator(Car c) {
        super(c);
        System.out.println("sport  car decorator constructor");
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("assembling in sport car decorator");
    }
}

class LuxuryCarDecorator extends CarDecorator {

    public LuxuryCarDecorator(Car c) {
        super(c);
        System.out.println("luxury  car decorator constructor");
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("assembling in luxury car decorator");
    }
}
