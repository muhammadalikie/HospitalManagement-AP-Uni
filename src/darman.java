
import java.util.Scanner;

public class darman {

    public static void main(String[] args){
        MyFile.doctorLoad();
        MyFile.patientLoad();
        MyFile.drugLoad();
        MyFile.visitLoad();
        MyFile.messageLoad();
        try {
            while (true) {
                System.out.println("\n\t************ Menu ************");
                System.out.println("1: Add Doctor");
                System.out.println("2: Add Patient");
                System.out.println("3: Add Drug");
                System.out.println("4: Add Visit");
                System.out.println("5: Add Message");

                System.out.println("\n6: Remove Doctor");
                System.out.println("7: Remove Patient");
                System.out.println("8: Remove Drug");
                System.out.println("9: Remove Visit");
                System.out.println("10: Remove Message");

                System.out.println("\n11: Edit Doctor");
                System.out.println("12: Edit Patient");
                System.out.println("13: Edit Drug");
                System.out.println("14: Edit Visit");
                System.out.println("15: Edit Message");

                System.out.println("\n16: See Message");

                System.out.println("\n17: Show Doctor");
                System.out.println("18: Show Patient");
                System.out.println("19: Show Drug");
                System.out.println("20: Show Visit");
                System.out.println("21: Show Message");

                System.out.println("\n22: Save & Exit");
                System.out.println("\n\t************ Enter the desired number ************");
                Scanner inputint = new Scanner(System.in);
                int choice = inputint.nextInt();
                switch (choice) {
                    case 1: MyFile.addDoctor();break;
                    case 2: MyFile.addPatient();break;
                    case 3: MyFile.addDrug();break;
                    case 4: MyFile.addVisit();break;
                    case 5: MyFile.addMessage();break;

                    case 6: MyFile.removeDoc();break;
                    case 7: MyFile.removePat();break;
                    case 8: MyFile.removeDru();break;
                    case 9: MyFile.removeVis();break;
                    case 10: MyFile.removeMes();break;

                    case 11: MyFile.editDoctor();break;
                    case 12: MyFile.editPatient();break;
                    case 13: MyFile.editDrug();break;
                    case 14: MyFile.editVisit();break;
                    case 15: MyFile.editMessage();break;

                    case 16: MyFile.seeMessage();break;

                    case 17: MyFile.showDoctors();break;
                    case 18: MyFile.showPatients();break;
                    case 19: MyFile.showDrugs();break;
                    case 20: MyFile.showVisits();break;
                    case 21: MyFile.showMessages();break;

                    case 22: MyFile.update();System.exit(0);break;
                    default: System.out.println("Input is incorrect ");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}