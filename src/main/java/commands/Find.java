package commands;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Find extends Command {
    private final String param;

    public Find(String param) {
        this.param = param;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass();
    }

}
