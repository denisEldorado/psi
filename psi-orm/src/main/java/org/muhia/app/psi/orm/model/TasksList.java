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
@Table(name = "DAT_TASKS_LIST")
public class TasksList {
    private Long id;
    private String taskHeader;
    private String taskDetails;
    private String createdby;
    private Date createdon;
    private Long taskStatus;
    private Long assignedTo;
    private Long taskType;

    @Id
    @Column(name = "ID", nullable = true, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TASK_HEADER", nullable = true, length = 200)
    public String getTaskHeader() {
        return taskHeader;
    }

    public void setTaskHeader(String taskHeader) {
        this.taskHeader = taskHeader;
    }

    @Basic
    @Column(name = "TASK_DETAILS", nullable = true, length = 1900)
    public String getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
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
    @Column(name = "TASK_STATUS", nullable = true, precision = 0)
    public Long getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Long taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Basic
    @Column(name = "ASSIGNED_TO", nullable = true, precision = 0)
    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Basic
    @Column(name = "TASK_TYPE", nullable = true, precision = 0)
    public Long getTaskType() {
        return taskType;
    }

    public void setTaskType(Long taskType) {
        this.taskType = taskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksList tasksList = (TasksList) o;

        if (id != null ? !id.equals(tasksList.id) : tasksList.id != null) return false;
        if (taskHeader != null ? !taskHeader.equals(tasksList.taskHeader) : tasksList.taskHeader != null) return false;
        if (taskDetails != null ? !taskDetails.equals(tasksList.taskDetails) : tasksList.taskDetails != null)
            return false;
        if (createdby != null ? !createdby.equals(tasksList.createdby) : tasksList.createdby != null) return false;
        if (createdon != null ? !createdon.equals(tasksList.createdon) : tasksList.createdon != null) return false;
        if (taskStatus != null ? !taskStatus.equals(tasksList.taskStatus) : tasksList.taskStatus != null) return false;
        if (assignedTo != null ? !assignedTo.equals(tasksList.assignedTo) : tasksList.assignedTo != null) return false;
        if (taskType != null ? !taskType.equals(tasksList.taskType) : tasksList.taskType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taskHeader != null ? taskHeader.hashCode() : 0);
        result = 31 * result + (taskDetails != null ? taskDetails.hashCode() : 0);
        result = 31 * result + (createdby != null ? createdby.hashCode() : 0);
        result = 31 * result + (createdon != null ? createdon.hashCode() : 0);
        result = 31 * result + (taskStatus != null ? taskStatus.hashCode() : 0);
        result = 31 * result + (assignedTo != null ? assignedTo.hashCode() : 0);
        result = 31 * result + (taskType != null ? taskType.hashCode() : 0);
        return result;
    }
}
