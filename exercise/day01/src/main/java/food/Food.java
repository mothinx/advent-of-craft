package food;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public record Food(LocalDate expirationDate,
                   Boolean approvedForConsumption,
                   UUID inspectorId) {
    public boolean isEdible(Supplier<LocalDate> now) {
        return isUpToDate(now) &&
                canBeConsumned() &&
                hasBeenInspected();
    }

    private boolean isUpToDate(Supplier<LocalDate> now) {
        return this.expirationDate.isAfter(now.get());
    }

    private Boolean canBeConsumned() {
        return this.approvedForConsumption;
    }

    private boolean hasBeenInspected() {
        return this.inspectorId != null;
    }
}