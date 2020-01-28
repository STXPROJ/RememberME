package com.example.user.remember_me.ModeloVO;

public class TaskHistoryVO extends TaskVO{
    /* Metodos Implementados de Herencia de la clase Task */
    @Override
    public int getidTask() {
        return super.getidTask();
    }

    @Override
    public void setidTask(int midTask) {
        super.setidTask(midTask);
    }

    @Override
    public String getname() {
        return super.getname();
    }

    @Override
    public void setname(String mname) {
        super.setname(mname);
    }

    @Override
    public String getdescription() {
        return super.getdescription();
    }

    @Override
    public void setdescription(String mdescription) {
        super.setdescription(mdescription);
    }

    @Override
    public String gettaskDate() {
        return super.gettaskDate();
    }

    @Override
    public void settaskDate(String mtaskDate) {
        super.settaskDate(mtaskDate);
    }

    @Override
    public String getnextDate() {
        return super.getnextDate();
    }

    @Override
    public void setnextDate(String mnextDate) {
        super.setnextDate(mnextDate);
    }

    @Override
    public boolean getisDone() {
        return super.getisDone();
    }

    @Override
    public void setisDone(boolean misDone) {
        super.setisDone(misDone);
    }

    @Override
    public RecurrenceVO getRecurrence() {
        return super.getRecurrence();
    }

    @Override
    public void setRecurrence(RecurrenceVO recurrence) {
        super.setRecurrence(recurrence);
    }
}
