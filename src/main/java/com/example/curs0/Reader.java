package com.example.curs0;

public class Reader {
    private String namebook;
    private String nameuser;
    private String dateissue;
    private String datareturn;

    public Reader(String namebook, String nameuser, String dateissue, String datareturn){
        this.namebook = namebook;
        this.nameuser = nameuser;
        this.dateissue = dateissue;
        this.datareturn = datareturn;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getDateissue() {
        return dateissue;
    }

    public void setDateissue(String dateissue) {
        this.dateissue = dateissue;
    }

    public String getDatareturn() {
        return datareturn;
    }

    public void setDatareturn(String datareturn) {
        this.datareturn = datareturn;
    }
}