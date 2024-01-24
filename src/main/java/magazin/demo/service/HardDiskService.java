package magazin.demo.service;

import magazin.demo.dto.HardDisksDTO;

import java.util.List;

public interface HardDiskService {

    HardDisksDTO createHardDisk(HardDisksDTO hardDiskDTO);

    HardDisksDTO readHardDiskById(Long id);

    List<HardDisksDTO> findAllHardDisks();

    HardDisksDTO updateHardDisk(Long id, HardDisksDTO updatedHardDiskDTO);

    void deleteHardDisk(Long id);
}
