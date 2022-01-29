
public class Patient extends Person implements Reminder{
    protected String illness;
    protected int id;
    static int Pid=0;

    public Patient(String name, String illness, int nCode) {
        super(name, nCode);
        this.illness = illness;
        this.id = ++Pid;
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
        return "ID: " + this.id +", Name: " + this.name + ", illness: " + this.illness + ", nCode: " + this.nCode + ";";
    }
    public String saveData(){
        return this.id + "," + this.name + "," + this.illness + "," + this.nCode + ";" ;
    }
}
