package com.example.demo.po;

public class Teacher {
    private Integer id;

    private String teaid;

    private String school;

    private String psw;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaid() {
        return teaid;
    }

    public void setTeaid(String teaid) {
        this.teaid = teaid == null ? null : teaid.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw == null ? null : psw.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teaid='" + teaid + '\'' +
                ", school='" + school + '\'' +
                ", psw='" + psw + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}