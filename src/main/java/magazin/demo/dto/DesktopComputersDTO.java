package magazin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputersDTO {
    private int count;
    private List<DesktopComputerDTO> results;

    public DesktopComputersDTO(List<DesktopComputerDTO> results) {
        this.results = results;
        this.count = results.size();
    }
}
