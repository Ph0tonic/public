import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class AppTest {
    @Test
    void addTicket() {
        assertThat(new Shop("Bianca's shop").addTicket(new Ticket), is(2));
    }
}
