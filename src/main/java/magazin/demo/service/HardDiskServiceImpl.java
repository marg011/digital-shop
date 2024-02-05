package magazin.demo.service;

import magazin.demo.dto.HardDisksDTO;
import magazin.demo.entity.HardDiskEntity;
import magazin.demo.exception.harddisks.HardDiskAlreadyExistsException;
import magazin.demo.exception.harddisks.HardDiskNotFoundException;
import magazin.demo.mapper.HardDisksMapper;
import magazin.demo.repository.HardDiskRepository;
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
    public HardDisksDTO createHardDisk(HardDisksDTO hardDiskDTO) throws HardDiskAlreadyExistsException {
        try {
            HardDiskEntity hardDiskEntity = hardDisksMapper.dtoToEntity(hardDiskDTO);
            HardDiskEntity savedEntity = hardDiskRepository.save(hardDiskEntity);
            return hardDisksMapper.entityToDto(savedEntity);
        } catch (DataIntegrityViolationException e) {
            throw new HardDiskAlreadyExistsException("Жесткий диск с таким серийным номером уже существует");
        }
    }

    @Override
    public HardDisksDTO readHardDiskById(int id) throws HardDiskNotFoundException {
        Optional<HardDiskEntity> hardDiskEntityOptional = hardDiskRepository.findById(id);

        if (hardDiskEntityOptional.isPresent()) {
            HardDiskEntity hardDiskEntity = hardDiskEntityOptional.get();
            return hardDisksMapper.entityToDto(hardDiskEntity);
        } else {
            throw new HardDiskNotFoundException("Жесткий диск с id " + id + " не найден");
        }
    }

    @Override
    public List<HardDisksDTO> findAllHardDisks() {
        List<HardDiskEntity> hardDiskEntities = hardDiskRepository.findAll();

        List<HardDisksDTO> hardDiskDTOs = hardDiskEntities.stream()
                .map(hardDisksMapper::entityToDto)
                .collect(Collectors.toList());

        return hardDiskDTOs;
    }

    @Override
    public HardDisksDTO updateHardDisk(int id, HardDisksDTO updatedHardDiskDTO) throws HardDiskNotFoundException {
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
    public void deleteHardDisk(int id) throws HardDiskNotFoundException {
        Optional<HardDiskEntity> optionalHardDisk = hardDiskRepository.findById(id);

        if (optionalHardDisk.isPresent()) {
            hardDiskRepository.delete(optionalHardDisk.get());
        } else {
            throw new HardDiskNotFoundException("Жесткий диск с id " + id + " не найден");
        }
    }
}