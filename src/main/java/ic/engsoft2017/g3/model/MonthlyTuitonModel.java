package ic.engsoft2017.g3.model;

import ic.engsoft2017.g3.model.enums.StatusPaymentTuiton;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "member_tuiton")
@Getter @Setter
public class MonthlyTuitonModel {

    @Id
    private Long pk;

    private LocalDateTime monthYearReference;

    private BigDecimal price;

    private StatusPaymentTuiton statusPaymentTuiton;

    public MonthlyTuitonModel() {
        //default for JPA
    }
}
