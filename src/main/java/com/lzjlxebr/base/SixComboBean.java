package com.lzjlxebr.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * create: lzjlxebr
 * time: 2018/12/11 上午12:27
 * description: 数据基本表
 **/
@MappedSuperclass
public class SixComboBean implements Serializable {
    /**
     *修改人ID
     */
    @Column(name = "ID_PRIVILEGE_MODIFY_USER")
    private String modifyUserId;

    /**
     *修改人姓名
     */
    @Column(name = "MODIFY_USERNAME")
    private String modifyUserName;

    /**
     *修改人时间
     */
    @Column(name = "MODIFY_TIME")
    private String modifyTime;

    /**
     * 创建人姓名
     */
    @Column(name = "CREATE_USERNAME")
    private String creatorName;

    /**
     * 创建人关联ID
     */
    @Column(name = "ID_CREATOR")
    private String creatorId;

    /**
     * 创建人创建时间
     */
    @Column(name = "CREATE_TIME")
    private String createTime;

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
