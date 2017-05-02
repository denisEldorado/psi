package org.muhia.app.psi.orm.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

/*
  Created by Kenneth
  Project: psi
  Package: org.muhia.apps.psi.orm.model
  Generated on: 30-Mar-17, 08:41.
 */
@Entity
@Table(name = "CRM_SERVICE_REQUESTS", schema = "PSI")
public class ServiceRequests {
    private Long id;
    private String chargingNode;
    private String chargingValue;
    private Date orderreceivedDate;
    private Date workorderinitiatedDate;
    private Date serviceorderscreatedDate;
    private Date resourceorderscreatedDate;
    private Date requestqueuedDate;
    private Date requestdequeuedDate;
    private Date commandscompletedDate;
    private Date cleanupqueuedDate;
    private Date cleanupdequeuedDate;
    private int renewable;
    private int priority;
    private int status;
    private String prvItemMapKey1;
    private String prvItemMapValue1;
    private String prvItemMapKey2;
    private String prvItemMapValue2;
    private String prvItemMapKey3;
    private String prvItemMapValue3;
    private String prvItemMapKey4;
    private String prvItemMapValue4;
    private String prvItemMapKey5;
    private String prvItemMapValue5;
    private String prvItemMapKey7;
    private String prvItemMapValue7;
    private String prvItemMapKey8;
    private String prvItemMapValue8;
    private String prvItemMapKey9;
    private String prvItemMapValue9;
    private String prvItemMapKey10;
    private String prvItemMapValue10;
    private String prvItemMapKey6;
    private String prvItemMapValue6;
    private String responseMessage;
    private Collection<RecurringOrders> crmRecurringOrdersById;
    private OrderMaster orderNumber;
    private ProductPrvTemplates prvTemplate;
    private Collection<PrincipalsLoans> datPrincipalsLoansById;
    private Collection<PrincipalsSavingsTarget> datPrincipalsSavingsTargetById;
    private Collection<RegistrationDetails> datRegistrationDetailsById;
    private Collection<TransactionRequests> transactionRequests;

    @Id
    @SequenceGenerator(name = "CRM_SERVICE_REQUESTS_SEQ_GEN", sequenceName = "CRM_SERVICE_REQUESTS_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "CRM_SERVICE_REQUESTS_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, precision = 0)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CHARGING_NODE", nullable = true, length = 100)
    public String getChargingNode() {
        return chargingNode;
    }

    public void setChargingNode(String chargingNode) {
        this.chargingNode = chargingNode;
    }

    @Basic
    @Column(name = "CHARGING_VALUE", nullable = true, length = 100)
    public String getChargingValue() {
        return chargingValue;
    }

    public void setChargingValue(String chargingValue) {
        this.chargingValue = chargingValue;
    }

    @Basic
    @Column(name = "ORDERRECEIVED_TIME", nullable = true)
    public Date getOrderreceivedDate() {
        return orderreceivedDate;
    }

    public void setOrderreceivedDate(Date orderreceivedDate) {
        this.orderreceivedDate = orderreceivedDate;
    }

    @Basic
    @Column(name = "WORKORDERINITIATED_TIME", nullable = true)
    public Date getWorkorderinitiatedDate() {
        return workorderinitiatedDate;
    }

    public void setWorkorderinitiatedDate(Date workorderinitiatedDate) {
        this.workorderinitiatedDate = workorderinitiatedDate;
    }

    @Basic
    @Column(name = "SERVICEORDERSCREATED_TIME", nullable = true)
    public Date getServiceorderscreatedDate() {
        return serviceorderscreatedDate;
    }

    public void setServiceorderscreatedDate(Date serviceorderscreatedDate) {
        this.serviceorderscreatedDate = serviceorderscreatedDate;
    }

    @Basic
    @Column(name = "RESOURCEORDERSCREATED_TIME", nullable = true)
    public Date getResourceorderscreatedDate() {
        return resourceorderscreatedDate;
    }

    public void setResourceorderscreatedDate(Date resourceorderscreatedDate) {
        this.resourceorderscreatedDate = resourceorderscreatedDate;
    }

    @Basic
    @Column(name = "REQUESTQUEUED_TIME", nullable = true)
    public Date getRequestqueuedDate() {
        return requestqueuedDate;
    }

    public void setRequestqueuedDate(Date requestqueuedDate) {
        this.requestqueuedDate = requestqueuedDate;
    }

