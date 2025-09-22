package src.OOPs;

// Abstract class Animal (cannot be instantiated directly)
abstract class Animal_abs {
    String name;

    // Abstract method (must be implemented by subclasses)
    abstract void makeSound();

    // Normal method (common for all animals)
    void sleep() {
        System.out.println(name + " is sleeping...");
    }
}

// Dog class extends Animal
class Dog extends Animal_abs {
    Dog(String name) {
        this.name = name;
    }

    // Implementing abstract method
    @Override
    void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }
}

// Cat class extends Animal
class Cat extends Animal_abs {
    Cat(String name) {
        this.name = name;
    }

    // Implementing abstract method
    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// Main class
public class AbstractionExample {
    public static void main(String[] args) {
        // We cannot do: Animal a = new Animal(); ❌ (abstract class can't be instantiated)

        Animal_abs dog = new Dog("Dog");
        Animal_abs cat = new Cat("Cat");

        // Using abstraction (common interface but different implementations)
        dog.makeSound();  // Output: Dog says: Woof Woof!
        cat.makeSound();  // Output: Cat says: Meow!

        dog.sleep();      // Output: Dog is sleeping...
        cat.sleep();      // Output: Cat is sleeping...
    }
}
