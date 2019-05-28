package com.vnext.projekt.common.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode
public class CustomTimestamp {

    OffsetDateTime odt;

    private static final String UTC_DATETIME_PATTERN = "uuuu-MM-dd'T'HH:mm:ss'Z'";
    private static final DateTimeFormatter UTC_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(UTC_DATETIME_PATTERN);

    public static CustomTimestamp of(@NonNull String _odt) throws DateTimeException {
        if (_odt.isEmpty()) return null;
        return new CustomTimestamp(OffsetDateTime.parse(_odt).withOffsetSameInstant(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS));
    }

    public static CustomTimestamp of(@NonNull Timestamp _timestamp) {
        return new CustomTimestamp(OffsetDateTime.ofInstant(Instant.ofEpochMilli(_timestamp.getTime()), ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS));
    }

    public static CustomTimestamp now() {
        return new CustomTimestamp(OffsetDateTime.now());
    }

    public OffsetDateTime toOffsetDateTime() {
        return this.odt.withOffsetSameInstant(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS);
    }

    public Timestamp toTimestamp() {
        return Timestamp.from(this.odt.withOffsetSameInstant(ZoneOffset.UTC).truncatedTo(ChronoUnit.SECONDS).toInstant());
    }

    @Override
    public String toString() {
        return UTC_DATETIME_FORMATTER.format(this.odt);
    }

}
