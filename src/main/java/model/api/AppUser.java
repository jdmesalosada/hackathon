package model.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUser {

    private String credentials;
}
