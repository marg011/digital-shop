package magazin.demo.service;

import magazin.demo.dto.HardDiskDTO;
import magazin.demo.exception.harddisks.HardDiskAlreadyExistsException;
import magazin.demo.exception.harddisks.HardDiskNotFoundException;

import java.util.List;

public interface HardDiskService {

    HardDiskDTO createHardDisk(HardDiskDTO hardDiskDTO) throws HardDiskAlreadyExistsException;

    HardDiskDTO readHardDiskById(long id) throws HardDiskNotFoundException;

    List<HardDiskDTO> findAllHardDisks();

    HardDiskDTO updateHardDisk(long id, HardDiskDTO updatedHardDiskDTO) throws HardDiskNotFoundException;

    void deleteHardDisk(long id) throws HardDiskNotFoundException;
}
