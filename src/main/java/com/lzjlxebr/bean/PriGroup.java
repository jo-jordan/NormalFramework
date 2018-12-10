package com.lzjlxebr.bean;

import com.lzjlxebr.base.SixComboBean;

import javax.persistence.*;
import java.util.List;

/**
 * create: lzjlxebr
 * time: 2018/12/11 00:37
 * description: 权限组表
 **/
@Entity
@Table(name = "PRI_GROUP")
public class PriGroup extends SixComboBean {
    @Id
    @TableGenerator(
            name = "ID_GENERATOR",
            table = "ID_GENERATOR",
            pkColumnName = "PK_NAME",
            pkColumnValue = "ID_PRI_GROUP",
            valueColumnName = "PK_VALUE",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "ID_GENERATOR")
    @Column(name = "ID_PRI_GROUP")
    private Long id;

    //app用户组名称
    @Column(name = "GROUP_APP_NAME")
    private String name;

    //app用户组描述
    @Column(name = "GROUP_APP_DESCRIPTION")
    private String description;

    @ManyToMany
    @JoinColumn(name = "ID_PRI_ROLE")
    private List<PriRole> appRole;

    public PriGroup() {
    }

    public PriGroup(Long id){
        this.id = id;
    }

    public PriGroup(String name, String description, String createUserId, String createUserName, String createTime) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
