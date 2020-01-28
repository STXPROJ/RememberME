package com.example.user.remember_me.ModeloVO;
/* Esta clase se llama VO (Value Object) en esta clase se almacenan los valores temporales
de las tareas, estas se comunican directamente con la clase DAO
 */
public class TaskVO {
    private int midTask;
    private String mname;
    private String mdescription;
    private boolean mIsCancelled;
    private String mtaskDate;
    private String mnextDate;
    private String mstartTime;
    private String mendTime;
    private boolean misDone;
    private RecurrenceVO mRecurrence;

    public TaskVO(int id,String name,String fecha, boolean isDone){
        this.midTask = id;
        this.mname = name;
        this.mtaskDate = fecha;
        this.misDone = isDone;
    }
    public String getstartTime() {
        return mstartTime;
    }

    public void setstartTime(String startTime) {
        this.mstartTime = startTime;
    }

    public String getendTime() {
        return mendTime;
    }

    public void setendTime(String endTime) {
        this.mendTime = endTime;
    }


    /* Metodos Getter y Setter de la clase Task */
    public int getidTask() {
        return midTask;
    }

    public void setidTask(int midTask) {
        this.midTask = midTask;
    }

    public String getname() {
        return mname;
    }

    public void setname(String mname) {
        this.mname = mname;
    }

    public String getdescription() {
        return mdescription;
    }

    public void setdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public boolean getIsCancelled() {
        return mIsCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        mIsCancelled = isCancelled;
    }

    public String gettaskDate() {
        return mtaskDate;
    }

    public void settaskDate(String mtaskDate) {
        this.mtaskDate = mtaskDate;
    }

    public String getnextDate() {
        return mnextDate;
    }

    public void setnextDate(String mnextDate) {
        this.mnextDate = mnextDate;
    }

    public boolean getisDone() {
        return misDone;
    }

    public void setisDone(boolean misDone) {
        this.misDone = misDone;
    }

    public RecurrenceVO getRecurrence() {
        return mRecurrence;
    }

    public void setRecurrence(RecurrenceVO recurrenceVO) {
        mRecurrence = recurrenceVO;
    }

    @Override
    public String toString() {
        return mname + "\r\r\r" + mtaskDate ;
    }
}
