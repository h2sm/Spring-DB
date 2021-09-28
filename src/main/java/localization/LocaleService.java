package localization;

import lombok.Getter;
import lombok.Setter;
//import org.springframework.stereotype.Service;
//@Service
import java.util.Locale;

public class LocaleService {
    @Getter @Setter
    private Locale current = Locale.forLanguageTag("ru");
}
