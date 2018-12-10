package com.lzjlxebr.bean;

import javax.persistence.*;

/**
 * create: lzjlxebr
 * time: 2018/12/11 00:37
 * description: 权限表
 **/
@Entity
@Table(name = "PRI")
public class PriPrivilege {
    // 主键
    @Id
    @TableGenerator(name = "ID_GENERATOR",  //生成器名称
            table = "ID_GENERATOR", //生成器使用的表
            pkColumnName = "PK_NAME", //表中对应的字段名
            pkColumnValue = "ID_PRI_APP", //上述字段的值
            valueColumnName = "PK_VALUE", //值
            //根据上述三个属性，就可以定位到表中的PK_VALUE的值，如：1，10，100
            allocationSize = 1)//表示主键一次增加10
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
    @Column(name = "ID_PRI_APP")
    private Long id;

    /**
     * 权限索引
     */
    @Column(name = "PRIVILEGE_INDEX")
    private Integer index;

    /**
     * 左侧菜单栏级别
     */
    @Column(name = "PRIVILEGE_LEVEL")
    private Integer level;

    /**
     * 权限父级索引
     */
    @Column(name = "PRIVILEGE_PARENT_INDEX")
    private Integer parentIndex;

    /**
     * 权限对应的权限资源
     */
    @Column(name = "PRIVILEGE_RESOURCE")
    private String resource;

    /**
     * 权限名称
     */
    @Column(name = "PRIVILEGE_NAME")
    private String name;

    /**
     * 权限描述
     */
    @Column(name = "PRIVILEGE_DESCRIPTION")
    private String description;

    /**
     * 显示名称
     */
    @Column(name = "PRIVILEGE_DISPLAY_NAME")
    private String displayName;

    /**
     * 权限编码
     */
    @Column(name = "PRIVILEGE_CODE")
    private String code;

    /**
     * 权限权限类别：0-页面 1-接口
     */
    @Column(name = "PRIVILEGE_TYPE")
    private Integer type;

    public PriPrivilege() {
    }

    public PriPrivilege(Long id) {
        this.id = id;
    }

    public PriPrivilege(Integer index, Integer level, Integer parentIndex, String resource, String name, String description, String displayName, Integer type) {
        this.index = index;
        this.level = level;
        this.parentIndex = parentIndex;
        this.resource = resource;
        this.name = name;
        this.description = description;
        this.displayName = displayName;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(!(obj instanceof PriPrivilege)){
            return false;
        }

        PriPrivilege priPrivilege = (PriPrivilege)obj;

        return this.id.compareTo(priPrivilege.getId()) == 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(Integer parentIndex) {
        this.parentIndex = parentIndex;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}