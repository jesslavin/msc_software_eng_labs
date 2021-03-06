import java.util.ArrayList;
import java.util.Iterator;

// A Boss object can be created without any workers
public class Boss extends Person{

    // **************** QUERY ****************
    // DOESN'T USE A PRINTSTREAM IN PRINT METHOD
    // **************** QUERY ****************

    // Constructor
    private ArrayList<Worker> workers = new ArrayList<>();
    private Iterator<Worker> workerSearch;
    private Worker currentWorker;

    // Get boss name and dob
    public Boss(String name, Date dob){
        super(name, dob);
    }

    // Method to add workers
    public void add_worker (Worker toAdd){
        this.workers.add(toAdd);
        toAdd.new_boss(this);
    }

    // Method to remove workers
    public void sub_worker (Worker toRemove){
        this.workers.remove(toRemove);
        toRemove.new_boss(null);
    }

    // The worker objects associated with a Boss can be found by two methods

    // Worker next() - returns next Worker or null
    public Worker next(){
        this.currentWorker = this.workerSearch.next();
        return currentWorker;
    }

    // void reset() - back to start of Workers
    public void reset(){
        workerSearch = workers.iterator();
     }

    // It will also have a print(PrintStream) method
    public String print(){
        this.workerSearch = this.workers.iterator();
        String boss = super.print();
        return boss + String.format("\nWorkers: " + this.listWorkers());

    }

    // Method to list workers
    public String listWorkers(){
        String workerNames = "";
        while(workerSearch.hasNext()){
            workerNames += "\n"+workerSearch.next().getName();
        }
        while(workerNames == ""){
            workerNames = "\nnull";
        }
        return workerNames;
    }

}