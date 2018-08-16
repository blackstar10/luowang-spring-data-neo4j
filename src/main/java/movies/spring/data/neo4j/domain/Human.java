package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import movies.spring.data.neo4j.domain.Entity;
import movies.spring.data.neo4j.domain.IDCard;
import movies.spring.data.neo4j.domain.relationship.PlainRelationship;
import movies.spring.data.neo4j.utils.DateUtils;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.DateLong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create on 2018/7/30 10:07
 *
 * @author sunqiu@cmss.chinamobile.com
 */
public class Human extends Entity {
    private String name;
    private String birthday;

    @DateLong
    private Date birthdayLong;
    private String comments;

    private boolean isResident;

    // 在json中使用枚举，还要再转成Neo4j的Node?
    private String gender;

    private double crimePercent = 0.01;

    @Relationship(type = "owns")
    private List<IDCard> idCardList = new ArrayList<>();


    @Relationship(type = PlainRelationship.belongToType)
    private List<HumanType> humanTypeList = new ArrayList<>();

    @Relationship(type = "belongToGroup")
    private List<Group> groupList = new ArrayList<>();

    // @JsonBackReference
    @Relationship(type = "isFamilyNumberWith", direction = Relationship.UNDIRECTED)
    private List<Human> familyList = new ArrayList<>();

    @Relationship(type = "owns")
    private List<Phone> phoneList = new ArrayList<>();

    private List<String> humanTypeListString = new ArrayList<>();

    public Human() {
    }

    public Human(String name, String birthday, String comments, boolean isResident, String gender) {
        this.name = name;
        this.birthday = birthday;
        this.birthdayLong = DateUtils.getDate(birthday);
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
        this.birthdayLong = DateUtils.getDate(birthday);
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


    public List<HumanType> getHumanTypeList() {
        return humanTypeList;
    }

    public void addHumanType(HumanType humanType) {
        humanTypeList.add(humanType);
    }

    public Date getBirthdayLong() {
        return birthdayLong;
    }

    public void setBirthdayLong(Date birthdayLong) {
        this.birthdayLong = birthdayLong;
    }


    public double getCrimePercent() {
        return crimePercent;
    }

    public void setCrimePercent(double crimePercent) {
        this.crimePercent = crimePercent;
    }

    public List<String> getHumanTypeListString() {
        return humanTypeListString;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public void addGroupList(Group group) {
        groupList.add(group);
    }

    public List<Human> getFamilyList() {
        return familyList;
    }

    public void addFamilyMember(Human human) {
        familyList.add(human);
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void addPhone(Phone phone){
        this.phoneList.add(phone);
    }
}
