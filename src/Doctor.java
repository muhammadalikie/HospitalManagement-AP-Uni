
public class Doctor extends Person implements Reminder{

    protected int mCode;
    protected String specialty;
    static int Doid = 0;
    protected int id;

    public Doctor(String name, String specialty, int nCode, int mCode){
        super(name,nCode);
        this.mCode = mCode;
        this.specialty = specialty;
        this.id = ++Doid;

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
        return "ID: " + this.id +", Name: " + this.name + ", Specialty: " + this.specialty + ", mCode: " + this.mCode + ", nCode: " + this.nCode + ";" ;
    }
    public String saveData(){
        return this.id + "," +this.name + "," + this.specialty + "," + this.nCode + "," + this.mCode + ";" ;
    }

}
