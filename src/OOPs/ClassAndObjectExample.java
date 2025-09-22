package src.OOPs;

// Class definition
class Animal_class_object {
    // Fields (attributes)
    String name;
    int age;

    // Method (behavior)
    void makeSound() {
        System.out.println(name + " makes a sound!");
    }
}

// Main class to run program
public class ClassAndObjectExample {
    public static void main(String[] args) {
        // Creating objects (instances of Animal class)
        Animal_class_object dog = new Animal_class_object();
        dog.name = "Dog";
        dog.age = 3;

        Animal_class_object cat = new Animal_class_object();
        cat.name = "Cat";
        cat.age = 2;

        // Calling method
        dog.makeSound();   // Output: Dog makes a sound!
        cat.makeSound();   // Output: Cat makes a sound!
    }
}

/*

Class: 

 */