# Password Check Algorithm
***
#### Requests a password from the user and checks that it complies with the following conditions:
* 1) Must contain at least 8 characters
* 2) Must not contain a space character
* 3) First letter must be uppercase
* 4) Last character must be '?'

Static boolean methods are used in this algorithm.

#### Here two methods PasswordLength named and IsFirstStringUpperCase named are defined.
```java
    static boolean PasswordLength(String password){

        return password.length() >= 8;
    }
    
    
    static boolean IsFirstStringUpperCase(String password) {

        for (int i = 0; i < password.length(); i++) {

            if (Character.isLetter(password.charAt(i))) {

                return Character.isUpperCase(password.charAt(i));
            }
        }return false;
    }
```