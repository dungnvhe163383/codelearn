/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author okanh
 */
public class HistoryHireRelationship {
    private int id;
    private int menteeid;
    private int mentorid;
    private Date closedate;

    public HistoryHireRelationship() {
    }

    public HistoryHireRelationship(int id, int menteeid, int mentorid, Date closedate) {
        this.id = id;
        this.menteeid = menteeid;
        this.mentorid = mentorid;
        this.closedate = closedate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenteeid() {
        return menteeid;
    }

    public void setMenteeid(int menteeid) {
        this.menteeid = menteeid;
    }

    public int getMentorid() {
        return mentorid;
    }

    public void setMentorid(int mentorid) {
        this.mentorid = mentorid;
    }

    public Date getClosedate() {
        return closedate;
    }

    public void setClosedate(Date closedate) {
        this.closedate = closedate;
    }
    
    
}
