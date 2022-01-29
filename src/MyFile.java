import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFile {
//-------------------------------------Add Method--------------------------------
    
    public static void addDoctor(){

        try {

            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);
            String name, specialty;
            int nCode, mCode;
            System.out.println("Enter Doctor name: ");
            name = inputstr.nextLine();

            System.out.println("Enter Doctor specialty: ");
            specialty = inputstr.nextLine();

            System.out.println("Enter Doctor nCode: ");
            nCode = inputint.nextInt();

            System.out.println("Enter Doctor mCode: ");
            mCode = inputint.nextInt();

            Doctor doctor = new Doctor(name, specialty, nCode, mCode);
            doctor.save();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addPatient(){

        try {
            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);
            String name, illness;
            int nCode;
            System.out.println("Enter Patient name: ");
            name = inputstr.nextLine();

            System.out.println("Enter Patient illness: ");
            illness = inputstr.nextLine();

            System.out.println("Enter Patient nCode: ");
            nCode = inputint.nextInt();

            Patient patient = new Patient(name, illness, nCode);
            patient.save();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addVisit(){

        try {

            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);
            String date;
            Doctor doctor;
            Drug drug;
            Patient patient;
            int nCode,id;

            showDoctors();
            System.out.println("Enter Doctor nCode: ");
            nCode = inputint.nextInt();
            doctor = getdoctor(nCode);

            showPatients();
            System.out.println("Enter Patient nCode: ");
            nCode = inputint.nextInt();
            patient = getpatient(nCode);

            showDrugs();
            System.out.println("Enter Drug Id: ");
            id = inputint.nextInt();
            drug = getdrug(id);

            System.out.println("Enter Date (yyyy/mm/dd): ");
            date = inputstr.nextLine();

            Visit visit = new Visit(doctor,patient,drug,date);
            visit.save();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addDrug(){

        try {
            Scanner inputstr = new Scanner(System.in);
//            Scanner inputint = new Scanner(System.in);
            String name, company,illness,description,mDate,eDate;

            System.out.println("Enter Drug name: ");
            name = inputstr.nextLine();

            System.out.println("Enter Drug company: ");
            company = inputstr.nextLine();

            System.out.println("Enter Drug illness: ");
            illness = inputstr.nextLine();

            System.out.println("Enter Drug description: ");
            description = inputstr.nextLine();

            System.out.println("Enter Drug mDate (yyyy/mm/dd): ");
            mDate = inputstr.nextLine();

            System.out.println("Enter Drug eDate (yyyy/mm/dd): ");
            eDate = inputstr.nextLine();

            Drug drug = new Drug(name,company,illness,description,mDate,eDate);
            drug.save();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addMessage(){

        try {
            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);
            Doctor doctor;
            Patient patient;
            String subject,date;
            int nCode;

            showDoctors();
            System.out.println("Enter Doctor nCode: ");
            nCode = inputint.nextInt();
            doctor = getdoctor(nCode);

            showPatients();
            System.out.println("Enter Patient nCode: ");
            nCode = inputint.nextInt();
            patient = getpatient(nCode);

            System.out.println("Enter your Message: ");
            subject = inputstr.nextLine();

            System.out.println("Enter date (yyyy/mm/dd): ");
            date = inputstr.nextLine();

            Message message = new Message(doctor,patient,subject,date);
            message.visited = "false";
            message.save();


        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

//-------------------------------------Remove Method--------------------------------
    public static void removeDoc(){
        try {
            Scanner inputint = new Scanner(System.in);

            showDoctors();
            System.out.println("Enter Doctor nCode: ");
            int nCode = inputint.nextInt();
            Doctor doctor = getdoctor(nCode);

            if (doctor!=null){
                remove(doctor);

                for (Visit visit: visits){
                    if (visit.doctor == doctor){
                        remove(visit);
                    }
                }

                for (Message message: messages){
                    if (message.doctor == doctor){
                        remove(message);
                    }
                }

            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void removePat(){
        try {
            Scanner inputint = new Scanner(System.in);

            showPatients();
            System.out.println("Enter Patient nCode: ");

            int nCode = inputint.nextInt();
            Patient patient = getpatient(nCode);

            if (patient!=null){
                remove(patient);

                for (Visit visit: visits){
                    if (visit.patient == patient){
                        remove(visit);
                    }
                }

                for (Message message: messages){
                    if (message.patient == patient){
                        remove(message);
                    }
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeVis(){
        try {
            Scanner inputint = new Scanner(System.in);
            //Scanner inputstr = new Scanner(System.in);

            Visit visit;
            showVisits();
            System.out.println("Enter Visit id: ");
            int id = inputint.nextInt();
            visit = getvisit(id);

            if (visit!=null){
                remove(visit);
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeDru(){
        try {
            Scanner inputint = new Scanner(System.in);
            Drug drug;
            int id;

            showDrugs();
            System.out.println("Enter Drug id: ");
            id = inputint.nextInt();

            drug = getdrug(id);

            if (drug!=null){
                remove(drug);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void removeMes(){
        try {
            Scanner inputint = new Scanner(System.in);
            Message message;
            int id;

            showMessages();
            System.out.println("Enter Messsage id: ");
            id = inputint.nextInt();

            message = getmessage(id);

            if (message!=null){
                remove(message);
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//-------------------------------------Edit Method--------------------------------

    public static void editDoctor(){

        try {
            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);

            int nCode;
            Doctor doctor;

            showDoctors();
            System.out.println("Enter Doctor nCode: ");
            nCode = inputint.nextInt();
            doctor = getdoctor(nCode);

            System.out.println("Enter Doctor name: ");
            doctor.name = inputstr.nextLine();

            System.out.println("Enter Doctor specialty: ");
            doctor.specialty = inputstr.nextLine();

            System.out.println("Enter Doctor nCode: ");
            doctor.nCode = inputint.nextInt();

            System.out.println("Enter Doctor mCode: ");
            doctor.mCode = inputint.nextInt();

            int index = doctor.id;
            doctors.set(--index,doctor);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editPatient(){

        try {
            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);
            int nCode;
            Patient patient;

            showPatients();
            System.out.println("Enter Patient nCode: ");
            nCode = inputint.nextInt();
            patient = getpatient(nCode);

            System.out.println("Enter Patient name: ");
            patient.name = inputstr.nextLine();

            System.out.println("Enter Patient illness: ");
            patient.illness = inputstr.nextLine();

            System.out.println("Enter Patient nCode: ");
            patient.nCode = inputint.nextInt();

            int index = patient.id;
            patients.set(--index,patient);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editVisit(){

        try {

            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);

            Visit visit;
            int nCode,id;

            showVisits();
            System.out.println("Enter Visit id: ");
            id = inputint.nextInt();
            visit = getvisit(id);


            showDoctors();
            System.out.println("Enter Doctor nCode: ");
            nCode = inputint.nextInt();
            visit.doctor = getdoctor(nCode);

            showPatients();
            System.out.println("Enter Patient nCode: ");
            nCode = inputint.nextInt();
            visit.patient = getpatient(nCode);

            showDrugs();
            System.out.println("Enter Drug Id: ");
            id = inputint.nextInt();
            visit.drug = getdrug(id);

            System.out.println("Enter Date (yyyy/mm/dd): ");
            visit.date = inputstr.nextLine();

            int index = visit.id;
            visits.set(--index,visit);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editDrug(){

        try {
            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);

            Drug drug;

            showDrugs();
            System.out.println("Enter Drug id: ");
            int id = inputint.nextInt();
            drug = getdrug(id);

            System.out.println("Enter Drug name: ");
            drug.name = inputstr.nextLine();

            System.out.println("Enter Drug company: ");
            drug.company = inputstr.nextLine();

            System.out.println("Enter Drug illness: ");
            drug.illness = inputstr.nextLine();

            System.out.println("Enter Drug description: ");
            drug.description = inputstr.nextLine();

            System.out.println("Enter Drug mDate (yyyy/mm/dd): ");
            drug.mDate = inputstr.nextLine();

            System.out.println("Enter Drug eDate (yyyy/mm/dd): ");
            drug.eDate = inputstr.nextLine();

            int index = drug.id;
            drugs.set(--index,drug);

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editMessage(){

        try {
            Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);

            int nCode;
            int id;
            Message message;

            showMessages();
            System.out.println("Enter Message id: ");
            id = inputint.nextInt();
            message = getmessage(id);

            showDoctors();
            System.out.println("Enter Doctor nCode: ");
            nCode = inputint.nextInt();
            message.doctor = getdoctor(nCode);

            showPatients();
            System.out.println("Enter Patient nCode: ");
            nCode = inputint.nextInt();
            message.patient = getpatient(nCode);

            System.out.println("Enter your Message: ");
            message.subject = inputstr.nextLine();

            System.out.println("Enter date (yyyy/mm/dd): ");
            message.date = inputstr.nextLine();

            int index = message.id;
            messages.set(--index,message);


        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

//-------------------------------------See Message Method--------------------------------

    public static void seeMessage(){

        try {
            //Scanner inputstr = new Scanner(System.in);
            Scanner inputint = new Scanner(System.in);
            Message message;
            int id;

            MyFile.showMessages();
            System.out.println("Enter Message id: ");
            id = inputint.nextInt();
            message = MyFile.getmessage(id);
            System.out.println(MessageFormat.format("Message: {0}",message.subject));
            message.visited = "true";
            MyFile.messages.set(--id,message);


        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

//-------------------------------------Paths--------------------------------
    
    private static final String DoctorPath = "D:\\Doctors.txt";
    private static final String PatientPath = "D:\\Patients.txt";
    private static final String VisitPath = "D:\\Visits.txt";
    private static final String DrugPath = "D:\\Drugs.txt";
    private static final String MessagePath = "D:\\Messages.txt";
    
//-------------------------------------Arrays--------------------------------
    
    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static ArrayList<Patient> patients = new ArrayList<>();
    public static ArrayList<Visit> visits = new ArrayList<>();
    public static ArrayList<Drug> drugs = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();

//-------------------------------------Saves Method-----------------------------

    public static void save(Doctor doctor){

        doctors.add(doctor);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DoctorPath,true))){

            bufferedWriter.write(doctor.saveData());
            bufferedWriter.newLine();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public static void save(Patient patient){

        patients.add(patient);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PatientPath,true))){

            bufferedWriter.write(patient.saveData());
            bufferedWriter.newLine();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public static void save(Visit visit){

        visits.add(visit);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(VisitPath,true))){

            bufferedWriter.write(visit.saveData());
            bufferedWriter.newLine();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void save(Drug drug){

        drugs.add(drug);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DrugPath,true))){

            bufferedWriter.write(drug.saveData());
            bufferedWriter.newLine();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void save(Message message){

        messages.add(message);

        try (BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(MessagePath,true))){

            bufferedWriter.write(message.saveData());
            bufferedWriter.newLine();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

//-------------------------------------Removes from Arrays Method--------------------------------
    
    public static void remove(Doctor doctor){
        doctors.remove(doctor);
    }
    public static void remove(Patient patient){
        patients.remove(patient);
    }
    public static void remove(Visit visit){
        visits.remove(visit);
    }
    public static void remove(Drug drug){
        drugs.remove(drug);
    }
    public static void remove(Message message){
        messages.remove(message);
    }

//-------------------------------------Shows Method--------------------------------
    
    public static void showDoctors() throws Exception{
        int count=0;
        for (Doctor doctor: MyFile.doctors){
            System.out.println(doctor.toString());
            count++;
        }
        if (count==0){
            throw new Exception("No doctor registered");
        }
    }
    public static void showPatients() throws Exception{
        int count=0;
        for (Patient patient: MyFile.patients){
            System.out.println(patient.toString());
            count++;
        }
        if (count==0){
            throw new Exception("No Patient registered");
        }
    }
    public static void showVisits() throws Exception{
        int count=0;
        for (Visit visit: MyFile.visits){
            System.out.println(visit.toString());
            count++;
        }
        if (count==0){
            throw new Exception("No Visit registered");
        }
    }
    public static void showDrugs() throws Exception{
        int count=0;
        for (Drug drug: MyFile.drugs){
            System.out.println(drug.toString());
            count++;
        }
        if (count==0){
            throw new Exception("No Drug registered");
        }
    }
    public static void showMessages() throws Exception{
        int count=0;
        for (Message message: MyFile.messages){
            System.out.println(message.toString());
            count++;
        }
        if (count==0){
            throw new Exception("No Message registered");
        }
    }
    
//-------------------------------------Gets Method--------------------------------
    
    public static Doctor getdoctor(int nCode){
        Doctor doctor= null;
        for (Doctor d: MyFile.doctors){
            if (d.nCode == nCode){
                doctor = d;
                break;
            }
        }
        return doctor;
    }
    public static Patient getpatient(int nCode){
        Patient patient= null;
        for (Patient p: MyFile.patients){
            if (p.nCode == nCode){
                patient = p;
                break;
            }
        }
        return patient;
    }
    public static Visit getvisit(int id){
        Visit visit= null;
        for (Visit v: MyFile.visits){
            if (v.id == id){
                visit = v;
                break;
            }
        }
        return visit;
    }
    public static Drug getdrug(int id){
        Drug drug= null;
        for (Drug d: MyFile.drugs){
            if (d.id == id){
                drug = d;
                break;
            }
        }
        return drug;
    }
    public static Message getmessage(int id){
        Message message = null;
        for (Message m: MyFile.messages){
            if (m.id == id){
                message = m;
                break;
            }
        }
        return message;
    }
    
//-------------------------------------File loads Method--------------------------------

    public static void doctorLoad(){
        Doctor doctor;

        int mCode,nCode,id;
        String name,specialty;

        String[] readRow;
        String[] readCol;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DoctorPath))){

            for (String line ; (line = bufferedReader.readLine()) != null; ){
                readRow = line.split(";");

                for (String Col : readRow){
                    readCol = Col.split(",");
                    id = Integer.parseInt(readCol[0]);
                    name = readCol[1];
                    specialty = readCol[2];
                    nCode = Integer.parseInt(readCol[3]);
                    mCode = Integer.parseInt(readCol[4]);

                    doctor = new Doctor(name,specialty,nCode,mCode);
                    doctor.id = id;
                    doctors.add(doctor);
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void patientLoad(){
        Patient patient;

        int nCode,id;
        String name,illness;

        String[] readRow;
        String[] readCol;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PatientPath))){

            for (String line ; (line = bufferedReader.readLine()) != null; ){
                readRow = line.split(";");

                for (String Col : readRow){
                    readCol = Col.split(",");
                    id = Integer.parseInt(readCol[0]);
                    name = readCol[1];
                    illness = readCol[2];
                    nCode = Integer.parseInt(readCol[3]);

                    patient = new Patient(name,illness,nCode);
                    patient.id = id;
                    patients.add(patient);
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void visitLoad(){
        Visit visit;
        Doctor doctor;
        Patient patient;
        Drug drug;
        String date;
        int id;

        String[] readRow;
        String[] readCol;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(VisitPath))){

            for (String line ; (line = bufferedReader.readLine()) != null ; ){

                readRow = line.split(";");

                for (String Col: readRow){
                    readCol = Col.split(",");

                    id = Integer.parseInt(readCol[0]);
                    doctor = getdoctor(Integer.parseInt(readCol[1]));
                    patient = getpatient(Integer.parseInt(readCol[2]));
                    drug = getdrug(Integer.parseInt(readCol[3]));
                    date = readCol[4];

                    visit = new Visit(doctor,patient,drug,date);
                    visit.id = id;
                    visits.add(visit);
                }

            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void drugLoad(){
        Drug drug;

        String name,company,illness,description,mDate,eDate;
        int id;

        String[] readRow;
        String[] readCol;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DrugPath))){

            for (String line ; (line = bufferedReader.readLine()) != null ; ){
                readRow = line.split(";");

                for (String Col : readRow){
                    readCol = Col.split(",");

                    id = Integer.parseInt(readCol[0]);
                    name = readCol[1];
                    company = readCol[2];
                    illness = readCol[3];
                    description = readCol[4];
                    mDate = readCol[5];
                    eDate = readCol[6];

                    drug = new Drug(name,company,illness,description,mDate,eDate);
                    drug.id = id;

                    drugs.add(drug);

                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void messageLoad(){
        Message message;

        Doctor doctor;
        Patient patient;
        String subject,date;
        int id;
        String visited;

        String[] readRow;
        String[] readCol;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(MessagePath))){

            for (String line ; (line = bufferedReader.readLine()) != null ;){
                readRow = line.split(";");

                for (String Col: readRow){
                    readCol = Col.split(",");

                    id = Integer.parseInt(readCol[0]);
                    doctor = getdoctor(Integer.parseInt(readCol[1]));
                    patient = getpatient(Integer.parseInt(readCol[2]));
                    subject = readCol[3];
                    date = readCol[4];
                    visited = readCol[5];

                    message = new Message(doctor,patient,subject,date);

                    message.id = id;
                    message.visited = visited ;

                    messages.add(message);
                }
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

//-------------------------------------Update Method--------------------------------
   
    public static void update(){

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DoctorPath,false))){
            for (Doctor doctor:doctors){
                    bufferedWriter.write(doctor.saveData());
                    bufferedWriter.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PatientPath,false))){
            for (Patient patient:patients){
                bufferedWriter.write(patient.saveData());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DrugPath,false))){ 
            for (Drug drug:drugs){
                bufferedWriter.write(drug.saveData());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(VisitPath,false))){ 
            for (Visit visit:visits){
                bufferedWriter.write(visit.saveData());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
                System.out.println(e.getMessage());
        }


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(MessagePath,false))){
            for (Message message:messages){
                bufferedWriter.write(message.saveData());
                bufferedWriter.newLine();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    
    

}
