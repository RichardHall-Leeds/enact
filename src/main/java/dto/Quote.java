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

    private String purchasePriceQuote;
    private String tenure;
    private String totalConveyancingFees;
    private String totalFeeAndSearchPack;
    private String estimatedTotal;


    public static Quote decode(DTOMap row) {
        return new Quote(
                row.get("purchasePriceQuote"),
                row.get("tenure"),
                row.get("totalConveyancingFee"),
                row.get("totalFeeAndSearchPack"),
                row.get("estimatedTotal"));
    }
}
