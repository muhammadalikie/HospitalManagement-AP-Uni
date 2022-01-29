
public class Drug implements Reminder{
    protected String name;
    protected String company;
    protected String illness;
    protected String description;
    protected String mDate;
    protected String eDate;
    protected static int Did=0;
    protected  int id=0;

    public Drug(String name,String company,String illness,String description,String mDate,String eDate){
        this.name = name;
        this.company = company;
        this.illness = illness;
        this.description = description;
        this.mDate = mDate;
        this.eDate = eDate;
        this.id = ++Did;
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
        return "ID: " + this.id + ", Name: " + this.name + ", Company: " + this.company +
                ", illness: " + this.illness + ", Description: " + this.description  +
                ", mDate: " + this.mDate + ", eDate: " + this.eDate + ";";
    }
    public String saveData(){
        return this.id + "," + this.name + "," + this.company + "," + this.illness + "," + this.description + "," + this.mDate + "," + this.eDate + ";";
    }
}
