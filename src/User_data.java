
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User_data {
        private String user;
        private String[] userDataParts;
        private String surname;
        private String firstName;
        private String lastName;
        private String  Birthday;
        private int phone;
        private char gender;

        Scanner scanner = new Scanner(System.in);


        void enterData() throws Exception {

            System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
            user = scanner.nextLine();
            userDataParts = user.split(" ");
            if (userDataParts.length < 6) {
                throw new LengthDataExceptions("Введены не все данные");
            }
            if (userDataParts.length > 6) {
                throw new LengthDataExceptions("Введено больше данных");
            }
        }

        public void parseSurname() throws Exception  {
            surname = userDataParts[0];
            Pattern alphaBet = Pattern.compile("^[а-яА-Я]*$");
            boolean lastNameValidator = alphaBet.matcher(surname).find();
            if (!lastNameValidator) {
                throw new SurnameNameExceptions("Фамимлия написана не корректно");
            }
        }

        public void parseFirstName () throws Exception {
            firstName = userDataParts[1];
            Pattern alphaBet = Pattern.compile("^[а-яА-Я]*$");
            boolean firstNameValidator = alphaBet.matcher(firstName).find();
            if (!firstNameValidator) {
                throw new FirstNameExceptions("Имя написано не корректно");
            }
        }

        public void parseLastName () throws Exception {
            lastName = userDataParts[2];
            Pattern alphaBet = Pattern.compile("^[а-яА-Я]*$");
            boolean lastNameValidator = alphaBet.matcher(lastName).find();
            if (!lastNameValidator) {
                throw new LastNameExceptions("Отчество написана не корректно");
            }
        }

        public void parseBirthday () throws Exception {
            Birthday = userDataParts[3];
            Pattern DATE_FORMAT_PATTERN = Pattern.compile("^\\d{2}.\\d{2}.\\d{4}$");
            boolean dateFormatValidator = DATE_FORMAT_PATTERN.matcher(Birthday).matches();

            if (!dateFormatValidator) {
                throw new BirthdayExceptions("Дата рождения введена в неверном формате");
            }
        }


        public void parsePhone () throws Exception {

            try {
                phone = Integer.parseInt(userDataParts[4]);
            } catch (NumberFormatException e) {
                throw new PhoneExceptions("Не корректно введенный номер телефона");
            }
        }


        public void parseGender () throws Exception {

            gender = userDataParts[5].charAt(0);
            if (gender != 'm' & gender != 'f') {

                throw new Exception("Не корректно введенный пол.");
            }
        }

        public void writeFile () {
            try (FileWriter writer = new FileWriter(surname + ".txt", true)) {
                writer.write("<" + surname + ">" + "<" + firstName + ">" + "<" + surname + ">" +
                        "<" + Birthday + ">" + "<" + phone + ">" + "<" + gender + ">");
                writer.write("\n");
                writer.flush();
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл" + e.getMessage());
                e.printStackTrace();
            }
        }

    }