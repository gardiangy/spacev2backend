package hu.voga.space.util;

import hu.voga.space.enums.NotificationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
@Builder
public class Notification {

    private NotificationType notificationType;
    private Map<String, String> data;

}
