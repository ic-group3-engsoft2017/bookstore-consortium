package ic.engsoft2017.g3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter @Setter
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    @OneToMany
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<MonthlyTuitonModel> payments;

    private String userUID;

    @ManyToOne
    private ConsortiumModel consortiumModel;

    public MemberModel() {
        // default for JPA
    }
}
