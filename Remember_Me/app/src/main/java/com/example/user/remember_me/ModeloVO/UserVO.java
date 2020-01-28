package com.example.user.remember_me.ModeloVO;

public class UserVO {
    private int midUser;
    private String mname;
    private String mapellido;
    private String mFechaNac;
    private String mcorreo;
    private String mcontrasena;

    public String getusername() {
        return username;
    }

    public void setusername(String musername) {
        this.username = musername;
    }

    private String username;
    public int getidUser() {
        return midUser;
    }

    public void setidUser(int midUser) {
        this.midUser = midUser;
    }

    public String getname() {
        return mname;
    }

    public void setname(String mname) {
        this.mname = mname;
    }

    public String getapellido() {
        return mapellido;
    }

    public void setapellido(String mapellido) {
        this.mapellido = mapellido;
    }

    public String getFechaNac() {
        return mFechaNac;
    }

    public void setFechaNac(String fechaNac) {
        mFechaNac = fechaNac;
    }

    public String getcorreo() {
        return mcorreo;
    }

    public void setcorreo(String mcorreo) {
        this.mcorreo = mcorreo;
    }

    public String getcontrasena() {
        return mcontrasena;
    }

    public void setcontrasena(String mcontrasena) {
        this.mcontrasena = mcontrasena;
    }


}
