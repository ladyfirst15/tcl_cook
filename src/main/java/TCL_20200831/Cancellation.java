package TCL_20200831;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Cancellation_table")
public class Cancellation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer customerId;
    private String status;
    private Long orderId;

    //@PrePersist
    @PostPersist
    public void onPostPersist(){
        CookCancelled cookCancelled = new CookCancelled();
        BeanUtils.copyProperties(this, cookCancelled);
        cookCancelled.publishAfterCommit();


    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
