package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:40.
 */
@Entity
@Table(name = "ADM_USSD_SESSIONS")
public class UssdSessions {
    private Long id;
    private String sessionId;
    private Date creationDate;
    //private Long userId;
    private String varFld01;
    private String varFld02;
    private String varFld03;
    private String varFld04;
    private String varFld05;
    private String varFld06;
    private String varFld07;
    private String varFld08;
    private String varFld09;
    private String varFld10;
    private Integer status;
    private Principals userId;

    @Id
    @SequenceGenerator(name = "ADM_USSD_SESSIONS_SEQ_GEN", sequenceName = "ADM_USSD_SESSIONS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ADM_USSD_SESSIONS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "SESSION_ID", nullable = true, length = 100)
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "CREATION_TIME", nullable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



    @Basic
    @Column(name = "VAR_FLD_01", nullable = true, length = 255)
    public String getVarFld01() {
        return varFld01;
    }

    public void setVarFld01(String varFld01) {
        this.varFld01 = varFld01;
    }

    @Basic
    @Column(name = "VAR_FLD_02", nullable = true, length = 255)
    public String getVarFld02() {
        return varFld02;
    }

    public void setVarFld02(String varFld02) {
        this.varFld02 = varFld02;
    }

    @Basic
    @Column(name = "VAR_FLD_03", nullable = true, length = 255)
    public String getVarFld03() {
        return varFld03;
    }

    public void setVarFld03(String varFld03) {
        this.varFld03 = varFld03;
    }

    @Basic
    @Column(name = "VAR_FLD_04", nullable = true, length = 255)
    public String getVarFld04() {
        return varFld04;
    }

    public void setVarFld04(String varFld04) {
        this.varFld04 = varFld04;
    }

    @Basic
    @Column(name = "VAR_FLD_05", nullable = true, length = 255)
    public String getVarFld05() {
        return varFld05;
    }

    public void setVarFld05(String varFld05) {
        this.varFld05 = varFld05;
    }

    @Basic
    @Column(name = "VAR_FLD_06", nullable = true, length = 4000)
    public String getVarFld06() {
        return varFld06;
    }

    public void setVarFld06(String varFld06) {
        this.varFld06 = varFld06;
    }

    @Basic
    @Column(name = "VAR_FLD_07", nullable = true, length = 255)
    public String getVarFld07() {
        return varFld07;
    }

    public void setVarFld07(String varFld07) {
        this.varFld07 = varFld07;
    }

    @Basic
    @Column(name = "VAR_FLD_08", nullable = true, length = 255)
    public String getVarFld08() {
        return varFld08;
    }

    public void setVarFld08(String varFld08) {
        this.varFld08 = varFld08;
    }

    @Basic
    @Column(name = "VAR_FLD_09", nullable = true, length = 255)
    public String getVarFld09() {
        return varFld09;
    }

    public void setVarFld09(String varFld09) {
        this.varFld09 = varFld09;
    }

    @Basic
    @Column(name = "VAR_FLD_10", nullable = true, length = 255)
    public String getVarFld10() {
        return varFld10;
    }

    public void setVarFld10(String varFld10) {
        this.varFld10 = varFld10;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, precision = 0)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UssdSessions that = (UssdSessions) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (varFld01 != null ? !varFld01.equals(that.varFld01) : that.varFld01 != null) return false;
        if (varFld02 != null ? !varFld02.equals(that.varFld02) : that.varFld02 != null) return false;
        if (varFld03 != null ? !varFld03.equals(that.varFld03) : that.varFld03 != null) return false;
        if (varFld04 != null ? !varFld04.equals(that.varFld04) : that.varFld04 != null) return false;
        if (varFld05 != null ? !varFld05.equals(that.varFld05) : that.varFld05 != null) return false;
        if (varFld06 != null ? !varFld06.equals(that.varFld06) : that.varFld06 != null) return false;
        if (varFld07 != null ? !varFld07.equals(that.varFld07) : that.varFld07 != null) return false;
        if (varFld08 != null ? !varFld08.equals(that.varFld08) : that.varFld08 != null) return false;
        if (varFld09 != null ? !varFld09.equals(that.varFld09) : that.varFld09 != null) return false;
        if (varFld10 != null ? !varFld10.equals(that.varFld10) : that.varFld10 != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (varFld01 != null ? varFld01.hashCode() : 0);
        result = 31 * result + (varFld02 != null ? varFld02.hashCode() : 0);
        result = 31 * result + (varFld03 != null ? varFld03.hashCode() : 0);
        result = 31 * result + (varFld04 != null ? varFld04.hashCode() : 0);
        result = 31 * result + (varFld05 != null ? varFld05.hashCode() : 0);
        result = 31 * result + (varFld06 != null ? varFld06.hashCode() : 0);
        result = 31 * result + (varFld07 != null ? varFld07.hashCode() : 0);
        result = 31 * result + (varFld08 != null ? varFld08.hashCode() : 0);
        result = 31 * result + (varFld09 != null ? varFld09.hashCode() : 0);
        result = 31 * result + (varFld10 != null ? varFld10.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false)
    public Principals getUserId() {
        return userId;
    }

    public void setUserId(Principals admPrincipalsByUserId) {
        this.userId = admPrincipalsByUserId;
    }
}
