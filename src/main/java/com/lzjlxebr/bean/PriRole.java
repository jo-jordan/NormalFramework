package com.lzjlxebr.bean;

import com.lzjlxebr.base.SixComboBean;

import javax.persistence.*;
import java.util.List;

/**
 * create: lzjlxebr
 * time: 2018/12/11 00:37
 * description: 权限角色表
 **/
@Entity
@Table(name = "PRI_ROLE")
public class PriRole extends SixComboBean {
    @Id
    @TableGenerator(name="ID_GENERATOR",  //生成器名称
            table="ID_GENERATOR", //生成器使用的表
            pkColumnName="PK_NAME", //表中对应的字段名
            pkColumnValue="ID_PRI_ROLE", //上述字段的值
            valueColumnName="PK_VALUE", //值
            //根据上述三个属性，就可以定位到表中的PK_VALUE的值，如：1，10，100
            allocationSize=1)//表示主键一次增加10
    @GeneratedValue(strategy=GenerationType.TABLE, generator="ID_GENERATOR")
    @Column(name = "ID_PRI_ROLE")
    private Long id;

    //app角色名称
    @Column(name = "ROLE_APP_NAME")
    private String name;

    //app角色描述
    @Column(name = "ROLE_APP_DESCRIPTION")
    private String description;

    //app角色编码
    @Column(name = "ROLE_APP_CODE")
    private String code;

    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_PRI_APP")
    private List<PriPrivilege> privileges;

    public PriRole() {
    }

    public PriRole(Long id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<PriPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PriPrivilege> privileges) {
        this.privileges = privileges;
    }
}
