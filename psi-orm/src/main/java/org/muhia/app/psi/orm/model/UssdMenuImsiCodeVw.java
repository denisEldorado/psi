package org.muhia.app.psi.orm.model;

import javax.persistence.*;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:43.
 */
@Entity
@Table(name = "DAT_USSD_MENU_IMSI_CODE_VW", schema = "PSI", catalog = "")
public class UssdMenuImsiCodeVw {
    private Long id;
    private String ussdCode;
    private String ussdImsiPrefix;
    private int status;
    private String menuKey;
    private String textVar1;
    private String textVar2;
    private String textVar3;
    private String textVar4;
    private String menuNextId;
    private String menuAction;
    private String menuCondition;
    private String menuParameter;
    private String menuIsChoice;
    private String menuSessionEnd;
    private String secureMenu;
    private Long ftu;
    private String preProcessingInfo;
    private String postProcessingInfo;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USSD_CODE", nullable = false, length = 20)
    public String getUssdCode() {
        return ussdCode;
    }

    public void setUssdCode(String ussdCode) {
        this.ussdCode = ussdCode;
    }

    @Basic
    @Column(name = "USSD_IMSI_PREFIX", nullable = false, length = 20)
    public String getUssdImsiPrefix() {
        return ussdImsiPrefix;
    }

    public void setUssdImsiPrefix(String ussdImsiPrefix) {
        this.ussdImsiPrefix = ussdImsiPrefix;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @Column(name = "MENU_NEXT_ID", nullable = true, length = 230)
    public String getMenuNextId() {
        return menuNextId;
    }

    public void setMenuNextId(String menuNextId) {
        this.menuNextId = menuNextId;
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
    @Column(name = "MENU_CONDITION", nullable = true, length = 230)
    public String getMenuCondition() {
        return menuCondition;
    }

    public void setMenuCondition(String menuCondition) {
        this.menuCondition = menuCondition;
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

        UssdMenuImsiCodeVw that = (UssdMenuImsiCodeVw) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (ussdCode != null ? !ussdCode.equals(that.ussdCode) : that.ussdCode != null) return false;
        if (ussdImsiPrefix != null ? !ussdImsiPrefix.equals(that.ussdImsiPrefix) : that.ussdImsiPrefix != null)
            return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (menuKey != null ? !menuKey.equals(that.menuKey) : that.menuKey != null) return false;
        if (textVar1 != null ? !textVar1.equals(that.textVar1) : that.textVar1 != null) return false;
        if (textVar2 != null ? !textVar2.equals(that.textVar2) : that.textVar2 != null) return false;
        if (textVar3 != null ? !textVar3.equals(that.textVar3) : that.textVar3 != null) return false;
        if (textVar4 != null ? !textVar4.equals(that.textVar4) : that.textVar4 != null) return false;
        if (menuNextId != null ? !menuNextId.equals(that.menuNextId) : that.menuNextId != null) return false;
        if (menuAction != null ? !menuAction.equals(that.menuAction) : that.menuAction != null) return false;
        if (menuCondition != null ? !menuCondition.equals(that.menuCondition) : that.menuCondition != null)
            return false;
        if (menuParameter != null ? !menuParameter.equals(that.menuParameter) : that.menuParameter != null)
            return false;
        if (menuIsChoice != null ? !menuIsChoice.equals(that.menuIsChoice) : that.menuIsChoice != null) return false;
        if (menuSessionEnd != null ? !menuSessionEnd.equals(that.menuSessionEnd) : that.menuSessionEnd != null)
            return false;
        if (secureMenu != null ? !secureMenu.equals(that.secureMenu) : that.secureMenu != null) return false;
        return ftu != null ? ftu.equals(that.ftu) : that.ftu == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (ussdCode != null ? ussdCode.hashCode() : 0);
        result = 31 * result + (ussdImsiPrefix != null ? ussdImsiPrefix.hashCode() : 0);

        result = 31 * result + (menuKey != null ? menuKey.hashCode() : 0);
        result = 31 * result + (textVar1 != null ? textVar1.hashCode() : 0);
        result = 31 * result + (textVar2 != null ? textVar2.hashCode() : 0);
        result = 31 * result + (textVar3 != null ? textVar3.hashCode() : 0);
        result = 31 * result + (textVar4 != null ? textVar4.hashCode() : 0);
        result = 31 * result + (menuNextId != null ? menuNextId.hashCode() : 0);
        result = 31 * result + (menuAction != null ? menuAction.hashCode() : 0);
        result = 31 * result + (menuCondition != null ? menuCondition.hashCode() : 0);
        result = 31 * result + (menuParameter != null ? menuParameter.hashCode() : 0);
        result = 31 * result + (menuIsChoice != null ? menuIsChoice.hashCode() : 0);
        result = 31 * result + (menuSessionEnd != null ? menuSessionEnd.hashCode() : 0);
        result = 31 * result + (secureMenu != null ? secureMenu.hashCode() : 0);
        result = 31 * result + (ftu != null ? ftu.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "PRE_PROCESSING_INFO")
    public String getPreProcessingInfo() {
        return preProcessingInfo;
    }

    public void setPreProcessingInfo(String preProcessingInfo) {
        this.preProcessingInfo = preProcessingInfo;
    }

    @Basic
    @Column(name = "POST_PROCESSING_INFO")
    public String getPostProcessingInfo() {
        return postProcessingInfo;
    }

    public void setPostProcessingInfo(String postProcessingInfo) {
        this.postProcessingInfo = postProcessingInfo;
    }
}
