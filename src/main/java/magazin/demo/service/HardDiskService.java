package magazin.demo.service;

import magazin.demo.dto.HardDisksDTO;
import magazin.demo.exception.harddisks.HardDiskAlreadyExistsException;
import magazin.demo.exception.harddisks.HardDiskNotFoundException;

import java.util.List;

public interface HardDiskService {

    HardDisksDTO createHardDisk(HardDisksDTO hardDiskDTO) throws HardDiskAlreadyExistsException;

    HardDisksDTO readHardDiskById(long id) throws HardDiskNotFoundException;

    List<HardDisksDTO> findAllHardDisks();

    HardDisksDTO updateHardDisk(long id, HardDisksDTO updatedHardDiskDTO) throws HardDiskNotFoundException;

    void deleteHardDisk(long id) throws HardDiskNotFoundException;
}
