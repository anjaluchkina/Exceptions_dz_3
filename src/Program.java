public class Program {
    public static void main(String[] args) throws Exception {

        User_data user = new User_data();
        user.enterData();
        user.parseSurname();
        user.parseFirstName();
        user.parseLastName();
        user.parseBirthday();
        user.parsePhone();
        user.parseGender();
        user.writeFile();
    }
}