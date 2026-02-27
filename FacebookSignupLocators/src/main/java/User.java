public class User {

    private String firstName;
    private String surName;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String gender;
    private String phoneNumber;
    private String password;

    public User(String firstName, String surName,
                String birthDay, String birthMonth, String birthYear,
                String gender, String phoneNumber, String password) {

        this.firstName = firstName;
        this.surName = surName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getSurName() {
        return surName;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public String getBirthMonth() {
        return birthMonth;
    }
    public String getBirthYear() {
        return birthYear;
    }
    public String getGender() {
        return gender;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPassword() {
        return password;
    }
}