package magazin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopsDTO {
    private int count;
    private List<LaptopDTO> results;

    public LaptopsDTO(List<LaptopDTO> results) {
        this.results = results;
        this.count = results.size();
    }
}