    @Basic
    @Column(name = "REQUESTDEQUEUED_TIME", nullable = true)
    public Date getRequestdequeuedDate() {
        return requestdequeuedDate;
    }

    public void setRequestdequeuedDate(Date requestdequeuedDate) {
        this.requestdequeuedDate = requestdequeuedDate;
    }

    @Basic
    @Column(name = "COMMANDSCOMPLETED_TIME", nullable = true)
    public Date getCommandscompletedDate() {
        return commandscompletedDate;
    }

    public void setCommandscompletedDate(Date commandscompletedDate) {
        this.commandscompletedDate = commandscompletedDate;
    }

    @Basic
    @Column(name = "CLEANUPQUEUED_TIME", nullable = true)
    public Date getCleanupqueuedDate() {
        return cleanupqueuedDate;
    }

    public void setCleanupqueuedDate(Date cleanupqueuedDate) {
        this.cleanupqueuedDate = cleanupqueuedDate;
    }

    @Basic
    @Column(name = "CLEANUPDEQUEUED_TIME", nullable = true)
    public Date getCleanupdequeuedDate() {
        return cleanupdequeuedDate;
    }

    public void setCleanupdequeuedDate(Date cleanupdequeuedDate) {
        this.cleanupdequeuedDate = cleanupdequeuedDate;
    }

    @Basic
    @Column(name = "RENEWABLE", nullable = true, precision = 0)
    public int getRenewable() {
        return renewable;
    }

    public void setRenewable(int renewable) {
        this.renewable = renewable;
    }

