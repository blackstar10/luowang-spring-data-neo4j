package movies.spring.data.neo4j.domain;

import movies.spring.data.neo4j.utils.DateUtils;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * Create on 2018/7/30 10:07
 *
 * @author sunqiu@cmss.chinamobile.com
 */
@NodeEntity
public class Human extends Entity {
    private String name;
    private String birthday;

    private Long birthdayLong;
    private String comments;

    private boolean isResident;

    private String gender; // todo 枚举?

    @Relationship(type = "owns")
    private List<IDCard> idCardList = new ArrayList<>();

    public Human() {
    }

    public Human(String name, String birthday, String comments, boolean isResident, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.birthdayLong = DateUtils.getDateLong(birthday);
        this.comments = comments;
        this.isResident = isResident;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.birthdayLong = DateUtils.getDateLong(birthday);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<IDCard> getIdCardList() {
        return idCardList;
    }

    public void addIdCard(IDCard idCard) {
        idCardList.add(idCard);
    }


    public Long getBirthdayLong() {
        return birthdayLong;
    }

    public void setBirthdayLong(Long birthdayLong) {
        this.birthdayLong = birthdayLong;
    }
}
