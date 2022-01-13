package guru.springframework.msscbrewery.web.mapper;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
public class DateMapper {
    public OffsetDateTime asOffsetDateTime(Timestamp timestamp) {
        OffsetDateTime offsetDateTime = null;
        if(timestamp != null)
            offsetDateTime = OffsetDateTime.of(timestamp.toLocalDateTime().getYear(),
                    timestamp.toLocalDateTime().getMonthValue(),
                    timestamp.toLocalDateTime().getDayOfMonth(),
                    timestamp.toLocalDateTime().getHour(),
                    timestamp.toLocalDateTime().getMinute(),
                    timestamp.toLocalDateTime().getSecond(),
                    timestamp.toLocalDateTime().getNano(),
                    ZoneOffset.UTC);
        return offsetDateTime;
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime) {
        Timestamp timestamp = null;
        if(offsetDateTime != null)
            timestamp = Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        return timestamp;
    }

    public LocalDateTime asLocalDateTime(Timestamp timestamp) {
        LocalDateTime localDateTime = null;
        if(timestamp != null)
            localDateTime = LocalDateTime.of(timestamp.toLocalDateTime().getYear(),
                    timestamp.toLocalDateTime().getMonthValue(),
                    timestamp.toLocalDateTime().getDayOfMonth(),
                    timestamp.toLocalDateTime().getHour(),
                    timestamp.toLocalDateTime().getMinute(),
                    timestamp.toLocalDateTime().getSecond(),
                    timestamp.toLocalDateTime().getNano());
        return localDateTime;
    }

    public Timestamp asTimestamp(LocalDateTime localDateTime) {
        Timestamp timestamp = null;
        if(localDateTime != null)
            timestamp = Timestamp.valueOf(localDateTime);
        return timestamp;
    }

}
