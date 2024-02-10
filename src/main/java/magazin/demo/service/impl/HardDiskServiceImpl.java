package magazin.demo.service.impl;

import magazin.demo.dto.HardDiskDTO;
import magazin.demo.entity.HardDiskEntity;
import magazin.demo.exception.harddisks.HardDiskAlreadyExistsException;
import magazin.demo.exception.harddisks.HardDiskNotFoundException;
import magazin.demo.mapper.HardDisksMapper;
import magazin.demo.repository.HardDiskRepository;
import magazin.demo.service.HardDiskService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardDiskServiceImpl implements HardDiskService {

    private final HardDiskRepository hardDiskRepository;
    private final HardDisksMapper hardDisksMapper;

    public HardDiskServiceImpl(HardDiskRepository hardDiskRepository, HardDisksMapper hardDisksMapper) {
        this.hardDiskRepository = hardDiskRepository;
        this.hardDisksMapper = hardDisksMapper;
    }

    @Override
    public HardDiskDTO createHardDisk(HardDiskDTO hardDiskDTO) throws HardDiskAlreadyExistsException {
        try {

            if (hardDiskDTO.getId() != 0 && hardDiskRepository.existsById(hardDiskDTO.getId())) {
                throw new HardDiskAlreadyExistsException("Жесткий диск с таким ID уже существует");
            }

            HardDiskEntity hardDiskEntity = hardDisksMapper.dtoToEntity(hardDiskDTO);
            HardDiskEntity savedEntity = hardDiskRepository.save(hardDiskEntity);
            return hardDisksMapper.entityToDto(savedEntity);
        } catch (DataIntegrityViolationException e) {
            throw new HardDiskAlreadyExistsException("Жесткий диск с таким ID уже существует");
        }
    }

    @Override
    public HardDiskDTO readHardDiskById(long id) throws HardDiskNotFoundException {
        HardDiskEntity hardDiskEntity = hardDiskRepository.findById(id)
                .orElseThrow(() -> new HardDiskNotFoundException("Жесткий диск с id " + id + " не найден"));

        return hardDisksMapper.entityToDto(hardDiskEntity);
    }


    @Override
    public List<HardDiskDTO> findAllHardDisks() {
        List<HardDiskEntity> hardDiskEntities = hardDiskRepository.findAll();

        List<HardDiskDTO> hardDiskDTOs = hardDiskEntities.stream()
                .map(hardDisksMapper::entityToDto)
                .collect(Collectors.toList());

        return hardDiskDTOs;
    }

    @Override
    public HardDiskDTO updateHardDisk(long id, HardDiskDTO updatedHardDiskDTO) throws HardDiskNotFoundException {
        Optional<HardDiskEntity> optionalHardDisk = hardDiskRepository.findById(id);

        if (optionalHardDisk.isPresent()) {
            HardDiskEntity existingHardDisk = optionalHardDisk.get();



            HardDiskEntity updatedHardDiskEntity = hardDiskRepository.save(existingHardDisk);

            return hardDisksMapper.entityToDto(updatedHardDiskEntity);
        } else {
            throw new HardDiskNotFoundException("Жесткий диск с id " + id + " не найден");
        }
    }

    @Override
    public void deleteHardDisk(long id) throws HardDiskNotFoundException {
        Optional<HardDiskEntity> optionalHardDisk = hardDiskRepository.findById(id);

        if (optionalHardDisk.isPresent()) {
            hardDiskRepository.delete(optionalHardDisk.get());
        } else {
            throw new HardDiskNotFoundException("Жесткий диск с id " + id + " не найден");
        }
    }
}