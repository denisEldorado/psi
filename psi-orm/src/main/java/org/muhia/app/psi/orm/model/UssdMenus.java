package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:42.
 */
@Entity
@Table(name = "DAT_USSD_MENUS")
public class UssdMenus {
    private Long id;
    private String menuKey;
    private String menuAction;
    private String menuNextId;
    private String menuParameter;
    private String menuIsChoice;
    private String menuCondition;
    private Integer status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private String textVar1;
    private String textVar2;
    private String textVar3;
    private String textVar4;
    private String textVar5;
    private String textVar6;
    private String menuSessionEnd;
    private String secureMenu;
    private String postProcessingInfo;
    private String preProcessingInfo;
    private Long ftu;
    private UssdCodeImsi ussdCodeImsi;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MENU_KEY", nullable = false, length = 230)
    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    @Basic
    @Column(name = "MENU_ACTION", nullable = true, length = 230)
    public String getMenuAction() {
        return menuAction;
    }

    public void setMenuAction(String menuAction) {
        this.menuAction = menuAction;
    }

    @Basic
    @Column(name = "MENU_NEXT_ID", nullable = true, length = 230)
    public String getMenuNextId() {
        return menuNextId;
    }

    public void setMenuNextId(String menuNextId) {
        this.menuNextId = menuNextId;
    }

    @Basic
    @Column(name = "MENU_PARAMETER", nullable = true, length = 230)
    public String getMenuParameter() {
        return menuParameter;
    }

    public void setMenuParameter(String menuParameter) {
        this.menuParameter = menuParameter;
    }

    @Basic
    @Column(name = "MENU_IS_CHOICE", nullable = true, length = 230)
    public String getMenuIsChoice() {
        return menuIsChoice;
    }

    public void setMenuIsChoice(String menuIsChoice) {
        this.menuIsChoice = menuIsChoice;
    }

    @Basic
    @Column(name = "MENU_CONDITION", nullable = true, length = 230)
    public String getMenuCondition() {
        return menuCondition;
    }

