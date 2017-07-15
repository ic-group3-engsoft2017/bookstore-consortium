package ic.engsoft2017.g3.usecase.crud;

import ic.engsoft2017.g3.model.ConsortiumModel;
import ic.engsoft2017.g3.web.rest.dto.ConsortiumDTO;

public interface CreateNewConsortiumUseCase {
    ConsortiumModel save(ConsortiumDTO consortiumDTO);
}
