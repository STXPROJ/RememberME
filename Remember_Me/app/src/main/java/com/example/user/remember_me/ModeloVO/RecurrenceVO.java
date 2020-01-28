package com.example.user.remember_me.ModeloVO;

public class RecurrenceVO {
    private int idRecurrence;
    private String name;
    private String description;
    private String type;
    private int interval;

    /* Metodos Getter y Setter de la clase Recurrence */
    public int getidRecurrence() {
        return idRecurrence;
    }

    public void setidRecurrence(int midRecurrence) {
        this.idRecurrence = midRecurrence;
    }

    public String getname() {
        return name;
    }

    public void setname(String mname) {
        this.name = mname;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String mdescription) {
        this.description = mdescription;
    }

    public String gettype() {
        return type;
    }

    public void settype(String mtype) {
        this.type = mtype;
    }

    public int getinterval() {
        return interval;
    }

    public void setinterval(int minterval) {
        this.interval = minterval;
    }
}
