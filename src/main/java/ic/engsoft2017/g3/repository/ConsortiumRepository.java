package ic.engsoft2017.g3.repository;

import ic.engsoft2017.g3.model.ConsortiumModel;
import ic.engsoft2017.g3.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by pegoraroluiz on 7/9/17.
 */
public interface ConsortiumRepository extends JpaRepository<ConsortiumModel, Long> {

    Optional<ConsortiumModel> findOneByName(String name);

    List<ConsortiumModel> findAllByStartAfterAndEndBefore(LocalDateTime before, LocalDateTime after);

    List<ConsortiumModel> findAllByAdminstrator(MemberModel admin);

}
