package dto;

//import dto.DTOMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Home {

    private String purchasePrice;
    private String purchaseStage;
    private String firstTimeBuyer;
    private String name;
    private String email;
    private String phone;
    private String postcode;
    private String consent;

    public static Home decode(DTOMap row) {
        return new Home(
                row.get("purchasePrice"),
                row.get("purchaseStage"),
                row.get("firstTimeBuyer"),
                row.get("name"),
                row.get("email"),
                row.get("phone"),
                row.get("postcode"),
                row.get("consent"));
    }
}
