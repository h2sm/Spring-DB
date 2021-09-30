package localization;

import console.UI;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@RequiredArgsConstructor
public class LocaleService {
    private final UI ui;
    @Getter
    private Locale current = Locale.forLanguageTag("ru");
    public void askLocale() {
        var localeStr = ui.read();
        current = Locale.forLanguageTag(localeStr);
    }
}
