import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyApp { 
 
        public static class User { 
            private final int id; 
            private final String name; 
            private final int age; 
 
            public User(int id, String name, int age) { 
                this.id = id; 
                this.name = name; 
                this.age = age; 
            } 
 
            public int getId() { 
                return id; 
            } 
 
            public String getName() { 
                return name; 
            } 
 
            public int getAge() { 
                return age; 
            } 
 
        } 
 
        public static void main(String[] args) { 
            List<User> users = List.of( 
                    new User(1, "Alex", 13), 
                    new User(2, "Rachel", 21), 
                    new User(3, "John", 18), 
                    new User(4, "Reem", 56), 
                    new User(5, "Layla", 24), 
                    new User(6, "Krishna", 35) 
            ); 
 

 
 
            // Map user id to user name 
            // 1 : Alex, 2 : Rachel, etc 
            Map<Integer, String> idsNames = users.stream().collect(Collectors.toMap(User::getId,User::getName)); 
 
            // Find maximum age 
            int maxAge = users.stream().map(o -> o.getAge()).max((o1, o2) -> o1-o2).orElse(0); 
 
 
            System.out.println(idsNames); 
 
            System.out.println(maxAge); 
        } 
} 
