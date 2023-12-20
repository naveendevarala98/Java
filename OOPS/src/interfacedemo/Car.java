package interfacedemo;

//start & stop present both in engine & media
public class Car implements Engine,Media{
    @Override
    public void start() {
        System.out.println("start car");
    }

    @Override
    public void stop() {
        System.out.println("start car");
    }

    @Override
    public void acc() {
        System.out.println("start car");
    }
}
