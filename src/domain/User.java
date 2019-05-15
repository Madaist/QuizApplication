package domain;

public class User {
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String userName;
    private String password;
    private int ID;

    public User(){}

    public int getID(){return ID;}

    public void setID(int ID){this.ID = ID;}

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String lastName, String firstName, String phoneNumber, String userName, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }
}

