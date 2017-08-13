package com.smm.school.pojo;

import com.smm.clas.pojo.Clas;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by TaroChen on 2017/8/4.
 */
public class School {

    private Integer shid;
    private String shname;
    private String shaddress;

    private Set<Clas> clas = new HashSet<Clas>();

    public Set<Clas> getClas() {
        return clas;
    }
    public void setClas(Set<Clas> clas) {
        this.clas = clas;
    }

    public Integer getShid() {
        return shid;
    }

    public void setShid(Integer shid) {
        this.shid = shid;
    }

    public String getShname() {
        return shname;
    }

    public void setShname(String shname) {
        this.shname = shname;
    }

    public String getShaddress() {
        return shaddress;
    }

    public void setShaddress(String shaddress) {
        this.shaddress = shaddress;
    }
}
