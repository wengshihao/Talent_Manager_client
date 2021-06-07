package com.example.talent_manager_client.File_Listview;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class File implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private byte[] Bitmap;
    private String Job;

    public byte[] getBitmap() {
        return Bitmap;
    }

    public void setBitmap(byte[] bitmap) {
        this.Bitmap = bitmap;
    }

    private String Date;
    private String Cevaluate;
    private String Eevaluate;
    private String Name;
    private String Sex;
    private String Age;
    private String Ethnic;
    private String Pstatus;
    private String Apartment;
    private String Discipline;


    private String GZJX;
    private String JHWCL;
    private String SKWCL;
    private String XSFYL;
    private String XKHKZ;
    private String SCXXSJ;

    public String getGZJX() {
        return GZJX;
    }

    public void setGZJX(String GZJX) {
        this.GZJX = GZJX;
    }

    public String getJHWCL() {
        return JHWCL;
    }

    public void setJHWCL(String JHWCL) {
        this.JHWCL = JHWCL;
    }

    public String getSKWCL() {
        return SKWCL;
    }

    public void setSKWCL(String SKWCL) {
        this.SKWCL = SKWCL;
    }

    public String getXSFYL() {
        return XSFYL;
    }

    public void setXSFYL(String XSFYL) {
        this.XSFYL = XSFYL;
    }

    public String getXKHKZ() {
        return XKHKZ;
    }

    public void setXKHKZ(String XKHKZ) {
        this.XKHKZ = XKHKZ;
    }

    public String getSCXXSJ() {
        return SCXXSJ;
    }

    public void setSCXXSJ(String SCXXSJ) {
        this.SCXXSJ = SCXXSJ;
    }

    public String getCQ() {
        return CQ;
    }

    public void setCQ(String CQ) {
        this.CQ = CQ;
    }

    public String getKG() {
        return KG;
    }

    public void setKG(String KG) {
        this.KG = KG;
    }

    public String getQJ() {
        return QJ;
    }

    public void setQJ(String QJ) {
        this.QJ = QJ;
    }

    public String getCDZT() {
        return CDZT;
    }

    public void setCDZT(String CDZT) {
        this.CDZT = CDZT;
    }

    //private String KQQK;
    private String CQ;
    private String KG;
    private String QJ;
    private String CDZT;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCevaluate() {
        return Cevaluate;
    }

    public void setCevaluate(String cevaluate) {
        Cevaluate = cevaluate;
    }

    public String getEevaluate() {
        return Eevaluate;
    }

    public void setEevaluate(String eevaluate) {
        Eevaluate = eevaluate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getEthnic() {
        return Ethnic;
    }

    public void setEthnic(String ethnic) {
        Ethnic = ethnic;
    }

    public String getPstatus() {
        return Pstatus;
    }

    public void setPstatus(String pstatus) {
        Pstatus = pstatus;
    }

    public String getApartment() {
        return Apartment;
    }

    public void setApartment(String apartment) {
        Apartment = apartment;
    }

    public String getDiscipline() {
        return Discipline;
    }

    public void setDiscipline(String discipline) {
        Discipline = discipline;
    }
}