    @Basic
    @Column(name = "PRIORITY", nullable = true, precision = 0)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, precision = 0)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_1", nullable = true, length = 200)
    public String getPrvItemMapKey1() {
        return prvItemMapKey1;
    }

    public void setPrvItemMapKey1(String prvItemMapKey1) {
        this.prvItemMapKey1 = prvItemMapKey1;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_1", nullable = true, length = 200)
    public String getPrvItemMapValue1() {
        return prvItemMapValue1;
    }

    public void setPrvItemMapValue1(String prvItemMapValue1) {
        this.prvItemMapValue1 = prvItemMapValue1;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_2", nullable = true, length = 200)
    public String getPrvItemMapKey2() {
        return prvItemMapKey2;
    }

    public void setPrvItemMapKey2(String prvItemMapKey2) {
        this.prvItemMapKey2 = prvItemMapKey2;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_2", nullable = true, length = 200)
    public String getPrvItemMapValue2() {
        return prvItemMapValue2;
    }

    public void setPrvItemMapValue2(String prvItemMapValue2) {
        this.prvItemMapValue2 = prvItemMapValue2;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_3", nullable = true, length = 200)
    public String getPrvItemMapKey3() {
        return prvItemMapKey3;
    }

    public void setPrvItemMapKey3(String prvItemMapKey3) {
        this.prvItemMapKey3 = prvItemMapKey3;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_3", nullable = true, length = 200)
    public String getPrvItemMapValue3() {
        return prvItemMapValue3;
    }

    public void setPrvItemMapValue3(String prvItemMapValue3) {
        this.prvItemMapValue3 = prvItemMapValue3;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_4", nullable = true, length = 200)
    public String getPrvItemMapKey4() {
        return prvItemMapKey4;
    }

    public void setPrvItemMapKey4(String prvItemMapKey4) {
        this.prvItemMapKey4 = prvItemMapKey4;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_4", nullable = true, length = 200)
    public String getPrvItemMapValue4() {
        return prvItemMapValue4;
    }

    public void setPrvItemMapValue4(String prvItemMapValue4) {
        this.prvItemMapValue4 = prvItemMapValue4;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_5", nullable = true, length = 200)
    public String getPrvItemMapKey5() {
        return prvItemMapKey5;
    }

    public void setPrvItemMapKey5(String prvItemMapKey5) {
        this.prvItemMapKey5 = prvItemMapKey5;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_5", nullable = true, length = 200)
    public String getPrvItemMapValue5() {
        return prvItemMapValue5;
    }

    public void setPrvItemMapValue5(String prvItemMapValue5) {
        this.prvItemMapValue5 = prvItemMapValue5;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_7", nullable = true, length = 200)
    public String getPrvItemMapKey7() {
        return prvItemMapKey7;
    }

    public void setPrvItemMapKey7(String prvItemMapKey7) {
        this.prvItemMapKey7 = prvItemMapKey7;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_7", nullable = true, length = 200)
    public String getPrvItemMapValue7() {
        return prvItemMapValue7;
    }

    public void setPrvItemMapValue7(String prvItemMapValue7) {
        this.prvItemMapValue7 = prvItemMapValue7;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_8", nullable = true, length = 200)
    public String getPrvItemMapKey8() {
        return prvItemMapKey8;
    }

    public void setPrvItemMapKey8(String prvItemMapKey8) {
        this.prvItemMapKey8 = prvItemMapKey8;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_8", nullable = true, length = 200)
    public String getPrvItemMapValue8() {
        return prvItemMapValue8;
    }

    public void setPrvItemMapValue8(String prvItemMapValue8) {
        this.prvItemMapValue8 = prvItemMapValue8;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_9", nullable = true, length = 200)
    public String getPrvItemMapKey9() {
        return prvItemMapKey9;
    }

    public void setPrvItemMapKey9(String prvItemMapKey9) {
        this.prvItemMapKey9 = prvItemMapKey9;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_9", nullable = true, length = 200)
    public String getPrvItemMapValue9() {
        return prvItemMapValue9;
    }

    public void setPrvItemMapValue9(String prvItemMapValue9) {
        this.prvItemMapValue9 = prvItemMapValue9;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_10", nullable = true, length = 200)
    public String getPrvItemMapKey10() {
        return prvItemMapKey10;
    }

    public void setPrvItemMapKey10(String prvItemMapKey10) {
        this.prvItemMapKey10 = prvItemMapKey10;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_10", nullable = true, length = 200)
    public String getPrvItemMapValue10() {
        return prvItemMapValue10;
    }

    public void setPrvItemMapValue10(String prvItemMapValue10) {
        this.prvItemMapValue10 = prvItemMapValue10;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_KEY_6", nullable = true, length = 200)
    public String getPrvItemMapKey6() {
        return prvItemMapKey6;
    }

    public void setPrvItemMapKey6(String prvItemMapKey6) {
        this.prvItemMapKey6 = prvItemMapKey6;
    }

    @Basic
    @Column(name = "PRV_ITEM_MAP_VALUE_6", nullable = true, length = 200)
    public String getPrvItemMapValue6() {
        return prvItemMapValue6;
    }

    public void setPrvItemMapValue6(String prvItemMapValue6) {
        this.prvItemMapValue6 = prvItemMapValue6;
    }

    @Basic
    @Column(name = "RESPONSE_MESSAGE", nullable = true, length = 2000)
    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceRequests that = (ServiceRequests) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (chargingNode != null ? !chargingNode.equals(that.chargingNode) : that.chargingNode != null) return false;
        if (chargingValue != null ? !chargingValue.equals(that.chargingValue) : that.chargingValue != null)
            return false;
        if (orderreceivedDate != null ? !orderreceivedDate.equals(that.orderreceivedDate) : that.orderreceivedDate != null)
            return false;
        if (workorderinitiatedDate != null ? !workorderinitiatedDate.equals(that.workorderinitiatedDate) : that.workorderinitiatedDate != null)
            return false;
        if (serviceorderscreatedDate != null ? !serviceorderscreatedDate.equals(that.serviceorderscreatedDate) : that.serviceorderscreatedDate != null)
            return false;
        if (resourceorderscreatedDate != null ? !resourceorderscreatedDate.equals(that.resourceorderscreatedDate) : that.resourceorderscreatedDate != null)
            return false;
        if (requestqueuedDate != null ? !requestqueuedDate.equals(that.requestqueuedDate) : that.requestqueuedDate != null)
            return false;
        if (requestdequeuedDate != null ? !requestdequeuedDate.equals(that.requestdequeuedDate) : that.requestdequeuedDate != null)
            return false;
        if (commandscompletedDate != null ? !commandscompletedDate.equals(that.commandscompletedDate) : that.commandscompletedDate != null)
            return false;
        if (cleanupqueuedDate != null ? !cleanupqueuedDate.equals(that.cleanupqueuedDate) : that.cleanupqueuedDate != null)
            return false;
        if (cleanupdequeuedDate != null ? !cleanupdequeuedDate.equals(that.cleanupdequeuedDate) : that.cleanupdequeuedDate != null)
            return false;


        //if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (prvItemMapKey1 != null ? !prvItemMapKey1.equals(that.prvItemMapKey1) : that.prvItemMapKey1 != null)
            return false;
        if (prvItemMapValue1 != null ? !prvItemMapValue1.equals(that.prvItemMapValue1) : that.prvItemMapValue1 != null)
            return false;
        if (prvItemMapKey2 != null ? !prvItemMapKey2.equals(that.prvItemMapKey2) : that.prvItemMapKey2 != null)
            return false;
        if (prvItemMapValue2 != null ? !prvItemMapValue2.equals(that.prvItemMapValue2) : that.prvItemMapValue2 != null)
            return false;
        if (prvItemMapKey3 != null ? !prvItemMapKey3.equals(that.prvItemMapKey3) : that.prvItemMapKey3 != null)
            return false;
        if (prvItemMapValue3 != null ? !prvItemMapValue3.equals(that.prvItemMapValue3) : that.prvItemMapValue3 != null)
            return false;
        if (prvItemMapKey4 != null ? !prvItemMapKey4.equals(that.prvItemMapKey4) : that.prvItemMapKey4 != null)
            return false;
        if (prvItemMapValue4 != null ? !prvItemMapValue4.equals(that.prvItemMapValue4) : that.prvItemMapValue4 != null)
            return false;
        if (prvItemMapKey5 != null ? !prvItemMapKey5.equals(that.prvItemMapKey5) : that.prvItemMapKey5 != null)
            return false;
        if (prvItemMapValue5 != null ? !prvItemMapValue5.equals(that.prvItemMapValue5) : that.prvItemMapValue5 != null)
            return false;
        if (prvItemMapKey7 != null ? !prvItemMapKey7.equals(that.prvItemMapKey7) : that.prvItemMapKey7 != null)
            return false;
        if (prvItemMapValue7 != null ? !prvItemMapValue7.equals(that.prvItemMapValue7) : that.prvItemMapValue7 != null)
            return false;
        if (prvItemMapKey8 != null ? !prvItemMapKey8.equals(that.prvItemMapKey8) : that.prvItemMapKey8 != null)
            return false;
        if (prvItemMapValue8 != null ? !prvItemMapValue8.equals(that.prvItemMapValue8) : that.prvItemMapValue8 != null)
            return false;
        if (prvItemMapKey9 != null ? !prvItemMapKey9.equals(that.prvItemMapKey9) : that.prvItemMapKey9 != null)
            return false;
        if (prvItemMapValue9 != null ? !prvItemMapValue9.equals(that.prvItemMapValue9) : that.prvItemMapValue9 != null)
            return false;
        if (prvItemMapKey10 != null ? !prvItemMapKey10.equals(that.prvItemMapKey10) : that.prvItemMapKey10 != null)
            return false;
        if (prvItemMapValue10 != null ? !prvItemMapValue10.equals(that.prvItemMapValue10) : that.prvItemMapValue10 != null)
            return false;
        if (prvItemMapKey6 != null ? !prvItemMapKey6.equals(that.prvItemMapKey6) : that.prvItemMapKey6 != null)
            return false;
        if (prvItemMapValue6 != null ? !prvItemMapValue6.equals(that.prvItemMapValue6) : that.prvItemMapValue6 != null)
            return false;
        if (responseMessage != null ? !responseMessage.equals(that.responseMessage) : that.responseMessage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (chargingNode != null ? chargingNode.hashCode() : 0);
        result = 31 * result + (chargingValue != null ? chargingValue.hashCode() : 0);
        result = 31 * result + (orderreceivedDate != null ? orderreceivedDate.hashCode() : 0);
        result = 31 * result + (workorderinitiatedDate != null ? workorderinitiatedDate.hashCode() : 0);
        result = 31 * result + (serviceorderscreatedDate != null ? serviceorderscreatedDate.hashCode() : 0);
        result = 31 * result + (resourceorderscreatedDate != null ? resourceorderscreatedDate.hashCode() : 0);
        result = 31 * result + (requestqueuedDate != null ? requestqueuedDate.hashCode() : 0);
        result = 31 * result + (requestdequeuedDate != null ? requestdequeuedDate.hashCode() : 0);
        result = 31 * result + (commandscompletedDate != null ? commandscompletedDate.hashCode() : 0);
        result = 31 * result + (cleanupqueuedDate != null ? cleanupqueuedDate.hashCode() : 0);
        result = 31 * result + (cleanupdequeuedDate != null ? cleanupdequeuedDate.hashCode() : 0);


        result = 31 * result + (prvItemMapKey1 != null ? prvItemMapKey1.hashCode() : 0);
        result = 31 * result + (prvItemMapValue1 != null ? prvItemMapValue1.hashCode() : 0);
        result = 31 * result + (prvItemMapKey2 != null ? prvItemMapKey2.hashCode() : 0);
        result = 31 * result + (prvItemMapValue2 != null ? prvItemMapValue2.hashCode() : 0);
        result = 31 * result + (prvItemMapKey3 != null ? prvItemMapKey3.hashCode() : 0);
        result = 31 * result + (prvItemMapValue3 != null ? prvItemMapValue3.hashCode() : 0);
        result = 31 * result + (prvItemMapKey4 != null ? prvItemMapKey4.hashCode() : 0);
        result = 31 * result + (prvItemMapValue4 != null ? prvItemMapValue4.hashCode() : 0);
        result = 31 * result + (prvItemMapKey5 != null ? prvItemMapKey5.hashCode() : 0);
        result = 31 * result + (prvItemMapValue5 != null ? prvItemMapValue5.hashCode() : 0);
        result = 31 * result + (prvItemMapKey7 != null ? prvItemMapKey7.hashCode() : 0);
        result = 31 * result + (prvItemMapValue7 != null ? prvItemMapValue7.hashCode() : 0);
        result = 31 * result + (prvItemMapKey8 != null ? prvItemMapKey8.hashCode() : 0);
        result = 31 * result + (prvItemMapValue8 != null ? prvItemMapValue8.hashCode() : 0);
        result = 31 * result + (prvItemMapKey9 != null ? prvItemMapKey9.hashCode() : 0);
        result = 31 * result + (prvItemMapValue9 != null ? prvItemMapValue9.hashCode() : 0);
        result = 31 * result + (prvItemMapKey10 != null ? prvItemMapKey10.hashCode() : 0);
        result = 31 * result + (prvItemMapValue10 != null ? prvItemMapValue10.hashCode() : 0);
        result = 31 * result + (prvItemMapKey6 != null ? prvItemMapKey6.hashCode() : 0);
        result = 31 * result + (prvItemMapValue6 != null ? prvItemMapValue6.hashCode() : 0);
        result = 31 * result + (responseMessage != null ? responseMessage.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "serviceRequest")
    public Collection<RecurringOrders> getCrmRecurringOrdersById() {
        return crmRecurringOrdersById;
    }

    public void setCrmRecurringOrdersById(Collection<RecurringOrders> crmRecurringOrdersById) {
        this.crmRecurringOrdersById = crmRecurringOrdersById;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_NUMBER", referencedColumnName = "ID")
    public OrderMaster getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(OrderMaster orderNumber) {
        this.orderNumber = orderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "PRV_TEMPLATE", referencedColumnName = "ID")
    public ProductPrvTemplates getPrvTemplate() {
        return prvTemplate;
    }

    public void setPrvTemplate(ProductPrvTemplates prvTemplate) {
        this.prvTemplate = prvTemplate;
    }

    @OneToMany(mappedBy = "sr")
    public Collection<PrincipalsLoans> getDatPrincipalsLoansById() {
        return datPrincipalsLoansById;
    }

    public void setDatPrincipalsLoansById(Collection<PrincipalsLoans> datPrincipalsLoansById) {
        this.datPrincipalsLoansById = datPrincipalsLoansById;
    }

    @OneToMany(mappedBy = "servicerequest")
    public Collection<PrincipalsSavingsTarget> getDatPrincipalsSavingsTargetById() {
        return datPrincipalsSavingsTargetById;
    }

    public void setDatPrincipalsSavingsTargetById(Collection<PrincipalsSavingsTarget> datPrincipalsSavingsTargetById) {
        this.datPrincipalsSavingsTargetById = datPrincipalsSavingsTargetById;
    }

    @OneToMany(mappedBy = "serviceRequest")
    public Collection<RegistrationDetails> getDatRegistrationDetailsById() {
        return datRegistrationDetailsById;
    }

    public void setDatRegistrationDetailsById(Collection<RegistrationDetails> datRegistrationDetailsById) {
        this.datRegistrationDetailsById = datRegistrationDetailsById;
    }

    @OneToMany(mappedBy = "serviceRequest")
    public Collection<TransactionRequests> getTransactionRequests() {
        return transactionRequests;
    }

    public void setTransactionRequests(Collection<TransactionRequests> transactionRequests) {
        this.transactionRequests = transactionRequests;
    }
}
