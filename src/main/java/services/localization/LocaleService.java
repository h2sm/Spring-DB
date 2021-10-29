package services.localization;

import logging.Loggable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public class LocaleService {
    @Getter
    private Locale current = Locale.forLanguageTag("ru");
    @Loggable
    public void setLocale(String loc) {
        current = Locale.forLanguageTag(loc);
    }
}
