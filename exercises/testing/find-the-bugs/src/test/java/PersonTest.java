import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

final class PersonTest {
    @Test
    void exampleTest() {
        assertThat(1 + 1, is(2));
    }

    @Test
    void personne17IsMinor() {
        assertThat(new Person("George", "Candella", 17).isMinor(), is(true));
    }

    @Test
    void differentLastNamesButSameFirstNamesAndAgesAreNotConfused() {
        AddressBook book = new AddressBook();
        book.setAddress(new Person("Alan", "Turing", 99), "Secret Enigma-cracking lab");
        book.setAddress(new Person("Alan", "Rickman", 99), "Potions-brewing room");

        assertThat(book.toString(),
                both(containsString("Alan Turing: Secret Enigma-cracking lab"))
                        .and(containsString("Alan Rickman: Potions-brewing room"))
        );
    }
}
