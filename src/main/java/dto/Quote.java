package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quote {

    private String purchasePrice;
    private String tenure;
    private String totalConveyancingFee;
    private String totalFeeAndSearchPack;
    private String estimatedTotal;


    public static Quote decode(DTOMap row) {
        return new Quote(
                row.get("purchasePrice"),
                row.get("tenure"),
                row.get("totalConveyancingFee"),
                row.get("totalFeeAndSearchPack"),
                row.get("estimatedTotal"));
    }
}
