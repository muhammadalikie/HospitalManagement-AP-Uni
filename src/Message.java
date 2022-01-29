
public class Message implements Reminder{

    protected Doctor doctor;
    protected Patient patient;
    protected String subject;
    protected String date;
    protected String visited;
    protected static int Mid=0;
    protected int id=0;

    public Message(Doctor doctor,Patient patient,String subject,String date){
        this.doctor = doctor;
        this.patient = patient;
        this.subject = subject;
        this.date = date;
        this.id = ++Mid;
    }

//-------------------------------------------------------------------------------
    public void save(){
        MyFile.save(this);
    }
    public void remove(){
        MyFile.remove(this);
    }

    @Override
    public String toString(){
        return "id: " + this.id + ", Doctor: " + this.doctor.name + ", Patient: " + this.patient.name + ", Date: " + this.date + ", Visited: " + this.visited + ";" ;
    }
    public String saveData(){
        return this.id + "," + this.doctor.nCode + "," + this.patient.nCode + "," + this.subject + "," + this.date + "," + this.visited + ";";
    }

}
