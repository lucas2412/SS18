package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity
//@Table(name = "ORDER")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer O_ID;
    @Column
    private Integer O_C_ID;
  //  @Column
  //  private Integer O_H_ID;
    @Column
    private Date O_EINGANGSDATUM;
    @Column
    private Integer O_OL_CNT;

    public Order() {
    }

    @ManyToOne
    @JoinColumn(name = "O_C_ID", insertable=false, updatable = false)
    private Customer customer;
/*
    @ManyToOne
    @JoinColumn(name = "O_H_ID", insertable=false, updatable = false)
    private History OrderHistory;
*/

    @OneToMany(mappedBy = "OL_Order")
    private List<OrderLine> orderLines = new ArrayList<OrderLine>();

    @OneToOne(mappedBy = "NewOrder")
    private NewOrder NewOrder;

    public Integer getO_ID() {
        return O_ID;
    }

    public void setO_ID(Integer o_ID) {
        O_ID = o_ID;
    }

    public Integer getO_C_ID() {
        return O_C_ID;
    }

    public void setO_C_ID(Integer o_C_ID) {
        O_C_ID = o_C_ID;
    }
/*
    public Integer getO_H_ID() {
        return O_H_ID;
    }

    public void setO_H_ID(Integer o_H_ID) {
        O_H_ID = o_H_ID;
    }
*/
    public Date getO_EINGANGSDATUM() {
        return O_EINGANGSDATUM;
    }

    public void setO_EINGANGSDATUM(Date o_EINGANSDATUM) {
        O_EINGANGSDATUM = o_EINGANSDATUM;
    }

    public Integer getO_OL_CNT() {
        return O_OL_CNT;
    }

    public void setO_OL_CNT(Integer o_OL_CNT) {
        O_OL_CNT = o_OL_CNT;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
/*
    public History getOrderHistory() {
        return OrderHistory;
    }

    public void setOrderHistory(History orderHistory) {
        OrderHistory = orderHistory;
    }
*/
    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public model.NewOrder getNewOrder() {
        return NewOrder;
    }

    public void setNewOrder(model.NewOrder newOrder) {
        NewOrder = newOrder;
    }
}