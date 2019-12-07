package com.yingnuo.domain;

/**
 * Created with IntelliJ IDEA.
 * User: skyzc
 * Date: 2019/11/30
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Admin {
    private int admin_id;
    private String admin_name;
    private String password;
    private String note;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}