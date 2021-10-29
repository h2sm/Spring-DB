package services.localization;

import logging.Loggable;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageService {
    private static final Object[] EMPTY_ARGS = new Object[0];

    private final MessageSource messageSource;
    private final LocaleService localeService;

    public String localize(String code) {
        return messageSource.getMessage(code, EMPTY_ARGS, localeService.getCurrent());
    }
    @Loggable
    public String localize(String code, Object... params) {
        return messageSource.getMessage(code, params, localeService.getCurrent());
    }
    @Loggable
    public void askForLocale(String loc) {
        localeService.setLocale(loc);
    }
}
