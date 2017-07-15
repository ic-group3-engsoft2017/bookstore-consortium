package ic.engsoft2017.g3.usecase.crud.impl;

import ic.engsoft2017.g3.model.ConsortiumModel;
import ic.engsoft2017.g3.model.builder.ConsortiumModelBuilder;
import ic.engsoft2017.g3.repository.ConsortiumRepository;
import ic.engsoft2017.g3.usecase.crud.CreateNewConsortiumUseCase;
import ic.engsoft2017.g3.web.rest.dto.ConsortiumDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by pegoraroluiz on 7/15/17.
 */
@Service
public class CrudConsortiumServiceImpl implements CreateNewConsortiumUseCase {

    private ConsortiumRepository consortiumRepository;

    public CrudConsortiumServiceImpl(ConsortiumRepository consortiumRepository) {
        this.consortiumRepository = consortiumRepository;
    }

    @Override
    public ConsortiumModel save(ConsortiumDTO consortiumDTO) {
        Optional<ConsortiumModel> savedModel = consortiumRepository.findOneByName(consortiumDTO.getName());
        return savedModel.orElse(consortiumRepository.save(fromDTO(consortiumDTO)));
    }

    private ConsortiumModel fromDTO(ConsortiumDTO dto) {
        return ConsortiumModelBuilder.aConsortiumModel()
                .withName(dto.getName())
                .withStart(dto.getStart())
                .withEnd(dto.getEnd())
                .withVoucher(dto.getVoucher())
                .withMembers(dto.getMembers())
                .withAdminstrators(dto.getAdminstrators())
                .build();
    }
}
