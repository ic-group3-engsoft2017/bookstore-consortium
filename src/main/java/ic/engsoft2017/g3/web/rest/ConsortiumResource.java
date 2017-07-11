package ic.engsoft2017.g3.web.rest;

import ic.engsoft2017.g3.model.ConsortiumModel;
import ic.engsoft2017.g3.repository.ConsortiumRepository;
import ic.engsoft2017.g3.security.AuthoritiesConstants;
import ic.engsoft2017.g3.usecase.crud.CreateNewConsortiumUseCase;
import ic.engsoft2017.g3.web.rest.dto.ConsortiumDTO;
import ic.engsoft2017.g3.web.rest.util.HeaderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pegoraroluiz on 7/9/17.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ConsortiumResource {

    private static final String ENTITY_NAME = "consortium";

    private ConsortiumRepository consortiumRepository;

    private CreateNewConsortiumUseCase createNewConsortium;

    public ConsortiumResource(ConsortiumRepository consortiumRepository, CreateNewConsortiumUseCase createNewConsortium) {
        this.consortiumRepository = consortiumRepository;
        this.createNewConsortium = createNewConsortium;
    }

    @PostMapping("/consortium")
    @Secured(AuthoritiesConstants.USER)
    public ResponseEntity createConsortium(@RequestBody ConsortiumDTO consortiumDTO) {
        if(consortiumRepository.findOneByName(consortiumDTO.getName()).isPresent()){
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new consortiu cannot already have an name"))
                    .body(null);
        }
        ConsortiumModel model = createNewConsortium.save(consortiumDTO);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createAlert("consortium.created", consortiumDTO.getName()))
                .body(model);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ConsortiumModel>> getAllUsers() {
        final List<ConsortiumModel> consortiumModels = consortiumRepository.findAll();
        return new ResponseEntity<>
                (consortiumModels, HeaderUtil.createAlert("listofconsortiums", String.valueOf(consortiumModels.size()))
                        , HttpStatus.OK);
    }
}
