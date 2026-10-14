public class User {
    private final String firstName;
    private final String lastName;
    private final int age;

    public User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;

    }

    // Getters (No Setters to preserve immutability)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        // Fluent setter for optional age
        public Builder age(int age) {
            this.age = age;
            return this; // Returns the builder instance for method chaining
        }

        // The final build method that executes instantiation
        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user = new User.Builder("John", "Doe") // Mandatory fields
                        .age(28)                         // Optional
                        .build();

        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        System.out.println(user.getAge());
    }
    
}
