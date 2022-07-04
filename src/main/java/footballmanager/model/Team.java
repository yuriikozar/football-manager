package footballmanager.model;

import java.math.BigDecimal;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long commission;
    private BigDecimal bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommission() {
        return commission;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }

    public BigDecimal getBank() {
        return bank;
    }

    public void setBank(BigDecimal bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("commission=" + commission)
                .add("bank=" + bank)
                .toString();
    }
}
