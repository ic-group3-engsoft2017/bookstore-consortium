package ic.engsoft2017.g3.model.builder;

import ic.engsoft2017.g3.model.ConsortiumModel;
import ic.engsoft2017.g3.model.MemberModel;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pegoraroluiz on 7/15/17.
 */
public final class ConsortiumModelBuilder {
    private Long pk;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private String voucher;
    private Set<MemberModel> members;
    private Set<MemberModel> adminstrators;

    private ConsortiumModelBuilder() {
    }

    public static ConsortiumModelBuilder aConsortiumModel() {
        return new ConsortiumModelBuilder();
    }

    public ConsortiumModelBuilder withPk(Long pk) {
        this.pk = pk;
        return this;
    }

    public ConsortiumModelBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ConsortiumModelBuilder withStart(LocalDateTime start) {
        this.start = start;
        return this;
    }

    public ConsortiumModelBuilder withEnd(LocalDateTime end) {
        this.end = end;
        return this;
    }

    public ConsortiumModelBuilder withVoucher(String voucher) {
        this.voucher = voucher;
        return this;
    }

    public ConsortiumModelBuilder withMembers(Set<MemberModel> members) {
        this.members = members;
        return this;
    }

    public ConsortiumModelBuilder withAdminstrators(Set<MemberModel> adminstrators) {
        this.adminstrators = adminstrators;
        return this;
    }

    public ConsortiumModelBuilder but() {
        return aConsortiumModel().withPk(pk).withName(name).withStart(start).withEnd(end).withVoucher(voucher).withMembers(members).withAdminstrators(adminstrators);
    }

    public ConsortiumModel build() {
        ConsortiumModel consortiumModel = new ConsortiumModel();
        consortiumModel.setPk(pk);
        consortiumModel.setName(name);
        consortiumModel.setStart(start);
        consortiumModel.setEnd(end);
        consortiumModel.setVoucher(voucher);
        consortiumModel.setMembers(members);
        consortiumModel.setAdminstrators(adminstrators);
        return consortiumModel;
    }
}
