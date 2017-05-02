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
@Table(name = "ADM_USER_SECURITY_QUESTIONS")
public class UserSecurityQuestions {
    private Long id;

    private String answer;
    private int status;
    private String createdby;
    private Date createdon;
    private String modifiedby;
    private Date modifiedon;
    private String deleteby;
    private Date deletedon;
    private Principals userId;
    private DefineSecurityQuestions questions;

    public UserSecurityQuestions() {
    }

    public UserSecurityQuestions(Long id) {
        this.id = id;
    }

    public UserSecurityQuestions(Long id, String answer, int status) {
        this.id = id;
        this.answer = answer;
        this.status = status;
    }

    public UserSecurityQuestions(Principals userId, String answer, DefineSecurityQuestions question) {
        this.userId = userId;
        this.answer = answer;
        this.questions = question;
        this.status =1;
        this.createdby = userId.getFullname();
        this.createdon = new Date();
    }


    @Id
    @SequenceGenerator(name = "ADM_USERSECURITY_QUESTIONS_SEQ_GEN", sequenceName = "ADM_USERSECURITY_QUESTIONS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ADM_USERSECURITY_QUESTIONS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ANSWER", nullable = false, length = 500)
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSecurityQuestions that = (UserSecurityQuestions) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;


        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;
        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (createdby != null ? !createdby.equals(that.createdby) : that.createdby != null) return false;
        if (createdon != null ? !createdon.equals(that.createdon) : that.createdon != null) return false;
        if (modifiedby != null ? !modifiedby.equals(that.modifiedby) : that.modifiedby != null) return false;
        if (modifiedon != null ? !modifiedon.equals(that.modifiedon) : that.modifiedon != null) return false;
        if (deleteby != null ? !deleteby.equals(that.deleteby) : that.deleteby != null) return false;
        if (deletedon != null ? !deletedon.equals(that.deletedon) : that.deletedon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);

        result = 31 * result + (answer != null ? answer.hashCode() : 0);

        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (modifiedby != null ? modifiedby.hashCode() : 0);
        result = 31 * result + (modifiedon != null ? modifiedon.hashCode() : 0);
        result = 31 * result + (deleteby != null ? deleteby.hashCode() : 0);
        result = 31 * result + (deletedon != null ? deletedon.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "QUESTION", referencedColumnName = "ID", nullable = false)
    public DefineSecurityQuestions getQuestions() {
        return questions;
    }

    public void setQuestions(DefineSecurityQuestions questions) {
        this.questions = questions;
    }
}
