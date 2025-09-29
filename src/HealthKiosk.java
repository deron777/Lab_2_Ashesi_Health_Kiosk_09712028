import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        System.out.println("Welcome to the Ashesi Health Kiosk");
        char serviceCode;  // declaring a variable for the service code
        boolean triageSelected = false;
        boolean option1 = false;
        boolean option2 = false;
        boolean option3 = false;
        double weight;
        double height;
        double bmi;
        double roundedBmi = 0;
        String desk = "";
        int option;
        int roundedTablets = 0;
        double roundedSine = 0;
        String code;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Service Code ");
        serviceCode = sc.next().charAt(0);


        // Task 1
        switch (serviceCode) {
            case 'P':
            case 'p':
                System.out.println("Go to : Pharmacy Desk");
                desk = "Pharmacy";
                break;
            case 'L':
            case 'l':
                System.out.println("Go to : Lab Desk");
                desk = "Laboratory";
                break;
            case 'C':
            case 'c':
                System.out.println("Go to : Counselling");
                desk = "Counselling";
                break;
            case 'T':
            case 't':
                System.out.println("Go to : Triage Desk");
                triageSelected = true;
                desk = "Triage";
                break;
            default:
                System.out.println("Invalid Service Code");
                break;
        }
        // Task 2
        if (triageSelected) {
            System.out.println("---- Triage Desk -----");
            System.out.println("---- Pick an Option ----");
            System.out.println("1. BMI Calculator");
            System.out.println("2. Dosage Calculator");
            System.out.println("3. Angle Calculator");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    option1 = true;
                    String weightCategory;
                    System.out.println("Enter your weight (in kg)");
                    weight = sc.nextDouble();
                    System.out.println("Enter your height (in meters)");
                    height = sc.nextDouble();
                    bmi = (weight / Math.pow(height, 2));
                    roundedBmi = Math.round(bmi * 10) / 10.0;

                    if (roundedBmi < 18.5) {
                        weightCategory = "Underweight";
                    } else if (roundedBmi >= 18.5 && roundedBmi <= 24.9) {
                        weightCategory = "Normal";
                    } else if (roundedBmi >= 25.0 && roundedBmi <= 29.9) {
                        weightCategory = "Overweight";
                    } else {
                        weightCategory = "Obese";
                    }
                    System.out.println("Weight (kg) : " + weight);
                    System.out.println("Height(m) : " + height);
                    System.out.println("BMI : " + roundedBmi + " Category : " + weightCategory);
                    break;

                case 2:
                    option2 = true;
                    double dosage;
                    double dividedDosage;
                    double tablets;
                    System.out.println("Enter the required dosage (in mg)");
                    dosage = sc.nextDouble();
                    dividedDosage = dosage / 250;
                    tablets = Math.ceil(dividedDosage);
                    roundedTablets = (int) tablets;
                    System.out.println("Number of tablets to be given is : " + roundedTablets);
                    break;

                case 3:
                    option3 = true;
                    double angleInDegrees;
                    double angleInRadians;
                    double sineOfAngle;
                    double cosOfAngle;
                    double roundedCos;
                    System.out.println("Enter an angle in degrees : ");
                    angleInDegrees = sc.nextDouble();
                    angleInRadians = Math.toRadians(angleInDegrees);
                    sineOfAngle = Math.sin(angleInRadians);
                    cosOfAngle = Math.cos(angleInRadians);
                    roundedSine = Math.round(sineOfAngle * 1000.0) / 1000.0;
                    roundedCos = Math.round(cosOfAngle * 1000.0) / 1000.0;
                    System.out.println("Sine of Angle is : " + roundedSine);
                    System.out.println("Cos of Angle is : " + roundedCos);

                default:
                    System.out.println("Invalid Option selected");
                    break;
            }
        }


        //Task 3
        //Generating the random id
        char idLetter = (char) ('A' + (int) (Math.random() * 26));
        int num1 = (int) (Math.random() * 7) + 3;
        int num2 = (int) (Math.random() * 7) + 3;
        int num3 = (int) (Math.random() * 7) + 3;
        int num4 = (int) (Math.random() * 7) + 3;
        String id = "" + idLetter + num1 + num2 + num3 + num4;
        System.out.println("Id is : " + id);


        // Checking ID
        if (id.length() != 5) {
            System.out.println("Invalid : Id must be 5 characters long!");
        } else if (!Character.isLetter(id.charAt(0))) {
            System.out.println("Invalid : First character must be a letter");
        } else if (!Character.isDigit(id.charAt(1)) || !Character.isDigit(id.charAt(2)) || !Character.isDigit(id.charAt(3)) || !Character.isDigit(id.charAt(4))) {
            System.out.println("Invalid : Last 4 characters must be digits");
        } else {
            System.out.println("ID ok");
        }

        //Task 4
        // Generating the secure code
        int bmiCode = (int) (Math.ceil(roundedBmi));
        String name;
        char baseCode;
        System.out.println("Please enter your name");
        name = sc.next().toUpperCase();
        baseCode = (char) ('A' + (name.charAt(0) - 'A' + 2) % 26);
        if (option1) {
            code = "" + baseCode + id.charAt(3) + id.charAt(4) + "-" + bmiCode;
            System.out.println(" < " + code + " > ");
        } else if (option2) {
            code = "" + baseCode + id.charAt(3) + id.charAt(4) + "-" + roundedTablets;
            System.out.println(" < " + code + " > ");
        } else if (option3) {
            code = "" + baseCode + id.charAt(3) + id.charAt(4) + "-" + roundedSine;
            System.out.println(" < " + code + " > ");
        } else {
            code = "" + baseCode + id.charAt(3) + id.charAt(4) + "-" + "00";
            System.out.println(" < " + code + " > ");


            //Task 5
            System.out.println("Summary : " + desk + " | ID =  " + id + " | BMI =  " + roundedBmi + " | Code = " + code);


        }
    }
}