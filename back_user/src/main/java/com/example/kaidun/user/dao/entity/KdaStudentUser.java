package com.example.kaidun.user.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * <p>
 * 学员移动登陆用户管理表
 * </p>
 *
 * @author harvey
 * @since 2020-11-17
 */
@TableName("KDA_STUDENT_USER")
public class KdaStudentUser extends Model<KdaStudentUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 学员用户表主键
     */
    @TableId("KSU_ID")
    private String ksuId;

    /**
     * 学员ID
     */
    @TableField("KSU_STU_ID")
    private String ksuStuId;

    /**
     * 学员登录用户名
     */
    @TableField("KSU_USER_CODE")
    private String ksuUserCode;

    /**
     * 学员登录密码
     */
    @TableField("KSU_USER_PWD")
    private String ksuUserPwd;

    /**
     * 表示用户是否被禁用（001、正常002、禁止）
     */
    @TableField("KSU_USER_ENABLED")
    private String ksuUserEnabled;

    /**
     * 学员用户头像地址
     */
    @TableField("KSU_USER_STU_HEAD_IMG")
    private String ksuUserStuHeadImg;

    /**
     * 家长用户头像地址
     */
    @TableField("KSU_USER_FAM_HEAD_IMG")
    private String ksuUserFamHeadImg;

    /**
     * 创建时间
     */
    @TableField("KSU_USER_CREATE_DATE")
    private LocalDateTime ksuUserCreateDate;

    /**
     * 二维码图片地址
     */
    @TableField("KSU_QR_CODE_URL")
    private String ksuQrCodeUrl;

    /**
     * 家长端最后登录时间
     */
    @TableField("KSU_FAM_LAST_TIME")
    private LocalDateTime ksuFamLastTime;

    /**
     * 帐号生效开始时间
     */
    @TableField("KSU_START_DATE")
    private LocalDateTime ksuStartDate;

    /**
     * 帐号结束开始时间
     */
    @TableField("KSU_END_DATE")
    private LocalDateTime ksuEndDate;

    public String getKsuId() {
        return ksuId;
    }

    public void setKsuId(String ksuId) {
        this.ksuId = ksuId;
    }

    public String getKsuStuId() {
        return ksuStuId;
    }

    public void setKsuStuId(String ksuStuId) {
        this.ksuStuId = ksuStuId;
    }

    public String getKsuUserCode() {
        return ksuUserCode;
    }

    public void setKsuUserCode(String ksuUserCode) {
        this.ksuUserCode = ksuUserCode;
    }

    public String getKsuUserPwd() {
        return ksuUserPwd;
    }

    public void setKsuUserPwd(String ksuUserPwd) {
        this.ksuUserPwd = ksuUserPwd;
    }

    public String getKsuUserEnabled() {
        return ksuUserEnabled;
    }

    public void setKsuUserEnabled(String ksuUserEnabled) {
        this.ksuUserEnabled = ksuUserEnabled;
    }

    public String getKsuUserStuHeadImg() {
        return ksuUserStuHeadImg;
    }

    public void setKsuUserStuHeadImg(String ksuUserStuHeadImg) {
        this.ksuUserStuHeadImg = ksuUserStuHeadImg;
    }

    public String getKsuUserFamHeadImg() {
        return ksuUserFamHeadImg;
    }

    public void setKsuUserFamHeadImg(String ksuUserFamHeadImg) {
        this.ksuUserFamHeadImg = ksuUserFamHeadImg;
    }

    public LocalDateTime getKsuUserCreateDate() {
        return ksuUserCreateDate;
    }

    public void setKsuUserCreateDate(LocalDateTime ksuUserCreateDate) {
        this.ksuUserCreateDate = ksuUserCreateDate;
    }

    public String getKsuQrCodeUrl() {
        return ksuQrCodeUrl;
    }

    public void setKsuQrCodeUrl(String ksuQrCodeUrl) {
        this.ksuQrCodeUrl = ksuQrCodeUrl;
    }

    public LocalDateTime getKsuFamLastTime() {
        return ksuFamLastTime;
    }

    public void setKsuFamLastTime(LocalDateTime ksuFamLastTime) {
        this.ksuFamLastTime = ksuFamLastTime;
    }

    public LocalDateTime getKsuStartDate() {
        return ksuStartDate;
    }

    public void setKsuStartDate(LocalDateTime ksuStartDate) {
        this.ksuStartDate = ksuStartDate;
    }

    public LocalDateTime getKsuEndDate() {
        return ksuEndDate;
    }

    public void setKsuEndDate(LocalDateTime ksuEndDate) {
        this.ksuEndDate = ksuEndDate;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "KdaStudentUser{" +
        ", ksuId=" + ksuId +
        ", ksuStuId=" + ksuStuId +
        ", ksuUserCode=" + ksuUserCode +
        ", ksuUserPwd=" + ksuUserPwd +
        ", ksuUserEnabled=" + ksuUserEnabled +
        ", ksuUserStuHeadImg=" + ksuUserStuHeadImg +
        ", ksuUserFamHeadImg=" + ksuUserFamHeadImg +
        ", ksuUserCreateDate=" + ksuUserCreateDate +
        ", ksuQrCodeUrl=" + ksuQrCodeUrl +
        ", ksuFamLastTime=" + ksuFamLastTime +
        ", ksuStartDate=" + ksuStartDate +
        ", ksuEndDate=" + ksuEndDate +
        "}";
    }
}
