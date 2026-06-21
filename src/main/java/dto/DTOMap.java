package dto;

import java.util.Map;
import java.util.Objects;

public class DTOMap {

    private final Map<String, String> map;

    public DTOMap(Map map) {
        this.map = map;
    }

    public String get(String key) {
        String value = map.get(key);
        return Objects.requireNonNullElse(value, "");
    }
}
