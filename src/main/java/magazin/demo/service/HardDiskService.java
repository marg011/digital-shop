package magazin.demo.service;

import magazin.demo.dto.HardDisksDTO;
import magazin.demo.exception.harddisks.HardDiskAlreadyExistsException;
import magazin.demo.exception.harddisks.HardDiskNotFoundException;

import java.util.List;

public interface HardDiskService {

    HardDisksDTO createHardDisk(HardDisksDTO hardDiskDTO) throws HardDiskAlreadyExistsException;

    HardDisksDTO readHardDiskById(int id) throws HardDiskNotFoundException;

    List<HardDisksDTO> findAllHardDisks();

    HardDisksDTO updateHardDisk(int id, HardDisksDTO updatedHardDiskDTO) throws HardDiskNotFoundException;

    void deleteHardDisk(int id) throws HardDiskNotFoundException;
}
