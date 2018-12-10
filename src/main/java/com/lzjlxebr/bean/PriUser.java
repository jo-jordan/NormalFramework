package com.lzjlxebr.bean;

import com.lzjlxebr.base.SixComboBean;

import javax.persistence.*;
import java.util.List;

/**
 * create: lzjlxebr
 * time: 2018/12/11 00:37
 * description: 用户表
 **/
@Entity
@Table(name = "PRI_USER")
public class PriUser extends SixComboBean {
    @Id
    @TableGenerator(name="ID_GENERATOR",  //生成器名称
            table="ID_GENERATOR", //生成器使用的表
            pkColumnName="PK_NAME", //表中对应的字段名
            pkColumnValue="ID_PRI_USER", //上述字段的值
            valueColumnName="PK_VALUE", //值
            //根据上述三个属性，就可以定位到表中的PK_VALUE的值，如：1，10，100
            allocationSize=1)//表示主键一次增加10
    @GeneratedValue(strategy=GenerationType.TABLE, generator="ID_GENERATOR")
    @Column(name = "ID_PRI_USER")
    private Long id;

    //app用户名称
    @Column(name = "USER_APP_NAME")
    private String name;

    //微信号的openid
    @Column(name = "USER_APP_OPEN_ID")
    private String openid;

    //app用户密码
    @Column(name = "USER_APP_PASSWORD_ENCRYPT")
    private String password;

    //app用户地址
    @Column(name = "USER_APP_ADDRESS")
    private String address;

    //app用户手机
    @Column(name = "USER_APP_PHONE_NUMBER")
    private String phone;

    //app用户年龄
    @Column(name = "USER_APP_AGE")
    private String age;

    //app用户性别
    @Column(name = "USER_APP_GENDER")
    private String gender;

    //app用户紧急联系人电话
    @Column(name = "USER_APP_EMERGENCY_PHONE")
    private String emergencyPhone;

    //app用户紧急联系人姓名
    @Column(name = "USER_APP_EMERGENCY_NAME")
    private String emergencyName;

    //app用户描述
    @Column(name = "USER_APP_DESCRIPTION")
    private String description;

    /**
     * 所属组织类型
     */
    @Column(name = "USER_ORGANIZATION_TYPE")
    private Integer organizationType;

    /**
     * 所属组织ID，需要配合组织类型来使用
     */
    @Column(name = "ID_ORGANIZATION")
    private Long organizationId;

    /**
     * 部门ID，需要配合组织类型来使用
     */
    @Column(name = "USER_DEPARTMENT_ID")
    private Long departmentId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PRI_ROLE")
    private List<PriRole> appRole;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRI_GROUP")
    private List<PriGroup> priGroups;

    public PriUser() {
    }

    public List<PriGroup> getPriGroups() {
        return priGroups;
    }

    public void setPriGroups(List<PriGroup> priGroups) {
        this.priGroups = priGroups;
    }

    public List<PriRole> getAppRole() {
        return appRole;
    }

    public void setAppRole(List<PriRole> appRole) {
        this.appRole = appRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmergencyPhone() {
        return emergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        this.emergencyPhone = emergencyPhone;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
