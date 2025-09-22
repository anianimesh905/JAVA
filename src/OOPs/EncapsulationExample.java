package src.OOPs;

// Class with encapsulation
class Animal_encap {
    // Private fields (data is hidden from outside classes)
    private String name;
    private int age;

    // Public getter and setter for 'name'
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Public getter and setter for 'age'
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        // Example of data validation
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive!");
        }
    }

    // Method (behavior)
    public void makeSound() {
        System.out.println(name + " makes a sound!");
    }
}

// Main class to run program
public class EncapsulationExample {
    public static void main(String[] args) {
        Animal_encap dog = new Animal_encap();

        // Setting values using setters
        dog.setName("Dog");
        dog.setAge(3);

        // Accessing values using getters
        System.out.println("Name: " + dog.getName());  // Output: Name: Dog
        System.out.println("Age: " + dog.getAge());    // Output: Age: 3

        // Behavior
        dog.makeSound();   // Output: Dog makes a sound!
    }
}