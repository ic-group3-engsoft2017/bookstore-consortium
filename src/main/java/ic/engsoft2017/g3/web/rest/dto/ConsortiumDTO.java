package ic.engsoft2017.g3.web.rest.dto;

import ic.engsoft2017.g3.model.MemberModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pegoraroluiz on 7/9/17.
 */
@Getter @Setter
public class ConsortiumDTO {

    //@Size(min = 3, max = 200)
    private String name;

    private LocalDateTime start;

    private LocalDateTime end;

    private String voucher;

    private Set<MemberModel> members;

    private Set<MemberModel> adminstrators;

    public ConsortiumDTO() {
        //default for Jackson
    }
}
