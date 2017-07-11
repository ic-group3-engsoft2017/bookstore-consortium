package ic.engsoft2017.g3.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pegoraroluiz on 7/9/17.
 */
@Entity
@Table(name = "member")
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pk;

    @OneToMany
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<MonthlyTuitonModel> payments;

    @NotNull
    private String userUID;

    @ManyToOne
    private ConsortiumModel consortiumModel;

    public MemberModel() {
        // default for JPA
    }
}
