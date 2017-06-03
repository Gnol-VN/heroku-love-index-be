package uet.k59t.model;

import uet.k59t.controller.dto.LoveDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Longlaptop on 6/4/2017.
 */
@Entity
public class Love {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name0;
    private String name1;
    private String day0;
    private String day1;
    private String month0;
    private String month1;
    private String year0;
    private String year1;

    public Love() {
    }

    public Love(LoveDTO loveDTO) {
        this.day0 = loveDTO.getDay0();
        this.day1= loveDTO.getDay1();
        this.name0 = loveDTO.getName0();
        this.name1=loveDTO.getName1();
        this.month0 = loveDTO.getMonth0();
        this.month1 = loveDTO.getMonth1();
        this.year0 = loveDTO.getYear0();
        this.year1 = loveDTO.getYear1();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName0() {
        return name0;
    }

    public void setName0(String name0) {
        this.name0 = name0;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getDay0() {
        return day0;
    }

    public void setDay0(String day0) {
        this.day0 = day0;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getMonth0() {
        return month0;
    }

    public void setMonth0(String month0) {
        this.month0 = month0;
    }

    public String getMonth1() {
        return month1;
    }

    public void setMonth1(String month1) {
        this.month1 = month1;
    }

    public String getYear0() {
        return year0;
    }

    public void setYear0(String year0) {
        this.year0 = year0;
    }

    public String getYear1() {
        return year1;
    }

    public void setYear1(String year1) {
        this.year1 = year1;
    }
}
