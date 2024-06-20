package net.vuphan.backend.datamodel.entity;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
    private boolean status;
    private String creUid;
    private String modUid;
    private Date creTs;
    private String modTs;
}
