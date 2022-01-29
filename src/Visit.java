
public class Visit implements Reminder{
    protected Doctor doctor;
    protected Patient patient;
    protected Drug drug;
    protected String date;
    protected static int Vid=0;
    protected int id;

    public Visit(Doctor doctor,Patient patient , Drug drug ,String date){
        this.doctor = doctor;
        this.patient = patient;
        this.drug = drug;
        this.date = date;
        this.id = ++Vid;
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
        return "ID: " + this.id + ", Doctor: " + this.doctor.name + ", Patient: " + this.patient.name + ";" ;
    }
    public String saveData(){
        return this.id + "," + this.doctor.nCode + "," + this.patient.nCode + "," + this.drug.id + "," + this.date + ";";
    }
}
