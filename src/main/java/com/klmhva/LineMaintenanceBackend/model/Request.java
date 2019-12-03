package com.klmhva.LineMaintenanceBackend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public interface Request {

    public String getId();
    public Date getDateRequested();
    public String getMechanicId();
    public Status getStatus();

}
