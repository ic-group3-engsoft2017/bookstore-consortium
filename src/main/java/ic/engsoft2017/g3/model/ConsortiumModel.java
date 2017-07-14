package ic.engsoft2017.g3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pegoraroluiz on 7/9/17.
 */
@Entity
@Table(name = "consortium", schema = "bookstore_consortium")
@Getter @Setter
public class ConsortiumModel {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long pk;

    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    private String voucher;

    @ManyToMany
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<MemberModel> members;

    @ManyToMany
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<MemberModel> adminstrators;

    public ConsortiumModel() {
        //default for JPA
    }

}