    public void setMenuCondition(String menuCondition) {
        this.menuCondition = menuCondition;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CREATEDBY", nullable = true, length = 100)
    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    @Basic
    @Column(name = "CREATEDON", nullable = true)
    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    @Basic
    @Column(name = "MODIFIEDBY", nullable = true, length = 100)
    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Basic
    @Column(name = "MODIFIEDON", nullable = true)
    public Date getModifiedon() {
        return modifiedon;
    }

    public void setModifiedon(Date modifiedon) {
        this.modifiedon = modifiedon;
    }

    @Basic
    @Column(name = "DELETEBY", nullable = true, length = 100)
    public String getDeleteby() {
        return deleteby;
    }

    public void setDeleteby(String deleteby) {
        this.deleteby = deleteby;
    }

    @Basic
    @Column(name = "DELETEDON", nullable = true)
    public Date getDeletedon() {
        return deletedon;
    }

    public void setDeletedon(Date deletedon) {
        this.deletedon = deletedon;
    }

    @Basic
    @Column(name = "TEXT_VAR_1", nullable = true, length = 200)
    public String getTextVar1() {
        return textVar1;
    }

    public void setTextVar1(String textVar1) {
        this.textVar1 = textVar1;
    }

    @Basic
    @Column(name = "TEXT_VAR_2", nullable = true, length = 200)
    public String getTextVar2() {
        return textVar2;
    }

    public void setTextVar2(String textVar2) {
        this.textVar2 = textVar2;
    }

    @Basic
    @Column(name = "TEXT_VAR_3", nullable = true, length = 200)
    public String getTextVar3() {
        return textVar3;
    }

    public void setTextVar3(String textVar3) {
        this.textVar3 = textVar3;
    }

    @Basic
    @Column(name = "TEXT_VAR_4", nullable = true, length = 200)
    public String getTextVar4() {
        return textVar4;
    }

    public void setTextVar4(String textVar4) {
        this.textVar4 = textVar4;
    }

    @Basic
    @Column(name = "TEXT_VAR_5", nullable = true, length = 200)
    public String getTextVar5() {
        return textVar5;
    }

    public void setTextVar5(String textVar5) {
        this.textVar5 = textVar5;
    }

    @Basic
    @Column(name = "TEXT_VAR_6", nullable = true, length = 200)
    public String getTextVar6() {
        return textVar6;
    }

    public void setTextVar6(String textVar6) {
        this.textVar6 = textVar6;
    }

    @Basic
    @Column(name = "MENU_SESSION_END", nullable = true, length = 10)
    public String getMenuSessionEnd() {
        return menuSessionEnd;
    }

    public void setMenuSessionEnd(String menuSessionEnd) {
        this.menuSessionEnd = menuSessionEnd;
    }

    @Basic
    @Column(name = "SECURE_MENU", nullable = false, length = 50)
    public String getSecureMenu() {
        return secureMenu;
    }

    public void setSecureMenu(String secureMenu) {
        this.secureMenu = secureMenu;
    }

    @Basic
    @Column(name = "POST_PROCESSING_INFO", nullable = true, length = 3000)
    public String getPostProcessingInfo() {
        return postProcessingInfo;
    }

    public void setPostProcessingInfo(String postProcessingInfo) {
        this.postProcessingInfo = postProcessingInfo;
    }

    @Basic
    @Column(name = "PRE_PROCESSING_INFO", nullable = true, length = 3000)
    public String getPreProcessingInfo() {
        return preProcessingInfo;
    }

    public void setPreProcessingInfo(String preProcessingInfo) {
        this.preProcessingInfo = preProcessingInfo;
    }

    @Basic
    @Column(name = "FTU", nullable = false, precision = 0)
    public Long getFtu() {
        return ftu;
    }

    public void setFtu(Long ftu) {
        this.ftu = ftu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UssdMenus ussdMenus = (UssdMenus) o;

        if (id != null ? !id.equals(ussdMenus.id) : ussdMenus.id != null) return false;
        if (menuKey != null ? !menuKey.equals(ussdMenus.menuKey) : ussdMenus.menuKey != null) return false;
        if (menuAction != null ? !menuAction.equals(ussdMenus.menuAction) : ussdMenus.menuAction != null) return false;
        if (menuNextId != null ? !menuNextId.equals(ussdMenus.menuNextId) : ussdMenus.menuNextId != null) return false;
        if (menuParameter != null ? !menuParameter.equals(ussdMenus.menuParameter) : ussdMenus.menuParameter != null)
            return false;
        if (menuIsChoice != null ? !menuIsChoice.equals(ussdMenus.menuIsChoice) : ussdMenus.menuIsChoice != null)
            return false;
        if (menuCondition != null ? !menuCondition.equals(ussdMenus.menuCondition) : ussdMenus.menuCondition != null)
            return false;
        //if (status != null ? !status.equals(ussdMenus.status) : ussdMenus.status != null) return false;
        if (createdby != null ? !createdby.equals(ussdMenus.createdby) : ussdMenus.createdby != null) return false;
        if (createdon != null ? !createdon.equals(ussdMenus.createdon) : ussdMenus.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(ussdMenus.modifiedby) : ussdMenus.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(ussdMenus.modifiedon) : ussdMenus.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(ussdMenus.deleteby) : ussdMenus.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(ussdMenus.deletedon) : ussdMenus.deletedon != null) return false;
        if (textVar1 != null ? !textVar1.equals(ussdMenus.textVar1) : ussdMenus.textVar1 != null) return false;
        if (textVar2 != null ? !textVar2.equals(ussdMenus.textVar2) : ussdMenus.textVar2 != null) return false;
        if (textVar3 != null ? !textVar3.equals(ussdMenus.textVar3) : ussdMenus.textVar3 != null) return false;
        if (textVar4 != null ? !textVar4.equals(ussdMenus.textVar4) : ussdMenus.textVar4 != null) return false;
        if (textVar5 != null ? !textVar5.equals(ussdMenus.textVar5) : ussdMenus.textVar5 != null) return false;
        if (textVar6 != null ? !textVar6.equals(ussdMenus.textVar6) : ussdMenus.textVar6 != null) return false;
        if (menuSessionEnd != null ? !menuSessionEnd.equals(ussdMenus.menuSessionEnd) : ussdMenus.menuSessionEnd != null)
            return false;
        if (secureMenu != null ? !secureMenu.equals(ussdMenus.secureMenu) : ussdMenus.secureMenu != null) return false;
        if (postProcessingInfo != null ? !postProcessingInfo.equals(ussdMenus.postProcessingInfo) : ussdMenus.postProcessingInfo != null)
            return false;
        if (preProcessingInfo != null ? !preProcessingInfo.equals(ussdMenus.preProcessingInfo) : ussdMenus.preProcessingInfo != null)
            return false;
        if (ftu != null ? !ftu.equals(ussdMenus.ftu) : ussdMenus.ftu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (menuKey != null ? menuKey.hashCode() : 0);
        result = 31 * result + (menuAction != null ? menuAction.hashCode() : 0);
        result = 31 * result + (menuNextId != null ? menuNextId.hashCode() : 0);
        result = 31 * result + (menuParameter != null ? menuParameter.hashCode() : 0);
        result = 31 * result + (menuIsChoice != null ? menuIsChoice.hashCode() : 0);
        result = 31 * result + (menuCondition != null ? menuCondition.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
        result = 31 * result + (textVar1 != null ? textVar1.hashCode() : 0);
        result = 31 * result + (textVar2 != null ? textVar2.hashCode() : 0);
        result = 31 * result + (textVar3 != null ? textVar3.hashCode() : 0);
        result = 31 * result + (textVar4 != null ? textVar4.hashCode() : 0);
        result = 31 * result + (textVar5 != null ? textVar5.hashCode() : 0);
        result = 31 * result + (textVar6 != null ? textVar6.hashCode() : 0);
        result = 31 * result + (menuSessionEnd != null ? menuSessionEnd.hashCode() : 0);
        result = 31 * result + (secureMenu != null ? secureMenu.hashCode() : 0);
        result = 31 * result + (postProcessingInfo != null ? postProcessingInfo.hashCode() : 0);
        result = 31 * result + (preProcessingInfo != null ? preProcessingInfo.hashCode() : 0);
        result = 31 * result + (ftu != null ? ftu.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USSD_CODE_IMSI", referencedColumnName = "ID", nullable = false)
    public UssdCodeImsi getUssdCodeImsi() {
        return ussdCodeImsi;
    }

    public void setUssdCodeImsi(UssdCodeImsi ussdCodeImsi) {
        this.ussdCodeImsi = ussdCodeImsi;
    }
}
