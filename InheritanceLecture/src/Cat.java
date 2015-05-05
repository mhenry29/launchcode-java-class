/**
 * Created by dshook on 4/30/15.
 */
public class Cat extends Animal {

    private String meow;

    public Cat(String food, String meow) {
        super("Cat", food);
        this.meow = meow;
    }

    public void meow() {
        System.out.println(this.meow);
    }

    public void eat() {
        System.out.println("Cat is eating");
    }

    public static void main(String[] args) {
        Animal[] zoo = new Animal[2];
        Animal a = new Cat("fish", "ROWR");
        Animal d = new Dog("woof");
        zoo[0] = a;
        zoo[1] = d;
        for(int i = 0; i < zoo.length; i++) {
            zoo[i].eat();
        }
    }
}
